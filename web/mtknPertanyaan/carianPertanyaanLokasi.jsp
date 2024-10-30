<%-- 
    Document   : carianPertanyaanLokasi
    Created on : May 19, 2014, 3:11:49 PM
    Author     : Hafiz
--%>

<%@taglib prefix = "s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<s:include value="../inc2/head_form.jsp"/> 
<s:include value="../inc2/head_datatable.jsp"/> 
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <i class="fa" id="toggle"></i>
                </span>
                <h3 class="panel-title">Carian Jalan</h3>
            </div>
            <div class="panel-body" id="panel">
                <s:if test="layout.equals(\"frame\")">
                    <s:set name="urlCarian">2FramesearchcarianPertanyaanLokasi</s:set>                 
                </s:if>
                <s:else>
                    <s:set name="urlCarian">searchcarianPertanyaanLokasiLink2</s:set>   
                </s:else> 
                <s:form cssClass="form-horizontal" namespace="/tanya" action="%{#urlCarian}">
                    <%--div class="form-group">
                        <!--poskod jalan/kawasan-->

                <!--nama jalan-->                                              
                <label class="col-sm-2 control-label">nama jalan :</label>
                <div class="col-sm-4 input-group">
                    <s:textfield cssClass="form-control input-sm" name="carianLokasi.JNama"/>
                </div>
            </div--%> 
                    <div class="form-group">                        
                        <!--kod jalan-->
                        <label class="col-sm-2 control-label">jalan :</label>
                        <div class="col-sm-4">
                            <div class="input-group"> 
                                <s:select id="JlkodDr" name="lokasiPerincian.pegJlkod" cssClass="form-control input-sm select2_single" tabindex="-1" headerKey="" headerValue="--- Pilih Jalan ---" list="jalanList" listKey="jlnJlkod" listValue="jlnJlkod +' - '+ jlnJnama" title="Jalan" data-placeholder="--- Pilih Jalan ---"/> 
                                <s:url var="urlJalan" namespace="/" action="Jlkod" escapeAmp="false">
                                    <s:param name="idField">JlkodDr</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJalan" />" data-height="100%" data-width="99.6%" data-target="#modalJlkod">
                                    <i class="fa fa-book" style="cursor: pointer;"></i>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="operation-button">
                            <button type="submit" class="cari"></button>
                            <button type="reset" class="isisemula" onclick="window.location = '<s:property value="urlCarian"/>'"></button>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <i class="fa" id="toggle2"></i>
                </span>
                <h3 class="panel-title">hasil carian</h3>
            </div>
            <div class="panel-body" id="panel2">
                <div class="mb col-sm-12">       
                    <s:iterator value="carianPertanyaanLokasiList">
                        <s:if test="status.equals(\"AKTIF\")">
                            <div class="btn btn-app" onclick="window.location = '<s:property value="#urlCarian"/>?lokasiPerincian.pegJlkod=<s:property value="lokasiPerincian.pegJlkod"/>&status=Y'">
                                <span class="badge bg-blue-sky"><s:property value="bil == null ? '0':bil"/></span>
                                <i class="fa fa-users"></i><s:property value="status"/>
                            </div>
                        </s:if>
                        <s:else>
                            <div class="btn btn-app" style="cursor: default;" onclick="window.location = '<s:property value="#urlCarian"/>?lokasiPerincian.pegJlkod=<s:property value="lokasiPerincian.pegJlkod"/>&status=Y&codeStatus=H'">
                                <span class="badge bg-green"><s:property value="bil == null ? '0':bil"/></span>
                                <i class="fa fa-close"></i><s:property value="status"/>
                            </div>
                        </s:else>
                    </s:iterator>
                </div>
                <s:if test="status != null">
                    <div class="form-group">
                        <div class="col-sm-6 form-control-static">
                            <s:if test="codeStatus == null">
                                <h3 class="panel-title"> Akaun Aktif</h3>

                            </s:if>
                            <s:else>
                                <h3 class="panel-title"> Akaun Batal</h3>
                            </s:else>
                        </div>
                    </div>
                </s:if>
                <div class="form-group">
                    <s:if test="layout.equals(\"frame\")">
                        <s:set name="urlDetail">2FramePelMklumatPgangan</s:set>                 
                    </s:if>
                    <s:else>
                        <s:set name="urlDetail">PelMklumatPganganLink2</s:set>   
                    </s:else>     
                    <display:table name="lokasiPerincianList" id="models" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending" >
                        <display:setProperty name="paging.banner.placement" value="bottom" />     
                        <display:setProperty name="basic.empty.showtable" value="true" />
                        <display:column property="pvdPlgid" title="No. K/P" />
                        <display:column property="pegAkaun" title="No. Akaun" />
                        <display:column property="pvdPnama" title="Nama Pemilik" />
                        <display:column property="pegAhrta" title="Alamat Harta" />
                        <display:column property="pegNilth" style="text-align: right" title="Nilai Tahunan (RM)" />
                        <display:column property="pegTksir" style="text-align: right" title="Cukai Taksiran (RM)" />
                        <display:column property="pegStatf" title="Status Akaun" />
                        <display:column title="Tindakan">                     
                            <s:a href="%{#urlDetail}?PelMklumatPgangan.pegAkaun=%{#attr.models.pegAkaun}&stsBack=2"><i class="fa fa-eye tooltips" data-toogle="tooltip" data-placement="top" title="Lihat Rekod"></i></s:a>      
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       
                            <s:url var="urlMaklumat" namespace="/report" action="cetak" escapeAmp="false">
                                <s:param name="reportName">pemilikPegangan</s:param>
                                <s:param name="param1" value="%{#attr.models.pegAkaun}"/>
                            </s:url>                                        
                            <a  class="modalButton" data-toggle="modal" data-src="<s:property value="#urlMaklumat" />" 
                                data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false"> <i class="fa fa-print tooltips" data-toogle="tooltip" data-placement="top" title="Cetak Rekod"></i></a>
                            </display:column>
                        </display:table>
                </div>
            </div>
        </div>

        <script src="<%=request.getContextPath()%>/jscript/common.js"></script>
        <s:include value="../inc2/footer_datatable.jsp"/> 
        <s:include value="../inc2/footer_form.jsp"/> 
        <!-- (MODAL) -->
        <div class="modal fade" id="modalJlkod" tabindex="-1" role="dialog"  aria-labelledby="modalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="modalLabel">Jalan</h4>
                    </div>
                    <div class="modal-body">
                        <iframe id="frame" frameborder="0" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!--  (MODAL) -->
        <!-- CETAK (MODAL) -->  
        <div class="modal fade" id="modalCetak" tabindex="-1" role="dialog"  aria-labelledby="modalCetakLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" style="width: 100%; height: 100%; padding: 0">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="modalCetakLabel">Maklumat Pemilik dan Pegangan</h4>

                    </div>
                    <div class="modal-body" style="zoom:0.80;">
                        <iframe id="cetakFrame" height="700px" width="100%" frameborder="0" scrolling="yes"></iframe>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!-- CETAK (MODAL) -->      
        <%--
        <s:include value="/sidebar-right.jsp"/>        
        <s:include value="/footer-table.jsp"/> 
        --%>
        <%--<script>
            $(window).load(function() { // makes sure the whole site is loaded
                        $('#status').fadeOut(); // will first fade out the loading animation
                        $('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
                        $('body').delay(350).css({'overflow':'visible'});
                });
        </script>--%>
        <%--</body>
        </html>--%>
