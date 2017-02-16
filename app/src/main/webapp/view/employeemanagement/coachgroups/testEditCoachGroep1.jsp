<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<body>
<t:layout2>
    <jsp:attribute name="css">
         <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/coachgroup.css"/>"/>
    </jsp:attribute>
     <html>
    <head>
    </head>
    
    		<div class="div">
    			<form action="edit" method="post">
    				<input type="text" class="form-control" id="inputEdit" name="inputName">Rens
    			</form>
      		</div>
    				
    				
    			
      		
    	
    </t:layout2>
    </body>
    </html>