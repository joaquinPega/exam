package org.simple.model;

import junit.framework.TestCase;

public class TestLanguage extends TestCase {

	public void testLanguage() {
		Language language = new Language();
		language.setName("ingles");
		assertEquals(language.getName(), "ingles");
	}

}
