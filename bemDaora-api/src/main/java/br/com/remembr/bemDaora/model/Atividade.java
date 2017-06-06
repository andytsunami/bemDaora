package br.com.remembr.bemDaora.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

@Entity
@Table(name = "ATIVIDADE")
public class Atividade implements BaseEntity<Long>{
	
	private static final long serialVersionUID = -5506485238236638771L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_VOLUNTARIO")
	private Voluntario voluntario;
	
	@ManyToOne
	@JoinColumn(name = "ID_VAGA")
	private Vaga vaga;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_AGENDADA")
	private Date dataAgendada;
	
	@Column(name = "APROVADO")
	private boolean aprovado = false;
	
	@Column(name = "REALIZADO")
	private boolean realizado = false;
	
	@Column(name = "MOTIVO_REPROVACAO")
	private String motivoReprovacao;
	
	@Column(name = "QUANTIDADE_HORA")
	private Long quantidadeHora;
	
	@Column(name = "CONFIRMA_INSTITUICAO")
	private boolean confirmadoInstituicao = false; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Voluntario getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Date getDataAgendada() {
		return dataAgendada;
	}

	public void setDataAgendada(Date dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public String getMotivoReprovacao() {
		return motivoReprovacao;
	}

	public void setMotivoReprovacao(String motivoReprovacao) {
		this.motivoReprovacao = motivoReprovacao;
	}

	public Long getQuantidadeHora() {
		return quantidadeHora;
	}

	public void setQuantidadeHora(Long quantidadeHora) {
		this.quantidadeHora = quantidadeHora;
	}
	
	public Date getDataTermino(){
		if(this.dataAgendada != null && this.quantidadeHora != null){
			DateTime dateTime = new DateTime(this.dataAgendada);
			DateTime plusHours = dateTime.plusHours(this.quantidadeHora.intValue());
			return plusHours.toDate();
		} else {
			return this.dataAgendada;
		}
	}

	public boolean isConfirmadoInstituicao() {
		return confirmadoInstituicao;
	}

	public void setConfirmadoInstituicao(boolean confirmadoInstituicao) {
		this.confirmadoInstituicao = confirmadoInstituicao;
	}
}