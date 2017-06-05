package br.com.remembr.bemDaora.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.remembr.bemDaora.chat.model.Mensagem;
import br.com.remembr.bemDaora.dao.generio.DAO;

public class MensagemDAO extends DAO<Mensagem, Long>{

	@Inject
	@Override
	public void setEntityManager(EntityManager em) {
		this.setInternalEntityManager(em);
	}
}