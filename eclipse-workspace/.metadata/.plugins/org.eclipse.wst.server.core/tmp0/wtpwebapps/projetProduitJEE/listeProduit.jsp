<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Produit" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<style>
	table {
    	background-color: aliceblue;
	}
</style>
</head>
<body>
<%
ArrayList<Produit> lp = ( ArrayList<Produit> ) request.getAttribute("produits");
%>

<h1>Liste des produits</h1>

<a href='AddProduit' class='btn btn-primary'>Ajouter un produit</a>

<table class='table table-striped mt-4' width='100%' border='1'>
	<thead>
		<tr>
			<th>ID</th>
			<th> designation</th>
			<th> prix </th>
			<th> quantite</th>
			<th>Actions</th>
		</tr>
	</thead>
	
	<tbody>
		<% for (Produit p : lp) { %>
		<tr>
			<td><%= p.getId() %></td> 
			<td><%= p.getDesignation() %></td>
			<td><%= p.getPrix() %></td>
			<td><%= p.getQuantite() %></td>
			<td>
				<a href="UpdateProduit?id=<%= p.getId() %>" class="btn btn-sm btn-info">E</a>
				<a href="DeleteProduit?id=<%= p.getId() %>" class="btn btn-sm btn-danger">x</a>
			</td>
		</tr>
		<% }  %>
	</tbody>
</table>
</body>
</html>