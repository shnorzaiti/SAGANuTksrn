<%-- 
    Document   : makHtgPemilik
    Created on : Mar 30, 2015, 11:35:04 AM
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
                <s:form cssClass="form-horizontal bucket-form" action="cetakMakHtgPemilikLink2" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Pilihan :</label>
                        <div class="col-sm-10">
                            <s:if test="reportName.equals(\"htts26a\")">
                                <input type="radio" name="reportName" id="pilihan" value="htts26a" onclick="carianBy()" checked="true"> No. Akaun
                            </s:if>
                            <s:else>
                                <input type="radio" name="reportName" id="pilihan" value="htts26a" onclick="carianBy()" > No. Akaun
                            </s:else>
                            <s:if test="reportName.equals(\"htts26b\")">
                                <input type="radio" name="reportName" id="pilihan" value="htts26b" onclick="carianBy()" checked="true"> Mukim
                            </s:if>
                            <s:else>
                                <input type="radio" name="reportName" id="pilihan" value="htts26b" onclick="carianBy()"> Mukim
                            </s:else>
                        </div>
                    </div>
                    <s:if test="reportName.equals(\"htts26a\")">
                        <div id="akaun" style="display:block">
                        </s:if>
                        <s:else>
                            <div id="akaun" style="display:none">
                            </s:else>
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
                                </div>

                        <s:if test="reportName.equals(\"htts26b\")">
                            <div id="jalan" style="display:block">
                            </s:if>
                            <s:else>
                                <div id="jalan" style="display:none">
                                </s:else>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Kod Jalan  :</label>
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
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Amaun :</label>
                                        <div class="col-sm-7">
                                            <div class="input-group ">   
                                        <span class="input-group-addon">RM</span>
                                        <s:textfield name="param5" cssClass="form-control input-sm"/>    
                                        <span class="input-group-addon">Hingga</span>
                                        <span class="input-group-addon">RM</span>
                                        <s:textfield name="param6" cssClass="form-control input-sm"/>     
                                    </div>
                                    <span class="text-warning"><s:fielderror><s:param>param5</s:param> </s:fielderror></span>  
                                    <span class="text-warning"><s:fielderror><s:param>param6</s:param> </s:fielderror></span>
                                        </div>
                                    </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Saiz Cetakan :</label>
                                    <div class="col-sm-7 form-control-static">
                                        <s:if test="reportSize.equals(\"1\")">
                                            <input type="radio" name="reportSize" id="reportSize" value="1" checked="true"> A3
                                        </s:if>
                                        <s:else>
                                            <input type="radio" name="reportSize" id="reportSize" value="1"> A3
                                        </s:else>
                                        <s:if test="reportSize.equals(\"2\")">
                                            <input type="radio" name="reportSize" id="reportSize" value="2" checked="true"> A4
                                        </s:if>
                                        <s:else>
                                            <input type="radio" name="reportSize" id="reportSize" value="2"> A4
                                        </s:else>
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
        <script>
            function carianBy() {
                var pilih;
                var radios = document.getElementsByName('reportName');

                for (var i = 0; i < radios.length; i++) {
                    var aRadio = radios[i];

                    if (aRadio.checked) {
                        pilih = aRadio.value;
                        break;
                    }
                }
                if (pilih === 'htts26a') {
                    document.getElementById('akaun').style.display = "block";
                    document.getElementById('jalan').style.display = "none";

                } else if (pilih === 'htts26b') {
                    document.getElementById('akaun').style.display = "none";
                    document.getElementById('jalan').style.display = "block";
                }
                document.getElementById('AkaunDr').style.display = "";
                document.getElementById('AkaunHg').style.display = "";
                document.getElementById('JlkodDr').style.display = "";
                document.getElementById('JlkodHg').style.display = "";
            }
        </script>
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
                        <h4 class="modal-title" id="modalCetakLabel">Maklumat Hutang - Pemilik</h4>
                    </div>
                    <div class="modal-body" style="zoom:0.80;">
                        <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="700px" width="100%" 
                                frameborder="0" scrolling="yes"></iframe>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!-- CETAK (MODAL) -->


