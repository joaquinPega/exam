package org.simple.persistence;

import java.util.List;

import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.Manager;

public class ManagerDAO implements GenericDAO<Manager> {

	@Override
	public void save(Manager t) throws ObjectDuplicateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Manager t) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Manager t) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Manager> search(String query) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
