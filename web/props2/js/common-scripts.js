
//auto slash date id = txtDate 23/11/2015
$(".datepicker").keyup(function (e) {
    var textSoFar = $(this).val();

    /* if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
     //display error message
     //$("#errmsg").html("Digits Only").show().fadeOut("slow");
     console.log("Digits Only");
     return false;
     }*/

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

$('.input-sm').on("input", function () {
    this.value = this.value.toUpperCase();
});

//Confirmation
$("body").delegate(".confirm", "click", function (event) {
    event.preventDefault();
    var page = $(this).attr('href');
    var formId = $(this).attr('formId');
    var msg = $(this).attr('data-msg');

    vex.defaultOptions.className = 'vex-theme-flat-attack';
    vex.dialog.confirm({
        message: msg,
        callback: function (confirmed) {
            $(".vex").hide();
            if (confirmed) {
                if (formId == undefined) {
                    if (page == undefined) {
                        $("#" + $('form').attr('id')).submit();
                    } else {
                        window.location.href = page;
                    }
                } else {
                    $("#" + formId).submit();
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

$(document).ready(function () {
    $('#selectall').click(function (event) {  //on click
        if (this.checked) { // check select status
            $('.checkbox').each(function () { //loop through each checkbox
                this.checked = true;  //select all checkboxes with class "checkbox1"              
            });
        } else {
            $('.checkbox').each(function () { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox1"                      
            });
        }
    });

});


//$('.amount').priceFormat();
$(".amount").blur(function () {
    if ($(this).val() != '') {
        $(this).val(parseFloat($(this).val().replace(/,/g, '')).toFixed(2));
        if ($(this).val().length > parseInt($(this).attr('maxLength'))) {
            $('<div class="req">' + $(this).val() + ' melebihi input yang dibenarkan (' + $(this).attr('maxLength') + ')</div>').insertAfter($(this).parent(".input-group"));
            $(this).val('');
            $(this).addClass("decoratedErrorField");
        } else {
            $(this).removeClass("decoratedErrorField");
            $('div.req').hide();
        }
    }
});
/* BYE 07/12/2015 */

/* 26/03/2016 */

/** ******  /select2  *********************** **/
$(document).ready(function () {
    $(".select2_single").select2({
        placeholder: $(this).attr('data-placeholder'),
        allowClear: true
    })
            .on("select2-close", function () {
                setTimeout(function () {
                    $('.select2-container-active').removeClass('select2-container-active');
                    $(':focus').blur();
                }, 1);
            });
});
/** ******  /select2  *********************** **/
/* 26/03/2016 */
/* 29/03/2016 */

function validateEmail(sEmail) {
    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (filter.test(sEmail)) {
        return true;
    }
    else {
        return false;
    }
}

$('.input-email').on("blur", function () {
    $('#infoEmail').hide();
    var sEmail = $(this).val();
    /*if ($.trim(sEmail).length == 0) {
     alert('Please enter valid email address');
     e.preventDefault();
     }*/
    if (validateEmail(sEmail) === false) {
        $('#infoEmail').html('Format E-mel tidak sah.');
        $('#infoEmail').show();
    }
    /*else {
     alert("E-mel tidak sah.");
     $('#infoEmail').html('E-mel tidak sah.');
     $('#infoEmail').show();
     //e.preventDefault();
     }*/
});

/* 29/03/2016 */
