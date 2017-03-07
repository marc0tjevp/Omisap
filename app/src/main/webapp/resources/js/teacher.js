/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    initCreateAbbreviation();
    $('#submitId').on('click', function(){
    	console.log('inside click function');
    	console.log($.trim($("#teacherFirstName").val()));
    	console.log($.trim($("#teacherLastName").val()));
    	console.log($.trim($("#teacherEmail").val()));
    	console.log($.trim($("#teacherDateOfBirth > input").val()));
    	console.log($.trim($("#teacherCardID").val()));
    	console.log($.trim($("#teacherEmployeeNumber").val()));
    	if(
    			$.trim($("#teacherFirstName").val())!==''&&
    			$.trim($("#teacherLastName").val())!==''&&
    			$.trim($("#teacherEmail").val())!==''&&
    			$.trim($("#teacherDateOfBirth > input").val())!==''&&
    			$.trim($("#teacherCardID").val())!==0&&
    			$.trim($("#teacherEmployeeNumber").val())!==0){
    		console.log('inside if statement');
    				$('#addTeacherForm').submit();
    	} else {
    		console.log('inside else statement');
    		return false;
    	}	
    });
});

function initCreateAbbreviation() {
    $('#firstName, #lastName').keyup(function () {
        var first = $('#firstName').val().trim();
        var last = $('#lastName').val().trim();
        s = last.substr(0, 4) + first.substr(0, 2);
        $('#abbreviation').val(s.toLowerCase());
    });
}



	