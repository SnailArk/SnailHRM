package com.snailark.snailhrm.web.action;

import org.apache.commons.lang.StringUtils;


import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.service.ConfigurationService;

public class AddDepartmentAction extends BaseActionSupport {

	private static final long serialVersionUID = 1L;

	// DepartmentVO reference interact by struts
	private DepartmentVO departmentVO;
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	@Override
	public String execute() {
		if ((getSubmit() != null) && SUBMIT.equals(getSubmit())) {
			ConfigurationService configurationService = new ConfigurationService();
			try {
				configurationService.addDepartment(departmentVO);
				this.setId(departmentVO.getId());
				return SUCCESS;
			} catch (BizException se) {
				addActionError(se.getExceptionCategory().getMessage());
				return ERROR;
			}
		}
		return "addDepartment";
	}

	@Override
	public void validate() {
		super.validate();
		if (SUBMIT.equals(getSubmit())) {
			if (StringUtils.isEmpty(departmentVO.getDepartmentName())) {
				addFieldError("departmentVO.departmentName", "Department name cannot be blank.");
			} else {
				if (!StringUtils.isAlphaSpace(departmentVO.getDepartmentName())) {
					addFieldError("departmentVO.departmentName", "Department name cannot contain numeric and special characters");
				}
			}
			
			if(StringUtils.length(departmentVO.getNotes()) > 1000) {
				addFieldError("departmentVO.notes", "Notes cannot be exceed 1000 characters");
			}
		}

	}
}
