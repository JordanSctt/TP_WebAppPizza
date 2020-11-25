package fr.greta.java.jsp;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class ConnectionBase {
	
	 private final static String URL = "jdbc:postgresql://localhost/WebAppPizza";
	    private final static String USER = "postgres";
	    private final static String PASSWORD = "admin";

	    public Connection create() throws SQLException, ClassNotFoundException {
	    	Class.forName("org.postgresql.Driver"); 
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }	
}
