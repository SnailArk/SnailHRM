package com.snailark.snailhrm.service;

import java.util.List;

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
	
	public List<DepartmentVO> searchDepartment() {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		List<DepartmentVO> deaprtmentsList = configurationFacade.searchDepartment();
		transaction.commit();
		return deaprtmentsList;
		
	} 

}
