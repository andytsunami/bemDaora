package br.com.remembr.bemDaora.producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {
	
	@PersistenceContext(unitName = "BemDaora-PU")
	private EntityManager em;
	
	@Produces
	public EntityManager produceEntityManager(){
		return this.em;
	}
}