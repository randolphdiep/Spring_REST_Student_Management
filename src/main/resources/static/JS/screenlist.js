$(document).ready(function() {
	$('#example').DataTable({
		searching: false,
		lengthMenu: false,
		pagingType: 'full_numbers',
		lengthChange: false,
		info: false
	});
});
function deleteConfirm(elem) {
	if (confirm("Are you sure to delete this student?")) {
		jQuery(elem).closest('form').submit();
		return false;
	}
}

function logoutConfirm(elem) {
	if (confirm("Are you sure you want to log out?")) {
		jQuery(elem).closest('form').submit();
		return false;
	}
}
