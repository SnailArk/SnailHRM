package com.snailark.snailhrm.facade;

import java.util.List;

import com.snailark.snailhrm.dao.DataAccessObject;
import com.snailark.snailhrm.dao.DepartmentDAO;
import com.snailark.snailhrm.model.DepartmentVO;

public class ConfigurationFacade {
	public void addDepartment(DepartmentVO departmentVO) {
		DataAccessObject parentDAO = new DepartmentDAO(DepartmentVO.class);

		parentDAO.save(departmentVO);
	}

	public List<DepartmentVO> searchDepartment() {
		
		DepartmentDAO departmentDAO = new DepartmentDAO(DepartmentVO.class);
		
		List<DepartmentVO> searcheddepartmentName = departmentDAO.searchDepartment();
	
		return searcheddepartmentName;
	}


}
