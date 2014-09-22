package com.snailark.snailhrm.facade;


import java.util.List;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.dao.DataAccessObject;
import com.snailark.snailhrm.dao.DepartmentDAO;
import com.snailark.snailhrm.model.DepartmentVO;

public class ConfigurationFacade {
	public void addDepartment(DepartmentVO departmentVO) {
		DataAccessObject parentDAO = new DepartmentDAO();

		parentDAO.save(departmentVO);
	}

	public List<DepartmentVO> searchDepartment() {
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		
		List<DepartmentVO> searcheddepartmentName = departmentDAO.searchDepartment();
	
		return searcheddepartmentName;
	}


	public void updateDepartment(DepartmentVO departmentVO) throws SystemException {
		DataAccessObject parentDAO = new DepartmentDAO();
		parentDAO.update(departmentVO);
	}

	
}
