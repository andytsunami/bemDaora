package br.com.remembr.bemDaora.producer;

import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;

import br.com.remembr.bemDaora.service.interfaces.SingleSignOnRemote;

public class SingleSignOnRemoteProducer {
	
	@Produces
	public SingleSignOnRemote produceSingleSignOnRemote() throws Exception{
		return (SingleSignOnRemote) new InitialContext().lookup(SingleSignOnRemote.JNDI_NAME);
	}
}