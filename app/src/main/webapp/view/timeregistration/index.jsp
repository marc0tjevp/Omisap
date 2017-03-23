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
	   .div-inline{
	    display:inline-block;
	}
   </style>
           <style>
            #popup{
                display: none;
                border: 1px solid black;
            }

            .cell-which-triggers-popup{
                cursor: pointer;    
            }

            .cell-which-triggers-popup:hover{
                background-color: #6BBAAB;    
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
        <div class="btn-group">
       <!-- TODO via struts tijden kiezen in de dropdown -->
       <label>Start Time</label>
<input type="text" name="time" list="Starttime1"/>
<datalist id="Starttime1">
   		<option>8:30</option>
        <option>09:00</option>
        <option>09:30</option>
        <option>10:00</option>
        <option>10:30</option>
        <option>11:00</option>
        <option>11:30</option>
        <option>12:00</option>
        <option>12:30</option>
        <option>13:00</option>
        <option>13:30</option>
        <option>14:00</option>
        <option>14:30</option>
        <option>15:00</option>
        <option>15:30</option>
        <option>16:00</option>
        <option>16:30</option>
</datalist>
</div>
<!-- TODO via struts tijden kiezen in de dropdown -->
   
      <label>End Time</label>
      <input type="text" name="time" list="Starttime2"/>
      <datalist id="Starttime2">
        <option>08:30</option>
        <option>09:00</option>
        <option>09:30</option>
        <option>10:00</option>
        <option>10:30</option>
        <option>11:00</option>
        <option>11:30</option>
        <option>12:00</option>
        <option>12:30</option>
        <option>13:00</option>
        <option>13:30</option>
        <option>14:00</option>
        <option>14:30</option>
        <option>15:00</option>
        <option>15:30</option>
        <option>16:00</option>
        <option>16:30</option>
      </datalist>
      </div>

    <div class="form-group">
      <label for="sel3">Day</label>
      <select class="form-control" id="sel3">
        <option>Maandag</option>
        <option>Dinsdag</option>
        <option>Woensdag</option>
        <option>Donderdag</option>
        <option>Vrijdag</option>
      </select>
      </div>
</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success ">Toevoegen</button>
      </div>
     
    </div>
  </div>
		</div>
<!--  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
  Aanpassen
</button>-->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;
        </span></button>
              <h4 class="modal-title" id="myModalLabel">Schooltijden aanpassen</h4>
      </div>
      <div class="modal-body">
       <div class="btn-group">
       <div class="btn-group">
       
       <!-- TODO via struts tijden kiezen in de dropdown -->
      <label>Start Time</label>
      <input type="text" name="time" list="Starttime3"/>
      <datalist id="Starttime3">
        <option>08:30</option>
        <option>09:00</option>
        <option>09:30</option>
        <option>10:00</option>
        <option>10:30</option>
        <option>11:00</option>
        <option>11:30</option>
        <option>12:00</option>
        <option>12:30</option>
        <option>13:00</option>
        <option>13:30</option>
        <option>14:00</option>
        <option>14:30</option>
        <option>15:00</option>
        <option>15:30</option>
        <option>16:00</option>
        <option>16:30</option>
      </datalist>
      </div>


<!-- TODO via struts tijden kiezen in de dropdown -->
      <label>End Time</label>
      <input type="text" name="time" list="Starttime4"/>
      <datalist id="Starttime4">
        <option>08:30</option>
        <option>09:00</option>
        <option>09:30</option>
        <option>10:00</option>
        <option>10:30</option>
        <option>11:00</option>
        <option>11:30</option>
        <option>12:00</option>
        <option>12:30</option>
        <option>13:00</option>
        <option>13:30</option>
        <option>14:00</option>
        <option>14:30</option>
        <option>15:00</option>
        <option>15:30</option>
        <option>16:00</option>
        <option>16:30</option>
      </datalist>
      </div>

    <div class="form-group">
      <label for="sel6">Day</label>
      <select class="form-control" id="sel6">
        <option>Maandag</option>
        <option>Dinsdag</option>
        <option>Woensdag</option>
        <option>Donderdag</option>
        <option>Vrijdag</option>
      </select>
      </div>
</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success ">Aanpassen</button>
         
             <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal2">
 Verwijder
</button>
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
               <table class="table table-bordered">
    <thead>
      <tr>
        <th>Maandag</th>
        <th>Dinsdag</th>
        <th>Woensdag</th>
        <th>Donderdag</th>
        <th>Vrijdag</th>
      </tr>
    </thead>
<tbody>
                  <tr>
         
                <td        
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
                <div class="well well-sm">8:30 10:10</div>
                </td>
                                                        <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">8:30	10:10</div>
                     </td>
                                                        <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">8:30	10:10</div>
                     </td>
                                                                             <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">8:30	10:10</div>
                     </td>
                                                                             <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">8:30	10:10</div>
                     </td>
                  </tr>
                  <tr>
                                   <td
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">10:25  12:05</div>
                     </td>
                                                        <td 
              class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">10:25  12:05</div>
                     </td>
                                                        <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">10:25  12:05</div>
                     </td>
                                                        <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">10:25  12:05</div>
                     </td>
                                                        <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">10:25  12:05</div>
                     </td>
                     
                  </tr>
     <tr>
                                   <td 
               class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">12:35	14:15</div>
                     </td>
                                                       <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">12:35	14:15</div>
                     </td>
                                                        <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">12:35	14:15</div>
                     </td>
                                                                             <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">12:35	14:15</div>
                     </td>
                                                                      <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">12:35	14:15</div>
                     </td>
                  </tr>
                  <tr>
                                   <td 
               class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">14:30	15:35</div>
                     </td>
                                                        <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">14:30	15:35</div>
                     </td>
                                                        <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">14:30	15:35</div>
                     </td>
                                                        <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">14:30	15:35</div>
                     </td>
                                                        <td 
                class="cell-which-triggers-popup" data-toggle="modal" data-target="#editModal">
	                     <div class="well well-sm">14:30	15:35</div>
                     </td>
                  </tr>
                  
                  </tbody>                  
               </table>
            </div>
         </div>
      </div>
      
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
		        <button type="button" class="btn btn-">Verwijder</button>
		      </div>
		    </div>
		  </div>
		</div>
      
      <style>
		.table tbody tr:hover 
		{
		  background-color: transparent;
		}
      </style>
   </jsp:attribute>
</t:layout2>
 	
