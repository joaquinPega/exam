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
import org.simple.model.User;
import org.simple.webhandler.WebHandler;

public class ChangeUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		WebHandler webHandler = WebHandler.getInstance();
		String newEmail, newExperience;
		Long newLanguage;
		newEmail = req.getParameter("email");
		newExperience = req.getParameter("newExperience");
		newLanguage = Long.parseLong(req.getParameter("language"));
		List<User> users = (List<User>) session.getAttribute("users");
		List<Language> languages = (List<Language>) session.getAttribute("languages");
		User currentUser = (User) session.getAttribute("currentUser");
		Language selectedLanguage = null;
		for (Language l : languages) {
			if (l.getId()==newLanguage) {
				selectedLanguage = l;
				break;
			}
		}
		boolean emailDuplicate = false;
		for (User u : users) {
			if (u.getEmail().equals(newEmail)) {
				emailDuplicate = true;
				break;
			}
		}
		if (!emailDuplicate) {
			currentUser.setEmail(newEmail);
			currentUser.setExperience(newExperience);
			if (selectedLanguage != null) {
				currentUser.setLanguage(selectedLanguage);
			} else {
				resp.getWriter().write("ERROR, no se encontro el lenguage");
			}
			try{
				webHandler.updateUser(currentUser);
				users = webHandler.getListUsers();
				session.setAttribute("users", users);
				session.setAttribute("currentUser", currentUser);
				resp.sendRedirect("user.jsp");
			}catch(CouldNotFinishOperationException e){
				resp.getWriter().write("Error bd "+e.getMessage());
			}
		}else{
			resp.sendRedirect("modify-user.jsp");
		}
	}

}
