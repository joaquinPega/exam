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
		<a href="main.jsp" id="logout">Logout</a>
	</div>
	<h1>Welcome %username%!</h1>
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
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					
				</tr>
				
			</table>
		</center>
		<br>
		<center>
			<input
				class="adminButtons" type="button" value="Modify profile">
		</center>

	</div>
	<br>
	<br>
	
	
</body>
</html>