<%-- 
    Document   : pengumuranThunan
    Created on : Apr 16, 2015, 12:18:26 PM
    Author     : farisazri
--%>

<%@ taglib prefix = "s" uri="/struts-tags"%>
<s:include value="../inc2/head_form.jsp"/>
<!--main content starts here-->
<div class="row">
    <div class="col-lg-12">
        <div class="alert alert-success" id="infoMessage" style="display: none;"></div>
        <s:if test="hasActionMessages() || hasActionErrors()">
            <div id="panelUmum pnl" class="panel-body">   
                <!-- messages & error -->
                <s:if test="hasActionMessages()">
                    <div class="alert alert-success">
                        <a href="#" class="close" data-dismiss="alert"><i class="fa fa-times-circle"></i></a>
                            <s:actionmessage/>
                    </div>
                </s:if>
                <s:if test="hasActionErrors()">
                    <div class="alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert"><i class="fa fa-times-circle"></i></a>
                            <s:actionerror/>                                
                    </div>

                </s:if>                                      
                <!-- end messages & error -->    
            </div>
        </s:if>  
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <i class="fa" id="toggle"></i>
                </span>
                <h3 class="panel-title"><s:property value="bcName"/></h3>
            </div>
            <div class="panel-body" id="panel">
                <s:form cssClass="form-horizontal bucket-form" action="savePengumuranThunanLink2" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Pilihan :</label>
                        <div class="col-sm-10">                      
                            <label class="">
                                <input type="radio" name="reportName" value="httl35" onclick="carianBy()" checked="true" > Pengumuran
                            </label>
                            &nbsp;
                            <label class="">
                                <input type="radio" name="reportName" value="httl36" onclick="carianBy()" > Rosot Nilai
                            </label>                    
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">No. Akaun:</label>
                        <div class="col-sm-7">                                                
                            <div class="input-group ">
                                <span class="input-group-addon">Dari</span>
                                <s:textfield id="AkaunDr" name="param1" cssClass="form-control input-sm"/> 
                                <s:url var="urlAkaun" namespace="/" action="Akaun" escapeAmp="false">
                                    <s:param name="idAkaun">AkaunDr</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaun" />" data-height="100%" data-width="99.6%" data-target="#modalAkaun">
                                    <i class="fa fa-book"></i></span>
                                <div class="modal fade bs-example-modal-lg" id="modalAkaun" tabindex="-1" role="dialog"  aria-labelledby="modalAkaunLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="modalAkaunLabel"><s:text name="Senarai Akaun"/> </h4>
                                            </div>
                                            <div class="modal-body">
                                                <iframe id="akaunFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal-dialog -->
                                </div>
                                <span class="input-group-addon">Hingga</span>
                                <s:textfield id="AkaunHg" name="param2" cssClass="form-control input-sm"/> 
                                <s:url var="urlAkaunHg" namespace="/" action="Akaun" escapeAmp="false">
                                    <s:param name="idAkaun">AkaunHg</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaunHg" />" data-height="100%" data-width="99.6%" data-target="#modalAkaun">
                                    <i class="fa fa-book"></i></span>
                                    <%--div class="modal fade bs-example-modal-lg" id="modalAkaunHg" tabindex="-1" role="dialog"  aria-labelledby="modalAkaunHgLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title" id="modalAkaunHgLabel"><s:text name="Senarai Akaun"/> </h4>
                                                </div>
                                                <div class="modal-body">
                                                    <iframe id="akaunFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                                </div>
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dialog -->
                                    </div>--%>
                            </div>
                            <span class="text-warning"><s:fielderror><s:param>param1</s:param> </s:fielderror></span>  
                            <span class="text-warning"><s:fielderror><s:param>param2</s:param> </s:fielderror></span>  
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Kod Jalan :</label>
                                <div class="col-sm-7">                                                
                                    <div class="input-group ">
                                        <span class="input-group-addon">Dari</span>
                                <s:textfield id="JlkodDr" name="param3" cssClass="form-control input-sm"/> 
                                <s:url var="urlJlkod" namespace="/" action="Jlkod" escapeAmp="false">
                                    <s:param name="idField">JlkodDr</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJlkod" />" data-height="550px" data-width="99.6%" data-target="#modalJlkod">
                                    <i class="fa fa-book"></i></span>
                                <div class="modal fade bs-example-modal-lg" id="modalJlkod" tabindex="-1" role="dialog"  aria-labelledby="modalJalanLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="modalJalanLabel"><s:text name="Senarai Jalan"/> </h4>
                                            </div>
                                            <div class="modal-body">
                                                <iframe id="jalanFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal-dialog -->
                                </div>  
                                <span class="input-group-addon">Hingga</span>
                                <s:textfield id="JlkodHg" name="param4" cssClass="form-control input-sm"/> 
                                <s:url var="urlJlkodHg" namespace="/" action="Jlkod" escapeAmp="false">
                                    <s:param name="idField">JlkodHg</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJlkodHg" />" data-height="550px" data-width="99.6%" data-target="#modalJlkod">
                                    <i class="fa fa-book"></i></span>

                            </div>
                            <span class="text-warning"><s:fielderror><s:param>param3</s:param> </s:fielderror></span>  
                            <span class="text-warning"><s:fielderror><s:param>param4</s:param> </s:fielderror></span>  
                                </div>

                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Kod Hartanah :</label>
                                <div class="col-sm-7">                                                
                                    <div class="input-group ">   
                                        <span class="input-group-addon">Dari</span>   
                                <s:textfield id="Htkod" name="param5" cssClass="form-control input-sm"/>
                                <s:url var="urlHtkod" namespace="/laporan" action="popHtkod" escapeAmp="false"/>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlHtkod" />" data-height="450px" data-width="99.6%" data-target="#modalHtkod">
                                    <i class="fa fa-book"></i></span>
                                <div class="modal fade bs-example-modal-lg" id="modalHtkod" tabindex="-1" role="dialog"  aria-labelledby="modalHtkodLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="modalHtkodLabel"><s:text name="Senarai Kod dan Nama Lokasi"/> </h4>
                                            </div>
                                            <div class="modal-body">
                                                <iframe id="akaunFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal-dialog -->
                                </div>
                                <span class="input-group-addon">Hingga</span>
                                <s:textfield id="HtkodHg" name="param6" cssClass="form-control input-sm"/> 
                                <s:url var="urlHtkodHg" namespace="/laporan" action="popHtkodHg" escapeAmp="false"/>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlHtkodHg" />" data-height="100%" data-width="99.6%" data-target="#modalHtkodHg">
                                    <i class="fa fa-book"></i></span>
                                <div class="modal fade bs-example-modal-lg" id="modalHtkodHg" tabindex="-1" role="dialog"  aria-labelledby="modalHtkodHgLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="modalHtkodHgLabel"><s:text name="Senarai Kod dan Nama Lokasi"/> </h4>
                                            </div>
                                            <div class="modal-body">
                                                <iframe id="akaunFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal-dialog -->
                                </div>
                            </div>
                            <span class="text-warning"><s:fielderror><s:param>param3</s:param> </s:fielderror></span>  
                            <span class="text-warning"><s:fielderror><s:param>param4</s:param> </s:fielderror></span>  
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Amaun Tunggakkan :</label>
                                <div class="col-sm-7">                                                
                                    <div class="input-group ">
                                        <span class="input-group-addon">Dari</span>
                                        <span class="input-group-addon">RM</span>
                                <s:textfield id="AmaunDr" name="param7" cssClass="form-control input-sm"/>
                                <span class="input-group-addon">Hingga</span>
                                <span class="input-group-addon">RM</span>
                                <s:textfield id="AmaunHg" name="param8" cssClass="form-control input-sm"/>
                            </div>
                        </div>
                    </div>

                    <s:if test="kumpPengguna.equals(\"PENYELIA\")"> 
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Format Laporan :</label>
                            <div class="col-sm-2 form-control-static"> 
                                <s:select name="reportFormat" headerValue="~PILIH~" headerKey="" list="formatList" listKey="LookupCode" listValue="LookupDesc" cssClass="form-control input-sm" title="Format Laporan"/>
                            </div>
                        </div> 
                    </s:if>
                    <s:if test="kumpPengguna.equals(\"ADMIN\")"> 
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Format Laporan :</label>
                            <div class="col-sm-2 form-control-static"> 
                                <s:select name="reportFormat" headerValue="~PILIH~" headerKey="" list="formatList" listKey="LookupCode" listValue="LookupDesc" cssClass="form-control input-sm" title="Format Laporan"/>
                            </div>
                        </div> 
                    </s:if>


                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <s:submit value="Cetak" cssClass="btn btn-primary"/>   
                            <s:reset value="Isi Semula" cssClass="btn btn-danger"/>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/jscript/common.js"></script>
<s:include value="../inc2/footer_form.jsp"/>

<s:if test="stsCetak != null">
    <s:if test="stsCetak.equals(\"Y\")">
        <script type="text/javascript">
                                    $(window).load(function () {
                                        $('#modalCetak').modal('show');
                                    });
        </script>
    </s:if>
</s:if>
<!-- CETAK (MODAL) -->  
<div class="modal fade" id="modalCetak" tabindex="-1" role="dialog"  aria-labelledby="modalCetakLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" style="width: 100%; height: 100%; padding: 0">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalCetakLabel">Pengumuran Tahunan</h4>
            </div>
            <div class="modal-body" style="zoom:0.80;">
                <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="700px" width="100%" 
                        frameborder="0" scrolling="yes"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- CETAK (MODAL) -->
