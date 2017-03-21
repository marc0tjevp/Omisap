<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<style type="text/css">
button {
	text-align: center;
	padding: 10px 60px;
	border-radius: 10px;
}

.highlight {
	background-color: #3c8dbc;
}
</style>
<t:layout2>
	<jsp:attribute name="css">

</jsp:attribute>
	<jsp:attribute name="content">
<h4>Student details:</h4>
	
<div style="clear: both;"></div>
	
	<div>
	<div class="row">
  		<div class="col-xs-12 col-sm-6 col-md-2">
			<img
						src="http://howsmydealing.com/wp-content/uploads/2016/12/cropped-anonymous-icon-270x270.jpg"
						width="150" height="200" alt="Student Picture">
		</div>
 		
 		 <div class="row">
  		<div class="col-xs-12 col-sm-6 col-md-4">
  		<div style="background-color: #FFF" border="black">
			<p> Naam: </p> student(a).getName 
			<p>Ov nummer: </p> student(a).getOvNumber
			<p>Les groep: </p> student(a).getlessonGroup
		</div>
		</div>
  
  
  <div class="col-xs-6 col-md-5">
            <div class="todolist">
             
             <div style="background-color: #FFF">
                <ul id="done-items" class="list-unstyled">
                    <li>12-04: Te laat door bus vertraging. <button
											class="remove-item btn btn-default btn-xs pull-right">
											<span class="glyphicon glyphicon-remove"></span>
										</button></li>
                    <li>15-06: Te laat door bus vertraging. <button
											class="remove-item btn btn-default btn-xs pull-right">
											<span class="glyphicon glyphicon-remove"></span>
										</button></li>
					<li>13-07: Afwezig vanwege ziekte. <button
											class="remove-item btn btn-default btn-xs pull-right">
											<span class="glyphicon glyphicon-remove"></span>
										</button></li>                
                	<li>14-07: Afwezig vanwege ziekte. <button
											class="remove-item btn btn-default btn-xs pull-right">
											<span class="glyphicon glyphicon-remove"></span>
										</button></li>
                	<li>12-08: Autopech en hierdoor te laat. <button
											class="remove-item btn btn-default btn-xs pull-right">
											<span class="glyphicon glyphicon-remove"></span>
										</button></li>
                	<li>01-09: Te laat door bus vertraging. <button
											class="remove-item btn btn-default btn-xs pull-right">
											<span class="glyphicon glyphicon-remove"></span>
										</button></li>
                	<li>02-04: Te laat door bus vertraging. <button
											class="remove-item btn btn-default btn-xs pull-right">
											<span class="glyphicon glyphicon-remove"></span>
										</button></li>
                	<li>20-12: Door wekken heen geslapen. <button
											class="remove-item btn btn-default btn-xs pull-right">
											<span class="glyphicon glyphicon-remove"></span>
										</button></li>
                	
                </ul>
            </div>
            </div>
        </div>
</div>
</div>
	
	
<div class="row">

  		<div class="col-xs-12 col-sm-6 col-md-5">
  		<div style="background-color: #FFF">
			
			<h4>Incheck tijden</h4>           
  <table class="table">
    <thead>
      <tr>
        <th>In/uit:</th>
        <th>tijd:</th>
        
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>In</td>
        <td>12:32</td> 
      </tr>
      <tr>
        <td>Uit</td>
        <td>14:56</td>
      </tr>
      <tr>
        <td>In</td>
        <td>12:35</td>
      </tr>
    </tbody>
  </table>
			
		</div>
		</div>
	
	
	
	
	



		<img src="http://matplotlib.org/1.5.0/mpl_examples/pie_and_polar_charts/pie_demo_features_00.hires.png"
		width="400" height="200" alt="Student Picture">
	
	</div>
	
	
	
	
	

    
    
	</div>
	</jsp:attribute>
</t:layout2>