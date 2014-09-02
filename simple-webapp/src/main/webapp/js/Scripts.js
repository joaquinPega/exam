function validateEmail() {
	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z0-9]{1,200}$/;
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
<<<<<<< HEAD
=======
function validateEmail2() {
	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z0-9]{1,200}$/;
	var email = document.forms["modifyForm2"]["email"].value;
	var password = document.forms["modifyForm2"]["password"].value;
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

function deleteUser() {
	var x = confirm("Are you sure you want to delete?");
	if (x)
		return true;
	else
		return false;
}
>>>>>>> e25a6501f2875e9da35a5a4af7bf8d0eb0313786
