<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<t:layout2>
    <jsp:attribute name="content">

        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h1>Create educationTeam</h1>
                    <form action="addEducationTeam">

                        <div class="form-group">
                            <label class="control-label" for="name">Name</label>
                            <input class="form-control"
                                   placeholder="Name" name="name" type="text">
                        </div>
                        
                        <div class="form-group">
                            <label>Abbreviation</label>
                            <input class="form-control"
                                   placeholder="Abbreviation" name="abbrevation" type="text">
                        </div>

                        <button type="submit" class="btn btn-primary">Annuleren</button>
                        <button id="addEducationTeam" type="submit"
                                class="btn btn-primary pull-right">Aanmaken</button>
                    </form>
                </div>
            </div>
        </div>

    </jsp:attribute>
</t:layout2>
