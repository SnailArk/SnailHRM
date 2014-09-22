package com.snailark.snailhrm.facade;

import com.snailark.snailhrm.dao.DataAccessObject;
import com.snailark.snailhrm.dao.DepartmentDAO;
import com.snailark.snailhrm.model.DepartmentVO;

public class ConfigurationFacade {
	public void addDepartment(DepartmentVO departmentVO) {
		DataAccessObject parentDAO = new DepartmentDAO(DepartmentVO.class);

		parentDAO.save(departmentVO);

	}

}
