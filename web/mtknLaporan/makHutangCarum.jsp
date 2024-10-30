<%-- 
    Document   : makHutangCarum
    Created on : Mar 23, 2015, 11:44:48 AM
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
                <s:form cssClass="form-horizontal bucket-form" action="cetakMakHutangCarumLink2" method="post">
                    <div class="form-group" style="height: 100px;">
                        <label class="col-sm-2 control-label">Jabatan :</label>
                        <div class="col-sm-2">
                            <div class="input-group">  
                                <s:textfield cssClass="form-control input-sm" id="JAbjbkod" name="param1"  cssErrorClass="decoratedErrorField" onblur="reloadMaklCBK(this.value)"/>
                                <s:url var="urlJabatan" namespace="/pemprosesan" action="Jabatan" escapeAmp="false">
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJabatan" />" data-height="100%" data-width="99.6%" data-target="#modalJabatan">
                                    <i class="fa fa-book"></i></span>
                            </div>
                            <span class="req"><s:fielderror><s:param>param1</s:param> </s:fielderror></span>
                                    <div id="infoKodJabatan" style="display: none;"></div>
                                    <div class="modal fade" id="modalJabatan" tabindex="-1" role="dialog"  aria-labelledby="modalJabatanLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title" id="modalJabatanLabel">Senarai Jabatan</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <iframe id="akaunFrame" frameborder="0" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                                </div>
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dialog -->
                                    </div><!-- /.modal -->
                                    <!-- CETAK (MODAL) -->
                                </div>
                                <div class="col-sm-5 form-control-static"> 
                                    <div id="JAbjnama">
                                        <strong>
                                    <s:property value="jabt.jabJnama" escape="false"/><br/>
                                    <s:property value="jabt.JabAlam1" escape="false"/><br/>
                                    <s:property value="jabt.JabAlam2" escape="false"/><br/>
                                    <s:property value="jabt.JabAlam3" escape="false"/><br/>
                                    <s:property value="jabt.JabAlam4" escape="false"/>
                                </strong>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button type="submit" class="cetak"></button>
                            <button type="reset" class="isisemula"></button>
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
                <h4 class="modal-title" id="modalCetakLabel">Maklumat Hutang - Harta Caruman Bantu Kadar</h4>
            </div>
            <div class="modal-body" style="zoom:0.80;">
                <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="700px" width="100%" 
                        frameborder="0" scrolling="yes"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- CETAK (MODAL) -->
