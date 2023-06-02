<%@ page import="java.util.List" %>
<%@ page import="org.simplilearn.entities.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Dashboard</title>
</head>
<body>


<h2>Hi ${sessionScope.cuser.username} , Welcome to Customer Dashboard</h2>

<table border='1'>
<tr>
<th>ID</th>
<th>Product Name</th>
<th> Description</th>
<th>Category</th>
<th>Price</th>
</tr>

<%

List<Product> prod1=(List<Product>)request.getAttribute("products1");

for(Product p : prod1){

%>

<tr>
<td><%=p.getPid() %></td>
<td><%=p.getName() %></td>
<td><%=p.getDescription() %></td>
<td><%=p.getCategory()%></td>
<td><%=p.getPrice() %></td>

<td>

<form action="/addToCart" method="post">
<input type=hidden name="pid" value="<%=p.getPid()%>">
<input type="submit" value="Add To Cart">

</form>
</td>



<td>
<form action="/removeFromCart" method="post">
<input type=hidden name="pid" value="<%=p.getPid() %>">

<button>Remove from Cart</button>
</form>
</td>
</tr>
<%
}
%> 

</table>
<br><br><br>
<form action="/viewCart" method="post">
<input type="submit" value="View Cart">
</form>

<br><br><br><br><br><br><br>
<a href="/logout">Logout</a>
</body>
</html>