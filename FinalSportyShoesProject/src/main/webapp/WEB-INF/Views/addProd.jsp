<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form for Adding Products</title>
</head>
<body>
<h2>Add a Product</h2>
<form action="/addProduct" method="post">
Name of Product:<input type=text name="prodName"><br><br>
Description of Product:<input type=text name="desc"><br><br>
Category of Product:<select name="category">
<option value="BasketBall">BasketBall</option>
<option value="Cricket">Cricket</option>
<option value="VolleyBall">VolleyBall</option>
<option value="Running">Running</option>
<option value="Gymnastics">Gymnastics</option>

</select><br><br>
Price:<input type=text name="price"><br><br>
<input type="submit" value="Add Product">

</form>

</body>
</html>