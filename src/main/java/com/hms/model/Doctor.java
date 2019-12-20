package com.hms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Doctor {

	private Integer docId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String mobile;
	private Date dob;
	private Date joinDate;
	private Date releaseDate;
	private Address address;
	private List<Qualification> qualifications;
	private List<Specialization> specializations;
	private List<Membership> memberships;
	private List<Award> awards;
	private List<Publication> publications;
	private String status;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_qualification", joinColumns = { @JoinColumn(name = "docId") }, inverseJoinColumns = {
			@JoinColumn(name = "qId") })
	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_specializatio", joinColumns = { @JoinColumn(name = "docId") }, inverseJoinColumns = {
			@JoinColumn(name = "specId") })
	public List<Specialization> getSpecializations() {
		return specializations;
	}

	public void setSpecializations(List<Specialization> specializations) {
		this.specializations = specializations;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_membership", joinColumns = { @JoinColumn(name = "docId") }, inverseJoinColumns = {
			@JoinColumn(name = "memId") })
	public List<Membership> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<Membership> memberships) {
		this.memberships = memberships;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_award", joinColumns = { @JoinColumn(name = "docId") }, inverseJoinColumns = {
			@JoinColumn(name = "awdId") })
	public List<Award> getAwards() {
		return awards;
	}

	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_publication", joinColumns = { @JoinColumn(name = "docId") }, inverseJoinColumns = {
			@JoinColumn(name = "pubId") })
	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
