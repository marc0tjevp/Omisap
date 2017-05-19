<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page import="nl.scalda.pasimo.controller.employeemanagement.StudentController" %>
<t:layout2>
    <jsp:attribute name="content">
   
    <h1>Details van Student</h1>
  
  		<body>
        <header><h2>Check-in/out Times</h2></header>
        <table class="table">
        <s:iterator value="#studentCheckinz" var="checkIn">
        <td><s:property value="#checkIn.value"/></td>
        </s:iterator>
        </table>
        </body>
        	
    </jsp:attribute>
</t:layout2>