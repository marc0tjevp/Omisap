<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<t:layout2>
	<jsp:attribute name="content">
    <h1>Nieuwe notitie aanmaken</h1>
<form action="noteAdd" class="" enctype="multipart/form-data"
			method="post" id="noteForm">
        <s:bean name="nl.scalda.pasimo.model.employeemanagement.Note"
				var="note">
			<div class="panel panel-default"></div>
	<div class="panel-heading"></div>
	<div class="panel-body">
	
	</div>
	<div
					style="border-style: solid; padding: 20px; width: 250px; border-color: #1E90FF;">
	<p>Titel:</p>
	<s:textfield id="noteTitle" style="width: 75%;" class="form-control"
						name="note.title" type="text" placeholder="DD-MM-YY / Naam" />

		<br>
	
		<p>Bericht:</p>
		<s:textarea id="noteMessage" rows="10" cols="30" placeholder="Notitie"
						name="note.message" type="text"></s:textarea>
							<button type="button" data-toggle="modal" data-target="#myModal"
						style="margin-right: 45px;">Aanmaken</button>
	<button type="button" name="cancel">Annuleren</button>
							</div>
							</s:bean>
	</form>
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
            </jsp:attribute>
	<jsp:attribute name="scripts">
<script type="text/javascript" src="/Pasimo/resources/js/note.js"></script>
</jsp:attribute>
</t:layout2>