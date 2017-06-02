package br.com.remembr.bemDaora.model;

import java.util.Base64;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name = "SEGUNDO_CADASTRO_COMPLETO")
	private boolean segundoCadastroCompleto = false;
	
	@Column(name = "ULTIMO_CADASTRO_COMPLETO")
	private boolean ultimoCadastroCompleto = false;
	
	@ManyToOne
	@JoinColumn(name = "ID_RAMO_ATIVIDADE")
	private RamoAtividade profissao;
	
	@Column(name = "SOBRE")
	private String sobre;
	
	@Column(name = "AVATAR")
	private byte[] avatar;
	
	@Column(name = "LEVEL")
	private Integer level = 0;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "voluntario", cascade = CascadeType.ALL)
	private List<Atividade> atividades;
	
	@Column(name = "PONTOS")
	private Long pontos = 0L;
	
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

	public boolean isSegundoCadastroCompleto() {
		return segundoCadastroCompleto;
	}

	public void setSegundoCadastroCompleto(boolean cadastroCompleto) {
		this.segundoCadastroCompleto = cadastroCompleto;
	}

	public RamoAtividade getProfissao() {
		return profissao;
	}

	public void setProfissao(RamoAtividade profissao) {
		this.profissao = profissao;
	}

	public boolean isUltimoCadastroCompleto() {
		return ultimoCadastroCompleto;
	}

	public void setUltimoCadastroCompleto(boolean ultimoCadastroCompleto) {
		this.ultimoCadastroCompleto = ultimoCadastroCompleto;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public String getAvatarNoJeito(){
		return "data:image/png;base64,"+Base64.getEncoder().encodeToString(avatar);
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Long getPontos() {
		return pontos;
	}

	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}
}