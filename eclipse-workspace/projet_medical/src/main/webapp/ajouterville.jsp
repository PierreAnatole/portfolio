<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="medical.fr.VilleDAO" %>

<%
    String nom = request.getParameter("nom");
	String pays = request.getParameter("pays");
	out.println( "Nom saisi " + nom );
	if( nom != null ){
		int cp = Integer.parseInt(request.getParameter("cp"));
		VilleDAO vdao = new VilleDAO();
		vdao.createVille( nom, cp, pays );
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter une ville</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
<div class="w-50 mx-auto">
	<h2 class="text-center">Formulaire d'ajout d'une ville en JSP</h2>
	<form name="createVille" method="post" action="">
		<div class="mb-3">
		  <label for="nom" class="form-label">Nom</label>
		  <input type="text" class="form-control" id="nom" placeholder="Nom" name="nom">
		</div>
		
		<div class="mb-3">
		  <label for="cp" class="form-label">Code postal</label>
		  <input type="number" class="form-control" id="cp" placeholder="CP" name="cp">
		</div>
		
		<div class="mb-3">
		  <label for="pays" class="form-label">Pays</label>
		  <input type="text" class="form-control" id="pays" placeholder="Pays" name="pays">
		</div>
		
		<button type="submit" class="btn btn-secondary">Valider</button>
		
	</form>
</div>
</body>
</html>