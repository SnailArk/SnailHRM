package com.snailark.snailhrm.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.snailark.snailhrm.facade.ConfigurationFacade;
import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.util.HibernateUtils;

public class ConfigurationService {

	public void addDepartment(DepartmentVO departmentVO) {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		configurationFacade.addDepartment(departmentVO);
		transaction.commit();

	}

}
