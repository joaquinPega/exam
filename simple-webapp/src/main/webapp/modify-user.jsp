<%@page import="java.util.List"%>
<%@page import="org.simple.model.Language"%>
<%@page import="org.simple.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%//TODO: el javascript para validar el email %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="Stylesheet" href="css/Style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/Scripts.js"></script>
<title>Modify user</title>
</head>
<body>
	<div>
		<a href="logout" id="logout">Logout</a>
	</div>
	<h1>Please modify user:</h1>
	<p align="center">
		<i><%=((User) session.getAttribute("currentUser")).getName()%></i>
	</p>
	<div id="modifyForm">
	<form name="modifyForm2" id="modifyForm2" action="changeUser" method="post" onsubmit="return validateEmail2();">
		<table>
			<%
				List<Language> languages = (List<Language>) session.getAttribute("languages");
			%>
			<tr>
				<th>Email:<input id="email" type="text" name="email"  class="inputBox"><br>
					<br></th>

				<th>Experience:<input type="text" name="newExperience"
					class="inputBox"><br> <br></th>
				<th>Language:<select name="language">
						<%
							for (int i = 0; i < languages.size(); i++) {
						%>
						<option value="<%=languages.get(i).getName()%>"><%=languages.get(i).getName()%></option>
						<%
							}
						%>
				</select> <br></th>
			</tr>



		</table>
		<center>
			<input type="submit" name="submit" value="Submit changes">
		</center>
	</form>
	</div>
	<center>
	<form action="user.jsp">
		<input type="submit" value="cancel">
	</form>
	</center>
</body>
</html>