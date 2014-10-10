package com.snailark.snailhrm.web.action;

import java.util.List;

import org.hibernate.HibernateException;

import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.model.EmployeeVO;
import com.snailark.snailhrm.service.ConfigurationService;

public class SearchEmployeeAction extends BaseActionSupport {
	private EmployeeVO employeeVO;
	private List<EmployeeVO> employeeList;

	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(
			EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}

	public List<EmployeeVO> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeVO> employeeList) {
		this.employeeList = employeeList;
	}

	public String execute() {
		String retVal = SUCCESS;
		ConfigurationService configurationService = new ConfigurationService();
		if(SUBMIT.equals(getSubmit())) {
			try {
				employeeList = configurationService.searchEmployee(employeeVO);
			} catch(SystemException se) {
				addActionError(se.getExceptionCategory().getMessage());
				retVal = ERROR;
			}
		} else {
			
		try {
			
			employeeList =  configurationService.searchEmployee(employeeVO);
		} catch(SystemException se) {
			addActionError(se.getExceptionCategory().getMessage());
			retVal = ERROR;
		}
		
		}
		return retVal;
	}

}
