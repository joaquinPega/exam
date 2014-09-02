package org.simple.model;

import org.junit.Test;

import junit.framework.TestCase;

public class TestManager extends TestCase {
	@Test
	public void testManager() {
		Manager manager = new Manager();
		manager.setName("manager");
		assertEquals(manager.getName(), "manager");
	}

}
