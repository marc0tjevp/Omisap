<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>   

<t:layout2>
	<jsp:attribute name="css">
		<link rel="stylesheet"  href="<c:url value="/resources/css/note.css"/>"/>
	</jsp:attribute>
	<jsp:attribute name="content">

	<div class = "container">
		<div class = "row">
			<div class = "col-md-6 all">	
		
				<div class = "row">
					<div class ="col-md-6"><h4>Notities:</h4></div>
					
					<div class = "col-md-3">
					<button class = "button">Alles Verwijderen</button>
					</div>
					
					<div class = "col-md-3">
					<button class = "button" ><a href = "noteAdd">Nieuw Aanmaken</a></button>
					</div>
				</div>
				
			 	<div class= "row">
					<c:forEach var="a" items="${noteList}">
						<div class = "note col-md-4">
							<div class= "row">
								<div class = "col-md-12 noteTitle">${a.getTitle()}</div>
							</div>
							<div class= "row">
								<div class = "col-md-12 noteMessage">${a.getMessage()}</div>
							</div>
							
							
						</div>
						
					</c:forEach>				
				</div>
				
				
				
			</div>
		</div>
	</div>
		
		<!-- arraylist terug krijgen van controller, doorheenloopen in een div met c for each -->
		
	</jsp:attribute>
</t:layout2>
