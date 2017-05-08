package com.ws1001.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import java.sql.Time;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "kvarovi")
public class Kvar extends Model {

@ManyToOne(targetEntity=Sala.class)
   // @JoinColumn(name="id")
    private Sala sala;

@OneToMany //(nullable = true)
private List<User> uocioNastavnik = new ArrayList<>();

//@OneToMany(nullable = true)
//private List<Rezervacija> rezervacija = new ArrayList<>();

@Column(name = "opis")
	private String opis;

@Column(name = "vrijemeBiljeske")
	private Time vrijemeBiljeske;

@Column(name="otkrivenNaknadno")
private Byte otkrivenNaknadno;

public Sala getSala() {
		return sala;
	}

public void setSala(Sala sala) {
		this.sala = sala;
	}

public String getOpis() {
		return opis;
	}

public void setOpis(String opis) {
		this.opis = opis;
	}

public Time getVrijemeBiljeske() {
		return vrijemeBiljeske;
	}

public void setVrijemeBiljeske(Time vrijemeBiljeske) {
		this.vrijemeBiljeske = vrijemeBiljeske;
	}

public Byte getOtkrivenNaknadno() {
		return otkrivenNaknadno;
	}

public void setotkrivenNaknadno(Byte otkrivenNaknadno) {
		this.otkrivenNaknadno = otkrivenNaknadno;
	}

}