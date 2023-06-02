<%@ page import="java.util.List" %>
<%@ page import="org.simplilearn.entities.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>List of All Products</h2>
<br><br><br><br>
<table border="1">
<tr>
<th>Product Id</th>
<th>Product name</th>
<th>Description</th>
<th>Category</th>
<th>Price</th>
</tr>

<%
List<Product> prod1=(List<Product>)request.getAttribute("products1");

for(Product p: prod1){

%>

<tr>

<td><%=p.getPid() %></td>
<td><%=p.getName() %></td>
<td><%=p.getDescription() %></td>
<td><%=p.getCategory() %></td>
<td><%=p.getPrice() %></td>
</tr>
<%
}

%>
</table>

<br><br><br><br><br>
<a href="/adminDash">Click here to go to Admin Dashboard</a>
</body>
</html>