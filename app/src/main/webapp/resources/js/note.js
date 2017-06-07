/**
 * 
 */

$('#noteSubmit').on('click', function(){
	$('#noteForm').submit();
});

$('#overviewModal').on('show.bs.modal', function (e) {
    $(this).find('#noteDelete').attr("href", "noteDelete?id=" + e.relatedTarget.id);
    $(this).find('#noteEditView').attr("href", "noteEditView?id=" + e.relatedTarget.id);
});

$('#myModal').on('show.bs.modal', function (e) {
    $(this).find('#noteFormEdit').attr("href", "noteEdit?id=" + e.relatedTarget.id);
});
$('#noteEdit').on('click', function(){
	$('#noteFormEdit').submit();
});


