package com.snailark.snailhrm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.util.HibernateUtils;

public class DepartmentDAO extends DataAccessObject {
	
	public DepartmentDAO(Class classReference) {
		super(classReference);
	}

	
	public List<DepartmentVO> searchDepartment() {
		
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(DepartmentVO.class);
		List<DepartmentVO> departmentsList = criteria.list();
		return departmentsList;
	}
	
}
