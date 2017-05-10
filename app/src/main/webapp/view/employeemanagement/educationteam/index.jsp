<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<t:layout2>
    <jsp:attribute name="content">
        <div class="container">

            <div class="row">
                <div class="col-sm-12">
                    <h1>Educatieteams
                       
                    <a href="educationTeam/create" class="btn btn-primary pull-right"><i class="fa fa-plus"></i> Nieuw EducationTeam</a>
                    
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Afkorting</th>
                                <th>Naam</th>
                                <th>Acties</th>
                            </tr>
                            <tr>
                            
                            <td><input class="btn btn-primary pull-left" type="checkbox">    AO</td>
                            <td>ApplicatieOntwikkeling</td>
                            <td>                      
                              <a data-toggle="modal" data-target="#deleteConfirmation" class="btn btn-danger align-right"><i class="fa fa-trash"></i></a>
                              <a href="educationTeam/edit" class="btn btn-primary aligh-right"><i class="fa fa-edit"></i></a></td>
                        </thead>
                        <tbody>
                            <s:iterator value="educationTeams">
                                <tr>
                                    <td><s:property value="abbreviation"/></td>
                                    <td><s:property value="name"/></td>
                                    <td style="width: 10%;">
                                        <a href="educationTeam/update" class="btn btn-primary align-right"><i class="fa fa-edit"></i></a>
                                        <a data-toggle="modal" data-target="#deleteConfirmation" class="btn btn-danger align-right"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>

                    </table>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li><a href="#">1</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

        <!-- Modal for Delete Confirmation -->
        <div id="deleteConfirmation" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Verwijderen</h4>
                    </div>
                    <div class="modal-body">
                        <p>Weet u zeker dat u "name goes here" wilt verwijderen?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Annuleren</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Verwijderen</button>
                    </div>
                </div>
            </div>
        </div>

</jsp:attribute>
</t:layout2>
