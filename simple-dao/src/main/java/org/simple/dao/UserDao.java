package org.simple.dao;

import org.simple.exceptions.DataBaseErrorException;
import org.simple.exceptions.UserNotFoundException;
import org.simple.model.User;
/**
 * 
 * @author Joaquin Pega (joaquin.pega@globant.com)
 *
 */
public interface UserDao {
	public void save(User u) throws DataBaseErrorException;
	public User getById(String email) throws UserNotFoundException;
}
