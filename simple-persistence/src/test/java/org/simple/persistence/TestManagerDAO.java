package org.simple.persistence;

import java.util.List;

import org.simple.model.Manager;

import junit.framework.TestCase;

public class TestManagerDAO extends TestCase {

	public void testSave() {
		fail("Not yet implemented");
	}

	public void testUpdate() {
		fail("Not yet implemented");
	}

	public void testDelete() {
		fail("Not yet implemented");
	}

	public void testSearch() {
		ManagerDAO md = new ManagerDAO();
		List<Manager> m = md.search("Manager1");
		for(Manager m1 : m){
			System.out.println(m1.getName());
		}
		
	}

	public void testGetAll() {
		fail("Not yet implemented");
	}

}
