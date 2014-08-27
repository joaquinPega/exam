package pruebas;

import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;
import org.simple.persistence.LanguageDAO;
import org.simple.persistence.ManagerDAO;
import org.simple.persistence.UserDAO;

public class PruebasMain {
	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		ManagerDAO md = new ManagerDAO();
		LanguageDAO ld = new LanguageDAO();
		User j = new User();
		Manager m = new Manager();
		Language l = new Language("Ingles");
		m.setName("pepe");
		j.setEmail("joaquiN");
		j.setAdmin(true);
		j.setCompany("Globant");
		j.setExperience("meses");
		j.setJobTitle("java developer");
		j.setManager(m);
		j.setLanguage(l);
		try {
			ld.save(l);
			md.save(m);
			ud.save(j);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
