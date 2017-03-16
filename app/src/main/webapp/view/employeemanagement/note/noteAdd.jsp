<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!-- <link rel="stylesheet" href="/resources/css/noteAdd.css"></link>
    <link rel="stylesheet" href="../Pasimo/resources/css/style.css"> -->
<t:layout2>
	<jsp:attribute name="scripts">
<script type="text/javascript" src="/Pasimo/resources/js/note.js"></script>
</jsp:attribute>
	<jsp:attribute name="css">
		<link rel="stylesheet" href="<c:url value="/resources/css/note.css"/>" />
	</jsp:attribute>
	<jsp:attribute name="content">
	

<!-- note imput -->	

<form action="noteAdd" class="" enctype="multipart/form-data"
			method="post" id="noteForm">		
			<s:bean name="nl.scalda.pasimo.model.employeemanagement.Note"
				var="note">					
<div class="container kader">
	<div class="row">
		<div class="col col-md-6 border">
			<div class="row">
				<div class="col-md-12">
				<h2>Nieuwe notitie aanmaken</h2>				
				</div>
			</div>
			
			<div class="row">
				<div class="col col-md-12">
<div class="form-group">
  <label for="sel1">Gemaakt door docent:	</label>
  <select name="note.teacher" class="form-control" id="sel1">
    <option value="SCHOMX">Max</option>
    <!--<option>Rens</option> -->
    <!--<option>Bram</option> -->
    <!--<option>Gino</option> -->
  </select>
</div>
				</div>
			</div>
	
			<div class="row">
				<div class="col col-md-12">
					<h5>Titel:</h5>
					<input id="noteTitle" class="input" type="text" name="note.title"
										placeholder="DD-MM-YY / Name"><br>
				</div>
			</div>
			<div class="row">
				<div class="col col-md-12">
					
					<h5>Bericht:</h5>
				</div>
				<div class="col col-md-12">
					<textarea id="noteMessage" class="textarea" name="note.message"
										rows="10" placeholder="Notitie"></textarea>
									
				
				</div>
				
			</div>
			
			<div class="row">
				<div class="col col-md-6">
				
				</div>
		
	
			
				<div class="col col-md-3">
				<button class="button1" type="button" data-toggle="modal"
										data-target="#myModal">Aanmaken</button>
				</div>
				<div class="col col-md-3">
				<button class="button1" type="button" name="cancel"
										data-toggle="modal" data-target="#myModal">Annuleren</button>
				</div>
				
			</div>
		
		</div>
	</div>	
<!-- end note imput -->

</div>

</s:bean>
		</form>
<!--pop up-->
<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
      <div class="modal-content">
    
      	<div class="modal-header">	
        	<button type="button" class="close" data-dismiss="modal">&times;</button>
        	<h4 class="modal-title">Weet u zeker dat u de geselecteerde notitie wilt toevoegen?	</h4>
      	</div>
      	<div class="modal-body">
   	   	</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default"
							data-dismiss="modal" id="noteSubmit">Toevoegen</button>
        <button type="button" class="btn btn-default"
							data-dismiss="modal">Annuleren</button>

      </div>
    </div>

  </div>
</div>


<!-- end pop up -->
	
	
	</jsp:attribute>

</t:layout2>