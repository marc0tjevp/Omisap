<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!-- <link rel="stylesheet" href="/resources/css/noteAdd.css"></link>
    <link rel="stylesheet" href="../Pasimo/resources/css/style.css"> -->
<t:layout2>

	<jsp:attribute name="css">
	<link rel="stylesheet"  href="<c:url value="/resources/css/note.css"/>"/>
	</jsp:attribute>
	<jsp:attribute name="content">
	

<!-- note imput -->	
<div class="container kader">
	<div class = "row">
		<div class = "col col-md-6 border">
			<div class = "row">
				<div class = "col-md-12">
				<h2>Nieuwe notitie aanmaken</h2>
				</div>
			</div>
			<div class="row">
			<div class="col col-md-12">
				<div class="form-group">
  					<label for="sel1"><h5>Gemaakt door docent:</h5></label>
  					<select name="note.teacher" class="form-control" id="sel1">
   					 <option value="SCHOMX">Max</option>
   					 <!--<option>Rens</option> -->
  					 <!--<option>Bram</option> -->
    				<!--<option>Gino</option> -->
 					 </select>
				</div>
				
			</div>
			</div>
	
			<div class = "row">
				<div class = "col col-md-12">
					<h5>Titel:</h5>
					<input class = "input" type="text" name="inputDate" placeholder="DD-MM-YY / Name"><br>
				</div>
			</div>
			<div class = "row">
				<div class = "col col-md-12">
					
					<h5>Bericht:</h5>
				</div>
				<div class ="col col-md-12">
					<textarea class = "textarea" name="note" rows="10" placeholder="Notitie"></textarea>
				
				</div>
			</div>
			<div class = "row">
				<div class = "col col-md-6">
				
				</div>
				<div class = "col col-md-3">
				<button class = "button1" type="button" data-toggle="modal" data-target="#myModal">Aanmaken</button>
				</div>
				<div class = "col col-md-3">
				<button class = "button1" type="button"><a href="">Annuleren</a></button>
				</div>
				
			</div>

	
		</div>
	</div>
</div>	
<!-- end note imput -->

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
							data-dismiss="modal">Toevoegen</button>
        <button type="button" class="btn btn-default"
							data-dismiss="modal">Annuleren</button>

      </div>
    </div>

  </div>
</div>


<!-- end pop up -->
	
	
            </jsp:attribute>
</t:layout2>