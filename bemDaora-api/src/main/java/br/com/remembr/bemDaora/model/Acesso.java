package br.com.remembr.bemDaora.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.remembr.bemDaora.enums.AcessoStatusEnum;


@Entity
@Table(name = "ACESSO")
public class Acesso implements BaseEntity<Long>{
	
	private static final long serialVersionUID = 2787314595068474644L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DT_FIM")
	private Date dataFim;

	@NotNull
	@Column(name = "DT_INICIO")
	private Date dataInicio;

	@NotNull
	@Column(name = "IP")
	private String ip;

	@NotNull
	@Enumerated(EnumType.STRING)
	private AcessoStatusEnum status;

	@NotNull
	@Column(name = "TICKET")
	private String ticket;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@NotNull
	@Column(name = "PERMANENTE", columnDefinition = "TINYINT(1)")
	private Boolean permanente = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public AcessoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(AcessoStatusEnum status) {
		this.status = status;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getPermanente() {
		return permanente;
	}

	public void setPermanente(Boolean permanente) {
		this.permanente = permanente;
	}
}