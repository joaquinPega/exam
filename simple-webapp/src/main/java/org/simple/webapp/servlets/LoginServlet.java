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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		WebHandler webHandler = WebHandler.getInstance();
		String email,password;
		List<User> users;
		User usuario=null;
		email=request.getParameter("email");
		password = request.getParameter("password");
		users = webHandler.getListUsers(1);
		for(User u : users){
			if(u.getEmail().equals(email)&& u.getPassword().equals(password) ){
				response.getWriter().write("Boluda");
				usuario = u;
				break;
			}
		}
		if(usuario == null){
			response.getWriter().write("No se encontro a nadie");
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		WebHandler webHandler = WebHandler.getInstance();
		String email,password;
		List<User> users;
		User usuario=null;
		email=request.getParameter("email");
		password = request.getParameter("password");
		try{
			users = webHandler.getListUsers(1);
			for(User u : users){
				if(u.getEmail().equals(email)&& u.getPassword().equals(password) ){
					response.getWriter().write("Boluda");
					usuario = u;
					break;
				}
			}
			if(usuario == null){
				response.getWriter().write("No se encontro a nadie");
			}
		}catch(CouldNotFinishOperationException e){
			response.getWriter().write(e.getMessage());
		}
		
	}

}
