package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter({"/","/ajout","/list","/update","/delete"})
public class AuthenticationFilter implements Filter{
	@Override
	public void doFilter(ServletRequest requset, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		HttpServletRequest servletRequest = (HttpServletRequest) requset ;
		HttpServletResponse servletResponse = (HttpServletResponse) response ;
		
		HttpSession session = servletRequest.getSession();
		
		if (session.getAttribute("utilisateur") !=null) 
		{
			
			chain.doFilter(requset, response);   
		}
		
		else 
		{
			servletResponse.sendRedirect("login");
		}
		
		
		
	}
}
