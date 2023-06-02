<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>

<form action="/register/process" method="post">
UserName: <input type=text name="username"><br><br>
Password: <input type=password name="pwd"><br><br>
Phone No.: <input type=text name="phone"><br><br>

<input type="submit"  value="Register">


</form>

</body>
</html>