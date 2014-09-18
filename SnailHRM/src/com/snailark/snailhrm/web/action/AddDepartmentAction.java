package com.snailark.snailhrm.web.action;

import com.snailark.snailhrm.model.DepartmentVO;

public class AddDepartmentAction extends BaseActionSupport {

		
	private static final long serialVersionUID = 1L;
	
	// DepartmentVO reference interact by struts 
	private DepartmentVO departmentVO;

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (SUBMIT.equals("submit")) {
			return SUCCESS;

		}
		return SUCCESS;
	}

	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		// validation for department name field
		if (departmentVO.getDepartmentName() == null || "".equals(departmentVO.getDepartmentName())) {
			addFieldError("departmentVO.departmentName","Department name cannot blank");
		}
 
		// validation fot notes field
		if (departmentVO.getNotes() == null || "".equals(departmentVO.getNotes())) {
			addFieldError("departmentVO.notes", "Notes cannot be blank");
		}
	}
}