$(document).ready(function () {

    $("#selectAll").on('click', function () {
        if (this.checked) {
            // Iterate each checkbox
            $(':checkbox').each(function () {
                this.checked = true;
                $(this).addClass("selectedLessonGroup");
                $("#deleteStudentButton").removeAttr("disabled");
            });
        }
        else {
            $(':checkbox').each(function () {
                this.checked = false;
                $(this).removeAttr("disabled");
                $("#deleteStudentButton").attr("disabled", true);
            });
        }
    });

    $(".lesson-groups-table tbody td input[type=\"checkbox\"]").change(function () {
        if (this.checked) {
            $(this).addClass("selectedLessonGroup");
        } else {
            $(this).removeClass("selectedLessonGroup");
        }


        var selectedLessonGroup = $(".selectedLessonGroup");
        if (selectedLessonGroup.length == 0) {
            $("#deleteStudentButton").attr("disabled", true);
        }

        if (selectedLessonGroup.length >= 1) {
            $("#deleteStudentButton").removeAttr("disabled");
        }
    });


});