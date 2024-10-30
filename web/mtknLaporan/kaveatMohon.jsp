<%-- 
    Document   : kaveatMohon
    Created on : Jun 17, 2019, 1:47:17 PM
    Author     : Bai
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
                <h3  class="panel-title">Senarai Pemohonan Kaveat</h3>
            </div>
            <div class="panel-body" id="panel">
                <s:form cssClass="form-horizontal bucket-form" action="cetakMohonKaveatLink2" method="post">
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
                        <label class="col-sm-2 control-label">Tarikh :</label>
                        <div class="col-sm-7">                                                
                            <div class="input-group ">
                                <span class="input-group-addon">Dari</span>
                                <s:textfield id="TarikhDr" name="param3" cssClass="form-control input-sm datepicker"/> 
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                <span class="input-group-addon">Hingga</span>
                                <s:textfield id="TarikhHg" name="param4" cssClass="form-control input-sm datepicker"/> 
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                            </div>
                            <span class="text-warning"><s:fielderror><s:param>param3</s:param> </s:fielderror></span>  
                            <span class="text-warning"><s:fielderror><s:param>param4</s:param> </s:fielderror></span>  
                                </div>

                            </div>
                            <div class="form-group">
                                <div class="operation-button"> 
                                    <button type="submit" class="cetak"></button>
                                    <button type="reset" class="isisemula" onclick="javascript:location.href = 'MohonKaveatLink2';"></button>
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
                <h4 class="modal-title" id="modalCetakLabel">Senarai Pemohonan Kaveat</h4>
            </div>
            <div class="modal-body" style="zoom:0.80;">
                <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="700px" width="100%" 
                        frameborder="0" scrolling="yes"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- CETAK (MODAL) -->