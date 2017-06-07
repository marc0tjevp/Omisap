<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<html>

<t:layout>
	<jsp:attribute name="css">
         <link type="text/css" rel="stylesheet"
			href="<c:url value="/resources/css/loginView.css"/>" />
    </jsp:attribute>


    <jsp:attribute name="content">
        

	<div class="container1">
    <div class="row">
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Wachtwoord vergeten</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form class="login"
							action="login" role="form" method="post">
						<fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" placeholder="E-mail" name="email" type="text">
			    		</div>
			    		<input class="button" id="Wachtwoordvergeten" type="submit" value="Wachtwoord veranderen">
			    		</fieldset>
			    	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
</jsp:attribute>
</t:layout>
</html>