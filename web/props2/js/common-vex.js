
//Confirmation
$("body").delegate(".confirm", "click", function(event) {
    event.preventDefault();
    var page = $(this).attr('href');
    var formId = $(this).attr('formId');
    var msg = $(this).attr('data-msg');

    vex.defaultOptions.className = 'vex-theme-flat-attack';
    vex.dialog.confirm({
        message: msg,
        callback: function(confirmed) {
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