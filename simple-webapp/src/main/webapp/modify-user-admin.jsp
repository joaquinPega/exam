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
<form action="modifyAdmin" method="post">
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
		Experience:<input type="text" name="experience" value="<%=user.getExperience()%>"><br>
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
</body>
</html>