package br.com.remembr.bemDaora.service.sso;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;

import br.com.remembr.bemDaora.exception.SingleSignOnException;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.interfaces.SingleSignOnRemote;

public class UsuarioLogadoProducer {
	
	@Inject
	private UsuarioTicket ticket;
	
	@Produces
	@SessionScoped
	@UsuarioLogado
	@Named("BD_UsuarioLogado")
	public Usuario produceUsuarioLogado() throws SingleSignOnException {
		SingleSignOnRemote sso;
		
		try{
			sso = (SingleSignOnRemote) new InitialContext().lookup(SingleSignOnRemote.JNDI_NAME);
		} catch (Exception e){
			throw new SingleSignOnException(e);
		}
		
		Usuario usuario = sso.getUsuarioLogado(ticket.getTicket());
		if(usuario != null){
			return usuario;
		} else {
			throw new SingleSignOnException("Ticket inválido [" + ticket.getTicket() + "]");
		}
	}
}