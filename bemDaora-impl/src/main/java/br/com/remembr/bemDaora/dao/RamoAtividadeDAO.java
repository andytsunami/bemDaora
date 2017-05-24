package br.com.remembr.bemDaora.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.model.RamoAtividade;

public class RamoAtividadeDAO extends DAO<RamoAtividade, Long>{

	@Inject
	@Override
	public void setEntityManager(EntityManager em) {
		setInternalEntityManager(em);
	}
	
	public List<RamoAtividade> lista(){
		String sql = "select r from " + RamoAtividade.class.getSimpleName() + " r order by r.nome asc";
		
		TypedQuery<RamoAtividade> query = this.em.createQuery(sql,RamoAtividade.class);
		List<RamoAtividade> resultado = query.getResultList();
		
		return resultado;
	}
}