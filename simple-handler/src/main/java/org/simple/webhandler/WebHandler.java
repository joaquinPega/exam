package org.simple.webhandler;

/*
 * Meter String a tabla en la cual el servlet busca cual pagina devolver o mensaje mostrar
 */

import java.util.List;

import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;
import org.simple.persistence.LanguageDAO;
import org.simple.persistence.ManagerDAO;
import org.simple.persistence.UserDAO;

public class WebHandler {
	public static final int MAX_USERS_PER_PAGE = 20;
	private static WebHandler instance;

	public static WebHandler getInstance() {
		if (instance == null) {
			instance = new WebHandler();
		}
		return instance;
	}

	private WebHandler() {
		startAplication();
	}

	private void startAplication() {
		ManagerDAO md = new ManagerDAO();
		LanguageDAO ld = new LanguageDAO();
		for (int i = 0; i < 4; i++) {
			Manager m = new Manager();
			Language l = new Language("Language" + i);
			m.setName("Manager" + i);
			try {
				md.save(m);
				ld.save(l);
			} catch (ObjectDuplicateException e) {
				
			}
		}

	}

	public List<User> search(String filter, int page) {
		List<User> users = null;
		users = new UserDAO().search(filter);
		if (users.size() > (MAX_USERS_PER_PAGE * page)) {
			return users.subList((page * MAX_USERS_PER_PAGE)
					- MAX_USERS_PER_PAGE, 20 * MAX_USERS_PER_PAGE);
		} else {
			return users;
		}

	}

	public List<User> getListUsers(int page) {
		List<User> users = null;
		users = new UserDAO().getAll();
		if (users.size() > (MAX_USERS_PER_PAGE * page)) {
			return users.subList((page * MAX_USERS_PER_PAGE)
					- MAX_USERS_PER_PAGE, 20 * MAX_USERS_PER_PAGE);
		} else {
			return users;
		}

	}

	public String deleteUser(User user) {
		String result = "Error";
		UserDAO ud = new UserDAO();
		try {
			ud.delete(user);
			result = "Success";
		} catch (ObjectNotFoundException e) {
			result = "Edelete";
		} finally {
			ud = null;
		}
		return result;
	}

	public String saveUser(User user) {
		String result = "Error";
		UserDAO ud = new UserDAO();
		try {
			ud.save(user);
			result = "Success";
		} catch (ObjectDuplicateException e) {
			result = "Derror";
		}
		return result;
	}

	public String updateUser(User user) {
		String result = "Error";
		UserDAO ud = new UserDAO();
		try {
			ud.update(user);
			result = "Success";
		} catch (ObjectNotFoundException e) {
			result = "Eupdate";
		} finally {
			ud = null;
		}
		return result;
	}

}
