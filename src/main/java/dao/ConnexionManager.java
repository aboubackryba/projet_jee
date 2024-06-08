package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager {
	
	public static Connection getConnection() {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/tp_java", "root", "");
			
			return connexion ; 
			
		} catch (Exception e) {
			return null;
			
		}
	}
}
