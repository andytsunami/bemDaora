package br.com.remembr.bemDaora.service.bean;

import javax.ejb.Stateless;

import br.com.remembr.bemDaora.exception.SingleSignOnException;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.interfaces.SingleSignOnRemote;
import br.com.remembr.bemDaora.service.sso.Login;
import br.com.remembr.bemDaora.vo.LoginVO;

@Stateless
public class SingleSignOnBean implements SingleSignOnRemote{

	@Override
	public Usuario getUsuarioLogado(String ticket) throws SingleSignOnException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTicketValido(String ticket) throws SingleSignOnException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTicketsMesmoLogin(String ticket1, String ticket2) throws SingleSignOnException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(String login) throws SingleSignOnException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoginVO login(Login login, boolean deslogar) throws SingleSignOnException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String criaTicketPermanente(String login) throws SingleSignOnException {
		// TODO Auto-generated method stub
		return null;
	}

}
