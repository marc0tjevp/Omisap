<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout2>
	<jsp:attribute name="css">
         <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/coachgroups.css"/>" />
			
    </jsp:attribute>
    
<jsp:attribute name="scripts">
 <script type="text/javascript" src="<c:url value="/resources/js/coachGroupEdit.js"/>"></script>
        </jsp:attribute>
	<jsp:attribute name="content">
	                <form id="updateCoachGroup"
						action="/Pasimo/coachGroups/updateCoachGroup" role="form" method="post">
                        
                     
                             <input type="hidden" name="s1" value="${coach.getName()}">
                             
                                <div class="form-group">
                                    <label for="coachGroupName-input"
									class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
										<input class="form-control" value="${coach.getName()}" name="s3" placeholder="${coach.getName()}" id="coachGroupName-input"   />
                                    </div>
                                   </div>
                                   
                                    <label
									for="coachGroupTeacherName-input" class="col-2 col-form-label">Teacher</label>
                                    <div class="col-10">
                                         <select class="form-control" name="s2" id="coachGroupTeacherName-input">
                                        
                                         <option value="${coach.getCoach().employeeNumber}">${coach.getCoach().getAbbreviation()}</option>
                                         
                                        <s:iterator value="teacher" var="ed">
                                        
                                        <s:if test="%{#ed.getEmployeeNumber() != coach.getCoach().getEmployeeNumber() }">
                                        <option value="${ed.employeeNumber}">${ed.abbreviation} </option>
                                        </s:if>
                                        </s:iterator>
                                    </select>
                                     
                                </div>
                                
                                   
                               
                           
                        
                        <div class="modal-footer">
                         <button type="button" value="Annuleren"
									class="btn btn-secondary" id="AnnulerenButton">Annuleren</button>
                            <input type="submit" value="Wijzigen"
								class="btn btn-danger">
                           
                        </div>
                         </form>
                    
                
</jsp:attribute>
</t:layout2>