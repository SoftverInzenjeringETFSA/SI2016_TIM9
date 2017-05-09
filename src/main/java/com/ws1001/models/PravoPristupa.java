package com.ws1001.models;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@Table(name = "prava_pristupa")
public class PravoPristupa extends Model {
    
    @OneToMany
    private List<Sala> sale = new ArrayList<>();

    @OneToOne
    private User korisnik;

    public User getKorisnik() {
		return korisnik;
	    }

    public void setKorisnik(User korisnik) {
		this.korisnik = korisnik;
	    }

	public List<Sala> getSale() {
		return sale;
	    }

    public void setSale(List<Sala> sale) {
		this.sale = sale;
	    }


	
}