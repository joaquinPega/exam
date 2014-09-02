package org.simple.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextPageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int currentPage =0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(Integer.parseInt(req.getParameter("id"))==1){
			currentPage++;
			resp.sendRedirect("admin.jsp?selectedPage="+currentPage);
			
		}else{
			currentPage--;
			resp.sendRedirect("admin.jsp?selectedPage="+currentPage);
		}
	}
	

}
