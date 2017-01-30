<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout2>
    <jsp:attribute name="css">
         <link rel="stylesheet" href="<c:url value="/resources/css/lessongroup.css"/>"/>
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


                    if ($(".selectedLessonGroup").length == 0) {
                        $("#deleteButton").attr("disabled", true);
                    }

                    if ($(".selectedLessonGroup").length >= 1) {
                        $("#deleteButton").removeAttr("disabled");
                    }
                });


            });
        </script>
    </jsp:attribute>
    <jsp:attribute name="content">

        <div class="container">

            <h1>Lesson groups</h1>
            <div class="lessonGroupButtons">
                <button class="btn btn-default" type="submit">Toevoegen</button>
                <button class="btn btn-default" id="deleteButton" type="submit" disabled>Verwijderen</button>
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
                        <td>92</td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO41A</a></td>
                        <td>92</td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO41A</a></td>
                        <td>92</td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO41A</a></td>
                        <td>92</td>
                    </tr>

                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO41A</a></td>
                        <td>2</td>
                    </tr>


                    <tr>
                        <td>
                            <label>
                                <input type="checkbox">
                            </label>
                        </td>

                        <td><a href="details.jsp">ICO41A</a></td>
                        <td>12</td>
                    </tr>
                </tbody>
            </table>
        </div>

    </jsp:attribute>
</t:layout2>