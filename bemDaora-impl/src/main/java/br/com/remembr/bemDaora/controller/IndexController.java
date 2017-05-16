package br.com.remembr.bemDaora.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.remembr.bemDaora.dao.generio.DAOException;

@Controller
public class IndexController {
	
	@Inject
	private Result result;
	
	@Path("/")
	public void index(){
		
	}
	
	@Path("/manutencao")
	public void manutencao() throws DAOException{
		
	}
	
	@Path("/devAccess")
	public void devAccess() throws DAOException{
	}
}