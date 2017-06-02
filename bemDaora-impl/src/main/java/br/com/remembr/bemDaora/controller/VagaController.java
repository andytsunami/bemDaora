package br.com.remembr.bemDaora.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.joda.time.DateTime;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.remembr.bemDaora.dao.AtividadeDAO;
import br.com.remembr.bemDaora.dao.VagaDAO;
import br.com.remembr.bemDaora.dao.VoluntarioDAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Atividade;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.model.Vaga;
import br.com.remembr.bemDaora.model.Voluntario;
import br.com.remembr.bemDaora.service.sso.UsuarioLogado;

@Controller
public class VagaController {
	
	@Inject
	private Result result;
	
	@Inject
	private VagaDAO vagaDAO;
	
	@UsuarioLogado
	@Inject
	private Usuario usuario;
	
	@Inject
	private VoluntarioDAO voluntarioDAO;
	
	@Inject
	private AtividadeDAO atividadeDAO;
	
	@Path("/vaga/{idVaga}")
	public void vaga(Long idVaga) throws DAOException{
		Vaga vaga = vagaDAO.find(idVaga);
		result.include("vaga",vaga);
		result.include("usuario",usuario);
	}
	
	
	@Path("/vaga/solicita/{idVaga}/{idVoluntario}")
	public void solicitaVaga(Long idVaga, Long idVoluntario) throws DAOException{
		Vaga vaga = vagaDAO.find(idVaga);
		
		result.include("vaga",vaga);
		result.include("idVoluntario",idVoluntario);
		result.include("usuario",usuario);
		
	}
	
	@Transactional
	@Post("/vaga/agenda")
	public void realizaAgendamento(Long idVaga, Long idVoluntario, DateTime dataAgendada) throws DAOException{
		Vaga vaga = vagaDAO.find(idVaga);
		
		Atividade atividadeBd = atividadeDAO.buscaPorUsuarioVaga(idVaga,idVoluntario);
		
		if(vaga.getQuantidade() > 0 && atividadeBd != null){
			
			Atividade atividade = new Atividade();
			Voluntario voluntario = voluntarioDAO.find(idVoluntario);
			atividade.setVaga(vaga);
			atividade.setVoluntario(voluntario);
			atividade.setDataAgendada(dataAgendada.toDate());
			
			vaga.setQuantidade(vaga.getQuantidade()-1);
			
			atividade = atividadeDAO.insert(atividade);
			
			result.use(Results.json()).from(atividade).serialize();
		}
	}
}