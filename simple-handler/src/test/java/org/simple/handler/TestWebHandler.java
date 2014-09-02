package org.simple.handler;

import java.util.List;

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
		User user = new User();
		user.setCompany("Globant");
		user.setEmail("kdkdkd@globant.com");
		user.setJobTitle("dev");
		wh.saveUser(user);
	}

	public void testUpdateUser() {
		WebHandler wh = WebHandler.getInstance();
		List<User> users = wh.getListUsers();
		User u = users.get(0);
		u.setName("admin");
		wh.updateUser(u);
	}

}
