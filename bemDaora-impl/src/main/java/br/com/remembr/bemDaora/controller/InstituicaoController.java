package br.com.remembr.bemDaora.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.remembr.bemDaora.dao.InstituicaoDAO;
import br.com.remembr.bemDaora.dao.RamoAtividadeDAO;
import br.com.remembr.bemDaora.dao.VagaDAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Instituicao;
import br.com.remembr.bemDaora.model.RamoAtividade;
import br.com.remembr.bemDaora.model.Vaga;

@Controller
public class InstituicaoController {

	@Inject
	private InstituicaoDAO instituicaoDAO;
	
	@Inject
	private Result result;
	
	@Inject
	private VagaDAO vagaDAO;
	
	@Inject
	private RamoAtividadeDAO ramoAtividadeDAO;
	
	@Path("/adm/listaInstituicao")
	public void listaInstituicoes() throws DAOException{
		List<Instituicao> instituicoes = instituicaoDAO.lista();
		result.include("instituicoes", instituicoes);
	}
	
	@Path("/adm/cadastraInstituicao")
	public void cadastraInstituicao(){
		
	}
	
	@Transactional
	@Path("/adm/editarInstituicao/{idInstituicao}/adm")
	public void editarInstituicao(Long idInstituicao) throws DAOException{
		Instituicao instituicao = instituicaoDAO.buscar(idInstituicao);
		result.include("instituicao",instituicao);
		result.redirectTo(this).cadastraInstituicao();
	}
	
	@Transactional
	@Post("/adm/salvaInstituicao")
	public void salvarInstituicao(Instituicao instituicao, UploadedFile avatar) throws Exception{
		if(avatar != null){
			instituicao.setAvatar(IOUtils.toByteArray(avatar.getFile()));
		}
		
		if(instituicao.getId() == null) {
			instituicao.setSenha("123456");
			instituicao.setResetarSenha(true);
			instituicao.setDataCadastro(new Date());
			instituicaoDAO.insert(instituicao);
		} else {
			
			Instituicao instituicaoBD = instituicaoDAO.find(instituicao.getId());
			instituicaoBD.setRazaoSocial(instituicao.getRazaoSocial());
			instituicaoBD.setNome(instituicao.getNome());
			instituicaoBD.setEmail(instituicao.getEmail());
			instituicaoBD.setCnpj(instituicao.getCnpj());
			instituicaoBD.setSobre(instituicao.getSobre());
			instituicaoBD.setEndereco(instituicao.getEndereco());
			instituicaoBD.setAvatar(instituicao.getAvatar());
			
			instituicaoDAO.update(instituicaoBD);
		}
		
		result.redirectTo(this).listaInstituicoes();
	}
	
	@Transactional
	@Post("/adm/excluiInstituicao")
	public void excluiInstituicao(Long idInstituicao) throws DAOException{
		instituicaoDAO.exclusaoLogica(idInstituicao);
		result.nothing();
	}
	
	@Transactional
	@Post("/publicaVaga/adm")
	public void publicaVaga(Vaga vaga) throws DAOException{
		
		Long idInstituicao = vaga.getInstituicao().getId();
		Instituicao instituicao = instituicaoDAO.find(idInstituicao);
		vaga.setInstituicao(instituicao);
		
		if(vaga.getId() == null){
			vagaDAO.insert(vaga);
		} else {
			vagaDAO.update(vaga);
		}
		result.redirectTo(this).editarInstituicao(idInstituicao);
	}
	
	@Path("/cadastraVaga/{idInstituicao}/adm")
	public void cadastraVaga(Long idInstituicao) throws DAOException{
		Instituicao instituicao = instituicaoDAO.find(idInstituicao);
		List<RamoAtividade> ramos = ramoAtividadeDAO.lista();
		
		result.include("instituicao",instituicao);
		result.include("ramos",ramos);
	}
}