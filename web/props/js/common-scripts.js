//initializes left bar accordion djqc-accordion plugin
$(function () {
    $('#nav-accordion').dcAccordion({
        eventType: 'click',
        classActive: 'active',
        autoClose: true,
        saveState: true,
        classCount: 'badge',
        disableLink: true,
        speed: 'fast',
        showCount: false,
        autoExpand: false,
        classExpand: 'dcjq-current-parent'
    });
});
// initializes panels and their respective cookies
$(function () {
    $.fn.persistentPanel.defaults.togglerClass = false;
    $.fn.persistentPanel.defaults.defaultState = "open";
    $('#panel').persistentPanel({toggler: '#toggle', cookieName: 'panel1'});
    $('#panel2').persistentPanel({toggler: '#toggle2', cookieName: 'panel2'});
    $('#panel3').persistentPanel({toggler: '#toggle3', cookieName: 'panel3'});
    $('#panel4').persistentPanel({toggler: '#toggle4', cookieName: 'panel4'});
    $('#panel5').persistentPanel({toggler: '#toggle5', cookieName: 'panel5'});
    $('#panel6').persistentPanel({toggler: '#toggle6', cookieName: 'panel6'});
    $('#panel7').persistentPanel({toggler: '#toggle7', cookieName: 'panel7'});
});

//datetimepicker
$(function () {
    $('.datepicker').datetimepicker({
        lang: 'ms',
        format: 'd/m/Y',
        formatTime: 'H:i',
        formatDate: 'd/m/Y',
        timepicker: false,
        mask: false
    });
});

$(function() {
    $('.datetimepicker').datetimepicker({
        datepicker: false,
        format: 'h:i a',
        formatTime: 'h:i A',
        mask: true
    });

});

//auto slash date id = txtDate 23/11/2015
$(".datepicker").keyup(function (e) {
        var textSoFar = $(this).val();
        if (e.keyCode != 191) {
            if (e.keyCode != 8) {
                if (textSoFar.length == 2 || textSoFar.length == 5) {
                    $(this).val(textSoFar + "/");
                }
        //kalau copy paste 8 digit nombor ddmmyyyy akan auto convert
                else if (e.keyCode == 86 && textSoFar.length == 8) {
                    $(this).val(textSoFar.substr(0, 2) + "/" + textSoFar.substr(2, 2) + "/" + textSoFar.substr(4, 4));
                }
            }
           else {
                //backspace akan ignore slash
                if (textSoFar.length == 5) {
                    $(this).val(textSoFar.substring(0, 4));
                }
                else if (textSoFar.length == 2) {
                    $(this).val(textSoFar.substring(0, 1));
                }
            }
        }
        else {
            //ini block user guna "/"
            $(this).val(textSoFar.substring(0, textSoFar.length - 1));
        }
    });
//auto slash date id = txtDate 23/11/2015   
    
//other scripts
var Script = function () {
//  sidebar dropdown menu auto scrolling

    jQuery('#sidebar .sub-menu > a').click(function () {
        var o = ($(this).offset());
        diff = 250 - o.top;
        if (diff > 0)
            $("#sidebar").scrollTo("-=" + Math.abs(diff), 500);
        else
            $("#sidebar").scrollTo("+=" + Math.abs(diff), 500);
    });
//    sidebar toggle
    $(function () {
        function responsiveView() {
            var wSize = $(window).width();
            if (wSize <= 768) {
                $('#container').addClass('sidebar-close');
                $('#sidebar > ul').hide();
            }

            if (wSize > 768) {
                $('#container').removeClass('sidebar-close');
                $('#sidebar > ul').show();
            }
        }
        $(window).on('load', responsiveView);
        $(window).on('resize', responsiveView);
    });

    $('.sidebar-toggle').click(function () {
        $("i", this).toggleClass("fa-toggle-on fa-toggle-off");
        if ($('#sidebar > ul').is(":visible") === true) {

            $('#main-content').css({
                'margin-left': '0px'
            },
            $.cookie('main_css', 'hide', {expires: 7, path: '/'}));
            $('#sidebar').css({
                'margin-left': '-380px'
            },
            $.cookie('sidebar_ul', 'hide', {expires: 7, path: '/'}));
            $('#sidebar > ul').hide(), $.cookie('sidebar_css', 'hide', {expires: 7, path: '/'});
            $("#container").addClass("sidebar-closed"),
                    $.cookie('container', 'hide', {expires: 7, path: '/'});

        } else {
            //sidebar_content
            $('#main-content').css({
                'margin-left': '380px'
            },
            $.cookie('main_css', null)
                    );
            //sidebar_show
            $('#sidebar > ul').show(),
                    $.cookie('sidebar_ul', null);
            $('#sidebar').css({
                'margin-left': '0'
            }, $.cookie('sidebar_css', null));
            $("#container").removeClass("sidebar-closed"),
                    $.cookie('container', null);

        }
    });

//  initializes custom scrollbar
    $("#sidebar").niceScroll({styler: "fb", cursorcolor: "#fff", cursorwidth: '7', cursorborderradius: '10px', background: '#404040', spacebarenabled: false, cursorborder: ''});

//    $("html").niceScroll({styler: "fb", cursorcolor: "#4ECDC4", cursorwidth: '7', cursorborderradius: '10px', background: '#404040', spacebarenabled: false, cursorborder: '', zindex: '1000'});

//    initializes tool tips
    $('.tooltips').tooltip();
//    initializes popovers
    $('.popovers').popover();
//    
}();
// initializes datetimepicker
$(function () {
    $('.datepicker').datetimepicker({
        lang: 'ms',
        format: 'd/m/Y',
        formatTime: 'H:i',
        formatDate: 'd/m/Y',
        timepicker: false,
        mask: false
    });
});
//initializes DataTables
$('#models').dataTable({
    "aLengthMenu": [
        [10, 20, 50, 100, -1],
        [10, 20, 50, 100, "Semua"]
    ],
    //"scrollY": "200px",
    "scrollCollapse": true,
    "iDisplayLength": 20,
    "oLanguage": {
        "sLengthMenu": "Paparkan _MENU_ rekod",
        "sSearch": "Saring : ",
        "sEmptyTable": "Tiada rekod dijumpai",
        "sInfo": "Memaparkan _START_ hingga _END_ rekod daripada _TOTAL_ rekod",
        "sInfoFiltered": "(tapisan daripada _MAX_ rekod)",
        "sZeroRecords": "Tiada rekod yang sepadan ditemui",
        "sInfoEmpty": "Memaparkan 0 hingga 0 daripada 0 rekod",
        "oPaginate": {
            "sNext": "Seterusnya",
            "sPrevious": "Sebelum"
        }
    },
    "bSort": false,
    "aoColumnDefs": [{
            'bSortable': true,
            'aTargets': [0]
        }
    ]

});
//initializes Loader
$(window).load(function () {
    $(".loader").fadeOut("slow");
});
//Form Function
$('.input-sm').on("input", function () {
    this.value = this.value.toUpperCase();
});

//
$(document).ready(function () {

    $('#testinput').jqEasyCounter({
        'maxChars': 10,
        'maxCharsWarning': 8
    });

});

//Confirmation
$("body").delegate(".confirm", "click", function (event) {
    event.preventDefault();
    var page = $(this).attr('href');
    var msg = $(this).attr('data-msg');

    vex.defaultOptions.className = 'vex-theme-flat-attack';
    vex.dialog.confirm({
        message: msg,
        callback: function (confirmed) {
            $(".vex").hide();
            if (confirmed) {
                if (page == undefined) {
                    $("#" + $('form').attr('id')).submit();
                } else {
                    window.location.href = page;
                }
            } else {
                return false;
            }
        },
        buttons: [
            $.extend({}, vex.dialog.buttons.YES, {
                text: 'Ok'
            }), $.extend({}, vex.dialog.buttons.NO, {
                text: 'Batal'
            })
        ]
    });
});

$('#scrollTable').dataTable({
    "aLengthMenu": [
        [10, 20, 50, 100, -1],
        [10, 20, 50, 100, "Semua"]
    ],
    "scrollY": "200px",
    "scrollCollapse": true,
    "iDisplayLength": 20,
    "oLanguage": {
        "sLengthMenu": "Paparkan _MENU_ rekod",
        "sSearch": "Buat Carian Di Sini : ",
        "sEmptyTable": "Tiada rekod dijumpai",
        "sInfo": "Memaparkan _START_ hingga _END_ rekod daripada _TOTAL_ rekod",
        "sInfoEmpty": "Memaparkan 0 hingga 0 daripada 0 rekod",
        "oPaginate": {
            "sNext": "Seterusnya",
            "sPrevious": "Sebelum"
        }
    },
    "bSort": false,
    "aoColumnDefs": [{
            'bSortable': true,
            'aTargets': [0]
        }
    ]

});

//BYE 27/07/2015
//Prevent Enter on textfield
$('input').on("keypress", function (e) {
    if (e.keyCode == 13 && e.target.type !== 'submit') {
        e.preventDefault();
        return $(e.target).blur().focus();
    }
});
//BYE 27/07/2015

//BYE 29/07/2015
$('.number').on("keypress", function (event) {
    //$.isNumeric($(this).val()); 
    //$(".number").numeric //R&D
    return restrictInput(this, event, digitsOnly);
});

$('.decimal').on("keypress", function (event) {
    //$.isNumeric($(this).val()); 
    //$(".number").numeric //R&D
    return restrictInput(this, event, integerOnly);
});

var digitsOnly = /[1234567890]/g;
var integerOnly = /[0-9\.-]/g;
var alphaOnly = /[A-Za-z]/g;
var usernameOnly = /[0-9A-Za-z\._-]/g;

function restrictInput(myfield, e, restrictionType, checkdot) {

    $('#infoNumber').hide();
    if (!e)
        var e = window.event
    if (e.keyCode)
        code = e.keyCode;
    else if (e.which)
        code = e.which;
    var character = String.fromCharCode(code);

    // if user pressed esc... remove focus from field...
    if (code == 27) {
        this.blur();
        return false;
    }

    // ignore if the user presses other keys
    // strange because code: 39 is the down key AND ' key...
    // and DEL also equals .
    if (!e.ctrlKey && code != 9 && code != 8 && code != 36 && code != 37 && code != 38 && (code != 39 || (code == 39 && character == "'")) && code != 40) {
        if (character.match(restrictionType)) {
            if (checkdot == "checkdot") {
                return !isNaN(myfield.value.toString() + character);
            } else {
                return true;
            }
        } else {
            $('#infoNumber').show();
            return false;
        }
    }
}