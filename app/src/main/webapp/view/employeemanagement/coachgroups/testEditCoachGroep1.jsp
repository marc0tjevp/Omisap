<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout2>
	<jsp:attribute name="css">
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/editCoachGroup.css"/>" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			
    </jsp:attribute>
		<jsp:attribute name="content">
    
    
   			 <body>
       			<div class="select-div">
       				<form action="action" method="post">
       					
       						<label for="business">Teachers</label>
								<select id="select" name="select">
									<option value="First Choice">Bram</option>
									<option value="Second Choice">Rens</option>
									<option value="Third Choice">Max</option>
									<option value="Fourth Choice">Kees</option>
								</select>
						
								<p></p>
										<label for="inputName">Name</label>
										
										<input id="text" type="text" value="inputName" placeholder="inputName">
										
										
										
								<input type="submit" value="confirm">
					</form>
				</div>
					
								
       					
       							
		       			
       				<!-- <button class="dropdown-toggle" type="button" data-toggle="dropdown">Rens<span class="caret"></span></button>
                	<ul class="dropdown-menu">
                	               	
                	
                	
               		</ul> -->
    			
    				<!--  <input type="text" class="form-control" id="inputEdit" name="inputName">Rens -->
   						 				
    			
      		
    				
    </body>				
    			
      		
    </jsp:attribute>
</t:layout2>

