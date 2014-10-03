package com.snailark.snailhrm.model;

public class EmployeeAddressDetailsVO extends ValueObject {
	private EmployeePersonalDetailsVO employee;
	private String street;
	private String country;
	private String state;
	private String city;
	
	public EmployeePersonalDetailsVO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeePersonalDetailsVO employee) {
		this.employee = employee;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
