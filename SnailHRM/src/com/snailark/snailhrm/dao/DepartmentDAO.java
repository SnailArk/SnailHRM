package com.snailark.snailhrm.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.util.HibernateUtils;


public class DepartmentDAO extends DataAccessObject {
	
	public DepartmentDAO() {
		super(DepartmentVO.class);
	}

	
	public List<DepartmentVO> searchDepartment() {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(DepartmentVO.class);
		List<DepartmentVO> departmentsList = criteria.list();
		return departmentsList;
	}
	
	public DepartmentVO searchByDepartmentName(DepartmentVO departmentVO) {
		DepartmentVO savedVO  = null;
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(DepartmentVO.class);
		Criterion criterion = Restrictions.ilike("departmentName", departmentVO.getDepartmentName());
	    criteria.add(criterion);
	    List<DepartmentVO> departmentVOList = criteria.list();
	    if(!departmentVOList.isEmpty()){
	    	savedVO = departmentVOList.get(0);
	    }
	    return savedVO;
	}
	
	
	
	
	
	
}
