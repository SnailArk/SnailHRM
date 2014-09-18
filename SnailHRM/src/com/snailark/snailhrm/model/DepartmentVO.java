package com.snailark.snailhrm.model;

public class DepartmentVO extends ValueObject {
	private String departmentName;
	private String notes;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
