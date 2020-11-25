package fr.greta.java.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/disconnect")
public class DisconnectServlet extends HttpServlet {
	
	
	// Fct doGet qui via la servlet disconect, r�cup�re la requ�te utilisateur lorsqu'il clic sur 
	// "se d�connecter", remove les attribus de la session et le redirige vers l'accueil
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("userConnected");
    	
    	request
        .getRequestDispatcher("Accueil.jsp")
        .forward(request, response);
	}
}
