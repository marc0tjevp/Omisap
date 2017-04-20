<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:layout2>
  <jsp:attribute name="content">
  <div class="container">
    <h1>Studenten wijzigen</h1>
    <br>
    <form action="editStudent" class="" enctype="multipart/form-data" method="post">
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
            <s:textfield  id="StudentInsertion" style="width: 50%;" class="form-control" name="Student.insertion" type="text" />
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
          <label class="col-2 col-form-label">Kaartnummer</label>
          <div class="col-10">
            <s:textfield id="StudentCardID" style="width: 50%;" class="form-control" name="Student.cardID" type="text" />
          </div>
        </div>
        <s:textfield id="employeeNumber" style="width: 0%; display: none" class="form-control" name="Student.employeeNumber" type="hidden" />
        <div class="form-group row">
          <label class="col-2 col-form-label">Educatieteam</label>
          <div class="col-10">
                <s:select class="form-control" style="width: 50%;" name="teamAbbreviation" list="educationTeams" 
                listKey="abbreviation" listValue="name" value="teamAbbreviation"></s:select>
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