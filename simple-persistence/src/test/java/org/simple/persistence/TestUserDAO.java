package org.simple.persistence;

import java.util.List;

import org.junit.Test;
import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;

import junit.framework.TestCase;

public class TestUserDAO extends TestCase {
	@Test
	public void testSave() {
		UserDAO ud = new UserDAO();
		ManagerDAO md = new ManagerDAO();
		LanguageDAO ld = new LanguageDAO();
		User u = new User();
		Manager m;
		Language l;
		m = md.getAll().get(0);
		l = ld.getAll().get(0);
		u.setId(1);
		u.setName("Joaquin");
		u.setAdmin(true);
		u.setEmail("joaquin@pega.com");
		u.setCompany("Globant");
		u.setExperience("Nothing");
		u.setJobTitle("Java developer");
		u.setPassword("asd");
		u.setManager(m);
		u.setLanguage(l);
		ud.save(u);
	}
	@Test
	public void testUpdate() {
		UserDAO ud = new UserDAO();
		List<User> users = ud.getAll();
		User user = users.get(0);
		user.setName("pepito");
		user.setCompany("compania");
		user.setEmail("emailnuevo@nuevo.com");
		user.setExperience("nuevaExperiencia");
		user.setJobTitle("nuevo jobTitle");
	}
	@Test
	public void testDelete() {
		UserDAO ud = new UserDAO();
		List<User> users = ud.getAll();
		ud.delete(users.get(0));
	}
	@Test
	public void testSearch() {
		UserDAO ud = new UserDAO();
		List<User> users = ud.search("joaquin");
		for(User u : users){
			System.out.println(u.getName());
		}
		
	}

}
