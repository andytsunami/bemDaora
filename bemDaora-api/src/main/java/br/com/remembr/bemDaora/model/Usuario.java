package br.com.remembr.bemDaora.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ID_TIPO_USUARIO")
@Table(name = "USUARIO")
public class Usuario implements BaseEntity<Long>{
	
	private static final long serialVersionUID = 3292465011589307720L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "NOME")
	private String nome;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "EMAIL")
	private String email;
	
	@Size(min = 4, max = 255)
	@Column(name = "SENHA")
	private String senha;
	
	@NotNull
	@Column(name = "ATIVO", columnDefinition = "TINYINT(1)")
	private boolean ativo = true;
	
	@NotNull
	@Column(name = "RESETAR_SENHA", columnDefinition = "TINYINT(1)")
	private boolean resetarSenha = true;
	
	@Column(name = "ID_TIPO_USUARIO", insertable = false, updatable = false)
	private String idTipoUsuario;
	
	@Column(name = "ENDERECO")
	private String endereco;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CADASTRO")
	private Date dataCadastro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public boolean isResetarSenha() {
		return resetarSenha;
	}
	public void setResetarSenha(boolean resetarSenha) {
		this.resetarSenha = resetarSenha;
	}
	public String getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(String idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}