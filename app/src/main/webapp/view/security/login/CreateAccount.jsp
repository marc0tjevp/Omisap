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
                <h2>Account aanmaken</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">Naam</label>
                    <div class="col-sm-9">
                        <input type="text" id="firstName" placeholder="Naam" class="form-control" autofocus>
                </div>
                 </div>
                 
                 <div class="form-group">
                    <label for="Tussevoegsel" class="col-sm-3 control-label">Tussenvoegsel</label>
                    <div class="col-sm-9">
                        <input type="text" id="tussenvoegsel" placeholder="Tussevoegsel" class="form-control" autofocus>
                </div>
                
                 </div>       
                  <div class="form-group">
                    <label for="Achternaam" class="col-sm-3 control-label">Achternaam</label>
                    <div class="col-sm-9">
                        <input type="text" id="Achternaam" placeholder="Achternaam" class="form-control" autofocus>
                </div>
                </div>        
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <input type="email" id="email" placeholder="Email" class="form-control">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Wachtwoord</label>
                    <div class="col-sm-9">
                        <input id="password" type="password" class="form-control" name="password"  placeholder="wachtwoord"/>
                    </div>
                    
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Wachtwoord bevestigen</label>
                    <div class="col-sm-9">
    				<input id="cfmPassword" type="password" class="form-control" name="cfmPassword"  placeholder="Wachtwoord Bevestigen"/>
                    </div>
                    
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">Geboortedatum</label>
                    <div class="col-sm-9">
                        <input type="date" id="birthDate" class="form-control">
                    	
                    </div>
                </div>
                <div class=" form-group">
                
                    <label for="country" class="col-sm-3 control-label">Docent/Student</label>
                    <div class="col-sm-9">
                       	<input id="leerling" type="radio" name="docentstudent" value="Student" >Student
                       	<input id="leraar" type="radio" name="docentstudent" value="Docent">Docent
                    </div>
                   
                    	<label for="Student/Docent" class="col-sm-9 form-group"></label>                    		
                    	<div class="from-control">
                    			<div id="student" class="form-group">
                    		
                  						  <label for="firstName" class="col-sm-3 control-label">ovNummer</label>
                    				<div class="col-sm-9">
                       					 <input name="OvNummer" type="text" id="firstName" placeholder="ovNummer" class="form-control">
                       					 <br>
                					</div>
                					
                						<label for="firstName" class="col-sm-3 control-label">BeginJaar</label>
                    				<div class="col-sm-9">
                       					 <input name="OvNummer" type="text" id="firstName" placeholder="BeginJaar" class="form-control">
                       					 <br>
                					</div>
                					
										<label for="firstName" class="col-sm-3 control-label">BSN</label>
                    				<div class="col-sm-9">
                       					 <input name="OvNummer" type="text" id="firstName" placeholder="BeginJaar" class="form-control">
                       					 <br>
                					</div>
                					
                						<label for="firstName" class="col-sm-3 control-label">CardId</label>
                    				<div class="col-sm-9">
                       					 <input name="OvNummer" type="text" id="firstName" placeholder="CardId" class="form-control">
                       					 <br>
                					</div>
                					
               					 </div>	
               					<div id="docent" class="form-group">
                  							<label for="firstName" class="col-sm-3 control-label">EmployeeNumber</label>
                    			<div class="col-sm-9">
                       						<input type="text" id="firstName" placeholder="EmployeeNumber" class="form-control">
                       						
                						</div>
                							<label for="firstName" class="col-sm-3 control-label">CardId</label>
                    			<div class="col-sm-9">
                       						<input type="text" id="firstName" placeholder="cardId" class="form-control">
                       						<br>
                						</div>
                							<label for="firstName" class="col-sm-3 control-label">Abbreviation</label>
                    			<div class="col-sm-9">
                       						<input type="text" id="firstName" placeholder="Abbreviation" class="form-control">
                       						<br>
                						</div>
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
