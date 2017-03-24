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
            <div class="row">
                <div class="col-md-12">
                    <h1 style="float: left; margin-right: 5px;">Studenten </h1>
                    <h1 id="lessonGroupName" data-lessongroup-id="<s:property value="lessonGroupId"></s:property>"> <s:property value="name"></s:property></h1>
                </div>

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
            <!-- The properties of a person -->
            <table class="table lesson-groups-table">
                <thead>
                    <tr>
                        <th>
                            <label>
                                <input type="checkbox" id="selectAll">
                            </label>
                        </th>
                        <th>
                            OV-nummer
                        </th>
                        <th>
                            Voornaam
                        </th>
                        <th>
                            Achternaam
                        </th>
                        <th>
                            Cohort
                        </th>
                    </tr>
                </thead>
                <tbody>
                <s:iterator value="students">
                	<tr data-student-ov="<s:property value="studentOV"></s:property>">
                			<td>
                                <label>
                                    <input type="checkbox"
									name="checkbox">
                                </label>
                            </td>
                            
							<td>
                                <s:property value="studentOV"></s:property>
                            </td>
                            <td>
                                <s:property value="firstName"></s:property>
                            </td>
                            <td>
                                <s:property value="insertion"></s:property> <s:property value="lastName"></s:property>
                            </td>
                            <td>
                                <s:property value="cohort"></s:property>
                            </td>
                	</tr>
                </s:iterator>
                </tbody>
            </table>
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

<!-- Add Students Modal -->
<div class="modal fade" id="addStudentsModal" tabindex="-1"
			role="dialog" aria-labelledby="addStudentLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
                <h4 class="modal-title" id="addStudentLabel">Student(en) toevoegen</h4>
            </div>
            <div class="modal-body">
                <div>
                    <h3>Alle studenten</h3>
                        <%-- Alle studenten weergeven behalve degene die al in deze lesgroep zitten --%>
                    <table
								class="table lesson-group-other-students-table">
                        <thead>
                            <tr>
                                <th>
                                    <label>
                                        <input type="checkbox"
												id="selectAllStudentsForLessonGroupCheckbox">
                                    </label>
                                </th>
                                <th>
                                    OV-nummer
                                </th>
                                <th>
                                    Voornaam
                                </th>
                                <th>
                                    Achternaam
                                </th>
                                <th>
                                    Cohort
                                </th>
                            </tr>
                        </thead>
                        <tbody>
							<s:iterator value="additionalStudents">
                				<tr data-additional-student-id="<s:property value="studentOV"></s:property>">
		                			<td>
		                                <label>
		                                    <input type="checkbox"
											name="checkbox">
		                                </label>
		                            </td>
		                            
									<td>
		                                <s:property value="studentOV"></s:property>
		                            </td>
		                            <td>
		                                <s:property value="firstName"></s:property>
		                            </td>
		                            <td>
		                                <s:property value="insertion"></s:property> <s:property value="lastName"></s:property>
		                            </td>
		                            <td>
		                                <s:property value="cohort"></s:property>
		                            </td>
                				</tr>
                			</s:iterator>
                        </tbody>
                    </table>

                </div>

            </div>
            <!-- Button for adding student to a lesson group -->
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
							data-dismiss="modal">Sluiten</button>
                <button type="button" id="addStudentToLessonGroupButton"
							class="btn btn-primary" disabled>Studenten toevoegen</button>
            </div>
        </div>
    </div>
</div>
        <!-- Delete Students Modal -->
<div class="modal fade" id="deleteStudentsModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
                <h4 class="modal-title" id="myModalLabel">Verwijder student(en)</h4>
            </div>
            <div class="modal-body">
                Weet u zeker dat u de geselecteerde studenten wilt verwijderen? 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary"
							data-dismiss="modal">Annuleren</button>
                <button type="button" id="confirmDeleteStudentsInLessonGroupButton" class="btn btn-danger">Verwijderen</button>
            </div>
        </div>
    </div>
</div>
<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


    </jsp:attribute>
</t:layout2>
