<%-- 
    Document   : carianPertanyaan
    Created on : May 14, 2014, 9:42:48 AM
    Author     : Uzzair Baharudin
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
                <h3 class="panel-title">Carian Akaun</h3>
            </div>
            <div class="panel-body" id="panel"> 
                <s:if test="layout.equals(\"frame\")">
                    <s:set name="urlCarian">2FramesearchcarianPertanyaan</s:set>                 
                </s:if>
                <s:else>
                    <s:set name="urlCarian">searchcarianPertanyaanLink2</s:set>   
                </s:else> 
                <s:form cssClass="form-horizontal" namespace="/tanya" action="%{#urlCarian}" theme="simple">
                    <div class="form-group">
                        <!--no akaun/ no akaun lama-->
                        <label class="col-sm-2 control-label">No. Akaun Baru :</label>
                        <div class="col-sm-4">
                            <s:textfield cssClass="form-control input-sm" name="carianPertanyaan.pegAkaun" title="Masukkan No. Akaun Baru"/>
                        </div>
                        <label class="col-sm-2 control-label">no. akaun lama :</label>
                        <div class="col-sm-4">
                            <s:textfield cssClass="form-control input-sm" name="carianPertanyaan.pegOldac" title="Masukkan No. Akaun Lama"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Nama Pemilik :</label>
                        <div class="col-sm-4">
                            <s:textfield cssClass="form-control input-sm" name="carianPertanyaan.pmkNmbil" title="Masukkan Nama Pelanggan"/>
                        </div>
                        <label class="col-sm-2 control-label">no. k/P :</label>
                        <div class="col-sm-4">
                            <s:textfield cssClass="form-control input-sm" name="carianPertanyaan.pmkPlgid" title="Masukkan No. K/P"/>
                        </div> 
                    </div> 

                    <div class="form-group">
                        <label class="col-sm-2 control-label">No. Hakmilik :</label>
                        <div class="col-sm-4">
                            <s:textfield cssClass="form-control input-sm" name="carianPertanyaan.pmkHkmlk" title="Masukkan No. Lot"/>
                        </div>
                        <label class="col-sm-2 control-label">No. Lot :</label>
                        <div class="col-sm-4">
                            <s:textfield cssClass="form-control input-sm" name="carianPertanyaan.pegNolot" title="Masukkan No. Lot"/>
                        </div>
                    </div>    

                   <div class="form-group">                        
                        <label class="col-sm-2 control-label">Jenis Bangunan :</label>
                        <div class="col-sm-4">
                            <div class="input-group"> 
                                <s:select id="JlkodDr" name="carianPertanyaan.pegBgkod" cssClass="form-control input-sm select2_single" tabindex="-1" headerKey="" headerValue="--- Pilih Jenis Bangunan ---" list="bgnList" listKey="bgnBgkod" listValue="bgnBgkod +' - '+ bgnBnama" title="Bangunan" data-placeholder="--- Pilih Jenis Bangunan ---"/> 
                        </div>
                    </div>
                        <label class="col-sm-2 control-label">No. PT :</label>
                        <div class="col-sm-4">
                            <s:textfield cssClass="form-control input-sm" name="carianPertanyaan.pegNompt" title="Masukkan No. PT"/>
                        </div>
                   </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Alamat Harta :</label>
                        <div class="col-sm-4">
                            <s:textarea cssClass="form-control input-sm" name="carianPertanyaan.pegAhrta" title="Masukkan Alamat"/>
                        </div>
                        <label class="col-sm-2 control-label">Alamat Pos :</label>
                        <div class="col-sm-4">
                            <s:textarea cssClass="form-control input-sm" name="carianPertanyaan.pvdAlpos" title="Masukkan Alamat"/>
                        </div>
                    </div>     

                    <div class="form-group">
                        <div class="operation-button">

                            <button type="submit" class="cari"></button>
                            <button type="reset" class="isisemula" onclick="window.location = '<s:property value="urlCarian"/>'"></button>
                            <%--s:submit value="Cari Rekod" cssClass="cari"/>
                            <s:reset value="Isi Semula Borang Ini" cssClass="isisemula"/--%>                   
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <i class="fa" id="toggle"></i>
                </span>
                <h3 class="panel-title">hasil carian</h3>
            </div>
            <div class="panel-body" id="panel2">
                <display:table uid="models" name="carianPertanyaanList" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending">
                    <display:setProperty name="paging.banner.placement" value="both" />     
                    <display:setProperty name="basic.empty.showtable" value="true" />  
                    <display:column title="No. Akaun" property="pegAkaun"/>
                    <display:column title="No. Akaun Lama" property="pegOldac"/>
                    <display:column title="Nama Pemilik" property="pmkNmbil"/>
                    <display:column title="ID Pelanggan" property="pmkPlgid"/>
                    <display:column title="Alamat Harta" property="pegAhrta"/>
                    <display:column title="Alamat Pos" property="pvdAlpos"/>
                    <display:column title="Tindakan">
                        <s:if test="layout.equals(\"frame\")">
                            <s:set name="urlAkaun">2FramePelMklumatPgangan</s:set>                 
                        </s:if>
                        <s:else>
                            <s:set name="urlAkaun">PelMklumatPganganLink2</s:set>   
                        </s:else> 
                        <s:url var="linkAkaun" action="%{#urlAkaun}">
                            <s:param name="PelMklumatPgangan.pegAkaun" value="%{#attr.models.pegAkaun}">
                            </s:param>
                        </s:url>
                        <s:a href="%{linkAkaun}"><i class="fa fa-eye tooltips" data-toogle="tooltip" data-placement="top" title="Lihat Rekod"></i></s:a>                                 
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       
                        <s:url var="urlMaklumat" namespace="/report" action="cetak" escapeAmp="false">
                            <s:param name="reportName">pemilikPegangan</s:param>
                            <s:param name="param1" value="%{#attr.models.pegAkaun}"/>
                        </s:url>                                        
                        <a  class="modalButton" data-toggle="modal" data-src="<s:property value="#urlMaklumat" />" 
                            data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false"> <i class="fa fa-print tooltips" data-toogle="tooltip" data-placement="top" title="Cetak Rekod"></i></a>

                    </display:column>
                </display:table>
                <%--table class="table" id="models">
            <thead>
                <tr>
                    <th>akaun baru</th>
                    <th>akaun lama</th>
                    <th>nama pemilik</th>
                    <th>no. K/P</th>
                    <th>no. lot</th> 
                    <th>tindakan</th>                           
                </tr>
            </thead>  
            <tbody>
                <s:iterator value="carianPertanyaanList" var="obj">
                    <tr style="text-align: center">
                        <td><s:property value="%{pegAkaun}"/></td>
                        <td><s:property value="%{pegOldac}"/></td>
                        <td><s:property value="%{pmkNmbil}"/></td>
                        <td><s:property value="%{pmkPlgid}"/></td>                     
                        <td><s:property value="%{pegNolot}"/></td>
                        <td>
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
                            <s:a href="%{linkAkaun}"><i class="fa fa-eye tooltips" data-toggle="tooltip" data-placement="top" title="Lihat Rekod"></i></s:a>                                        
                            <s:url var="urlMaklumat" namespace="/report" action="cetak" escapeAmp="false">
                                <s:param name="reportName">pemilikPegangan</s:param>
                                <s:param name="param1" value="%{pegAkaun}"/>
                            </s:url>                                        
                            <a  class="modalButton" data-toggle="modal" data-src="<s:property value="#urlMaklumat" />" 
                                data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false"> <i class="fa fa-print tooltips" data-toggle="tooltip" data-placement="top" title="Cetak Rekod"></i></a>
                        </td>

                    </tr>                                
                </s:iterator>
            </tbody>
        </table--%>
            </div>
        </div>     
    </div>
</div>

<script src="<%=request.getContextPath()%>/jscript/common.js"></script>
<s:include value="../inc2/footer_datatable.jsp"/> 
<s:include value="../inc2/footer_form.jsp"/> 
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