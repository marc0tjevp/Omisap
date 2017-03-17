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
            $("#selectAllLessonGroups").on('click', function () {
                if (this.checked) {
                    // Iterate each checkbox
                    $(':checkbox').each(function () {
                        this.checked = true;
                        $(this).addClass("selectedLessonGroup");
                        $("#deleteButton").removeAttr("disabled");
                        
                      
                    });
                }
                else {
                    $(':checkbox').each(function () {
                        this.checked = false;
                        $(this).removeClass("selectedLessonGroup");
                        $("#deleteButton").attr("disabled", true);
                        
        
                    });
                }
            });

            
            
            
            
            var closestTr = [];
            $(".lesson-groups-table tbody td input[type=\"checkbox\"]").change(function () {
                if (this.checked) {
                    $(this).addClass("selectedLessonGroup");
                } else {
                    $(this).removeClass("selectedLessonGroup");
                }

                closestTr = [];
                
                $(':checkbox').each(function () {
                if(this.checked){
                	closestTr = closestTr + $(this).closest('tr').attr('id');
                	console.log(closestTr);
                }
                });

                var selectedLessonGroup = $(".selectedLessonGroup").length;
                if (selectedLessonGroup == 0) {
                    $("#deleteButton").attr("disabled", true);
                    
                  
                }

                if (selectedLessonGroup >= 1) {
                    $("#deleteButton").removeAttr("disabled");
                    
                   
                }
            });


        });
        </script>
    </jsp:attribute>
    <jsp:attribute name="content">

        <div class="container" style="width: 85%;">

            <h1>Lesson Groups in ICO41A</h1>
            <div class="lessonGroupButtons">
                <button class="btn btn-primary" type="button" id="addButton" data-toggle="modal"
                        data-target="#lessonGroupAddModal">Toevoegen
                </button>
                <button class="btn btn-danger" id="deleteButton" type="button" data-toggle="modal"
                        data-target="#lessonGroupDeleteModal" disabled>Verwijderen
                </button>
            </div>

            <!-- Modal for adding an lesson group -->
            <div class="modal fade" id="lessonGroupAddModal" tabindex="-1" role="dialog"
                 aria-labelledby="lessonGroupAddModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="lessonGroupAddModalLabel">LessonGroup toevoegen</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                          <form action="addLessonGroup"class="addLessonGroupForm" role="form">
                        
                        <div class="modal-body">
                                                          <div class="form-group">
                                    <label for="lessonGroupName-input" class="col-2 col-form-label">Name</label>
                                    <div class="col-10">
                                        <select class="form-control"   id="LessonGroupName-input">
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
                            <button type="button" class="btn btn-primary" >Toevoegen</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Modal for deleting an lessonGroup from  a coachgroup -->
            <div class="modal fade" id="lessonGroupDeleteModal" tabindex="-1" role="dialog"
                 aria-labelledby="lessonGroupDeleteModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="coachGroupDeleteModalLabel">LessonGroup verwijderen from Coachgroup</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                         <form action="addLessonGroup"class="addLessonGroupForm" role="form">
                        <div class="modal-body">
                            <p>Weet u zeker dat u Lesson Group 1234 wilt verwijderen van CoachGroup?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuleren</button>
                            <button type="button" class="btn btn-danger">Verwijderen</button>
                        </div>
                       </form>
                    </div>
                </div>
            </div>	

            <table class="table lesson-groups-table table-responsive">
                <thead>
                    <tr>
                        <th>
                            <label>
                                <input id="selectAllLessonGroups" type="checkbox">
                            </label>
                        </th>
                        <th>LessonGroup Name</th>
                        <th>Aantal studenten</th>
                        
                    </tr>

                </thead>
                <tbody>
                    <tr>
                        <td>
                            <label>
                                 <input id="selectedLessonGroup" type="checkbox">
                            </label>
                        </td>

                        <td>1234</td>
                        <td>24</td>
                
                        
                        
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedLessonGroup" type="checkbox">
                            </label>
                        </td>
							
						<td>1234</td>	
                        <td>24</td>
                        
                       
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedLessonGroup" type="checkbox">
                            </label>
                        </td>

						<td>1234</td>
                        <td>24</td>
                        
                        
                        
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedLessonGroup" type="checkbox">
                            </label>
                        </td>
						<td>1234</td>
                        <td>24</td>
                        
                        
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedLessonGroup" type="checkbox">
                            </label>
                        </td>

                        <td>1234</td>
                        <td>24	</td>
                        
                       
                    </tr>


                    <tr>
                        <td>
                            <label>
                                 <input id="selectedLessonGroup" type="checkbox">
                            </label>
                        </td>

                        <td>1234</td>
                        <td>24</td>
                        
                    </tr>
                </tbody>
            </table>
        </div>

    </jsp:attribute>
</t:layout2>
