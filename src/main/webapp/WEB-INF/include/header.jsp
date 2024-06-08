<% final String APP_ROOT = request.getContextPath(); %>

<%@ page language="java" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestion des Utilisateurs</title>
	<link rel="stylesheet" type="text/css" href="./css/main.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">


</head>
<body>
	<header>GESTION DES UTILISATEURS</header>
	
	<div class="nav">
		<a href="/GestionUser/" class="navi">Accueil</a>
		<a href="/GestionUser/list" class="navi">Lister</a>
		<a href="/GestionUser/ajout" class="navi">Ajouter</a>
		<a href="/GestionUser/logout" class="navi">Déconnexion</a>
	</div>