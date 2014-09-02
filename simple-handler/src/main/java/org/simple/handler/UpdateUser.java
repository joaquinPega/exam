package org.simple.handler;

import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.User;
import org.simple.persistence.UserDAO;

/**
 * 
 * 
 * @author joaquin.pega
 *
 */
public class UpdateUser implements Runnable {
	private User user;

	@Override
	public void run() {
		update(this.user);
	}

	public UpdateUser(User user) {
		this.user = user;
	}

	private void update(User u) throws ObjectNotFoundException {
		UserDAO userDAO = new UserDAO();
		try {
			userDAO.update(u);
		} catch (ObjectNotFoundException e) {
			throw e;
		} finally {
			userDAO = null;
		}
	}
}
