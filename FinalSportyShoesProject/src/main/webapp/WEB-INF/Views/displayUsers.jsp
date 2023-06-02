<%@page import="org.simplilearn.entities.User"%>
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

<h2>The list of Users who have signed up</h2>

<table border="1">
<tr>
<th>Id</th>
<th>Username</th>
<th>Active</th>
<th>Phone no.</th>
</tr>

<%
List<User> users=(List<User>)request.getAttribute("allUsers");

for(User u : users)
{
%>
<tr>
      <td><%=u.getId() %></td>
      <td><%=u.getUsername() %></td>
      <td><%=u.getActive() %></td>
      <td><%=u.getUserPhone() %></td>
      
</tr>      
<%
}

%>      


</table>

<br><br><br><br>
<a href="/adminDash">Click here to go to Admin Dashboard</a>
</body>
</html>