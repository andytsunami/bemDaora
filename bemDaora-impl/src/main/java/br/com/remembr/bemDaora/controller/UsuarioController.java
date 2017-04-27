package br.com.remembr.bemDaora.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.remembr.bemDaora.dao.UsuarioDAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Usuario;

@Controller
public class UsuarioController {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Path("/usuario/teste")
	@Transactional
	public void teste() throws DAOException{
		Usuario usuario = new Usuario();
		usuario.setNome("Teste2");
		usuarioDAO.insert(usuario);
	}

}