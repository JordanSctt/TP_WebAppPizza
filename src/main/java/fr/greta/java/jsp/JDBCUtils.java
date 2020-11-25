package fr.greta.java.jsp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

	
	 public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection conn) {
	        close(resultSet);
	        close(preparedStatement);
	        close(conn);	      
	    }
	 
	 public static void close(ResultSet resultSet, Statement statement, Connection conn) {
	        close(resultSet);
	        close(statement);
	        close(conn);	      
	    }
	 
	 public static void close(PreparedStatement preparedStatement, Connection conn) {	        
	        close(preparedStatement);
	        close(conn);	      
	    }
	 
	 public static void close(Statement statement, Connection conn) {	        
	        close(statement);
	        close(conn);	      
	    }
	 
	    private static void close(ResultSet resultSet) {
	        if(resultSet != null) {
	            try {
	                resultSet.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    private static void close(PreparedStatement preparedStatement) {
	        if(preparedStatement != null) {
	            try {
	            	preparedStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    private static void close(Statement statement) {
	        if(statement != null) {
	            try {
	            	statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    private static void close(Connection conn) {
	        if(conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	   
	
}
