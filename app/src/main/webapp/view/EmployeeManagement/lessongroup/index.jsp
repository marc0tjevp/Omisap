<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout2>
    <jsp:attribute name="css">
         <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/lessongroup.css"/>"/>
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <script>
            $(document).ready(function () {


                $(".lesson-groups-table tbody td input[type=\"checkbox\"]").change(function () {
                    if (this.checked) {
                        $(this).addClass("selectedLessonGroup");
                    } else {
                        $(this).removeClass("selectedLessonGroup");
                    }


                    var selectedLessonGroup = $(".selectedLessonGroup");
                    if (selectedLessonGroup.length == 0) {
                        $("#deleteButton").attr("disabled", true);
                    }

                    if (selectedLessonGroup.length >= 1) {
                        $("#deleteButton").removeAttr("disabled");
                    }
                });


            });
        </script>
    </jsp:attribute>
    <jsp:attribute name="content">

        <div class="container">

            <h1>Les groepen</h1>
            <div class="lessonGroupButtons">
                <button class="btn btn-primary" type="button" id="addButton" data-toggle="modal"
                        data-target="#lessonGroupAddModal">Toevoegen
                </button>
                <button class="btn btn-danger" id="deleteButton" type="button" data-toggle="modal" data-target="#lessonGroupDeleteModal" disabled>Verwijderen</button>
            </div>

            <!-- Modal for adding an lesson group -->
            <div class="modal fade" id="lessonGroupAddModal" tabindex="-1" role="dialog"
                 aria-labelledby="lessonGroupAddModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="lessonGroupAddModalLabel">Les groep toevoegen</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form class="addLessonGroupForm" role="form">
                                <div class="form-group">
                                    <label for="lessonGroupName-input" class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text" value="" id="lessonGroupName-input">
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
            <div class="modal fade" id="lessonGroupDeleteModal" tabindex="-1" role="dialog"
                 aria-labelledby="lessonGroupDeleteModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="lessonGroupDeleteModalLabel">Les groep verwijderen</h5>
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

            <table class="table lesson-groups-table">
                <thead>
                    <tr>
                        <th>
                            <label>
                                <input type="checkbox" disabled readonly>
                            </label>
                        </th>
                        <th>Naam (klik om te openen)</th>
                        <th>Aantal studenten</th>
                    </tr>

                </thead>
                <tbody>
                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO41A</a></td>
                        <td>3</td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO41B</a></td>
                        <td>8</td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO45E</a></td>
                        <td>16</td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO56T</a></td>
                        <td>42</td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO89E</a></td>
                        <td>2</td>
                    </tr>


                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO33A</a></td>
                        <td>12</td>
                    </tr>
                </tbody>
            </table>
        </div>

    </jsp:attribute>
</t:layout2>