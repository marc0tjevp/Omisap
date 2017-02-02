/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    initTabs();
    initCSRF();
    initMenuSlide();
    initPersonPopover();
    initPersonModal();
    initFormSubmit();
    initTinyMCE();
});

function initTabs() {
    var hashTab = window.location.hash;
    if (hashTab !== '') {
        $('.nav-tabs a[href="' + hashTab + '"]').tab('show');
        $(hashTab).addClass('active');
    }
    $('a[data-toggle="tab"]').on('click', function () {
        var anchor = $(this).attr('href');
        location.hash = anchor;
    });
}

function initCSRF() {
    $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
        var token;
        if (!options.crossDomain) {
            token = $('meta[name="_csrf"]').attr('content');
            if (token) {
                return jqXHR.setRequestHeader('X-CSRF-Token', token);
            }
        }
    });
}

//initialize the sliding menu
function initMenuSlide() {
    $('.slide').each(function () {
        var $slideElement = $(this);
        var target = $slideElement.data('target');
        var $target = $(document.getElementById(target));

        $slideElement.on('click', function () {
            if ($target.css('display') === 'none') {
                $target.slideDown();
            } else {
                $target.slideUp();
            }
        });
    });

}

//initialize the image popover in the teacher/student tables
function initPersonPopover() {
    //initialize popover 
    $('.person-table').on('draw.dt', function () {
        $('.person-popover').popover({
            html: true,
            trigger: 'hover',
            placement: 'right',
            container: 'body',
            content: function () {
                return '<img src="' + $(this).attr('src') + '" />';
            }
        });
    });
}

//callback for the add/edit modal
function initPersonModal() {
    $('.personModal').on('show.bs.modal', function (e) {
        var $modal = $(this);
        var $clicked = $(e.relatedTarget);
        //set title
        $modal.find('.modal-title').text($clicked.data('title'));

        //action can be 'edit' or 'add'
        var action = $clicked.data('action');
        //set the value of the action hidden input. This is used in the strut action:
        $('#action').val(action);

        //clear all inputs if this is the 'add' modal
        if (action === 'add') {
            $modal.find('input[type=text], input[type=email]').each(function () {
                $(this).val('');
            });
            return;
        }

        //if edit:
        var $tr = $(e.relatedTarget).first().closest('tr');

        $('#' + $modal.data('key')).val($tr.data('id'));
        $tds = $tr.find('td');

        //FILL THE EDIT MODAL
        //use the id and value data attributes (set by the createdCell 
        //callback in student-columns.js) to find and set the the input
        //values of the modal
        $tds.each(function () {
            var $td = $(this);
            if ($td.data('id')) {
                var id = $td.data('id');
                var value = $td.data('value');
                $('#' + id).val(value);
            }
        });
    });
}

//prevent buttons getting clicked twice and add a loader to button
function initFormSubmit() {
    $('form').submit(function () {
        $('.fa-cog').removeClass('hide');
        $('.savebtn').addClass('disabled');
    });
}

//remove loading classes from save button
function removeLoaders() {
    $('.savebtn').removeClass('disabled');
    $('.fa-cog').addClass('hide');
}

//initialize tinymce (text editor)
function initTinyMCE() {


    tinymce.init({
        selector: 'textarea:not(.noMCE):not(.textArea)',
        menubar: false,
        height: 50,
        statusbar: false,
        plugins: [
            "advlist autolink lists preview table autoresize",
        ],
        toolbar: "preview undo redo | table | bold italic | bullist numlist",
        table_default_styles: {
            width: '200px'
        },
        forced_root_block_attrs: {"style": "margin:3px 0;"},
        autoresize_min_height: 50,
    });

    tinymce.init({
        selector: 'textarea.noMCE',
        menubar: false,
        height: 50,
        toolbar: false,
        resize: false,
        plugins: "autoresize",
        autoresize_max_height: 500,
        autoresize_min_height: 50,
        autoresize_bottom_margin: 3,
        forced_root_block_attrs: {"style": "margin:3px 0;"},
        statusbar: false,
    });

}

