package org.simple.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simple.exceptions.CouldNotFinishOperationException;
import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;
import org.simple.webhandler.WebHandler;

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
			for (int i = 0; i < 100; i++) {
				Manager m = new Manager();
				Language l = new Language();
				User u = new User();
				m.setName("Manager" + i);
				l.setName("Language" + i);
				u.setManager(m);
				u.setLanguage(l);
				u.setName("Name"+i);
				u.setAdmin(false);
				u.setCompany("Company"+i);
				u.setEmail("user"+i+"@user.com");
				u.setExperience("Nothing");
				u.setJobTitle("Jave developer");
				u.setPassword("asd");
				wh.saveLanguage(l);
				wh.saveManager(m);
				wh.saveUser(u);
			}
		} catch (CouldNotFinishOperationException e) {
			resp.getWriter().write("Error " + e.getMessage());
		}
		resp.sendRedirect("main.jsp");
	}

}
