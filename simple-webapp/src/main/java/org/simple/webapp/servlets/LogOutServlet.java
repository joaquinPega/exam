package org.simple.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**Removes the session variables
 * @author Joaquin Pega (joaquin.pega@globant.com); Artiom Amerhanov (artiom.amerhanov@globant.com)
 * 
 */
public class LogOutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession().removeAttribute("currentUser");
		req.getSession().removeAttribute("users");
		req.getSession().removeAttribute("languages");
		req.getSession().removeAttribute("managers");
		req.getSession().removeAttribute("userNotFound");
		req.getSession().removeAttribute("isAdmin");
		req.getSession().removeAttribute("idUser");
		resp.sendRedirect("main.jsp");
	}
	
	
	
}
