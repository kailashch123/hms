package com.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Award {

	private Integer awdId;
	private String name;
	private Integer year;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAwdId() {
		return awdId;
	}

	public void setAwdId(Integer awdId) {
		this.awdId = awdId;
	}

	@NotEmpty(message = "Award name can not be empty")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty(message = "Award year can not be empty")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	

}
