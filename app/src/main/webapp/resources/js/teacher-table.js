/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
});