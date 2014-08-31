<%@page import="java.util.List"%>
<%@page import="org.simple.model.Language"%>
<%@page import="org.simple.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="Stylesheet" href="css/Style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify user</title>
</head>
<body>
	<div>
		<a href="http://localhost:8080/simple-webapp/logout" id="logout">Logout</a>
	</div>
	<h1>Please modify user:</h1>
	<p align="center">
		<i><%=((User) session.getAttribute("currentUser")).getName()%></i>
	</p>

	<form action="changeUser" method="post">
		<table>
			<%
				List<Language> languages = (List<Language>) session.getAttribute("languages");
			%>
			<tr>
				<th>Email:<input type="text" id="newName" class="inputBox"><br>
					<br></th>

				<th>Experience:<input type="text" id="newCompany"
					class="inputBox"><br> <br></th>
				<th>Language:<select name="languageList">
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
			<input type="Submit" id="add" value="Submit changes">
		</center>
	</form>

</body>
</html>