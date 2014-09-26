package com.snailark.snailhrm.web.action;

import java.util.Calendar;
import java.util.Date;

import com.snailark.snailhrm.BizException;
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
			}
		}
		return "addRole";
	}
}
