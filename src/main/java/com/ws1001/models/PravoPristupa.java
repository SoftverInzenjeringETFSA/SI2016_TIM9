package com.ws1001.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "prava_pristupa")
public class PravoPristupa extends Model {
    
    @OneToMany
    private List<Sala> sale = new ArrayList<>();

    @OneToOne
    private User korisnik;
	
}