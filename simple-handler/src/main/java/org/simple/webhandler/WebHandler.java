package org.simple.webhandler;

/*
 * Meter String a tabla en la cual el servlet busca cual pagina devolver o mensaje mostrar
 */

import java.util.List;

import org.simple.exceptions.CouldNotFinishOperationException;
import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.User;
import org.simple.persistence.UserDAO;

public class WebHandler {
	public static final int MAX_USERS_PER_PAGE = 20;
	private static WebHandler instance;
	private UserDAO ud;
	List<User> users = null;

	public static WebHandler getInstance() {
		if (instance == null) {
			instance = new WebHandler();
		}
		return instance;
	}

	private WebHandler() {
		startAplication();
	}

	private void startAplication()throws CouldNotFinishOperationException {
		this.ud = new UserDAO();
	}

	public List<User> search(String filter, int page)throws CouldNotFinishOperationException {
		try {
			if(users==null)
			users = ud.search(filter);
			if (users.size() > (MAX_USERS_PER_PAGE * page)) {
				return users.subList((page * MAX_USERS_PER_PAGE)
						- MAX_USERS_PER_PAGE, 20 * MAX_USERS_PER_PAGE);
			} else {
				return users;
			}
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("search user fail");
		}
	}

	public List<User> getListUsers(int page)
			throws CouldNotFinishOperationException {
		try {
			if(users==null)
			users = ud.getAll();
			if (users.size() > (MAX_USERS_PER_PAGE * page)) {
				return users.subList((page * MAX_USERS_PER_PAGE)
						- MAX_USERS_PER_PAGE, 20 * MAX_USERS_PER_PAGE);
			} else {
				return users;
			}
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("Get user list fail");
		}
	}

	public void deleteUser(User user) throws CouldNotFinishOperationException {
		try {
			ud.delete(user);
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("delete user fail");
		}
	}

	public void saveUser(User user) {
		try {
			ud.save(user);
		} catch (ObjectDuplicateException e) {
			throw new CouldNotFinishOperationException("Save user fail");
		}
	}

	public void updateUser(User user) throws CouldNotFinishOperationException {
		try {
			ud.update(user);
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("Update user fail");
		}
	}

}
