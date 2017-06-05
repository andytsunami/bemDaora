package br.com.remembr.bemDaora.chat;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import br.com.remembr.bemDaora.chat.model.Mensagem;

public class ChatMessageEncoder implements Encoder.Text<Mensagem>{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(final Mensagem mensagem) throws EncodeException {
		return Json.createObjectBuilder().add("usuario", mensagem.getEmailUsuario()).add("mensagem", mensagem.getMensagem()).build().toString();
	}
}