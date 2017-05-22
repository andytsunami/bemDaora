package br.com.remembr.bemDaora.bean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.remembr.bemDaora.business.SingleSignOnBusiness;
import br.com.remembr.bemDaora.exception.SingleSignOnException;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.interfaces.SingleSignOnRemote;
import br.com.remembr.bemDaora.service.sso.Login;
import br.com.remembr.bemDaora.vo.LoginVO;

@Stateless
public class SingleSignOnBean implements SingleSignOnRemote{
	
	@Inject
	private SingleSignOnBusiness sso;

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Usuario getUsuarioLogado(String ticket) throws SingleSignOnException {
		return sso.getUsuarioLogado(ticket);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public boolean isTicketValido(String ticket) throws SingleSignOnException {
		return sso.isTicketValido(ticket);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public boolean isTicketsMesmoLogin(String ticket1, String ticket2) throws SingleSignOnException {
		return sso.isTicketsMesmoLogin(ticket1, ticket2);
	}

	@Override
	public void logout(String login) throws SingleSignOnException {
		sso.logout(login);
	}

	@Override
	public LoginVO login(Login login, boolean deslogar) throws SingleSignOnException {
		return sso.login(login,deslogar);
	}

	@Override
	public String criaTicketPermanente(String login) throws SingleSignOnException {
		return sso.ticketPermanente(login);
	}
}