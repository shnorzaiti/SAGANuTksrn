<%-- 
    Document   : KutipanHarian
    Created on : Apr 11, 2014, 11:59:03 AM
    Author     : NurMuhammadAfzal
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
                <h3 class="panel-title">Proses Denda Lewat/Notis E/Waran F</h3>
            </div>
            <div class="panel-body" id="panel">
                <s:form cssClass="form-horizontal" namespace="/pemprosesan" action="saveDendaNotisWaranLink2">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><s:text name="dnw.proses"/> :</label>
                        <div class="col-sm-9">
                            <s:radio name="proses" list="prosesList" value="%{'N'}" listKey="lookupCode" listValue="lookupDesc" />
                        </div>                        
                    </div> 
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><s:text name="dnw.pilih"/> :</label>
                        <div class="col-sm-3">
                            <label>
                                <s:if test="pilihan.equals(\"1\")">
                                    <input type="radio" name="pilihan" id="pilihan1" value="1" checked="true" /> <s:text name="dnw.akaun"/>
                                </s:if>
                                <s:else>
                                    <input type="radio" name="pilihan" id="pilihan1" value="1" /> <s:text name="dnw.akaun"/>
                                </s:else>                                
                            </label>                                
                        </div>    
                        <div class="col-sm-7" id="akaun">
                            <div class="input-group">  
                                <span class="input-group-addon">Dari</span> 
                                <s:textfield id="AkaunDr" name="akaunDr" cssClass="form-control input-sm"/>
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
                                <s:textfield id="AkaunHg" name="akaunHgga" cssClass="form-control input-sm"/> 
                                <s:url var="urlAkaunHg" namespace="/" action="Akaun" escapeAmp="false">
                                    <s:param name="idAkaun">AkaunHg</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaunHg" />" data-height="100%" data-width="99.6%" data-target="#modalAkaun">
                                    <i class="fa fa-book"></i></span>
                            </div>
                            <span class="text-warning">
                                <s:fielderror><s:param>akaunDr</s:param> </s:fielderror>                           
                                        <br/>
                                <s:fielderror><s:param>akaunHgga</s:param> </s:fielderror>
                                    </span>  
                                </div>      
                            </div>                              
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-2">
                                    <label>
                                <s:if test="pilihan.equals(\"2\")">
                                    <input type="radio" name="pilihan" id="pilihan2" value="2" checked="true" /> <s:text name="dnw.jalan"/>
                                </s:if>
                                <s:else>
                                    <input type="radio" name="pilihan" id="pilihan2" value="2" /> <s:text name="dnw.jalan"/>                                        
                                </s:else>
                            </label>
                        </div>     
                        <div class="col-sm-2" id="jalan" style="visibility:hidden">                                   
                            <div class="input-group ">
                                <s:textfield id="JlkodDr"  name="jlnKod" cssClass="form-control input-sm"/>
                                <s:url var="urlJlkod" namespace="/" action="Jlkod" escapeAmp="false">
                                    <s:param name="idField">JlkodDr</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJlkod" />" data-height="550px" data-width="99.6%" data-target="#modalJlkod">
                                    <i class="fa fa-book"></i></span>
                            </div>
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
                            <span class="text-warning"><s:fielderror><s:param>jlnKod</s:param> </s:fielderror></span>  
                                </div>                          
                            </div>  
                            <div class="form-group">
                                <label class="col-sm-2 control-label"><s:text name="dnw.amaunHtg"/> :</label>
                        <div class="col-sm-5">
                            <div class="input-group input-large">   
                                <span class="input-group-addon">RM</span>
                                <s:textfield id="amaunDr" name="amaunDr" cssClass="form-control input-sm amount" maxLength="15"/>
                                <span class="input-group-addon">hingga</span>

                                <s:textfield id="amaunHgga" name="amaunHgga" cssClass="form-control input-sm amount" maxLength="15"/>
                                <span class="input-group-addon">RM</span>
                                <span class="text-warning"><s:fielderror><s:param>amaunDr</s:param> </s:fielderror></span>
                                <span class="text-warning"><s:fielderror><s:param>amaunHgga</s:param> </s:fielderror></span>
                                    </div>
                                </div>                        
                            </div> 
                            <div class="form-group">
                                <label class="col-sm-2 control-label"><s:text name="tarikh"/> :</label>
                        <div class="col-sm-3 form-inline">
                            <div class="input-group">
                                <s:textfield name="tarikh" cssClass="form-control input-sm datepicker" />                                   
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>

                            </div>
                            <span class="text-warning"><s:fielderror><s:param>tarikh</s:param></s:fielderror></span>  
                                </div>               
                            </div> 
                            <div class="form-group">
                                <label class="col-sm-2 control-label"><s:text name="tempoh"/> :</label>
                        <div class="col-sm-3 form-inline">
                            <div class="input-group">

                                <s:textfield id="tempohTksr" name="tempoh" cssClass="form-control input-sm datepicker"/>                                   
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>

                            </div>
                            <span class="text-warning"><s:fielderror><s:param>tempoh</s:param></s:fielderror></span>  
                                </div>
                            </div> 
                            <div class="operation-button">                        
                        <s:submit value="Proses Borang Ini" cssClass="proses"/>
                        <s:reset value="Isi Semula Borang Ini" cssClass="isisemula"/>
                    </div>
                </s:form>
            </div>
        </div>


        <%-- <s:include value="/sidebar-right.jsp"/>        
         <s:include value="/footer-table.jsp"/>
         <script>
             $(window).load(function() { // makes sure the whole site is loaded
                         $('#status').fadeOut(); // will first fade out the loading animation
                         $('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
                         $('body').delay(350).css({'overflow':'visible'});
                 });
         </script>
     </body>
 </html>--%>

        <script src="<%=request.getContextPath()%>/jscript/common.js"></script>
        <s:include value="../inc2/footer_form.jsp"/>
        <script>

            $(document).ready(function () {
                if ($("input[name='pilihan']:checked").val() == 1) {
                    $("#akaun").css({"visibility": "visible"});
                    $("#jalan").css({"visibility": "hidden"});
                } else {
                    $("#akaun").css({"visibility": "hidden"});
                    $("#jalan").css({"visibility": "visible"});

                }
            });


            $("input[name='pilihan']").click(function () {

                if ($("input[name='pilihan']:checked").val() == 1) {
                    $("#akaun").css({"visibility": "visible"});
                    $("#jalan").css({"visibility": "hidden"});
                } else {
                    $("#akaun").css({"visibility": "hidden"});
                    $("#jalan").css({"visibility": "visible"});

                }
            });
            function tempohBilTksr(data1)
            {
                $.getJSON("../TempohJson", {"passTkhLulus": data1, "passTempoh": "12"}, function (data) {
                    $("#tempohTksr").val(data.tkhTamat);
                });
            }
        </script>
