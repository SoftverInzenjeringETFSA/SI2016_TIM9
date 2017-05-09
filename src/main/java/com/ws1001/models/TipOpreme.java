package com.ws1001.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "tipoviOpreme")
public class TipOpreme extends Model {

@Column(name = "sifra", unique = true)
	private Integer sifra;

@Column(name = "naziv")
	private String naziv;

public Integer getSifra() {
		return sifra;
	}

public void setSifra(Integer sifra) {
		this.sifra = sifra;
	}

public String getNaziv(){
	return naziv;
}

public void setNaziv(String naziv){
	this.naziv = naziv;
}



}