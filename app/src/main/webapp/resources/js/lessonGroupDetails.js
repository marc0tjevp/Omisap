$(document).ready(function () {

    $("#selectAll").on('click', function () {
        if (this.checked) {
            // Iterate each checkbox
            $(':checkbox').each(function () {
                this.checked = true;
                $(this).addClass("selectedLessonGroupStudent");
                $("#deleteStudentButton").removeAttr("disabled");
            });
        }
        else {
            $(':checkbox').each(function () {
                this.checked = false;
                $(this).removeClass("selectedLessonGroupStudent");
                $("#deleteStudentButton").attr("disabled", true);
            });
        }
    });

    $(".lesson-groups-table tbody td input[type=\"checkbox\"]").change(function () {
        if (this.checked) {
            $(this).addClass("selectedLessonGroupStudent");
        } else {
            $(this).removeClass("selectedLessonGroupStudent");
        }


        var selectedLessonGroup = $(".selectedLessonGroupStudent");
        if (selectedLessonGroup.length == 0) {
            $("#deleteStudentButton").attr("disabled", true);
        }

        if (selectedLessonGroup.length >= 1) {
            $("#deleteStudentButton").removeAttr("disabled");
        }
    });

    $("#selectAllStudentsForLessonGroupCheckbox").on('click', function () {
        if (this.checked) {
            // Iterate each checkbox
            $(':checkbox').each(function () {
                this.checked = true;
                $(this).addClass("selectedLessonGroupStudent");
                $("#deleteStudentButton").removeAttr("disabled");
            });
        }
        else {
            $(':checkbox').each(function () {
                this.checked = false;
                $(this).removeClass("selectedLessonGroupStudent");
                $("#deleteStudentButton").attr("disabled", true);
            });
        }
    });

    $(".lesson-groups-table tbody td input[type=\"checkbox\"]").change(function () {
        if (this.checked) {
            $(this).addClass("selectedLessonGroupStudent");
        } else {
            $(this).removeClass("selectedLessonGroupStudent");
        }


        var selectedLessonGroup = $(".selectedLessonGroupStudent");
        if (selectedLessonGroup.length == 0) {
            $("#deleteStudentButton").attr("disabled", true);
        }

        if (selectedLessonGroup.length >= 1) {
            $("#deleteStudentButton").removeAttr("disabled");
        }
    });

    $("#editLessonGroupName").on('show.bs.modal', function () {
        $("#currentLessonGroup").val($("#lessonGroupName").text());
    })


});