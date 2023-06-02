<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%@ page import="org.simplilearn.entities.Order" %>
<%@ page import="org.simplilearn.entities.OrderDetails" %>
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
<h2>Reports By Category</h2>
<br><br><br>

<%
Set<Order> orderByCat=(Set<Order>)request.getAttribute("ordbycat");

for(Order o :orderByCat){
	
%>
	
<table border="1">
<tr>
<th>Order No.</th>
<th>Order Date</th>
<th>Customer Name</th>
</tr>

<tr>
<td><%=o.getOrder_id() %></td>
<td><%=o.getOrder_date() %></td>
<td><%=o.getUser().getUsername() %></td>
</tr>

</table>

<h3>Details of the Order are</h3>

<table border="1">
<tr>
<th>Product ID</th>
<th>Product Name</th>
<th>Description</th>
<th>Category</th>
<th>Price per unit</th>
<th>Quantity ordered</th>
<th>Amount</th>
</tr>	

<%
        Set<OrderDetails> ord_det2=o.getOrd_details();          

      for(OrderDetails od:ord_det2){
       
    	  Product p=od.getProduct();
     
%>

<tr>
<td><%=p.getPid() %></td>
<td><%=p.getName() %></td>
<td><%=p.getDescription() %></td>
<td><%=p.getCategory() %></td>
<td><%=p.getPrice() %></td>
<td><%=od.getQuty() %></td>
<td><%=od.getAmount() %></td>
</tr>	   


<%
      }
%>

</table>

<h3>Total Amount Paid: <%=o.getTotal_amount() %> </h3>
<br><br><br><br><br>

<%
}
%>

<a href="/adminDash">Go to Admin Dashboard</a><br><br>

</body>
</html>