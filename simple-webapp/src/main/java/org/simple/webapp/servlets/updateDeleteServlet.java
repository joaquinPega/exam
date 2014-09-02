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
 * For the table update delete buttons
 * @author Joaquin Pega (joaquin.pega@globant.com); Artiom Amerhanov (artiom.amerhanov@globant.com)
 *
 */
public class updateDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}


	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		WebHandler webHandler = WebHandler.getInstance();
		if (req.getParameter("id") == null) { // delete
			User toDelete = null;
			long userId = Long.parseLong(req.getParameter("idDel"));
			List<User> users = (List<User>) session.getAttribute("users");
			for (User u : users) {
				if (u.getId() == userId) {
					toDelete = u;
					break;
				}
			}
			if (toDelete != null) {
				try {
					webHandler.deleteUser(toDelete);
					users.remove(toDelete);
					session.setAttribute("users", users);
					resp.sendRedirect("admin.jsp");
				} catch (CouldNotFinishOperationException e) {
					resp.getWriter().write("ERROR: " + e.getMessage());
				}
			}
		} else {
		
			resp.sendRedirect("modify-user-admin.jsp?id="+req.getParameter("id"));
		}
	}

}
