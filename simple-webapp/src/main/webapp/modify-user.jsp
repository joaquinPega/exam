<%@page import="java.util.List"%>
<%@page import="org.simple.model.Language"%>
<%@page import="org.simple.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="Stylesheet" href="css/Style.css" />
<script type="text/javascript" src="js/Scripts.js"></script>
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
	function textCounter(field, maxlimit) {
        var countfield = document.getElementById(field);
        document.getElementById("lblWords").innerHTML=maxlimit - countfield.value.length;
        if (countfield.value.length > maxlimit) {
        	countfield.value = countfield.value.substring(0, maxlimit);
                return false;
        } 
	} 
	function validateEmail() {
		var email = document.forms["modifyForm"]["email"].value;
		if (!emailPattern.test(email)) {
			alert("Wrong mail");
			return emailPattern.test(email);
		} else if (email.length > 200) {
			alert("Wrong mail mas de 200");
			return false;

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

				<th>Experience:<input type="text" name="newExperience" id="experience"
					class="inputBox" maxlength="500" onkeydown="textCounter('experience',500);" onkeyup="textCounter('experience',500);"><div id="lblWords"></div><br> <br></th>
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