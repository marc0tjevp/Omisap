<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/layout.jsp"%>
<h1>Docent wijzigen</h1><br>
 <form action="addTeacher" class="" enctype="multipart/form-data" method="post">
 <s:bean name="nl.scalda.pasimo.model.Teacher" var="teacher">
<div class="form-group row">
  <label class="col-2 col-form-label">Voornaam</label>
  <div class="col-10">
        <s:textfield id="teacherFirstName" style="width: 50%;" class="form-control" name="teacher.firstName" type="text"/>
  </div>
</div>
<div class="form-group row">
  <label class="col-2 col-form-label">Tussenvoegsel</label>
  <div class="col-10">
        <s:textfield id="teacherInsertion" style="width: 50%;" class="form-control" name="teacher.insertion" type="text"/>
  </div>
</div>
<div class="form-group row">
  <label class="col-2 col-form-label">Achternaam</label>
  <div class="col-10">
        <s:textfield id="teacherLastName" style="width: 50%;" class="form-control" name="teacher.lastName" type="text"/>
  </div>
</div>
<div class="form-group row">
  <label class="col-2 col-form-label">Email</label>
  <div class="col-10">
        <s:textfield id="teacherEmail" style="width: 50%;" class="form-control" name="teacher.email" type="text"/>
  </div>
</div>
<div class="form-group row">
  <label class="col-2 col-form-label">Kaartnummer</label>
  <div class="col-10">
        <s:textfield id="teacherCardID" style="width: 50%;" class="form-control" name="teacher.cardID" type="text"/>
  </div>
</div>
<div class="form-group row">
  <label class="col-2 col-form-label">Werknemersnummer</label>
  <div class="col-10">
        <s:textfield id="teacherEmployeeNumber" style="width: 50%;" class="form-control" name="teacher.employeeNumber" type="text"/><br>
  </div>
</div>
<div class="form-group row">
  <label class="col-2 col-form-label">Educatieteam</label>
  <div class="col-10">
  Hier komt een s:select met de educatieteams
	<br><br>
  	    <input type="submit" value="Toevoegen" class="btn btn-primary" id="submitId"/>
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

<%@include file="../includes/footer.jsp"%></html>