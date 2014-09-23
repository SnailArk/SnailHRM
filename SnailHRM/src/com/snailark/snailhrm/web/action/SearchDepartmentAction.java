package com.snailark.snailhrm.web.action;

import java.util.List;

import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.service.ConfigurationService;

public class SearchDepartmentAction extends BaseActionSupport {
	
	private DepartmentVO departmentVO;
	private List<DepartmentVO> listDepartment ;

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public List<DepartmentVO> getListDepartment() {
		return listDepartment;
	}

	public void setListDepartment(List<DepartmentVO> listDepartment) {
		this.listDepartment = listDepartment;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}
	
	public String execute() {
		ConfigurationService configurationService = new ConfigurationService();
		listDepartment =  configurationService.searchDepartment();
		return SUCCESS;
	}
	
}
