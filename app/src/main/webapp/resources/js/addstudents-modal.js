/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    initAddModal();
});
function createStudentTag($modal, name, number) {
    var $li = $('<li data-number="' + number + '" class="student-tag"><span class="student-name">' + name + '</span><span class="tag-remove">×</span></li>');
    $modal.find('.studentNumbers').append($li);
    $li.find('.tag-remove').on('click', function () {
        $li.remove();
        $("input[type=checkbox][data-number=" + number + "]").prop('checked', false);
    });
}

function initStudentsFormSubmit(callback, $form) {
    var $modal = $form.closest('.modal');
    $form.off('submit').on("submit", function (e) {
        e.preventDefault();
        //no students selected so return
        if ($('.student-tag').length === 0) {
            return;
        }

        $('.student-tag').each(function () {
            var studentNumber = $(this).data('number');
            var input = $("<input>")
                    .attr("type", "hidden")
                    .attr("name", "studentNumbers").val(studentNumber);
            $form.append($(input));
        });
        //show loaders
        $('.fa-cog').removeClass('hide');
        $('.savebtn').addClass('disabled');

        $.ajax({
            type: "POST",
            url: $form.attr('action'),
            data: $form.serialize(), // serializes the form's elements.
            success: function (data) {
                $modal.modal('hide');
                switch (callback) {
                    case "group":
                        groupManagement.createTable(".person-table");
                        break;
                    case "course":
                        location.reload();
                        break;
                    case "teacher":
                        studentTableMinimal.createTable(".person-table");
                        break;
                }
                removeLoaders();
                removeSelectedStudents($modal);
            }
        });
    });
}

//remove the checked(selected) students from the modal
function removeSelectedStudents($modal) {
    $modal.find('.chkAddStudent').each(function () {
        var $this = $(this);
        $this.prop('checked', false);
        $this.trigger('change');
    });
}

//init table in modal
function initTargetTable($target) {
    var $modal = $target.closest('.modal');
    $target.DataTable({
        "ajax": {
            "url": $target.data('url'),
            "dataSrc": "students"
        },
        "destroy": true, //<--- here
        "deferRender": true,
        "scrollCollapse": true,
        "bInfo": false,
        "order": [[2, "asc"]],
        "columns": [
            {
                "data": null,
                "title": "Add",
                "orderable": false,
                "render": function (data, type, full, meta) {
                    return '<div class="checkbox"><input data-number=' + full.number + ' class="chkAddStudent" type="checkbox" value=""></div>';
                }
            },
            {
                "data": null,
                "title": "First name",
                "render": function (data, type, full, meta) {
                    return '<a href=student?number=' + full.number + '>' + full.firstName + '</a>';
                }
            },
            {
                "data": "insertion",
                "title": "Insertion",
                "orderable": false
            },
            {
                "data": "lastName",
                "title": "Last name"
            },
            {
                "data": null,
                "title": "Group",
                "render": function (data, type, full, meta) {
                    if (full.group === null) {
                        return null;
                    }
                    return "<p>" + full.group.name + "</p>";
                }
            },
            {
                "data": null,
                "title": "Photo",
                "width": "3%",
                "orderable": false,
                "render": function (data, type, full, meta) {
                    return "<img style='width:100%' data-toggle='popover' src=/project/images/" + full.number + ".jpeg>";
                }
            }
        ],
        "createdRow": function (row, data, dataIndex) {
            //remove the student tag if the checkbox gets unchecked, else create a student tag
            $(row).find('.chkAddStudent').change(function () {
                if (!$(this).is(':checked')) {
                    var $studentTag = $modal.find('.studentNumbers li[data-number=' + data['number'] + ']');
                    $studentTag.remove();
                } else {
                    var name = data['firstName'] + ' ' + data['lastName'];
                    createStudentTag($modal, name, data['number']);
                }
            });
        },
        "initComplete": function (settings, json) {
            initStudentsFormSubmit($modal.data('callback'), $modal.find('form'));
        }
    });
}

//init the table in the modal once
function initAddModal($target) {
    if ($target === undefined) {
        $target = $('.addModal');
    }
    $('.addModal').on('shown.bs.modal', function (e) {
        e.preventDefault();
        var $modal = $(this);
        initTargetTable($modal.find('.table'));
        $target.off('shown.bs.modal');
    });
}
