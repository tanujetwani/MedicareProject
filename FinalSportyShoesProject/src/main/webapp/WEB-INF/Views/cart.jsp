<%@ page import="java.util.List" %>
<%@ page import="org.simplilearn.entities.Cart" %>
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
<h2> Cart of user    ${sessionScope.cuser.username}</h2>
<table border="1">

<tr>
<th>Prod Id</th>
<th>Product Name</th>
<th>Category</th>
<th>Desrciption</th>
<th>Price</th>
<th>Quantity</th>
<tr>

<%
List<Cart> carts=(List<Cart>)request.getAttribute("cart1");


for(Cart c: carts){
	
    Product prod=c.getProd();
    
%>

<tr>
<td><%=prod.getPid() %></td>
<td><%=prod.getName() %></td>
<td><%=prod.getCategory() %></td>
<td><%=prod.getDescription() %></td>
<td><%= prod.getPrice() %></td>
<td><%=c.getQty() %></td>
</tr>
<!-- <td> 

<form action="/removeFromCart" method="post">
<input type=hidden name="pid" value="<%=prod.getPid() %>">
<button>Remove from Cart</button>

</form>
</td>
-->
<%
}
%>


</table>
<br><br><br>
<form action="/buyProd" method="post">
<input type="submit" value="Buy">

</form>
<br><br><br><br><br><br>
<a href="/logout">Logout</a>
</body>
</html>