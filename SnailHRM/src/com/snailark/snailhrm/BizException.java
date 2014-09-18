package com.snailark.snailhrm;

public class BizException extends Exception{

	private static final long serialVersionUID = 1L;

	private ExceptionCategory exceptionCategory;
	
	public BizException(ExceptionCategory exceptionCategory) {
		this.exceptionCategory = exceptionCategory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ExceptionCategory getExceptionCategory() {
		return exceptionCategory;
	}
	
    	
}
