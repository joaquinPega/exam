package org.simple.handler;

import java.util.List;

import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;
import org.simple.webhandler.WebHandler;

import junit.framework.TestCase;

public class TestWebHandler extends TestCase {

	public void testGetInstance() {
	}

	
	public void testSearch() {
		WebHandler wh = WebHandler.getInstance();
		List<User> users = wh.search("name2");
		for (User u : users) {
			System.out.println(u.getName());
		}
	}

	public void testGetListUsers() {
		WebHandler wh = WebHandler.getInstance();
		List<User> users = wh.getListUsers();
		for (User u : users) {
			System.out.println(u.getName());
		}
	}

	public void testDeleteUser() {
		WebHandler wh = WebHandler.getInstance();
		List<User> users = wh.getListUsers();
		wh.deleteUser(users.get(54));

	}

	public void testSaveUser() {
		WebHandler wh = WebHandler.getInstance();
		User u = new User();
		Manager m;
		Language l;
		m = wh.getListManagers().get(0);
		l = wh.getListLanguages().get(0);
		u.setId(1);
		u.setName("Joaquin");
		u.setAdmin(true);
		u.setEmail("joaquin@pega.com");
		u.setCompany("Globant");
		u.setExperience("Nothing");
		u.setJobTitle("Java developer");
		u.setPassword("asd");
		u.setManager(m);
		u.setLanguage(l);
		wh.saveUser(u);
	}

	public void testUpdateUser() {
		WebHandler wh = WebHandler.getInstance();
		List<User> users = wh.getListUsers();
		User u = users.get(0);
		u.setName("admin");
		wh.updateUser(u);
	}

}
