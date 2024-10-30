<%-- 
    Document   : BilTksir
    Created on : Apr 10, 2014, 11:48:41 AM
    Author     : Hafiz
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
                <s:form cssClass="form-horizontal" namespace="/pemprosesan" action="saveProsesBilLink2">

                    <div class="form-group" >
                        <label class="col-sm-2 control-label">No. Akaun :</label>
                        <div class="col-sm-7">                                                
                            <div class="input-group">
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
                            </div>    
                            <span class="req">
                                <s:fielderror><s:param>akaunDr</s:param> </s:fielderror>   
                                <s:fielderror><s:param>akaunHgga</s:param> </s:fielderror>
                                    </span>  
                                </div>      
                            </div>    


                            <div class="form-group" >
                                <label class="col-sm-2 control-label">Jalan/Taman/Kampung :</label>
                                <div class="col-sm-7">                                                
                                    <div class="input-group">
                                <s:textfield id="" name="param3" cssClass="form-control input-sm"/> 
                                <span class="input-group-addon">Hingga</span>
                                 <s:textfield id="" name="param4" cssClass="form-control input-sm"/> 
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Tarikh Bil Taksiran :</label>
                        <div class="col-sm-2 form-control-static">
                            <s:textfield cssClass="form-control has-feedback-right input-sm datepicker" name="param5" />
                            <span class="fa fa-calendar form-control-feedback right" aria-hidden="true"></span>

                            <span class="req"><s:fielderror><s:param>tarikhTksr</s:param></s:fielderror></span>  
                                </div>          
                            </div>                      
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Tempoh Bil Taksiran :</label>
                                <div class="col-sm-2 form-control-static">

                            <s:textfield cssClass="form-control has-feedback-right input-sm datepicker" id="tempohTksr" name="param6"  />
                            <span class="fa fa-calendar form-control-feedback right" aria-hidden="true"></span>

                            <span class="req"><s:fielderror><s:param>tempohTksr</s:param></s:fielderror></span>  
                                </div>               
                            </div>   
                            <!-- -->


                            <div class="form-group">
                                <div class="operation-button">                        
                            <s:submit cssClass="proses" value="Proses Borang Ini"/>
                            <s:reset cssClass="isisemula" value="Isi Semula Borang Ini"/>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
    </div> <!-- end panel-body -->
</div> <!-- end panel  -->


<script src="<%=request.getContextPath()%>/jscript/common.js"></script>
<s:include value="../inc2/footer_form.jsp"/>
