<%@page import="org.simple.model.User"%>
<%@page import="org.simple.model.Language"%>
<%@page import="org.simple.model.Manager"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify user</title>
</head>
<body>
<script>
	function validateEmail() {
		var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,200}$/;
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
		</script>
<%List<Manager> managers=(List<Manager>)session.getAttribute("managers");
List<Language> languages=(List<Language>)session.getAttribute("languages");
List<User> users = (List<User>)session.getAttribute("users");
User user=null;
long userId = Long.parseLong(request.getParameter("id"));
session.setAttribute("idUser", userId);
for(User u: users){
	if(u.getId()==userId){
		user = u;
	}
}
%>
<form name="modifyForm" action="modifyAdmin" method="post" onsubmit="return validateEmail();">
		Name:<input type="text" name="name" value="<%=user.getName()%>"><br>
		Company:<input type="text" name="company" value="<%=user.getCompany()%>"><br>
		Job title:<input type="text" name="jobTitle" value="<%=user.getJobTitle()%>"><br>
		Email:<input type="text" name="email" value="<%=user.getEmail()%>"><br>
		Manager:<select name="manager">
					<%
							for (int i = 0; i < managers.size(); i++) {
						%>
						<option value="<%=managers.get(i).getId()%>"><%=managers.get(i).getName()%></option>
						<%
							}
						%>
				</select><br>
		Experience:<input type="text" name="experience" id="experience" onkeyup="textCounter(this,'counter',500)" value="<%=user.getExperience()%>"><br>
		Language:<select name="language">
					<%
							for (int i = 0; i < languages.size(); i++) {
						%>
						<option value="<%=languages.get(i).getId()%>"><%=languages.get(i).getName()%></option>
						<%
							}
						%>
				</select><br>
		Password:<input type="text" name="password" value="<%=user.getPassword()%>"> <br>
		<input type="submit" value="apply">
	</form>
	<script>
	function textCounter(field, field2, maxlimit) {
        var countfield = document.getElementById(field2);
        if (field.value.length > maxlimit) {
                field.value = field.value.substring(0, maxlimit);
                return false;
        } else {
                countfield.value = maxlimit - field.value.length;
        }
	} 
	</script>
</body>
</html>