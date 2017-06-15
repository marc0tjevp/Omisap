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

<form action="noteEdit" method="post" id="noteFormEdit">				
<div class="container kader">
    <div class="row">
        <div class="col col-md-6 border">
            <div class="row">
                <div class="col-md-12">
                <h2>Notitie bewerken</h2>                
                </div>
            </div>
    
            <div class="row">
                <div class="col col-md-12">
                    <h5>Titel:</h5>
                    <input type="hidden" name="id" value="${note.getId()}">
                    <input id="noteTitle" class="input" type="text" name="title"
                                        value="${note.getTitle()}"><br>
                </div>
            </div>
            <div class="row">
                <div class="col col-md-12">
                    
                    <h5>Bericht:</h5>
                </div>
                <div class="col col-md-12">
                    <textarea id="noteMessage" class="textarea" name="message"
                                        rows="10">${note.getMessage()} </textarea>
                </div>    
            </div>
            <div class="row">
                <div class="col col-md-6">
                </div>
                <div class="col col-md-3">
                <button class="btn btn-primary" type="button" data-toggle="modal"
                                        data-target="#myModal" id="${note.getId() }">Bewerken</button>
                </div>
                <div class="col col-md-3">
                <a class="btn btn-primary" href="noteOverview">Annuleren</a>
                </div>
                
                
            </div>
        
        </div>
    </div>    

<!-- end note imput -->

</div>
		</form>
<!--pop up-->

<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
      <div class="modal-content">
    
      	<div class="modal-header">	
        	<button type="button" class="close" data-dismiss="modal">&times;</button>
        	<h4 class="modal-title">Weet u zeker dat u de geselecteerde notitie wilt bewerken?	</h4>
      	</div>
      	<div class="modal-body">
   	   	</div>
      <div class="modal-footer">
        <a type="button" class="btn btn-default"
						id="noteEdit" >bewerken</a>
        <button type="button" class="btn btn-default"
							data-dismiss="modal">Annuleren</button>

      </div>
    </div>

  </div>
</div>

<!-- end pop up -->
	
	
	</jsp:attribute>

</t:layout2>