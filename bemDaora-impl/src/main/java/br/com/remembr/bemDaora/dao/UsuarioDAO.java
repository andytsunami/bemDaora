package br.com.remembr.bemDaora.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.LockLogin;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.utils.PasswordEncrypter;
import br.com.remembr.bemDaora.vo.ChaveValorVO;
import br.com.remembr.bemDaora.vo.UsuarioVO;

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
	
	public LockLogin lockLogin(String login) throws DAOException {
		try {
			
			LockLogin lockLogin = this.em.find(LockLogin.class, login, LockModeType.PESSIMISTIC_WRITE);
			return lockLogin;
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
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

			Usuario usuario = query.getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			throw e;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public Usuario buscarPorEmail(String email) throws DAOException {
		try {
			TypedQuery<Usuario> query = this.em.createQuery("select u from " + Usuario.class.getSimpleName() + " u where u.login = :pLogin", Usuario.class);
			query.setParameter("pLogin", email);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public String buscarNomePorId(Long id) throws DAOException {
		try {
			TypedQuery<String> query = this.em.createQuery("select u.nome from " + Usuario.class.getSimpleName() + " u where u.id = :id", String.class);
			query.setParameter("id", id);
			
			return query.getSingleResult();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<ChaveValorVO> buscarDadosEmailUsuario(String email) throws DAOException {
		try {
			TypedQuery<ChaveValorVO> query = this.em.createQuery("select new br.com.remembr.bemDaora.vo.ChaveValorVO(u.email,u.nome) from " + Usuario.class.getSimpleName() + " u where upper(u.email) like :email and u.ativo = :ativo and u.email is not null order by u.nome asc", ChaveValorVO.class);
			query.setParameter("email", "%" + email.toUpperCase() + "%");
			query.setParameter("ativo", true);

			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<UsuarioVO> buscarNomeUsuario(String nome) throws DAOException {
		try {
			TypedQuery<UsuarioVO> query = this.em.createQuery("select new br.com.remembr.bemDaora.vo.UsuarioVO(u.id,u.nome) from " + Usuario.class.getSimpleName() + " u where upper(u.nome) like :nome and u.ativo = :ativo order by u.nome asc", UsuarioVO.class);
			query.setParameter("nome", "%" + nome.toUpperCase() + "%");
			query.setParameter("ativo", true);

			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void alterarSenha(Long idUsuario, String novaSenha) throws DAOException {
		try {
			novaSenha = PasswordEncrypter.encrypt(novaSenha);
			
			Query query = this.em.createQuery("update " + Usuario.class.getSimpleName() + " set senha = :novaSenha where id = :idUsuario");
			query.setParameter("idUsuario", idUsuario);
			query.setParameter("novaSenha", novaSenha);
			
			query.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
	}

	public Usuario buscarPorCpf(String cpf) throws DAOException {
		try {
			TypedQuery<Usuario> query = this.em.createQuery("from " + Usuario.class.getSimpleName() + " where cpf = :cpf and ativo = :ativo", Usuario.class);
			query.setParameter("cpf", cpf);
			query.setParameter("ativo", true);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}