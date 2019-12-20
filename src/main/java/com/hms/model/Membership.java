package com.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Membership {

	private Integer memId;
	private String orgName;
	private Integer joinYear;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	
	@NotEmpty(message = "Organization name can not be empty")
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@NotEmpty(message = "Join Year name can not be empty")
	public Integer getJoinYear() {
		return joinYear;
	}

	public void setJoinYear(Integer joinYear) {
		this.joinYear = joinYear;
	}

}
