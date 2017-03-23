$(document).ready(function () {

    $("#selectAll").on('click', function () {
        if (this.checked) {
            // Iterate each checkbox
            $('.lesson-groups-table :checkbox').each(function () {
                this.checked = true;
                $(this).addClass("selectedLessonGroupStudent");
                $("#deleteStudentButton").removeAttr("disabled");
            });
        }
        else {
            $('.lesson-groups-table :checkbox').each(function () {
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
            $('table.lesson-group-other-students-table :checkbox').each(function () {
                this.checked = true;
                $(this).addClass("selectedLessonGroupStudentForAdding");
                $("#addStudentToLessonGroupButton").removeAttr("disabled");
            });
        }
        else {
            $('table.lesson-group-other-students-table :checkbox').each(function () {
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
    })

    /**
     * AJAX request for changing a lesson group name
     */
    $("#updateLessonGroupNameButton").on("click", function(event) {
    	//Incase the button does something by default
    	event.preventDefault();
    	
    	var lessonGroupName = $("div#editLessonGroupName div.modal-body input#currentLessonGroup").val();
    	
    	//If the input is not empty
    	if(lessonGroupName) {
    		//Retrieve lesson group id because it only got saved in GET variables of URL
    		var lessonGroupId = $("h1#lessonGroupName").attr("data-lessongroup-id");
    		
    		//POST AJAX request to update lesson group action
      		 $.ajax({
    		     type: 'POST',	  
    			 url:'details/updateName',
    		     dataType: 'json',
   				 data : "lessonGroupId="+lessonGroupId + "&name="+lessonGroupName,
    		});
      	}
    	location.reload();
    });
    
    $("#addStudentToLessonGroupButton").on("click", function(event) {
    	event.preventDefault();
    
    	$("input[type=checkbox].selectedLessonGroupStudentForAdding").each(function() {
    		var studentRow = $(this).parent().parent().parent();
    		var studentOV = studentRow.attr("data-additional-student-id");
    		
      		 $.ajax({
    		     type: 'POST',	  
    			 url:"details/students/add",
    		     dataType: 'json',
   				 data : "studentId="+studentOV
      		 });
    	});

    });
});