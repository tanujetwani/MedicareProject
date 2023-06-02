<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> View Reports filtered by Category of Product</h2>
<br><br><br>

<form action="/repByCate" method="post">
Enter Category of Product: <select name="category1">
<option value="BasketBall">BasketBall</option>
<option value="Cricket">Cricket</option>
<option value="VolleyBall">VolleyBall</option>
<option value="Running">Running</option>
<option value="Gymnastics">Gymnastics</option>
</select><br><br>
<input type="submit" value="Search Reports">


</form>

</body>
</html>