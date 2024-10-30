

<%@ taglib prefix = "s" uri="/struts-tags"%>
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
        <section class="panel">
            <header class="panel-heading">
                penyata akaun individu
                <span class="fa tools pull-right">
                    <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle"></a>                                               
                </span>
            </header>
            <div class="panel-body" id="panel">
                <s:form cssClass="form-horizontal" namespace="/tanya" action="carianPenyata">
                    <div class="form-group">
                        <!--pilihan/cetak-->
                        <label class="col-sm-2 control-label">Pilihan :</label>
                        <div class="col-sm-3">
                            <s:textfield name="carianPenyata.PEgoldac"/>
                        </div>
                        <label class="col-sm-2 control-label">Cetak :</label>
                        <div class="col-sm-3">
                            <select class="form-control">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <!--No. K/P@Pendaftaran/kegunaan hartanah-->
                        <label class="col-sm-2 control-label">No. Akaun :</label>
                        <div class="col-sm-3">
                           <s:textfield name="carianPenyata.PEgakaun"/>
                        </div>
                        <label class="col-sm-2 control-label">No. Akaun Lama :</label>
                        <div class="col-sm-3">
                            <s:textfield name="carianPenyata.PEgoldac"/>
                        </div>                        
                    </div>
                    <div class="form-group">                     
                        <!--nama/bangsa-->
                        <label class="col-sm-2 control-label">ID Pelanggan :</label>                    
                        <div class="col-sm-3">
                            <s:textfield name="carianPenyata.PEgoldac"/>
                        </div>
                        <label class="col-sm-2 control-label">Status Bil :</label>                    
                        <div class="col-sm-3">
                            <s:textfield name="carianPenyata.PEgoldac"/>
                        </div>
                    </div>
                    <!--nama-->
                    <div class="form-group">                    
                        <label class="col-sm-2 control-label">Nama Di Atas Bil :</label>
                        <div class="col-sm-6 ">
                            <s:textfield name="carianPenyata.PEgoldac"/>                                        
                        </div>                        
                    </div>
                    <!--alamat-->
                    <div class="form-group">                    
                        <label class="col-sm-2 control-label">Alamat Harta:</label>
                        <div class="col-sm-6 ">
                            <input type="text" class="form-control input-sm ">                         
                            <input type="text" class="form-control input-sm ">
                            <input type="text" class="form-control input-sm ">
                            <input type="text" class="form-control input-sm ">
                            <input type="text" class="form-control input-sm ">
                        </div>                        
                    </div> 
                    
                    <div class="position-center">
                    <s:submit value="Cari" cssClass="btn btn-primary"/>
                    </div>
                </s:form>
            </div>
        </section>
        <section class="panel">
            <header class="panel-heading">
                Modul Taksiran
                <span class="fa tools pull-right">
                   <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle2"></a>                                              
                </span>
            </header>
            <div class="panel-body" id="panel2">
               <table class="table table-striped table-hover table-bordered">                                        <thead>
                       
                            <tr>
                                <th>Tarikh Bil</th>
                                <th>Bil/Resit</th>
                                <th>Keterangan</th>
                                <th>Bil</th>
                                <th>Resit</th>
                                <th>Baki</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="carianPenyataList" var="obj">
                            <tr>
                                <td><s:property value="%{PEgakaun}"/></td>
                                    <td><s:property value="%{PEgoldac}"/></td>
                                    <td><s:property value="%{PMknmbil}"/></td>
                                    <td><s:property value="%{PMkplgid}"/></td>                     
                                    <td><s:property value="%{PEgnolot}"/></td>
                                    <td><s:url var="linkAkaun" action="PelMklumatPgangan">
  <s:param name="PelMklumatPgangan.PEgakaun" value="%{PEgakaun}"></s:param></s:url><s:a href="%{linkAkaun}"><i class="fa fa-eye tooltips" title="Lihat rekod"></i></s:a></td>
                            </tr>
                            </s:iterator>
                        </tbody>
                    </table>
            </div>
        </section>
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

