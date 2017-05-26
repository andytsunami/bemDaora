package br.com.remembr.bemDaora.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.remembr.bemDaora.dao.InstituicaoDAO;
import br.com.remembr.bemDaora.dao.VoluntarioDAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Instituicao;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.model.Voluntario;
import br.com.remembr.bemDaora.service.sso.UsuarioLogado;

@Controller
public class VoluntarioController {
	
	@Inject
	private Result result;
	
	@Inject
	private VoluntarioDAO voluntarioDAO;
	
	@Inject
	private InstituicaoDAO instituicaoDAO;
	
	@Inject
	@UsuarioLogado
	private Usuario usuarioLogado;
	
	
	@Path("/voluntario/home/{idVoluntario}")
	public void voluntarioHome(Long idVoluntario) throws DAOException{
		
		Voluntario voluntario = voluntarioDAO.find(idVoluntario);
		if(voluntario.isCadastroCompleto()){
			List<Instituicao> instituicoes = instituicaoDAO.lista();
			result.include("instituicoes",instituicoes);
			
		} else {
			result.redirectTo(this).continuaCadastro(voluntario);
		}
		
		
		
		result.include("usuarioLogado", usuarioLogado);
		
		
	}

	@Path("/voluntario/cadastro")
	public void continuaCadastro(Voluntario voluntario) {
		result.include("voluntario",voluntario);
		
	}
}
