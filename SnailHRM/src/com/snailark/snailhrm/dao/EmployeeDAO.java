package com.snailark.snailhrm.dao;

import java.util.ArrayList;

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
		Criterion criterion = Restrictions
				.ilike("email", employeeVO.getEmail());
		criteria.add(criterion);
		List<EmployeeVO> employeeVOList = criteria.list();
		if (!employeeVOList.isEmpty()) {
			savedVO = employeeVOList.get(0);
		}
		return savedVO;
	}

	public List<EmployeeVO> searchEmployee(EmployeeVO employeeVO) {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeVO.class);
		List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		if(employeeVO != null) {
			if (employeeVO.getFirstName() != null
					&& !("".equals(employeeVO.getFirstName()))) {
				Criterion firstName = Restrictions.ilike("firstName",
						employeeVO.getFirstName());
				criteria.add(firstName);
			}
			if (employeeVO.getLastName() != null
					&& !("".equals(employeeVO.getLastName()))) {
				Criterion lastName = Restrictions.ilike("lastName",
						employeeVO.getLastName());
				criteria.add(lastName);
			}
			employeeList = criteria.list();
		} else {
				employeeList = criteria.list();
			}

		

		return employeeList;
	}

}
