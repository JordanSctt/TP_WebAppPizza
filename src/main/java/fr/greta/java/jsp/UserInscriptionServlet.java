package fr.greta.java.jsp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InscriptionUser")
public class UserInscriptionServlet extends HttpServlet {

	private static final String LOGIN = "login_parameter";
	private static final String MDP = "mdp_parameter";
	
	private static UserDepot depot = new UserDepot();	
	
	//Fcy doPost qui récupére le login et mdp entré par l'utilisateur sur la page d'inscription, éxecution de la fct create qui réalise la requéte SQL 
	// avec en paramétre les arguments afin de créer un nouvel utilisateur 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter(LOGIN);
    	String mdp = request.getParameter(MDP);
		
		try {
			depot.createUser(login, mdp);
			request.getRequestDispatcher("Accueil.jsp").forward(request, response);	
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}	
}
