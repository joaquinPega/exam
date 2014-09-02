package org.simple.webapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simple.exceptions.CouldNotFinishOperationException;
import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;
import org.simple.webhandler.WebHandler;
/**
 * Add a new User
 * @author Joaquin Pega (joaquin.pega@globant.com); Artiom Amerhanov (artiom.amerhanov@globant.com)
 *
 */
public class AddNewUserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}


	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		WebHandler webHandler = WebHandler.getInstance();
		String name,company,job,email,experience,password;
		Long managerId,languageId;
		Manager selectedManager=null;
		User newUser;
		Language selectedLanguage=null;
		List<Manager> managers = (List<Manager>)session.getAttribute("managers");
		List<Language> languages = (List<Language>)session.getAttribute("languages");
		List<User> users=(List<User>)session.getAttribute("users");
		name = req.getParameter("name");
		company = req.getParameter("company");
		job = req.getParameter("jobTitle");
		email = req.getParameter("email");
		password=req.getParameter("password");
		managerId = Long.parseLong(req.getParameter("manager"));
		languageId = Long.parseLong(req.getParameter("language"));
		experience = req.getParameter("experience");
		for (Language l : languages) {
			if (l.getId()==languageId) {
				selectedLanguage = l;
				break;
			}
		}
		for (Manager m : managers) {
			if (m.getId()==managerId) {
				selectedManager = m;
				break;
			}
		}
		boolean emailDuplicate=false;
		for (User u : users) {
			if (u.getEmail().equals(email)) {
				emailDuplicate = true;
				break;
			}
		}
		if(!emailDuplicate && selectedManager != null && selectedLanguage != null){
			newUser = new User();
			newUser.setName(name);
			newUser.setCompany(company);
			newUser.setJobTitle(job);
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setManager(selectedManager);
			newUser.setLanguage(selectedLanguage);
			newUser.setExperience(experience);
			try{
				webHandler.saveUser(newUser);
				users.add(newUser);
				session.setAttribute("users", users);
				resp.sendRedirect("admin.jsp");
			}catch(CouldNotFinishOperationException e){
				resp.getWriter().write("Error "+e.getMessage());
			}
		}
	}
	

}
