var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,200}$/;
function validateEmail() {	
	var email = document.forms["loginForm"]["email"].value;
	var password = document.forms["loginForm"]["password"].value;
	if (!emailPattern.test(email)) {
		alert("Wrong mail");
		return emailPattern.test(email);
	} else if (email.length > 200) {
		alert("Wrong mail mas de 200");
		return false;

	} else if (password.length == 0) {
		alert("Please enter a password!")
		return false;
	}
}