package fr.greta.java.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/ConnectionUser")
public class UserConnectionServlet extends HttpServlet {
		  
	
	private static final String LOGIN = "login_parameter";
	private static final String MDP = "mdp_parameter";
	
	private static UserDepot depot = new UserDepot();	
	
	
		//Fct DoPost qui récupére le login et le mdp saisis par l'utilisateur dans le formulaire de connection - je request.getPara les deux infos dans
		// une viriable, puis le met en arguments de ma fonction FindByLog.. situé dans la classe UserDepot qui réalise la requete SQL à la BDD 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	  	    	
	    		
	    	String login = request.getParameter(LOGIN);
	    	String mdp = request.getParameter(MDP);
	    	
	    	try {	    						
				User user = depot.findByLoginAndMdp(login, mdp);				
				if (user != null) {
					HttpSession session = request.getSession();
					session.setAttribute("userConnected", user);
					request.setAttribute("userConnected2", user);
					request.setAttribute("isAdmin", user instanceof Admin);
					request.getRequestDispatcher("Accueil.jsp").forward(request, response);					
					} else {
						PrintWriter out = response.getWriter();
						out.println("<html>" + "<body>" + "<h1>Erreur de saisie du login ou mdp !!</h1>" + "</html>" + "</body>");
					}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}	    		    	
	    }
}
