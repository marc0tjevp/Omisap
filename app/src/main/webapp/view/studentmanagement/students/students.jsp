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
    background-color: #66FFFF;
}

</style>
<t:layout2>
	<jsp:attribute name="css">

</jsp:attribute>
	<jsp:attribute name="content">
<h4>Students:</h4>
	<table class="StudentFunctions" align="center">
		<thead>
			<tr>
				<td><button data-toggle="modal" data-target="#addModal">Add</button></td>
            <td><button data-toggle="modal"
							data-target="#editModal">Edit</button></td>
            <td><button data-toggle="modal"
							data-target="#deleteModal">Delete</button></td>
			</tr>
		</thead>
	</table>
<div style="clear: both;"></div>
	<div>

		<table id="studentTable">
			<thead>
				<tr>
					<th>Name</th>
					<th>OV Number</th>
					<th>Cohort</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Student1</td>
					<td>123456</td>
					<td>1010101</td>
				</tr>
				<tr>
					<td>Student2</td>
					<td>234567</td>
					<td>10101</td>
				</tr>
				<tr>
					<td>Student3</td>
					<td>345678</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Student4</td>
					<td>456789</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Student4</td>
					<td>567891</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Student5</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Student6</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Student7</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Student8</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Student9</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>

				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
				<tr>
					<td>Test</td>
					<td>Test</td>
					<td>Test</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="addModal" class="modal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
							data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Student Toevoegen</h4>
                </div>

                <div class="modal-body" student-name="">
                    <p>Name:</p>
                    <div class="NametoGive">
                        <input type="text" class="form-control"
								id="studentName" placeholder="Enter name">
                    </div>
                </div>

                <div class="modal-body" student-OV="">
                    <p>OV Nummer :</p>
                    <div class="OVtoGive">
                        <input type="text" class="form-control"
								id="studentOV" placeholder="Enter OV Nummer">
                    </div>
                </div>

                <div class="modal-body" student-cohort="">
                    <p>Cohort:</p>
                    <div class="CohorttoGive">
                        <input type="text" class="form-control"
								id="studentCohort" placeholder="Enter Cohort">
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
							data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-default"
							data-dismiss="modal">Ok</button>
                </div>
            </div>

        </div>
    </div>


    <div id="editModal" class="modal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
							data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Student Aanpassen</h4>
                </div>

                <div class="modal-body" student-name="">
                    <p>Name:</p>
                    <div class="NametoEdit">
                        <input type="text" class="form-control"
								id="studentEditName" placeholder="Enter name">
                    </div>
                </div>

                <div class="modal-body" student-OV="">
                    <p>OV Nummer :</p>
                    <div class="OVtoEdit">
                        <input type="text" class="form-control"
								id="studentEditOV" placeholder="Enter OV Nummer">
                    </div>
                </div>

                <div class="modal-body" student-cohort="">
                    <p>Cohort:</p>
                    <div class="CohorttoEdit">
                        <input type="text" class="form-control"
								id="studentEditCohort" placeholder="Enter Cohort">
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
							data-dismiss="modal">Close</button>
                    <button type="submit" onclick=""
							class="btn btn-default" data-dismiss="modal">Ok</button>
                </div>
            </div>

        </div>
    </div>

    <div id="deleteModal" class="modal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
							data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Student Verwijderen</h4>
                </div>

                <div>
                    <p>Weer u zeker dat u de student wilt verwijderen?</p>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
							data-dismiss="modal">Close</button>
                    <button type="submit" onclick=""
							class="btn btn-default" data-dismiss="modal">Ok</button>
                </div>
            </div>

        </div>
    </div>
	</jsp:attribute>
	<jsp:attribute name="scripts">
	<script type="text/javascript">
		console.log('testtt');
		$(document).ready(function() {
			
			$('#studentTable').DataTable({
				"scrollY" : true
			});
			
			$('tr').on('click', function () {
                $(this).addClass('highlight').siblings().removeClass('highlight');
            });

		});
	</script>

	</jsp:attribute>
</t:layout2>