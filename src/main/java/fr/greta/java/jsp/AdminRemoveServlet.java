package fr.greta.java.jsp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")
public class AdminRemoveServlet extends HttpServlet {
	
	private static UserDepot depot = new UserDepot();	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("userToRemove");
		try {
			depot.deleteUser(login);
			
			RequestDispatcher dispatch = req.getRequestDispatcher("administration");
			dispatch.forward(req, resp);	
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
}
