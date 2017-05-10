package br.com.remembr.bemDaora.service.sso;

import java.io.Serializable;

import com.google.common.base.Strings;

public class Login implements Serializable {
	
	private static final long serialVersionUID = -972754403993075107L;
	private String email;
	private String senha;
	private String ip;

	public Login() {}
	
	public Login(String login, String senha) {
		this.email = (Strings.isNullOrEmpty(login) == true ? null : login.toLowerCase());
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String login) {
		this.email = (Strings.isNullOrEmpty(login) == true ? null : login.toLowerCase());
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}