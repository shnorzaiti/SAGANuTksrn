<%-- 
    Document   : ListAnsuran
    Created on : Nov 19, 2014, 11:58:33 PM
    Author     : otasoft01
--%>

<%@ taglib prefix="s" uri="/struts-tags"%>
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
                    <i class="fa fa-arrows-alt"></i>
                </span>
                <h3 class="panel-title">menu carian</h3>
            </div>
            <div class="panel-body" id="panel"> 
                <s:form cssClass="form-horizontal" namespace="/ansuran" action="ansuranListLink2">
                    <div class="form-group">
                        <!--no akaun/ no akaun lama-->
                        <label class="col-lg-2 control-label">No. Akaun :</label>
                        <div class="col-lg-2">
                            <s:textfield cssClass="form-control input-sm" name="carianAkaun" title="Masukkan No. Akaun Baru"/>
                        </div>

                        <label class="col-lg-2 control-label">Nama Pelanggan:</label>
                        <div class="col-lg-4">
                            <s:textfield cssClass="form-control input-sm" name="carianNama" title="Masukkan Nama Pelanggan"/>
                        </div>
                    </div> 
                    <div class="form-group">
                        <div class="operation-button">
                            <button class="cari" type="submit"></button>
                            <button class="isisemula" type="button"></button>         
                        </div>
                    </div>

                </s:form>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <i class="fa" id="toggle"></i>
                    <i class="fa fa-arrows-alt"></i>
                </span>
                <h3 class="panel-title">senarai ansuran</h3>
            </div>
            <div class="panel-body" id="panel">
                <div class="mb">
                    <a class="daftar" href="AnsuranLink2" >                
                    </a>
                </div>
                <display:table name="ansuranList" uid="models" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped table-hover" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending" >
                    <display:setProperty name="paging.banner.placement" value="bottom" />     
                    <display:setProperty name="basic.empty.showtable" value="true" />  
                    <display:column property="in2Akaun" title="No. Akaun" style="width:5%"/>
                    <display:column property="nama" title="Nama Pemilik"/>
                    <display:column property="in2Trikh" title="Tempoh"/>
                    <display:column property="bilangan" title="Bil. Ansuran" style="text-align:right"/>
                    <display:column property="jumlah" title="Jumlah" style="text-align:right"/>
                    <display:column title="Tindakan">
                        <s:if test="layout.equals(\"frame\")">
                            <s:set name="urlAkaun">FramePelMklumatPgangan</s:set>                 
                        </s:if>
                        <s:else>
                            <s:set name="urlAkaun">PelMklumatPganganLink</s:set>   
                        </s:else> 
                        <s:url var="linkAkaun" action="%{#urlAkaun}">
                            <s:param name="PelMklumatPgangan.pegAkaun" value="%{pegAkaun}">
                            </s:param>
                        </s:url>                     
                        <a href="javascript:void(0);" onClick="href = 'InfoLink2?HVnduk4.pegAkaun=<s:property value="%{#attr.models.in2Akaun}"/>'"><i class="fa fa-pencil tooltips" title="Lihat Rekod" data-placement="top" data-toggle="tooltip"></i></a>                                 
                        &nbsp;&nbsp;&nbsp;
                        <s:url var="urlBilAnsuran" namespace="/report" action="cetak" escapeAmp="false">
                            <s:param name="reportName">hlkq01_a4</s:param>
                            <s:param name="param1"><s:property value="%{#attr.models.in2Akaun}"/></s:param> 
                            <s:param name="onama"><s:property value="%{userModel.userId}"/></s:param>
                        </s:url> 
                        <a class="modalButton" data-toggle="modal" data-src="<s:property value="#urlBilAnsuran" />"
                           data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false"><i class="fa fa-print tooltips" title="Bil Ansuran"></i></a> 
                        </display:column>
                    </display:table>                
            </div>
        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/jscript/common.js"></script>
<s:include value="../inc2/footer_datatable.jsp"/> 
<s:include value="../inc2/footer_form.jsp"/> 

<!-- CETAK (MODAL) -->  
<div class="modal fade modal-fullscreen" id="modalCetak" tabindex="-1" role="dialog"  aria-labelledby="modalCetakLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" style="width: 100%; height: 100%; padding: 0">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="$('#cetakFrame').attr('src', '');">&times;</button>
                <h4 class="modal-title" id="modalCetakLabel">Bil</h4>
            </div>
            <div class="modal-body" style="zoom:0.80;">
                <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="750px" width="100%" 
                        frameborder="0" scrolling="yes"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- CETAK (MODAL) -->
