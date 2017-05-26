package br.com.remembr.bemDaora.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.remembr.bemDaora.settings.Defaults;

@Entity
@DiscriminatorValue(Defaults.Usuario.VOLUNTARIO)
@Table(name = "VOLUNTARIO")
public class Voluntario extends Usuario implements BaseEntity<Long>{
	
	private static final long serialVersionUID = -926117324922978880L;

	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "AVATAR_FACEBOOK")
	private String avatarFacebook;
	
	@Column(name = "AVATAR_GOOGLE")
	private String avatarGoogle;
	
	@Column(name = "CADASTRO_COMPLETO")
	private boolean cadastroCompleto;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAvatarFacebook() {
		return avatarFacebook;
	}

	public void setAvatarFacebook(String avatarFacebook) {
		this.avatarFacebook = avatarFacebook;
	}

	public String getAvatarGoogle() {
		return avatarGoogle;
	}

	public void setAvatarGoogle(String avatarGoogle) {
		this.avatarGoogle = avatarGoogle;
	}

	public boolean isCadastroCompleto() {
		return cadastroCompleto;
	}

	public void setCadastroCompleto(boolean cadastroCompleto) {
		this.cadastroCompleto = cadastroCompleto;
	}
}