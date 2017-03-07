<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<t:layout2>
    <jsp:attribute name="content">
        <h1>Education</h1>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="text-right">
                        <a href="educationTeam/create">  <button class="btn btn-primary"><i class="fa fa-plus"></i> Nieuw EducationTeam</button></a>
                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Afkorting</th>
                                <th>Naam</th>
                                <th>Acties</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="educationTeams">
                                <tr>
                                    <td><s:property value="name"/></td>
                                    <td><s:property value="abbreviation"/></td>
                                    <td style="width: 10%;">
                                        <a href="#" class="btn btn-primary align-right"><i class="fa fa-edit"></i></a>
                                        <a href="#" class="btn btn-primary align-right"><i class="fa fa-trash"></i></a>
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
    </jsp:attribute>
</t:layout2>
