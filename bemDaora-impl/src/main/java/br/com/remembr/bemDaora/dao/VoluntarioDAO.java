package br.com.remembr.bemDaora.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.model.Voluntario;

public class VoluntarioDAO extends DAO<Voluntario, Long>{

	@Inject
	@Override
	public void setEntityManager(EntityManager em) {
		setInternalEntityManager(em);
	}

	public byte[] buscaFotoDoVoluntario(Long idVoluntario) {
		String sql = "select v.avatar from " + Voluntario.class.getSimpleName() + " v where v.id = :idVoluntario";
		Query query = this.em.createQuery(sql);
		query.setParameter("idVoluntario", idVoluntario);
		query.setMaxResults(1);
		
		return (byte[]) query.getSingleResult();
		
	}
}