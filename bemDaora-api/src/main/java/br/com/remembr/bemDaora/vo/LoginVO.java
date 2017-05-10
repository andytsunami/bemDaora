package br.com.remembr.bemDaora.vo;

import java.io.Serializable;

public class LoginVO implements Serializable {
	
	private static final long serialVersionUID = 5504725977925106901L;
	private Long idUsuario;
	private String ticket;

	public LoginVO(Long idUsuario, String ticket) {
		this.idUsuario = idUsuario;
		this.ticket = ticket;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}