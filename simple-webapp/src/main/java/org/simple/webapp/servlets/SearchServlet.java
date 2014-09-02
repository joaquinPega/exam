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
 * Reload the users lists
 * @author Joaquin Pega (joaquin.pega@globant.com); Artiom Amerhanov (artiom.amerhanov@globant.com)
 *
 */
public class SearchServlet extends HttpServlet{

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
		HttpSession session = req.getSession();
		WebHandler webHandler = WebHandler.getInstance();
		String search = req.getParameter("search");
		List<User> users;
		try{
			if(search.equals("")){
				users = webHandler.getListUsers();
			}else{
				users = webHandler.search(search);
			}
				session.setAttribute("users", users);
			
				resp.sendRedirect("admin.jsp");
		}catch(CouldNotFinishOperationException e){
			resp.getWriter().write("Error "+ e.getMessage());
		}
		
	}
	
	

}
