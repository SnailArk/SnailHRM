package com.snailark.snailhrm.web.action;

import java.util.List;

import com.snailark.snailhrm.ExceptionCategory;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.model.RoleVO;
import com.snailark.snailhrm.service.ConfigurationService;

public class SearchRoleAction extends BaseActionSupport {
	
	private RoleVO roleVO;
	private List<RoleVO> listRole;
	public RoleVO getRoleVO() {
		return roleVO;
	}
	public void setRoleVO(RoleVO roleVO) {
		this.roleVO = roleVO;
	}
	public List<RoleVO> getListRole() {
		return listRole;
	}
	public void setListRole(List<RoleVO> listRole) {
		this.listRole = listRole;
	}
	public String execute() {
		ConfigurationService configurationService = new ConfigurationService();
		try {
			
			listRole =  configurationService.searchRole();
		} catch(SystemException se) {
			addActionError(ExceptionCategory.SYSTEM.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

}
