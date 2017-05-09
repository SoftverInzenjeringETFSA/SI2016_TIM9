package com.ws1001.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "rasporedi")
public class Raspored extends Model {

	@Column(name = "datumPocetka")
	private Date datumPocetka;

	@Column(name = "datumKraja")
	private Date datumKraja;

public Date getDatumPocetka() {
		return datumPocetka;
	}

public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

public Date getDatumKraja() {
		return datumKraja;
	}

public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}




}