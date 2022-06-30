<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entreprise.metier.DureeInvalideException" %>
<%@ page import="com.entreprise.metier.CapitalInvalideException" %>
<%@ page import="com.entreprise.metier.EmpruntInvalideException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="formulaireEmprunt" method="post">
	    <label for="capital">capital</label>
	    <input type="text" name="capital" id="capital">
	    <% 
	    if (request.getAttribute("capitalInvalide") != null) {
	    	CapitalInvalideException dureeInvalide = (CapitalInvalideException)request.getAttribute("capitalInvalide");
	    	out.println(dureeInvalide.getMessage());
	    }
	    %>
	
	    <label for="emprunt">emprunt</label>
	    <input type="text" name="emprunt" id="emprunt">
	    <%
	    if (request.getAttribute("empruntInvalide") != null) {
	    	EmpruntInvalideException empruntInvalide = (EmpruntInvalideException)request.getAttribute("empruntInvalide");
	    	out.println(empruntInvalide.getMessage());
	    }
	    %>
	
	    <label for="duree">durée</label>
	    <input type="text" name="duree" id="duree">
	    <% 
	    if (request.getAttribute("dureeInvalide") != null) {
	    	DureeInvalideException dureeInvalide = (DureeInvalideException)request.getAttribute("dureeInvalide");
	    	out.println(dureeInvalide.getMessage());
	    }
	    %>
	    
	    <input type="submit" value="envoi">
	</form>
	
	<div>
	    <h3>mensualite</h3>
	    <p>
	    <% 
	    if (request.getAttribute("mensualite") != null) {
	    	double mensualite = (double)request.getAttribute("mensualite");
	    	out.println( Double.toString(mensualite));
	    }
	    %>
	    
	    
		
		</p>
	</div>
</body>
</html>