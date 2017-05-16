package br.com.remembr.bemDaora.dao;

import java.util.Random;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.security.Base64Utils;
import org.joda.time.DateTime;

import br.com.remembr.bemDaora.dao.generio.DAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.TokenResetSenha;



@Named
public class TokenResetSenhaDAO extends DAO<TokenResetSenha, String>{

	@Override
	@Inject
	public void setEntityManager(EntityManager em) {
		super.setInternalEntityManager(em);
	}
		
	public TokenResetSenha buscarPorToken(String token64) throws DAOException {
		try {
			TypedQuery<TokenResetSenha> query = this.em.createQuery("from " + TokenResetSenha.class.getSimpleName() + " where token = :token64 and ativo = :ativo", TokenResetSenha.class);
			query.setParameter("token64", token64);
			query.setParameter("ativo", true);
			TokenResetSenha token = query.getSingleResult();
			return token;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	public TokenResetSenha novoToken(TokenResetSenha.TipoEnum tipo, Long idUsuario, String emailUsuario) throws DAOException {
		try {
			DateTime agora = new DateTime();
			TokenResetSenha token = new TokenResetSenha();
			token.setAtivo(true);
			token.setDataRequisicao(agora.toDate());
			token.setDataExpiracao(agora.plusHours(2).toDate());
			token.setEmailUsuario(emailUsuario);
			token.setIdUsuario(idUsuario);
			token.setRandomInt(Math.abs(new Random().nextInt()));
			token.setTipo(tipo);
			token.setUuid(UUID.randomUUID().toString());
	
			String base = token.getRandomInt() + "|" + String.valueOf(emailUsuario) + "|" + token.getUuid();
			token.setToken(Base64Utils.tob64(base.getBytes("UTF-8")));
			
			token = insert(token);
			return token;
		} catch (DAOException e) {
			throw e;
		} catch (Exception e) { 
			throw new RuntimeException(e);
		}
	}

	
	public void desativaToken(String uuid) {
		Query query = this.em.createQuery("update " + TokenResetSenha.class.getSimpleName() + " set ativo = :ativo where uuid = :uuid");
		query.setParameter("ativo", false);
		query.setParameter("uuid", uuid);
		query.executeUpdate();
	}	
}