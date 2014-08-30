/**
 * 
 */


function validateEmail() {
	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z0-9]{1,200}$/;		//Esto le saque para que sin el punto ande
	var email =document.forms["loginForm"]["email"].value;
	if(!emailPattern.test(email)){
		alert("Wrong mail");
		return emailPattern.test(email);
	}else if(email.length>200){
		alert("Wrong mail mas de 200");
		return false;
		
	}
}

