
<%@page import="org.simplilearn.demo.entities.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome to Employee Management</h1>

<table border="1">
<tr>
<th>Eno</th>
<th>Name</th>
<th>Address</th>
</tr>

<%

List<Emp> emp1=(List<Emp>)request.getAttribute("emps");
for(Emp e : emp1 )
{	
%>
<tr>
          <td><%=e.getEno() %></td>
          <td><%=e.getName() %></td>
          <td><%=e.getAddress() %></td>
          </tr>
	
<%
}

%>


	


</table>

</body>
</html>