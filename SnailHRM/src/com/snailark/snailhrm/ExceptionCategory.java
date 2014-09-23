package com.snailark.snailhrm;

public enum ExceptionCategory {
	SYSTEM("System Error: Contact to your system administrator"), 
	BIZ("Bisuness Exception"), 
	DATABASE_UPDATE_EXCEPTION("Error while updating the record in database."),
	DEPARTMENT_ALREADY_EXISTS("Department name already exists");

	private String message;

	private ExceptionCategory(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
