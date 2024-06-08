<%@include file="include/header.jsp"  %>
	
	<section>
		
		<form method="post" class="contenu">
			<fieldset>
			 	<legend align="left" ><h1>Ajout d'un utilisateur</h1></legend>
			 	<table align="center" id="table" cellspacing="6" cellpadding="6" >
			 		<tr>
                        <td><label for="">Nom</td>
                        <td>
                        	<input type="text" name="nom" class="input" value="${ user.nom }"><br>
                        	<span class="erreur">${ erreurs.nom }</span>
                        </td>
                        <td><label for="">Prenom</td>
                        <td>
                        	<input type="text" name="prenom" class="input" value="${ user.prenom }"><br>
                        	<span class="erreur">${ erreurs.prenom }</span>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="">Login</td>
                        <td>
                        	<input type="text" name="login" class="input" value="${ user.login }"><br>
                        	<span class="erreur">${ erreurs.login }</span>
                        </td>
                        <td><label for="">Mot de passe</td>
                        <td>
                        	<input type="password" name="password" class="input"><br>
                        	<span class="erreur">${ erreurs.password }</span>
                        </td>
                    </tr>
                    <tr >
                        <td><label for="">Confirmation du mot de passe</td>
                        <td>
                        	<input type="password" name="passwordConf" class="input"><br>
                        	<span class="erreur">${ erreurs.passwordConf }</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5"><input type="submit" class="btn-submit" value="Ajouter"> <input type="reset" class="btn-reset" value="Annuler"></td>
                        
                    </tr>
					
					 <br><br>
				</table>
			</fieldset>
		</form>
		
	</section>
	<%@include file="include/footer.jsp"  %>
</body>
</html>