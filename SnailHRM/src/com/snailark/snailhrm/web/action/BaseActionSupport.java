package com.snailark.snailhrm.web.action;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseActionSupport extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String submit;
	public static String SUBMIT = "submit";

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
	

}
