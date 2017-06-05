package br.com.remembr.bemDaora.chat;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import br.com.remembr.bemDaora.chat.model.Mensagem;

public class ChatMessageDecoder implements Decoder.Text<Mensagem>{

	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public Mensagem decode(String corpo) throws DecodeException {
		Mensagem mensagem = new Mensagem();
		JsonObject obj = Json.createReader(new StringReader(corpo)).readObject();
		mensagem.setEmailUsuario(obj.getString("usuario"));
		mensagem.setMensagem(obj.getString("mensagem"));
		return mensagem;
	}

	@Override
	public boolean willDecode(final String s) {
		return true;
	}
}