<%-- 
    Document   : PnydianFltFileE
    Created on : Mar 26, 2018, 12:01:25 PM
    Author     : shahr
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
                <h3 class="panel-title">penyedian flatfile</h3>
            </div>
            <div class="panel-body" id="panel">
                <s:form cssClass="form-horizontal" namespace="/pemprosesan" action="saveFlatFileELink2">
                    <div class="panel-body" id="panel"> 
                        <div class="x_content">
                            <div class="" role="tabpanel" data-example-id="togglable-tabs">
                                <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                    <li>

                                        <s:a href="processFlatfileLink2">Bil Awal CTA</s:a>
                                        </li>

                                        <li class="active">

                                        <s:a href="FlatFileELink2">Notis E</s:a>
                                        </li>
                                    </ul>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Jenis Pelanggan</label>
                                    <div class="col-sm-3 form-control-static">
                                    <s:select id="jpkod" name="jpkod" headerKey="" list="jpkList" listKey="LookupCode" headerValue="~~~PILIH PELANGGAN~~~" 
                                              listValue="LookupDesc" cssClass="form-control input-sm" title="Status"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-2 control-label">Status: </label>
                                <div class="col-sm-3 form-control-static">
                                    <s:select id="status" name="status" headerKey="" list="dropList" listKey="LookupCode" headerValue="~~~PILIH STATUS~~~" 
                                              listValue="LookupDesc" cssClass="form-control input-sm" title="Status"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-2 control-label">Pilihan :</label>
                                <div class="col-sm-9">
                                    <label class="">
                                        <input type="radio" onclick=""  name="pilihan" id="akaun" value="1" > Akaun
                                    </label>
                                    <label class="">
                                        <input type="radio" onclick=""  name="pilihan" id="jalan" value="2" > Jalan
                                    </label>    
                                    <label class="">
                                        <input type="radio" name="pilihan" id="nolot" value="3" > No Lot
                                    </label>    
                                    <label class="">
                                        <input type="radio" name="pilihan" id="rjfil" value="4" > Rujukan Fail
                                    </label>    
                                </div>  
                            </div>

                            <div class="form-group" id="akaune" style="display: none" >
                                <label class="col-sm-2 control-label">No. Akaun :</label>
                                <div class="col-sm-7">                                                
                                    <div class="input-group">
                                        <s:textfield id="" name="akaun1" cssClass="form-control input-sm"/> 
                                        <span class="input-group-addon">Hingga</span>
                                        <s:textfield id="" name="akaun2" cssClass="form-control input-sm"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group" id="jalane" style="display: none" >
                                <label class="col-sm-2 control-label">Jalan :</label>
                                <div class="col-sm-7">                                                
                                    <div class="input-group">
                                        <s:textfield id="" name="mnjln1" cssClass="form-control input-sm"/> 
                                        <span class="input-group-addon">Hingga</span>
                                        <s:textfield id="" name="mnjln2" cssClass="form-control input-sm"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group" id="nolote" style="display: none" >
                                <label class="col-sm-2 control-label">No Lot :</label>
                                <div class="col-sm-7">                                                
                                    <div class="input-group">
                                        <s:textfield id="" name="nolot1" cssClass="form-control input-sm"/> 
                                        <span class="input-group-addon">Hingga</span>
                                        <s:textfield id="" name="nolot2" cssClass="form-control input-sm"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group" id="rjfile" style="display: none" >
                                <label class="col-sm-2 control-label">No Rujukan Fail :</label>
                                <div class="col-sm-7">                                                
                                    <div class="input-group">
                                        <s:textfield id="" name="rjfil1" cssClass="form-control input-sm"/> 
                                        <span class="input-group-addon">Hingga</span>
                                        <s:textfield id="" name="rjfil2" cssClass="form-control input-sm"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="span4 offset4 text-center">                        
                                    <button id="button" type="submit" class="proses"></button>
                                </div>
                            </div>

                            <script type="text/javascript">
                                $(function () {
                                    $("input[name='pilihan']").click(function () {
                                        if ($("#akaun").is(":checked")) {
                                            $("#akaune").show();
                                        } else {
                                            $("#akaune").hide();
                                        }
                                        if ($("#jalan").is(":checked")) {
                                            $("#jalane").show();
                                        } else {
                                            $("#jalane").hide();
                                        }
                                        if ($("#nolot").is(":checked")) {
                                            $("#nolote").show();
                                        } else {
                                            $("#nolote").hide();
                                        }
                                        if ($("#rjfil").is(":checked")) {
                                            $("#rjfile").show();
                                        } else {
                                            $("#rjfile").hide();
                                        }
                                    });
                                });
                            </script>

                        </s:form>
                    </div>
                </div>
            </div> <!-- end panel-body -->
        </div> <!-- end panel  -->
        <script src="<%=request.getContextPath()%>/jscript/common.js"></script> 
        <s:include value="../inc2/footer_form.jsp"/>

