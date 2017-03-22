$(document).ready(function () {
    initCreateAbbreviation();
    
    var invalidInput = false;
    
    $('#submitId').on('click', function(){
    	if(
    			$.trim($("#teacherFirstName").val())!==''&&
    			$.trim($("#teacherLastName").val())!==''&&
    			$.trim($("#teacherEmail").val())!==''&&
    			$.trim($("#teacherDateOfBirth > input").val())!==''&&
    			$.trim($("#teacherCardID").val())!==0&&
    			$.trim($("#teacherEmployeeNumber").val())!==0&&
    			!invalidInput){
    				$('#addTeacherForm').submit();
    	} else {
    		//TODO add notAllFieldsContainCorrectValues message for x seconds
    		return false;
    	}	
    });
    
    $('#teacherCardID, #teacherEmployeeNumber').keyup(function(e){
    	var reg = /^\d+$/;
    	if(reg.test($.trim($(this).val()))){
    		$(this).css('border', '1px solid #ccc');
    		if($(this).id == $('#teacherCardID')){
    			if(reg.test($.trim($('#teacherEmployeeNumber').val()))){
    				invalidInput = false;
    			} else {
    				//TODO add onlyNumbersAllowedMessage for x seconds
    				invalidInput = true;
    			}
    		} else {
    			if(reg.test($.trim($('#teacherCardID').val()))){
    				invalidInput = false;
    			} else {
    				//TODO add onlyNumbersAllowedMessage for x seconds
    				invalidInput = true;
    			}
    		}
    	} else {
    		invalidInput = true;
    		$(this).css('border', 'red 2px solid');
    		//TODO add onlyNumbersAllowedMessage for x seconds
    		console.log($(this).parent('div').css('border'));
    	}
    	if($.trim($('#teacherCardID').val()).length > 11){
    		//TODO add toLongErrorMessage until length is lower than or equal to 11
    	}
    	if($.trim($('#teacherEmployeeNumber').val()).length > 6){
    		//TODO add toLongErrorMessage until length is lower than or equal to 6
    	}
    })
});

function initCreateAbbreviation() {
    $('#firstName, #lastName').keyup(function () {
        var first = $('#firstName').val().trim();
        var last = $('#lastName').val().trim();
        s = last.substr(0, 4) + first.substr(0, 2);
        $('#abbreviation').val(s.toLowerCase());
    });
}
