package com.snailark.snailhrm.web.action;

import java.util.List;

import org.hibernate.HibernateException;

import com.snailark.snailhrm.ExceptionCategory;
import com.snailark.snailhrm.SystemException;
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
		String retVal = SUCCESS;
		ConfigurationService configurationService = new ConfigurationService();
		try {
			
			listDepartment =  configurationService.searchDepartment();
		} catch(SystemException se) {
			addActionError(ExceptionCategory.SYSTEM.getMessage());
			retVal = ERROR;
		}
		return retVal;
	}
	
}
