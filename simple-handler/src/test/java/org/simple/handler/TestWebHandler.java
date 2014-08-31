package org.simple.handler;

import java.util.List;

import org.simple.model.User;
import org.simple.webhandler.WebHandler;

import junit.framework.TestCase;

public class TestWebHandler extends TestCase {

	public void testGetInstance() {
	}

	public void testSearch() {
	}

	public void testGetListUsers() {
		WebHandler wh = WebHandler.getInstance();
		List<User> users = wh.getListUsers();
		for(User u : users){
			System.out.println(u.getName());
		}
	}

	public void testDeleteUser() {
	}

	public void testSaveUser() {
	}

	public void testUpdateUser() {
	}

}
