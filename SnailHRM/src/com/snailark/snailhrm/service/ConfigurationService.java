package com.snailark.snailhrm.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.snailark.snailhrm.BizException;
import com.snailark.snailhrm.ExceptionCategory;
import com.snailark.snailhrm.SystemException;
import com.snailark.snailhrm.facade.ConfigurationFacade;
import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.model.EmployeeVO;
import com.snailark.snailhrm.model.RoleVO;
import com.snailark.snailhrm.util.HibernateUtils;

public class ConfigurationService {

	public void addDepartment(DepartmentVO departmentVO) throws BizException, SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		try {
			configurationFacade.addDepartment(departmentVO);
			transaction.commit();
		} catch (BizException be ) {
			transaction.rollback();
			throw be;
		} catch(HibernateException he) {
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
	}

	public List<DepartmentVO> searchDepartment() throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		List<DepartmentVO> deaprtmentsList = new ArrayList<DepartmentVO>();
		try {
			
		deaprtmentsList = configurationFacade.searchDepartment();
		transaction.commit();
		} catch(HibernateException he) {
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
		return deaprtmentsList;

	}

	public void updateDepartment(DepartmentVO departmentVO)
			throws SystemException, BizException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		try {
			configurationFacade.updateDepartment(departmentVO);
			transaction.commit();
		} catch (SystemException se) {
			transaction.rollback();
			throw se;
		} catch (BizException be) {
			transaction.rollback();
			throw be;
		} catch(HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
	}

	public DepartmentVO findDepartmentById(DepartmentVO requestVO) throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		DepartmentVO departmentVO = new DepartmentVO();
		try {
			
		departmentVO = configurationFacade.findDepartmentById(requestVO);
		transaction.commit();
		} catch(HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
		return departmentVO;
	}

	public void addRole(RoleVO roleVO) throws BizException, SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		
		try {
			configurationFacade.addRole(roleVO);
			transaction.commit();
		} catch (BizException be) {
			transaction.rollback();
			throw be;
		} catch(HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
	}
	
	public List<RoleVO> searchRole() throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		List<RoleVO> roleList = new ArrayList<RoleVO>();
		try {
			
		roleList = configurationFacade.searchRole();
		transaction.commit();
		} catch(HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
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
		} catch(HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
	}
	
	public RoleVO findRoleById(RoleVO requestVO) throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		RoleVO roleVO = new RoleVO();
		try {
			
		roleVO = configurationFacade.findRoleById(requestVO);
		transaction.commit();
		} catch(HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
		return roleVO;
	}

	public void addEmployee(EmployeeVO employeeVO) throws BizException, SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		try {
			configurationFacade.addEmployee(employeeVO);
			transaction.commit();
		} catch (BizException be ) {
			transaction.rollback();
			throw be;
		} catch(HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
	}
	
	
	
	public List<EmployeeVO> searchEmployee(EmployeeVO employeeVO) throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<EmployeeVO> employeesList = new ArrayList<EmployeeVO>();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		try {			
		employeesList = configurationFacade.searchEmployee(employeeVO);
		transaction.commit();
		} catch(HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
		return employeesList;

	}
}
