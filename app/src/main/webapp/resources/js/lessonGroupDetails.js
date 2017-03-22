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

    $("#selectAllStudentsForLessonGroupCheckbox").on('click', function () {
        if (this.checked) {
            // Iterate each checkbox
            $('table.lesson-group-other-students-table :checkbox').each(function () {
                this.checked = true;
                $(this).addClass("selectedLessonGroupStudentDetail");
                $("#addStudentToLessonGroupButton").removeAttr("disabled");
            });
        }
        else {
            $('table.lesson-group-other-students-table :checkbox').each(function () {
                this.checked = false;
                $(this).removeClass("selectedLessonGroupStudentDetail");
                $("#addStudentToLessonGroupButton").attr("disabled", true);
            });
        }
    });

    $(".lesson-group-other-students-table tbody td input[type=\"checkbox\"]").change(function () {
        if (this.checked) {
            $(this).addClass("selectedLessonGroupStudentDetail");
        } else {
            $(this).removeClass("selectedLessonGroupStudentDetail");
        }


        var selectedLessonGroup = $(".selectedLessonGroupStudentDetail");
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

});