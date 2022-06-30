<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout produit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="w-50 mx-auto">
	<h2 class="text-center">Formulaire d'ajout d'un produit</h2>
	<form name="ajout_produit" method="get" action="ExecuteAdd">
	
		<div class="mb-3">
    		<label for="designation" class="form-label">Designation</label>
    		<input type="text" class="form-control" id="designation" name="designation">
		</div>
			
		<div class="mb-3">
    		<label for="prix" class="form-label">prix</label>
    		<input type="text" class="form-control" id="prix" name="prix">
		</div>
		
		<div class="mb-3">
    		<label for="quantite" class="form-label">quantite</label>
    		<input type="text" class="form-control" id="quantite" name="quantite">
		</div>
		
		<button type="submit" class="btn btn-secondary">Ajouter</button>
		
	</form>
</div>
</body>
</html>