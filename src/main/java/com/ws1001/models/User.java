package com.ws1001.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "korisnici")
public class User extends Model {
	private String ime;
	private String prezime;
	private String korisnicko_ime;
	private String lozinka;
	private byte tip;
	
	public User(String ime, String prezime, String korisnicko_ime, String lozinka, byte tip) {
		this.ime = ime;
		this.prezime = prezime;
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
		this.tip = tip;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}

	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public byte getTip() {
		return tip;
	}

	public void setTip(byte tip) {
		this.tip = tip;
	}
	
	
}
