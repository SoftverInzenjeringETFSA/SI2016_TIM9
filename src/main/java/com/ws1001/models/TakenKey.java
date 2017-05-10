package com.ws1001.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class TakenKey extends Model {
	private Reservation reservation;
	private Date takenAt;
	private Date returnedAt;

	@OneToOne(optional = false)
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	@NotNull
	public Date getTakenAt() {
		return takenAt;
	}

	public void setTakenAt(Date takenAt) {
		this.takenAt = takenAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getReturnedAt() {
		return returnedAt;
	}

	public void setReturnedAt(Date returnedAt) {
		this.returnedAt = returnedAt;
	}
}
