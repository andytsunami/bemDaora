package br.com.remembr.bemDaora.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioVO implements Serializable {
	
	private static final long serialVersionUID = 7619679414148373132L;
	
	private Long id;
	private String login;
	private String nome;
	private Integer ramal;
	private String email;
	private String perfil;
	private String capa;
	private String departamento;
	private boolean ativo;
	private String avatar;
	private String cpf;
	private String rg;
	private String telefone;
	private List<String> niveisRaiz = new ArrayList<String>();
	
	public UsuarioVO(Long id, String login, String email) {
		this.id = id;
		this.login = login;
		this.email = email;
	}
	
	public UsuarioVO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	
	public UsuarioVO(Long id, String nome, Integer ramal, String email, String perfil, String departamento, String capa, String avatar, String cpf, String rg, String telefone) {
		this.id = id;
		this.nome = nome;
		this.ramal = ramal;
		this.email = email;
		this.perfil = perfil;
		this.departamento = departamento;
		this.capa = capa;
		this.avatar = avatar;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
	}
	
	public UsuarioVO(Long id, String nome,  Integer ramal, String perfil, String login) {
		this.id = id;
		this.nome = nome;
		this.ramal = ramal;		
		this.perfil = perfil;		
		this.login = login;
	}
	

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

	public Integer getRamal() {
		return ramal;
	}

	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}

	public List<String> getNiveisRaiz() {
		return niveisRaiz;
	}

	public void setNiveisRaiz(List<String> niveisRaiz) {
		this.niveisRaiz = niveisRaiz;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "UsuarioVO [id=" + id + ", nome=" + nome + "]";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
