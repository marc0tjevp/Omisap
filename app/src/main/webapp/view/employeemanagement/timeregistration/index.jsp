

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
                     <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal1">
  Aanmaken
</button>
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;
        </span></button>
              <h4 class="modal-title" id="myModalLabel">Schooltijden aanmaken</h4>
      </div>
      <div class="modal-body">
       <div class="btn-group">
       
       <!-- TODO via struts tijden kiezen in de dropdown -->
       
	      		  <div class="dropdown div-inline">
                     <button class="btn btn-classic dropdown-toggle" type="button" data-toggle="dropdown">Start time
                     <span class="caret"></span></button>
                     <ul class="dropdown-menu">
                        <li><a href="#">Tijd</a></li>
                        <li><a href="#">Tijd</a></li>
                     </ul>
                  </div>
</div>
<!-- TODO via struts tijden kiezen in de dropdown -->
	      		  <div class="dropdown div-inline">
                     <button class="btn btn-classic dropdown-toggle" type="button" data-toggle="dropdown">End time
                     <span class="caret"></span></button>
                     <ul class="dropdown-menu">
                        <li><a href="#">Tijd</a></li>
                        <li><a href="#">Tijd</a></li>
                     </ul>
                  </div>
</div>

      <div class="modal-footer">
        <button type="button" class="btn btn-success ">Toevoegen</button>
      </div>
     
    </div>
  </div>
		</div>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
  Aanpassen
</button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;
        </span></button>
              <h4 class="modal-title" id="myModalLabel">Schooltijden aanpassen</h4>
      </div>
      <div class="modal-body">
       <div class="btn-group">
       
       <!-- TODO via struts tijden kiezen in de dropdown -->
       
	      		  <div class="dropdown div-inline">
                     <button class="btn btn-classic dropdown-toggle" type="button" data-toggle="dropdown">Start time
                     <span class="caret"></span></button>
                     <ul class="dropdown-menu">
                        <li><a href="#">Tijd</a></li>
                        <li><a href="#">Tijd</a></li>
                     </ul>
                  </div>
</div>
<!-- TODO via struts tijden kiezen in de dropdown -->
	      		  <div class="dropdown div-inline">
                     <button class="btn btn-classic dropdown-toggle" type="button" data-toggle="dropdown">End time
                     <span class="caret"></span></button>
                     <ul class="dropdown-menu">
                        <li><a href="#">Tijd</a></li>
                        <li><a href="#">Tijd</a></li>
                     </ul>
                  </div>
</div>

      <div class="modal-footer">
        <button type="button" class="btn btn-success ">Toevoegen</button>
      </div>
    </div>
    </div>
    </div>
    
                     <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal2">
 Verwijder
</button>

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Verwijder een WorkBlock</h4>
      </div>
      <div class="modal-body">
        Weet je zeker dat je zeker dat je dit les block wilt verwijderen?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-succes">Save changes</button>
      </div>
    </div>
  </div>
</div>
                     
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
 <td>
 </td>
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

