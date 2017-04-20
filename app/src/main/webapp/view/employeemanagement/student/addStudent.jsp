<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<sx:head/>
<t:layout2>
  <jsp:attribute name="content">
    <div class="container">
      <h1>student toevoegen</h1>
      <br>
      <form action="addStudent" class="" enctype="multipart/form-data" method="post" id="addStudentForm">
        <s:bean name="nl.scalda.pasimo.model.employeemanagement.Student" var="Student">
          <div class="form-group row">
            <label class="col-2 col-form-label">Voornaam</label>
            <div class="col-10">
              <s:textfield id="StudentFirstName" style="width: 50%;" class="form-control" name="Student.firstName" type="text" />
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
              <s:textfield id="StudentEmail" style="width: 50%;" class="form-control" name="Student.email" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Geboortedatum</label>
            <div class="col-10">
              <sx:datetimepicker name="Student.dateOfBirth" displayFormat="dd-MMM-yyyy" value="" id="StudentDateOfBirth" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Kaartnummer</label>
            <div class="col-10">
              <s:textfield id="StudentCardID" style="width: 50%;" class="form-control" name="Student.cardID" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Werknemersnummer</label>
            <div class="col-10">
              <s:textfield id="StudentEmployeeNumber" style="width: 50%;" class="form-control" name="Student.employeeNumber" type="text" />
              <br>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Educatieteam</label>
            <div class="col-10">
                <s:select class="form-control" style="width: 50%;" name="teamLessonGroup" list="educationTeams" listKey="LessonGroup" listValue="name"></s:select>
              <br>
              <br>
              <div class="btn btn-primary" id="submitId">Toevoegen</div>
            </div>
          </div>
          <!-- <div class="form-group row">
                   <label class="col-2 col-form-label">Profielfoto</label>
                   <div class="col-10">
                     <input class="form-control" type="file" id="myFile"><br>
                   </div>
                 </div> -->
        </s:bean>
      </form>
    </div>
  </jsp:attribute>
  <jsp:attribute name="scripts">
  <script type="text/javascript" src="resources/js/Student.js"></script>
</jsp:attribute>
</t:layout2>