package com.snailark.snailhrm.web.action;


import org.apache.commons.lang.StringUtils;

import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.service.ConfigurationService;

public class UpdateDepartmentAction extends BaseActionSupport {
	private static final long serialVersionUID = 1L;

	// DepartmentVO reference interact by struts
	private DepartmentVO departmentVO;
	private int id;

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
		ConfigurationService configurationService = new ConfigurationService();
		if (SUBMIT.equals(getSubmit())) {
			try {
				configurationService.updateDepartment(departmentVO);
			} catch (SystemException e) {
				addActionError("Error while saving the department.");
				return ERROR;
			} catch (BizException e) {
				addActionError("Department name already exist");
				return ERROR;
			}
			return SUCCESS;
		} else {
			DepartmentVO departmentVO = new DepartmentVO();
			departmentVO.setId(getId());
			departmentVO = configurationService
					.findDepartmentById(departmentVO);
			setDepartmentVO(departmentVO);
			return "update";
		}
	}

	@Override
	public void validate() {
		super.validate();
		if (SUBMIT.equals(getSubmit())) {
			if (StringUtils.isEmpty(departmentVO.getDepartmentName())) {
				addFieldError("departmentVO.departmentName",
						"Department name cannot be blank.");
			} else {
				if (!StringUtils.isAlphaSpace(departmentVO.getDepartmentName())) {
					addFieldError("departmentVO.departmentName",
							"Department name cannot contain numeric and special characters");
				}
			}
		}

	}
}