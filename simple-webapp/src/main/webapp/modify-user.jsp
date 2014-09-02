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
		<a href="logout" id="logout">Logout</a>
	</div>
	<h1>Please modify user:</h1>
	<p align="center">
		<i><%=((User) session.getAttribute("currentUser")).getName()%></i>
	</p>
	<script>
	function validateEmail() {
		var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,200}$/;
		var email = document.forms["modifyForm"]["email"].value;
		if (!emailPattern.test(email)) {
			alert("Wrong mail");
			return emailPattern.test(email);
		} else if (email.length > 200) {
			alert("Wrong mail mas de 200");
			return false;

		} 
	}
	function validaExperiencia(){
		var exp = document.forms["modifyForm"]["newExperience"].value;
		if(exp.length>500){
			alert("500");
		}
	}
		</script>
	<div id="modifyForm">
	<form name="modifyForm" action="changeUser" method="post" onsubmit="return validateEmail();">
		<table>
			<%
				List<Language> languages = (List<Language>) session.getAttribute("languages");
			%>
			<tr>
				<th>Email:<input type="text" name="email"  class="inputBox"><br>
					<br></th>

				<th>Experience:<input type="text" name="newExperience"
					class="inputBox" onkeydown="return validaExperiencia()"><br> <br></th>
				<th>Language:<select name="language">
						<%
							for (int i = 0; i < languages.size(); i++) {
						%>
						<option value="<%=languages.get(i).getId()%>"><%=languages.get(i).getName()%></option>
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