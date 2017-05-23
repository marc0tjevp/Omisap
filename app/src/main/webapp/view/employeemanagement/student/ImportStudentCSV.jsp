<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sx:head />
<t:layout2>
	<jsp:attribute name="content">
    <div class="container">
      <h1>Studenten toevoegen met een CSV</h1>
      <br>
      <form action="AddStudentWithCSV" class=""
				enctype="multipart/form-data" method="post"
				id="AddStudentWithCSVForm">
<div class="form-group row">
           <label class="col-2 col-form-label">coachGroup</label>
           <div class="col-10">
             <s:select class="form-control" style="width: 50%;" name="coachGroupName" list="coachGroups" listKey="name" listValue="name"></s:select>
           </div>
         </div>
         <div class="form-group row">
           <label class="col-2 col-form-label">lessonGroupID</label>
           <div class="col-10">
             <s:select class="form-control" style="width: 50%;" name="lessonGroupID" list="lessonGroups" listKey="id" listValue="name"></s:select>
           </div>
         </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">cohort</label>
            <div class="col-10">
              <s:textfield id="studentCohort" name="cohort" style="width: 50%;"
							class="form-control" type="number" />
            </div>
          </div>
          <div class="form-group row">
          <label class="col-2 col-form-label">upload CSV</label>
          <div class="col-10">
          <s:file name="csvFile" class="fileUploadbutton" id="importedFile"
							accept="text/csv" />
          </div>
          </div>
            <div class="form-group row">
              <button type="button" class="btn btn-primary"
						data-toggle="button" aria-pressed="false">
  		   Annuleren</button>
              <button type="submit" class="btn btn-primary" id="submitId"
						data-toggle="button" aria-pressed="false">
  		   Toevoegen</button>
			</div>
      </form>
    </div>
</jsp:attribute>
    <jsp:attribute name="scripts">
  <script type="text/javascript" src="resources/js/student.js"></script>
  </jsp:attribute>
</t:layout2>
