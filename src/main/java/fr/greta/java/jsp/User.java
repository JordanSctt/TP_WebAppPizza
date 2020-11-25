package fr.greta.java.jsp;

public class User {
	
	private int id;
	private String login;
	private String mdp;

	
	public User(String name, String mdp) {
		super();
		this.login = name;
		this.mdp = mdp;
		
		
	}
	
	public boolean isAdmin() {
		return false;
	}
	
	
	//------------------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}		
	//-------------------------------------------------
		
}
