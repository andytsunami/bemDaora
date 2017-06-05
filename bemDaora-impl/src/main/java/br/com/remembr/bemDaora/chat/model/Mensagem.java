package br.com.remembr.bemDaora.chat.model;

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

import br.com.remembr.bemDaora.model.BaseEntity;
import br.com.remembr.bemDaora.model.Voluntario;

@Entity
@Table(name = "MENSAGEM")
public class Mensagem implements BaseEntity<Long>{
	
	private static final long serialVersionUID = -3516990119284529204L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CORPO")
	private String mensagem;
	
	@Column(name = "EMAIL")
	private String emailUsuario;
	
	@Column(name = "TIPO_MENSAGEM")
	private String tipoMensagem;
	
	@ManyToOne
	@JoinColumn(name = "ID_VOLUNTARIO_DESTINO")
	private Voluntario voluntario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_ENVIO")
	private Date enviado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_VIZUALIZADO")
	private Date visualizado;
	
	@Column(name = "LINK")
	private String enderecoDoObjeto;
	
	public Mensagem(String mensagem, String emailUsuario, String tipoMensagem, Voluntario voluntario) {
		super();
		this.mensagem = mensagem;
		this.emailUsuario = emailUsuario;
		this.tipoMensagem = tipoMensagem;
		this.voluntario = voluntario;
	}
	
	public Mensagem() {
	}

	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoMensagem() {
		return tipoMensagem;
	}
	public void setTipoMensagem(String tipoMensagem) {
		this.tipoMensagem = tipoMensagem;
	}
	public Voluntario getVoluntario() {
		return voluntario;
	}
	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}
	public Date getEnviado() {
		return enviado;
	}
	public void setEnviado(Date enviado) {
		this.enviado = enviado;
	}
	public Date getVisualizado() {
		return visualizado;
	}
	public void setVisualizado(Date visualizado) {
		this.visualizado = visualizado;
	}

	public String getEnderecoDoObjeto() {
		return enderecoDoObjeto;
	}

	public void setEnderecoDoObjeto(String enderecoDoObjeto) {
		this.enderecoDoObjeto = enderecoDoObjeto;
	}

	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", mensagem=" + mensagem + ", emailUsuario=" + emailUsuario + ", tipoMensagem="
				+ tipoMensagem + ", voluntario=" + voluntario + ", enviado=" + enviado + ", visualizado=" + visualizado
				+ ", enderecoDoObjeto=" + enderecoDoObjeto + "]";
	}
}