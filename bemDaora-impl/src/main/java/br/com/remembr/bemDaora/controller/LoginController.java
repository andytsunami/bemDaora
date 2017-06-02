package br.com.remembr.bemDaora.controller;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import com.google.common.base.Strings;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.remembr.bemDaora.business.SingleSignOnBusiness;
import br.com.remembr.bemDaora.dao.TokenResetSenhaDAO;
import br.com.remembr.bemDaora.dao.UsuarioDAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.exception.SingleSignOnException;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.sso.Login;
import br.com.remembr.bemDaora.service.sso.UsuarioLogado;
import br.com.remembr.bemDaora.service.sso.UsuarioTicket;
import br.com.remembr.bemDaora.vo.LoginVO;

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
	public void login(Login login) throws DAOException{
		try{
			
		
		if(Strings.isNullOrEmpty(login.getEmail())){
			throw new SingleSignOnException("Campo E-mail vazio");
		}
		
		if(usuarioTicket.getTicket() != null && !login.getEmail().toUpperCase().equals(usuarioLogado.getEmail().toUpperCase())){
			logout();
			return;
		}
		
		login.setIp(request.getRemoteAddr());
		LoginVO acesso = sso.login(login);
		usuarioTicket.setTicket(acesso.getTicket());
		result.include("ticket", acesso.getTicket());
		
		result.redirectTo(VoluntarioController.class).voluntarioHome(acesso.getIdUsuario());
		
		} catch (NoResultException | SingleSignOnException e) {
			result.include("nt_information", "Não foi possível acessar com os dados preenchidos");
			result.redirectTo(IndexController.class).index();
		}	


	}
	
	@Path("/logout")
	@Transactional
	public void logout(){
		try {
			if(usuarioTicket.getTicket() != null){
				try{
					sso.logout(usuarioLogado.getEmail());
					
				} catch (Exception e) {
					throw new Exception(e);
				}
				//TODO SERVIDOR WEBSOCKET
			}
			request.getSession(false).invalidate();
			result.redirectTo(IndexController.class).index();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}