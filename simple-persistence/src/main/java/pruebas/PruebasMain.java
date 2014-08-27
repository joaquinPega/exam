package pruebas;

import java.util.ArrayList;

import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;
import org.simple.persistence.Persistence;

public class PruebasMain {
	public static void main(String[] args) {
		Persistence p = new Persistence();
		User j = new User();
		Manager m = new Manager();
		//Language l = new Language("Ingles");
		m.setName("pepe");
		j.setEmail("joaquiN");
		j.setAdmin(true);
		j.setCompany("Globant");
		//ArrayList<Language> langs= new ArrayList<Language>();
		//langs.add(l);
		//j.setLanguages(langs);
		ArrayList<Manager> manas= new ArrayList<Manager>();
		manas.add(m);
		j.setManagers(manas);
		j.setExperience("meses");
		j.setJobTitle("java developer");
		ArrayList<User> users=new ArrayList<User>();
		users.add(j);
		m.setUsers(users);

		p.guarda(j);
	}
}
