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
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Instituicao;

@Controller
public class InstituicaoController {

	@Inject
	private InstituicaoDAO instituicaoDAO;
	
	@Inject
	private Result result;
	
	@Path("/adm/listaInstituicao")
	public void listaInstituicoes() throws DAOException{
		List<Instituicao> instituicoes = instituicaoDAO.list();
		result.include("instituicoes", instituicoes);
	}
	
	@Path("/adm/cadastraInstituicao")
	public void cadastraInstituicao(){
		
	}
	
	@Transactional
	@Post("/adm/salvaInstituicao")
	public void salvarInstituicao(Instituicao instituicao, UploadedFile avatar) throws Exception{
		if(instituicao.getId() == null){
			instituicao.setSenha("123456");
			instituicao.setResetarSenha(true);
			instituicao.setDataCadastro(new Date());
		}
		if(avatar != null){
			instituicao.setAvatar(IOUtils.toByteArray(avatar.getFile()));
		}
		
		instituicaoDAO.insert(instituicao);
		result.redirectTo(this).listaInstituicoes();
	}
}