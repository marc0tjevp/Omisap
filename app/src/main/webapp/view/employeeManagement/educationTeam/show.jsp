<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<t:layout2>
    <jsp:attribute name="content">
        <h1>EducationTeam</h1>
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <table>
                    <thead>
                    <tr>
                        <th>name</th>

                        <th>abbrevation</th>
                    </tr>
                    </thead>

                    <tbody>

                    <tr>
                        <td class=""><s:property value="abbrevation"/></td>
                        <td class=""><s:property value="name"/></td>


                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </jsp:attribute>
</t:layout2>