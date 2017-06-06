$(document).ready(function (){
//Uncaught Error: Syntax error, unrecognized expression: [name=dojo.searchDate]
	$("#dateButton").on("click", function(){
		if($.trim($("name=dojo.searchDate")) != "" /*&& '^[0-9]*$'.test($.trim($("name=dojo.searchDate")))*/){
			console.log("ingevuld");
		}
	});
	
});