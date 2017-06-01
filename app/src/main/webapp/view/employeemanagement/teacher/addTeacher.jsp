<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<sx:head/>
<t:layout2>
  <jsp:attribute name="content">
    <div class="container">
      <h1>Docent toevoegen</h1>
      <br>
      <form action="addTeacher" class="" enctype="multipart/form-data" method="post" id="addTeacherForm">
        <s:bean name="nl.scalda.pasimo.model.employeemanagement.Teacher" var="teacher">
          <div class="form-group row">
            <label class="col-2 col-form-label">Voornaam</label>
            <div class="col-10">
              <s:textfield id="teacherFirstName" style="width: 50%;" class="form-control" name="teacher.firstName" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Tussenvoegsel</label>
            <div class="col-10">
              <s:textfield id="teacherInsertion" style="width: 50%;" class="form-control" name="teacher.insertion" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Achternaam</label>
            <div class="col-10">
              <s:textfield id="teacherLastName" style="width: 50%;" class="form-control" name="teacher.lastName" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Email</label>
            <div class="col-10">
              <s:textfield id="teacherEmail" style="width: 50%;" class="form-control" name="teacher.email" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Geboortedatum</label>
            <div class="col-10">
              <sx:datetimepicker name="teacher.dateOfBirth" displayFormat="dd-MMM-yyyy" value="" id="teacherDateOfBirth" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Kaartnummer</label>
            <div class="col-10">
              <s:textfield id="teacherCardID" style="width: 50%;" class="form-control" name="teacher.cardID" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Werknemersnummer</label>
            <div class="col-10">
              <s:textfield id="teacherEmployeeNumber" style="width: 50%;" class="form-control" name="teacher.employeeNumber" type="text" />
              <br>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">Educatieteam</label>
            <div class="col-10">
                <s:select class="form-control" style="width: 50%;" name="teamAbbreviation" list="educationTeams" listKey="abbreviation" listValue="name"></s:select>
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
  <script type="text/javascript" src="resources/js/teacher.js"></script>
</jsp:attribute>
</t:layout2>
