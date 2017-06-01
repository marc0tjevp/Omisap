/**
 * 
 */
$( window ).on( "load", function() { 
            	 var closestTr = [];
            	var openModal = [];
            	
            	 
                $("#selectAllCoachGroups").on('click', function () {
                    if (this.checked) {
                        // Iterate each checkbox
                        $(':checkbox').each(function () {
                            this.checked = true;
                            $(this).addClass("selectedCoachGroup");
                            $("#deleteButton").removeAttr("disabled");
                            $("#editButton").attr("disabled", true);
                            
                           
                        });
                    }
                    else {
                        $(':checkbox').each(function () {
                            this.checked = false;
                            $(this).removeClass("selectedCoachGroup");
                            $("#deleteButton").attr("disabled", true);
                            
            
                        });
                    }
                    closestTr = [];
                    $(':checkbox').each(function () {
                        if(this.checked){
                        	closestTr.push($(this).closest('tr').attr('id'));
                        	console.log(closestTr);
                        }
                        });
                });
               
               
                
                $(".coach-groups-table tbody td input[type=\"checkbox\"]").change(function () {
                	
                    if (this.checked) {
                    	
                    	
                        $(this).addClass("selectedCoachGroup");
        
                        
                        
                    } else {
                        $(this).removeClass("selectedCoachGroup");
                    }
                    
					
                    closestTr = [];
                   
                    $(':checkbox').each(function () {
                    if(this.checked){
                    	closestTr.push($(this).closest('tr').attr('id'));
                    	console.log(closestTr);
                    }
                    });
                   

                    
                    var selectedCoachGroup = $(".selectedCoachGroup").length;
                    if (selectedCoachGroup == 0) {
                        $("#deleteButton").attr("disabled", true);
                        
                        $("#editButton").attr("disabled", true);
                    }

                    if (selectedCoachGroup == 1) {
                        $("#deleteButton").removeAttr("disabled");
                        
                        $("#editButton").removeAttr("disabled");
                    }
                    if(selectedCoachGroup >= 2) {
                        $("#deleteButton").removeAttr("disabled");
                        
                        $("#editButton").attr("disabled", true);
                    }
                    
                   
                });
                
                
                $("#deleteButton2").click(function(e){
                    	$.ajax({
                		 	type: 'POST',	  
                			url:'coachGroup/array',
                		   	dataType: 'json',
               				data : "s1=" + closestTr,
               				success: function(data) {
	           			     	location.reload();
	           				 }
                    	});
                 
                  							
                	
                });
					
                
                $("#editButton").click(function(e){
             
           					window.location.replace(window.location.href+ "/CoachGroupEdit?s1=" + closestTr);
                	});
                	
                
                $('.form-control')
                .dropdown();
               
                $('select').change(function() {
                    if ($(this).children('option:first-child').is(':selected')) {
                      $(this).addClass('placeholder');
                    } else {
                     $(this).removeClass('placeholder');
                    }
                   });
            });
            
            