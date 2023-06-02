<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>View Reports Filtered by Date</h2>
<br><br><br><br>


<form action="/repByDate" method="post">
Enter Date of Report :<input type="date" name="dateOfPurchase"><br><br>
<input type="submit" value="Show Reports">

</form>

</body>
</html>