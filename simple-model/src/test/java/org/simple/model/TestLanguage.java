package org.simple.model;

import org.junit.Test;

import junit.framework.TestCase;

public class TestLanguage extends TestCase {
	@Test
	public void testLanguage() {
		Language language = new Language();
		language.setName("ingles");
		assertEquals(language.getName(), "ingles");
	}

}
