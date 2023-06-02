<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Details of User</h3>
<table border="1">
<tr>
<th>Id</th>
<th>Username</th>
<th>Active</th>
<th>UserType</th>
<th>User Phone</th>
</tr>

<tr>
<td>${users.id}</td>
<td>${users.username}</td>
<td>${users.active}</td>
<td>${users.userType}</td>
<td>${users.userPhone}</td> 
</tr>

</table>
<br><br><h3>${msg}</h3>

<br><br><br><br>
<a href="/adminDash">Click here to go to Admin Dashboard</a>
</body>
</html>