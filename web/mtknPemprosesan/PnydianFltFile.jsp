<%-- 
    Document   : PnydianFltFile
    Created on : Apr 10, 2014, 3:17:08 PM
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
                <h3 class="panel-title">penyedian flatfile</h3>
            </div>
            <div class="panel-body" id="panel">
                <s:form cssClass="form-horizontal" namespace="/pemprosesan" action="saveprocessFlatfileLink2">                
                    <div class="panel-body" id="panel"> 
                        <div class="x_content">
                            <div class="" role="tabpanel" data-example-id="togglable-tabs">
                                <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                    <li class="active">

                                        <s:a href="processFlatfileLink2">Bil Awal CTA</s:a>
                                        </li>

                                        <li>

                                        <s:a href="FlatFileELink2">Notis E</s:a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="form-group" style="display: none;">
                                    <label class="col-sm-2 control-label">Flatfile: :</label>
                                    <div class="col-sm-9">
                                        <label class="">
                                            <input type="radio" name="pilih" id="pilihan" value="1" checked="true"> Bil Awal CTA
                                        </label>
                                        <label class="">
                                            <input type="radio" name="pilih" id="pilihan" value="2"> Notis E
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Jenis Pelanggan</label>
                                    <div class="col-sm-3 form-control-static">
                                    <s:select id="jpkod" name="jpkod" headerKey="" list="dropList" listKey="LookupCode" headerValue="~~~PILIH PELANGGAN~~~" 
                                              listValue="LookupDesc" cssClass="form-control input-sm" title="Status"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Bil Rekod Per Flatfile </label>
                                <div class="col-sm-2">
                                    <s:textfield id="rekod" name="bilRekod" cssClass="form-control input-sm"/> 
                                </div>
                            </div>
                            <!--<div class="form-group">
                                <div class="col-sm-7">
                                    <font color="blue"><b>Flatfile yang diwujudkan akan dinamakan flatfile01.txt, flatfile02.txt, dan seterusnya mengikut bilangan rekod per flatfile yang dimaksudkan.</b></font>
                                </div>
                            </div>-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Pilihan Bil Awal CTA</label>
                                <div class="col-sm-4">
                                    <label class="">
                                        <input type="radio" name="rekod" id="pilihan" value="1"> Semua Pemilik
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <input type="radio" name="rekod" id="pilihan" value="2" checked="true"> Hanya Pemilik Mempunyai Amaun Melebihi
                                </div>
                                <div class="col-sm-3">
                                    <div class="input-group ">
                                        <span class="input-group-addon">RM</span>  
                                        <s:textfield id="amlbh" name="amlbh" cssClass="form-control input-sm"/>
                                        <s:hidden id="amlbh" name="tkhbl" cssClass="form-control input-sm"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <font color="red"><b>Sila Isi Medan-medan Di Atas Dan Klik Butang Proses. Proses Ini Akan Mengambil Masa Yang Lama</b></font>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="span4 offset4 text-center">                        
                                    <button id="button" type="submit" class="proses"></button>
                                </div>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div> <!-- end panel-body -->
        </div> <!-- end panel  -->
        <script src="<%=request.getContextPath()%>/jscript/common.js"></script> 
        <s:include value="../inc2/footer_form.jsp"/>
