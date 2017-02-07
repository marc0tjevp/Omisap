/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var columns = [
    {
        "data": null,
        "title": "Photo",
        "width": "3%",
        "orderable": false,
        "render": function (data, type, full, meta) {
            return "<img style='width:100%' class='person-popover' data-toggle='popover' src=/project/images/" + full.abbreviation + ".jpeg>";
        }
    },
    {
        "data": "firstName",
        "title": "First name",
        "render": function (data, type, full, meta) {
            return '<a href=teacher?action=teacher&id=' + full.id + '>' + full.firstName + '</a>';
        },
        "createdCell": function (td, cellData, rowData, row, col) {
            $(td).data('id', 'firstName');
            $(td).data('value', cellData);
        }
    },
    {
        "data": "insertion",
        "title": "Insertion",
        "orderable": false,
        "createdCell": function (td, cellData, rowData, row, col) {
            $(td).data('id', 'insertion');
            $(td).data('value', cellData);
        }
    },
    {
        "data": "lastName",
        "title": "Last name",
        "createdCell": function (td, cellData, rowData, row, col) {
            $(td).data('id', 'lastName');
            $(td).data('value', cellData);
        }
    },
    {
        "data": "email",
        "title": "email",
        "createdCell": function (td, cellData, rowData, row, col) {
            $(td).data('id', 'email');
            $(td).data('value', cellData);
        }
    },
    {
        "data": "abbreviation",
        "title": "Abbreviation",
        "createdCell": function (td, cellData, rowData, row, col) {
            $(td).data('id', 'abbreviation');
            $(td).data('value', cellData);
        }
    },
    {
        "data": "function",
        "title": "Function",
        "createdCell": function (td, cellData, rowData, row, col) {
            $(td).data('id', 'function');
            $(td).data('value', cellData);
        }
    }
]