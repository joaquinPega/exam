package org.simple.handler;

import java.util.List;

import org.simple.model.User;
import org.simple.webhandler.WebHandler;

import junit.framework.TestCase;

public class TestWebHandler extends TestCase {

	public void testGetInstance() {
		fail("Not yet implemented");
	}

	public void testSearch() {
		fail("Not yet implemented");
	}

	public void testGetListUsers() {
		WebHandler wh = WebHandler.getInstance();
		List<User> users = wh.getListUsers(1);
		for(User u : users){
			System.out.println(u.getName());
		}
	}

	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	public void testSaveUser() {
		fail("Not yet implemented");
	}

	public void testUpdateUser() {
		fail("Not yet implemented");
	}

}
