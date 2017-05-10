package com.ws1001.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class User extends Model {
	public enum UserType { Teacher, Operator, Admin };

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private UserType type;
	private List<AccessGrant> accessGrants = new ArrayList<AccessGrant>();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private List<DamageReport> damageReports = new ArrayList<DamageReport>();

	@Column(nullable = false)
	@NotNull
	@Pattern(regexp = "[a-z]+")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(nullable = false)
	@NotNull
	@Pattern(regexp = "[a-z]+")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(unique = true, nullable = false)
	@NotNull
	@Pattern(regexp = "[a-z0-9]+")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(nullable = false)
	@NotNull
	@Size(min = 6)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = false)
	@NotNull
	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
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
