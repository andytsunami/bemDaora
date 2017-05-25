package br.com.remembr.bemDaora.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Vetoed;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.remembr.bemDaora.settings.Defaults;
@Vetoed
@Entity
@DiscriminatorValue(Defaults.Usuario.INSTITUICAO)
@Table(name = "INSTITUICAO")
public class Instituicao extends Usuario implements BaseEntity<Long>{
	
	private static final long serialVersionUID = -6084585532906762194L;

	@Column(name = "RAZAO_SOCIAL")
	private String razaoSocial;
	
	@Column(name = "SOBRE")
	private String sobre;
	
	@Column(name = "CNPJ")
	private String cnpj;
	
	@Column(name = "AVATAR")
	private byte[] avatar;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL)
	private List<FotoInstituicao> fotosInstituicao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL)
	private List<Vaga> vagas;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public List<FotoInstituicao> getFotosInstituicao() {
		return fotosInstituicao;
	}

	public void setFotosInstituicao(List<FotoInstituicao> fotosInstituicao) {
		this.fotosInstituicao = fotosInstituicao;
	}

	public List<Vaga> getVagas() {
		List<Vaga> ativas = new ArrayList<>();
		for (Vaga vaga : vagas) {
			if(vaga.isAtivo()){
				ativas.add(vaga);
			}
		}
		return ativas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}
}