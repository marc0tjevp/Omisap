<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<t:layout2>
    <jsp:attribute name="content">

        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div>
                        <h1>Edit educationTeam</h1>

                        <form action="editEducationTeam">

                            <div class="form-group">
                                <label class="control-label" for="name">Name</label>
                                <input class="form-control" required="true" placeholder="Name" id="name">
                            </div>
                            <div class="form-group">
                                <label>Abbrevation</label>
                                <input class="form-control" required="true" placeholder="Abbrevation" id="abbrevation">

                            </div>

                            <a href="../educationTeam" class="btn btn-primary">Annuleren</a>

                            <button type="submit" class="btn btn-primary pull-right">Opslaan</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
</t:layout2>
