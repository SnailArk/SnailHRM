package com.snailark.snailhrm;

public class SystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ExceptionCategory exceptionCategory;
	public SystemException(ExceptionCategory exceptionCategory) {
		
		this.exceptionCategory = exceptionCategory;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ExceptionCategory getExceptionCategory() {
		return exceptionCategory;
	}
	

}
