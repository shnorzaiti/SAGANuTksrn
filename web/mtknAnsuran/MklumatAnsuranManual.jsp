<%-- 
    Document   : MklumatAnsuran
    Created on : Jul 7, 2014, 3:35:53 PM
    Author     : NurMuhammadAfzal & MohammadHafiz
--%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <i class="fa" id="toggle"></i>
                </span>
                <h3 class="panel-title">maklumat akaun</h3>
            </div>
            <div class="panel-body" id="panel">
                <s:form cssClass="form-horizontal bucket-form" namespace="/ansuran" action="AnsuranLink2">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">no. akaun:</label>
                        <div class="col-sm-4">
                            <div class="input-group">
                                <span class="input-group-addon" id="pvdModin">T</span>
                                <s:textfield id="PEgakaun" cssClass="form-control input-sm" name="HVnduk4.pegAkaun" cssErrorClass="decoratedErrorField" onblur="reloadMaklumat(this.form,'AnsuranLink2')"/>
                                <span class="input-group-addon" id="mjaDigitText"><s:property value="HVnduk4.pegDigit"/></span>
                                <s:url var="urlAkaun" namespace="/"  action="Akaun" escapeAmp="false">
                                    <s:param name="idAkaun">PEgakaun</s:param>
                                </s:url>
                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaun" />" data-height="100%" data-width="99.6%" data-target="#modalAkaun">
                                    <i class="fa fa-book" style="cursor: pointer;"></i></span>
                            </div>  
                            <span class="req"><s:fielderror><s:param>maklUmum.PEgakaun</s:param> </s:fielderror></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">nama pemilik:</label>
                                <div class="col-sm-4 form-control-static">                            
                                    <b><s:property value="HVnduk4.pvdPnama" escape="false"/>   </b>
                        </div>
                        <label class="col-sm-2 control-label">status :</label>
                        <div class="col-sm-4 form-control-static">
                            <s:if test="HVnduk4.pegStatf.equals(\"AKTIF\")">
                                <span class="label label-info"><s:property value="HVnduk4.pegStatf"/></span>                                     
                            </s:if>
                            <s:else>
                                <span class="label label-danger"><s:property value="HVnduk4.pegStatf"/></span>  
                            </s:else>
                        </div> 
                    </div> 
                    <div class="form-group">
                        <label class="col-sm-2 control-label">alamat pemilik:</label>
                        <div class="col-sm-4 form-control-static">                  
                            <b>
                                <s:property value="HVnduk4.pvdAlmt1" escape="false"/>   </br>
                                <s:property value="HVnduk4.pvdAlmt2" escape="false"/>   </br>
                                <s:property value="HVnduk4.pvdAlmt3" escape="false"/>   </br>
                                <s:property value="HVnduk4.pvdAlmt4" escape="false"/> 
                            </b>
                        </div>

                    </div><s:if test="!HVnduk4.pegAkaun.equals(\"\")">

                        <div id="penyata" class="adv-table editable-table col-lg-offset-1 col-sm-10">
                            <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                <s:iterator begin="1" end="5"  status="tahunSts">     
                                    <s:set name="thnSms" ><s:property value="thnPilihan"/></s:set>
                                    <s:set name="thn" ><s:property value="%{#attr.TAHUN - #tahunSts.index}"/></s:set>
                                    <s:set name="thnIndex" ><s:property value="%{#tahunSts.index}"/></s:set>
                                    <s:url var="maklUrl" action="AnsuranLink2" escapeAmp="false">
                                        <s:param name="HVnduk4.pegAkaun" value="HVnduk4.pegAkaun" />
                                        <s:param name="thnPilihan" value="#thn" />
                                        <s:param name="pytStats" value="#thnIndex" />
                                    </s:url>
                                    <s:if test="#thnSms.equals(#thn)">
                                        <li role="presentation" class="active"><s:a href="%{maklUrl}#penyata"><s:property value="thn"/></s:a></li>
                                        </s:if> 
                                        <s:else>
                                        <li role="presentation"><s:a href="%{maklUrl}#penyata"><s:property value="thn"/></s:a></li>
                                        </s:else>
                                    </s:iterator>
                            </ul>

                            <div id="suratSenarai" class="tab-content">
                                <div  class="tab-pane fade active in">
                                    <table class="table table-bordered table-condensed table-responsive table-striped display">
                                        <thead>
                                            <tr>
                                                <th>Tarikh</th>
                                                <th>Status Bil</th>
                                                <th>Bil / Resit</th>
                                                <th>Keterangan</th>
                                                <th>Bil (RM)</th>
                                                <th>Resit (RM)</th>       
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
                                                    </tr>
                                                </s:iterator>     
                                            </s:else>
                                        </tbody>
                                        <s:if test="pnyataAkaunList.size() != 0">
                                            <tfoot>            
                                                <tr style="background-color: #53A7D5; font-weight: bold;">
                                                    <td colspan="4" style="text-align: right">Jumlah (RM)</td>
                                                    <td align="right"><s:property value="pnyataAkaun.PYtwdbamn" /></td>
                                                    <td align="right">(<s:property value="pnyataAkaun.PYtcramn" />)</td>
                                                </tr>
                                                <tr style="background-color: #53A7D5; font-weight: bold;">                   
                                                    <th colspan="4" style="text-align: right">Baki (RM)</th>                                 
                                                    <td colspan="2" align="right"><s:property value="pnyataAkaun.Baki" /></td>
                                                </tr>
                                            </tfoot>
                                        </s:if>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </s:if>
                </s:form>
            </div>
        </div>

        <s:if test="!HVnduk4.pegAkaun.equals(\"\") && HVnduk4.pegStatf.equals(\"AKTIF\") && (@java.lang.Double@parseDouble(pnyataAkaun.baki.replaceAll(\",\", \"\")) > 0)">
            <div class="x_content">
                <div class="" role="tabpanel" data-example-id="togglable-tabs">
                    <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                        <li>
                            <s:a href="AnsuranLink2?HVnduk4.pegAkaun=%{HVnduk4.pegAkaun}">Automatik</s:a>
                            </li>

                            <li class="active">

                            <s:a href="#">Manual</s:a>
                            </li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div role="tabpanel" class="tab-pane fade active in" id="tab_content3" aria-labelledby="home-tab"> 

                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <span class="pull-right panel-options">
                                            <i class="fa" id="toggle3"></i>
                                        </span>
                                        <h3 class="panel-title">permohonan ansuran (Manual)</h3>
                                    </div>
                                    <div class="panel-body" id="panel3">
                                    <s:form id="formManual" cssClass="form-horizontal bucket-form" namespace="/ansuran" action="saveManualLink2">
                                        <div class="form-group">                     
                                            <label class="col-sm-2  control-label">Tarikh Mohon :</label>
                                            <div class="col-sm-2 form-control-static"> 
                                                <s:if test="stsUpd.equals(\"Y\")">
                                                    <b><s:property value="bilAns.in1Tdate"/></b>
                                                </s:if>
                                                <s:else>
                                                    <s:textfield cssClass="form-control has-feedback-right input-sm datepicker" name="bilAns.in1Tdate" cssErrorClass="decoratedErrorField"/>
                                                    <span class="fa fa-calendar form-control-feedback right" aria-hidden="true"></span>
                                                </s:else>                       
                                            </div>
                                            <label class="col-sm-2  col-sm-offset-2 control-label">anggota majlis :</label>
                                            <div class="col-sm-1 form-control-static">
                                                <s:if test="stsUpd.equals(\"Y\")">
                                                    <b><s:property value="bilAns.in1Stang == null ? '-' : bilAns.in1Stang" escape="false"/></b>
                                                </s:if>
                                                <s:else>
                                                    <s:if test="bilAns.in1Stang != null">  
                                                        <s:if test="bilAns.in1Stang.equals(\"Y\")">                                    
                                                            <s:checkbox name="bilAns.in1Stang" value="true" cssClass="form-control"  />
                                                        </s:if>
                                                        <s:else>
                                                            <s:checkbox name="bilAns.in1Stang" cssClass="form-control"/>
                                                        </s:else>                              
                                                    </s:if>
                                                    <s:else>  
                                                        <s:checkbox id="majlis" name="bilAns.in1Stang" cssClass="form-control" onclick="maklNoPekerja()"/>
                                                    </s:else>       
                                                </s:else>
                                            </div>
                                        </div>
                                        <div class="form-group">                  
                                            <%--label class="col-sm-2 control-label">Bil. Ansuran :</label>
                                            <div class="col-sm-2 form-control-static">
                                                <s:if test="stsUpd.equals(\"Y\")">
                                                    <b><s:property value="bilAns.in1Jmseq"/> kali</b>
                                                </s:if>
                                                <s:else>
                                                    <div class="input-group ">
                                                        <s:textfield name="bilAns.in1Jmseq" cssClass="form-control input-sm"/>
                                                        <span class="input-group-addon">Kali</span>
                                                    </div>
                                                </s:else>
                                            </div--%>
                                            <div id="pekerja" style="display:none">
                                                <label class="col-sm-2 col-sm-offset-6 control-label">pekerja : </label>
                                                <div class="col-sm-2 form-control-static">
                                                    <s:if test="stsUpd.equals(\"Y\")">
                                                        <b><s:property value="bilAns.in1Nopek == null ? '-' : bilAns.in1Nopek"/></b>
                                                    </s:if>
                                                    <s:else>                        
                                                        <div class="input-group ">      
                                                            <s:url var="urlPenyelia" namespace="/"  action="Pegawai" escapeAmp="false"/>
                                                            <s:textfield id="pneKppek" name="bilAns.in1Nopek" cssClass="form-control input-sm"/>
                                                            <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlPenyelia" />" data-height="100%" data-width="99.6%" data-target="#modalAkaun" data-label="Senarai Pekerja"><i class="fa fa-book"></i></span>
                                                        </div>
                                                    </s:else>
                                                    <s:hidden name="HVnduk4.pegAkaun"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">              
                                            <label class="col-sm-2 control-label">Baki :</label>
                                            <div class="col-sm-3 form-control-static">
                                                <b>RM <s:property value="pnyataAkaun.baki"/></b>
                                            </div>
                                        </div> 
                                        <br/>
                                        <br/>
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <span class="pull-right panel-options">
                                                    <i class="fa" id="toggle4"></i>
                                                </span>
                                                <h3 class="panel-title">Pecahan Bayaran Ansuran</h3>
                                            </div>
                                            <div class="panel-body" id="panel4">
                                                <table id="ansuranTable" class="table" id="models">
                                                    <thead> 
                                                        <tr>
                                                            <th rowspan="2">Tarikh</th>
                                                            <th colspan="2">Cukai Taksiran</th>  
                                                            <th colspan="2">Denda</th>
                                                            <th colspan="2">Notis E</th>
                                                            <th colspan="2">Waran F</th>    
                                                                <%--th colspan="2">Lain - Lain</th--%>   
                                                            <th rowspan="2">Jumlah <br/>(RM)</th>
                                                        </tr> 
                                                        <tr>
                                                            <th>Semasa <br/>(RM)</th>                            
                                                            <th>Tunggakan <br/>(RM)</th>
                                                            <th>Semasa <br/>(RM)</th>                            
                                                            <th>Tunggakan <br/>(RM)</th>
                                                            <th>Semasa <br/>(RM)</th>                            
                                                            <th>Tunggakan <br/>(RM)</th>
                                                            <th>Semasa <br/>(RM)</th>                            
                                                            <th>Tunggakan <br/>(RM)</th>
                                                                <%--th>Semasa <br/>(RM)</th>                            
                                                                <th>Tunggakan <br/>(RM)</th--%>
                                                        </tr>

                                                    </thead>
                                                    <tbody>
                                                        <tr valign="right"> 
                                                            <td>
                                                                <s:textfield cssClass="form-control input-sm datepicker" id="HLins2List[0].in2Trikh" name="HLins2List[0].in2Trikh" title="Tarikh" onkeydown="return tab(this, event)"  onblur="if (this.value.length == 0) {delLineTable('ansuranTable','0','ans');}" />  
                                                                <span class="req"><s:fielderror><s:param>HLins2List[0].in2Trikh</s:param> </s:fielderror></span>
                                                                    </td>
                                                                    <td>
                                                                <s:textfield cssClass="form-control input-sm amount" id="HLins2List[0].in2Ctsms" name="HLins2List[0].in2Ctsms" title="Cukai Taksiran Semasa" onkeydown="return tab(this, event)" onblur="if (this.value != '') {calculateTarikh(0); calculateTotal();}" />  
                                                                <span class="req"><s:fielderror><s:param>HLins2List[0].in2Ctsms</s:param> </s:fielderror></span>
                                                                    </td>                                
                                                                    <td>
                                                                <s:textfield cssClass="form-control input-sm amount" id="HLins2List[0].in2Cttgk" name="HLins2List[0].in2Cttgk" title="Cukai Taksiran Tunggakan" onkeydown="return tab(this, event)" onblur="if (this.value != '') {calculateTarikh(0); calculateTotal();}" />  
                                                                <span class="req"><s:fielderror><s:param>HLins2List[0].in2Cttgk</s:param> </s:fielderror></span>
                                                                    </td>
                                                                    <td>
                                                                <s:textfield cssClass="form-control input-sm amount" id="HLins2List[0].in2Dnsms" name="HLins2List[0].in2Dnsms" title="Denda Semasa" onkeydown="return tab(this, event)" onblur="if (this.value != '') {calculateTarikh(0); calculateTotal();}" />  
                                                                <span class="req"><s:fielderror><s:param>HLins2List[0].in2Dnsms</s:param> </s:fielderror></span>
                                                                    </td>
                                                                    <td>
                                                                <s:textfield cssClass="form-control input-sm amount" id="HLins2List[0].in2Dntgk" name="HLins2List[0].in2Dntgk" title="Denda Tunggakan" onkeydown="return tab(this, event)" onblur="if (this.value != '') {calculateTarikh(0); calculateTotal();}" />  
                                                                <span class="req"><s:fielderror><s:param>HLins2List[0].in2Dntgk</s:param> </s:fielderror></span>
                                                                    </td>
                                                                    <td>
                                                                <s:textfield cssClass="form-control input-sm amount" id="HLins2List[0].in2Ntsms" name="HLins2List[0].in2Ntsms" title="Notis E Semasa" onkeydown="return tab(this, event)" onblur="if (this.value != '') {calculateTarikh(0); calculateTotal();}" />  
                                                                <span class="req"><s:fielderror><s:param>HLins2List[0].in2Ntsms</s:param> </s:fielderror></span>
                                                                    </td>
                                                                    <td>
                                                                <s:textfield cssClass="form-control input-sm amount" id="HLins2List[0].in2Nttgk" name="HLins2List[0].in2Nttgk" title="Notis E Tunggakan" onkeydown="return tab(this, event)" onblur="if (this.value != '') {calculateTarikh(0); calculateTotal();}"/>  
                                                                <span class="req"><s:fielderror><s:param>HLins2List[0].in2Nttgk</s:param> </s:fielderror></span>
                                                                    </td>
                                                                    <td>
                                                                <s:textfield cssClass="form-control input-sm amount" id="HLins2List[0].in2Wrsms" name="HLins2List[0].in2Wrsms" title="Waran F Semasa" onkeydown="return tab(this, event)" onblur="if (this.value != '') {calculateTarikh(0); calculateTotal();}"/>  
                                                                <span class="req"><s:fielderror><s:param>HLins2List[0].in2Wrsms</s:param> </s:fielderror></span>
                                                                    </td>
                                                                    <td>
                                                                <s:textfield cssClass="form-control input-sm amount" id="HLins2List[0].in2Wrtgk" name="HLins2List[0].in2Wrtgk" title="Waran F Tunggakan"  onkeydown="var a = tab(this, event); if(a === false) {document.getElementById('HLins2List[0].plus').focus()}" onblur="if (this.value != '') {calculateTarikh(0); calculateTotal();}"/>  
                                                                <span class="req"><s:fielderror><s:param>HLins2List[0].in2Wrtgk</s:param> </s:fielderror></span>
                                                                    </td>
                                                            <%--td>
                                                                <s:property value="in2Lnsms"/>
                                                            </td>
                                                            <td>
                                                                <s:property value="in2Lntgk"/>
                                                            </td--%>
                                                            <td align="right">
                                                                <s:div id="HLins2List[0].jumlahTarikh" ><strong><s:property value="jumlah"/></strong></s:div>
                                                                </td>
                                                                <td align="right"><a id="HLins2List[0].plus" onkeydown="cloneAnsuran();" onclick="cloneAnsuran();" href="#panelKutipan"><i class="fa fa-plus  tooltips" title="Tambah Baris" alt="tambah" data-placement="top" data-toggle="tooltip"></i></a>&nbsp;</td>
                                                            </tr>
                                                        </tbody>
                                                        <tfoot>
                                                            <tr style="background-color: #53A7D5; font-weight: bold;">
                                                                <td><b>Jumlah (RM)</b></td>
                                                                <td align="right">
                                                                    <strong><div id="totalCtsms"><s:property value="Ansuran.in2Ctsms"/></div></strong>
                                                            </td>      
                                                            <td align="right">
                                                                <strong><div id="totalCttgk"><s:property value="Ansuran.in2Cttgk"/></div></strong>
                                                            </td>
                                                            <td align="right">
                                                                <strong><div id="totalDnsms"><s:property value="Ansuran.in2Dnsms"/></div></strong>
                                                            </td>
                                                            <td align="right">
                                                                <strong><div id="totalDntgk"><s:property value="Ansuran.in2Dntgk"/></div></strong>
                                                            </td>
                                                            <td align="right">
                                                                <strong><div id="totalNtsms"><s:property value="Ansuran.in2Ntsms"/></div></strong>
                                                            </td>
                                                            <td align="right">
                                                                <strong><div id="totalNttgk"><s:property value="Ansuran.in2Nttgk"/></div></strong>
                                                            </td>
                                                            <td align="right">
                                                                <strong><div id="totalWrsms"><s:property value="Ansuran.in2Wrsms"/></div></strong>
                                                            </td>
                                                            <td align="right">
                                                                <strong><div id="totalWrtgk"><s:property value="Ansuran.in2Wrtgk"/></div></strong>
                                                            </td>
                                                            <%--td align="right">
                                                            <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Lnsms"/></strong></s:div>
                                                            </td>
                                                            <td align="right">
                                                            <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Lntgk"/></strong></s:div>
                                                            </td--%>
                                                            <td align="right">

                                                                <strong><div id="grandTotalText"><s:property value="Ansuran.jumlah"/></div></strong>
                                                                    <s:hidden id="grandTotal" name="Ansuran.jumlah"/>
                                                                    <s:hidden id="baki" name="pnyataAkaun.baki"/>
                                                            </td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                                            </div>
                                        </div>
                                        <s:if test="!stsUpd.equals(\"Y\")"> 
                                            <div id="butang" class="operation-button">
                                                <button id="simpan" type="submit" class="simpan confirm" data-msg="<s:text name="mesej.simpan"/>" formId="formManual"></button>
                                                <button type="reset" value="reset" class="batal" onclick="javascript:location.href = 'AnsuranLink2';"></button>
                                            </div>
                                        </s:if>
                                    </s:form> 
                                </div>
                            </div> 
                            <%--<div class="span4 offset4 text-center">   
                                <s:reset value="Kembali" cssClass="btn btn-danger" onclick="javascript:history.go(-1);"/>
                            </div>--%>
                        </div>
                    </div>
                </div>
            </div>
        </s:if>
    </div>
</div>
<script src="<%=request.getContextPath()%>/jscript/common.js"></script>
<s:include value="../inc2/footer_form.jsp"/> 
<script>


                                                    function cloneAnsuran() {
                                                        $("input.datepicker").datetimepicker("destroy");
                                                        $("#ansuranTable tbody tr:last")
                                                                .clone(true)
                                                                .appendTo("#ansuranTable")
                                                                .each(function () {
                                                                    var index = $("#ansuranTable tbody tr:last").index();
                                                                    $(this).find("input:text").each(function () {
                                                                        this.name = this.name.replace(/\[(\d+)\]/g, '[' + (index) + ']');
                                                                        this.id = this.id.replace(/\[(\d+)\]/g, '[' + (index) + ']');
                                                                        this.value = "";
                                                                    });

                                                                    $(this).find("div,a[id$='plus']").each(function () {
                                                                        this.id = this.id.replace(/\[(\d+)\]/g, '[' + (index) + ']');
                                                                    });
                                                                    $(this).find("div[id$='jumlahTarikh']").html("");

                                                                    $(this).find("input[name$='in2Trikh']")
                                                                            .attr('onblur', 'if (this.value.length == 0) {delLineTable(\'ansuranTable\',\'' + (index + 2) + '\',\'ans\');} ')
                                                                            .focus();

                                                                    $(this).find("input[name$='in2Ctsms'], input[name$='in2Cttgk'], input[name$='in2Dnsms'],input[name$='in2Dntgk'],input[name$='in2Ntsms'],input[name$='in2Nttgk'],input[name$='in2Wrsms']")
                                                                            .attr('onblur', 'if (this.value != \'\') {calculateTarikh(' + (index) + '); calculateTotal();}');


                                                                    $(this).find("input[name$='in2Wrtgk']")
                                                                            .attr('onkeydown', "var a = tab(this, event); if(a === false) {document.getElementById('HLins2List[" + (index) + "].plus').focus()}")
                                                                            .attr('onblur', 'if (this.value != \'\') {calculateTarikh(' + (index) + '); calculateTotal();}');


                                                                    $(this).find("a[id$='trash']").remove();
                                                                    $(this).find("td:last").append('<a id="kutipList[' + (index) + '].trash" href="#" onclick="javascript:$(this).closest(\'tr\').remove();"><i class="fa fa-trash-o  tooltips" title="Padam Baris" alt="delete" ></i></a>');
                                                                });
                                                        goToByScroll("ansuranTable tbody tr:last td:last");

                                                        $('.datepicker').datetimepicker({
                                                            lang: 'ms',
                                                            format: 'd/m/Y',
                                                            formatTime: 'H:i',
                                                            formatDate: 'd/m/Y',
                                                            timepicker: false,
                                                            mask: false,
                                                            scrollMonth: false,
                                                            scrollInput: false

                                                        });
                                                    }


                                                    function delLineTable(tableId, row, sts) {

                                                        if (row !== '0') {
                                                            var table = document.getElementById(tableId);

                                                            table.deleteRow(row);

                                                            /*  if (sts === 'bayar') {
                                                             document.getElementById('bayarList[0].byrKcbyr').focus();
                                                             } else */
                                                            if (sts === 'ans') {
                                                                console.log("ROW:" + row);
                                                                document.getElementById('simpan').focus();
                                                            }
                                                        }
                                                    }

                                                    function calculateTarikh(indexRow) {

                                                        var amaunCtsms = parseFloat($('#HLins2List\\[' + indexRow + '\\]\\.in2Ctsms').val().replace(/,/g, '') || 0);
                                                        var amaunCttgk = parseFloat($('#HLins2List\\[' + indexRow + '\\]\\.in2Cttgk').val().replace(/,/g, '') || 0);
                                                        var amaunDnsms = parseFloat($('#HLins2List\\[' + indexRow + '\\]\\.in2Dnsms').val().replace(/,/g, '') || 0);
                                                        var amaunDntgk = parseFloat($('#HLins2List\\[' + indexRow + '\\]\\.in2Dntgk').val().replace(/,/g, '') || 0);
                                                        var amaunNtsms = parseFloat($('#HLins2List\\[' + indexRow + '\\]\\.in2Ntsms').val().replace(/,/g, '') || 0);
                                                        var amaunNttgk = parseFloat($('#HLins2List\\[' + indexRow + '\\]\\.in2Nttgk').val().replace(/,/g, '') || 0);
                                                        var amaunWrsms = parseFloat($('#HLins2List\\[' + indexRow + '\\]\\.in2Wrsms').val().replace(/,/g, '') || 0);
                                                        var amaunWrtgk = parseFloat($('#HLins2List\\[' + indexRow + '\\]\\.in2Wrtgk').val().replace(/,/g, '') || 0);
                                                        var jumlah = 0;
                                                        jumlah = amaunCtsms + amaunCttgk + amaunDnsms + amaunDntgk + amaunNtsms + amaunNttgk + amaunWrsms + amaunWrtgk;

                                                        $('#HLins2List\\[' + indexRow + '\\]\\.jumlahTarikh').html(jumlah.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString());
                                                    }

                                                    function calculateTotal() {
                                                        var sumCtsms = 0;
                                                        var sumCttgk = 0;
                                                        var sumDnsms = 0;
                                                        var sumDntgk = 0;
                                                        var sumNtsms = 0;
                                                        var sumNttgk = 0;
                                                        var sumWrsms = 0;
                                                        var sumWrtgk = 0;
                                                        var tbl = $('#ansuranTable');
                                                        tbl.find('input[id$=\'in2Ctsms\']').each(function (index, elem) {
                                                            var valTotalCtsms = parseFloat($(elem).val().replace(/,/g, ''));
                                                            if (!isNaN(valTotalCtsms)) {
                                                                sumCtsms += valTotalCtsms;
                                                            }
                                                        });
                                                        $('#totalCtsms').html(sumCtsms.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString());
                                                        //$('#mcmAmaun').val(sumTotal.toFixed(2));


                                                        tbl.find('input[id$=\'in2Cttgk\']').each(function (index, elem) {
                                                            var valTotalCttgk = parseFloat($(elem).val().replace(/,/g, ''));
                                                            if (!isNaN(valTotalCttgk)) {
                                                                sumCttgk += valTotalCttgk;
                                                            }
                                                        });
                                                        $('#totalCttgk').html(sumCttgk.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString());

                                                        tbl.find('input[id$=\'in2Dnsms\']').each(function (index, elem) {
                                                            var valTotalDnsms = parseFloat($(elem).val().replace(/,/g, ''));
                                                            if (!isNaN(valTotalDnsms)) {
                                                                sumDnsms += valTotalDnsms;
                                                            }
                                                        });
                                                        $('#totalDnsms').html(sumDnsms.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString());

                                                        tbl.find('input[id$=\'in2Dntgk\']').each(function (index, elem) {
                                                            var valTotalDntgk = parseFloat($(elem).val().replace(/,/g, ''));
                                                            if (!isNaN(valTotalDntgk)) {
                                                                sumDntgk += valTotalDntgk;
                                                            }
                                                        });
                                                        $('#totalDntgk').html(sumDntgk.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString());

                                                        tbl.find('input[id$=\'in2Ntsms\']').each(function (index, elem) {
                                                            var valTotalNtsms = parseFloat($(elem).val().replace(/,/g, ''));
                                                            if (!isNaN(valTotalNtsms)) {
                                                                sumNtsms += valTotalNtsms;
                                                            }
                                                        });
                                                        $('#totalNtsms').html(sumNtsms.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString());

                                                        tbl.find('input[id$=\'in2Nttgk\']').each(function (index, elem) {
                                                            var valTotalNttgk = parseFloat($(elem).val().replace(/,/g, ''));
                                                            if (!isNaN(valTotalNttgk)) {
                                                                sumNttgk += valTotalNttgk;
                                                            }
                                                        });
                                                        $('#totalNttgk').html(sumNttgk.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString());

                                                        tbl.find('input[id$=\'in2Wrsms\']').each(function (index, elem) {
                                                            var valTotalWrsms = parseFloat($(elem).val().replace(/,/g, ''));
                                                            if (!isNaN(valTotalWrsms)) {
                                                                sumWrsms += valTotalWrsms;
                                                            }
                                                        });
                                                        $('#totalWrsms').html(sumWrsms.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString());

                                                        tbl.find('input[id$=\'in2Wrtgk\']').each(function (index, elem) {
                                                            var valTotalWrtgk = parseFloat($(elem).val().replace(/,/g, ''));
                                                            if (!isNaN(valTotalWrtgk)) {
                                                                sumWrtgk += valTotalWrtgk;
                                                            }
                                                        });
                                                        $('#totalWrtgk').html(sumWrtgk.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString());

                                                        var jumlah = sumCtsms + sumCttgk + sumDnsms + sumDntgk + sumNtsms + sumNttgk + sumWrsms + sumWrtgk;

                                                        $('#grandTotalText').html(jumlah.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString());
                                                        $('#grandTotal').val(jumlah.toFixed(2));

                                                        if (parseFloat($("#grandTotal").val()) > parseFloat($("#baki").val())) {
                                                            vex.defaultOptions.className = 'vex-theme-flat-attack';

                                                            vex.dialog.alert({message: "Melebihi Baki Penyata. <br/>",
                                                                callback: function () {
                                                                    $(".vex").hide()
                                                                },
                                                                buttons: [
                                                                    $.extend({}, vex.dialog.buttons.YES, {
                                                                        text: 'Ok'
                                                                    })
                                                                ]
                                                            });
                                                        }

                                                    }

                                                    function maklNoPekerja() {
                                                        $('#majlis').change(function (event) {  //on click
                                                            if (this.checked) { // check select status
                                                                document.getElementById('pekerja').style.display = "block";
                                                            } else {
                                                                document.getElementById('pekerja').style.display = "none";
                                                            }
                                                        });

                                                    }

                                                    /*                                                   
                                                     $("body").delegate(".baki", "click", function (event) {
                                                     event.preventDefault();
                                                     var msg2 = $(this).attr('data-msg');
                                                     var baki = $("#totalBaki").val();
                                                     var msg;
                                                     var stsTunai = "";
                                                     
                                                     var tbl = $('#bayaranTable');
                                                     
                                                     tbl.find('input[id$=\'byrKcbyr\']').each(function (index, elem) {
                                                     if ($(elem).val() !== '00') {
                                                     stsTunai = 'N';
                                                     } else {
                                                     stsTunai = 'Y';
                                                     }
                                                     console.log($(elem).val() + ":" + stsTunai);
                                                     });
                                                     
                                                     if (baki < 0) {
                                                     msg = "Bayaran Tidak Mencukupi <br/>";
                                                     } else {
                                                     if (stsTunai === 'Y') {
                                                     msg = "Baki : RM " + baki + " <br/>";
                                                     } else {
                                                     if (stsTunai === 'N' && baki > 0) {
                                                     msg = "Cara Bayaran bukan tunai. Tiada pemulangan baki. <br/>";
                                                     } else {
                                                     msg = "Baki : RM " + baki + " <br/>";
                                                     }
                                                     }
                                                     }
                                                     
                                                     vex.defaultOptions.className = 'vex-theme-flat-attack';
                                                     if (baki < 0 || (stsTunai !== 'Y' && baki > 0)) {
                                                     vex.dialog.alert({message: msg,
                                                     callback: function () {
                                                     $(".vex").hide()
                                                     },
                                                     buttons: [
                                                     $.extend({}, vex.dialog.buttons.YES, {
                                                     text: 'Ok'
                                                     })
                                                     ]
                                                     });
                                                     // vex.dialog.alert 'Thanks for checking out Vex!';
                                                     } else {
                                                     vex.dialog.confirm({
                                                     message: msg + msg2,
                                                     callback: function (confirmed) {
                                                     $(".vex").hide();
                                                     if (confirmed) {
                                                     $("#" + $('form').attr('id')).submit();
                                                     } else {
                                                     return false;
                                                     }
                                                     },
                                                     buttons: [
                                                     $.extend({}, vex.dialog.buttons.YES, {
                                                     text: 'Ok'
                                                     }), $.extend({}, vex.dialog.buttons.NO, {
                                                     text: 'Batal'
                                                     })
                                                     ]
                                                     });
                                                     }
                                                     }); * /
                                                     
                                                     
                                                     /*   $(document).ready(function () {
                                                     $(".data").blur(function () {
                                                     var temp, total = 0, index;
                                                     $(this).closest("tr").find(".data").each(function (i, item) {
                                                     temp = parseFloat($(item).val());
                                                     if (!isNaN(temp))
                                                     total = total + temp;
                                                     });
                                                     $(this).closest("tr").find(".rowTotal").val(total.toFixed(2));
                                                     total = 0;
                                                     index = $(this).closest("tr").find("td").index($(this).closest("td"));
                                                     $("#ansuranTable tr").each(function (i, item) {
                                                     
                                                     if ($(item).find("td:eq(" + index + ") .data").hasClass("data")) {
                                                     temp = parseFloat($(item).find("td:eq(" + index + ") .data").val());
                                                     if (!isNaN(temp))
                                                     total = total + temp;
                                                     }
                                                     });
                                                     $("#ansuranTable tr:last td:eq(" + index + ") .columnTotalText").html(total.toFixed(2));
                                                     calculateGrandTotal();
                                                     
                                                     if (lebihBaki() == "Y") {
                                                     totalAsal = $(".grandTotal").val() - $(this).val();
                                                     $(".grandTotalText").html(totalAsal.toFixed(2));
                                                     $(".grandTotal").val(totalAsal.toFixed(2));
                                                     $(this).val("0.00");
                                                     }
                                                     ;
                                                     })
                                                     });
                                                     function calculateGrandTotal() {
                                                     (function () {
                                                     var temp, total = 0;
                                                     $(".rowTotal").each(function () {
                                                     temp = parseFloat($(this).val());
                                                     if (!isNaN(temp))
                                                     total = total + temp;
                                                     });
                                                     $(".grandTotalText").html(total.toFixed(2));
                                                     $(".grandTotal").val(total.toFixed(2));
                                                     })();
                                                     }
                                                     
                                                     function lebihBaki() {
                                                     if ($(".grandTotal").val() > $("#baki").val()) {
                                                     alert("Melebihi baki penyata");
                                                     //clearkan data tambah
                                                     return "Y";
                                                     }
                                                     }*/
</script>

<!-- MODAL -->    
<%--div class="modal fade" id="modalPenyelia" tabindex="-1" role="dialog"  aria-labelledby="modalAkaunLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabel">Senarai Pekerja</h4>
            </div>
            <div class="modal-body">
                <iframe id="frameJab" frameborder="0" style="overflow-x:hidden; overflow-y:auto;"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div--%><!-- /.modal -->
<!-- MODAL --> 


<!-- AKAUN (MODAL) -->
<div class="modal fade bs-example-modal-lg" id="modalAkaun" tabindex="-1" role="dialog"  aria-labelledby="modalAkaunLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabel">AKAUN </h4>
            </div>
            <div class="modal-body">
                <iframe id="akaunFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- AKAUN (MODAL) -->

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
<div class="modal fade modal-fullscreen" id="modalCetak" tabindex="-1" role="dialog"  aria-labelledby="modalCetakLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" style="width: 100%; height: 100%; padding: 0">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="$('#cetakFrame').attr('src', '');">&times;</button>
                <h4 class="modal-title" id="modalCetakLabel">Bil</h4>
            </div>
            <div class="modal-body" style="zoom:0.80;">
                <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="750px" width="100%" 
                        frameborder="0" scrolling="yes"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- CETAK (MODAL) -->