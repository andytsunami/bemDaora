package br.com.remembr.bemDaora.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.model.Usuario;

public class UsuarioDAO extends DAO<Usuario, Long>{

	@Override
	@Inject
	public void setEntityManager(EntityManager em) {
		this.setInternalEntityManager(em);
	}

}