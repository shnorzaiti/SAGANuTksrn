<%-- 
    Document   : SelengaraKaveat
    Created on : Mar 21, 2019, 3:42:23 PM
    Author     : shahr
--%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%--@taglib prefix="sj" uri="/struts-jquery-tags"--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<s:include value="../inc2/head_form.jsp"/> 

<div class="row">
    <div class="col-lg-12"> 
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
        <s:if test="layout.equals(\"frame\")">
            <s:set name="urlAkaun">2FrameSelenggaraKaveat</s:set>        
        </s:if>
        <s:else>
            <s:set name="urlAkaun">SelenggaraKaveatLink2</s:set>        
        </s:else>

        <s:form cssClass="form-horizontal " action="save%{#urlAkaun}" namespace="tanya">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Selenggara Kaveat</h3>
                </div>
                <div class="panel-body" id="panel" >
                    <div class="form-group">
                        <label class="col-sm-2 control-label">no. akaun :</label>
                        <div class="col-sm-4"> 
                            <s:hidden name="module"/>
                            <div class="input-group">  
                                <span class="input-group-addon"><s:property value="PelMklumatPgangan.pvdModin"/></span>
                                <s:textfield id="lulAkaun" name="PelMklumatPgangan.pegAkaun" cssClass="form-control input-sm" onblur="reloadMaklumat(this.form,'%{#urlAkaun}')" title="%{getText('makl.noAkaun')}" cssErrorClass="decoratedErrorField"/>                               
                                <span class="input-group-addon"><s:property value="PelMklumatPgangan.pegDigit"/></span>
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">no. akaun lama :</label>
                        <div class="col-sm-4">
                            <b><s:property value="PelMklumatPgangan.pegOldac == null?'-':PelMklumatPgangan.pegOldac"/></b>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">no. K/P / pendaftaran :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pmkPlgid == null?'-':PelMklumatPgangan.pmkPlgid"/></b>
                        </div>  
                        <label class="col-sm-2 control-label">status pegangan :</label>
                        <div class="col-sm-4 form-control-static">
                            <s:if test="PelMklumatPgangan.PegStatf.equals(\"AKTIF\")">
                                <span class="label label-info"><s:property value="PelMklumatPgangan.PegStatf"/></span>                                     
                            </s:if>
                            <s:elseif test="PelMklumatPgangan.PegStatf.equals(\"ANSURAN\")">
                                <span class="label label-success"><s:property value="PelMklumatPgangan.PegStatf"/></span>                                     
                            </s:elseif>
                            <s:else>
                                <span class="label label-danger"><s:property value="PelMklumatPgangan.PegStatf"/></span>  
                            </s:else>
                        </div> 
                    </div>
                    <s:if test="PelMklumatPgangan.pegStcbk.equals(\"Y\")">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">nama jabatan :</label>
                            <div class="col-sm-4 form-control-static">                            
                                <b><s:property value="PelMklumatPgangan.jabJnama == null?'-':PelMklumatPgangan.jabJnama"/></b>
                            </div>
                            <label class="col-sm-2 control-label">jenis cukai :</label>
                            <div class="col-sm-2 form-control-static">                            
                                <b><s:property value="PelMklumatPgangan.trxInama == null?'-':PelMklumatPgangan.trxInama"/></b>                            
                            </div>
                            <div class="col-sm-1 form-control-static">
                                <span class="label label-info">Sumbangan Membantu Kadar</span>  
                            </div>
                        </div>
                    </s:if>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">nama pemilik :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pmkNmbil == null?'-':PelMklumatPgangan.pmkNmbil"/></b>
                        </div>
                        <label class="col-sm-2 control-label">bangsa :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pvdWkbgsa == null?'-':PelMklumatPgangan.pvdWkbgsa"/></b>
                        </div> 
                    </div>
                    <div class="form-group">    
                        <label class="col-sm-2 control-label">alamat pemilik :</label>
                        <div class="col-sm-4 form-control-static">
                            <b>
                                <s:property value="PelMklumatPgangan.pvdAlmt1" escape="false"/><br/>
                                <s:property value="PelMklumatPgangan.pvdAlmt2" escape="false"/><br/>
                                <s:property value="PelMklumatPgangan.pvdAlmt3" escape="false"/><br/>
                                <s:property value="PelMklumatPgangan.pvdAlmt4"/>
                            </b>
                        </div>
                        <label class="col-sm-2 control-label">alamat harta :</label>
                        <div class="col-sm-4 form-control-static">
                            <b>
                                <s:property value="PelMklumatPgangan.adpg1" escape="false"/><br/>
                                <s:property value="PelMklumatPgangan.adpg2" escape="false"/><br/>
                                <s:property value="PelMklumatPgangan.adpg3" escape="false"/><br/>
                                <s:property value="PelMklumatPgangan.adpg4"/>
                            </b>
                        </div>                                   
                    </div> 



                    <br><br> 
                    <div class="form-group"> 

                        <div class="form-group">                  
                            <label class="col-sm-2 control-label">Status Bil :</label>
                            <div class="col-sm-2 form-control-static">
                                <b><s:property value="PelMklumatPgangan.pegStatf == null?'-':PelMklumatPgangan.pegStatf"/></b>
                            </div>
                            <label class="col-sm-2 control-label">Status Kaveat :</label>
                            <div class="col-sm-4 form-control-static">
                                <s:if test="PelMklumatPgangan.PegStkvt.equals(\"YA\") || PelMklumatPgangan.PegStkvt.equals(\"TIDAK\")">
                                    <span class="label label-danger"><s:property value="PelMklumatPgangan.PegStkvt"/></span>                                     
                                </s:if>
                                <s:else>
                                   <s:property value="PelMklumatPgangan.PegStkvt == null?'-':PelMklumatPgangan.PegStkvt"/></span>  
                                </s:else>
                            </div>                            
                        </div> 

                        <%--<div class="btn-group pull-right col-lg-offset-10">
                            <button class="cetakPilih" id="2" data-toggle="dropdown"></button>
                            <ul class="dropdown-menu pull-right"> 
                                <s:url var="urlBilTerkini" namespace="/report" action="cetak" escapeAmp="false">
                                    <s:param name="reportName">httblm_a4</s:param>
                                    <s:param name="param1" value="PelMklumatPgangan.pegAkaun"/> 
                                    <s:param name="param2" value="PelMklumatPgangan.pegAkaun"/>
                                    <s:param name="param3" value="PelMklumatPgangan.pegJlkod"/>
                                    <s:param name="param4" value="PelMklumatPgangan.pegJlkod"/>
                                    <s:param name="param5" value="PelMklumatPgangan.pnyBaki == null ? \"0\":PelMklumatPgangan.pnyBaki.replaceAll(\",\",\"\")"/>
                                    <s:param name="param6" value="PelMklumatPgangan.pnyBaki == null ? \"0\":PelMklumatPgangan.pnyBaki.replaceAll(\",\",\"\")"/>
                                    <s:param name="param7" value="PelMklumatPgangan.jlnPskod"/>
                                    <s:param name="param8" value="PelMklumatPgangan.jlnPskod"/>
                                    <s:param name="onama" value="%{userModel.userId}"/>
                                </s:url> 
                                <li><a class="modalButton" data-toggle="modal" data-src="<s:property value="#urlBilTerkini" />" 
                                       data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false" data-label="Bil Terkini">Bil Terkini</a></li>

                            </ul>
                        </div> 
                    </div>--%>

                    <div class="adv-table editable-table col-lg-offset-1 col-sm-10">
                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                            <s:iterator begin="1" end="5"  status="tahunSts">     
                                <s:set name="thnSms" ><s:property value="thnPilihan"/></s:set>
                                <s:set name="thn" ><s:property value="%{#attr.TAHUN - #tahunSts.index}"/></s:set>
                                <s:set name="thnIndex" ><s:property value="%{#tahunSts.index}"/></s:set>
                                <s:url var="maklUrl" action="%{#urlAkaun}" escapeAmp="false">
                                    <s:param name="PelMklumatPgangan.pegAkaun" value="PelMklumatPgangan.pegAkaun" />
                                    <s:param name="thnPilihan" value="#thn" />
                                    <s:param name="pytStats" value="#thnIndex" />
                                    <s:param name="module" value="module"/>
                                </s:url>
                                <s:if test="#thnSms.equals(#thn)">
                                    <li role="presentation" class="active"><s:a href="%{maklUrl}#panel3"><s:property value="thn"/></s:a></li>
                                    </s:if> 
                                    <s:else>
                                    <li role="presentation"><s:a href="%{maklUrl}#panel3"><s:property value="thn"/></s:a></li>
                                    </s:else>
                                </s:iterator>
                        </ul>
                        <div id="suratSenarai" class="tab-content">
                            <div  class="tab-pane fade active in">


                                <table class="table table-bordered table-condensed table-responsive table-striped display" id="dynamic-table">
                                    <thead>
                                        <tr>
                                            <th>Tarikh</th>
                                            <th>Status Bil</th>
                                            <th>Bil / Resit</th>
                                            <th>Keterangan</th>
                                            <th>Bil (RM)</th>
                                            <th>Resit (RM)</th>      
                                            <th>Baki (RM)</th>                               
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- BYE 25/09/2014 -->
                                        <s:if test="pnyataAkaunList.size() == 0">
                                            <tr>
                                                <td colspan="5" align="center">Tiada rekod.</td>
                                            </tr>

                                        </s:if>
                                        <!-- BYE 25/09/2014 -->
                                        <s:else>
                                            <s:iterator value="pnyataAkaunList" var="pnyataAkaunVar">
                                                <tr>
                                                    <td><s:property value="PYtwtkhbl"/> </td>
                                                    <td><s:property value="PYtstatf" /></td> 
                                                    <td><s:property value="PYtnobil" /></td>    
                                                    <td><s:property value="PYtketer" /></td>                                   
                                                    <td align="right"><s:property value="PYtwdbamn == '0.00' ? '-':PYtwdbamn" /></td>
                                                    <td align="right"><s:property value="PYtcramn == '0.00' ? '-':PYtcramn" /></td> 
                                                    <td align="right"><s:property value="baki"/></td>                                   </tr>
                                                </s:iterator>     
                                            </s:else>
                                    </tbody>
                                    <s:if test="pnyataAkaunList.size() != 0">
                                        <tfoot>            
                                            <tr style="background-color: #53A7D5; font-weight: bold;">
                                                <td colspan="4" style="text-align: right">Jumlah (RM)</td>
                                                <td align="right"><s:property value="pnyataAkaun.PYtwdbamn" /></td>
                                                <td align="right">(<s:property value="pnyataAkaun.PYtcramn" />)</td>           
                                                <td align="right"><s:property value="pnyataAkaun.Baki" /></td>

                                            </tr>
                                        </tfoot>
                                    </s:if>
                                </table>
                            </div> 
                        </div>
                        <br><br>
                        <div class="form-group">
                            <div id="butang" class="operation-button" >                        
                                <!-- BUTTON WITH NOTIFICATION --> 
                                <button type="submit" class="simpan confirm" data-msg="<s:text name="mesej.simpan"/>"></button>
                                <button type="reset" class="batal"></button>
                            </div>
                        </s:form>
                    </div>
                    <script src="<%=request.getContextPath()%>/jscript/common.js"></script>
                    <script src="<%=request.getContextPath()%>/props2/js/bs-modal-fullscreen.js"></script>
                    <s:include value="../inc2/footer_form.jsp"/>
                    <s:include value="../inc2/footer_datatable.jsp"/>
                    <!-- CETAK (MODAL) -->  
                    <div class="modal fade modal-fullscreen" id="modalCetak" tabindex="-1" role="dialog"  aria-labelledby="modalCetakLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg" style="width: 100%; height: 100%; padding: 0">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="$('#cetakFrame').attr('src', '');">&times;</button>
                                    <h4 class="modal-title" id="modalLabel">Maklumat Taksiran</h4>
                                </div>
                                <div class="modal-body" style="zoom:0.80;">
                                    <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="100%" width="100%" 
                                            frameborder="0" scrolling="yes"></iframe>
                                </div>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal-dialog -->
                    </div><!-- /.modal -->
                    <!-- CETAK (MODAL) -->