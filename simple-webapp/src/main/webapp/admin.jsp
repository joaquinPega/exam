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

	<%
		List<User> users = (List<User>) session.getAttribute("users");
	%>
<%
		int i = users.size();
		int selectedPage=0;
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
		if(request.getParameter("selectedPage")!=null){
			selectedPage=Integer.parseInt(request.getParameter("selectedPage"));		
			if(selectedPage<=0){
				selectedPage=0;
			}
			if(selectedPage>=k-1){
				selectedPage =k-1;
			}
				
		}
		
	%>
				<%!public int getPageStart(int currentPage) {
						return currentPage * 20;
					}

					public int getLastPage(int currentPage, int m,boolean isOnePage) {
						if(isOnePage){
							return m;
						}
						if (m == 0)
							return currentPage * 20 + 20;
						return currentPage * 20 + 20;
					}
					%>

	
	<div>
		<a href="logout" id="logout">Logout</a>
	</div>
	<h1>Welcome administrator!</h1>
	<div>
		<h2>Users List</h2>
		
		<center>	
			<form action=modify method="get">		
			<table>
				<tr>
					<th>Name</th>
					<th>Company</th>
					<th>Job title</th>
					<th>E-mail</th>
					<th>Modify:</th>
					<th>delete:</th>
				</tr>
				<%
					for (int j = getPageStart(selectedPage); j < getLastPage(selectedPage , r,isOnePage); j++) {
				%>
				<tr>
				
					<td><%=users.get(j).getName()%></td>
					<td><%=users.get(j).getCompany()%></td>
					<td><%=users.get(j).getJobTitle()%></td>
					<td><%=users.get(j).getEmail()%></td>
					<td><input type="submit" name="id" value="<%=users.get(j).getId() %>" /></td>
					<td><input type="submit" name="idDel" value="<%=users.get(j).getId() %>"/> </td>
					
				</tr>
				<%} %>
			</table>			
			</form>
			<a href="admin.jsp?selectedPage=<%=(int)selectedPage--%>">prevPag</a>
			<a href="admin.jsp?selectedPage=<%=(int)selectedPage++%>">sigPag</a>
		</center>
		<br>
		<center>
			<a href="add-new-user.jsp" >Create User</a>
		</center>
	</div>
	<br>
	<br>
	<div>
		<center>
		<form name="search" action="search">
				<input type="text" name="search" value="">
				<input type="submit" value="Search" >
		</form>
		</center>
	</div>
</body>
</html>