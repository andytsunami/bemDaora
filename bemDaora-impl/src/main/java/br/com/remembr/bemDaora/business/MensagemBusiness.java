package br.com.remembr.bemDaora.business;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.remembr.bemDaora.chat.WSEndpoint;
import br.com.remembr.bemDaora.chat.model.Mensagem;
import br.com.remembr.bemDaora.dao.MensagemDAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;

@Stateless
public class MensagemBusiness {
	
	@Inject
	private WSEndpoint wSEndpoint;
	
	@Inject
	private MensagemDAO mensagemDAO;
	
	public void enviarMensagem(Mensagem mensagem) throws DAOException{
		Mensagem mensagemBD = mensagemDAO.insert(mensagem);
		if(wSEndpoint.enviaMensagem(mensagemBD)){
			mensagemBD.setEnviado(new Date());
		}
		
		mensagemDAO.update(mensagemBD);
	}
}