package fr.greta.java.jsp;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDepot {
	
	private ConnectionBase connectionBase = new ConnectionBase();
	
	
	/* fct qui réalise la requéte SQL sur la base de donnée afin de comparer les valeurs des utilsateurs en base de donnée
	  avec les valeurs récupérer dans le formulaire de connection  */
	public User findByLoginAndMdp(String login, String mdp) throws SQLException, ClassNotFoundException {
		User user = null;
        String request = "SELECT login, mdp, _role FROM utilisateur WHERE login = ? AND mdp = ?";

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = connectionBase.create();
            preparedStatement = conn.prepareStatement(request);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, mdp);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){                              
                String userLogin = resultSet.getString("login");
                String userMdp = resultSet.getString("mdp");                
                if (resultSet.getString("_role").equals("admin")) {
                	user = new Admin(userLogin, userMdp);
                } else {
                	user = new User(userLogin, userMdp);
                }
                return user;
            } 
            return null;
                       
        } catch (SQLException e) {
        	e.printStackTrace();
            System.err.println("Erreur lors de l'execution de la requête:" + request);
            throw e;
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, conn);
        }
    }
	
	public ListUtilisateur getAllUsers() throws SQLException, ClassNotFoundException {
		ListUtilisateur allUsers = new ListUtilisateur();
		
        String request = "SELECT * FROM utilisateur";

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = connectionBase.create();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()){                              
                String login = resultSet.getString("login");
                String mdp = resultSet.getString("mdp"); 
                if (resultSet.getString("_role").equals("admin")) {
                	Admin user = new Admin(login, mdp);
                	allUsers.add(user);                
                } else {
                	User user = new User(login, mdp);
                	allUsers.add(user); 
                }               
            }                                    
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'execution de la requête:" + request);
            throw e;
        } finally {
            JDBCUtils.close(resultSet, statement, conn);
        }
        return allUsers;
    }
	
	

	
	/* fct qui réalise la requéte SQL sur la base de donnée afin de créer un utilsateurs en base de donnée
	  avec les valeurs récupérer dans le formulaire d'inscription  */
	public void createUser(String login, String mdp) throws SQLException, ClassNotFoundException {
		
		 String request = "INSERT INTO utilisateur (login, mdp, _role) VALUES (?, ?, ?)";
	        	        
	        Connection conn = null;
	        PreparedStatement preparedStatement = null;
	        
	        try {
	            conn = connectionBase.create();
	            preparedStatement = conn.prepareStatement(request);
	            preparedStatement.setString(1, login);
	            preparedStatement.setString(2, mdp);
	            preparedStatement.setString(3, "user");
	            preparedStatement.executeUpdate();	            
	        } catch (SQLException e) {
	            System.err.println("Erreur lors de l'execution de la requête: " + request);
	            e.printStackTrace();
	            throw e;
	        } finally {
	        	JDBCUtils.close(preparedStatement, conn);        		        	
	        }
	}
	
	public void deleteUser(String login) throws SQLException, ClassNotFoundException {
		
		 String request = "DELETE FROM utilisateur WHERE login = ?";
	        	        
	        Connection conn = null;
	        PreparedStatement preparedStatement = null;
	        
	        try {
	            conn = connectionBase.create();
	            preparedStatement = conn.prepareStatement(request);
	            preparedStatement.setString(1, login);
	            preparedStatement.executeUpdate();	            
	        } catch (SQLException e) {
	            System.err.println("Erreur lors de l'execution de la requête: " + request);
	            e.printStackTrace();
	            throw e;
	        } finally {
	        	JDBCUtils.close(preparedStatement, conn);        		        	
	        }
	}
	
	
	
}
