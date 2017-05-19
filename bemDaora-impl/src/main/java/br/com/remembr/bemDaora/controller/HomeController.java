package br.com.remembr.bemDaora.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.sso.UsuarioLogado;
import br.com.remembr.bemDaora.service.sso.UsuarioTicket;

@Controller
public class HomeController {
	
	@Inject
	private Result result;
	
	@Inject
	@UsuarioLogado
	private Usuario usuario;
	
	@Inject
	private UsuarioTicket usuarioTicket;
	
	@Path("/home")
	public void home(){
				
		result.include("usuario",usuario);
	}
}