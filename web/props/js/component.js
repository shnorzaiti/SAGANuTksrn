/*
 * Button Class
 */
$('.table').addClass('table-striped table-bordered');
//Operation button
$('.operation-button').addClass('col-sm-offset-2 col-sm-10');
//Daftar button class
$('.daftar').addClass('btn btn-primary btn-lg');
//Simpan rekod button class
$('.simpan').addClass('btn btn-primary btn-lg');
//Cari rekod button class
$('.cari').addClass('btn btn-primary btn-lg');
//Batal button class
$('.batal').addClass('btn btn-warning btn-lg');
//Senarai rekod button class
$('.senarai').addClass('btn btn-info btn-lg');
//Proses rekod button class
$('.proses').addClass('btn btn-primary btn-lg');
//Cetak button class
$('.cetak').addClass('btn btn-primary btn-lg');
//padam
$('.padam').addClass('btn btn-warning btn-sm');
//kemaskini
$('.kemaskini').addClass('btn btn-primary btn-lg');
//isi semula
$('.isisemula').addClass('btn btn-warning btn-lg');

/*
 * Button Labelling
 */
//Button daftar
$('.daftar').append('<i class="fa fa-plus-circle"></i>' + '&nbsp' + 'Rekod Baru');
//Button Simpan rekod
$('.simpan').append('<i class="fa fa-save fa"></i>' + '&nbsp' + 'Simpan Rekod');
//Button Batal operasi
$('.batal').append('<i class="fa fa-times"></i>' + '&nbsp' + 'Batal Operasi');
//proses
$('.proses').append('<i class="fa fa-save"></i>'+'&nbsp'+'Proses Rekod');
//Button Cari rekod
$('.cari').append('<i class="fa fa-search"></i>'+'&nbsp'+'Carian');
//Button Senarai
$('.senarai').append('<i class="fa fa-file></i>'+'&nbsp'+'Lihat Senarai Rekod');
//cetak
$('.cetak').append('<i class="fa fa-print"></i>'+'&nbsp'+'Cetak Rekod');
//padam
$('.padam').append('<i class="fa fa-trash"></i>'+'&nbsp'+'Padam Rekod');
//kemaskini
$('.kemaskini').append('<i class="fa fa-edit"></i>'+'&nbsp'+'Kemaskini Rekod');
//isi semula
$('.isisemula').append('<i class="fa fa-refresh"></i>'+'&nbsp'+'Isi Semula');
/*
 * Table
 */
//datatable


////Dynamic Tabs
//$(document).ready(function() {
//    var tabmain = $("#tabmain");
//    var tabs = tabmain.find("section");
//    var tabNum = 1;
//    var tabHeader = '<ul class="nav nav-tabs">';
//    tabs.each(function() {
//        var tab = $(this);
//        var tabName = tab.data("tab-name");
//        if (tabName.length) {
//            var tabId = "tab" + tabNum;
//            tab.attr("id", tabId);
//            tabHeader += '<li><a href="#' + tabId + '" data-toggle="tab">' + tabName + '</a></li>';
//            tabNum++;
//        }
//    });
//    tabs.wrapAll('<div class="tab-content" />');
//    tabHeader += "</ul>";
//    $(tabHeader).insertBefore(tabmain.find("[class=tab-content]"));
//});

$('#tabmain > section').addClass('tab-pane container');