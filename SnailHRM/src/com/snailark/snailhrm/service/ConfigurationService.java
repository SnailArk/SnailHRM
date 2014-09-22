package com.snailark.snailhrm.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.snailark.snailhrm.ExceptionCategory;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.facade.ConfigurationFacade;
import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.util.HibernateUtils;

public class ConfigurationService {

	public void addDepartment(DepartmentVO departmentVO) throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		try {
			
			configurationFacade.addDepartment(departmentVO);
			transaction.commit();
		} catch(SystemException se) {
				transaction.rollback();
				throw se;
		}

	}

	public void updateDepartment(DepartmentVO departmentVO) throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		configurationFacade.updateDepartment(departmentVO);
		transaction.commit();
	}
}
