package com.ws1001.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "kvarovi")
public class Kvar extends Model {

    @ManyToOne(targetEntity=Sala.class)
        @JoinColumn(name="id")
           private Sala sala;

    @OneToMany
    @JoinColumn(name="id", nullable = true)
        private List<User> uociliNastavnici = new ArrayList<>();
 
    @OneToMany
    @JoinColumn(name="id", nullable = true)
        private List<Rezervacija> rezervacije = new ArrayList<>();

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

public List<User> getUociliNastavnici() {
		return uociliNastavnici;
	}

public void setUociliNastavnici(List<User> uociliNastavnici) {
		this.uociliNastavnici = uociliNastavnici;
	}

public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
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