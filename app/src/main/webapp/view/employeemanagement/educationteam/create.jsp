<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<t:layout2>
    <jsp:attribute name="content">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h1>Nieuw Educatieteam</h1>

                    <form action="addEducationTeam">

                        <div class="form-group">
                            <label class="control-label" for="name">Naam</label>
                            <input class="form-control" placeholder="Name" id="name">
                        </div>
                        <div class="form-group">
                            <label>Afkorting</label>
                            <input class="form-control" placeholder="Abbrevation" id="abbrevation">

                        </div>

                        <button href="educationTeam" class="btn btn-primary">Annuleren</button>

                        <button type="submit" class="btn btn-primary pull-right">Aanmaken</button>

                    </form>

                </div>
            </div>
        </div>
    </jsp:attribute>
</t:layout2>
