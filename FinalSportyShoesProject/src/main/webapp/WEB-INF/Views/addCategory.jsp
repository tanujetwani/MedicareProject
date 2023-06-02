<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Categorize Products</h2>
<form action="/addProdCategory" method="post">
Enter Id of Product:<input type=text name="pid"><br><br>
Add category : <select name="category">
<option value="BasketBall">BasketBall</option>
<option value="Cricket">Cricket</option>
<option value="VolleyBall">VolleyBall</option>
<option value="Running">Running</option>
<option value="Gymnastics">Gymnastics</option>

</select>
<input type="submit" value="Add Category">

</form>

</body>
</html>