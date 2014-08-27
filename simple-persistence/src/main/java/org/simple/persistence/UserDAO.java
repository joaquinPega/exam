package org.simple.persistence;

import java.util.List;

import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.User;

public class UserDAO implements GenericDAO<User> {

	@Override
	public void save(User t) throws ObjectDuplicateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User t) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> search(String query) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
