

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<t:layout2>
   <jsp:attribute name="content">
   <style>
	   .div-inline{
	    display:inline-block;
	}
   </style>
      <h1>Time Registration</h1>
      <div class="container">
	      <div class="col-sm-12">
	                        <div class="div-inline">
                     <button class="btn btn-primary">Add</button>
                     <button class="btn btn-primary">Edit</button>
                     <button class="btn btn-primary">Delete</button>
                  </div>
	      		  <div class="dropdown div-inline">
                     <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Klas
                     <span class="caret"></span></button>
                     <ul class="dropdown-menu">
                        <li><a href="#">Klas 1</a></li>
                        <li><a href="#">Klas 2</a></li>
                     </ul>
                  </div>
                  <div class="dropdown div-inline">
                     <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Opleiding
                     <span class="caret"></span></button>
                     <ul class="dropdown-menu">
                        <li><a href="#">Opleiding 1</a></li>
                        <li><a href="#">Opleiding 2</a></li>
                     </ul>
                  </div>
	      </div>
      
         <div class="row">
            <div class="col-sm-12">
               <table class="table">
               <thead>
                  <tr>
                     <th></th>
                     <th>Maandag</th>
                     <th>Dinsdag</th>
                     <th>Woensdag<th>
                     <th>Donderdag<th>
                     <th>Vrijdag</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                     <td>8:30	10:10</td>
                     <td>
	                     <div class="well">
	                     </div>
                     </td>
                  </tr>
                  <tr>
                     <td>10:25	12:05</td>
                     <td>
	                     <div class="well">
	                     </div>
                     </td>
                  </tr>
                  <tr>
                     <td>12:35	14:15</td>
                     <td>
	                     <div class="well">
	                     </div>
                     </td>
                  </tr>
                  <tr>
                     <td>14:30	15:35</td>
                     <td>
	                     <div class="well">
	                     </div>
                     </td>
                  </tr>
                  </tbody>
               </table>
            </div>
         </div>
      </div>
   </jsp:attribute>
</t:layout2>

