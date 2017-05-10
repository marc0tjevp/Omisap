/**
 * 
 */

$('#noteSubmit').on('click', function(){
	$('#noteForm').submit();
});

//triggered when modal is about to be shown
$('#overviewModal').on('show.bs.modal', function(e) {
	console.log('hoi');
});