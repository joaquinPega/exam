<%@page import="org.simple.model.Language"%>
<%@page import="org.simple.model.Manager"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="Stylesheet" href="css/Style.css" />
<script type="text/javascript" src="js/Scripts.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new user</title>
</head>
<body>
<script>
function validateEmail() {
	var email = document.forms["modifyForm"]["email"].value;
	var password = document.forms["modifyForm"][ "password" ].value;
	if (!emailPattern.test(email)) {
		alert("Wrong mail");
		return emailPattern.test(email);
	} else if (email.length > 200) {
		alert("Wrong mail mas de 200");
		return false;

	} else if(password.length == 0)
	{
		alert("Please enter a password!")
		return false;
	}
}
function textCounter(field, maxlimit) {
    var countfield = document.getElementById(field);
    document.getElementById("lblWords").innerHTML=maxlimit - countfield.value.length;
    if (countfield.value.length > maxlimit) {
    	countfield.value = countfield.value.substring(0, maxlimit);
    	document.getElementById("lblWords").innerHTML=maxlimit - countfield.value.length;
            return false;
    } 
} 
		</script>
<%List<Manager> managers=(List<Manager>)session.getAttribute("managers");
List<Language> languages=(List<Language>)session.getAttribute("languages");
%>
	<div>
		<a href="logout" id="logout">Logout</a>
	</div>
	<h1>Please add new user:</h1>
	<form name="modifyForm" action="addNewUser" method="post" onsubmit="return validateEmail();">
	<center>
		Name:<input type="text" name="name"><br>
		Company:<input type="text" name="company"><br>
		Job title:<input type="text" name="jobTitle"><br>
		Email:<input type="text" name="email"><br>
		Manager:<select name="manager">
					<%
							for (int i = 0; i < managers.size(); i++) {
						%>
						<option value="<%=managers.get(i).getId()%>"><%=managers.get(i).getName()%></option>
						<%
							}
						%>
				</select><br>
		Experience:<input type="text" name="experience" id="experience" onkeydown="textCounter('experience',500);" onkeyup="textCounter('experience',500);"><div id="lblWords"></div><br>
		Language:<select name="language">
					<%
							for (int i = 0; i < languages.size(); i++) {
						%>
						<option value="<%=languages.get(i).getId()%>"><%=languages.get(i).getName()%></option>
						<%
							}
						%>
				</select><br>
		Password:<input type="password" name="password"> <br>
		<input type="submit" value="apply">
		</center>
	</form>
	<center>
	<form action="admin.jsp"><input type="submit" value="cancel"></form></center>
	<script>
	function textCounter(field, maxlimit) {
        var countfield = document.getElementById(field);
        document.getElementById("lblWords").innerHTML=maxlimit - countfield.value.length;
        if (countfield.value.length > maxlimit) {
        	countfield.value = countfield.value.substring(0, maxlimit);
        	document.getElementById("lblWords").innerHTML=maxlimit - countfield.value.length;
                return false;
        } 
	} 
	</script>
</body>
</html>