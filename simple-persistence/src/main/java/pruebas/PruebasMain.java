package pruebas;


import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;
import org.simple.persistence.UserDAO;

public class PruebasMain {
	public static void main(String[] args) {
		UserDAO ud= new UserDAO();
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
		ud.save(j);
	}
}
