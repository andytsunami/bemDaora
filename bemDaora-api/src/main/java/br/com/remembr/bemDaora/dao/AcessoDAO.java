package br.com.remembr.bemDaora.dao;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.enums.AcessoStatusEnum;
import br.com.remembr.bemDaora.model.Acesso;
import br.com.remembr.bemDaora.model.Usuario;

@Named
public class AcessoDAO extends DAO<Acesso, Long> {
	
	@Override
	@Inject
	public void setEntityManager(EntityManager em) {
		this.setInternalEntityManager(em);
	}

	public Acesso buscarPorTicketLogado(String ticket, boolean permanente) throws DAOException {
		try {
			Query query = this.em.createQuery("from " + Acesso.class.getSimpleName() + " where ticket = :ticket and status = :status");
			query.setParameter("ticket", ticket);
			query.setParameter("status", AcessoStatusEnum.LOGADO);
			query.setMaxResults(1);

			Acesso acesso = (Acesso) query.getSingleResult();
			return acesso;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	public Usuario buscarUsuarioPorTicketLogado(String ticket, boolean permanente) throws DAOException {
		try {
			TypedQuery<Usuario> query = this.em.createQuery("select a.usuario from " + Acesso.class.getSimpleName() + " a join fetch a.usuario.grupos where a.ticket = :ticket and a.status = :status", Usuario.class);
			query.setParameter("ticket", ticket);
			query.setParameter("status", AcessoStatusEnum.LOGADO);
			query.setMaxResults(1);

			Usuario usuario = query.getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	public Acesso buscarPorLoginLogado(String login) throws DAOException {
		try {
			Query query = this.em.createQuery("from " + Acesso.class.getSimpleName() + " where usuario.login = :login and status = :status");
			query.setParameter("login", login);
			query.setParameter("status", AcessoStatusEnum.LOGADO);
			query.setMaxResults(1);

			Acesso acesso = (Acesso) query.getSingleResult();
			return acesso;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	public Acesso buscarLogadoPermanentePorLogin(String login) throws DAOException {
		try {
			Query query = this.em.createQuery("from " + Acesso.class.getSimpleName() + " where usuario.login = :login and status = :status and permanente = true");
			query.setParameter("login", login);
			query.setParameter("status", AcessoStatusEnum.LOGADO);
			query.setMaxResults(1);

			Acesso acesso = (Acesso) query.getSingleResult();
			return acesso;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void deslogar(String login) throws DAOException {
		try {
			Query query = this.em.createQuery("update " + Acesso.class.getSimpleName() + " set status = :deslogado, dataFim = :agora where usuario.id = (select u.id from " + Usuario.class.getSimpleName() + " u where u.login = :login) and status = :logado and permanente = false");
			query.setParameter("deslogado", AcessoStatusEnum.DESLOGADO);
			query.setParameter("logado", AcessoStatusEnum.LOGADO);
			query.setParameter("agora", new Date());
			query.setParameter("login", login);

			query.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public boolean isTicketValido(String ticket) throws DAOException {
		try {
			TypedQuery<Long> query = this.em.createQuery("select count(a) from " + Acesso.class.getSimpleName() + " a where ticket = :ticket and status = :status", Long.class);
			query.setParameter("ticket", ticket);
			query.setParameter("status", AcessoStatusEnum.LOGADO);

			long qtd = query.getSingleResult();
			return qtd > 0;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}