<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type="text/css" rel="Stylesheet" href="css/Style.css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
</head>
<body>
<script>
function validateForm() {
    var x = document.forms["loginForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos< 1 ) {
        alert("Not a valid e-mail address: something before @ is required");
        return false;
	}else if( dotpos<atpos + 2){
		alert("Not a valid e-mail address: something before . is required");
		return false;
	}else if(dotpos+2 >= x.length ){
		alert("Not a valid e-mail address: something after . is required");
		return false;
	}else if(x.length >200){
		alert("Not a valid e-mail address: the length must be less than 200. current_length: "+x.length);
		return false;
	}
}</script>
<div class="head">
<h1>Examen java globant academy</h1>
</div>
<div class="loginFormLeft"><!-- LoginForm-->
	<form name="loginForm" action="login" method="post" onsubmit="return validateForm();"><!-- Primer Form login prueba -->
		Email:<input id="email" type="text" name="email"/></br>
		Password:<input id="password" type="password" name="password"/></br>
		<input type="submit" name="submit" value="Log in">
	</form>
</div>
<div class="loginFormRight">
	<div id="barRight" class="buttonBar">
	
		<p>Implementar barra de botones</p>
	</div>


</div>

</body>
</html>