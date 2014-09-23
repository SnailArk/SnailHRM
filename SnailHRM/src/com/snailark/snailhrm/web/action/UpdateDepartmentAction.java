package com.snailark.snailhrm.web.action;

import org.apache.commons.lang.StringUtils;

import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.service.ConfigurationService;

public class UpdateDepartmentAction extends BaseActionSupport {
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
	public String execute() {
		if (SUBMIT.equals("submit")) {
			ConfigurationService configurationService = new ConfigurationService();
			try {
				configurationService.updateDepartment(departmentVO);
			} catch (SystemException e) {
				addActionError("Error while saving the department.");
				return ERROR;
			}
			return SUCCESS;
		}
		return ERROR;
	}

	@Override
	public void validate() {
		super.validate();
		if (SUBMIT.equals(getSubmit())) {
			if (StringUtils.isEmpty(departmentVO.getDepartmentName())) {
				addFieldError("departmentVO.getDepartmentName()",
						"Please enter department name");
			} else {
				if (!StringUtils.isAlphaSpace(departmentVO.getDepartmentName())) {
					addFieldError("departmentVO.getDepartmentName()",
							"Please enter department name correctly");
				}
			}
		}

	}
}