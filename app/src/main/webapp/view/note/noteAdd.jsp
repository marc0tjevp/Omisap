<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!-- <link rel="stylesheet" href="/resources/css/noteAdd.css"></link>
    <link rel="stylesheet" href="../Pasimo/resources/css/style.css"> -->
<t:layout2>
	<jsp:attribute name="css">

	<link rel="stylesheet"  href="<c:url value="/resources/css/noteAdd.css"/>"/>
	</jsp:attribute>
	<jsp:attribute name="content">
	
    <h1>Nieuwe notitie aanmaken</h1>
    


<!-- note imput -->	
<div class="container kader">
	<div class = "row">
		<div class = "col col-md-3 border">
			<div class = "row">
				<div class = "col col-md-12">
					<h5>Titel:</h5>
					<input type="text" name="inputDate" placeholder="DD-MM-YY / Name"><br>
				</div>
			</div>
			<div class = "row">
				<div class = "col col-md-12">
					
					<h5>Bericht:</h5>
					<form>
					<textarea name="note" rows="10" cols="30" placeholder="Notitie"></textarea>
					</form>
				</div>
			</div>
			<div class = "row">
				<div class = "col col-md-4">
				<button type="button" data-toggle="modal" data-target="#myModal">Aanmaken</button>
				</div>
				<div class = "col col-md-4">
				<button type="button" name="cancel">Annuleren</button>
				</div>
				<div class = "col col-md-4">
				
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