<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<form action="validation" method="post">
	    <label for="login">Nom d'utilisateur</label>
	    <input type="text" name="login" id="login">
	
	    <label for="password">mot de passe</label>
	    <input type="text" name="password" id="password">
	
	    <input type="submit" value="envoyer">
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>