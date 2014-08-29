package org.simple.webapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simple.exceptions.CouldNotFinishOperationException;
import org.simple.model.User;
import org.simple.webhandler.WebHandler;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		WebHandler webHandler = WebHandler.getInstance();
		String email, password;
		List<User> users;
		User currentUser = null;
		email = request.getParameter("email");
		password = request.getParameter("password");
		boolean searchingUser = true;
		int i =1;
		while (searchingUser) {
			users = webHandler.getListUsers(i++); // modificar webHandler
			for (User u : users) {
				if (u.getEmail().equals(email)
						&& u.getPassword().equals(password)) {
					currentUser = u;
					session.setAttribute("currentUser", currentUser);
					searchingUser = false;
					break;
				}
			}
			if(users.isEmpty()){
				searchingUser = false;
			}		
		}
		if (currentUser == null) {
			response.getWriter().write("No se encontro a nadie");
		}else{
			response.sendRedirect("user.jsp");
		}

	}

}
