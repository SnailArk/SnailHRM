package com.snailark.snailhrm.web.action;

import org.apache.commons.lang.StringUtils;

import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.ExceptionCategory;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.model.RoleVO;
import com.snailark.snailhrm.service.ConfigurationService;

public class UpdateRoleAction extends BaseActionSupport {
	private RoleVO roleVO;
	private int id;
	
	public RoleVO getRoleVO() {
		return roleVO;
	}
	public void setRoleVO(RoleVO roleVO) {
		this.roleVO = roleVO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() {
		ConfigurationService configurationService = new ConfigurationService();
		if (SUBMIT.equals(getSubmit())) {
			try {
				configurationService.updateRole(roleVO);
			} catch (SystemException e) {
				addActionError(ExceptionCategory.SYSTEM.getMessage());
				return ERROR;
			} catch (BizException e) {
				addActionError(ExceptionCategory.ROLE_ALREADY_EXISTS.getMessage());
				return ERROR;
			}
			return SUCCESS;
		} else {
			RoleVO roleVO = new RoleVO();
			roleVO.setId(getId());
			try {
				
			roleVO = configurationService.findRoleById(roleVO);
			} catch(SystemException se) {
				addActionError(ExceptionCategory.SYSTEM.getMessage());
			}
			setRoleVO(roleVO);
			return "update";
		}
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
