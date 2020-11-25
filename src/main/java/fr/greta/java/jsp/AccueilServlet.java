package fr.greta.java.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userConnected");		
		req.setAttribute("isAdmin", user instanceof Admin);
		
		RequestDispatcher dispatch = req.getRequestDispatcher("Accueil.jsp");
		dispatch.forward(req, resp);			
	}
}
