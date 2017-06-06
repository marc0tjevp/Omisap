<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:layout2>
  <jsp:attribute name="content">
  <div class="container">
    <h1>Student wijzigen</h1>
    <br>
    <form action="editStudent" class="" enctype="multipart/form-data" method="post">
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
            <s:textfield  id="studentInsertion" style="width: 50%;" class="form-control" name="student.insertion" type="text" />
          </div>
        </div>
        <div class="form-group row">
          <label class="col-2 col-form-label">Achternaam</label>
          <div class="col-10">
            <s:textfield id="studentLastName" style="width: 50%;" class="form-control" name="student.lastName" type="text" />
          </div>
        </div>
        <div class="form-group row">
          <label class="col-2 col-form-label">Email</label>
          <div class="col-10">
            <s:textfield id="studentEmail" style="width: 50%;" class="form-control" name="student.email" type="text" />
          </div>
        </div>
        <div class="form-group row">
          <label class="col-2 col-form-label">Kaartnummer</label>
          <div class="col-10">
            <s:textfield id="studentCardID" style="width: 50%;" class="form-control" name="student.cardID" type="text" />
          </div>
        </div>
        <s:textfield id="studentOV" style="width: 0%; display: none" class="form-control" name="student.studentOV" type="hidden" />
        <div class="form-group row">
          <label class="col-2 col-form-label">StudentOV</label>
          <div class="col-10">
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
