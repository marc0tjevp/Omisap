/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
//    $('.person-table').each(function () {
    var $table = $('.person-table');
    $table.DataTable({
        responsive: true,
        "ajax": {
            "url": $table.data('url'),
            "dataSrc": "students",
            "data": function (d) {
                //Optional extra data for the action class:
                //data-id-input-key contains the name of a variable in the action class
                //data-id-input-value contains the value;
                //example: data-id-input-key = groupID
                //         data-id-input-value = 12345-abcde
                var idKey = $table.data('id-input-key');
                var idValue = $table.data('id-input-value');
                d[idKey] = idValue;
            }
        },
        deferRender: true,
        "order": [[3, "asc"]],
        //columns variable is defined in student-table-columns.js
        "columns": columns,
        "createdRow": function (row, data, dataIndex) {
            $(row).data('id', data['id']);
        },
        "initComplete": function () {
            $('.deleteStudent').on('click', function () {
                var $this = $(this);
                var id = $(this).data('id');
                var data = {};
                data['id'] = id;
                $.ajax({
                    type: "POST",
                    url: "deleteStudent",
                    data: data, // serializes the form's elements.
                    success: function (data) {
                        $this.closest('tr').remove();
                        //TODO: prevent the reload. right now it's there to force a reload when
                        //a note is added via student profile page
                    }
                });
            });
        }
    });
});
