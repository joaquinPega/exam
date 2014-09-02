package org.simple.webapp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simple.exceptions.CouldNotFinishOperationException;
import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;
import org.simple.webhandler.WebHandler;
/**
 * Start some data base information
 * @author Joaquin Pega (joaquin.pega@globant.com); Artiom Amerhanov (artiom.amerhanov@globant.com)
 *
 */
public class InicioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		WebHandler wh = WebHandler.getInstance();
		try {
			String[] m1=new String[9];
			m1[0]="Kevin";
			m1[1]="Artiom";
			m1[2]="Lautaro";
			m1[3]="Nicolas";
			ArrayList<Manager> managers = new ArrayList<Manager>();
			ArrayList<Language> languages = new ArrayList<Language>();
			for(int i=0;i<4;i++){
				Manager m = new Manager();
				m.setName(m1[i]);
				wh.saveManager(m);
				managers.add(m);			
			}
			m1[0]="Ingles";
			m1[1]="Español";
			m1[2]="Japones";
			m1[3]="Chino";
			m1[4]="Coreano";
			m1[5]="Frances";
			for(int i = 0;i<6;i++){
				Language l = new Language();
				l.setName(m1[i]);
				wh.saveLanguage(l);
				languages.add(l);
			}
			for (int i = 0; i < 100; i++) {
				User u = new User();
				u.setManager(managers.get(i % 4));
				u.setLanguage(languages.get(i% 6));
				u.setName("Name"+i);
				u.setAdmin(false);
				u.setCompany("Company"+i);
				u.setEmail("user"+i+"@user.com");
				u.setExperience("Nothing");
				u.setJobTitle("Jave developer");
				u.setPassword("asd");
				wh.saveUser(u);
			}
		} catch (CouldNotFinishOperationException e) {
			resp.getWriter().write("Error " + e.getMessage());
		}
		resp.sendRedirect("main.jsp");
	}

}
