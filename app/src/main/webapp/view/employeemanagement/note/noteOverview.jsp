<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<t:layout2>
	<jsp:attribute name="css">
		<link rel="stylesheet" href="<c:url value="/resources/css/note.css"/>" />
	</jsp:attribute>
	<jsp:attribute name="content">

	<div class="container" style="
    max-width: 600px;">
		<div class="row">
			<div class="col-md-12 all">	
		
				<div class="row">
					<div class="col-md-6">
							<h4>Notities overzicht</h4>
						</div>
					
					<div class="col-md-3 button2">
					<a class="btn btn-primary" type="button" 
								href="noteDeleteAll">Alles Verwijderen</a>
					</div>
					
					<div class="col-md-3 button2" id="buttonseperator">
					<a class="btn btn-primary" href="noteView"> Nieuw Aanmaken</a>
					</div>
				</div>
				<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
      <div class="modal-content">
    
      	<div class="modal-header">	
        	<button type="button" class="close" data-dismiss="modal">&times;</button>
        	<h4 class="modal-title">Weet u zeker dat u alle notities wilt verwijderen?	</h4>
      	</div>
      	<div class="modal-body">
   	   	</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default"
										data-dismiss="modal" id="noteDeleteAll">Alles verwijderen</button>
        <button type="button" class="btn btn-default"
										data-dismiss="modal">Annuleren</button>

      </div>
    </div>

  </div>
</div>
				
			 	<div class="row">
					<c:forEach var="n" items="${noteList}">
						<div class="note col-md-3" data-toggle="modal"
								data-target="#overviewModal">
							<div class="row">
							<div onClick=";" style="cursor: pointer;"
										class="col-md-12 noteTitle">Title: ${n.getTitle()}</div>
							</div>
							<div class="row">
								<div class="col-md-12 noteMessage">Gemaakt door: ${n.getMadeBy().getFirstName()}</div>
							</div>					
							<div class="row">
								<div class="col-md-12 noteMessage">Aanmaak datum: ${n.getCreationDate()}</div>
							</div>		
						</div>
						
					</c:forEach>				
				</div>
				
				
				
			</div>
		</div>
	</div>
	<div id="overviewModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
      <div class="modal-content">
    
      	<div class="modal-header">	
        	<button type="button" class="close" data-dismiss="modal">&times;</button>
        	<h4 class="modal-title">Wilt u de notitie verwijderen of bewerken?	</h4>
      	</div>
      	<div class="modal-body">
   	   	</div>
      <div class="modal-footer">
        <a "type="button" class="btn btn-default" 
							id="noteDelete" href="noteDelete">Verwijderen</a>
        <a type="button" class="btn btn-default" href="noteEditView">Bewerken</a>

      </div>
    </div>

  </div>
</div>
		<!-- arraylist terug krijgen van controller, doorheenloopen in een div met c for each -->
		
	</jsp:attribute>
</t:layout2>
