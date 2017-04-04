<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/base/jquery-ui.css"/>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<t:layout2>
   <jsp:attribute name="content">

<style>
H1 {
    text-align: center;
}
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd ;
    text-align: left;
    padding: 8px;
}

tr:nth-child(odd) {
    background-color: #dddddd ;
}
.aTableAvailability{
    font-weight: bold;
}
</style>

<h1>Aanwezigheid Docenten</h1>
<div class="row">
    <div class="col-md-2 col-lg-2 col-sm-2"></div>
    <div class="col-md-8 col-lg-8 col-sm-8">
        <table>
            <tr>
                <th width="70%">Naam</th>
                <th width="30%">Aanwezigheid</th>
            </tr>
            <tr>
                <td>Bram van Huele</td>
                <td style="color:green" class="aTableAvailability">Aanwezig</td>
            </tr>
            <tr>
                <td>Rens Brandon</td>
                <td style="color:orange" class="aTableAvailability">Niet Bekend</td>
            </tr>
            <tr>
                <td>Cees Schipper</td>
                <td style="color:red" class="aTableAvailability">Afwezig</td>
            </tr>
            <tr>
                <td>Maxim Schoonen</td>
                <td style="color:green" class="aTableAvailability">Aanwezig</td>
            </tr>
            <tr>
                <td>Gino Palo</td>
                <td style="color:green" class="aTableAvailability">Aanwezig</td>
            </tr>
        </table>
    </div>
    <div class="col-md-2 col-lg-2 col-sm-2"></div>
</div>
<div class="row">
</div>


  </jsp:attribute>
</t:layout2>