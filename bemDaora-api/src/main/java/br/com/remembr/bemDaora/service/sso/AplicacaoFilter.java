package br.com.remembr.bemDaora.service.sso;

import static javax.servlet.DispatcherType.FORWARD;
import static javax.servlet.DispatcherType.REQUEST;

import java.io.IOException;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.remembr.bemDaora.constants.AplicacaoConstants;
import br.com.remembr.bemDaora.exception.SingleSignOnException;
import br.com.remembr.bemDaora.service.interfaces.SingleSignOnRemote;




@WebFilter(filterName = "AplicacaoFilter", urlPatterns = {"/*"}, dispatcherTypes = { FORWARD, REQUEST })
public class AplicacaoFilter implements Filter {
	
	private final static int HTTP_UNAUTHORIZED = 401;
	
	@Inject
	private UsuarioTicket usuarioTicket;
	
	private static final String[] IGNORADOS = {
			".pdf",
			".ico",
			".gif",
			".jpg",
			".jpeg",
			".png",
			".css",
			".js",
			".svg",
			".ttf",
			".eot",
			".woff",
			".mp3",
			".ogg",
			"/adm",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/login",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/loginMobile",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/logout",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/manutencao",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/devaccess",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/mapa",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/index",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/usuario/cadastro",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/adm",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/adm/listaInstituicao",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/adm/cadastraInstituicao",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/adm/salvaInstituicao",
			"/" + AplicacaoConstants.CONTEXTO_APLICACAO + "/adm/excluiInstituicao",
			};
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String uri = request.getRequestURI();
		int jsessionidIndex = uri.indexOf(";jsessionid=");
		if (jsessionidIndex > 0) {
			uri = uri.substring(0, jsessionidIndex);
		}
		
		if (uri.matches(request.getContextPath() + "/_healthChecker.+")) {
			chain.doFilter(request, response);
			return;
		}
		
		for (String ignorado : IGNORADOS) {
			if (uri.toLowerCase().endsWith(ignorado.toLowerCase())) {
//System.out.println("IGNORA ============ " + ignorado);
				chain.doFilter(request, response);
				return;
			}
		}
		
		if(uri.contains("/recuperaSenha")) {
			chain.doFilter(request, response);
			return;
		}
		
		if (request.getAttribute(AplicacaoConstants.TOKEN_EXTERNO) != null) {
			chain.doFilter(request, response);
			return;
		}
						
		String requestTicket = request.getParameter(AplicacaoConstants.PARAMETRO_REQUEST_TICKET);
		String sessionTicket = usuarioTicket.getTicket();
		
		if (valido(requestTicket, sessionTicket)) {
			chain.doFilter(req, res);
		} else {
			try {
				request.getSession(false).invalidate();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			response.sendError(HTTP_UNAUTHORIZED, "Não autorizado");
		}
	}
	
	private boolean valido(String requestTicket, String sessionTicket) {
		SingleSignOnRemote sso = null;
		String ticket;
		try {
			if (requestTicket != null && sessionTicket != null) {
				sso = (SingleSignOnRemote) new InitialContext().lookup(SingleSignOnRemote.JNDI_NAME);
				if (sso.isTicketsMesmoLogin(requestTicket, sessionTicket)) {
					ticket = requestTicket;
				} else {
					ticket = null;
				}
			} else {
				// qualquer um dos dois que nao for null
				ticket = requestTicket!=null ^ sessionTicket!=null ? requestTicket!=null ? requestTicket : sessionTicket : null;
			}
			
			if (ticket == null) return false;
		
			if (sso == null) {
				sso = (SingleSignOnRemote) new InitialContext().lookup(SingleSignOnRemote.JNDI_NAME);
			}
			
			boolean ticketValido = sso.isTicketValido(ticket);
			if (ticketValido) {
				usuarioTicket.setTicket(ticket);
				return true;
			} else {
				return false;
			}
		} catch (NamingException e) {
			throw new SingleSignOnException(e);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}