package pruebas;


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
		j.setExperience("meses");
		j.setJobTitle("java developer");

		p.guarda(j);
	}
}
