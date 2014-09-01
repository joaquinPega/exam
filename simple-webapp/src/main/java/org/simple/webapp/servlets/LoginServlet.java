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

/**Starts the session and save the currentUser
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		WebHandler webHandler = WebHandler.getInstance();
		String email, password;
		boolean isAdmin;
		List<User> users = null;
		List<Language> languages = null;
		List<Manager> managers = null;
		User currentUser = null;
		email = request.getParameter("email");
		password = request.getParameter("password");		
		try {
			languages = webHandler.getListLanguages();
			managers = webHandler.getListManagers();
			users = webHandler.getListUsers(); 
			for (User u : users) {
				if (u.getEmail().equals(email)
						&& u.getPassword().equals(password)) {
					currentUser = u;
					session.setAttribute("currentUser", currentUser);
					break;
				}
			}
			session.setAttribute("users", users);
			session.setAttribute("languages", languages);
			session.setAttribute("managers", managers);
		} catch (CouldNotFinishOperationException e) {
			response.getWriter().write(
					"Error implementar pagina de error: " + e.getMessage());
		}
		if (currentUser == null) {
			session.setAttribute("userNotFound", true);
			response.sendRedirect("main.jsp");
		} else {
			isAdmin=currentUser.isAdmin();
			session.setAttribute("isAdmin", isAdmin);
			response.sendRedirect("user.jsp");
		}

	}

}
