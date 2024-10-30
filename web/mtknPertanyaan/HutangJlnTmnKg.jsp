<%-- 
    Document   : HutangJlnTmnKg
    Created on : Apr 21, 2014, 10:34:04 AM
    Author     : NurMuhammadAfzal
--%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="/head-form.jsp"/>                 

    </head>
    <body>
        <s:include value="/top.jsp"/>    
        <s:include value="/sidebar-left.jsp"/>
        <!-- Preloader -->
        <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>
        <form class="form-horizontal ">
            <section class="panel">

                <header class="panel-heading">
                    HUTANG MENGIKUT JALAN/TAMAN/KAMPUNG
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down tooltips" data-toggle="tooltip" data-placement="bottom" title="Tutup panel"></a>                                       
                    </span>
                </header>
                <div class="panel-body">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Kod JLN/TMN/KG :</label>
                        <div class="col-sm-2">
                            <select name="select" class="form-control input-sm">
                                <option>...</option>
                                <option>67890</option>
                                <option>12345</option>
                                <option>67890</option>
                            </select>
                        </div>

                        <div class="col-sm-6">                           
                            <input type="text" class="form-control input-sm" placeholder="display">
                        </div>                        
                    </div>

                    <div class="form-group">                    
                        <label class="col-sm-2 control-label" >bilangan harta :</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control input-sm" placeholder="display">
                        </div>

                        <label class="col-sm-3 control-label" >bayaran lebihan :</label>
                        <div class="col-sm-3">
                            <div class="input-group">
                                <span class="input-group-addon">RM</span>
                                <input type="text" class="form-control input-sm" placeholder="">
                            </div>    
                        </div>
                    </div>
            </section>




            <section class="panel">

                <header class="panel-heading">
                    hutang dan terimaan
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down tooltips" data-toggle="tooltip" data-placement="bottom" title="Tutup panel"></a>                                       
                    </span>
                </header>
                <div class="panel-body">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th></th>
                                <th>
                                    semasa
                                </th>
                                <th>
                                    tunggakan
                                </th>
                                <th>
                                    bayaran
                                </th>
                                <th>
                                    baki hutang
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>taksiran</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>notis E</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>denda lewat</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>

                            </tr>
                            <tr>
                                <th>waran F</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>jumlah</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>

                        </tbody>
                    </table>

                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th></th>
                                <th>
                                    semasa
                                </th>
                                <th>
                                    tunggakan
                                </th>
                                <th>
                                    bayaran
                                </th>
                                <th>
                                    baki hutang
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>persekutuan</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>negeri</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>badan berkanun</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>

                            </tr>
                            <tr>
                                <th>jumlah</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>jumlah besar</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>

                        </tbody>
                    </table>


                </div>

                <div class="span4 offset4 text-center">                        
                    <button type="submit" class="btn btn-primary">Simpan</button>
                    <button type="reset" class="btn btn-primary">Batal</button>
                </div>
            </section>


        </form>
        <s:include value="/sidebar-right.jsp"/> 
        <s:include value="/footer-form.jsp"/> 
<script>
            $(window).load(function() { // makes sure the whole site is loaded
			$('#status').fadeOut(); // will first fade out the loading animation
			$('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
			$('body').delay(350).css({'overflow':'visible'});
		});
        </script>
    </body>
</html>    
