<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<t:layout2>
    <jsp:attribute name="content">
<h1>Time Registration</h1>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
        <table class="table">
         <div class="dropdown">
 <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Klas
  <span class="caret"></span></button>
       <ul class="dropdown-menu">
             <li><a href="#">Klas 1</a></li>                          
                            </ul>
                        </div>
                    <div class="text-right">
                <button class="btn btn-primary">Add</button>
                <button class="btn btn-primary">Edit</button>
                <button class="btn btn-primary">Delete</button>
            </div>
           <tr>
           <th><th>
           <th>Maandag</th>
           <th>Dinsdag</th>
           <th>Woensdag<th>
           <th>Donderdag<th>
           <th>Vrijdag</th>
           </tr>
 		 <tr><th>8:30	10:10</th></tr>
         <tr><th>10:25	12:05</th></tr>
         <tr><th>12:35	14:15</th></tr>
         <tr><th>14:30	15:35</th></tr>
            </table>
        </div>
    </div>
</div>
            </jsp:attribute>
</t:layout2>
