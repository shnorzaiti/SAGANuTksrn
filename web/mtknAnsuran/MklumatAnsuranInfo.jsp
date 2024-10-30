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
                                <s:textfield id="PEgakaun" cssClass="form-control input-sm" name="HVnduk4.pegAkaun" cssErrorClass="decoratedErrorField" onblur="reloadMaklumat(this.form,'InfoLink2')"/>
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
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="pull-right panel-options">
                        <i class="fa" id="toggle3"></i>
                    </span>
                    <h3 class="panel-title">permohonan ansuran</h3>
                </div>
                <div class="panel-body" id="panel3">
                    <s:form id="formAnsuran" cssClass="form-horizontal bucket-form" namespace="/ansuran" action="janaAnsuranLink2">
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
                            <label class="col-sm-2 col-sm-offset-2 control-label">pekerja : </label>
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
                        <div class="form-group">                  
                            <label class="col-sm-2 control-label">Bil. Ansuran :</label>
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
                            </div>
                            <label class="col-sm-2 col-sm-offset-2  control-label">anggota majlis :</label>
                            <div class="col-sm-1 form-control-static">
                                <s:if test="stsUpd.equals(\"Y\")">
                                    <b><s:property value="bilAns.in1Stang == null ? '-' : bilAns.in1Stang" escape="false"/></b>
                                </s:if>
                                <s:else>
                                    <s:if test="bilAns.in1Stang != null">  
                                        <s:if test="bilAns.in1Stang.equals(\"Y\")">                                    
                                            <s:checkbox name="bilAns.in1Stang" value="true" cssClass="form-control input-sm"  />
                                        </s:if>
                                        <s:else>
                                            <s:checkbox name="bilAns.in1Stang" cssClass="form-control input-sm"/>
                                        </s:else>                              
                                    </s:if>
                                    <s:else>  
                                        <s:checkbox name="bilAns.in1Stang" cssClass="form-control input-sm"/>
                                    </s:else>       
                                </s:else>
                            </div>
                        </div>
                        <div class="form-group">              
                            <label class="col-sm-2 control-label">Baki :</label>
                            <div class="col-sm-4 form-control-static">
                                <b>RM <s:property value="pnyataAkaun.baki"/></b>
                            </div>
                            <div class="col-sm-1 col-sm-offset-2">

                                <s:url var="urlBilAnsuran" namespace="/report" action="cetak" escapeAmp="false">
                                    <s:param name="reportName">hlkq01_a4</s:param>
                                    <s:param name="param1" value="HVnduk4.pegAkaun"/> 
                                    <s:param name="onama" value="%{userModel.userId}"/>
                                </s:url> 
                                <button type="button" class="cetakAns modalButton" data-toggle="modal" data-src="<s:property value="#urlBilAnsuran" />" 
                                        data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false" data-label="Bil Ansuran"></button>
                            </div>
                        </div> 
                    </s:form> 
                </div>
            </div> 
            <s:if test="!bilKali.equals(\"\")">
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
                                    <th colspan="2">Lain - Lain</th>   
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
                                    <th>Semasa <br/>(RM)</th>                            
                                    <th>Tunggakan <br/>(RM)</th>
                                </tr>

                            </thead>
                            <tbody>
                                <s:iterator value="HLins2List" var="HLins2Var" status="HLins2Sts">
                                    <tr valign="right">
                                        <td valign="left">
                                            <s:property value="in2Trikh"/>
                                        </td>
                                        <td align="right">
                                            <s:property value="in2Ctsms"/>
                                        </td>                                
                                        <td align="right">
                                            <s:property value="in2Cttgk"/>
                                        </td>
                                        <td align="right">
                                            <s:property value="in2Dnsms"/>
                                        </td>
                                        <td align="right">
                                            <s:property value="in2Dntgk"/>
                                        </td>
                                        <td align="right">
                                            <s:property value="in2Ntsms"/>
                                        </td>
                                        <td align="right">
                                            <s:property value="in2Nttgk"/>
                                        </td>
                                        <td align="right">
                                            <s:property value="in2Wrsms"/>
                                        </td>
                                        <td align="right">
                                            <s:property value="in2Wrtgk"/>
                                        </td>
                                        <td align="right">
                                            <s:property value="in2Lnsms"/>
                                        </td>
                                        <td align="right">
                                            <s:property value="in2Lntgk"/>
                                        </td>
                                        <td align="right"><s:div id="HLins2List[%{#HLins2Sts.index}].jumlah" ><strong><s:property value="jumlah"/></strong></s:div>
                                                <s:hidden id="HLins2List[%{#HLins2Sts.index}].jumlahText" name="HLins2List[%{#HLins2Sts.index}].jumlah" cssClass="rowTotal" />
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                            <tfoot>
                                <tr style="background-color: #53A7D5; font-weight: bold;">
                                    <td><b>Jumlah (RM)</b></td>
                                    <td align="right">
                                        <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Ctsms"/></strong></s:div>
                                        </td>      
                                        <td align="right">
                                        <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Cttgk"/></strong></s:div>
                                        </td>
                                        <td align="right">
                                        <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Dnsms"/></strong></s:div>
                                        </td>
                                        <td align="right">
                                        <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Dntgk"/></strong></s:div>
                                        </td>
                                        <td align="right">
                                        <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Ntsms"/></strong></s:div>
                                        </td>
                                        <td align="right">
                                        <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Nttgk"/></strong></s:div>
                                        </td>
                                        <td align="right">
                                        <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Wrsms"/></strong></s:div>
                                        </td>
                                        <td align="right">
                                        <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Wrtgk"/></strong></s:div>
                                        </td>
                                        <td align="right">
                                        <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Lnsms"/></strong></s:div>
                                        </td>
                                        <td align="right">
                                        <s:div cssClass="columnTotalText" ><strong><s:property value="Ansuran.in2Lntgk"/></strong></s:div>
                                        </td>
                                        <td align="right"><s:div cssClass="grandTotalText" ><strong><s:property value="Ansuran.jumlah"/></strong></s:div>
                                            <s:hidden cssClass="grandTotal" name="Ansuran.jumlah"/>
                                            <s:hidden id="baki" name="pnyataAkaun.baki"/>
                                    </td>
                                </tr>
                            </tfoot>
                        </table>
                        <div class="span4 offset4 text-center">   
                            <button type="button" value="Kembali" class="kembali" onclick="javascript:location.href = 'ansuranListLink2';"></button>
                        </div>
                    </div>
                </div>
            </s:if>
        </s:if>          
    </div>
</div>
<script src="<%=request.getContextPath()%>/jscript/common.js"></script>
<s:include value="../inc2/footer_form.jsp"/> 
<script>
                                $(document).ready(function () {
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
                                }
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