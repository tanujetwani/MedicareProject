<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>


<h2> Hi ${sessionScope.cuser.username}, Welcome to Admin Dashboard</h2>
<a href="/listOfUsers">Click here to get a List of Users who have Signed Up</a><br><br>
<a href="/searchUsers">Click here to search Users</a><br><br>

<br><br><br>
<a href="/addProd">Add a Product to Product List</a><br><br><br>
<a href="/deleteProd">Delete a Product from Product List</a><br><br><br>
<a href="/getAllProd">Get a List of all Products</a><br><br><br>
<a href="/addCategory">Categorize Products</a><br><br>

<br><br><br>
<a href="/reportsByDate">See Purchase reports filtered by Date</a><br><br>
<a href="/reportsByCategory">See Purchase reports filtered by category</a><br><br>

<br><br><br>
<a href="/logout">Logout</a>

</body>
</html>