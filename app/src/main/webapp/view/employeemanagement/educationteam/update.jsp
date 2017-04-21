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
                        <h1>Edit EducationTeam</h1>

                        <form action="update">

                            <div class="form-group">
                                <label class="control-label" for="name">Name</label>
                                <input class="form-control" required="true" placeholder="Name" id="name">
                            </div>
                            <div class="form-group">
                                <label>Abbreviation</label>
                                <input class="form-control" required="true" placeholder="Abbreviation" id="abbreviation">

                            </div>

                    
                     <a href="http://localhost:8080/Pasimo/educationTeam" class="btn btn-primary">Annuleren</a>
                     
                      <a href="http://localhost:8080/Pasimo/educationTeam" class="btn btn-primary pull-right">Opslaan</a>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
</t:layout2>
