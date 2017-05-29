<%@page contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout2>
    <jsp:attribute name="content">
        <h1>Student!</h1>
        <a href="importStudent">Student toevoegen met een CSV</a>
    </jsp:attribute>
</t:layout2>