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
      <form action="AddStudentWithCSV"
				enctype="multipart/form-data" method="post"
				id="AddStudentWithCSVForm">
          <div class="form-group row">
            <label class="col-2 col-form-label">coachGroupID</label>
            <div class="col-10">
              <s:select class="form-control" style="width: 50%;" name="coachGroupID" list="coachGroups" listKey="id" listValue="name"></s:select>
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
              <s:textfield id="cohort" style="width: 50%;" type="number"
							class="form-control" name="cohort" value="0" />
            </div>
          </div>
          <div class="form-group row">
          <label class="col-2 col-form-label">upload CSV</label>
          <div class="col-10">
          <s:file class="fileUploadbutton" accept="text/csv" name="csvFile" />
          </div>
          </div>
            <div align="left">
              <button type="button" class="btn btn-primary"
						data-toggle="button" aria-pressed="false">
  		   Cancel</button>
              <button type="button" id="submitButton" class="btn btn-primary"
						data-toggle="button" aria-pressed="false">
  		   Add</button>
			</div> 
			</form>
			</div>
  </jsp:attribute>
  <jsp:attribute name="scripts">
  <script type="text/javascript" src="resources/js/importStudent.js"></script>
</jsp:attribute>
</t:layout2>
