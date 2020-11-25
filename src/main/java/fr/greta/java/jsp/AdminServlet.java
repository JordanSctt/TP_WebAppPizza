package fr.greta.java.jsp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/administration")
public class AdminServlet extends HttpServlet {

	private static UserDepot depot = new UserDepot();	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			ListUtilisateur allUsers = depot.getAllUsers();
			
			req.setAttribute("userList", allUsers);
						
			RequestDispatcher dispatch = req.getRequestDispatcher("administration.jsp");
			dispatch.forward(req, resp);	
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			ListUtilisateur allUsers = depot.getAllUsers();
			
			req.setAttribute("userList", allUsers);
			
			RequestDispatcher dispatch = req.getRequestDispatcher("administration.jsp");
			dispatch.forward(req, resp);	
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}			
	}
	
}
