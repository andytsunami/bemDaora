package br.com.remembr.bemDaora.service.interfaces;

import javax.ejb.Remote;

import br.com.remembr.bemDaora.exception.SingleSignOnException;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.sso.Login;
import br.com.remembr.bemDaora.vo.LoginVO;


@Remote
public interface SingleSignOnRemote {
	
	public static final String JNDI_NAME = "ejb:/bemdaora//SingleSignOnBean!br.com.remembr.bemDaora.service.interfaces.SingleSignOnRemote";
	
	public Usuario getUsuarioLogado(String ticket) throws SingleSignOnException;
	
	public boolean isTicketValido(String ticket) throws SingleSignOnException;
	
	public boolean isTicketsMesmoLogin(String ticket1, String ticket2) throws SingleSignOnException;

	public void logout(String login) throws SingleSignOnException;
	
	public LoginVO login(Login login,boolean deslogar) throws SingleSignOnException;
	
	public String criaTicketPermanente(String login) throws SingleSignOnException;
}