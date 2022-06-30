<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="validation.jsp" method="post">
	    <label for="login">Nom d'utilisateur</label>
	    <input type="text" name="login" id="login">
	
	    <label for="password">mot de passe</label>
	    <input type="text" name="password" id="password">
	
	    <input type="submit" value="envoyer">
	</form>
</body>
</html>