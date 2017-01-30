/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * 
 * This initializes the group table on the group management page;
 */
var groupManagement = {
    createTable: function (target) {
        $('#groupTable').DataTable({
            "ajax": {
                "url": "groupJSON",
                "dataSrc": "groups"
            },
            "destroy": true,
            "scrollY": "200px",
            "scrollCollapse": true,
            "order": [[0, "asc"]],
            "columns": [
                {
                    "data": null,
                    "title": "Group name",
                    "render": function (data, type, full, meta) {
                        return '<a href=group?id=' + full.id + '>' + full.name + '</a>';
                    }
                },
                {
                    "data": "null",
                    "title": "Students",
                    "render": function (data, type, full, meta) {
                        return full.students.length;
                    }
                },
                {
                    "data": null,
                    "title": "Operations",
                    "sortable": false,
                    "render": function (data, type, full, meta) {
                        return '<a href="#" data-toggle="modal" data-input-name="groupID" data-input-value=' + full.id + ' data-target="#addModal">Add students</a>' +
                                ' / ' +
                                '<a href=group?action=delete&id=' + full.id + '>Delete</a>';
                    }
                }
            ]
        });
    }
}
$(document).ready(function () {
    groupManagement.createTable();
});