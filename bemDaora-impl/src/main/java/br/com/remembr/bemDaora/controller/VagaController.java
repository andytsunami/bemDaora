package br.com.remembr.bemDaora.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.dom4j.dom.DOMNodeHelper.EmptyNodeList;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.remembr.bemDaora.business.MensagemBusiness;
import br.com.remembr.bemDaora.chat.model.Mensagem;
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
	
	@Inject
	private MensagemBusiness mensagemBusiness;
	
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
	public void realizaAgendamento(Long idVaga, Long idVoluntario, String dataAgendada, Long qtdHora) throws DAOException, ParseException{
		Vaga vaga = vagaDAO.find(idVaga);
		
		Atividade atividadeBd = atividadeDAO.buscaPorUsuarioVaga(idVaga,idVoluntario);
		
		if(vaga.getQuantidade() > 0 && atividadeBd == null){
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			Date dtAgendada = sdf.parse(dataAgendada);
			
			Atividade atividade = new Atividade();
			Voluntario voluntario = voluntarioDAO.find(idVoluntario);
			atividade.setVaga(vaga);
			atividade.setVoluntario(voluntario);
			atividade.setDataAgendada(dtAgendada);
			
			vaga.setQuantidade(vaga.getQuantidade()-1);
			
			if(qtdHora != null && qtdHora > 0){
				atividade.setQuantidadeHora(qtdHora);
			} else {
				atividade.setQuantidadeHora(1L);
			}
			
			atividade = atividadeDAO.insert(atividade);
			
			result.use(Results.json()).from(atividade).serialize();
		}
	}
	
	@Path("/vaga/instituicao/{idInstituicao}/adm")
	public void listaVagasInstituicao(Long idInstituicao) throws DAOException{
		List<Vaga> vagas = vagaDAO.listaPorInstituicao(idInstituicao);
		result.include("vagas",vagas);
	}
	
	@Path("/vaga/listaCandidatos/{idVaga}/adm")
	public void listaCandidatos(Long idVaga) throws DAOException{
		List<Atividade> atividades = vagaDAO.listaAtividades(idVaga);
		Vaga vaga = vagaDAO.find(idVaga);
		result.include("atividades",atividades);
		result.include("vaga",vaga);
	}
	
	@Transactional
	@Post("/vaga/aprova/adm")
	public void aprovaCandidato(Long idAtividade) throws DAOException{
		Atividade atividade = atividadeDAO.find(idAtividade);
		atividade.setAprovado(true);
		atividadeDAO.update(atividade);

		Mensagem mensagem = new Mensagem();
		mensagem.setMensagem("Sua solicitacao foi aceita!");
		mensagem.setEmailUsuario(atividade.getVoluntario().getEmail());
		mensagem.setVoluntario(atividade.getVoluntario());
		mensagem.setTipoMensagem("sucesso");
		mensagem.setEnderecoDoObjeto("/bemdahora/atividade/confirmacao/"+atividade.getId());
		mensagemBusiness.enviarMensagem(mensagem);
		
		result.nothing();
	}
	
	@Path("/atividade/confirmacao/{idAtividade}")
	public void confirmacao(Long idAtividade) throws DAOException{
		Atividade atividade = atividadeDAO.find(idAtividade);
		result.include("atividade",atividade);
	}
	
	@Path("/atividade/instrucao/{idAtividade}")
	public void instrucoes(Long idAtividade){
		result.include("voluntario",usuario);
		result.include("idAtividade",idAtividade);
	}
	
	@Path("/atividade/realizar/{idAtividade}")
	public void realizarAtividade(Long idAtividade) throws DAOException{
		Atividade atividade = atividadeDAO.find(idAtividade);
		atividade.setRealizado(true);
		result.redirectTo(VoluntarioController.class).voluntarioHome(usuario.getId());
	}
	
	@Path("/atividade/marcaRealizado/{idAtividade}")
	public void marcarRealizado(Long idAtividade) throws DAOException{
		Atividade atividade = atividadeDAO.find(idAtividade);
		result.include("atividade",atividade);
	}
	
	@Transactional
	@Post("/atividade/confirmaRealizado/adm")
	public void confirmaRealizado(Long idAtividade, Long qtdHoras) throws DAOException{
		Atividade atividade = atividadeDAO.find(idAtividade);
		atividade.setConfirmadoInstituicao(true);
		atividade.getVoluntario().setPontos(atividade.getVoluntario().getPontos() + qtdHoras);
		
		Mensagem mensagem = new Mensagem();
		mensagem.setMensagem("Parabens pelo serviço realizado!");
		mensagem.setEmailUsuario(atividade.getVoluntario().getEmail());
		mensagem.setVoluntario(atividade.getVoluntario());
		mensagem.setTipoMensagem("badge");
		mensagem.setEnderecoDoObjeto("/bemdahora/atividade/confirmacao/"+atividade.getId());
		mensagemBusiness.enviarMensagem(mensagem);
		
		result.nothing();
		
	}
	
}