package br.com.remembr.bemDaora.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import com.google.common.base.Strings;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.remembr.bemDaora.business.SingleSignOnBusiness;
import br.com.remembr.bemDaora.dao.TokenResetSenhaDAO;
import br.com.remembr.bemDaora.dao.UsuarioDAO;
import br.com.remembr.bemDaora.exception.SingleSignOnException;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.sso.Login;
import br.com.remembr.bemDaora.service.sso.UsuarioLogado;
import br.com.remembr.bemDaora.service.sso.UsuarioTicket;

@Controller
public class LoginController {

	@Inject
	private SingleSignOnBusiness sso;
	
	@Inject
	private TokenResetSenhaDAO tokenResetSenhaDAO;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject
	private Result result;
	
	@Inject
	private UsuarioTicket usuarioTicket;
	
	@Inject
	@UsuarioLogado
	private Usuario usuarioLogado;
	
	@Inject
	private HttpServletRequest request;
	
	@Path("/login")
	@Transactional
	public void login(Login login){
		
		if(Strings.isNullOrEmpty(login.getEmail())){
			throw new SingleSignOnException("Campo E-mail vazio");
		}
		
		if(usuarioTicket.getTicket() != null && !login.getEmail().equals(usuarioLogado.getEmail())){
			logout();
			return;
		}
	
	}
	
	@Path("/logout")
	@Transactional
	public void logout(){
		try {
			if(usuarioTicket.getTicket() != null){
				sso.logout(usuarioLogado.getEmail());
				//TODO SERVIDOR WEBSOCKET
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}