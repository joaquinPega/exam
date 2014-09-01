/**
 * 
 */

function validateEmail() {
	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z0-9]{1,200}$/;
	var email = document.forms["loginForm"]["email"].value;
	var password = [ "password" ];
	if (!emailPattern.test(email)) {
		alert("Wrong mail");
		return emailPattern.test(email);
	} else if (email.length > 200) {
		alert("Wrong mail mas de 200");
		return false;

	} else
		(password.length == 0)
	{
		alert("Please enter a password!")
		return false;
	}
}
function validateEmail2() {
	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z0-9]{1,200}$/;
	var email = document.forms["modifyForm"]["email"].value;
	if (!emailPattern.test(email)) {
		alert("Wrong mail");
		return emailPattern.test(email);
	} else if (email.length > 200) {
		alert("Wrong mail mas de 200");
		return false;

	} else
		(password.length == 0)
	{
		alert("Please enter a password!")
		return false;
	}
}
