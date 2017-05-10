package br.com.remembr.bemDaora.business;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.remembr.bemDaora.dao.UsuarioDAO;

@Stateless
public class LoginBusiness {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void criarLockLoginSeNaoExistir(String email){
		usuarioDAO.criarLockLogin(email);
	}
}