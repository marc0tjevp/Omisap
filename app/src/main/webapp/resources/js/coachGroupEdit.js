/**
 * 
 */
 $( window ).on( "load", function() { 
        	
        $("#AnnulerenButton").click(function(e){
        		window.location.replace("/Pasimo/coachGroups");
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