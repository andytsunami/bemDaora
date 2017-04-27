package br.com.remembr.bemDaora.model;

import java.io.Serializable;

public interface BaseEntity<PK> extends Serializable {
	
	public PK getId();

}