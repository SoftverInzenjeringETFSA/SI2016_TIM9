package com.ws1001.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "korisnici")
public class User extends Model {
	@Column(name = "ime")
	private String firstName;
	
	@Column(name = "prezime")
	private String lastName;
	
	@Column(name = "korisnicko_ime")
	private String username;
	
	@Column(name = "lozinka")
	private String password;
	
	@Column(name = "tip")
	private byte type;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}
}
