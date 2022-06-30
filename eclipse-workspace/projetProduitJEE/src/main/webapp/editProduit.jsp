<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Produit" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edition produit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<%
	Produit produit = (Produit) request.getAttribute("produit");
%>
<div class="w-50 mx-auto">
	<h2 class="text-center">Formulaire d'édition d'un produit</h2>
	<form name="edition_produit" method="post" action="ExecuteUpdate">
	
		<div class="mb-3">
    		<label for="designation" class="form-label">Designation</label>
    		<input type="text" class="form-control" id="designation" name="designation" value="<%= produit.getDesignation() %>">
		</div>
			
		<div class="mb-3">
    		<label for="prix" class="form-label">prix</label>
    		<input type="text" class="form-control" id="prix" name="prix" value="<%= produit.getPrix() %>">
		</div>
		
		<div class="mb-3">
    		<label for="quantite" class="form-label">quantite</label>
    		<input type="text" class="form-control" id="quantite" name="quantite" value="<%= produit.getQuantite() %>">
		</div>
		
		<input type="hidden" name="id" value="<%= produit.getId()%>" >
		
		<button type="submit" class="btn btn-secondary">Valider</button>
		
	</form>
</div>
</body>
</html>