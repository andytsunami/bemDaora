// https://github.com/atao60/javaee7-websocket-chat/blob/master/app/src/main/webapp/index.html
// https://yakovfain.com/2014/12/29/pushing-data-to-multiple-websocket-clients-from-a-java-server/
package br.com.remembr.bemDaora.chat;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import br.com.remembr.bemDaora.chat.model.Mensagem;

@ServerEndpoint(value = "/socket/{login}",encoders = ChatMessageEncoder.class, decoders = ChatMessageDecoder.class)
public class WSEndpoint {
	
	private final Logger log = Logger.getLogger(getClass().getName());
	
	private static Set<Session> allSessions;
	
	@OnOpen
	public void open(final Session session,@PathParam("login") final String login) {
		System.out.println("Registrando login na sessão:" + session.getId());
		session.getUserProperties().put("login", login);
		allSessions = session.getOpenSessions();
		
	}
	
	@OnMessage
	public void onMessage(Mensagem mensagem, final Session session) {
		System.out.println("Received : "+ mensagem.getMensagem() + ", session:" + session.getId());
		String login = (String) session.getUserProperties().get("login");
		
		try {
			for(Session s : session.getOpenSessions()){
				if (s.isOpen()
						&& login.equals(s.getUserProperties().get("login"))) {
					//s.getBasicRemote().sendObject(mensagem.getMensagem());
					s.getBasicRemote().sendObject(mensagem);
				}
			}
		} catch (Exception e) {
			log.log(Level.WARNING, "falha ao enviar mensagem", e);
		}
	}
	
	public boolean enviaMensagem(Mensagem mensagem){
		if(allSessions != null){
			for (Session session : allSessions) {
				if(session.getUserProperties().get("login").toString().equals(mensagem.getEmailUsuario())){
					onMessage(mensagem, session);
					return true;
				} 
			}
		} else {
			return false;
		}
		return false;
	}
	
	
	@OnClose
	public void close(Session session, CloseReason c) {
		System.out.println("Closing:" + session.getId());
	}
	
}