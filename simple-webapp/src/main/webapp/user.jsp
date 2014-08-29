<%@page import="org.simple.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type="text/css" rel="Stylesheet" href="css/Style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
</head>
<body>
	<div>
		<a href="http://localhost:8080/simple-webapp/logout" id="logout">Logout</a>
	</div>
	<h1>Welcome <%=((User)session.getAttribute("currentUser")).getName()%></h1>
	<div>
		<h2>User Profile</h2>
		<center>
			<table class="user-table">
				<tr>
					<th>Name</th>
					<th>Company</th>
					<th>Job title</th>
					<th>E-mail</th>
					
				</tr>
				<tr>
					<th><%=((User)session.getAttribute("currentUser")).getName() %></th>
					<th><%=((User)session.getAttribute("currentUser")).getCompany() %></th>
					<th><%=((User)session.getAttribute("currentUser")).getJobTitle() %></th>
					<th><%=((User)session.getAttribute("currentUser")).getEmail() %></th>
					
				</tr>
				
			</table>
		</center>
		<br>
		<center>
		<form name="modifyForm" action="modifyUser" method="get">
			<input
				class="adminButtons" type="submit" value="Modify profile"></form>
		</center>

	</div>
	<br>
	<br>
	
	
</body>
</html>