<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="medical.fr.Patient" %>
<%@ page import="java.util.ArrayList" %>
<%
ArrayList<Patient> lp = ( ArrayList<Patient> ) request.getAttribute("pdaoParam");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des patients</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

<style>
	* {
	font-family : arial;
	font-size:16px
	}
</style>
</head>
<body class='w-50 mx-auto'>
<h1>Liste des patients</h1>

<a href='addpatient' class='btn btn-primary'>Ajouter un patient</a>

<table class='table table-striped mt-4' width='100%' border='1'>
<thead>
<tr>
	<th>ID</th>
	<th>Nom et Prénom **</th>
	<th>Email</th>
	<th>Téléphone</th>
	<th>Actions</th>
	
</tr>
</thead>
<tbody>
	<% 
	for (Patient p : lp) { %>
	<tr>
	<td><%= p.getId() %></td> 
	<td><%= p.getPrenom() %> <%= p.getNom() %></td>
	<td><%= p.getEmail() %></td>
	<td><%= p.getTelephone() %></td>
	<td>
		<a href="updatepatient?id=<%= p.getId() %>" class="btn btn-sm btn-info">E</a>
		<a href="deletepatient?id=<%= p.getId() %>" class="btn btn-sm btn-danger">x</a>
	</td>
	</tr>
	<% }  %>
</tbody>
</table>

</body>
</html>