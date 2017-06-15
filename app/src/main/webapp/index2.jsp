<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout2>
	<jsp:attribute name="css">
         <link type="text/css" rel="stylesheet"
			href="<c:url value="/resources/css/loginView.css"/>" />
    </jsp:attribute>
    
    <jsp:attribute name="content">
        <h1>Welkom bij Pasimo</h1>
        <form class="AccountAanmaken"
							action="AccountAanmaken" role="form" method="post">
			 <div class=" form-group">
                    <div class="col-sm-9">									
			<fieldset>
				<label><input type="radio" name="Option1" value="Student" >Student</label>
				<label><input type="radio" name="Option1" value="Docent" >Docent</label>
			</fieldset>
			
			</div>
			</div>
			
        <input class="button" type="submit" value="Account aanmaken">
        </form>
    </jsp:attribute>
</t:layout2>