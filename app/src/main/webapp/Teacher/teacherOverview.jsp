<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/layout.jsp"%>
<h1>Overzicht van Docenten</h1>
<br>
<table class="table">
  <thead>
    <tr>
      <th>Afkorting</th>
      <th>Kaartnummer</th>
      <th>Email</th>
      <th>Voornaam</th>
      <th>Tussenvoegsel</th>
      <th>Achternaam</th>
      <th>Werknemersnummer</th>
      <th>Wijzig</th>
      <th>Verwijder</th>
    </tr>
  </thead>
  <tbody>
  <s:iterator value="teachers">
  	<tr>
      <td><s:property value="abbreviation"></s:property></td>
      <td><s:property value="cardID"></s:property></td>
      <td><s:property value="email"></s:property></td>
      <td><s:property value="firstName"></s:property></td>
      <td><s:property value="insertion"></s:property></td>
      <td><s:property value="lastName"></s:property></td>
      <td><s:property value="employeeNumber"></s:property></td>
      <td>edit</td>
      <td>delete</td>
    </tr>
  </s:iterator>
    
  </tbody>
</table>

<%@include file="../includes/footer.jsp"%>