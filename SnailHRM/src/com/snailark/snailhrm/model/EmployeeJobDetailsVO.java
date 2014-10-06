package com.snailark.snailhrm.model;

import java.util.Date;

public class EmployeeJobDetailsVO extends ValueObject {
	private EmployeeVO employee;
	private DepartmentVO department;
	private RoleVO role;
	private Date dateOfJoining;

	public EmployeeVO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeVO employee) {
		this.employee = employee;
	}
	public DepartmentVO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}
	public RoleVO getRole() {
		return role;
	}
	public void setRole(RoleVO role) {
		this.role = role;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
