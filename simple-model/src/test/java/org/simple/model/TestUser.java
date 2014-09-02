package org.simple.model;

import org.junit.Test;

import junit.framework.TestCase;

public class TestUser extends TestCase {
	@Test
	public void testUser() {
		User user = new User();
		user.setName("name");
		user.setAdmin(false);
		user.setCompany("globant");
		user.setEmail("user@user.com");
		user.setExperience("Experience");
		user.setJobTitle("Java");
		assertEquals(user.getName(), "name");
		assertEquals(user.isAdmin(), false);
		assertEquals(user.getCompany(), "globant");
		assertEquals(user.getEmail(), "user@user.com");
		assertEquals(user.getExperience(), "Experience");
		assertEquals(user.getJobTitle(), "Java");
		
	}

}
