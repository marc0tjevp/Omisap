<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout2>
    <jsp:attribute name="content">
    
    <head>
    <h1>Details van "student naam hier"</h1>
    </head>
       
        <body>
        <header><h2>Check-in/out Times</h2></header>
        <table class="table">
        <c:forEach items="${studentCheckIns}" var="checkIn">
    	<tr><td>${entry.key}</td><td>${entry.value.myProperty}</td></tr>
		</c:forEach>
        </table>
        </body>
        
    </jsp:attribute>
</t:layout2>