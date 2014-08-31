<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type="text/css" rel="Stylesheet" href="css/Style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
</head>
<%//Agregar regular expresions al validateForm 
	Boolean userLogged = (Boolean)session.getAttribute("userLogged");
%>
<body>
	<div class="head">
		<h1>Examen java globant academy</h1>
	</div>
	<div id="loginForm" class="loginFormLeft">
		<!-- LoginForm-->
		<form name="loginForm" action="login" method="post"
			onsubmit="return validateEmail();">
			<!-- Primer Form login prueba -->
			Email: <input id="email" type="text" name="email" /></br> 
			Password:<input	id="password" type="password" name="password" /></br> 
			<input type="submit" name="submit" value="Log in">
		</form>
		<label id="userNotFound"><%if(session.getAttribute("userNotFound")!=null &&(Boolean)(session.getAttribute("userNotFound"))){%>
			Usuario no encontrado
		<%}
									
		%></label>
	</div>
	<div class="loginFormRight">
		<div id="barRight" class="buttonBar">

			<p></p>
		</div>


	</div>

</body>
<script type="text/javascript" src="js/Scripts.js"></script>
<script>
if(<%=userLogged%>){
	document.getElementById("loginForm").style.visibility="hidden";
}
</script>
</html>