<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:layout2>
  <jsp:attribute name="content">
  <div class="container">
<h1>Overzicht van Docenten <a href="addTeacherPage" class="btn btn-primary pull-right">Toevoegen</a></h1>
<br>
<table class="table table-hover table-responsive">
  <thead>
    <tr>
      <th>Werknemersnummer</th>
      <th>Afkorting</th>
      <th>Kaartnummer</th>
      <th>Email</th>
      <th>Voornaam</th>
      <th>Tussenvoegsel</th>
      <th>Achternaam</th>
      <th>Wijzig</th>
      <th>Verwijder</th>
    </tr>
  </thead>
  <tbody>
  <s:iterator value="teachers">
  	<tr>
  	<div class="rowContainer">
  	  <td name="emplnumb"><a href="teacherInfo?id=<s:property value="employeeNumber"></s:property>" class="noStyleAnchorTag"><s:property value="employeeNumber"></s:property></a></td>
      <td><a href="teacherInfo?id=<s:property value="employeeNumber"></s:property>" class="noStyleAnchorTag"><div style="height:100%;width:100%;"><s:property value="abbreviation"></s:property></div></a></td>
      <td><a href="teacherInfo?id=<s:property value="employeeNumber"></s:property>" class="noStyleAnchorTag"><s:property value="cardID"></s:property></a></td>
      <td><a href="teacherInfo?id=<s:property value="employeeNumber"></s:property>" class="noStyleAnchorTag"><s:property value="email"></s:property></a></td>
      <td><a href="teacherInfo?id=<s:property value="employeeNumber"></s:property>" class="noStyleAnchorTag"> <s:property value="firstName"></s:property></a></td>
      <td><a href="teacherInfo?id=<s:property value="employeeNumber"></s:property>" class="noStyleAnchorTag"><s:property value="insertion"></s:property></a></td>
      <td><a href="teacherInfo?id=<s:property value="employeeNumber"></s:property>" class="noStyleAnchorTag"><s:property value="lastName"></s:property></a></td>
      <td>
        <a name="edit" href="editTeacherPage?id=<s:property value="employeeNumber"></s:property>">
          <span class="fa fa-pencil"></span></a>
      </td>
      <td><a href="removeTeacher?id=<s:property value="employeeNumber"></s:property>" onclick="if(confirm('Weet u zeker dat u deze leraar wilt verwijderen?')){return true}else{return false}"><span class="fa fa-trash"></span></a></td>
    </div>
    </tr>
  </s:iterator>
    
  </tbody>
</table>
</div>
  </jsp:attribute>
  <jsp:attribute name="scripts">
  <link rel="stylesheet"  href="resources/css/delayedContent.css"/>
<script type="text/javascript" src="resources/js/teacher-table.js"></script>
</jsp:attribute>
</t:layout2>