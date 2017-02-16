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
            var kkeys = [], konami = "38,38,40,40,37,39,37,39,66,65";
            $(document).keydown(function(e) {
                console.log(e.keyCode);
                kkeys.push( e.keyCode );
                if ( kkeys.toString().indexOf( konami ) >= 0 ){
                    $(document).unbind('keydown',arguments.callee);
                    $.getScript('http://www.cornify.com/js/cornify.js',function(){
                        cornify_add();
                        $(document).keydown(cornify_add);
                    });
                }
            });
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

                $(".Coach-groups-table tbody td input[type=\"checkbox\"]").change(function () {
                    if (this.checked) {
                        $(this).addClass("selectedCoachGroup");
                    } else {
                        $(this).removeClass("selectedCoachGroup");
                    }


                    var selectedcoachGroup = $(".selectedCoachGroup");
                    if (selectedCoachGroup.length == 0) {
                        $("#deleteButton").attr("disabled", true);
                    }

                    if (selectedCoachGroup.length >= 1) {
                        $("#deleteButton").removeAttr("disabled");
                    }
                });


            });
        </script>
    </jsp:attribute>
    <jsp:attribute name="content">

        <div class="container" style="width: 85%;">

            <h1>Les groepen</h1>
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
                            <button type="button" class="btn btn-primary">Toevoegen</button>
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
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Sluiten</button>
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
                        <th>Docent</th>
                        <th>Naam</th>
                    </tr>

                </thead>
                <tbody>
                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        
                        <td>Bram	</td>
                        <td>ICOA41A	</td>
                        <td><a href='moet nog komen'> Leerlingen inzien</a></td>
                        <td><a href='moet nog komen'> Leerlingen Toegoeven</a></td>
						<td><a href='moet nog komen'> wijzigen</a></td>
                        
                        
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td>Rens</td>
                        <td>ICOA41B</td>
                        <td><a href='moet nog komen'> Leerlingen inzien</a></td>
                        <td><a href='moet nog komen'> Leerlingen Toegoeven</a></td>
						<td><a href='moet nog komen'> wijzigen</a></td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td>Gino</td>
                        <td>ICOA41C</td>
                        <td><a href='moet nog komen'> Leerlingen inzien</a></td>
                        <td><a href='moet nog komen'> Leerlingen Toegoeven</a></td>
						<td><a href='moet nog komen'> wijzigen</a></td>
                        
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td>Max</td>
                        <td>ICOA41D</td>
                        <td><a href='moet nog komen'> Leerlingen inzien</a></td>
                        <td><a href='moet nog komen'> Leerlingen Toegoeven</a></td>
						<td><a href='moet nog komen'> wijzigen</a></td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                       
                        <td>Kees</td>
                        <td>ICO89E</td>
                        <td><a href='moet nog komen'> Leerlingen inzien</a></td>
                        <td><a href='moet nog komen'> Leerlingen Toegoeven</a></td>
						<td><a href='moet nog komen'> wijzigen</a></td>
                    </tr>


                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        
                        <td>Piet</td>
                        <td>ICO33A</td>
                        <td><a href='moet nog komen'> Leerlingen inzien</a></td>
                        <td><a href='moet nog komen'> Leerlingen Toegoeven</a></td>
						<td><a href='moet nog komen'> wijzigen</a></td>
                    </tr>
                </tbody>
            </table>
        </div>

    </jsp:attribute>
</t:layout2>
