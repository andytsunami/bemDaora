package br.com.remembr.bemDaora.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.FotoInstituicao;
import br.com.remembr.bemDaora.model.Instituicao;

public class InstituicaoDAO extends DAO<Instituicao, Long>{

	@Inject
	@Override
	public void setEntityManager(EntityManager em) {
		setInternalEntityManager(em);
	}
	
	public List<Instituicao> lista() throws DAOException{
		String sql = "select i from " + Instituicao.class.getSimpleName() + " i where i.ativo = :ativo order by i.dataCadastro desc";
		
		try {
			TypedQuery<Instituicao> query = this.em.createQuery(sql,Instituicao.class);
			query.setParameter("ativo", Boolean.TRUE);
			query.setMaxResults(10);
			List<Instituicao> resultado = query.getResultList();
			return resultado;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void exclusaoLogica(Long idInstituicao) throws DAOException {
		String sql = "update " + Instituicao.class.getSimpleName() + " i set i.ativo = :desativado where i.id = :idInstituicao";
		try {
			Query query = this.em.createQuery(sql);
			query.setParameter("idInstituicao", idInstituicao);
			query.setParameter("desativado", Boolean.FALSE);
			query.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public Instituicao buscar(Long idInstituicao) throws DAOException {
		
		String sql = "select i from  " + Instituicao.class.getSimpleName() 
				+ " i left join fetch i.vagas where i.id = :idInstituicao order by i.nome asc";
		
		try {
			TypedQuery<Instituicao> query = this.em.createQuery(sql,Instituicao.class);
			query.setParameter("idInstituicao", idInstituicao);
			Instituicao instituicao = query.getSingleResult();
			return instituicao;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void limparGaleria(Long idInstituicao) throws DAOException {
		String sql = "delete from " + FotoInstituicao.class.getSimpleName() + " f where f.instituicao.id = :idInstituicao";
		try{
			Query query = this.em.createQuery(sql);
			query.setParameter("idInstituicao", idInstituicao);
			query.executeUpdate();
		} catch (Exception e) {
			throw new DAOException("Não foi possivel limpar a geleria. \n" + e);
		}
	}
}