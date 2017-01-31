<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout2>
    <jsp:attribute name="content">

        <div class="container">
            <div class="row">
                <div class="col-md-6">Les Groepen</div>
                <div class="col-md-3">
                    <div class="btn btn-success">Create</div>
                </div>
                <div class="col-md-3">
                    <div class="btn btn-danger">Delete</div>
                </div>
            </div>
        </div>

    </jsp:attribute>
</t:layout2>
