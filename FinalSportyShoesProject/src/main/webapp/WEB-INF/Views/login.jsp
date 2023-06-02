<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>

<form action="/login/process" method="post">
Username: <input type=text name="usrnm">
<br><br>Password: <input type=password name="passwd">
<br><br>

<input type="submit" value="Login">

</form>

<p>${msg}</p> 
</body>
</html>