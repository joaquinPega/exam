package org.simple.webapp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simple.dao.impl.ManagerDao;
import org.simple.dao.impl.UserDaoImpl;
import org.simple.model.Manager;
import org.simple.model.User;

/**@author joaquin.pega
 * Servlet implementation class HBTestServlet
 */
public class HBTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HBTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User joaquin = new User();
		Manager kevin = new Manager();
		kevin.setName("kevin");
		ManagerDao man= new ManagerDao();
		ArrayList<Manager> managers = new ArrayList<Manager>();
		ArrayList<User> usuarios= new ArrayList<User>();
		usuarios.add(joaquin);
		managers.add(kevin);
		joaquin.setEmail("joaquin_pega@hotmail.com");
		joaquin.setName("joaquin");
		joaquin.setCompany("Globant");
		joaquin.setAdmin(true);
		kevin.setUsers(usuarios);
		joaquin.setManager(kevin);
		UserDaoImpl userDao= new UserDaoImpl();

		man.save(kevin);
		userDao.save(joaquin);
		response.getWriter().write("magia");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
