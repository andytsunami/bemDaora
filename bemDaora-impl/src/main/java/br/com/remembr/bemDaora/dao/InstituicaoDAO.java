package br.com.remembr.bemDaora.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.model.Instituicao;

public class InstituicaoDAO extends DAO<Instituicao, Long>{

	@Inject
	@Override
	public void setEntityManager(EntityManager em) {
		setInternalEntityManager(em);
	}

}