<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>form for Deleting Product</title>
</head>
<body>

<h3>Delete Product By name</h3>
<form action="/deletebyname" method="post">
Name of Product:<input type=text name="nameofprod"><br><br>
<input type="submit" value="Delete Product">
</form>

<br><br><br>

<h3>Delete Product By Id</h3>
<form action="/deletebyid" method="post">
Id of Product:<input type=text name="pid"><br><br>
<input type="submit" value="Delete Product">
</form>

<br><br><br>
<h3>Delete Product By Category</h3>
<form action="/deletebycategory" method="post">
Category: <select name="category">
<option value="BasketBall">BasketBall Shoes</option>
<option value="Running">Running Shoes</option>
<option value="Cricket">Cricket Shoes</option>
<option value="Gymnastics">Gymnastic Shoes</option>
<option value="VolleyBall">VolleyBall Shoes</option>
</select>

<input type="submit" value="Delete Product">
</form>


</body>
</html>