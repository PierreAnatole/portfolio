<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="medical.fr.Patient" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editer un patient</title>
<%
Patient p = (Patient) request.getAttribute("p");
%>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
<div class="w-50 mx-auto">
	<h2 class="text-center">Formulaire d'édition d'un patient</h2>
	<form name="createVille" method="post" action="">
		<div class="mb-3">
		  <label for="prenom" class="form-label">Prénom</label>
		  <input type="text" class="form-control" id="prenom" placeholder="Prénom" name="prenom" value="<%= p.getPrenom() %>">
		</div>
			
		<div class="mb-3">
		  <label for="nom" class="form-label">Nom</label>
		  <input type="text" class="form-control" id="nom" placeholder="Nom" name="nom" value="<%= p.getNom() %>">
		</div>
		
		
		
		<div class="mb-3">
		  <label for="telephone" class="form-label">Téléphone</label>
		  <input type="text" class="form-control" id="telephone" placeholder="Téléphone" name="telephone" value="<%= p.getTelephone() %>">
		</div>
		
		<div class="mb-3">
		  <label for="email" class="form-label">Email</label>
		  <input type="email" class="form-control" id="email" placeholder="Email" name="email" value="<%= p.getEmail() %>">
		</div>
		
		<button type="submit" class="btn btn-secondary">Valider</button>
		
	</form>
</div>
</body>
</html>