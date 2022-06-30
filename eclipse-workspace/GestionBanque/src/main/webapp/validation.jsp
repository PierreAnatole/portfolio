<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="entities.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>Validation</h1>
	<% User user = (User) request.getAttribute("user"); %>
	<% String login = user.getUsername(); %>
	<% String password = user.getPassword(); %>
	<div>
	<c:out value="Bonjour" /><br/>
		Nom d'utilisateur : <%= login %>
	</div>
	<% Date date = new Date();
	int heure = date.getHours(); %>
	<p>
	Il est <%= heure %>h
	<% if (heure <= 11){ %>
	du matin
	<% } else if (heure == 12) { %>
	(midi)
	<% } else if ( (heure >= 13) && (heure <= 18) ) { %>
	de l'après midi
	<% } else if (heure > 18) { %>
	du soir
	<% } %>
	</p>
	<jsp:include page="footer.jsp" />
</body>
</html>