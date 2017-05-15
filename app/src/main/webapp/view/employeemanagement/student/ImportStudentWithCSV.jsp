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
            <label class="col-2 col-form-label">coachgroep</label>
            <div class="col-10">
              <s:textfield id="studentCoachGroupID" style="width: 50%;"
							class="form-control" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">lesgroep</label>
            <div class="col-10">
              <s:textfield id="studentlessonGroupID" style="width: 50%;"
							class="form-control" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">cohort</label>
            <div class="col-10">
              <s:textfield id="studentCohort" style="width: 50%;"
							class="form-control" type="text" />
            </div>
          </div>
          <div class="form-group row">
          <label class="col-2 col-form-label">upload CSV</label>
          <div class="col-10">
          <s:file name="importedFile" class="fileUploadbutton"
							accept="text/csv" />
          </div>
          </div>
            <div class="form-group row">
              <button type="button" class="btn btn-primary"
						data-toggle="button" aria-pressed="false">
  		   Annuleren</button>
              <button type="button" class="btn btn-primary"
						data-toggle="button" aria-pressed="false">
  		   Toevoegen</button>
			</div>
      </form>
    </div>
  </jsp:attribute>
</t:layout2>
