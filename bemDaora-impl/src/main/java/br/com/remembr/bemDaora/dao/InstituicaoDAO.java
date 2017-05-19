package br.com.remembr.bemDaora.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Instituicao;

public class InstituicaoDAO extends DAO<Instituicao, Long>{

	@Inject
	@Override
	public void setEntityManager(EntityManager em) {
		setInternalEntityManager(em);
	}
	
	public List<Instituicao> listaParaHome() throws DAOException{
		String sql = "select i from " + Instituicao.class.getSimpleName() + " i order by i.dataCadastro desc";
		
		try {
			TypedQuery<Instituicao> query = this.em.createQuery(sql,Instituicao.class);
			query.setMaxResults(10);
			List<Instituicao> resultado = query.getResultList();
			return resultado;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}