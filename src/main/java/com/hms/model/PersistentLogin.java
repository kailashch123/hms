package com.hms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PersistentLogin {

	private String series;
	private String username;
	private String token;
	private Date last_used;

	@Id
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	@Column(unique = true, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(unique = true, nullable = false)
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLast_used() {
		return last_used;
	}

	public void setLast_used(Date last_used) {
		this.last_used = last_used;
	}

}
