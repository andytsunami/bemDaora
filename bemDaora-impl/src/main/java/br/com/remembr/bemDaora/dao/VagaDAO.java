package br.com.remembr.bemDaora.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Atividade;
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

	public List<Vaga> buscarVagasIntituicao(Long idInstituicao) throws DAOException {
		String sql = "select v from " + Vaga.class.getSimpleName() + " v where v.ativo = :ativo and v.instituicao.id = :idInstituicao order by v.titulo asc";
		
		try{
			TypedQuery<Vaga> query = this.em.createQuery(sql,Vaga.class);
			query.setParameter("ativo", Boolean.TRUE);
			query.setParameter("idInstituicao", idInstituicao);
			
			List<Vaga> resultado = query.getResultList();
			return resultado;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<Vaga> listaPorInstituicao(Long idInstituicao) throws DAOException {
		String sql = "select v from " + Vaga.class.getSimpleName() + " v where v.instituicao.id = :idInstituicao and v.ativo = true order by id asc";
		try {
			TypedQuery<Vaga> query = this.em.createQuery(sql,Vaga.class);
			query.setParameter("idInstituicao", idInstituicao);
			List<Vaga> resultado = query.getResultList();
			return resultado;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<Atividade> listaAtividades(Long idVaga) throws DAOException {
		String sql = "select a from " + Atividade.class.getSimpleName() + " a where a.vaga.id = :idVaga";
		try {
			TypedQuery<Atividade> query = this.em.createQuery(sql,Atividade.class);
			query.setParameter("idVaga", idVaga);
			List<Atividade> resultado = query.getResultList();
			return resultado;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}