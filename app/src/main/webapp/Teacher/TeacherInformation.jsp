<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:layout2>
  <jsp:attribute name="content">
  <div class="container-info">
  	<div class="container-profile-picture">
  	<img src="../Pasimo/resources/images/emma.jpg" alt="emma" height="100%" width="100%"></img>
  	</div>
  	<div class="container-teacherInformation">
  		 <form  action="editTeacherPage?id=<s:property value="teacher.employeeNumber"></s:property>" method="post"><input type="submit" value="Aanpassen" class="editButtonInfoPage btn btn-primary btn-sm"></form>
  		 <table>
  		 <tbody>
  		 <tr><td><label>Naam: </label></td><td><span><s:property value="teacher.abbreviation" /> - <s:property value="teacher.fullName" /></span></td></tr>
  		 <tr><td><label>Werknemer: </label></td><td><span><s:property value="teacher.employeeNumber" /></span></td></tr>
  		 <tr><td><label>Kaartnummer: </label></td><td><span><s:property value="teacher.cardID" /></span></td></tr>
  		 <tr><td><label>Geboortedatum: </label></td><td><span><s:property value="teacher.getDateOfBirthInString()" /></span></td></tr>
  		 <tr><td><label>Coach groep: </label></td><td><span><s:property value="teacher.getCoachGroup" /></span></td></tr>
  		 <tr><td><label>Team: </label></td><td><span><s:property value="teacher.getTeam" /></span></td></tr>
  		 <tr><td><label>Emailadres: </label></td><td><span><s:property value="teacher.email" /></span></td></tr>
  		 </tbody>
  		 </table>
  	</div>
  	<div class="container-presentInfo">
  	<table class="table table-striped present-table"> 
  	<thead>
  	<tr>
  		<th>Klokmoment</th>
  		<th>In / Uit</th>
  	</tr>
  	</thead>
  	<tbody>
  		<tr>
  			<td>31-1-2017 11:01:31.372</td>
  			<td>in</td>
  		</tr>
  		<tr>
  			<td>31-1-2017 13:21:54.122</td>
  			<td>uit</td>
  		</tr>
  		<tr>
  			<td>31-1-2017 13:21:54.122</td>
  			<td>uit</td>
  		</tr>
  		<tr>
  			<td>31-1-2017 13:21:54.122</td>
  			<td>uit</td>
  		</tr>
  		<tr><td></td><td></td></tr>
  		<tr><td></td><td></td></tr>
  		<tr><td></td><td></td></tr>
  		<tr><td></td><td></td></tr>
  		<tr><td></td><td></td></tr>
  		<tr><td></td><td></td></tr>
  		<tr><td></td><td></td></tr>
  	</tbody>
  	</table>
  	<div class="chart-container">
	<canvas id="myChart"></canvas>
	<div id="legend"></div>
  	</div>
  	</div>
  	<div>
  	</div>
  </div>
  </jsp:attribute>
  <jsp:attribute name="scripts">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js" type="text/javascript"></script>
  <link rel="stylesheet"  href="resources/css/delayedContent.css"/>
  <script type="text/javascript" src="resources/js/teacher-table.js"></script>
</jsp:attribute>
</t:layout2>

