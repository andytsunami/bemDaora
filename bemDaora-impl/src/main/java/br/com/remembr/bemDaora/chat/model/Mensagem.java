package br.com.remembr.bemDaora.chat.model;

public class Mensagem {
	
	private String mensagem;
	
	private String usuario;
	
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String toString() {
		return "Mensagem [mensagem=" + mensagem + ", usuario=" + usuario +"]";
	}
}