package servelets;

import java.io.IOException;

import javax.swing.JOptionPane;

import dao.UtilisateurDao;
import forms.LoginForm;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/login","/logout"})
public class Login extends HttpServlet{
	
	private static final String VUE_USER ="/WEB-INF/loginPage.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		switch (request.getServletPath())
		{
			case "/login": 
			{
				getServletContext().getRequestDispatcher(VUE_USER).forward(request, response);
				break ;
			}
			default:
			{
				LoginForm form = new LoginForm(request);
				form.logout();
				response.sendRedirect("login");
			}
				
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		LoginForm form = new LoginForm(request);
		
		if (form.login()) {
			
			response.sendRedirect("list");
		}
		else {
			request.setAttribute("login", form.getLogin());
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			
			getServletContext().getRequestDispatcher(VUE_USER).forward(request, response);
		}
		 
		/* if (UtilisateurDao.login(username, password)) 
		{
			
			response.sendRedirect("list");
		}
		
		else {
			String logErreur = "Username et/ou Mot de passe incorrect !!";
			request.setAttribute("logErreur", logErreur);
			getServletContext().getRequestDispatcher(VUE_USER).forward(request, response);
		} */
		
		
	}
}
