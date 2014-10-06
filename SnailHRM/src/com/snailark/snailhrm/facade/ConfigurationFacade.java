package com.snailark.snailhrm.facade;


import java.util.List;

import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.ExceptionCategory;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.dao.DepartmentDAO;
import com.snailark.snailhrm.dao.EmployeeDAO;
import com.snailark.snailhrm.dao.RoleDAO;
import com.snailark.snailhrm.model.AddressVO;
import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.model.EmployeeJobDetailsVO;
import com.snailark.snailhrm.model.EmployeeVO;
import com.snailark.snailhrm.model.RoleVO;

public class ConfigurationFacade {

	public void addDepartment(DepartmentVO departmentVO) throws BizException {
		DepartmentDAO departmentDAO = new DepartmentDAO();
		if (departmentDAO.searchByDepartmentName(departmentVO) == null) {
			departmentDAO.save(departmentVO);
		}
		else {
			throw new BizException(ExceptionCategory.DEPARTMENT_ALREADY_EXISTS);
		}
	}

	public List<DepartmentVO> searchDepartment() {
		DepartmentDAO departmentDAO = new DepartmentDAO();
		List<DepartmentVO> searcheddepartmentName = departmentDAO.searchDepartment();
		return searcheddepartmentName;
	}


	public void updateDepartment(DepartmentVO departmentVO) throws SystemException, BizException {
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentVO savedVO = departmentDAO.searchByDepartmentName(departmentVO);
		
		if(savedVO == null){
			departmentDAO.update(departmentVO);
		} else if(savedVO.getId() == departmentVO.getId() ) {
			savedVO.setDepartmentName(departmentVO.getDepartmentName());
			savedVO.setNotes(departmentVO.getNotes());
			departmentDAO.update(savedVO);
		} else {
			throw new BizException(ExceptionCategory.DEPARTMENT_ALREADY_EXISTS);
		}
	}
	
	public DepartmentVO findDepartmentById(DepartmentVO departmentVO){
		DepartmentDAO departmentDAO = new DepartmentDAO();
		return (DepartmentVO)departmentDAO.findById(departmentVO);
	}
	
	public void addRole(RoleVO roleVO) throws BizException {
		RoleDAO roleDAO = new RoleDAO();
		if (roleDAO.searchByRoleName(roleVO) == null) {
			roleDAO.save(roleVO);
		}
		else {
			throw new BizException(ExceptionCategory.ROLE_ALREADY_EXISTS);
		}
	}

	public void updateRole(RoleVO roleVO) throws SystemException, BizException {
		RoleDAO roleDAO = new RoleDAO();
		RoleVO savedVO = roleDAO.searchByRoleName(roleVO);
		
		if(savedVO == null){
			roleDAO.update(roleVO);
		} else if(savedVO.getId() == roleVO.getId()) {
			savedVO.setRoleName(roleVO.getRoleName());
			savedVO.setRoleDescription(roleVO.getRoleDescription());
			roleDAO.update(savedVO);
		} else {
			throw new BizException(ExceptionCategory.ROLE_ALREADY_EXISTS);
		}
	}

	public RoleVO findRoleById(RoleVO roleVO) {
		RoleDAO roleDAO = new RoleDAO();
		return (RoleVO) roleDAO.findById(roleVO);
	}
	
	public List<RoleVO> searchRole() {
		RoleDAO roleDAO = new RoleDAO();
		List<RoleVO> searchedRoleName = roleDAO.searchRole();
		return searchedRoleName;
	}

	public void addEmployee(EmployeeVO employeeVO) throws BizException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		if (employeeDAO.searchByEmailId(employeeVO) == null) {
			for(AddressVO addVo : employeeVO.getAddresses()) {
				addVo.setEmployee(employeeVO);			
			}
			for(EmployeeJobDetailsVO jobVO : employeeVO.getJobDetails()) {
				jobVO.setEmployee(employeeVO);
			}
			employeeDAO.save(employeeVO);
		}
		else {
			throw new BizException(ExceptionCategory.EMPLOYEE_ALREADY_EXISTS);
		}
	}
	
}
