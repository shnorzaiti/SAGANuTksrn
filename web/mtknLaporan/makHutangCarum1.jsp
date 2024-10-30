<%-- 
    Document   : makHutangCarum
    Created on : Mar 23, 2015, 11:44:48 AM
    Author     : farisazri
--%>

<%@ taglib prefix = "s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="panel">
    <div id="infoMessage" style="display: none;"></div>
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

    <header class="panel-heading">
        Maklumat Hutang Harta Carum Bantu Kadar
        <span class="tools pull-right">
            <a class="fa tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle"></a>                            
        </span>
    </header>
    <div class="panel-body" id="panel">
        <s:form cssClass="form-horizontal bucket-form" action="" method="post">
            <div class="form-group">
                <label class="col-sm-2 control-label">Kod Jabatan:</label>
                <div class="col-sm-2">                                                
                    <div class="input-group ">      
                        <s:textfield id="JbtnDr" name="param1" cssClass="form-control input-sm"/>
                        <s:url var="urlJbtnDr" namespace="/laporan" action="popJbtn" escapeAmp="false"/>
                        <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJbtnDr" />" data-height="100%" data-width="99.6%" data-target="#modalJbtnDr">
                            <i class="fa fa-book"></i></span>
                        <div class="modal fade bs-example-modal-lg" id="modalJlkod" tabindex="-1" role="dialog"  aria-labelledby="modalJbtnDrLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="modalJbtnDrLabel"><s:text name="Senarai Kod dan Nama Jabatan"/> </h4>
                                    </div>
                                    <div class="modal-body">
                                        <iframe id="akaunFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal-dialog -->
                        </div>
                    </div>
                    <span class="text-warning"><s:fielderror><s:param>param1</s:param> </s:fielderror></span>   
                        </div>

                        <div class="form-group">
                            <div class="col-sm-7">
                        <s:textfield id="JbtnDr" cssClass="form-control input-sm"/>
                    </div>
                </div>
                    
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <s:submit value="Cetak" cssClass="btn btn-primary"/>   
                    <s:reset value="Isi Semula" cssClass="btn btn-danger"/>
                </div>
            </div>
        </s:form>
    </div>
</section>
<script src="<%=request.getContextPath()%>/jscript/common.js"></script>
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
                <h4 class="modal-title" id="modalCetakLabel">Daftar Mohon</h4>
            </div>
            <div class="modal-body" style="zoom:0.80;">
                <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="700px" width="100%" 
                        frameborder="0" scrolling="yes"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- CETAK (MODAL) -->