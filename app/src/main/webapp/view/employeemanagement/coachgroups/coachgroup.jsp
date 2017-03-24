<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout2>
    <jsp:attribute name="css">
         <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/coachgroups.css"/>"/>
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <script>
            $(document).ready(function () {
            	
            	
            	 
                $("#selectAllCoachGroups").on('click', function () {
                    if (this.checked) {
                        // Iterate each checkbox
                        $(':checkbox').each(function () {
                            this.checked = true;
                            $(this).addClass("selectedCoachGroup");
                            $("#deleteButton").removeAttr("disabled");
                            
                            
                           
                        });
                    }
                    else {
                        $(':checkbox').each(function () {
                            this.checked = false;
                            $(this).removeClass("selectedCoachGroup");
                            $("#deleteButton").attr("disabled", true);
                            
            
                        });
                    }
                });
               
                var closestTr = [];
                
                $(".coach-groups-table tbody td input[type=\"checkbox\"]").change(function () {
                	
                    if (this.checked) {
                    	
                    	
                        $(this).addClass("selectedCoachGroup");
        
                        
                        
                    } else {
                        $(this).removeClass("selectedCoachGroup");
                    }
                    
					
                    closestTr = [];
                   
                    $(':checkbox').each(function () {
                    if(this.checked){
                    	closestTr = closestTr + $(this).closest('tr').attr('id');
                    	console.log(closestTr);
                    }
                    });
                   

                    
                    var selectedCoachGroup = $(".selectedCoachGroup").length;
                    if (selectedCoachGroup == 0) {
                        $("#deleteButton").attr("disabled", true);
                        
                        $("#editButton").attr("disabled", true);
                    }

                    if (selectedCoachGroup == 1) {
                        $("#deleteButton").removeAttr("disabled");
                        
                        $("#editButton").removeAttr("disabled");
                    }
                    if(selectedCoachGroup >= 2) {
                        $("#deleteButton").removeAttr("disabled");
                        
                        $("#editButton").attr("disabled", true);
                    }
                    
                   
                });
                
                
                $('#coachGroupDeleteModal').on('show.bs.modal', function(e) {
                   	
                	 
                   
                });
                
                
                $('#coachGroupEditModal').on('show.bs.modal', function(e) {
                	
                	$(e.currentTarget).find('input[name="bookId"]').val();
                    
                });
                
                $('.form-control')
                .dropdown();
               
                
                
                $('select').change(function() {
                    if ($(this).children('option:first-child').is(':selected')) {
                      $(this).addClass('placeholder');
                    } else {
                     $(this).removeClass('placeholder');
                    }
                   });
            });
            
        </script>
    </jsp:attribute>
    <jsp:attribute name="content">

        <div class="container" style="width: 70%;">

            <h1>Coach groepen</h1>
            <div class="coachGroupButtons">
                <button class="btn btn-primary" type="button" id="addButton" data-toggle="modal"
                        data-target="#coachGroupAddModal">Coachgroup Aanmaken
                </button>
                <button class="btn btn-danger" id="deleteButton" type="button" data-toggle="modal"
                        data-target="#coachGroupDeleteModal" disabled>Verwijderen
                </button>
                
                <button class="btn btn-primary" id="editButton" type="button" data-toggle="modal"
                        data-target="#coachGroupEditModal" disabled>Wijzigen
                </button>
            </div>

            <!-- Modal for adding an lesson group -->
            <div class="modal fade" id="coachGroupAddModal" tabindex="-1" role="dialog"
                 aria-labelledby="coachGroupAddModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="coachGroupAddModalLabel">Coachgroup Aanmaken</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form class="addCoachGroup" action="addCoachGroup" role="form" method="post">
                          <div class="modal-body">
                            
                                <div class="form-group">
                                <label for="educationTeam-input" class="col-2 col-form-label">EducationTeam</label>
                                	<div class="col-10">
                                        
                                        <select class="form-control" name="coach.currentEducationTeam" id="educationTeam-input">
                                        <option value="">Select EducationTeam</option>
                                        <s:iterator value="educationTeam" var="ed">
                                        <option value="ed">${ed.abbreviation} </option>
                                        </s:iterator>
                                        </select>
                                    </div>
                                    
                                   <label for="coachGroupName-input" class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
                                        
                                        <s:textfield class="form-control" name="coach.name" id="coachGroupName-input"/>
                                    </div>
                                    <label for="coachGroupTeacherName-input" class="col-2 col-form-label">Teacher</label>
                                    <div class="col-10">
     
                                    
                                    <select class="form-control" name="coach.teacher" id="coachGroupTeacherName-input">
                                        <option value="" >Select Teacher</option>
                                        <s:iterator value="teacher" var="ed">
                                        <option value="ed">${ed.abbreviation} </option>
                                        </s:iterator>
                                        </select>
                                    </div>
                                </div>
                            
                        </div>
                        <div class="modal-footer">
                            
                            	<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuleren</button>
                            	<input  type="submit" value="Toevoegen" class="btn btn-primary" ><br>
                            
                        </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Modal for deleting an lesson group -->
            <div class="modal fade" id="coachGroupDeleteModal" tabindex="-1" role="dialog"
                 aria-labelledby="coachGroupDeleteModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="coachGroupDeleteModalLabel">Les groep verwijderen</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                         <s:form id="deleteCoachGroup" action="deleteCoachGroup" role="form" method="post">
                        <div class="modal-body">
                        <c:forEach var="p" items="${stuff}">
                            <p>Weet u zeker dat u Coach Group ${p.getName} wilt verwijderen van CoachGroup?</p>
                            </c:forEach>
                        </div>
                        <div class="modal-footer">
                        
                        
                       
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuleren</button>
                            <input type="submit" value= "Verwijderen" class="btn btn-danger">
                            </div>
                            </s:form>
                            
                        </div>
                    </div>
                </div>
            </div>	
            
            <!-- Modal for Editing an Coach group -->
            <div class="modal fade" id="coachGroupEditModal" tabindex="-1" role="dialog"
                 aria-labelledby="coachGroupEditModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                    <form id="updateCoachGroup" action="updateCoachGroup" role="form" method="post">
                        <div class="modal-header">
                            <h5 class="modal-title" id="coachGroupEditModalLabel">Coach groep wijzigen</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                      <div class="modal-body">
                            
                                <div class="form-group">
                                    <label for="coachGroupName-input" class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text" value="" id="coachGroupName-input">
                                    </div>
                                    <label for="coachGroupTeacherName-input" class="col-2 col-form-label">EducationTeam</label>
                                    <div class="col-10">
                                        <select class="form-control"   id="coachGroupTeacherName-input">
                                        <option>ICO41A</option>
     									<option>ICO41B</option>
      									<option>ICO41C</option>
      									<option>ICO41D</option>
      									<option>ICO41E</option>
                                    </select>
                                     
                                </div>
                                  
                                    <label for="coachGroupTeacherName-input" class="col-2 col-form-label">Teacher</label>
                                    <div class="col-10">
                                        <select class="form-control"   id="coachGroupTeacherName-input">
                                        <option>Bram</option>
     									<option>Rens</option>
      									<option>Gino</option>
      									<option>Max</option>
      									<option>Piet</option>
                                    </select>
                                     
                                </div>
                                </div>
                           
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuleren</button>
                            <input type="submit" value= "Wijzigen" class="btn btn-danger">
                           
                        </div>
                         </form>
                    </div>
                </div>
            </div>	

            <table class="table coach-groups-table table-responsive" >
                <thead>
                    <tr>
                        <th>
                            <label>
                                <input id="selectAllCoachGroups" type="checkbox">
                            </label>
                        </th>
                        <th>Naam</th>
                        <th>Docent</th>
                        
                        <th style="width:200px;">Aantal LessonGroups</th>
                        <th>EducationTeam</th>
                    </tr>

                </thead>
                <tbody>
                    <tr id="1">
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>

                        <td><a href='CoachLessonGroups'>ICOA41A</a>	</td>
                        <td>Bram	</td>
                        
                        <td> 12</td>
                        <td>ICO42A</td>
                        
						
                        
                        
                    </tr>

                    <tr id="2">
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>
						<td><a href='CoachLessonGroups'>ICOA41B</a></td>
                        <td>Rens</td>
                        
                        <td> 12</td>
                        <td>ICO42A</td>
				
                    </tr>

                    <tr id="3">
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>
						<td><a href='CoachLessonGroups'>ICOA41C</a></td>
                        <td>Gino</td>
                        
                        <td> 12</td>
                       <td>ICO42A</td>
					
                        
                    </tr>

                    <tr id="4">
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>
						<td><a href='CoachLessonGroups'>ICOA41D</a></td>
                        <td>Max</td>
                        
                        <td> 12</td>
                     	<td>ICO42A</td>
						
                    </tr>

                    <tr id="5">
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>

                        <td><a href='CoachLessonGroups'>ICO89E</a></td>
                        <td>Kees</td>
                        
                        <td> 12</td>
                        <td>ICO42A</td>
						
                    </tr>


                    <tr id="6">
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>

                        <td><a href='CoachLessonGroups'>ICO33A </a> </td>
                        <td>Piet</td>
                        <td> 12</td>
                        <td>ICO42A</td>
					
                    </tr>
                </tbody>
            </table>
       

    </jsp:attribute>
</t:layout2>
