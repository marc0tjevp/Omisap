var fileName = "";

$("#submitButton").on("click", function(){
	
	if($.trim($("#cohort").val())==0 || fileName == ""){
		//TODO add message to display what the user is doing wrong
		return false;
	}
	$("#AddStudentWithCSVForm").submit();
});

$(function() {
    $("input:file").change(function (){
       fileName = $(this).val();
    });
 });