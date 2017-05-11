package br.com.remembr.bemDaora.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.remembr.bemDaora.business.SingleSignOnBusiness;
import br.com.remembr.bemDaora.dao.TokenResetSenhaDAO;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.sso.UsuarioLogado;

@Controller
public class LoginController {

	@Inject
	private SingleSignOnBusiness sso;
	
	@Inject
	private TokenResetSenhaDAO tokenResetSenhaDAO;
	
	@Inject
	@UsuarioLogado
	private Usuario usuarioLogado;
	
	
}