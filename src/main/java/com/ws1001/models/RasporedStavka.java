package com.ws1001.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "rasporedStavke")
public class RasporedStavka extends Model {

	@ManyToOne(targetEntity=Raspored.class)
       @JoinColumn(name="id", nullable = false)
           private Raspored raspored;


public Raspored getRaspored() {
		return raspored;
	}

public void setRaspored(Raspored raspored) {
		this.raspored = raspored;
	}



 }