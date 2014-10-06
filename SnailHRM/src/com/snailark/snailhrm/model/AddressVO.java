package com.snailark.snailhrm.model;

public class AddressVO extends ValueObject {
	private EmployeeVO employee;
	private String street;
	private String country;
	private String state;
	private String city;
	private String addressType;
	
	public EmployeeVO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeVO employee) {
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
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
}
