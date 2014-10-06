package com.snailark.snailhrm.model;

import java.util.Date;
import java.util.Set;

public class EmployeeVO extends ValueObject {
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String nationality;
	private String gender;
	private String phoneNumber;
	private String email;
	private boolean status;
	private Set<AddressVO> addresses;
	private Set<EmployeeJobDetailsVO> jobDetails;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<AddressVO> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressVO> addresses) {
		this.addresses = addresses;
	}

	public Set<EmployeeJobDetailsVO> getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(Set<EmployeeJobDetailsVO> jobDetails) {
		this.jobDetails = jobDetails;
	}
	
}
