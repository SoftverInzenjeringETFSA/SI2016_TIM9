package com.ws1001.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;



@Entity
@Table(name = "rezervacije")
public class Rezervacija extends Model {

@OneToOne
private Sala sala;

@OneToOne
private User korisnik;

@OneToMany
@JoinColumn(name="id", nullable = true)
private List<RasporedStavka> rasporedStavka = new ArrayList<>();

@Column(name = "vrijemeRezervacije")
	private Time vrijemeRezervacije;

@Column(name = "trajanje")
	private byte trajanje;

public Sala getSala() {
		return sala;
	}

public void setSala(Sala sala) {
		this.sala = sala;
	}

public User getKorisnik() {
		return korisnik;
	}

public void setKorisnik(User korisnik) {
		this.korisnik = korisnik;
	}

public List<RasporedStavka> getRasporedStavka() {
		return rasporedStavka;
	}

public void setRasporedStavka(List<RasporedStavka> rasporedStavka) {
		this.rasporedStavka = rasporedStavka;
	}

public Time getVrijemeRezervacije() {
		return vrijemeRezervacije;
	}

public void setVrijemeRezervacije(Time vrijemeRezervacije) {
		this.vrijemeRezervacije = vrijemeRezervacije;
	}

public byte getTrajanje() {
		return trajanje;
	}

public void setTrajanje(byte trajanje) {
		this.trajanje = trajanje;
	}


}