package br.com.remembr.bemDaora.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.remembr.bemDaora.dao.InstituicaoDAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Instituicao;

@Controller
public class IndexController {
	
	@Inject
	private Result result;
	
	@Inject
	private InstituicaoDAO instituicaoDAO;
	
	@Path("/")
	public void index() throws DAOException{
		 
		List<Instituicao> instituicoes = instituicaoDAO.listaParaHome();
		result.include("instituicoes",instituicoes);
	}
	
	@Path("/manutencao")
	public void manutencao() throws DAOException{
		
	}
	
	@Path("/devAccess")
	public void devAccess() throws DAOException{
	}
}