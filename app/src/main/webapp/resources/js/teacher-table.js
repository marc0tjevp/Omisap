/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*$(document).ready(function () {
$(document).ready(function () {
    $('#teacherTable').DataTable({
        "ajax": {
            "url": "teacherJSON",
            "dataSrc": "teachers"
        },
        "order": [[3, "asc"]],
        "columns": columns,
        "createdRow": function (row, teachers, dataIndex) {
            $(row).data('id', teachers['id']);
        }
    });
});*/

//$('table>tbody>tr').click(function(){
//	window.location = "/Pasimo/editTeacherPage?id="+$(this).find('[name=emplnumb]')[0].innerHTML+"fout";
//});

//$('[name=edit]').click(function(){
//	window.location = "/Pasimo/editTeacherPage?id="+$(this).find('[name=emplnumb]')[0].innerHTML;
//});

//$.each($('table>tbody>tr'),function(){
//	$(this).find('a[name=edit]').href = "http://www.google.com"//$.find('[name=emplnumb]')[0].innerHTML
//})
//});

$(function () {
var data = [
    {
        value: 800,
        color:"#0084B0",
        highlight: "#7487B0",
        label: "Aanwezig"
    },
    {
        value: 50,
        color: "#00B09E",
        highlight: "#74B39E",
        label: "geoorloofd afwezig"
    },
    {
        value: 25,
        color: "#0029B0",
        highlight: "#7432B0",
        label: "Ongeoorloofd afwezig"
    }
]
    
var option = {
    responsive: true,
    animationSteps: 1,
    legendTemplate : '<ul>'
        +'<% for (var i=0; i<datasets.length; i++) { %>'
          +'<li>'
          +'<span style=\"background-color:<%=datasets[i].lineColor%>\"></span>'
          +'<% if (datasets[i].label) { %><%= datasets[i].label %><% } %>'
        +'</li>'
      +'<% } %>'
    +'</ul>'
    };
    // Get the context of the canvas element we want to select
    var ctx = document.getElementById("myChart").getContext('2d');
    var myLineChart = new Chart(ctx).Line(data, option); //'Line' defines type of the chart.
    var myPieChart = new Chart(ctx).Pie(data,option);
    $('#legend').append(myLineChart.generateLegend())
});