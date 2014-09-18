package com.snailark.snailhrm;

public enum ExceptionCategory {
	SYSTEM("System Error: Contact to your system administrator"), BIZ("Bisuness Exception");

	private String message;

	private ExceptionCategory(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
