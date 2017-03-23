<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout2>
    <jsp:attribute name="css">
         <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/lessongroup.css"/>"/>
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <script>
            var kkeys = [], konami = "38,38,40,40,37,39,37,39,66,65";
            $(document).keydown(function(e) {
                console.log(e.keyCode);
                kkeys.push( e.keyCode );
                if ( kkeys.toString().indexOf( konami ) >= 0 ){
                    $(document).unbind('keydown',arguments.callee);
                    $.getScript('http://www.cornify.com/js/cornify.js',function(){
                        cornify_add();
                        $(document).keydown(cornify_add);
                    });
                }
            });
            $(document).ready(function () {
                $("#selectAllLessonGroups").on('click', function () {
                    if (this.checked) {
                        // Iterate each checkbox
                        $(':checkbox').each(function () {
                            this.checked = true;
                            $(this).addClass("selectedLessonGroup");
                            $("#deleteButton").removeAttr("disabled");
                        });
                    }
                    else {
                        $(':checkbox').each(function () {
                            this.checked = false;
                            $(this).removeClass("selectedLessonGroup");
                            $("#deleteButton").attr("disabled", true);
                        });
                    }
                });

                $(".lesson-groups-table tbody td input[type=\"checkbox\"]").change(function () {
                    if (this.checked) {
                        $(this).addClass("selectedLessonGroup");
                    } else {
                        $(this).removeClass("selectedLessonGroup");
                    }


                    var selectedLessonGroup = $(".selectedLessonGroup");
                    if (selectedLessonGroup.length == 0) {
                        $("#deleteButton").attr("disabled", true);
                    }

                    if (selectedLessonGroup.length >= 1) {
                        $("#deleteButton").removeAttr("disabled");
                    }
                });
                
                $("#addLessonGroupButton").on("click", function() {
                	if($("input[type=text]#lessonGroupName-input").val()) {
                		console.log("Hallo!");
                		console.log($("input[type=text]#lessonGroupName-input").val());
                		 $.ajax({
                		 	type: 'POST',	  
                			url:'lessongroup/add.action',
                		   	dataType: 'json',
               				data : "lessonGroupName="+$("input[type=text]#lessonGroupName-input").val()
                		});
                	}
                	location.reload();
                });
                
                $("#confirmDeleteLessonGroupButton").on("click", function() {
                	
                	$("input[type=checkbox].selectedLessonGroup").each(function() {
                		var parentElement = $(this).parent().parent().parent();
                		var lessonGroupId = parentElement.attr("id");
                		
                		console.log(lessonGroupId);
	               		 $.ajax({
	            		     type: 'POST',	  
	            			 url:"lessongroup/delete",
	            		     dataType: 'json',
	           				 data : "lessonGroupId="+lessonGroupId,
	           				 });
	            		});
            		location.reload();
                }); 


            });
        </script>
        
    </jsp:attribute>
    <jsp:attribute name="content">

        <div class="container" style="width: 85%;">
         
          <!-- Text on top of page -->
            <h1>Les groepen</h1>
            <div class="lessonGroupButtons">
                <button class="btn btn-primary" type="button" id="addButton" data-toggle="modal"
                        data-target="#lessonGroupAddModal">Toevoegen
                <!-- Delete button -->
                </button>
                <button class="btn btn-danger" id="deleteButton" type="button" data-toggle="modal"
                        data-target="#lessonGroupDeleteModal" disabled>Verwijderen
                </button>
            </div>

            <!-- Modal for adding an lesson group -->
            <div class="modal fade" id="lessonGroupAddModal" tabindex="-1" role="dialog"
                 aria-labelledby="lessonGroupAddModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="lessonGroupAddModalLabel">Les groep toevoegen</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form class="addLessonGroupForm" role="form">
                                <div class="form-group">
                                    <label for="lessonGroupName-input" class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text" value="" id="lessonGroupName-input">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Sluiten</button>
                            <button id="addLessonGroupButton" type="button" class="btn btn-primary">Toevoegen</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal for deleting an lesson group -->
            <div class="modal fade" id="lessonGroupDeleteModal" tabindex="-1" role="dialog"
                 aria-labelledby="lessonGroupDeleteModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="lessonGroupDeleteModalLabel">Geseleteerde les groepen verwijderen</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p>Weet je zeker dat je de geselecteerde les groepen wilt verwijderen?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Sluiten</button>
                            <button type="button" id="confirmDeleteLessonGroupButton" class="btn btn-danger">Verwijderen</button>
                        </div>
                    </div>
                </div>
            </div>

            <table class="table lesson-groups-table table-responsive">
                <thead>
                    <tr>
                        <th>
                        <!--For selecting all lesson groups -->
                            <label>
                                <input id="selectAllLessonGroups" type="checkbox">
                            </label>
                        </th>
                        <th>Naam (klik om te openen)</th>
                        <th>Aantal studenten</th>
                    </tr>
               
                </thead>
                <tbody>
                <!-- Every lesson group -->
                    <s:iterator value="lessonGroups">
                    	<tr id="<s:property value="id"></s:property>">
                    		<td>
                    			<label>
                    				<input type="checkbox">
                    			</label>
                    		</td>
                    		
                    		<td>
                   				<a href="/Pasimo/lessongroup/details?lessonGroupId=<s:property value="id"></s:property>">
                   					<s:property value="name"></s:property>
                   				</a>
                    		</td>
                    		
                    		<td>
                    			<s:property value="students.size()"></s:property>
                    		</td>
                    	</tr>
                    </s:iterator>
                </tbody>
                <tbody>
                
                </tbody>
            </table>
        </div>

    </jsp:attribute>
</t:layout2>