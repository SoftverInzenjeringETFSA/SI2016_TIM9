package com.ws1001.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;



@Entity
@Table(name = "saleOpreme")
public class SalaOprema extends Model {

@ManyToOne(targetEntity=TipOpreme.class)
    @JoinColumn(name="id")
    private TipOpreme tipOpreme;

@ManyToOne(targetEntity=Sala.class)
    @JoinColumn(name="id")
    private Sala sala;


@Column(name = "kolicina")
	private Integer kolicina;

public TipOpreme getTipOpreme() {
		return tipOpreme;
	}

public void setTipOpreme(TipOpreme tipOpreme) {
		this.tipOpreme = tipOpreme;
	}

public Sala getSala() {
		return sala;
	}

public void setSala(Sala sala) {
		this.sala = sala;
	}

public Integer getKolicina() {
		return kolicina;
	}

public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}


}