package forms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public class AjoutForm {
	
	private static final String CHAMP_NOM = "nom" ; 
	private static final String CHAMP_PRENOM = "prenom" ; 
	private static final String CHAMP_LOGIN = "login" ; 
	private static final String CHAMP_PASSWORD= "password" ; 
	private static final String CHAMP_PASSWORD_CONF = "passwordConf" ; 
	
	private Map<String, String> erreurs ; //tableau associative
	private String statusMessage ;
	private boolean status ;
	private HttpServletRequest request ;
	private Utilisateur utilisateur ;
	
	public AjoutForm(HttpServletRequest request) 
	{
		this.request = request ;
		this.erreurs = new HashMap<String, String>();
	}
	
	public boolean ajouter() {
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		
		this.utilisateur = new Utilisateur(nom,prenom,login,password);
		
		this.statusMessage = "Echec de l'ajout ";
		this.status = false ;
		
		this.validerChamps(CHAMP_NOM,CHAMP_PRENOM,CHAMP_LOGIN,CHAMP_PASSWORD,CHAMP_PASSWORD_CONF);
		this.validerPasswords();
		
		
		
		if (this.erreurs.isEmpty()) {
			if (UtilisateurDao.ajouter(utilisateur)) {

				this.statusMessage = "Ajout effectué avec succès ! ";
				this.status = true;
			}
		}
		
		return this.status ;
	}
	
	private String getParameter(String parametre) 
	{
		String valeur = this.request.getParameter(parametre);
		
		if (valeur == null || valeur.isBlank()) 
		{
			return null  ;
		}
		
		return valeur.trim();
	}
	
	private void validerChamps(String... champs) // les elipse
	{
		for (String champ : champs) 
		{
			if (this.getParameter(champ) == null) 
			{
				this.erreurs.put(champ, "Vous devez renseigner le champ !");
				
			}
		}
	}
	
	private void validerPasswords()
	{
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordConf = this.getParameter(CHAMP_PASSWORD_CONF);
		
		if (password != null && !password.equals(passwordConf)) 
		{
			this.erreurs.put(CHAMP_PASSWORD, "Les mots de passe ne sont pas conformes");
			this.erreurs.put(CHAMP_PASSWORD_CONF, "Les mots de passe ne sont pas conformes");
			
		}
		
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public boolean isStatus() {
		return status;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	
	
}
