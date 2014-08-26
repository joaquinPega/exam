package org.simple.dao.impl;

import java.util.List;

import org.simple.dao.UserDao;
import org.simple.exceptions.DataBaseErrorException;
import org.simple.exceptions.UserNotFoundException;
import org.simple.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User u) throws DataBaseErrorException {
		// TODO Auto-generated method stub

	}

	@Override
	public User getById(String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getByName(String name) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getByCompany(String company) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getByExperience(String experience)
			throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
