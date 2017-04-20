<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout2>
	<jsp:attribute name="css">
         <link type="text/css" rel="stylesheet"
			href="<c:url value="/resources/css/lessongroup.css"/>" />
    </jsp:attribute>
	<jsp:attribute name="scripts">
         <script type="text/javascript"
			src="<c:url value="/resources/js/lessonGroupDetails.js"/>"></script>
    </jsp:attribute>
	<jsp:attribute name="content">

        <div class="container" style="width: 85%;">
            <div class="row" style="margin-bottom: 25px;">
                <div class="col-md-12">
                    <h1 style="float: left; margin-right: 5px;">Studenten </h1>
                    <h1 id="lessonGroupName" data-lessongroup-name="<s:property value="lessonGroupName"></s:property>"> <s:property value="lessonGroupName"></s:property></h1>
                	<br>
                </div>
				<h2 style="float: left; margin-right: 5px; margin-left: 15px; margin-top: 0;">Coachgroep </h2>
				<h2 style="float: left; margin-top: 0;" id="lessonGroupCoachGroupName" data-coachgroup-name="<s:property value="coachGroupName"></s:property>"> <s:property value="coachGroupName"></s:property></h2>
            </div>
            
            <div class="row">
                <div class=" col-md-12">
                     <!-- Editing the lesson group name -->
                    <div
						class="lessonGroupButtons lessonGroupNameButton">
                        <button class="btn btn-primary"
							data-toggle="modal" data-target="#editLessonGroupName">
							<i class="fa fa-pencil"></i> Lesgroep naam wijzigen
                        </button>
                    </div>
                    <div class="lessonGroupButtons">
                         <!-- To add students -->
                        <button class="btn btn-success"
							data-toggle="modal" data-target="#addStudentsModal">Studenten
                         <!-- To delete students -->                                                                               toevoegen
                        </button>
                        <button id="deleteStudentButton"
							class="btn btn-danger" data-toggle="modal"
							data-target="#deleteStudentsModal" disabled>Studenten verwijderen
                        </button>
                    </div>
                </div>

            </div>
        </div>

<!-- Edit LessonGroup name Modal -->
<div class="modal fade" id="editLessonGroupName" tabindex="-1"
			role="dialog" aria-labelledby="editLessonGroupNameLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
                <h4 class="modal-title" id="editLessonGroupNameLabel">Wijzig lesgroep naam</h4>
            </div>
            <div class="modal-body">
                <input class="form-control" id="currentLessonGroup">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
							data-dismiss="modal">Close</button>
                <button type="button" id="updateLessonGroupNameButton" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


    </jsp:attribute>
</t:layout2>
