/**
 * 
 */

$('#noteSubmit').on('click', function(){
	$('#noteForm').submit();
})

$('#overviewModal').on('show.bs.modal', function (e) {
    $(this).find('.modal-body').html('Message: ' + e.relatedTarget.id);
    $(this).find('#noteDelete').attr("href", "noteDelete?id=" + e.relatedTarget.id);
})