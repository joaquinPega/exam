<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type="text/css" rel="Stylesheet" href="css/Style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator page</title>
</head>
<body>
	<h1>Welcome administrator!</h1>
	<div>
		<h2>Users List</h2>
		<center>
			<table class="table">
				<tr>
					<th>Name</th>
					<th>Company</th>
					<th>Job title</th>
					<th>E-mail</th>
					<th>Select:</th>
				</tr>
				<tr>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th><input name="select" type="radio" /></th>
				</tr>				
				<tr>siguiente linea</tr>
				<tr>siguiente linea</tr>
				<tr>siguiente linea</tr>
			</table>
		</center>
		<br>
		<center>
			<input class="adminButtons" type="button"
				value="Create user"><input class="adminButtons"
				type="button" value="Modify user"><input class="adminButtons"
				type="button" value="Delete user">
		</center>

	</div>
	<div><p Search for user:><input type="text" id="searchBox" value="Search here...">
	<input type="button" value="Search" action="search.jsp"></div>
</body>
</html>