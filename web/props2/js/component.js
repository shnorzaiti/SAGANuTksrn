/*
 * Button Class
 */
$('.table').addClass('table-striped table-bordered');
//Operation button
$('.operation-button').addClass('col-sm-offset-2 col-sm-10');
//Daftar button class
$('.daftar').addClass('btn btn-primary');
$('.daftarPilih').addClass('btn btn-success dropdown-toggle');
//Simpan rekod button class
$('.simpan').addClass('btn btn-success');
//Simpan rekod & next tab button class
$('.simpanNext').addClass('btn btn-primary');
//Cari rekod button class
$('.cari').addClass('btn btn-info');
//Batal button class
$('.batal').addClass('btn btn-primary');
//Senarai rekod button class
$('.senarai').addClass('btn btn-info');
//Proses rekod button class
$('.proses').addClass('btn btn-success');
//Cetak button class
$('.cetak').addClass('btn btn-primary');
$('.cetakSm').addClass('btn btn-primary btn-sm');
$('.cetaksemula').addClass('btn btn-primary');
$('.cetakPilih').addClass('btn btn-primary dropdown-toggle');
$('.cetakAns').addClass('btn btn-primary');
//padam
$('.padam').addClass('btn btn-warning btn-sm');
//kemaskini
$('.kemaskini').addClass('btn btn-primary');
//isi semula
$('.isisemula').addClass('btn btn-warning');
//upload
$('.upload').addClass('btn btn-primary');
//keluar
$('.keluar').addClass('btn btn-info');
//login
$('.login').addClass('btn btn-primary');
//Tutup button class
$('.tutup').addClass('btn btn-warning');
//Jana button class
$('.jana').addClass('btn btn-primary');
//Kembali button class
$('.kembali').addClass('btn btn-primary btn-sm');
//Tambah button class
$('.tambah').addClass('btn btn-info');
//Buang button class
$('.buang').addClass('btn btn-warning');

/*
 * Button Labelling
 */
//Button daftar
$('.daftar').append('<i class="fa fa-plus-circle"></i>' + '&nbsp' + 'Rekod Baru');
$('.daftarPilih').append('<i class="fa fa-plus-circle"></i> Daftar &nbsp;&nbsp;<i class="fa fa-angle-down"></i>');
//Button Simpan rekod
$('.simpan').append('<i class="fa fa-save fa"></i>' + '&nbsp' + 'Simpan Rekod');
//Button Simpan rekod & next tab
$('.simpanNext').append('<i class="fa fa-save fa"></i>' + '&nbsp' + 'Simpan Rekod & Seterusnya');
//Button Batal operasi
$('.batal').append('<i class="fa fa-times"></i>' + '&nbsp' + 'Batal Operasi');
//proses
$('.proses').append('<i class="fa fa-save"></i>'+'&nbsp'+'Proses Rekod');
//Button Cari rekod
$('.cari').append('<i class="fa fa-search"></i>'+'&nbsp'+'Carian');
//Button Senarai
$('.senarai').append('<i class="fa fa-file"></i>'+'&nbsp'+'Lihat Senarai Rekod');
//cetak
$('.cetak').append('<i class="fa fa-print"></i>'+'&nbsp;'+'Cetak Rekod');
$('.cetakSm').append('<i class="fa fa-print"></i>'+'&nbsp;'+'Cetak Rekod');
$('.cetaksemula').append('<i class="fa fa-print"></i>'+'&nbsp;'+'Cetak Semula Rekod');
$('.cetakPilih').append('<i class="fa fa-print"></i> Cetak &nbsp;&nbsp;<i class="fa fa-angle-down"></i>');
$('.cetakAns').append('<i class="fa fa-print"></i>'+'&nbsp;'+'Cetak Bil Ansuran');
//padam
$('.padam').append('<i class="fa fa-trash"></i>'+'&nbsp'+'Padam Rekod');
//kemaskini
$('.kemaskini').append('<i class="fa fa-edit"></i>'+'&nbsp'+'Kemaskini Rekod');
//isi semula
$('.isisemula').append('<i class="fa fa-refresh"></i>'+'&nbsp'+'Isi Semula');
//upload
$('.upload').append('<i class="fa fa-upload"></i>'+'&nbsp'+'Muat Naik');
//keluar
$('.keluar').append('<i class="fa fa-sign-out"></i>'+'&nbsp'+'Keluar');
//login
$('.login').append('<i class="fa fa-sign-in"></i>'+'&nbsp'+'Login');
//Tutup button class
$('.tutup').append('<i class="fa fa-times"></i>'+'&nbsp'+'Tutup');
//Jana button class
$('.jana').append('<i class="fa fa-cogs"></i>'+'&nbsp'+'Jana');
//Kembali button class
$('.kembali').append('<i class="fa fa-backward"></i>'+'&nbsp'+'Kembali'); 
//Tambah button class
$('.tambah').append('Tambah'+'&nbsp'+'<i class="fa fa-plus-square"></i>');
//Buang button class
$('.buang').append('Buang'+'&nbsp'+'<i class="fa fa-trash-o"></i>');
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