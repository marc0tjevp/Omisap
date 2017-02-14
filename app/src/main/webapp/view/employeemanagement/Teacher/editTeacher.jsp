<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:layout2>
  <jsp:attribute name="content">
  <div class="container">
    <h1>Docent wijzigen</h1>
    <br>
    <form action="editTeacher" class="" enctype="multipart/form-data" method="post">
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
            <s:textfield  id="teacherInsertion" style="width: 50%;" class="form-control" name="teacher.insertion" type="text" />
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
          <label class="col-2 col-form-label">Kaartnummer</label>
          <div class="col-10">
            <s:textfield id="teacherCardID" style="width: 50%;" class="form-control" name="teacher.cardID" type="text" />
          </div>
        </div>
        <s:textfield id="employeeNumber" style="width: 0%; display: none" class="form-control" name="teacher.employeeNumber" type="hidden" />
        <div class="form-group row">
          <label class="col-2 col-form-label">Educatieteam</label>
          <div class="col-10">
                <s:select class="form-control" style="width: 50%;" name="teamAbbreviation" list="educationTeams" 
                listKey="abbreviation" listValue="abbreviation + ' - ' + name" value="teamAbbreviation"></s:select>
            <br>
            <br>
            <input type="submit" value="Wijzigen" class="btn btn-primary" id="submitId" />
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
</t:layout2>
