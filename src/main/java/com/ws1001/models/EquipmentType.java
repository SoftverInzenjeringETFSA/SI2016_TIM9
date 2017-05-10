package com.ws1001.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class EquipmentType extends Model {
	private int label;
	private String name;

	@Column(unique = true, nullable = false)
	@NotNull
	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	@Column(nullable = false)
	@NotNull
	@Size(min = 1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
