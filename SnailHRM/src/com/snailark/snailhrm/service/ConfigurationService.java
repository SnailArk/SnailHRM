package com.snailark.snailhrm.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.facade.ConfigurationFacade;
import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.model.RoleVO;
import com.snailark.snailhrm.util.HibernateUtils;

public class ConfigurationService {

	public void addDepartment(DepartmentVO departmentVO) throws BizException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		try {
			configurationFacade.addDepartment(departmentVO);
			transaction.commit();
		} catch (BizException be) {
			transaction.rollback();
			throw be;
		}
	}

	public List<DepartmentVO> searchDepartment() {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		List<DepartmentVO> deaprtmentsList = configurationFacade
				.searchDepartment();
		transaction.commit();
		return deaprtmentsList;

	}

	public void updateDepartment(DepartmentVO departmentVO)
			throws SystemException, BizException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			ConfigurationFacade configurationFacade = new ConfigurationFacade();
			configurationFacade.updateDepartment(departmentVO);
			transaction.commit();
		} catch (SystemException se) {
			transaction.rollback();
			throw se;
		} catch (BizException be) {
			transaction.rollback();
			throw be;
		}
	}

	public DepartmentVO findDepartmentById(DepartmentVO departmentVO) {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		DepartmentVO departmentVO2 = configurationFacade
				.findDepartmentById(departmentVO);
		transaction.commit();
		return departmentVO2;
	}

	public void addRole(RoleVO roleVO) throws BizException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		
		try {
			configurationFacade.addRole(roleVO);
			transaction.commit();
		} catch (BizException be) {
			transaction.rollback();
			throw be;
		}
	}
	
	public List<RoleVO> searchList() {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		List<RoleVO> roleList = configurationFacade.searchRole();
		transaction.commit();
		return roleList;

	}

	public void updateRole(RoleVO roleVO) throws SystemException, BizException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			ConfigurationFacade configurationFacade = new ConfigurationFacade();
			configurationFacade.updateRole(roleVO);
			transaction.commit();
		} catch (SystemException se) {
			transaction.rollback();
			throw se;
		} catch (BizException be) {
			transaction.rollback();
			throw be;
		}
	}
	
	public RoleVO findRoleById(RoleVO roleVO) {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		RoleVO roleVO2 = configurationFacade
				.findRoleById(roleVO);
		transaction.commit();
		return roleVO2;
	}
}
