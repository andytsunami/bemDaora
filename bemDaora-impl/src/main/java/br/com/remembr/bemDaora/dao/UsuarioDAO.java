package br.com.remembr.bemDaora.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.LockLogin;
import br.com.remembr.bemDaora.model.Usuario;

@Named
public class UsuarioDAO extends DAO<Usuario, Long>{

	@Override
	@Inject
	public void setEntityManager(EntityManager em) {
		this.setInternalEntityManager(em);
	}

	public void criarLockLogin(String email) {
		this.em.merge(new LockLogin(email));
	}
	
	public LockLogin lockLogin(String login) {
		return this.em.find(LockLogin.class, login, LockModeType.PESSIMISTIC_WRITE);
	}
	
	public Long buscarIdPorEmail(String email) throws DAOException {
		try {
			TypedQuery<Long> query = this.em.createQuery("select id from " + Usuario.class.getSimpleName() + " where email = :email", Long.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public Usuario buscarPorEmailAtivo(String email) throws DAOException, NoResultException {
		try {
			TypedQuery<Usuario> query = this.em.createQuery("from " + Usuario.class.getSimpleName() + " where email = :pEmail and ativo = :pAtivo", Usuario.class);
			query.setParameter("pEmail", email);
			query.setParameter("pAtivo", true);

			return query.getSingleResult();
		} catch (NoResultException e) {
			throw e;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}