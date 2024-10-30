
<%@taglib prefix = "s" uri="/struts-tags"%>
<s:include value="../inc2/head_form.jsp"/>


<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <i class="fa" id="toggle"></i>
                </span>
                <h3 class="panel-title">pemantauan tunggakan</h3>
            </div>
            <div class="panel-body" id="panel">

                <s:form cssClass="form-horizontal bucket-form" action="cetakcarianTunggakanLink2" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Laporan :</label>
                        <div class="col-sm-9">
                            <s:if test="jenisReport.equals(\"1\")">
                                <input type="radio" name="jenisReport" id="pilihan" value="1" checked="true" onclick="pilihReport()"> Pemilik Berhutang Ikut Amaun/Tempoh
                            </s:if>
                            <s:else>
                                <input type="radio" name="jenisReport" id="pilihan" value="1" onclick="pilihReport()"> Pemilik Berhutang Ikut Amaun/Tempoh
                            </s:else>
                            <br/>
                            <s:if test="jenisReport.equals(\"2\")">
                                <input type="radio" name="jenisReport" id="pilihan" value="2" checked="true" onclick="pilihReport()"> Maklumat Hutang - Pemilik
                            </s:if>
                            <s:else>
                                <input type="radio" name="jenisReport" id="pilihan" value="2" onclick="pilihReport()"> Maklumat Hutang - Pemilik
                            </s:else>
                            <br/>
                            <s:if test="jenisReport.equals(\"3\")">
                                <input type="radio" name="jenisReport" id="pilihan" value="3" checked="true" onclick="pilihReport()"> Maklumat Hutang - Jalan / Taman / Kampung
                            </s:if>
                            <s:else>
                                <input type="radio" name="jenisReport" id="pilihan" value="3" onclick="pilihReport()"> Maklumat Hutang - Jalan / Taman / Kampung
                            </s:else>
                            <br/>                          
                            <s:if test="jenisReport.equals(\"4\")">
                                <input type="radio" name="jenisReport" id="pilihan" value="4" checked="true" onclick="pilihReport()"> Maklumat Hutang - Harta Carum Bantu Kadar
                            </s:if>
                            <s:else>
                                <input type="radio" name="jenisReport" id="pilihan" value="4" onclick="pilihReport()"> Maklumat Hutang - Harta Carum Bantu Kadar
                            </s:else>
                            <br/>                            
                            <s:if test="jenisReport.equals(\"5\")">
                                <input type="radio" name="jenisReport" id="pilihan" value="5" checked="true" onclick="pilihReport()"> Senarai Syarikat Yang Tertunggak
                            </s:if>
                            <s:else>
                                <input type="radio" name="jenisReport" id="pilihan" value="5" onclick="pilihReport()"> Senarai Syarikat Yang Tertunggak
                            </s:else>

                        </div>
                    </div>
                    <s:if test="jenisReport.equals(\"1\")">
                        <div id="amaunTempoh" style="display:block">
                        </s:if>
                        <s:else>
                            <div id="amaunTempoh" style="display:none">
                            </s:else>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Pilihan :</label>
                                <div class="col-sm-9">
                                    <s:if test="amtTmphParam1.equals(\"1\")">
                                        <input type="radio" name="amtTmphParam1" id="pilihan" value="1" onclick="carianBy()" checked="true"> No. Akaun
                                    </s:if>
                                    <s:else>
                                        <input type="radio" name="amtTmphParam1" id="pilihan" value="1" onclick="carianBy()"> No. Akaun
                                    </s:else>
                                    <s:if test="amtTmphParam1.equals(\"2\")">
                                        <input type="radio" name="amtTmphParam1" id="pilihan" value="2" onclick="carianBy()" checked="true"> Kod Jalan
                                    </s:if>
                                    <s:else>
                                        <input type="radio" name="amtTmphParam1" id="pilihan" value="2" onclick="carianBy()"> Kod Jalan
                                    </s:else>
                                    <s:if test="amtTmphParam1.equals(\"3\")">
                                        <input type="radio" name="amtTmphParam1" id="pilihan" value="3" onclick="carianBy()" checked="true"> Kod Hartanah
                                    </s:if>
                                    <s:else>
                                        <input type="radio" name="amtTmphParam1" id="pilihan" value="3" onclick="carianBy()"> Kod Hartanah

                                    </s:else>
                                    <s:hidden id="reportName" name="reportName"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Status Akaun</label>
                                <div class="col-sm-2">
                                    <s:select id="stat" name="amtTmphParam2" headerKey="" list="statusList" listKey="LookupCode" headerValue="~~~PILIH STATUS~~~" listValue="LookupDesc" cssClass="form-control input-sm" title="Status"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Dikecualikan Bil</label>
                                <div class="col-sm-2">
                                    <s:select id="stat2" name="param12" headerKey="" list="kecualiList" listKey="LookupCode" headerValue="~~~PILIH STATUS~~~" listValue="LookupDesc" cssClass="form-control input-sm" title="Status"/>
                                </div>
                            </div>    
                            <s:if test="amtTmphParam1.equals(\"1\")">
                                <div id="opt1" style="display:block">
                                </s:if>
                                <s:else>
                                    <div id="opt1" style="display:none">
                                    </s:else>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">No. Akaun:</label>
                                        <div class="col-sm-7">                                                
                                            <div class="input-group ">
                                                <span class="input-group-addon">Dari</span>
                                                <s:textfield id="AkaunDr" name="amtTmphParam3" cssClass="form-control input-sm"/> 
                                                <s:url var="urlAkaun" namespace="/" action="Akaun" escapeAmp="false">
                                                    <s:param name="idAkaun">AkaunDr</s:param>
                                                </s:url>
                                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaun" />" data-height="550px" data-width="99.6%" data-target="#modalAkaun">
                                                    <i class="fa fa-book"></i></span>

                                                <span class="input-group-addon">Hingga</span>
                                                <s:textfield id="AkaunHg" name="amtTmphParam4" cssClass="form-control input-sm"/> 
                                                <s:url var="urlAkaunHg" namespace="/" action="Akaun" escapeAmp="false">
                                                    <s:param name="idAkaun">AkaunHg</s:param>
                                                </s:url>
                                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaunHg" />" data-height="550px" data-width="99.6%" data-target="#modalAkaun">
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
                                                    </div--%>
                                            </div>
                                            <span class="text-warning"><s:fielderror><s:param>amtTmphParam3</s:param> </s:fielderror></span>  
                                            <span class="text-warning"><s:fielderror><s:param>amtTmphParam4</s:param> </s:fielderror></span>  
                                                </div>
                                            </div>
                                        </div>
                                <s:if test="amtTmphParam1.equals(\"2\")">
                                    <div id="opt2" style="display:block">
                                    </s:if>
                                    <s:else>
                                        <div id="opt2" style="display:none">
                                        </s:else>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Kod Jalan :</label>
                                            <div class="col-sm-7">                                                
                                                <div class="input-group ">  
                                                    <span class="input-group-addon">Dari</span>    
                                                    <s:textfield id="JlkodDr" name="amtTmphParam5" cssClass="form-control input-sm"/>
                                                    <s:url var="urlJlkod" namespace="/" action="Jlkod" escapeAmp="false">
                                                        <s:param name="idField">JlkodDr</s:param>
                                                    </s:url>
                                                    <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJlkod" />" data-height="550px" data-width="99.6%" data-target="#modalJlkod">
                                                        <i class="fa fa-book"></i></span>

                                                    <span class="input-group-addon">Hingga</span>
                                                    <s:textfield id="JlkodHg" name="amtTmphParam6" cssClass="form-control input-sm"/> 
                                                    <s:url var="urlJlkodHg" namespace="/" action="Jlkod" escapeAmp="false">
                                                        <s:param name="idField">JlkodHg</s:param>
                                                    </s:url>
                                                    <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJlkodHg" />" data-height="550px" data-width="99.6%" data-target="#modalJlkod">
                                                        <i class="fa fa-book"></i></span>

                                                </div>
                                                <span class="text-warning"><s:fielderror><s:param>amtTmphParam5</s:param> </s:fielderror></span>  
                                                <span class="text-warning"><s:fielderror><s:param>amtTmphParam6</s:param> </s:fielderror></span>  
                                                    </div>
                                                </div>
                                            </div>
                                    <s:if test="amtTmphParam1.equals(\"3\")">
                                        <div id="opt3" style="display:block">
                                        </s:if>
                                        <s:else>
                                            <div id="opt3" style="display:none">
                                            </s:else>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Kod Hartanah :</label>
                                                <div class="col-sm-7">                                                
                                                    <div class="input-group ">      
                                                        <span class="input-group-addon">Dari</span>
                                                        <s:textfield id="Htkod" name="amtTmphParam7" cssClass="form-control input-sm"/>
                                                        <s:url var="urlHtkod" namespace="/laporan" action="popHtkod" escapeAmp="false"/>
                                                        <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlHtkod" />" data-height="450px" data-width="99.6%" data-target="#modalHtkod">
                                                            <i class="fa fa-book"></i></span>
                                                        <div class="modal fade bs-example-modal-lg" id="modalHtkod" tabindex="-1" role="dialog"  aria-labelledby="modalHtkodLabel" aria-hidden="true">
                                                            <div class="modal-dialog modal-lg">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                        <h4 class="modal-title" id="modalHtkodLabel"><s:text name="Senarai Kod dan Nama Lokasi"/> </h4>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        <iframe id="akaunFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                                                    </div>
                                                                </div><!-- /.modal-content -->
                                                            </div><!-- /.modal-dialog -->
                                                        </div>
                                                        <span class="input-group-addon">Hingga</span>
                                                        <s:textfield id="HtkodHg" name="amtTmphParam8" cssClass="form-control input-sm"/> 
                                                        <s:url var="urlHtkodHg" namespace="/laporan" action="popHtkodHg" escapeAmp="false"/>
                                                        <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlHtkodHg" />" data-height="100%" data-width="99.6%" data-target="#modalHtkodHg">
                                                            <i class="fa fa-book"></i></span>
                                                        <div class="modal fade bs-example-modal-lg" id="modalHtkodHg" tabindex="-1" role="dialog"  aria-labelledby="modalHtkodHgLabel" aria-hidden="true">
                                                            <div class="modal-dialog modal-lg">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                        <h4 class="modal-title" id="modalHtkodHgLabel"><s:text name="Senarai Kod dan Nama Lokasi"/> </h4>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        <iframe id="akaunFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                                                    </div>
                                                                </div><!-- /.modal-content -->
                                                            </div><!-- /.modal-dialog -->
                                                        </div>
                                                    </div>
                                                    <span class="text-warning"><s:fielderror><s:param>amtTmphParam7</s:param> </s:fielderror></span>  
                                                    <span class="text-warning"><s:fielderror><s:param>amtTmphParam8</s:param> </s:fielderror></span>  
                                                        </div>
                                                    </div>
                                                </div>
                                        <%--div class="form-group">
                                            <label class="col-sm-2 control-label">Tarikh :</label>
                                            <div class="col-sm-2">
                                                <div class="input-group ">      
                                            <s:textfield name="param9" cssClass="form-control input-sm datepicker"/>   
                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                        </div>
                                    </div>
                                </div--%>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Amaun Tunggakan :</label>
                                            <div class="col-sm-7">                                                
                                                <div class="input-group ">
                                                    <span class="input-group-addon">Dari</span>
                                                    <span class="input-group-addon">RM</span>
                                                    <s:textfield id="AmaunDr" name="amtTmphParam10" cssClass="form-control input-sm"/>
                                                    <span class="input-group-addon">Hingga</span>
                                                    <span class="input-group-addon">RM</span>
                                                    <s:textfield id="AmaunHg" name="amtTmphParam11" cssClass="form-control input-sm"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <s:if test="jenisReport.equals(\"2\")">
                                        <div id="pemilik" style="display:block">
                                        </s:if>
                                        <s:else>
                                            <div id="pemilik" style="display:none">
                                            </s:else>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Pilihan :</label>
                                                <div class="col-sm-10">
                                                    <s:if test="reportNamePmlk.equals(\"htts26a\")">
                                                        <input type="radio" name="reportNamePmlk" id="pilihanPmlk" value="htts26a" onclick="carianByPmlk()" checked="true"> No. Akaun
                                                    </s:if>
                                                    <s:else>
                                                        <input type="radio" name="reportNamePmlk" id="pilihanPmlk" value="htts26a" onclick="carianByPmlk()" > No. Akaun
                                                    </s:else>
                                                    <s:if test="reportNamePmlk.equals(\"htts26b\")">
                                                        <input type="radio" name="reportNamePmlk" id="pilihanPmlk" value="htts26b" onclick="carianByPmlk()" checked="true"> Mukim
                                                    </s:if>
                                                    <s:else>
                                                        <input type="radio" name="reportNamePmlk" id="pilihanPmlk" value="htts26b" onclick="carianByPmlk()"> Mukim
                                                    </s:else>
                                                </div>
                                            </div>
                                            <s:if test="reportName.equals(\"htts26a\")">
                                                <div id="pemilikAkaun" style="display:block">
                                                </s:if>
                                                <s:else>
                                                    <div id="pemilikAkaun" style="display:none">
                                                    </s:else>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">No. Akaun:</label>
                                                        <div class="col-sm-7">                                                
                                                            <div class="input-group ">
                                                                <span class="input-group-addon">Dari</span>
                                                                <s:textfield id="pmlkParam1" name="pmlkParam1" cssClass="form-control input-sm"/> 
                                                                <s:url var="urlAkaun" namespace="/" action="Akaun" escapeAmp="false">
                                                                    <s:param name="idAkaun">pmlkParam1</s:param>
                                                                </s:url>
                                                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaun" />" data-height="550px" data-width="99.6%" data-target="#modalAkaun">
                                                                    <i class="fa fa-book"></i></span>
                                                                <span class="input-group-addon">Hingga</span>
                                                                <s:textfield id="pmlkParam2" name="pmlkParam2" cssClass="form-control input-sm"/> <s:url var="urlAkaun" namespace="/" action="Akaun" escapeAmp="false">
                                                                    <s:param name="idAkaun">pmlkParam2</s:param>
                                                                </s:url>
                                                                <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaun" />" data-height="550px" data-width="99.6%" data-target="#modalAkaun">
                                                                    <i class="fa fa-book"></i></span>
                                                            </div>
                                                            <span class="text-warning"><s:fielderror><s:param>pmlkParam1</s:param> </s:fielderror></span>  
                                                            <span class="text-warning"><s:fielderror><s:param>pmlkParam2</s:param> </s:fielderror></span>  
                                                                </div>
                                                            </div>
                                                        </div>

                                                <s:if test="reportName.equals(\"htts26b\")">
                                                    <div id="pemilikJalan" style="display:block">
                                                    </s:if>
                                                    <s:else>
                                                        <div id="pemilikJalan" style="display:none">
                                                        </s:else>
                                                        <div class="form-group">
                                                            <label class="col-sm-2 control-label">Kod Jalan  :</label>
                                                            <div class="col-sm-7">                                                
                                                                <div class="input-group ">
                                                                    <span class="input-group-addon">Dari</span>
                                                                    <s:textfield id="pmlkParam3" name="pmlkParam3" cssClass="form-control input-sm"/> 
                                                                    <s:url var="urlJlkod" namespace="/" action="Jlkod" escapeAmp="false">
                                                                        <s:param name="idField">pmlkParam3</s:param>
                                                                    </s:url>
                                                                    <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJlkod" />" data-height="550px" data-width="99.6%" data-target="#modalJlkod">
                                                                        <i class="fa fa-book"></i></span>

                                                                    <span class="input-group-addon">Hingga</span>
                                                                    <s:textfield id="pmlkParam4" name="pmlkParam4" cssClass="form-control input-sm"/> 
                                                                    <s:url var="urlJlkodHg" namespace="/" action="Jlkod" escapeAmp="false">
                                                                        <s:param name="idField">pmlkParam4</s:param>
                                                                    </s:url>
                                                                    <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJlkodHg" />" data-height="550px" data-width="99.6%" data-target="#modalJlkod">
                                                                        <i class="fa fa-book"></i></span>

                                                                </div>
                                                                <span class="text-warning"><s:fielderror><s:param>pmlkParam3</s:param> </s:fielderror></span>  
                                                                <span class="text-warning"><s:fielderror><s:param>pmlkParam4</s:param> </s:fielderror></span>  
                                                                    </div>

                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Amaun Tunggakan :</label>
                                                                <div class="col-sm-7">                                                
                                                                    <div class="input-group ">
                                                                        <span class="input-group-addon">Dari</span>
                                                                        <span class="input-group-addon">RM</span>
                                                                <s:textfield id="AmaunDr" name="pmlkParam10" cssClass="form-control input-sm"/>
                                                                <span class="input-group-addon">Hingga</span>
                                                                <span class="input-group-addon">RM</span>
                                                                <s:textfield id="AmaunHg" name="pmlkParam11" cssClass="form-control input-sm"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <s:if test="jenisReport.equals(\"3\")">
                                                    <div id="jalan" style="display:block">
                                                    </s:if>
                                                    <s:else>
                                                        <div id="jalan" style="display:none">
                                                        </s:else>
                                                        <div class="form-group">
                                                            <label class="col-sm-2 control-label">Kod Jalan :</label>
                                                            <div class="col-sm-7">                                                
                                                                <div class="input-group ">
                                                                    <span class="input-group-addon">Dari</span>
                                                                    <s:textfield id="jlnParam1" name="jlnParam1" cssClass="form-control input-sm"/> 
                                                                    <s:url var="urlJlkod" namespace="/" action="Jlkod" escapeAmp="false">
                                                                        <s:param name="idField">jlnParam1</s:param>
                                                                    </s:url>
                                                                    <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJlkod" />" data-height="550px" data-width="99.6%" data-target="#modalJlkod">
                                                                        <i class="fa fa-book"></i></span>

                                                                    <span class="input-group-addon">Hingga</span>
                                                                    <s:textfield id="jlnParam2" name="jlnParam2" cssClass="form-control input-sm"/> 
                                                                    <s:url var="urlJlkodHg" namespace="/" action="Jlkod" escapeAmp="false">
                                                                        <s:param name="idField">jlnParam2</s:param>
                                                                    </s:url>
                                                                    <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJlkodHg" />" data-height="550px" data-width="99.6%" data-target="#modalJlkod">
                                                                        <i class="fa fa-book"></i></span>

                                                                </div>
                                                                <span class="text-warning"><s:fielderror><s:param>jlnParam1</s:param> </s:fielderror></span>  
                                                                <span class="text-warning"><s:fielderror><s:param>jlnParam2</s:param> </s:fielderror></span>  
                                                                <s:hidden id="reportNameJln" name="reportNameJln"/>
                                                            </div>

                                                        </div>
                                                    </div>

                                                    <s:if test="jenisReport.equals(\"4\")">
                                                        <div id="cbk" style="display:block">
                                                        </s:if>
                                                        <s:else>
                                                            <div id="cbk" style="display:none">
                                                            </s:else>
                                                            <div class="form-group" style="height: 100px;">
                                                                <label class="col-sm-2 control-label">Jabatan :</label>
                                                                <div class="col-sm-2">
                                                                    <div class="input-group">  
                                                                        <s:textfield cssClass="form-control input-sm" id="JAbjbkod" name="cbkParam1"  cssErrorClass="decoratedErrorField" onblur="reloadMaklCBK(this.value)"/>
                                                                        <s:url var="urlJabatan" namespace="/pemprosesan" action="Jabatan" escapeAmp="false">
                                                                        </s:url>
                                                                        <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlJabatan" />" data-height="100%" data-width="99.6%" data-target="#modalJabatan">
                                                                            <i class="fa fa-book"></i></span>
                                                                    </div>
                                                                    <span class="req"><s:fielderror><s:param>param1</s:param> </s:fielderror></span>
                                                                            <div id="infoKodJabatan" style="display: none;"></div>
                                                                            <div class="modal fade" id="modalJabatan" tabindex="-1" role="dialog"  aria-labelledby="modalJabatanLabel" aria-hidden="true">
                                                                                <div class="modal-dialog modal-lg">
                                                                                    <div class="modal-content">
                                                                                        <div class="modal-header">
                                                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                                            <h4 class="modal-title" id="modalJabatanLabel">Senarai Jabatan</h4>
                                                                                        </div>
                                                                                        <div class="modal-body">
                                                                                            <iframe id="akaunFrame" frameborder="0" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                                                                        </div>
                                                                                    </div><!-- /.modal-content -->
                                                                                </div><!-- /.modal-dialog -->
                                                                            </div><!-- /.modal -->
                                                                            <!-- CETAK (MODAL) -->
                                                                        </div>
                                                                        <div class="col-sm-7 form-control-static"> 
                                                                            <div id="JAbjnama">
                                                                                <strong>
                                                                            <s:property value="jabt.jabJnama" escape="false"/><br/>
                                                                            <s:property value="jabt.JabAlam1" escape="false"/><br/>
                                                                            <s:property value="jabt.JabAlam2" escape="false"/><br/>
                                                                            <s:property value="jabt.JabAlam3" escape="false"/><br/>
                                                                            <s:property value="jabt.JabAlam4" escape="false"/>
                                                                        </strong>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <s:if test="jenisReport.equals(\"5\")">
                                                            <div id="syarikat" style="display:block">
                                                            </s:if>
                                                            <s:else>
                                                                <div id="syarikat" style="display:none">
                                                                </s:else>
                                                                <div class="form-group">
                                                                    <label class="col-sm-2 control-label">No. Akaun:</label>
                                                                    <div class="col-sm-7">                                                
                                                                        <div class="input-group ">
                                                                            <span class="input-group-addon">Dari</span>
                                                                            <s:textfield id="syktParam1" name="syktParam1" cssClass="form-control input-sm"/> 
                                                                            <s:url var="urlAkaun" namespace="/" action="Akaun" escapeAmp="false">
                                                                                <s:param name="idAkaun">syktParam1</s:param>
                                                                            </s:url>
                                                                            <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaun" />" data-height="550px" data-width="99.6%" data-target="#modalAkaun">
                                                                                <i class="fa fa-book"></i></span>
                                                                            <span class="input-group-addon">Hingga</span>
                                                                            <s:textfield id="syktParam2" name="syktParam2" cssClass="form-control input-sm"/> 
                                                                            <s:url var="urlAkaun" namespace="/" action="Akaun" escapeAmp="false">
                                                                                <s:param name="idAkaun">syktParam2</s:param>
                                                                            </s:url>
                                                                            <span class="modalButton input-group-addon" data-toggle="modal" data-src="<s:property value="#urlAkaun" />" data-height="550px" data-width="99.6%" data-target="#modalAkaun">
                                                                                <i class="fa fa-book"></i></span>
                                                                        </div>
                                                                        <span class="text-warning"><s:fielderror><s:param>syktParam1</s:param> </s:fielderror></span>  
                                                                        <span class="text-warning"><s:fielderror><s:param>syktParam2</s:param> </s:fielderror></span>  
                                                                        <s:hidden id="reportNameSykt" name="reportNameSykt"/>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <s:if test="!jenisReport.equals(\"4\")">
                                                                <div id="sizeCetak" style="display:block">
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
                                                                </div>
                                                            </s:if>
                                                            <s:else>
                                                                <div id="sizeCetak" style="display:none">
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
                                                                </div>
                                                            </s:else>
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
                                    </div>
                                </div>
                            </div>
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
                            <script>
                                function pilihReport() {
                                    var pilih;
                                    var radios = document.getElementsByName('jenisReport');

                                    for (var i = 0; i < radios.length; i++) {
                                        var aRadio = radios[i];

                                        if (aRadio.checked) {
                                            pilih = aRadio.value;
                                            break;
                                        }
                                    }
                                    if (pilih === '1') {
                                        document.getElementById('amaunTempoh').style.display = "block";
                                        document.getElementById('pemilik').style.display = "none";
                                        document.getElementById('syarikat').style.display = "none";
                                        document.getElementById('jalan').style.display = "none";
                                        document.getElementById('cbk').style.display = "none";
                                        document.getElementById('sizeCetak').style.display = "block";
                                    } else if (pilih === '2') {
                                        document.getElementById('amaunTempoh').style.display = "none";
                                        document.getElementById('pemilik').style.display = "block";
                                        document.getElementById('syarikat').style.display = "none";
                                        document.getElementById('jalan').style.display = "none";
                                        document.getElementById('cbk').style.display = "none";
                                        document.getElementById('sizeCetak').style.display = "block";
                                        $("input[name='reportNamePmlk'][value='htts26a']").prop('checked', true);

                                        document.getElementById('pemilikAkaun').style.display = "block";
                                    } else if (pilih === '3') {
                                        document.getElementById('amaunTempoh').style.display = "none";
                                        document.getElementById('pemilik').style.display = "none";
                                        document.getElementById('syarikat').style.display = "none";
                                        document.getElementById('jalan').style.display = "block";
                                        document.getElementById('cbk').style.display = "none";
                                        document.getElementById('sizeCetak').style.display = "block";
                                        $('#reportNameJln').val('htts27');
                                    } else if (pilih === '4') {
                                        document.getElementById('amaunTempoh').style.display = "none";
                                        document.getElementById('pemilik').style.display = "none";
                                        document.getElementById('syarikat').style.display = "none";
                                        document.getElementById('jalan').style.display = "none";
                                        document.getElementById('cbk').style.display = "block";
                                        document.getElementById('sizeCetak').style.display = "none";
                                    } else if (pilih === '5') {
                                        document.getElementById('amaunTempoh').style.display = "none";
                                        document.getElementById('pemilik').style.display = "none";
                                        document.getElementById('syarikat').style.display = "block";
                                        document.getElementById('jalan').style.display = "none";
                                        document.getElementById('cbk').style.display = "none";
                                        document.getElementById('sizeCetak').style.display = "block";

                                        $('#reportNameSykt').val('htts34');
                                    }

                                }

                                function carianBy() {
                                    var pilih;
                                    var radios = document.getElementsByName('amtTmphParam1');

                                    for (var i = 0; i < radios.length; i++) {
                                        var aRadio = radios[i];

                                        if (aRadio.checked) {
                                            pilih = aRadio.value;
                                            break;
                                        }
                                    }
                                    if (pilih == '1') {
                                        document.getElementById('opt1').style.display = "block";
                                        document.getElementById('opt2').style.display = "none";
                                        document.getElementById('opt3').style.display = "none";
                                        $('#reportName').val('htts25a');

                                        document.getElementById('JlkodDr').style.display = "";
                                        document.getElementById('JlkodHg').style.display = "";
                                        document.getElementById('Htkod').style.display = "";
                                        document.getElementById('HtkodHg').style.display = "";
                                    } else if (pilih == '2') {
                                        document.getElementById('opt1').style.display = "none";
                                        document.getElementById('opt2').style.display = "block";
                                        document.getElementById('opt3').style.display = "none";
                                        $('#reportName').val('htts25b');

                                        document.getElementById('AkaunDr').style.display = "";
                                        document.getElementById('AkaunHg').style.display = "";
                                        document.getElementById('Htkod').style.display = "";
                                        document.getElementById('HtkodHg').style.display = "";
                                    } else if (pilih == '3') {
                                        document.getElementById('opt1').style.display = "none";
                                        document.getElementById('opt2').style.display = "none";
                                        document.getElementById('opt3').style.display = "block";
                                        $('#reportName').val('htts25c');

                                        document.getElementById('AkaunDr').style.display = "";
                                        document.getElementById('AkaunHg').style.display = "";
                                        document.getElementById('JlkodDr').style.display = "";
                                        document.getElementById('jlkodHg').style.display = "";
                                    }
                                }

                                function carianByPmlk() {
                                    var pilih;
                                    var radios = document.getElementsByName('reportNamePmlk');

                                    for (var i = 0; i < radios.length; i++) {
                                        var aRadio = radios[i];

                                        if (aRadio.checked) {
                                            pilih = aRadio.value;
                                            break;
                                        }
                                    }
                                    if (pilih === 'htts26a') {
                                        document.getElementById('pemilikAkaun').style.display = "block";
                                        document.getElementById('pemilikJalan').style.display = "none";

                                    } else if (pilih === 'htts26b') {
                                        document.getElementById('pemilikAkaun').style.display = "none";
                                        document.getElementById('pemilikJalan').style.display = "block";
                                    }
                                    document.getElementById('pmlkParam1').style.display = "";
                                    document.getElementById('pmlkParam2').style.display = "";
                                    document.getElementById('pmlkParam3').style.display = "";
                                    document.getElementById('pmlkParam4').style.display = "";
                                }
                            </script>
                            <!-- CETAK (MODAL) -->  
                            <div class="modal fade" id="modalCetak" tabindex="-1" role="dialog"  aria-labelledby="modalCetakLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg" style="width: 100%; height: 100%; padding: 0">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="modalCetakLabel">Pemantauan Tunggakan</h4>
                                        </div>
                                        <div class="modal-body" style="zoom:0.80;">
                                            <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="700px" width="100%" 
                                                    frameborder="0" scrolling="yes"></iframe>
                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal-dialog -->
                            </div><!-- /.modal -->
                            <!-- CETAK (MODAL) -->
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

                            <div class="modal fade bs-example-modal-lg" id="modalJlkod" tabindex="-1" role="dialog"  aria-labelledby="modalJlkodLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="modalJlkodLabel"><s:text name="Senarai Kod dan Nama Lokasi"/> </h4>
                                        </div>
                                        <div class="modal-body">
                                            <iframe id="akaunFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal-dialog -->
                            </div>