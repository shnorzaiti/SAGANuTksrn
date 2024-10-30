//RESIZE HEIGHT BASED ON CONTENT IFRAME

/*$('.modalButton').on('click', function() {
 var src = $(this).attr('data-src');
 var height = $(this).attr('data-height') || 200;
 var width = $(this).attr('data-width') || 400;
 //console.log(src+":"+height+":"+width);
 $(".modal iframe").attr({'src': src,
 'height': height,
 'width': width});
 });*/
$('.modalButton').on('click', function () {
    var src = $(this).attr('data-src');
    var height = $(window).height();// * 0.7;//$(this).attr('data-height') || 400;
    //var height = $(document).height();
    var width = $(this).attr('data-width');// || 400;
    console.log(src);
    console.log(height);
    console.log(width);
    if ($(this).attr('data-label') != 'undefined') {
        $(".modal #modalLabel").html($(this).attr('data-label'));
    }
    $(".modal iframe").attr({'src': src,
        'height': height,
        'width': width});
});

$('iframe').load(function () {
    // console.log("IFRAME");
    if ($(".modal iframe").length > 0) {
        var window = this.contentWindow;
        var prevheight = $(".modal iframe").attr('height');
        /*var newheight = Math.max(window.document.body.scrollHeight, window.document.body.offsetHeight
         , window.document.documentElement.clientHeight, window.document.documentElement.scrollHeight, window.document.documentElement.offsetHeight);
         */
        var newheight = $('iframe:eq(0)').contents().find('body').height();
        console.log(prevheight + ":" + newheight + ":" + $('iframe:eq(0)').contents().find('body').height());
        if (newheight !== prevheight && newheight > 0) {
            $(".modal iframe").attr('height', newheight);
        }
    }
});
//END RESIZE HEIGHT BASED ON CONTENT IFRAME

function reloadMaklumat(frm, link) {
    frm.action = link;
    frm.submit();
}

function goToByScroll(id) {
    // Remove "link" from the ID
    id = id.replace("link", "");
    // Scroll
    $('html,body').animate({
        scrollTop: $("#" + id).offset().top},
    'slow');
}

function clearCookies() {
    $.cookie('menuLvl1', null);
    $.cookie('menuUrl', null);
}

function reloadMaklCBK(data)
{
    //$('#butangNiaga').show();
    $('#infoKodJabatan').hide();
    $.getJSON("MaklCBKJson", {"passData": data}, function (data) {
        //$('#JAbjbkod').val(data.jabt.jabJbkod);

        if (data.rekodWujud === 0) {
            $('#JAbjbkod').val('');
            $('#JAbjnama').html('<strong>-</strong>');
            $info = "<p class='text-info'>Kod Jabatan tidak sah.</p>";
            $('#infoKodJabatan').html($info);
            $('#infoKodJabatan').show();
            //$('#butangNiaga').hide();
        } else {
            $('#JAbjnama').html('<strong>' + data.jabt.jabJnama + '</strong>');
        }

    });
}


function tab(field, event) {
    if (event.which === 13 /* IE9/Firefox/Chrome/Opera/Safari */ || event.keyCode === 13 /* IE8 and earlier */) {
        var focussableElements = 'a:not([disabled]), button:not([disabled]), input[type=text],[type=password]:not([disabled]), [tabindex]:not([disabled]):not([tabindex="-1"])';
        if (document.activeElement && document.activeElement.form) {
            var focussable = Array.prototype.filter.call(document.activeElement.form.querySelectorAll(focussableElements),
                    function (element) {
                        //check for visibility while always include the current activeElement 
                        return element.offsetWidth > 0 || element.offsetHeight > 0 || element === document.activeElement
                    });
            var index = focussable.indexOf(document.activeElement);
            focussable[index + 1].focus();
        }
        return false;
    }
    return true;
}