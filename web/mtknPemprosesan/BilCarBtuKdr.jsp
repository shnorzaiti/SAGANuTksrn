<%-- 
    Document   : BilCarBtuKdr
    Created on : Apr 10, 2014, 12:50:20 PM
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
                <s:form id="BilCBKForm" cssClass="form-horizontal " namespace="pemprosesan" action="saveBilCBKLink2" method="post">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Jabatan :</label>
                        <div class="col-sm-2">
                            <div class="input-group">  
                                <s:textfield cssClass="form-control input-sm" id="JAbjbkod" name="jabt.jabJbkod"  cssErrorClass="decoratedErrorField" onblur="reloadMaklJabt(this.value)"/>
                                <s:url var="urlJabatan" namespace="/pemprosesan" action="Jabatan" escapeAmp="false">
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJabatan" />" data-height="100%" data-width="99.6%" data-target="#modalJabatan">
                                    <i class="fa fa-book"></i></span>
                            </div>
                            <span class="req"><s:fielderror><s:param>jabt.jabJbkod</s:param> </s:fielderror></span>
                                    <div class="modal fade" id="modalJabatan" tabindex="-1" role="dialog"  aria-labelledby="modalJabatanLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title" id="modalBankPtbakiLabel">Senarai Jabatan</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <iframe id="akaunFrame" frameborder="0" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                                </div>
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dialog -->
                                    </div><!-- /.modal -->
                                    <!-- CETAK (MODAL) -->
                                </div>
                        <%--<div class="col-sm-5"> 
                            <div id="infoKodJabatan" style="display: none;"></div>   
                        </div>--%>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Alamat :</label>
                        <div class="col-sm-5">
                            <div id="JAbjnama">
                                <p class="form-control-static">
                                    <strong><s:property value="jabt.jabJnama" escape="false"/> </strong>
                                </p> 
                            </div>
                            <%--<s:property value="HLjabt.JAbalam1" escape="false"/>, <s:property value="HLjabt.JAbalam2" escape="false"/>, <s:property value="HLjabt.JAbalam3" escape="false"/>, <s:property value="HLjabt.JAbalam4" escape="false"/>--%>

                        </div>
                    </div>    
                    <div class="form-group" >
                        <label class="col-sm-2 control-label">Tarikh Bil CBK :</label>
                        <div class="col-sm-3 form-inline">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <s:textfield name="tarikhCBK" cssClass="form-control input-sm datepicker" onblur="tempohBilTksr(this.value);"/>                                   

                            </div>
                            <span class="text-warning"><s:fielderror><s:param>tarikhCBK</s:param></s:fielderror></span>  
                                </div>  
                                <label class="col-sm-2 control-label">Tempoh Bil CBK :</label>
                                <div class="col-sm-3 form-inline">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <s:textfield id="tempohTksr" name="tempohCBK"  cssClass="form-control input-sm datepicker"/>                                   

                            </div>
                            <span class="text-warning"><s:fielderror><s:param>tempohCBK</s:param></s:fielderror></span>  
                                </div>            
                            </div> 
                            <div class="form-group">
                                <div class="operation-button">                        
                            <s:submit cssClass="proses" value="Proses Borang Ini"/>
                            <s:reset cssClass="isisemula" value="Isi Semula"/>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>






        <%--<s:include value="/sidebar-right.jsp"/>     
        <s:include value="/footer-form.jsp"/>
        <script>
            $(window).load(function() { // makes sure the whole site is loaded
                        $('#status').fadeOut(); // will first fade out the loading animation
                        $('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
                        $('body').delay(350).css({'overflow':'visible'});
                });
        </script>
        </body>
        </html>--%>
        <script>
            function reloadMaklJabt(data)
            {
                //$('#butangNiaga').show();
                $('#infoKodJabatan').hide();
                $.getJSON("MaklJabtJson", {"passData": data}, function (data) {
                    $('#JAbjbkod').val(data.jabt.jabJbkod);

                    if (data.jabt.jabJnama === null) {
                        $('#JAbjnama').html('<strong>-</strong>');
                        $info = "<p class='text-info'>Kod Jabatan tidak sah.</p>";
                        $('#infoKodJabatan').html($info);
                        $('#infoKodJabatan').show();
                        //$('#butangNiaga').hide();
                    } else {
                        $('#JAbjnama').html('<strong>' + data.jabt.jabJnama + '</strong>');
                    }

                });
            }
            function tempohBilTksr(data1)
            {
                $.getJSON("../TempohJson", {"passTkhLulus": data1, "passTempoh": "12"}, function (data) {
                    $("#tempohTksr").val(data.tkhTamat);
                });
            }
        </script>
        <script src="<%=request.getContextPath()%>/jscript/common.js"></script>
