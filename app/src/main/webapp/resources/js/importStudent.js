var fileName = "";

$("#submitButton").on("click", function(){
	
	var reg = /^\d+$/;
	
	if($.trim($("#cohort").val())==0 || fileName == "" || reg.test($.trim($("cohort").val()))){
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