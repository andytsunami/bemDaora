package br.com.remembr.bemDaora.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.remembr.bemDaora.dao.InstituicaoDAO;
import br.com.remembr.bemDaora.dao.RamoAtividadeDAO;
import br.com.remembr.bemDaora.dao.VoluntarioDAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Instituicao;
import br.com.remembr.bemDaora.model.RamoAtividade;
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
	
	@Inject
	private RamoAtividadeDAO profissaoDAO;
	
	
	@Path("/voluntario/home/{idVoluntario}")
	public void voluntarioHome(Long idVoluntario) throws DAOException{
		
		Voluntario voluntario = voluntarioDAO.find(idVoluntario);
		result.include("usuarioLogado", usuarioLogado);
		
		if(voluntario.isSegundoCadastroCompleto() && voluntario.isUltimoCadastroCompleto()){
			List<Instituicao> instituicoes = instituicaoDAO.lista();
			result.include("instituicoes",instituicoes);
			
		} else if(!voluntario.isSegundoCadastroCompleto()){
			result.redirectTo(this).segundoCadastro(voluntario);
		} else if (!voluntario.isUltimoCadastroCompleto()) {
			result.redirectTo(this).terceiroCadastro(voluntario);
		}
		
		
		
		
		
	}
	
	@Path("/voluntario/voltaSegundoCadastro/{idVoluntario}")
	public void voltaSegundoCadastro(Long idVoluntario) throws DAOException{
		Voluntario voluntario = voluntarioDAO.find(idVoluntario);
		result.redirectTo(this).segundoCadastro(voluntario);
	}

	@Path("/voluntario/segundoCadastro")
	public void segundoCadastro(Voluntario voluntario) {
		result.include("voluntario",voluntario);
		List<RamoAtividade> profissoes = profissaoDAO.lista();
		result.include("profissoes",profissoes);
		
	}
	
	@Transactional
	@Post("/voluntario/salvaSegundo")
	public void salvaSegundoCadastro(Voluntario voluntario) throws DAOException{
		
		if(voluntario != null){
			
			Voluntario volBd = voluntarioDAO.find(voluntario.getId());
			volBd.setNome(voluntario.getNome());
			
			RamoAtividade ramoAtividade = profissaoDAO.find(voluntario.getProfissao().getId());
			volBd.setProfissao(ramoAtividade);
			volBd.setCpf(voluntario.getCpf());
					
			volBd.setSegundoCadastroCompleto(true);
			voluntarioDAO.update(volBd);
			result.redirectTo(this).terceiroCadastro(volBd);
		} else {
			result.redirectTo(LoginController.class).logout();
		}
		
	}

	@Path("/voluntario/terceiroCadastro")
	public void terceiroCadastro(Voluntario voluntario) {
		result.include("voluntario",voluntario);
	}
}
