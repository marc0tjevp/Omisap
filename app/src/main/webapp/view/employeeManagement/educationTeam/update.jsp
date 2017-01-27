<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%><%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<h1>Edit educationTeam</h1>
<div class="container">
    <div class="row">
        <div class="col-sm-12">

            <div>
                <s:bean name="nl.scalda.pasimo.model.employeeManagement.educationTeam" var="educationTeam">
                        <s:textfield type="hidden" id="name" name="name"/>
                        <s:textfield type="hidden" id="abbrevation" name="abbrevation"/>
                        
                        <div class="">
                            <label>name</label>
                            <s:textfield id="name" name="name"/>
                        </div>
                        <div class="">
                            <label>abbrevation</label>
                            <s:textfield id="abbrevation" name="name"/>
                        </div>
                </s:bean>
                </div>
            </div>
        </div>
    </div>