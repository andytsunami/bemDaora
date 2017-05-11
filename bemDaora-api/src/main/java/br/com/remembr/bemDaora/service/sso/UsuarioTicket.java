package br.com.remembr.bemDaora.service.sso;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuarioTicket implements Serializable {

	private static final long serialVersionUID = 1088641784795632690L;

	private String ticket;
	
	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
	public String validaURL(String url) {
		String[] urls = url.split("[?]");
		if (urls.length > 1) {
			return urls[0] + "?ticket=" + ticket + "&" + urls[1]; 
		} else {
			return url;
		}
	}
	
	@Override
	public String toString() {
		return this.ticket;
	}
}