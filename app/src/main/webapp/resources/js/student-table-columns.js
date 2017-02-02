/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//default columns for the student table
var columns = [
    {
        "data": null,
        "title": "Photo",
        "width": "3%",
        "orderable": false,
        "render": function (data, type, full, meta) {
            return "<a href=student?action=student&id=" + full.id + "><img style='width:100%' class='person-popover' data-toggle='popover' src=/project/images/" + full.number + ".jpeg></a>";
        }
    },
    {
        "data": "firstName",
        "title": "First name",
        "render": function (data, type, full, meta) {
            return '<a href=student?action=student&id=' + full.id + '>' + full.firstName + '</a>';
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
        "data": "number",
        "title": "Number",
        "class": "number",
        "cellData": "test",
        "createdCell": function (td, cellData, rowData, row, col) {
            $(td).data('id', 'number');
            $(td).data('value', cellData);
        }
    },
    {
        "data": "city",
        "title": "City",
        "createdCell": function (td, cellData, rowData, row, col) {
            $(td).data('id', 'city');
            $(td).data('value', cellData);
        }
    },
//    {
//        "data": "gender",
//        "title": "Gender",
//        "createdCell": function (td, cellData, rowData, row, col) {
//            $(td).data('id', 'gender');
//            $(td).data('value', cellData);
//        }
//    },
//    {
//        "data": "dateOfBirth",
//        "title": "Date of birth",
//        "orderable": false,
//        "createdCell": function (td, cellData, rowData, row, col) {
//            $(td).data('id', 'dateOfBirth');
//            $(td).data('value', cellData);
//        }
//    },
//    {
//        "data": "phone",
//        "title": "phone",
//        "orderable": false,
//        "createdCell": function (td, cellData, rowData, row, col) {
//            $(td).data('id', 'phone');
//            $(td).data('value', cellData);
//        }
//    },
//    {
//        "data": "email",
//        "title": "Email",
//        "createdCell": function (td, cellData, rowData, row, col) {
//            $(td).data('id', 'email');
//            $(td).data('value', cellData);
//        }
//    },
    {
        "data": null,
        "title": "Group",
        "render": function (data, type, full, meta) {
            if (full.group === null) {
                return null;
            }
            return "<p>" + full.group.name + "</p>";
        },
        "createdCell": function (td, cellData, rowData, row, col) {
            $(td).data('id', 'group');
            $(td).data('value', cellData);
        }
    }
];