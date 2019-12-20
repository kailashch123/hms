package com.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Specialization {

	private Integer specId;
	private String name;	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSpecId() {
		return specId;
	}

	public void setSpecId(Integer specId) {
		this.specId = specId;
	}

	@NotEmpty(message = "Specialization name can not be empty")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
