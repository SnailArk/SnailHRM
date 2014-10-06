package com.snailark.snailhrm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.snailark.snailhrm.model.EmployeeVO;
import com.snailark.snailhrm.util.HibernateUtils;

public class EmployeeDAO extends DataAccessObject {

	public EmployeeDAO() {
		super(EmployeeVO.class);
	}	

	public EmployeeVO searchByEmailId(EmployeeVO employeeVO) {
		EmployeeVO savedVO = null;
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeVO.class);
		Criterion criterion = Restrictions.ilike("email", employeeVO.getEmail());
	    criteria.add(criterion);
	    List<EmployeeVO> employeeVOList = criteria.list();
	    if(!employeeVOList.isEmpty()){
	    	savedVO = employeeVOList.get(0);
	    }
		return savedVO;
	}

}
