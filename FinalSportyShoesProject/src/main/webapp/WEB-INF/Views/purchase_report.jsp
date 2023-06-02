<%@ page import="org.simplilearn.entities.Order" %>
<%@ page import="java.util.List" %>
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

<h2>Hello ${sessionScope.cuser.username} , Below is ur Order Report</h2>
<%

Order ord=(Order)request.getAttribute("order");

%>

<table border="1">
<tr>
<th>Order ID</th>
<th>Order Date</th>
</tr>

<tr>
<td><%=ord.getOrder_id() %></td>
<td><%=ord.getOrder_date() %></td>
</tr>

</table>

<h2>Details of Products bought are as follows</h2>
<table border="1">
<tr>
<td>Product Id</td>
<td>Product Name</td>
<td>Description</td>
<td>Category</td>
<td>Price Per unit</td>
<td>Quantity</td>
<td>Amount</td>
</tr>

<%

List<OrderDetails> ord_det2=(List<OrderDetails>)request.getAttribute("ord_dets1");

for(OrderDetails order_det :ord_det2){
	
	Product prod=order_det.getProduct();

%>

<tr>
<td><%=prod.getPid() %></td>
<td><%=prod.getName() %></td>
<td><%=prod.getDescription() %></td>
<td><%=prod.getCategory() %></td>
<td><%=prod.getPrice() %></td>
<td><%=order_det.getQuty() %></td>
<td><%=order_det.getAmount() %></td>
<tr>
<%
}
%>
</table>

<h2>Total Amount to be Paid= <%=ord.getTotal_amount() %></h2>

<form action="/paytheamount" method="post">
<input type="submit" value="Pay the Total Amount">

</form>
</body>
</html>