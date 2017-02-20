<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout2>
    <jsp:attribute name="css">
         <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/coachgroup.css"/>"/>
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

                $(".coach-groups-table tbody td input[type=\"checkbox\"]").change(function () {
                    if (this.checked) {
                        $(this).addClass("selectedCoachGroup");
                    } else {
                        $(this).removeClass("selectedCoachGroup");
                    }


                    var selectedCoachGroup = $(".selectedCoachGroup").length;
                    if (selectedCoachGroup == 0) {
                        $("#deleteButton").attr("disabled", true);
                        
                        $("#editButton").attr("disabled", true);
                    }

                    if (selectedCoachGroup >= 1) {
                        $("#deleteButton").removeAttr("disabled");
                        
                        $("#editButton").removeAttr("disabled");
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
                        data-target="#coachGroupAddModal">Toevoegen
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
                            <h5 class="modal-title" id="coachGroupAddModalLabel">coach groep toevoegen</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form class="addCoachGroupForm" role="form">
                                <div class="form-group">
                                    <label for="coachGroupName-input" class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text" value="" id="coachGroupName-input">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Sluiten</button>
                            <button type="submit" class="btn btn-primary">Toevoegen</button>
                        </div>
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
                        <div class="modal-body">
                            <p>Weet je zeker dat je de les groep ICO41A wilt verwijderen met 123 studenten?</p>
                        </div>
                        <div class="modal-footer">
                        
                        <form id="subscribe-email-form" action="/notifications/subscribe/" method="post">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Sluiten</button>
                            <button type="submit" value= "SUBMIT" class="btn btn-danger">Verwijderen</button>
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>	
            
            <!-- Modal for Editing an Coach group -->
            <div class="modal fade" id="coachGroupEditModal" tabindex="-1" role="dialog"
                 aria-labelledby="coachGroupEditModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="coachGroupEditModalLabel">Les groep verwijderen</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                      <div class="modal-body">
                            <form class="editCoachGroupForm" role="form" action="/notifications/subscribe/" method="post">
                                <div class="form-group">
                                    <label for="coachGroupName-input" class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text" value="" id="coachGroupName-input">
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
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Sluiten</button>
                            <button  type="submit" class="btn btn-danger">Editing</button>
                        </div>
                    </div>
                </div>
            </div>	

            <table class="table coach-groups-table table-responsive">
                <thead>
                    <tr>
                        <th>
                            <label>
                                <input id="selectAllCoachGroups" type="checkbox">
                            </label>
                        </th>
                        <th>Naam</th>
                        <th>Docent</th>
                        
                        <th style="width:100px;">Aantal Studenten</th>
                    </tr>

                </thead>
                <tbody>
                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>

                        <td><a href='moet nog komen'>ICOA41A</a>	</td>
                        <td>Bram	</td>
                        
                        <td> 12</td>
                        
						
                        
                        
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>
						<td><a href='moet nog komen'>ICOA41B</a></td>
                        <td>Rens</td>
                        
                        <td> 12</td>
                        
				
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>
						<td><a href='moet nog komen'>ICOA41C</a></td>
                        <td>Gino</td>
                        
                        <td> 12</td>
                       
					
                        
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>
						<td><a href='moet nog komen'>ICOA41D</a></td>
                        <td>Max</td>
                        
                        <td> 12</td>
                     
						
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>

                        <td><a href='moet nog komen'>ICO89E</td>
                        <td>Kees</td>
                        
                        <td> 12</td>
                        
						
                    </tr>


                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>

                        
                        <td>Piet</td>
                        <td>ICO33A</td>
                        <td><a href='moet nog komen'> 12</a></td>
                        
					
                    </tr>
                </tbody>
            </table>
        </div>

    </jsp:attribute>
</t:layout2>
