package com.snailark.snailhrm.dao;

import com.snailark.snailhrm.model.ValueObject;

public abstract class DataAccessObject {
	
	public void save(ValueObject parentVO) {
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
