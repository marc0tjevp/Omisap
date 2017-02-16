<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<t:layout2>
	<jsp:attribute name="content">
    <h1>Nieuwe notitie aanmaken</h1>
			<div class="panel panel-default"></div>
	<div class="panel-heading"></div>
	<div class="panel-body">
	</div>
	<div style = "border-style : solid; padding : 20px; width: 250px; border-color: #1E90FF;">
	<p>Titel:</p>

	<input type="text" name="inputDate" placeholder="DD-MM-YY / Name">
		<br>
	<form>
		<p>Bericht:</p>
		<textarea name="note" rows="10" cols="30" placeholder="Notitie"></textarea>
	</form>
	<button type="button" data-toggle="modal" data-target="#myModal"
			style="margin-right: 45px;">Aanmaken</button>
	<button type="button" name="cancel">Annuleren</button>
</div>	
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
	
	
            </jsp:attribute>
</t:layout2>