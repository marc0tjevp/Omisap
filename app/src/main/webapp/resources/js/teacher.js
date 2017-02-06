/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    initCreateAbbreviation();
});

function initCreateAbbreviation() {
    $('#firstName, #lastName').keyup(function () {
        var first = $('#firstName').val().trim();
        var last = $('#lastName').val().trim();
        s = last.substr(0, 4) + first.substr(0, 2);
        $('#abbreviation').val(s.toLowerCase());
    });
}