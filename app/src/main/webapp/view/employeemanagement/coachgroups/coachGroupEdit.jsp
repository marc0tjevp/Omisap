<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout2>
	<jsp:attribute name="css">
         <link type="text/css" rel="stylesheet"
			href="<c:url value="/resources/css/coachgroups.css"/>" />
    </jsp:attribute>
<jsp:attribute name="scripts">
        <script>
        $( window ).on( "load", function() { 
        	
        $("#AnnulerenButton").click(function(e){
        		window.location.replace(window.location.href+"/coachGroup");
        	});
        
        $('.form-control')
        .dropdown();
       
        $('select').change(function() {
            if ($(this).children('option:first-child').is(':selected')) {
              $(this).addClass('placeholder');
            } else {
             $(this).removeClass('placeholder');
            }
           });
    });
        </script>
        </jsp:attribute>
	<jsp:attribute name="content">
	                <form id="updateCoachGroup"
						action="updateCoachGroup" role="form" method="post">
                        <div class="modal-header">
                            <h5 class="modal-title"
								id="coachGroupEditModalLabel">Coach groep wijzigen</h5>
                            <button type="button" class="close"
								data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                     
                             
                                <div class="form-group">
                                    <label for="coachGroupName-input"
									class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
										<input class="form-control" name="coachname" placeholder="${coach.getName()}" id="coachGroupName-input"   />
                                    </div>
                                   
                                    <label
									for="coachGroupEducationTeamName-input" class="col-2 col-form-label">EducationTeam</label>
                                    <div class="col-10">
                                        <select class="form-control" name="s1" id="coachGroupEducationTeamName-input">
                                        
                                        <s:iterator value="EducationTeam" var="ed">
                                      
                                        <option value="${ed.id}">${ed.getAbbreviation()}</option>
                                      
                                        </s:iterator>
                                    </select>
                                     
                                     
                                </div>
                                  
                                    <label
									for="coachGroupTeacherName-input" class="col-2 col-form-label">Teacher</label>
                                    <div class="col-10">
                                         <select class="form-control" name="s2" id="coachGroupTeacherName-input">
                                        
                                         <option value="">${coach.getCoach().getEmployeeNumber()}</option>
                                         
                                        <s:iterator value="teacher" var="ed">
                                        <s:if test="%{#ed.getEmployeeNumber() =! coach.getCoach().getEmployeeNumber() }">
                                        <option value="${ed.employeeNumber}">${ed.abbreviation} </option>
                                        </s:if>
                                        </s:iterator>
                                    </select>
                                     
                                </div>
                                </div>
                           
                        
                        <div class="modal-footer">
                         <button type="button" value="Annuleren"
									class="btn btn-secondary" id="AnnulerenButton>Annuleren</button>
                            <input type="submit" value="Wijzigen"
								class="btn btn-danger">
                           
                        </div>
                         </form>
                    
                
</jsp:attribute>
</t:layout2>