package com.ws1001.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;


@Entity
@Table(name = "sale")
public class Sala extends Model {

@OneToMany//(nullable = true)
private List<User> odgovorniNastavnici = new ArrayList<>();

@Column(name="naziv", unique = true)
	private String naziv;	

@Column(name="tip")
	private Byte tip;	

@Column(name="status")
	private Byte status;	

@Column(name="brojMjesta")
	private Integer brojMjesta;	

@Column(name="brojKljuceva")
	private Integer brojKljuceva;	

@Column(name="brojZaduzenihKljuceva")
	private Integer brojZaduzenihKljuceva;	

public List<User> getOdgovorniNastavnici() {
		return odgovorniNastavnici;
	}

public void setOdgovorniNastavnici(List<User> odgovorniNastavnici) {
		this.odgovorniNastavnici = odgovorniNastavnici;
	}

	
public String getNaziv() {
		return naziv;
	}

public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

public Byte getTip() {
		return tip;
	}

public void setTip(Byte tip) {
		this.tip = tip;
	}

public Byte getStatus() {
		return status;
	}

public void setStatus(Byte status) {
		this.status = status;
	}

public Integer getBrojMjesta() {
		return brojMjesta;
	}

public void setBrojMjesta(Integer brojMjesta) {
		this.brojMjesta = brojMjesta;
	}

public Integer getBrojKljuceva() {
		return brojKljuceva;
	}

public void setBrojKljuceva(Integer brojKljuceva) {
		this.brojKljuceva = brojKljuceva;
	}

public Integer getBrojZaduzenihKljuceva() {
		return brojZaduzenihKljuceva;
	}

public void setBrojZaduzenihKljuceva(Integer brojZaduzenihKljuceva) {
		this.brojZaduzenihKljuceva = brojZaduzenihKljuceva;
	}

}