package br.com.remembr.bemDaora.vo;

import java.io.Serializable;

public class ChaveValorVO implements Serializable {
	
	private static final long serialVersionUID = -8823685857122906328L;
	
	private String chave;
	private String valor;

	public ChaveValorVO() {
	}

	public ChaveValorVO(String chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chave == null) ? 0 : chave.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		ChaveValorVO other = (ChaveValorVO) obj;
		if (chave == null) {
			if (other.chave != null) return false;
		} else if (!chave.equals(other.chave)) return false;
		return true;
	}

}
