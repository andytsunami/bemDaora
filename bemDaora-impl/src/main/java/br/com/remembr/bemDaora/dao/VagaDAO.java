package br.com.remembr.bemDaora.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Vaga;

public class VagaDAO extends DAO<Vaga, Long>{

	@Inject
	@Override
	public void setEntityManager(EntityManager em) {
		setInternalEntityManager(em);
	}

	public void exclusaoLogica(Long idVaga) throws DAOException {
		String sql = "update " + Vaga.class.getSimpleName() + " v set v.ativo = :desativado where v.id = :idVaga";
		try {
			Query query = this.em.createQuery(sql);
			query.setParameter("idVaga", idVaga);
			query.setParameter("desativado", Boolean.FALSE);
			query.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	public List<Vaga> lista() throws DAOException {
		String sql = "select v from " + Vaga.class.getSimpleName() + " v where v.ativo = :ativo order by v.titulo asc";
		
		try{
			TypedQuery<Vaga> query = this.em.createQuery(sql,Vaga.class);
			query.setParameter("ativo", Boolean.TRUE);
			
			List<Vaga> resultado = query.getResultList();
			return resultado;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}