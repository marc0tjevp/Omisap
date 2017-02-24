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
                <button class="btn btn-primary">Verwijderen</button>
              <a href="create.jsp"><button class="btn btn-primary">Nieuw</button></a>  
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>Afkorting</th>
                    <th>Naam</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>AO</td>
                    <td>Applicatie Ontwikkelaar</td>
                    <td><a href="update.jsp">Wijzigen</a></td>
                </tr>
                <tr>
                    <td>SSC</td>
                    <td>Shared Server Center</td>
                    <td><a href="update.jsp">Wijzigen</a></td>
                </tr>
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
