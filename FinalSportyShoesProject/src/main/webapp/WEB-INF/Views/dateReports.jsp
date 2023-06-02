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
<h2>Filtered Reports By Date</h2>
<br><br><br>

<%
Set<Order> orderByDate=(Set<Order>)request.getAttribute("ordersByDate");

for(Order o: orderByDate){
	
  
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

<h3>Details of the Order are:</h3>
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

Set<OrderDetails> ord_dets=o.getOrd_details();

for(OrderDetails odet: ord_dets){
	
	   Product prod=odet.getProduct();

%>


<tr>
<td><%=prod.getPid() %></td>
<td><%=prod.getName() %></td>
<td><%=prod.getDescription() %></td>
<td><%=prod.getCategory() %></td>
<td><%=prod.getPrice() %></td>
<td><%=odet.getQuty() %></td>
<td><%=odet.getAmount() %></td>
</tr>	   

	   
<%
}

%>


</table> 



<h3>Total Amount paid : <%=o.getTotal_amount() %></h3>


<br><br><br><br>
<%

}
%>	   



<a href="/adminDash">Click here to go to Admin Dashboard</a>

</body>
</html>