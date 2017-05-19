/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
	$('#submitId').on('click', function(){
		console.log("script started");
		if(
    			$.trim($("#coachGroupName").val())!==''&&
    			$.trim($("#lessonGroupID").val())!==''&&
    			$.trim($("#studentCohort").val())!==''&&
    			$('#importedFile').get(0).files.length != 0){
    				console.log("importfile succesfol");
    				console.log($("#coachGroupName"));
    				$('#AddStudentWithCSVForm').submit();
    	} 	else if ($('#importedFile').get(0).files.length === 0) {
    	    console.log("No files selected.");
    	}else{ 
    		//TODO add notAllFieldsContainCorrectValues message for x seconds
    		console.log("importfile faild");
    		return false;
    	}
    });

});



