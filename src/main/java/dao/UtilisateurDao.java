package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao {
	
	private final static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	private static int idd=0 ;
	

	public static ArrayList<Utilisateur> lister()
	{
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
			Connection connexion = ConnexionManager.getConnection();
			Statement req = connexion.createStatement();
			ResultSet resultat = req.executeQuery("SELECT * FROM utilisateur");
			
			int id ;
			String nom, prenom, login, password;
			
			while (resultat.next()) {
				id = resultat.getInt("id");
				nom = resultat.getString("nom");
				prenom = resultat.getString("prenom");
				login = resultat.getString("login");
				password = resultat.getString("password");
				
				utilisateurs.add(new Utilisateur(id, nom, prenom, login, password));
				
			}
			resultat.close();
			connexion.close();
			
		} catch (Exception e) {
			System.err.println("erreur durant la récupération de la liste des utilisateur");
		}
		
		return utilisateurs ;
	}
	
	public static boolean login(String login,String password) {
		try {
			Connection connexion = ConnexionManager.getConnection();
			PreparedStatement requete = connexion.prepareStatement("SELECT * FROM utilisateur WHERE login = ? AND password = ?");
			
			requete.setString(1, login);
			requete.setString(2, password);
			ResultSet resultat = requete.executeQuery();
			
			
			if (resultat.next()) {
				return true ;
			}
			
			requete.close();
			connexion.close();
		} catch (Exception e) {
			System.err.println("ERRREUR :: "+e);
			System.err.println("erreur de connection ");
		}
		return false ;
	}
	
	public static boolean ajouter(Utilisateur utilisateur)
	{
		
		try {
			Connection connexion = ConnexionManager.getConnection();
			String requete = "INSERT INTO Utilisateur(nom, prenom, login, password) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(requete);
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			
			int userteRows = preparedStatement.executeUpdate();
			
			if (userteRows == 1) {
				return true ;
			}
			
			preparedStatement.close();
			connexion.close();
			
		} catch (Exception e) {
			System.err.println("erreur insertion");
		}
		
		return false ;
	}
	
	public static boolean supprimer(int id) {
		
		try {
				Connection connexion = ConnexionManager.getConnection();
				String requete = "DELETE FROM Utilisateur WHERE id = ?";
				PreparedStatement preparedStatement = connexion.prepareStatement(requete);
				preparedStatement.setInt(1, id);
				
				int deleteRows = preparedStatement.executeUpdate();
				
				if (deleteRows == 1) {
					return true ;
				}
				
				preparedStatement.close();
				connexion.close();
			
		} catch (Exception e) {
			System.err.println("ERRREUR :: "+e);
			System.err.println("erreur de la suppression de utilisateur N° "+id);
		}
		
		return false ;
	}
	
	public static Utilisateur get(int id) 
	{
		
		Utilisateur utilisateur = null ;                   
		try {
			Connection connexion = ConnexionManager.getConnection();
			PreparedStatement requete = connexion.prepareStatement("SELECT * FROM Utilisateur WHERE id = ?");
			requete.setInt(1, id);
			ResultSet resultat = requete.executeQuery();
			
			
			String nom, prenom, login, password;
			
			while (resultat.next()) {
				id = resultat.getInt("id");
				nom = resultat.getString("nom");
				prenom = resultat.getString("prenom");
				login = resultat.getString("login");
				password = resultat.getString("password");
				
				utilisateur = new Utilisateur(id, nom, prenom, login, password);
				
			}
			resultat.close();
			connexion.close();
			
		} catch (Exception e) {
			System.err.println("erreur durant la récupération de la liste des utilisateur");
		}
		
		return utilisateur ;
		
	}
	
	public static Utilisateur getUser(String login, String passwd) 
	{
		
		Utilisateur utilisateur = null ;                   
		try {
			Connection connexion = ConnexionManager.getConnection();
			PreparedStatement requete = connexion.prepareStatement("SELECT * FROM Utilisateur WHERE login = ? AND password = ?");
			requete.setString(1, login);
			requete.setString(2, passwd);
			ResultSet resultat = requete.executeQuery();
			
			int id ;
			String nom, prenom, loginU, password;
			
			while (resultat.next()) 
			{
				id = resultat.getInt("id");
				nom = resultat.getString("nom");
				prenom = resultat.getString("prenom");
				loginU = resultat.getString("login");
				password = resultat.getString("password");
				
				utilisateur = new Utilisateur(id, nom, prenom, loginU, password);
				
			}
			resultat.close();
			connexion.close();
			
		} catch (Exception e) {
			System.err.println("erreur durant la récupération de la liste des utilisateur");
		}
		
		return utilisateur ;
		
	}
	
	public static boolean modifier(Utilisateur utilisateur) {
		
		try {
			Connection connexion = ConnexionManager.getConnection();
			String requete = "UPDATE Utilisateur SET nom=?, prenom = ?, login=?, password = ? WHERE id = ?";
			PreparedStatement preparedStatement = connexion.prepareStatement(requete);
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			preparedStatement.setInt(5, utilisateur.getId());
			
			int updateRows = preparedStatement.executeUpdate();
			
			if (updateRows == 1) {
				return true ;
			}
			
			preparedStatement.close();
			connexion.close();
			
		} catch (Exception e) {
			System.err.println("erreur Mise à jour");
		}
		
		return false ;
		
	}
}
