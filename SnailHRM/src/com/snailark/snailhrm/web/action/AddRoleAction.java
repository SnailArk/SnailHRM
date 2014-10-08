package com.snailark.snailhrm.web.action;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.ExceptionCategory;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.model.RoleVO;
import com.snailark.snailhrm.service.ConfigurationService;

public class AddRoleAction extends BaseActionSupport {
	
	private int id;
	private RoleVO roleVO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RoleVO getRoleVO() {
		return roleVO;
	}
	public void setRoleVO(RoleVO roleVO) {
		this.roleVO = roleVO;
	}
	
	public String execute() {
		String retVal = "addRole";
		if (SUBMIT.equals(getSubmit())) {
			Calendar calendar = Calendar.getInstance();
			Date createdDate = calendar.getTime();
			roleVO.setCreatedDate(createdDate);
			
			ConfigurationService configurationService = new ConfigurationService();
			try {
				configurationService.addRole(roleVO);
				this.setId(roleVO.getId());
				retVal = SUCCESS;
			} catch (BizException se) {
				addActionError(se.getExceptionCategory().getMessage());
				retVal = ERROR;
			} catch(SystemException se) {
				addActionError(ExceptionCategory.SYSTEM.getMessage());
				retVal = ERROR;
			}
		}
		return retVal;
	}
	
	@Override
	public void validate() {
		super.validate();
		if (SUBMIT.equals(getSubmit())) {
			if (StringUtils.isEmpty(roleVO.getRoleName())) {
				addFieldError("roleVO.roleName", "Role name cannot be blank.");
			} else {
				if (!StringUtils.isAlphaSpace(roleVO.getRoleName())) {
					addFieldError("roleVO.roleName", "Role name cannot contain numeric and special characters");
				}
			}
		}
	}
}
