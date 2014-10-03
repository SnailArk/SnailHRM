package com.snailark.snailhrm.model;

import java.util.Date;

public class EmployeeJobDetailsVO extends ValueObject {
	private EmployeePersonalDetailsVO employee;
	private String department;
	private String role;
	private Date dateOfJoining;

	public EmployeePersonalDetailsVO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeePersonalDetailsVO employee) {
		this.employee = employee;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
