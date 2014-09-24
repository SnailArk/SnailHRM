package com.snailark.snailhrm.facade;


import java.util.List;

import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.ExceptionCategory;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.dao.DataAccessObject;
import com.snailark.snailhrm.dao.DepartmentDAO;
import com.snailark.snailhrm.model.DepartmentVO;

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
}
