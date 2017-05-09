package com.ws1001.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User extends Model {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private byte type;
	private List<AccessGrant> accessGrants = new ArrayList<AccessGrant>();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private List<DamageReport> damageReports = new ArrayList<DamageReport>();

	@Column(nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(unique = true, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}
	
	@OneToMany(mappedBy = "teacher")
	public List<AccessGrant> getAccessGrants() {
		return accessGrants;
	}

	public void setAccessGrants(List<AccessGrant> accessGrants) {
		this.accessGrants = accessGrants;
	}

	@OneToMany(mappedBy = "teacher")
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@OneToMany(mappedBy = "reportedBy")
	public List<DamageReport> getDamageReports() {
		return damageReports;
	}

	public void setDamageReports(List<DamageReport> damageReports) {
		this.damageReports = damageReports;
	}
}
