<%-- 
    Document   : analisaByrTarikhJln
    Created on : Mar 25, 2015, 12:58:25 PM
    Author     : ainyrusly
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
                <s:form cssClass="form-horizontal bucket-form" action="cetakAnalisaByrTarikhJlnLink2" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Pilihan :</label>
                        <div class="col-sm-9">
                            <label class="">
                                <input type="radio" name="param3" id="pilihan" value="1" onclick="carianBy()" > Tahun Semasa
                            </label>
                            <label class="">
                                <input type="radio" name="param3" id="pilihan" value="2" onclick="carianBy()" > Tahun Lepas
                            </label>

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Tarikh :</label>
                        <div class="col-sm-4">
                            <div class="input-group ">      
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <s:textfield name="param1" cssClass="form-control input-sm datepicker"/>    
                                <span class="input-group-addon">hingga</span>
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <s:textfield name="param2" cssClass="form-control input-sm datepicker"/>     
                            </div>
                            <span class="text-warning"><s:fielderror><s:param>param2</s:param> </s:fielderror></span>  
                            <span class="text-warning"><s:fielderror><s:param>param3</s:param> </s:fielderror></span>
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
                            <h4 class="modal-title" id="modalCetakLabel">Analisa Bayaran Mengikut Tarikh-Jln/Tmn/Kg</h4>
                        </div>
                        <div class="modal-body" style="zoom:0.80;">
                            <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="700px" width="100%" 
                                    frameborder="0" scrolling="yes"></iframe>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!-- CETAK (MODAL) -->