<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Users</title>
</head>
<body>
<br><br>
<h3>Search Users By Username</h3>
<form action="/searchWithName" method="post">

Enter Username :<input type="text" name="usrnm">
<input type="submit" value="Search Users">

</form>

<br><br><br><br>

<h3>Search Users by UserPhone No.</h3>

<form action="/searchByPhone" method="post">
Enter the phone no. of User:<input type="text" name="phone">

<input type="submit" value="Search Users">

</form>

</body>
</html>