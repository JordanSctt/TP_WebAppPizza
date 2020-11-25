package fr.greta.java.jsp;

import java.util.ArrayList;
import java.util.List;

public class ListUtilisateur {
	
	private List<User> users = new ArrayList<>();

	
	public void add(User user) {
		users.add(user);		
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	protected void delete (User user) {
		users.remove(user);
	}
	
	protected User getUser (String name) {		
		for (User user : users) {
			if (name.equals(user.getLogin())) {
				return user;
			}			
		}
		return null;
	}
	
}
