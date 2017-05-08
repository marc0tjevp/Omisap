$(document).ready(function () {
	/*
	 * Put the current lesson group name into the input box for changing the name
	 */
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
});