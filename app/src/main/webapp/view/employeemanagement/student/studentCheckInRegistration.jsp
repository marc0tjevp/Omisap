<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page
	import="nl.scalda.pasimo.controller.employeemanagement.StudentController"%>
<%@page import="nl.scalda.pasimo.model.employeemanagement.Student"%>
<%@page import="nl.scalda.pasimo.model.employeemanagement.Person"%>
<t:layout2>
	<jsp:attribute name="content">
   
    <h1>Check-Ins van: Alle Studenten <s:property value="lessongroupname" />
		</h1>
  
  		<body>
        <header>
				<h2>Inklok tijden van vandaag:</h2>
			</header>
        <table class="table" style="width: 50%; align: left;">
                <thead>
                <th>Leerlingnummer</th>
				<th>Naam</th>
				<th>Check In</th>
				<th>Check Out</th>
				<th>Check In</th>
				<th>Check Out</th>
				</thead>
				<tbody>
		<tr>
		<s:iterator value="allStudents" var="student">
        				<td><s:property value="getStudentOV()" /></td>
						<td><s:property value="getFirstName()" /></td>
							
			<s:iterator value="getCheckInsOfToday()" var="checkIn">
						<td><s:property value="getFormattedTime()" /></td>
        	</s:iterator>
		</s:iterator>


		</tr>
		</tbody>
        </table>
        </body>
        	
    </jsp:attribute>
</t:layout2>