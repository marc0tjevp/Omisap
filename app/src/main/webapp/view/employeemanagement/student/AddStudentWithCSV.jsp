<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sx:head />
<t:layout2>
	<jsp:attribute name="content">
    <div class="container">
      <h1>Add Student with CSV</h1>
      <s:bean name="nl.scalda.pasimo.model.employeemanagement.Student" var="student">
      <form action="AddStudentWithCSV" class=""
				enctype="multipart/form-data" method="post"
				id="AddStudentWithCSVForm"></form>
          <div class="form-group row">
            <label class="col-2 col-form-label">coachGroupID</label>
            <div class="col-10">
              <s:textfield id="studentCoachGroupID" style="width: 50%;"
							class="form-control" type="text" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label">lessonGroupID</label>
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
            <div align="left">
              <button type="button" class="btn btn-primary"
						data-toggle="button" aria-pressed="false">
  		   Cancel</button>
              <button type="button" class="btn btn-primary"
						data-toggle="button" aria-pressed="false">
  		   Add</button>
			</div>
			</s:bean>
    </div>
  </jsp:attribute>
</t:layout2>
