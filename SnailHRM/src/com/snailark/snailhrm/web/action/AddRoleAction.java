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
		if (SUBMIT.equals(getSubmit())) {
			Calendar calendar = Calendar.getInstance();
			Date createdDate = calendar.getTime();
			roleVO.setCreatedDate(createdDate);
			
			ConfigurationService configurationService = new ConfigurationService();
			try {
				configurationService.addRole(roleVO);
				this.setId(roleVO.getId());
				return SUCCESS;
			} catch (BizException se) {
				addActionError(se.getExceptionCategory().getMessage());
				return ERROR;
			} catch(SystemException se) {
				addActionError(ExceptionCategory.SYSTEM.getMessage());
				return ERROR;
			}
		}
		return "addRole";
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
