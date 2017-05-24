<%@page import="nl.scalda.pasimo.model.employeemanagement.Team"%>
<%@page import="nl.scalda.pasimo.model.employeemanagement.EducationTeam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<head>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/base/jquery-ui.css" />
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<t:layout2>
	<jsp:attribute name="content">

<style>
H1 {
	text-align: center;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 3px solid #dddddd;
	text-align: center;
	padding: 8px;
}

.aTableAvailability {
	font-weight: bold;
}

.teamsButton {
	width: 50%;
	display: block;
	margin: 5px auto;
}
</style>


<h1>Beschikbaarheid Docenten</h1>
<div class="row">
	<div class="col-md-3 col-lg-3 col-sm-3"></div>
	<div class="col-md-6 col-lg-6 col-sm-6">
		<s:if test="id == NULL">
			<s:iterator value="teams" var="t">
				<s:a class="teamsButton btn btn-primary" href="/Pasimo/TeacherPresence?id=%{id}">
					<s:property value="%{name}" />
				</s:a>
			</s:iterator>
		</s:if>
		<s:else>
			<table>
				<tr>
					<th style="background-color: #e6e6e6;" width="50%">Aanwezig</th>
					<th style="background-color: #e6e6e6;" width="50%">Afwezig</th>
				</tr>
				<s:iterator value="checkedInTeacher" var="c">
					<tr>
						<td><s:property value="getFullName()" /></td>
						<td></td>
					</tr>
				</s:iterator>
				<s:iterator value="checkedOutTeacher" var="c">
					<tr>
						<td></td>
						<td><s:property value="getFullName()" /></td>
					</tr>
				</s:iterator>
			</table>
		</s:else>
	</div>
	<div class="col-md-3 col-lg-3 col-sm-3"></div>
</div>


   </jsp:attribute>
</t:layout2>
