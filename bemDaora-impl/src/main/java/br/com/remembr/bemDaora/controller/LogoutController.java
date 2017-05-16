package br.com.remembr.bemDaora.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.remembr.bemDaora.exception.SingleSignOnException;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.interfaces.SingleSignOnRemote;
import br.com.remembr.bemDaora.service.sso.UsuarioLogado;

@Controller
public class LogoutController {
	
	@Inject
	private SingleSignOnRemote sso;
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	@UsuarioLogado
	private Usuario usuario;
	
	@Inject
	private Result result;
	
	@Path("logoutSocket")
	@Transactional
	public void logoutSocket(){
		try {
			sso.logout(usuario.getEmail());
			request.getSession(false).invalidate();
			result.nothing();
		} catch (SingleSignOnException e) {
			throw new RuntimeException(e);
		}
	}
}