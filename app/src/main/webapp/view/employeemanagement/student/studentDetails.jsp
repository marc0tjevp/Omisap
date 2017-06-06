<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page	import="nl.scalda.pasimo.controller.employeemanagement.StudentController"%>
<%@page import="nl.scalda.pasimo.model.employeemanagement.Student"%>
<%@page import="nl.scalda.pasimo.model.employeemanagement.Person"%>
<sx:head/>
<t:layout2>
	<jsp:attribute name="content">
   
    <h1>Details van <b>${param.cardId}</b></h1>
  		
		<form action="studentCheckInRegistration/studentDetails/date" class="" enctype="multipart/form-data" method="post" id="searchDate">
         <div class="form-group row">
            <label class="col-2 col-form-label">Selecteer een datum:</label>
            <div class="col-10">
              <sx:datetimepicker name="searchDate" displayFormat="dd-MMM-yyyy" value="" id="calendarDate"/>
            </div>
            <input type="submit" id="dateButton"/>
         </div>
         </form>
         
		<h2>Inklok tijden:</h2>
		
		<table>
		<thead>
		<th>Datum</th>
		<th style="color:blue;">Check In</th>
		<th style="color:blue;">Check Out</th>
		<th style="color:red;">Check In</th>
		<th style="color:red;">Check Out</th>
		</thead>
        <s:iterator value="studentCheckInHistory" var="checkIn">
        <tr>
        				<td><s:property value="getFormattedDate()" /></td>
						<td><s:property value="getFormattedTime()" /></td>
		</tr>
        </s:iterator>
        </table>
        	
    </jsp:attribute>
    <jsp:attribute name="scripts">
 	 <script type="text/javascript" src="/Pasimo/resources/js/student-calendar.js"></script>
	</jsp:attribute>
</t:layout2>