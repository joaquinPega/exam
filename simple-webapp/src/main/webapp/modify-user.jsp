<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="Stylesheet" href="css/Style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new user</title>
</head>
<body>
	<div>
		<a href="http://localhost:8080/simple-webapp/logout" id="logout">Logout</a>
	</div>
	<h1>Please modify a user:</h1>
	<p align="center">
		<i> aca va el nombre de usuario a modificar
	</p>
	<table>

		<tr>
			<th>Name:<input type="text" id="username" class="inputBox"><br>
				<br></th>

			<th>Company:<input type="text" id="company" class="inputBox"><br>
				<br></th>
			<th>Job title:<input type="text" id="job" class="inputBox"><br>
				<br></th>
			<th>E-mail:<input type="text" id="email" class="inputBox"><br>
				<br></th>
		</tr>



	</table>
	<center>
		<input type="Submit" id="add" value="Submit changes" method="post">
	</center>

</body>
</html>