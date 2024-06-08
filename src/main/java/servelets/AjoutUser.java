package servelets;

import java.awt.Dialog;
import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;
import forms.AjoutForm;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajout")
public class AjoutUser extends HttpServlet{
	
	private static final String ADD_USER = "/WEB-INF/ajoutUser.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADD_USER);
		
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		AjoutForm form =new AjoutForm(request);
		
		if (form.ajouter()) 
		{
			response.sendRedirect("list");
		}
		else
		{
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("user", form.getUtilisateur());
			request.setAttribute("erreurs", form.getErreurs());
			
			getServletContext().getRequestDispatcher(ADD_USER).forward(request, response);
		}
		
		/** String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Utilisateur user = new Utilisateur(nom,prenom,login,password); 
		
		UtilisateurDao.ajouter(user); **/
		
	}

}
