package fr.greta.java.jsp;

public class Admin extends User {

	public Admin(String login, String mdp) {
		super(login, mdp);
	}

	@Override
	public boolean isAdmin() {		
		return true;
	}
	
	
	
}
