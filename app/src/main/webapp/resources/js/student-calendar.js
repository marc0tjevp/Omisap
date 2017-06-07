$(document).ready(function (){
	$("name='searchDate'").on("change", function(event){
		event.preventDefault();
			console.log($("input[name*='searchDate']").val());
			document.forms["searchDate"].submit();

	});
	
});