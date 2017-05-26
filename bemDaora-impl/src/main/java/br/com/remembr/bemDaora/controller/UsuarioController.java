package br.com.remembr.bemDaora.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang.WordUtils;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.remembr.bemDaora.dao.UsuarioDAO;
import br.com.remembr.bemDaora.dao.VoluntarioDAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.model.Voluntario;

@Controller
public class UsuarioController {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject
	private VoluntarioDAO voluntarioDAO;
	
	@Inject
	private Result result;
	
	@Path("/usuario/teste")
	@Transactional
	public void teste() throws DAOException{
		Usuario usuario = new Usuario();
		usuario.setNome("Teste2");
		usuario.setEmail("teste@teste");
		usuario.setSenha("1234");
		usuarioDAO.insert(usuario);
	}
	
	@Path("/usuario/cadastro")
	public void cadastroUsuario(){
		
	}
	
	@Transactional
	@Post("/usuario/salvar/adm")
	public void salvar(Voluntario usuario) throws DAOException{
		usuario.setNome(WordUtils.capitalizeFully(usuario.getNome()).trim());
		
		if(usuario.getId() == null){
			Voluntario voluntario = voluntarioDAO.insert(usuario);
			
			usuarioDAO.alterarSenha(voluntario.getId(), usuario.getSenha());
			System.out.println("Usuario incluido com sucesso");
		} else {
			usuarioDAO.update(usuario);
			System.out.println("Usuario alterado com sucesso");
		}
		
		result.redirectTo(this).listaUsuario();
	}
	
	@Get("/usuario/editar/{id}")
	@Transactional
	public void editar(Long id) throws DAOException{
		Usuario usuario = usuarioDAO.find(id);
		result.include("usuario",usuario);
	}
	
	@Path("/usuario/lista")
	public void listaUsuario() throws DAOException{
		List<Usuario> usuarios = usuarioDAO.list();
		result.include("usuarios",usuarios);
	}
}