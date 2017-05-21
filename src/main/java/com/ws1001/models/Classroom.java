package com.ws1001.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Classroom extends BaseModel {
	public enum ClassroomType { Ordinary, Amphitheater, Laboratory, Office };
	public enum StatusType { InUse, Nonfunctional, WorkInProgess };

	private String name;
	private User teacherInCharge;
	private ClassroomType type;
	private StatusType status;
	private int seatCount;
	private int keyCount;
	private int takenKeyCount;
	private List<AccessGrant> accessGrants = new ArrayList<AccessGrant>();
	private List<ClassroomEquipment> equipment = new ArrayList<ClassroomEquipment>();
	private List<DamageReport> damageReports = new ArrayList<DamageReport>();
	private List<Reservation> reservations = new ArrayList<Reservation>();

	@Column(unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(optional = true)
	public User getTeacherInCharge() {
		return teacherInCharge;
	}

	public void setTeacherInCharge(User teacherInCharge) {
		this.teacherInCharge = teacherInCharge;
	}

	@Column(nullable = false)
	public ClassroomType getType() {
		return type;
	}

	public void setType(ClassroomType type) {
		this.type = type;
	}

	@Column(nullable = false)
	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	@Column(nullable = false)
	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	@Column(nullable = false)
	public int getKeyCount() {
		return keyCount;
	}

	public void setKeyCount(int keyCount) {
		this.keyCount = keyCount;
	}

	@Column(nullable = false)
	public int getTakenKeyCount() {
		return takenKeyCount;
	}

	public void setTakenKeyCount(int takenKeyCount) {
		this.takenKeyCount = takenKeyCount;
	}
	
	@OneToMany(mappedBy = "classroom")
	public List<AccessGrant> getAccessGrants() {
		return accessGrants;
	}

	public void setAccessGrants(List<AccessGrant> accessGrants) {
		this.accessGrants = accessGrants;
	}
	
	@OneToMany(mappedBy = "classroom")
	public List<ClassroomEquipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<ClassroomEquipment> equipment) {
		this.equipment = equipment;
	}

	@OneToMany(mappedBy = "classroom")
	public List<DamageReport> getDamageReports() {
		return damageReports;
	}

	public void setDamageReports(List<DamageReport> damageReports) {
		this.damageReports = damageReports;
	}

	@OneToMany(mappedBy = "classroom")
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
