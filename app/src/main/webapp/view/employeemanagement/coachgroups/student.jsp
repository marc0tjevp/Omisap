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

            $(".coach-groups-table tbody td input[type=\"checkbox\"]").change(function () {
                if (this.checked) {
                    $(this).addClass("selectedCoachGroup");
                } else {
                    $(this).removeClass("selectedCoachGroup");
                }


                var selectedCoachGroup = $(".selectedCoachGroup").length;
                if (selectedCoachGroup == 0) {
                    $("#deleteButton").attr("disabled", true);
                    
                  
                }

                if (selectedCoachGroup >= 1) {
                    $("#deleteButton").removeAttr("disabled");
                    
                   
                }
            });


        });
        </script>
    </jsp:attribute>
    <jsp:attribute name="content">

        <div class="container" style="width: 85%;">

            <h1>Leerlingen in ICO41A</h1>
            <div class="coachGroupButtons">
                <button class="btn btn-primary" type="button" id="addButton" data-toggle="modal"
                        data-target="#coachGroupAddModal">Toevoegen
                </button>
                <button class="btn btn-danger" id="deleteButton" type="button" data-toggle="modal"
                        data-target="#coachGroupDeleteModal" disabled>Verwijderen
                </button>
            </div>

            <!-- Modal for adding an lesson group -->
            <div class="modal fade" id="coachGroupAddModal" tabindex="-1" role="dialog"
                 aria-labelledby="coachGroupAddModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="coachGroupAddModalLabel">Student toevoegen</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form class="addCoachGroupForm" role="form">
                                <div class="form-group">
                                    <label for="coachGroupName-input" class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text" value="" id="Voornaam">                                    
		                            </div>
		                            	<label for="coachGroupName-input" class="col-2 col-form-label">Achternaam</label>
		                            <div class=col-10 >
		                           		<input class="form-control" type="text" value="" id="Achternaam">
		                            </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuleren</button>
                            <button type="button" class="btn btn-primary">Toevoegen</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal for deleting an student from coachgroup -->
            <div class="modal fade" id="coachGroupDeleteModal" tabindex="-1" role="dialog"
                 aria-labelledby="coachGroupDeleteModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="coachGroupDeleteModalLabel">Student verwijderen from Coachgroup</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p>Weet u zeker dat u student 1234 wilt verwijderen?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuleren</button>
                            <button type="button" class="btn btn-danger">Verwijderen</button>
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
                        <th>Leerling Nummer</th>
                        <th>Leerling Naam</th>
                        
                    </tr>

                </thead>
                <tbody>
                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>

                        <td>1234</td>
                        <td>Leerling naam	</td>
                       
                        <td><a href='moet nog komen'> Notities</a></td>
                
                        
                        
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>
							
						<td>1234</td>	
                        <td>Leerling naam	</td>
                        
                        <td><a href='moet nog komen'> Notities</a></td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>

						<td>1234</td>
                        <td>Leerling naam	</td>
                        
                        <td><a href='moet nog komen'> Notities</a></td>
                        
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>
						<td>1234</td>
                        <td>Leerling naam	</td>
                        
                        <td><a href='moet nog komen'> Notities</a></td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>

                        <td>1234</td>
                        <td>Leerling naam	</td>
                        
                        <td><a href='moet nog komen'> Notities</a></td>
                    </tr>


                    <tr>
                        <td>
                            <label>
                                 <input id="selectedCoachGroup" type="checkbox">
                            </label>
                        </td>

                        <td>1234</td>
                        <td>Leerling naam	</td>
                        
                        <td><a href='moet nog komen'> Notities</a></td>
                    </tr>
                </tbody>
            </table>
        </div>

    </jsp:attribute>
</t:layout2>
