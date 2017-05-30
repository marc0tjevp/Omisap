<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page import="nl.scalda.pasimo.controller.employeemanagement.StudentController"%>
<t:layout2>
	<jsp:attribute name="content">
   
    <h1>Details van Student</h1>
  
  		<body>
        <header>
				<h2>Inklok tijden:</h2>
			</header>
        <table class="table" style="width: 50%; align: left;">
        <s:iterator value="studentCheckinz" var="checkIn">
        <tr>
						<td></td>
						<td><s:property value="getFormattedTime()" /></td>
						<td><s:property value="getFormattedDate()" /></td>
		</tr>
        </s:iterator>
        </table>
        </body>
        	
    </jsp:attribute>
</t:layout2>