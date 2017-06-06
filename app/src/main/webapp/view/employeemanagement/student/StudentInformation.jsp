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
  	<div class="container-studentInformation">
  		 <form  action="editStudentPage?id=<s:property value="Student.studentOV"></s:property>" method="post"><input type="submit" value="Aanpassen" class="editButtonInfoPage btn btn-primary btn-sm"></form>
  		 <table>
  		 <tbody>
  		 <tr><td><label>Naam: </label></td><td><span><s:property/> - <s:property value="student.fullName" /></span></td></tr>
  		 <tr><td><label>StudentNummer: </label></td><td><span><s:property value="student.studentOV" /></span></td></tr>
  		 <tr><td><label>Kaartnummer: </label></td><td><span><s:property value="student.cardID" /></span></td></tr>
  		 <tr><td><label>Geboortedatum: </label></td><td><span><s:property value="student.getDateOfBirthInString()" /></span></td></tr>
  		 <tr><td><label>Coach groep: </label></td><td><span><s:property value="student.getCoachGroup().name" /></span></td></tr>
  		 <tr><td><label>klas </label></td><td><span><s:property value="student.getLessonGroup().name" /></span></td></tr>
  		 <tr><td><label>Emailadres: </label></td><td><span><s:property value="student.email" /></span></td></tr>
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
  			<td>31-1-2017 08:49:31.372</td>
  			<td>In</td>
  		</tr>
  		<tr>
  			<td>31-1-2017 12:05:54.122</td>
  			<td>Uit</td>
  		</tr>
  		<tr>
  			<td>31-1-2017 12:36:11.621</td>
  			<td>In</td>
  		</tr>
  		<tr>
  			<td>31-1-2017 14:15:24.332</td>
  			<td>Uit</td>
  		</tr>
   		<tr>
  			<td>1-2-2017 07:49:31.372</td>
  			<td>In</td>
  		</tr>
  		<tr>
  			<td>1-2-2017 12:07:54.122</td>
  			<td>Uit</td>
  		</tr>
  		<tr>
  			<td>1-2-2017 12:34:11.621</td>
  			<td>In</td>
  		</tr>
  		<tr>
  			<td>1-2-2017 14:29:24.332</td>
  			<td>Uit</td>
  		</tr>
  		<tr>
  			<td>2-2-2017 07:59:11.621</td>
  			<td>In</td>
  		</tr>
  		<tr>
  			<td>2-2-2017 12:06:24.332</td>
  			<td>Uit</td>
  		</tr>
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
  <script type="text/javascript" src="resources/js/student-table.js"></script>
</jsp:attribute>
</t:layout2>

