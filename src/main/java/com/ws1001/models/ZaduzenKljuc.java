package com.ws1001.models;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToOne;




@Entity
@Table(name = "zaduzeniKljucevi")
public class ZaduzenKljuc extends Model {

@OneToOne
private Rezervacija rezervacija; 

@Column(name = "vrijemeZaduzenja")
	private Time vrijemeZaduzenja;

@Column(name = "vrijemePovratka", nullable = true)
	private Time vrijemePovratka;

public Rezervacija getRezervacija() {
		return rezervacija;
	}

public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}

public Time getVrijemeZaduzenja() {
		return vrijemeZaduzenja;
	}

public void setVrijemeZaduzenja(Time vrijemeZaduzenja) {
		this.vrijemeZaduzenja = vrijemeZaduzenja;
	}

public Time getVrijemePovratka() {
		return vrijemePovratka;
	}

public void setVrijemePovratka(Time vrijemePovratka) {
		this.vrijemePovratka = vrijemePovratka;
	}





}