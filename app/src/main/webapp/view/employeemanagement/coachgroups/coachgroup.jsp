<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout2>
	<jsp:attribute name="css">
         <link type="text/css" rel="stylesheet"
			href="<c:url value="/resources/css/coachgroups.css"/>" />
    </jsp:attribute>

	<jsp:attribute name="scripts">
       <script type="text/javascript" src="<c:url value="/resources/js/coachGroup.js"/>"></script>
    </jsp:attribute>
	<jsp:attribute name="content">

        <div class="container" style="width: 70%;">

            <h1>Coach groepen</h1>
            <div class="coachGroupButtons">
                <button class="btn btn-primary" type="button"
					id="addButton" data-toggle="modal"
					data-target="#coachGroupAddModal">Coachgroup Aanmaken
                </button>
                <button class="btn btn-danger" id="deleteButton" type="button" data-toggle="modal"
                        data-target="#coachGroupDeleteModal" disabled>Verwijderen
                </button>
                
                <button class="btn btn-primary" id="editButton" type="button" value="submit" disabled>Wijzigen
                </button>
            </div>

            <!-- Modal for adding an lesson group -->
            <div class="modal fade" id="coachGroupAddModal"
				tabindex="-1" role="dialog"
				aria-labelledby="coachGroupAddModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title"
								id="coachGroupAddModalLabel">Coachgroup Aanmaken</h5>
                            <button type="button" class="close"
								data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form class="addCoachGroup"
							action="addCoachGroup" role="form" method="post">
                          <div class="modal-body">
                            
                                <div class="form-group">
                                <label for="educationTeam-input"
										class="col-2 col-form-label">EducationTeam</label>
                                	<div class="col-10">
                                        
                                        <select class="form-control"
											name="s1" id="educationTeam-input">
                                        <option value="">Select EducationTeam</option>
                                        <s:iterator
												value="educationTeam" var="ed">
                                        
                                        <option value="${ed.id}">${ed.abbreviation} </option>
                                        </s:iterator>
                                        </select>
                                    </div>
                                    
                                   <label for="coachGroupName-input"
										class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
                                        
                                        <s:textfield
											class="form-control" name="coach.name"
											id="coachGroupName-input" />
                                        
                                    </div>
                                    <!-- Adds a Teacher to a coachGroup -->
                                    <label for="coachGroupTeacherName-input" class="col-2 col-form-label">Teacher</label>
                                    <div class="col-10">
     
                                    
                                    <select class="form-control"
											name="s2" id="coachGroupTeacherName-input">
                                        <option value="">Select Teacher</option>
                                        <s:iterator value="teacher" var="ed">
                                        <option value="${ed.employeeNumber}">${ed.abbreviation} </option>
                                        </s:iterator>
                                        </select>
                                    </div>
                                </div>
                            
                        </div>
                        <div class="modal-footer">
                            
                            	<button type="button"
									class="btn btn-secondary" data-dismiss="modal">Annuleren</button>
                            	<input type="submit" value="Toevoegen"
									class="btn btn-primary"><br>
                            
                        </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Modal for deleting an lesson group -->
            <div class="modal fade" id="coachGroupDeleteModal"
				tabindex="-1" role="dialog"
				aria-labelledby="coachGroupDeleteModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title"
								id="coachGroupDeleteModalLabel">Les groep verwijderen</h5>
                            <button type="button" class="close"
								data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
              
                        <div class="modal-body">
                        <p>Weet u zeker dat u deze CoachGroupen wilt verwijderen?</p>
                        </div>
                        <div class="modal-footer"> 
                            <button type="button"
									class="btn btn-secondary" data-dismiss="modal">Annuleren</button>
                            <button type="button" value="Verwijderen"
									class="btn btn-danger" id="deleteButton2">Verwijderen</button>
                           </div> 
                            </div>
                        </div>
                    </div>
                </div>
         
           <!-- Tabel for a CoachGroup -->
            <table class="table coach-groups-table table-responsive">
                <thead>
                    <tr>
                        <th>
                            <label>
                                <input id="selectAllCoachGroups"
							type="checkbox">
                            </label>
                        </th>
                        <th>Naam</th>
                        <th>Docent</th>
                        
                        <th style="width: 200px;">Aantal LessonGroups</th>
                        <th>EducationTeam</th>
                    </tr>

                </thead>
                <tbody>
                <s:iterator value="coachGroup" var="cg">
                    <tr id="${cg.getName()}">
                        <td>
                            <label>
                                 <input id="selectedCoachGroup"
								type="checkbox">
                            </label>
                        </td>
                        <td><a href='CoachLessonGroups'>${cg.getName()}</a>	</td>
                        <td>${cg.getCoach().getAbbreviation()}	</td>
                        <td>${cg.getLessonGroups().size()}</td>
                        <td>
                        	<s:iterator  value="educationTeam" var="ed1">
                        	
                        	<s:set var="flag">${ed1.getCoachGroups().contains(cg)}</s:set>
								<s:if test="#flag">
									<s:property value="#ed1.abbreviation"></s:property>
								</s:if>
							</s:iterator>
                        </td>
                    </tr>        
				</s:iterator>  
				</tbody>  
            </table>
    </jsp:attribute>
</t:layout2>