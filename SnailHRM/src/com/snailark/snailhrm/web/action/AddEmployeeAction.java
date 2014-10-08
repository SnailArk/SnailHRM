package com.snailark.snailhrm.web.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;

import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.ExceptionCategory;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.model.AddressType;
import com.snailark.snailhrm.model.AddressVO;
import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.model.EmployeeJobDetailsVO;
import com.snailark.snailhrm.model.EmployeeVO;
import com.snailark.snailhrm.model.RoleVO;
import com.snailark.snailhrm.service.ConfigurationService;
import com.snailark.snailhrm.web.util.Option;

public class AddEmployeeAction extends BaseActionSupport {
	private EmployeeVO employeeVO;
	private AddressVO communicationAddressVO;
	private AddressVO permanentAddressVO;
	private EmployeeJobDetailsVO jobVO;
	private int id;
	private List<Option> departmentOptionList = new ArrayList<Option>();
	private List<Option> roleOptionList = new ArrayList<Option>();
		
	public AddEmployeeAction() {
	}
	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}

	public AddressVO getCommunicationAddressVO() {
		return communicationAddressVO;
	}

	public void setCommunicationAddressVO(AddressVO communicationAddressVO) {
		this.communicationAddressVO = communicationAddressVO;
	}

	public AddressVO getPermanentAddressVO() {
		return permanentAddressVO;
	}

	public void setPermanentAddressVO(AddressVO permanentAddressVO) {
		this.permanentAddressVO = permanentAddressVO;
	}

	public EmployeeJobDetailsVO getJobVO() {
		return jobVO;
	}

	public void setJobVO(EmployeeJobDetailsVO jobVO) {
		this.jobVO = jobVO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public List<Option> getDepartmentOptionList() {
		return departmentOptionList;
	}
	public void setDepartmentOptionList(List<Option> departmentOptionList) {
		this.departmentOptionList = departmentOptionList;
	}
	public List<Option> getRoleOptionList() {
		return roleOptionList;
	}
	public void setRoleOptionList(List<Option> roleOptionList) {
		this.roleOptionList = roleOptionList;
	}
	
	@Override
	public String execute() {
		String retVal = "addEmployee";
		setView();
		if (SUBMIT.equals(getSubmit())) {
			try {
				ConfigurationService configurationService = new ConfigurationService();
				Set<AddressVO> addressSet = new HashSet<AddressVO>();
				communicationAddressVO.setAddressType(AddressType.COMMUNICATION.toString());
				permanentAddressVO.setAddressType(AddressType.PERMANENT.toString());
				addressSet.add(communicationAddressVO);
				addressSet.add(permanentAddressVO);
				employeeVO.setAddresses(addressSet);
				
				Set<EmployeeJobDetailsVO> jobSet = new HashSet<EmployeeJobDetailsVO>();
				jobSet.add(jobVO);
				employeeVO.setJobDetails(jobSet);
				employeeVO.setStatus(true);
				
				configurationService.addEmployee(employeeVO);
				this.setId(employeeVO.getId());
				retVal = SUCCESS;
			} catch (BizException se) { // catch exception work have to do.
				addActionError(se.getExceptionCategory().getMessage());
				retVal = ERROR;
			} catch(SystemException se) {
				addActionError(ExceptionCategory.SYSTEM.getMessage());
				retVal = ERROR;
			}
		}
		return retVal;
	}

	private void setView() {
		ConfigurationService configurationService = new ConfigurationService();
		List<DepartmentVO> departmentList = new ArrayList<DepartmentVO>();
		try {
		departmentList = configurationService.searchDepartment();
		} catch(SystemException se) {
			addActionError(ExceptionCategory.SYSTEM.getMessage());
		}
		Option option = new Option();
		option.setLabel("Select Department");
		option.setValue(-1);
		departmentOptionList.add(option);
		for(DepartmentVO departmentVO : departmentList) {
			option = new Option();
			option.setLabel(departmentVO.getDepartmentName());
			option.setValue(departmentVO.getId());
			departmentOptionList.add(option);
		}
		List<RoleVO> roleList = new ArrayList<RoleVO>();
		try {
			
		roleList = configurationService.searchRole();
		} catch(SystemException se) {
			addActionError(ExceptionCategory.SYSTEM.getMessage());
		}
		option = new Option();
		option.setLabel("Select Role");
		option.setValue(-1);
		roleOptionList.add(option);
		for(RoleVO roleVO : roleList) {
			option = new Option();
			option.setLabel(roleVO.getRoleName());
			option.setValue(roleVO.getId());
			roleOptionList.add(option);
		}
	}

	@Override
	public void validate() {
		super.validate();
		if (SUBMIT.equals(getSubmit())) {
		/*	if (StringUtils.isEmpty(departmentVO.getDepartmentName())) {
				addFieldError("departmentVO.departmentName",
						"Department name cannot be blank.");
			} else {
				if (!StringUtils.isAlphaSpace(departmentVO.getDepartmentName())) {
					addFieldError("departmentVO.departmentName",
							"Department name cannot contain numeric and special characters");
				}
			}
*/
			
				//addFieldError("jobVO.department.id",
						//"hello");
			
			
		if(hasFieldErrors() || hasActionErrors()) {
		setView();
		}
		}
	}
}
