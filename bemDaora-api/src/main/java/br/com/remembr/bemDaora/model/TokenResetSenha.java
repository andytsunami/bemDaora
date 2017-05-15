package br.com.remembr.bemDaora.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TOKEN_RESET_SENHA")
public class TokenResetSenha implements BaseEntity<String> {

	private static final long serialVersionUID = -4296189996029763195L;

	public enum TipoEnum {
		ESQUECEU, EXPIRADO
	}

	@Id
	@NotNull
	@Column(name = "UUID")
	private String uuid;

	@NotNull
	@Column(name = "ID_USUARIO")
	private Long idUsuario;

	@NotNull
	@Column(name = "EMAIL_USUARIO")
	private String emailUsuario;

	@NotNull
	@Column(name = "DT_REQUISICAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRequisicao;

	@NotNull
	@Column(name = "DT_EXPIRACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataExpiracao;

	@NotNull
	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	private TipoEnum tipo;

	@NotNull
	@Column(name = "RANDOM_INT")
	private Integer randomInt;

	@NotNull
	@Column(name = "TOKEN")
	private String token;

	@NotNull
	@Column(name = "ATIVO", columnDefinition = "TINYINT(1)")
	private boolean ativo;

	public String getId() {
		return uuid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Date getDataRequisicao() {
		return dataRequisicao;
	}

	public void setDataRequisicao(Date dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public Integer getRandomInt() {
		return randomInt;
	}

	public void setRandomInt(Integer randomInt) {
		this.randomInt = randomInt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenResetSenha other = (TokenResetSenha) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
}