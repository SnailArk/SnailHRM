package com.snailark.snailhrm.web.action;


import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;

import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.ExceptionCategory;
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
		String retVal = "update"; 
		ConfigurationService configurationService = new ConfigurationService();
		if (SUBMIT.equals(getSubmit())) {
			try {
				configurationService.updateDepartment(departmentVO);
				retVal = SUCCESS;
			} catch (SystemException e) {
				addActionError(ExceptionCategory.SYSTEM.getMessage());
				retVal = ERROR;
			} catch (BizException e) {
				addActionError(ExceptionCategory.DEPARTMENT_ALREADY_EXISTS.getMessage());
				retVal = ERROR;
			} 
		} else {
			DepartmentVO departmentVO = new DepartmentVO();
			departmentVO.setId(getId());
			try {
				
			departmentVO = configurationService.findDepartmentById(departmentVO);
			} catch(SystemException se) {
				addActionError(ExceptionCategory.SYSTEM.getMessage());
				retVal = ERROR;
			}
			setDepartmentVO(departmentVO);
		}
		return retVal;
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