package org.simple.model;

import junit.framework.TestCase;

public class TestManager extends TestCase {

	public void testManager() {
		Manager manager = new Manager();
		manager.setName("manager");
		assertEquals(manager.getName(), "manager");
	}

}
