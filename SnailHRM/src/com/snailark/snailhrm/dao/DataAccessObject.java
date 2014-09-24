package com.snailark.snailhrm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.ExceptionCategory;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.model.ValueObject;
import com.snailark.snailhrm.util.HibernateUtils;

public abstract class DataAccessObject {
	protected Class classReference;

	public DataAccessObject(Class classReference) {
		this.classReference = classReference;
	}

	public void save(ValueObject parentVO) {
		// save object to DB.
		SessionFactory factory = HibernateUtils.getFactoryObject();
		Session session = factory.getCurrentSession();
		session.save(parentVO);
		
		
		
	}

	public void update(ValueObject parentVO) throws SystemException {
		try {
		// Update object to database
		SessionFactory factory = HibernateUtils.getFactoryObject();
		Session session = factory.getCurrentSession();
		session.update(parentVO);
		} catch(HibernateException he) {
			he.printStackTrace();
			throw new SystemException(ExceptionCategory.DATABASE_UPDATE_EXCEPTION);
		}
	}

	public ValueObject findById(ValueObject requestVO) {
		// Fetch a record by id
		SessionFactory factory = HibernateUtils.getFactoryObject();
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(DepartmentVO.class);
		Criterion criterion = Restrictions.idEq(requestVO.getId());
		criteria.add(criterion);
		List<DepartmentVO> departmentsList =criteria.list();
		if(!departmentsList.isEmpty() && departmentsList.size() == 1){
			DepartmentVO departmentVO = new DepartmentVO();
			departmentVO = departmentsList.get(0);
			return departmentVO;
		}
		else{
			
			return null;
		}
		
	
		
	}

	public void delete(ValueObject parentVO) {
		// Delete a record
	}

}
