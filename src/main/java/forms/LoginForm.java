package forms;


import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginForm {
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	
	private String statusMessage ;
	private boolean status ;
	private HttpServletRequest request ;
	private String login ; 
	
	public LoginForm(HttpServletRequest request)
	{
		this.request = request ;
		this.status = false ;
		this.statusMessage = "login et/ou mot de passe incorrect";
		
	}
	
	public boolean login()
	{
		this.login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);
		
		Utilisateur loggedUser = UtilisateurDao.getUser(login, password);
		
		if(loggedUser != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", loggedUser);
			
			return true ;
		}
		
		return false ;
	}
	public void logout() {
		HttpSession session = request.getSession();
		session.invalidate();
		
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
	
	public String getStatusMessage() {
		return statusMessage;
	}
	public boolean isStatus() {
		return status;
	}
	
	public String getLogin() {
		return this.login;
	}

}
