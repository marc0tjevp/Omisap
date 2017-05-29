<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page	import="nl.scalda.pasimo.controller.employeemanagement.StudentController"%>
<%@page import="nl.scalda.pasimo.model.employeemanagement.Student"%>
<%@page import="nl.scalda.pasimo.model.employeemanagement.Person"%>
<t:layout2>
	<jsp:attribute name="content">
   
    <h1>Check-Ins van: Alle Studenten <s:property value="lessongroupname" />
		</h1>
  
  		<body>
        <header>
				<h2 id="dateTime"></h2>
			</header>
        <table class="table" >
                <thead>
                <th>Leerlingnummer</th>
				<th>Naam</th>
				<th>Tussenvoegsel</th>
				<th>Achternaam</th>
				<th style="color:blue;">Check In</th>
				<th style="color:blue;">Check Out</th>
				<th style="color:red;">Check In</th>
				<th style="color:red;">Check Out</th>
				</thead>
				<tbody>
		<tr>
		<s:iterator value="allStudents" var="student">
		<tr>
        				<td><s:property value="getStudentOV()" /></td>
						<td><s:property value="getFirstName()" /></td>
						<td><s:property value="getInsertion()" /></td>
						<td><s:property value="getLastName()" /></td>
							
			<s:iterator value="getCheckInsOfToday()" var="checkIn">
						<td><s:property value="getFormattedTime()" /></td>
        	</s:iterator>
        	</tr>
		</s:iterator>


		</tr>
		</tbody>
        </table>
        </body>
        <script>
        var d = new Date();
        document.getElementById("dateTime").innerHTML = "Inklok tijden van: " + d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + "";
		</script>
    </jsp:attribute>
</t:layout2>