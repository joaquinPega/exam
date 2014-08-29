package org.simple.persistence;

import java.util.List;

import org.simple.model.User;

import junit.framework.TestCase;

public class TestUserDAO extends TestCase {

	public void testSave() {
		fail("Not yet implemented");
	}

	public void testUpdate() {
		fail("Not yet implemented");
	}

	public void testDelete() {
		fail("Not yet implemented");
	}

	//public void testSearch() {
	//	UserDAO ud = new UserDAO();
	//	System.out.println(ud.search("joaquin"));
	//}

	public void testGetAll() {
		UserDAO ud = new UserDAO();
		List<User> users=ud.getAll();
		for(User u : users){
			System.out.println(u.getName()+"\t"+ u.getManager().getName());
		}
	}

}
