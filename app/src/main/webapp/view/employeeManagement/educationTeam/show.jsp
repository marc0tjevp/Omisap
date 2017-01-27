<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%><%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<h1>EducationTeam</h1>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <table>     
                <thead>
                <th class="paddingLeft">name</th>
                <br> 
                <th class="paddingLeft">abbrevation</th> 
                </thead>
                
                <tbody>
                    <s:iterator value="educationTeams">
                        <tr>
                            <td class=""><s:property value="abbrevation" /></td>
                            <td class=""><s:property value="name" /></td>
                  
                            
                        </tr>    
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>