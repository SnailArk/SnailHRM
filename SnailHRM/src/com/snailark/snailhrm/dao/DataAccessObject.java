package com.snailark.snailhrm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.snailark.snailhrm.model.ValueObject;
import com.snailark.snailhrm.util.HibernateUtils;

public abstract class DataAccessObject {
	protected Class<Object> classReference;

	public DataAccessObject(Class<Object> classReference) {
		this.classReference = classReference;
	}

	public void save(ValueObject parentVO) {
		SessionFactory factory = HibernateUtils.getFactoryObject();
		Session session = factory.getCurrentSession();
		session.save(parentVO);
		// Save object to database
	}

	public void update(ValueObject parentVO) {
		// Update object to database
	}

	public ValueObject findById(ValueObject requestVO) {
		// Fetch a record by id
		return null;
	}

	public void delete(ValueObject parentVO) {
		// Delete a record
	}
	
		

}
