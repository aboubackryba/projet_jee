<%@page import="java.util.ArrayList"%>
<%@page import="beans.Utilisateur"%>


<%@include file="include/header.jsp"  %>
	
	<section>
		<% Utilisateur  user = (Utilisateur) request.getAttribute("usertoupdate") ;  %>
		
		<form method="post" class="contenu">
			<fieldset>
			 	<legend  align="left"><h1>Modification de l'utilisateur</h1></legend>
				<label>Nom</label><br>
				<input type="text" name="nom" value="<%= user.getNom() %>" class="input"><br><br>
				<label>Prenom</label><br>
				<input type="text" name="prenom" value="<%= user.getPrenom() %>" class="input"><br><br>
				<label>Login</label><br>
				<input type="text" name="login" value="<%= user.getLogin() %>" class="input"><br><br>
				<label>Mot de passe</label><br>
				<input type="password" name="password" value="<%= user.getPassword() %>" class="input"><br><br>
				
				<input type="submit" value="Modifier">
			</fieldset>
		</form>
		
	</section>
	<%@include file="include/footer.jsp"  %>
</body>
</html>