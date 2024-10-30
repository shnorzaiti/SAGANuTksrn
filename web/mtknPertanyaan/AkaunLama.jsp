<%-- 
    Document   : AkaunLama
    Created on : Apr 11, 2014, 11:23:51 AM
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
        <s:form cssClass="form-horizontal" namespace="/tanya" action="akaunLama">
            <section class="panel">
                <header class="panel-heading">
                    MAKLUMAT PEGANGAN
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down tooltips" data-toggle="tooltip" data-placement="bottom" title="Min/Max"></a>                   
                        <a href="javascript:;" class="fa fa-times tooltips" data-toggle="tooltip" data-placement="bottom" title="Tutup"></a>
                    </span>
                </header>
                <div class="panel-body">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">No. Akaun Baru :</label>
                        <div class="col-sm-3">
                            <%--<s:textfield cssClass="form-control input-sm" name="akaunLama.PEgakaun" />--%>
                            <s:textfield cssClass="form-control input-sm" name="akaunLama.PEgakaun" onblur="this.form.submit()"/>
                        </div>
                        <label class="col-sm-2 control-label">Akaun Lama :</label>
                        <div class="col-sm-3">
                            <s:property value="akaunLama.PEgoldac"/>
                        </div>                        
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Nama Pemilik:</label>
                        <div class="col-sm-3">
                            <s:textfield cssClass="form-control input-sm" name=""/>
                        </div>
                        <label class="col-sm-2 control-label">Nombor Lot :</label>
                        <div class="col-sm-3">
                            <s:property value="akaunLama.PEgnolot"/>
                        </div>

                    </div>                    

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Butiran Pemilik :</label>
                        <div class="col-sm-3">
                            <textarea rows="6" cols="70" class="form-control input-sm"></textarea> 
                        </div>
                        <label class="col-sm-2 control-label">Alamat Harta :</label>
                        <div class="col-sm-3">
                            <textarea rows="6" cols="70" class="form-control input-sm"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Status Pegangan :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                        <label class="col-sm-2 control-label">Nilai Tahunan :</label>
                        <div class="col-sm-3">
                            <div class="input-group">
                                <span class="input-group-addon">RM</span>
                                <s:property  value="akaunLama.PEgnilth" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Kegunaan Tanah :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                        <label class="col-sm-2 control-label">Kegunaan Hartanah :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Jenis Pemilik :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                        <label class="col-sm-2 control-label">Jenis Bangunan :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Struktur Bangunan :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Mesej :</label>
                        <div class="col-sm-5">
                            <textarea type="text" class="form-control input-sm"></textarea>
                        </div>
                    </div>



                </div>
            </section> 

        </s:form>
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