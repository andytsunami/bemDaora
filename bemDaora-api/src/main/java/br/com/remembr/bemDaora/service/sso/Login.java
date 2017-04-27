package br.com.remembr.bemDaora.service.sso;

import java.io.Serializable;

import com.google.common.base.Strings;

public class Login implements Serializable {
	
	private static final long serialVersionUID = -972754403993075107L;
	private String login;
	private String senha;
	private String ip;

	public Login() {}
	
	public Login(String login, String senha) {
		this.login = (Strings.isNullOrEmpty(login) == true ? null : login.toLowerCase());
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = (Strings.isNullOrEmpty(login) == true ? null : login.toLowerCase());
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