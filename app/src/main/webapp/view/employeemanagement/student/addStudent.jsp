<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<sx:head/>
<t:layout2>
  <jsp:attribute name="content">
    <div class="container">
      <h1>Student add</h1>
      <br>
      <form action="addStudent" class="" enctype="multipart/form-data" method="post" id="addStudentForm">
        <s:bean name="nl.scalda.pasimo.model.employeemanagement.Student" var="student">
          <div class="form-group row">
            <label class="col-2 col-form-label">Voornaam</label>
            <div class="col-10">
              <s:textfield id="studentFirstName" style="width: 50%;" class="form-control" name="student.firstName" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Tussenvoegsel</label>
            <div class="col-10">
              <s:textfield id="StudentInsertion" style="width: 50%;" class="form-control" name="Student.insertion" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Achternaam</label>
            <div class="col-10">
              <s:textfield id="StudentLastName" style="width: 50%;" class="form-control" name="Student.lastName" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Email</label>
            <div class="col-10">
              <s:textfield id="studentEmail" style="width: 50%;" class="form-control" name="student.email" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Geboortedatum</label>
            <div class="col-10">
              <sx:datetimepicker name="student.dateOfBirth" displayFormat="dd-MMM-yyyy" value="" id="studentDateOfBirth" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">OvNummer</label>
            <div class="col-10">
              <s:textfield id="studentOvNumber" style="width: 50%;" class="form-control" name="student.OvNumber" type="text" />
            </div>
          </div>
        </s:bean>
      </form>
    </div>
  </jsp:attribute>
  <jsp:attribute name="scripts">
  <script type="text/javascript" src="resources/js/teacher.js"></script>
</jsp:attribute>
</t:layout2>
