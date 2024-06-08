<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de connexion</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<% String logErreur = request.getAttribute("logErreur")+""; %>
<body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<section class="donate-page-area pt-90 pb-80">
	    <div class="container mt-4">
		
		
	      <div class="row justify-content-center">
	          	<%
	          		if(request.getAttribute("statusMessage") !=null)
	          		{%>
			          	<div class="alert alert-warning alert-dismissible fade show text-center" role="alert">
						  <strong>Echec de la connexion : </strong> ${ statusMessage }
						</div>
	          		<%	
	          		}
	          
	          	%>
	          	
	        <div class="col-lg-5">
	          <div class="card mt-4">
	            <div class="card-header">
	              <h3 class="card-title text-center">Connexion</h3>
	            </div>
	            <div class="card-body">
	              <form action="" class="form" method="POST">
	                <div class="form-group mt-4">
	                  <label for="login">Nom d'utilisateur</label>
	                  <input type="text" class="form-control" id="login" name="login" placeholder="Username" value="${ login }" autofocus=true>
	                </div>
	                <div class="form-group mt-4">
	                  <label for="password">Mot de passe</label>
	                  <input type="password" class="form-control" id="password" name="password" placeholder="Mot de passe">
	                </div>
	                <div class="text-center mt-4">
	                  <button type="submit" class="btn btn-primary">Se connecter</button>
	                </div>
	              </form>
	              <br>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </section>
</body>
</html>