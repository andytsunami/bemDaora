package br.com.remembr.bemDaora.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
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

	public List<Voluntario> listaRanking() throws DAOException {
		String sql = "select v from " + Voluntario.class.getSimpleName() + " v where v.ativo = true order by v.level asc";
		try {
			TypedQuery<Voluntario> query = this.em.createQuery(sql,Voluntario.class);
			query.setMaxResults(10);
			List<Voluntario> resultado = query.getResultList();
			return resultado;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}