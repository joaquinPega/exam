package org.simple.persistence;

import java.util.List;

import org.junit.Test;
import org.simple.model.Manager;

import junit.framework.TestCase;

public class TestManagerDAO extends TestCase {
	@Test 
	public void testSave() {
		ManagerDAO md = new ManagerDAO();
		Manager mn = new Manager();
		mn.setName("pepito");
		md.save(mn);

	}
	@Test
	public void testUpdate() {
		ManagerDAO md = new ManagerDAO();
		List<Manager> m = md.getAll();
		Manager manager = m.get(0);
		manager.setName("artiom");
		md.update(manager);
	}
	@Test
	public void testDelete() {
		ManagerDAO md = new ManagerDAO();
		List<Manager> m = md.getAll();
		for (Manager m2 : m) {
			if (m2.getName().equals("pepito")) {
				md.delete(m2);
				break;
			}
		}
	}
	@Test
	public void testSearch() {
		ManagerDAO md = new ManagerDAO();
		List<Manager> m = md.search("Manager1");
		for (Manager m1 : m) {
			System.out.println(m1.getName());
		}

	}
	@SuppressWarnings("unused")
	@Test
	public void testGetAll() {
		ManagerDAO md = new ManagerDAO();
		List<Manager> lista;
		lista = md.getAll();

	}

}
