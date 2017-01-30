/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * 
 * This initializes the group table;
 */
$(document).ready(function () {
    $('#groupTable').DataTable({
        "ajax": {
            "url": "groupJSON",
            "dataSrc": "groups"
        },
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
            }
        ]
    });
});