<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout2>
	<jsp:attribute name="css">
         <link type="text/css" rel="stylesheet"
			href="<c:url value="/resources/css/loginView.css"/>" />
    </jsp:attribute>
    
	<jsp:attribute name="content">
	
	<div class="container">
            <form id="formCheckPassword" class="form-horizontal" role="form" action="CreateAccount" method="post">
                <h2>Bestaand Account aanmaken</h2>
                
                <div class=" form-group">
                
                    <label for="country" class="col-sm-3 control-label">Docent/Student</label>
                    <div class="col-sm-9">
                       	<input id="leerling" type="radio" name="docentstudent" value="Student" >Student
                       	<input id="leraar" type="radio" name="docentstudent" value="Docent">Docent
                    </div>
                    	<label for="Student/Docent" class="col-sm-9 form-group"></label>                    		
                    	<div class="from-control">
                    			<div id="student" class="form-group">
                    				<select class="form-control	name="" id="studentFilter">
                                  <option value="">Select Leerling</option>
                                  <s:iterator value="coaches" var="ed">
                                        <option value="${ed.student}">${ed.abbreviation} </option>
                                        </s:iterator>
                                   </select>
                    		 </div>
                    		 
                    		 	
               					<div id="docent" class="form-group">
                  				
               					</div>	
               					 									
                    		</div >
              
                </div> <!-- /.form-group -->
                   		    
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <input type="submit" class="button" value="Aanmaken">
                    </div>
                </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>

	$(document).ready(function(){ 

			$('[name="docentstudent"]').click(function() {
			  	if($('#leerling').is(':checked')){
		  			$('#student').show();
		  			$('#docent').hide();
		  			//teacher hide
		  		}else if ($('#leraar').is(':checked')){
		  			$('#student').hide();
		  			$('#docent').show();
		  			 // teacher show
          	  	}
			});
			
			

			$('#student').hide();
			$('#docent').hide();
	}); 

</script>
	</jsp:attribute>
</t:layout2>
</html>
