<%@page import="org.simple.model.User"%>
<%@page import="java.util.List"%>
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
				<%!public int getPageStart(int currentPage) {
						return currentPage * 20;
					}

					public int getLastPage(int currentPage, int m,boolean isOnePage) {
						if(isOnePage){
							return m;
						}
						if (m == 0)
							return currentPage * 20 + 20;
						return currentPage * 20 + 20 + m;
					}%>

	<%
		List<User> users = (List<User>) session.getAttribute("users");
	%>
	<%
		int i = users.size();
		int selectedPage=0;
		if(request.getParameter("selectedPage")!=null){
			selectedPage=Integer.parseInt(request.getParameter("selectedPage"));
		}
		boolean isOnePage=false;
		int k, r;
		if (i > 20) {
			k = users.size() / 20;
			r = users.size() % 20;
		} else {
			k = 0;
			isOnePage=true;
			r = users.size()%20;    
		}
	%>
	<div>
		<a href="logout" id="logout">Logout</a>
	</div>
	<h1>Welcome administrator! k: <%=k %> i:<%=i %> r:<%=r %> inOnePage: <%=isOnePage %></h1>
	<div>
		<h2>Users List</h2>
		<center>
			<table class="admin-table">
				<tr>
					<th>Name</th>
					<th>Company</th>
					<th>Job title</th>
					<th>E-mail</th>
					<th>Select:</th>
				</tr>

				<%
					for (int j = getPageStart(selectedPage); j < getLastPage(selectedPage , r,isOnePage); j++) {
				%>
				<tr>
					<th><%=users.get(j).getName()%></th>
					<th><%=users.get(j).getCompany()%></th>
					<th><%=users.get(j).getJobTitle()%></th>
					<th><%=users.get(j).getEmail()%></th>
					<th><input name="select" type="radio" /></th>
				</tr>
				<%
					}
				%>
			</table>
			<a href="admin.jsp?selectedPage=<%=selectedPage-- %>">prevPag</a>
			<a href="admin.jsp?selectedPage=<%=selectedPage++ %>">sigPag</a>
			<%if(selectedPage<=0){
				selectedPage=0;
			}
				
			%>
		</center>
		<br>
		<center>
			<input class="adminButtons" type="button" value="Create user"><input
				class="adminButtons" type="button" value="Modify user"><input
				class="adminButtons" type="button" value="Delete user">
		</center>

	</div>
	<br>
	<br>
	<div>
		<center>
			<p Search for user:>
				<input type="text" class="adminButtons" value="Search here...">
				<input type="button" value="Search" action="search-result.jsp">
		</center>
	</div>
</body>
</html>