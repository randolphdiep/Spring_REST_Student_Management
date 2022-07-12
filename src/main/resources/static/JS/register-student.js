function generateCode() {
	var val = Math.floor(Math.random() * 990);
	val += Math.floor((val + 110) / 110);
	document.getElementById("studentCode").value = "STU" + ('000' + val).substr(-3);
};

function saveSubmit() {
	if (document.getElementById("studentCode").value == "") {
		generateCode();
	}
}

function logoutEditConfirm(elem) {
	if (confirm("Are you sure you want to log out?")) {
		jQuery(elem).closest('form').submit();
		return false;
	}
}