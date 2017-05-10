package br.com.remembr.bemDaora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LOCK_LOGIN")
public class LockLogin implements BaseEntity<String>{
	
	private static final long serialVersionUID = -4064200160710162045L;
	
	@Id
	@Column(name = "EMAIL")
	private String id;
	
	public LockLogin(){}
	
	public LockLogin(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LockLogin lockLogin = (LockLogin) o;

		return id != null ? id.equals(lockLogin.id) : lockLogin.id == null;

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
	
	@Override
	public String toString() {
		return "LockLogin{" +
				"id='" + id + '\'' +
				'}';
	}
}