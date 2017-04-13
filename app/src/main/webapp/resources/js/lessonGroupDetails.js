$(document).ready(function () {

    $("#selectAll").on('click', function () {
        if (this.checked) {
            // Iterate each checkbox
            $('.lesson-groups-table tbody :checkbox').each(function () {
                this.checked = true;
                $(this).addClass("selectedLessonGroupStudent");
                $("#deleteStudentButton").removeAttr("disabled");
            });
        }
        else {
            $('.lesson-groups-table tbody :checkbox').each(function () {
                this.checked = false;
                $(this).removeClass("selectedLessonGroupStudent");
                $("#deleteStudentButton").attr("disabled", true);
            });
        }
    });

    $(".lesson-groups-table tbody td input[type=\"checkbox\"]").change(function () {
        if (this.checked) {
            $(this).addClass("selectedLessonGroupStudent");
        } else {
            $(this).removeClass("selectedLessonGroupStudent");
        }


        var selectedLessonGroup = $(".selectedLessonGroupStudent");
        if (selectedLessonGroup.length == 0) {
            $("#deleteStudentButton").attr("disabled", true);
        }

        if (selectedLessonGroup.length >= 1) {
            $("#deleteStudentButton").removeAttr("disabled");
        }
    });

    /**
     * Selecting all students for adding them into a lesson group
     */
    $("#selectAllStudentsForLessonGroupCheckbox").on('click', function () {
        if (this.checked) {
            // Iterate each checkbox
            $('table.lesson-group-other-students-table tbody :checkbox').each(function () {
                this.checked = true;
                $(this).addClass("selectedLessonGroupStudentForAdding");
                $("#addStudentToLessonGroupButton").removeAttr("disabled");
            });
        }
        else {
            $('table.lesson-group-other-students-table tbody :checkbox').each(function () {
                this.checked = false;
                $(this).removeClass("selectedLessonGroupStudentForAdding");
                $("#addStudentToLessonGroupButton").attr("disabled", true);
            });
        }
    });

    /**
     * Select one student for adding them into the lesson group
     */
    $(".lesson-group-other-students-table tbody td input[type=\"checkbox\"]").change(function () {
        if (this.checked) {
            $(this).addClass("selectedLessonGroupStudentForAdding");
        } else {
            $(this).removeClass("selectedLessonGroupStudentForAdding");
        }


        var selectedLessonGroup = $(".selectedLessonGroupStudentForAdding");
        if (selectedLessonGroup.length == 0) {
            $("#addStudentToLessonGroupButton").attr("disabled", true);
        }

        if (selectedLessonGroup.length >= 1) {
            $("#addStudentToLessonGroupButton").removeAttr("disabled");
        }
    });

    $("#editLessonGroupName").on('show.bs.modal', function () {
        $("#currentLessonGroup").val($("#lessonGroupName").text());
    });

    /**
     * AJAX request for changing a lesson group name
     */
    $("#updateLessonGroupNameButton").on("click", function(event) {
    	//Incase the button does something by default    	
    	event.preventDefault();
    	var lessonGroupName =  $("h1#lessonGroupName").attr("data-lessongroup-name").trim();
    	var newLessonGroupName = $("div#editLessonGroupName div.modal-body input#currentLessonGroup").val().trim();
    	
    	//If the input is not empty
    	if(newLessonGroupName) {    		
    		var coachGroupName = $("h2#lessonGroupCoachGroupName").attr("data-coachgroup-name");
    		//POST AJAX request to update lesson group action
      		 $.ajax({
    		     type: 'POST',	  
    			 url:'details/updatename',
    		     dataType: 'json',
   				 data : "newLessonGroupName=" + newLessonGroupName + "&lessonGroupName="+lessonGroupName + "&coachGroupName=" + coachGroupName,
   				 success: function(data) {
   					 $('div.modal#editLessonGroupName').modal('hide');
   					 $("h1#lessonGroupName").text(" " + data['newLessonGroupName']);
   					 $("h1#lessonGroupName").attr("data-lessongroup-name", data['newLessonGroupName']);
   					 
   					 /*
   					  * Set the URL parameters to the new lesson group name for later page reloads (add and delete students)
   					  */
   					 history.pushState(null, null, "/Pasimo/lessongroup/details?lessonGroupName=" + newLessonGroupName + "&coachGroupName="+coachGroupName);
   				 }
    		});
      	}
    });
    
    /**
     * AJAX request for adding student to the lesson group
     */
    $("#addStudentToLessonGroupButton").on("click", function(event) {
    	//Incase the button does something by default    	
    	event.preventDefault();
    
		var lessonGroupId = $("h1#lessonGroupName").attr("data-lessongroup-id");

    	$("input[type=checkbox].selectedLessonGroupStudentForAdding").each(function() {
    		var studentRow = $(this).parent().parent().parent();
    		var studentOV = studentRow.attr("data-additional-student-id");
    		
    		//POST AJAX request to add the each student to the lesson group
      		 $.ajax({
    		     type: 'POST',	  
    			 url:"details/students/add",
    		     dataType: 'json',
   				 data: "studentId="+studentOV + "&lessonGroupId=" + lessonGroupId,
   				 success: function(data) {
   					//Reload the page to get all the new students into the table sorted
    				location.reload();
   				 }
      		 });
    	});
    });
    
    /**
     * AJAX request for deleting one or multiple students from the lesson group
     */
    $("#confirmDeleteStudentsInLessonGroupButton").on("click", function(event) {
    	//Incase the button does something by default    	
    	event.preventDefault();
    
		var lessonGroupName = $("h1#lessonGroupName").attr("data-lessongroup-name");
		var coachGroupName = $("h2#lessonGroupCoachGroupName").attr("data-coachgroup-name");


		console.log(lessonGroupName);
		console.log(coachGroupName);
		
    	$("input[type=checkbox].selectedLessonGroupStudent").each(function() {
    		var studentRow = $(this).parent().parent().parent();
    		var studentOV = studentRow.attr("data-student-ov");
    		
    		//POST AJAX request to delete each selected student from the lesson group
      		 $.ajax({
    		     type: 'POST',	  
    			 url:"details/students/delete",
    		     dataType: 'json',
   				 data: "studentId="+studentOV + "&lessonGroupName=" + lessonGroupName.trim() + "&coachGroupName=" + coachGroupName,
   				 success: function(data) {
   					//Reload the page to get all the new students into the table sorted
    				location.reload();
   				 }
      		 });
    	});
    });
});