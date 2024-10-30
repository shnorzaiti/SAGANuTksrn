<%-- 
    Document   : bilCukaiTaksir
    Created on : Mar 31, 2015, 10:57:34 AM
    Author     : ainyrusly
--%>

<%@taglib prefix = "s" uri="/struts-tags"%>
<s:include value="../inc2/head_form.jsp"/>

<div class="row">
    <div class="col-lg-12">
        <div class="alert alert-success" id="infoMessage" style="display: none;"></div>
        <s:if test="hasActionMessages() || hasActionErrors()">
            <div id="panelUmum" class="panel-body">   
                <!-- messages & error -->
                <s:if test="hasActionMessages()">
                    <div class="alert alert-success">
                        <a href="#" class="close" data-dismiss="alert">×</a>
                        <s:actionmessage/>
                    </div>
                </s:if>
                <s:if test="hasActionErrors()">
                    <div class="alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert">×</a>
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
                    <i class="fa fa-arrows-alt"></i>
                </span>
                <h3  class="panel-title">Bil Cukai Taksiran</h3>
            </div>
            <div class="panel-body" id="panel">
                <s:form cssClass="form-horizontal bucket-form" action="cetakBilCukaiTaksirLink2" method="post">
                    <%--div class="form-group">
                        <label class="col-sm-2 control-label">Cetakan :</label>
                        <div class="col-sm-9">
                            <label class="">
                                <input type="radio" name="reportExt" id="pilihan" value="bcode" onclick="carianBy()" > Pre-printed (Laser)
                            </label>
                            <label class="">
                                <input type="radio" name="reportExt" id="pilihan" value="a4" onclick="carianBy()"> Taksiran (A4)
                            </label>
                        </div>
                    </div--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Bil :</label>
                        <div class="col-sm-9">
                            <s:if test="reportName.equals(\"htpblm_a4\")">
                                <label class="">
                                    <input type="radio" name="reportName" id="pilihan" value="htpblm_a4" onclick="carianBy()" checked="true"> Bil Cukai Taksiran - Asal Salinan
                                </label>                                
                            </s:if>
                            <s:else>
                                <label class="">
                                    <input type="radio" name="reportName" id="pilihan" value="htpblm_a4" onclick="carianBy()" > Bil Cukai Taksiran - Asal Salinan
                                </label>                                
                            </s:else>                            
                            <s:if test="reportName.equals(\"httblm_a4\")">
                                <label class="">
                                    <input type="radio" name="reportName" id="pilihan" value="httblm_a4" onclick="carianBy()" checked="true"> Bil Cukai Taksiran - Terkini
                                </label>                                
                            </s:if>
                            <s:else>
                                <label class="">
                                    <input type="radio" name="reportName" id="pilihan" value="httblm_a4" onclick="carianBy()" > Bil Cukai Taksiran - Terkini
                                </label>                                
                            </s:else>
                            <s:if test="reportName.equals(\"htawal_a4\")">
                                <label class="">
                                    <input type="radio" name="reportName" id="pilihan" value="htawal_a4" onclick="carianBy()" checked="true"> Bil Cukai Taksiran - Bil Awal
                                </label>     
                            </s:if>
                            <s:else>
                                <label class="">
                                    <input type="radio" name="reportName" id="pilihan" value="htawal_a4" onclick="carianBy()"> Bil Cukai Taksiran - Bil Awal
                                </label>     
                            </s:else>     
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">No. Akaun :</label>
                        <div class="col-sm-7">                                                
                            <div class="input-group ">
                                <span class="input-group-addon">Dari</span>
                                <s:textfield id="AkaunDr" name="param1" cssClass="form-control input-sm"/> 
                                <s:url var="urlAkaun" namespace="/" action="Akaun" escapeAmp="false">
                                    <s:param name="idAkaun">AkaunDr</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaun" />" data-height="100%" data-width="99.6%" data-target="#modalAkaun">
                                    <i class="fa fa-book"></i></span>
                                <span class="input-group-addon">Hingga</span>
                                <s:textfield id="AkaunHg" name="param2" cssClass="form-control input-sm"/> 

                                <s:url var="urlAkaunHg" namespace="/" action="Akaun" escapeAmp="false">
                                    <s:param name="idAkaun">AkaunHg</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaunHg" />" data-height="100%" data-width="99.6%" data-target="#modalAkaun">
                                    <i class="fa fa-book"></i></span>
                            </div>
                            <span class="text-warning"><s:fielderror><s:param>param1</s:param> </s:fielderror></span>  
                            <span class="text-warning"><s:fielderror><s:param>param2</s:param> </s:fielderror></span>  
                                </div>

                            </div>
                    <%--div class="modal fade bs-example-modal-lg" id="modalAkaunHg" tabindex="-1" role="dialog"  aria-labelledby="modalAkaunHgLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="modalAkaunHgLabel"><s:text name="Senarai Akaun"/> </h4>
                        </div>
                        <div class="modal-body">
                            <iframe id="akaunFrame" frameborder="0" scrolling="yes" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div--%>
                    <div class="modal fade bs-example-modal-lg" id="modalAkaun" tabindex="-1" role="dialog"  aria-labelledby="modalAkaunLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="modalAkaunLabel"><s:text name="Senarai Akaun"/> </h4>
                                </div>
                                <div class="modal-body">
                                    <iframe id="akaunFrame" frameborder="0" scrolling="yes" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                </div>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal-dialog -->
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

                            <div class="form-group" >
                                <label class="col-sm-2 control-label" > Amaun Hutang :</label>
                                <div class="col-sm-7">
                                    <div class="input-group">
                                        <span class="input-group-addon">Dari</span>
                                        <span class="input-group-addon">RM</span>
                                <s:textfield id="" name="param5" cssClass="form-control input-sm"/>
                                <span class="input-group-addon"> Hingga </span>
                                <span class="input-group-addon">RM</span>
                                <s:textfield id="" name="param6" cssClass="form-control input-sm"/>

                            </div>
                            <span class="text-warning"><s:fielderror><s:param>param5</s:param> </s:fielderror></span>  
                            <span class="text-warning"><s:fielderror><s:param>param6</s:param> </s:fielderror></span>

                                </div>      

                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">Poskod :</label>
                                <div class="col-sm-7">                                                
                                    <div class="input-group ">
                                        <span class="input-group-addon">Dari</span>
                                <s:textfield id="poskdDr" name="param7" cssClass="form-control input-sm"/> 
                                <s:url var="urlPoskd" namespace="/laporan" action="popPoskod" escapeAmp="false">
                                    <s:param name="idField">poskdDr</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlPoskd" />" data-height="100%" data-width="99.6%" data-target="#modalPoskd">
                                    <i class="fa fa-book"></i></span>
                                <span class="input-group-addon">Hingga</span>
                                <s:textfield id="poskdHg" name="param8" cssClass="form-control input-sm"/> 
                                <s:url var="urlPoskdHg" namespace="/laporan" action="popPoskod" escapeAmp="false">
                                    <s:param name="idField">poskdHg</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlPoskdHg" />" data-height="100%" data-width="99.6%" data-target="#modalPoskd">
                                    <i class="fa fa-book"></i></span>

                            </div>
                            <span class="text-warning"><s:fielderror><s:param>param7</s:param> </s:fielderror></span>  
                            <span class="text-warning"><s:fielderror><s:param>param8</s:param> </s:fielderror></span>  
                                </div>
                            </div>
                            <div class="modal fade bs-example-modal-lg" id="modalPoskd" tabindex="-1" role="dialog"  aria-labelledby="modalPoskdLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="modalPoskdLabel"><s:text name="Senarai Poskod"/> </h4>
                                </div>
                                <div class="modal-body">
                                    <iframe id="akaunFrame" frameborder="0" scrolling="yes" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                </div>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal-dialog -->
                    </div>

                    <div class="form-group">
                        <div class="operation-button"> 
                            <button type="submit" class="cetak"></button>
                            <button type="reset" class="isisemula" onclick="javascript:location.href = 'BilCukaiTaksirLink2';"></button>
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
                <h4 class="modal-title" id="modalCetakLabel">Bil Cukai Taksiran - 
                    <s:if test="reportName.equals(\"htpblm_\")">Asal Salinan</s:if>
                    <s:elseif test="reportName.equals(\"htpblm_\")">Terkini</s:elseif>
                    <s:else>Bil Awal</s:else>
                    <s:if test="reportExt.equals(\"bcode\")">(Pre-printed (Laser))</s:if>
                    <s:else>(Taksiran (A4))</s:else>
                    </h4>
                </div>
                <div class="modal-body" style="zoom:0.80;">
                    <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="700px" width="100%" 
                        frameborder="0" scrolling="yes"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- CETAK (MODAL) -->


