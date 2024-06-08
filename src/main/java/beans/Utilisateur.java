package beans;

public class Utilisateur {
	
	private int id;
	private String nom,prenom,login,password ;
	
	public Utilisateur() {}
	public Utilisateur(String nom,String prenom,String login, String password) 
	{
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}
	public Utilisateur(int id,String nom,String prenom,String login, String password) 
	{
		this.id = id ; 
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}

}
