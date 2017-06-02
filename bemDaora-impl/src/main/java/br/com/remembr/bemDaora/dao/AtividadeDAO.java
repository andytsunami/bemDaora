package br.com.remembr.bemDaora.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Atividade;

public class AtividadeDAO extends DAO<Atividade, Long>{

	@Inject
	@Override
	public void setEntityManager(EntityManager em) {
		this.setInternalEntityManager(em);
	}

	public Atividade buscaPorUsuarioVaga(Long idVaga, Long idVoluntario) throws DAOException {
		String sql = "select a from " + Atividade.class.getSimpleName() + " a where a.voluntario.id = :idVoluntario and a.vaga.id = :idVaga";
		
		try {
			TypedQuery<Atividade> query = this.em.createQuery(sql,Atividade.class);
			query.setParameter("idVoluntario", idVoluntario);
			query.setParameter("idVaga", idVaga);
			query.setMaxResults(1);
			
			Atividade resultado = query.getSingleResult();
			return resultado;
			
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}