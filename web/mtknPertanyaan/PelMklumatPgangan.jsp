<%-- 
    Document   : PelMklumatPgangan
    Created on : Apr 11, 2014, 3:34:17 PM
    Author     : Uzzair Baharudin
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
            <s:set name="urlAkaun">2FramePelMklumatPgangan</s:set>     
            <s:set name="urlList">2FramecarianPertanyaan</s:set>      
            <s:set name="urlLokasi">2FramecarianLokasi?LokasiPerincian.pegJlkod=<s:property value="LokasiPerincian.pegJlkod"/></s:set>               
        </s:if>
        <s:else>
            <s:set name="urlAkaun">PelMklumatPganganLink2</s:set> 
            <s:set name="urlList">carianPertanyaanLink2</s:set>   
            <s:set name="urlLokasi">carianLokasiLink2?LokasiPerincian.pegJlkod=<s:property value="LokasiPerincian.pegJlkod"/></s:set>        
        </s:else>


        <s:form cssClass="form-horizontal " action="%{#urlAkaun}" namespace="tanya">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="pull-right panel-options">       
                        <s:url var="urlMaklumat" namespace="/report" action="cetak" escapeAmp="false">
                            <s:param name="reportName">pemilikPegangan</s:param>
                            <s:param name="param1" value="%{PelMklumatPgangan.pegAkaun}"/>
                        </s:url>               
                        <a  class="modalButton cetakSm" data-toggle="modal" data-src="<s:property value="#urlMaklumat" />" 
                            data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false"> </a>  
                        <s:if test="module == null || (!module.equals(\"MKTN\") && !module.equals(\"MNJL\"))">
                            <%--s:if test="!LokasiPerincian.equals(\"\")">
                                <s:a href="%{urlLokasi}" cssClass="btn btn-primary btn-sm"><i class="fa fa-backward"></i> Kembali </s:a>
                            </s:if>
                            <s:else--%>
                            <s:if test="stsBack.equals(\"2\")">
                                <s:if test="layout.equals(\"frame\")">   
                                    <s:set name="urlListJalan">2FramecarianPertanyaanLokasi</s:set>                   
                                </s:if>
                                <s:else>
                                    <s:set name="urlListJalan">carianPertanyaanLokasiLink2</s:set>         
                                </s:else>
                                <s:a href="%{urlListJalan}" cssClass="kembali"></s:a>
                            </s:if>
                            <s:else>
                                <s:a href="%{urlList}" cssClass="kembali"></s:a>
                            </s:else>
                            <%--/s:else--%>
                            <%--a onclick="goBack()" class="btn btn-primary"><i class="fa fa-backward"></i> Kembali </a--%>
                        </s:if>
                        <%--i class="fa fa-print tooltips" data-toggle="tooltip" data-placement="top" title="Cetak Rekod"></i--%>    
                    </span>
                    <h3 class="panel-title"> <s:if test="module == null || module.equals(\"MKTN\") || module.equals(\"MNJL\")">Taksiran - </s:if> Maklumat Pemilik</h3>
                    </div>
                    <div class="panel-body" id="panel" >
                        <div class="form-group">
                            <label class="col-sm-2 control-label">no. akaun :</label>
                            <div class="col-sm-4"> <%--:<s:property value="layout"/>:<s:property value="module"/>:--%>
                            <%--s:property value="PelMklumatPgangan.pegAkaun == null?'-':PelMklumatPgangan.pegAkaun"/>
                            <s:hidden name="PelMklumatPgangan.pegAkaun" /--%>
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
                    <div class="form-group">
                        <label class="col-sm-2 control-label">kod ansuran :</label>
                        <div class="col-sm-4 form-control-static">
                            <s:if test="PelMklumatPgangan.pmkKdans.equals(\"YA\")">
                                <span class="label label-success"><s:property value="PelMklumatPgangan.pmkKdans"/></span>                                     
                            </s:if>
                            <s:else>
                                <span class="label label-info"><s:property value="PelMklumatPgangan.pmkKdans"/></span>  
                            </s:else>
                        </div>                        
                        <label class="col-sm-2 control-label">taksiran :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pmkPrtus == null?'-':PelMklumatPgangan.pmkPrtus"/> %</b>
                        </div>
                    </div>   
                    <div class="form-group">  
                        <label class="col-sm-2 control-label">rujukan majlis :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pmkRujmj == null?'-':PelMklumatPgangan.pmkRujmj"/></b>
                        </div>
                    </div>
                    <div class="form-group">                   
                        <label class="col-sm-2 control-label">no. jilid :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pmkJilid == null?'-':PelMklumatPgangan.pmkJilid"/></b>
                        </div>
                        <label class="col-sm-2 control-label">dikecualikan bil :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pmkKdexp == null?'-':PelMklumatPgangan.pmkKdexp"/></b>
                        </div>
                    </div> 
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="pull-right panel-options">
                        <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle2"></a>                            
                    </span>
                    <h3 class="panel-title">Maklumat Pegangan</h3>
                </div>
                <div class="panel-body" id="panel2">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">no. lot :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegNolot == null?'-':PelMklumatPgangan.pegNolot"/></b>
                        </div>
                        <label class="col-sm-2 control-label">bil. lot :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegBllot == null?'-':PelMklumatPgangan.pegBllot"/></b>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">alamat harta :</label>
                        <div class="col-sm-4 form-control-static">
                            <b>
                                <s:property value="PelMklumatPgangan.adpg1" escape="false"/><br/>
                                <s:property value="PelMklumatPgangan.adpg2" escape="false"/><br/>
                                <s:property value="PelMklumatPgangan.adpg3" escape="false"/><br/>
                                <s:property value="PelMklumatPgangan.adpg4"/>
                            </b>
                        </div>            
                        <label class="col-sm-2 control-label">jalan :</label>
                        <div class="col-sm-4 form-control-static">
                            <b>
                                <s:property value="PelMklumatPgangan.pegJlkod == null?'-':PelMklumatPgangan.pegJlkod"/>
                                -
                                <s:property value="PelMklumatPgangan.jlnJnama == null?'-':PelMklumatPgangan.jlnJnama"/>
                            </b>
                        </div>                                    
                    </div>
                    <div class="form-group"> 
                        <label class="col-sm-2 control-label">kegunaan tanah :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.tnhTnama == null?'-':PelMklumatPgangan.tnhTnama"/></b>
                        </div>  
                        <label class="col-sm-2 control-label">jenis bangunan :</label>                            
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.bgnBnama == null?'-':PelMklumatPgangan.bgnBnama"/></b>
                        </div>
                    </div>
                    <div class="form-group">                       
                        <label class="col-sm-2 control-label">kegunaan hartanah :</label>                            
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.hrtHnama == null?'-':PelMklumatPgangan.hrtHnama"/></b>
                        </div>   
                        <label class="col-sm-2 control-label">struktur bangunan :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.stbSnama == null?'-':PelMklumatPgangan.stbSnama"/></b>
                        </div>
                    </div>
                    <div class="form-group">   
                        <label class="col-sm-2 control-label">jenis pemilik :</label>
                        <div class="col-sm-4 form-control-static">
                            <b><s:property value="PelMklumatPgangan.jpkJnama == null?'-':PelMklumatPgangan.jpkJnama"/></b>
                        </div> 
                    </div>
                    <div class="form-group">   
                        <label class="col-sm-2 control-label">tarikh MJP :</label>
                        <div class="col-sm-2 form-control-static" data-date="" data-date-format="DD/MM/YYYY">
                            <b><s:property value="PelMklumatPgangan.pegTkhpl == null?'-':PelMklumatPgangan.pegTkhpl"/></b>
                        </div>
                        <label class="col-sm-2 control-label">tarikh kuatkuasa :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegTkhtk == null?'-':PelMklumatPgangan.pegTkhtk"/></b>
                        </div>
                        <label class="col-sm-2 control-label">tarikh O.C. :</label>
                        <div class="col-sm-2 form-control-static" data-date="" data-date-format="DD/MM/YYYY">
                            <b><s:property value="PelMklumatPgangan.pegTkhoc == null?'-':PelMklumatPgangan.pegTkhoc"/></b>                               
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">no. P.T :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegNompt == null?'-':PelMklumatPgangan.pegNompt"/></b>
                        </div>                 
                        <label class="col-sm-2 control-label">rujukan fail :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegRjfil == null?'-':PelMklumatPgangan.pegRjfil"/></b>
                        </div>
                        <label class="col-sm-2 control-label">no. pelan :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegPelan == null?'-':PelMklumatPgangan.pegPelan"/></b>
                        </div> 
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Koordinat GPS (x) :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegCodex == null?'-':PelMklumatPgangan.pegCodex"/></b>
                        </div>
                        <label class="col-sm-2 col-sm-offset-2 control-label">Koordinat GPS (y) :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegCodey == null?'-':PelMklumatPgangan.pegCodey"/></b>
                        </div>
                    </div>
                    <div class="form-group">                               
                        <label class="col-sm-2 control-label">nilai tahunan :</label>                                        
                        <div class="col-sm-2 form-control-static">
                            <b>RM <s:property value="PelMklumatPgangan.pegNilth == null?'-':PelMklumatPgangan.pegNilth"/></b>
                        </div>     
                        <label class="col-sm-2 control-label">kadar :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.kawKadar == null?'-':PelMklumatPgangan.kawKadar"/> %</b>
                        </div>                      
                        <label class="col-sm-2 control-label">Cukai taksiran :</label>                         
                        <div class="col-sm-2 form-control-static">
                            <b>RM <s:property value="PelMklumatPgangan.pegTksir == null?'-':PelMklumatPgangan.pegTksir"/></b>
                        </div>         
                    </div>  
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Diskaun :</label> 
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegDiskn == null?'-':PelMklumatPgangan.pegDiskn"/> %</b>
                        </div>  
                        <label class="col-sm-2 control-label">Caj Sampah :</label>                         
                        <div class="col-sm-2 form-control-static">
                            <b>RM <s:property value="PelMklumatPgangan.pegSmpah == null?'-':PelMklumatPgangan.pegSmpah"/></b>
                        </div>      
                    </div>
                    <div class="form-group">                     
                        <label class="col-sm-2 control-label">no. hak Milik :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pmkHkmlk == null?'-':PelMklumatPgangan.pmkHkmlk"/></b>
                        </div>
                        <label class="col-sm-2 control-label">bil. pemilik :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegBilpk == null?'-':PelMklumatPgangan.pegBilpk"/></b>
                        </div>   
                        <label class="col-sm-2 control-label">rujukan MMK :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegRjmmk == null?'-':PelMklumatPgangan.pegRjmmk"/></b>
                        </div>
                    </div>
                    <div class="form-group">    
                        <label class="col-sm-2 control-label">luas bangunan :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegLsbgn == null?'-':PelMklumatPgangan.pegLsbgn"/> m&sup2;</b>
                        </div> 
                        <label class="col-sm-2 control-label">luas tanah :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property  value="PelMklumatPgangan.pegLstnh == null?'-':PelMklumatPgangan.pegLstnh"/> m&sup2;</b>
                        </div>       
                        <label class="col-sm-2 control-label">luas ansolari :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property  value="PelMklumatPgangan.pegLsans == null?'-':PelMklumatPgangan.pegLsans"/> m&sup2;</b>
                        </div>                  
                    </div>  
                    <div class="form-group">                       
                        <label class="col-sm-2 control-label">caj perkhidmatan :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegSmpah == null?'-':PelMklumatPgangan.pegSmpah"/></b>
                        </div>
                        <label class="col-sm-2 control-label">status pegangan :</label>
                        <div class="col-sm-2 form-control-static">
                            <b><s:property value="PelMklumatPgangan.pegStatk == null?'-':PelMklumatPgangan.pegStatk"/></b>
                        </div>                                 
                    </div>    
                </div>                            
            </div>

            <s:if test="wujudSyer != 0">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="pull-right panel-options">
                            <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle2"></a>                            </span>
                        <h3 class="panel-title">Perkongsian Pemilikan</h3>
                    </div>
                    <div class="panel-body" id="panel4">

                        <div class="form-group">  
                            <table class="table table-bordered table-condensed table-responsive table-striped table-hover col-sm-10 col-sm-offset-1" id="models">
                                <thead>
                                    <tr>
                                        <td class="col-sm-1" style="width: 10%"><b>ID Pelanggan</b></td>
                                        <td class="col-sm-2"><b>Nama</b></td>
                                        <td class="col-sm-4"><b>Alamat</b></td>
                                        <td class="col-sm-1" style="width: 10%"><b>Tarikh <br/>Kuatkuasa</b></td>
                                        <td class="col-sm-1" style="width: 10%"><b>Kadar <br/>(%)</b></td>
                                        <td class="col-sm-1" style="width: 10%"><b>Cukai Taksiran <br/>(RM)</b></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="kongsiList">
                                        <tr>
                                            <td><s:property value="syePlgid"/></td>
                                            <td><s:property value="pidPnama"/></td>
                                            <td>
                                                <s:property value="valAlmt1"/><br/>
                                                <s:property value="valAlmt2"/><br/>
                                                <s:property value="valAlmt3"/><br/>
                                                <s:property value="valAlmt4"/><br/>
                                                <s:property value="valAlmt5"/>
                                            </td>
                                            <td><s:property value="syeTkhkk"/></td>
                                            <td align="right"><s:property value="syePrtus"/></td>
                                            <td align="right"><s:property value="calNilth"/></td>
                                        </tr>
                                    </s:iterator>
                                <tbody>
                            </table>
                        </div>  
                    </div>
                </div>
            </s:if>


            <s:if test="wujudPemAsal != 0">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="pull-right panel-options">
                            <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle2"></a>                            </span>
                        <h3 class="panel-title">Sejarah Pemilikan - Pemilik Asal</h3>
                    </div>
                    <div class="panel-body" id="panel5">

                        <div class="form-group"> 
                            <div class="btn-group pull-right col-lg-offset-10">
                                <button class="cetakPilih" id="2" data-toggle="dropdown"></button>
                                <%--button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Cetak <i class="fa fa-angle-down"></i>
                                </button--%>
                                <ul class="dropdown-menu pull-right"> 
                                    <s:url var="urlSejarahPemilik" namespace="/report" action="cetak" escapeAmp="false">
                                        <s:param name="reportName">htpp99</s:param>
                                        <s:param name="param1" value="PelMklumatPgangan.pegAkaun"/> 
                                        <s:param name="onama" value="%{userModel.userId}"/>
                                    </s:url> 
                                    <li><a class="modalButton" data-toggle="modal" data-src="<s:property value="#urlSejarahPemilik" />" 
                                           data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false" data-label="Sejarah Pemilik Asal">Pemilik Asal</a></li>                                   
                                </ul>
                            </div> 
                        </div>

                        <div class="form-group">  
                            <table class="table table-bordered table-condensed table-responsive table-striped table-hover col-sm-10 col-sm-offset-1" id="models">
                                <thead>
                                    <tr>
                                        <td class="col-sm-2"><b>ID Pelanggan</b></td>
                                        <td class="col-sm-2"><b>Nama</b></td>
                                        <td class="col-sm-1"><b>Nilai Tahunan <br/>(RM)</b></td>
                                        <td class="col-sm-1"><b>Kadar <br/>(%)</b></td>
                                        <td class="col-sm-1"><b>Cukai Taksiran <br/>(RM)</b></td>
                                        <td class="col-sm-3"><b>Jenis Harta</b></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="pemAsalList">
                                        <tr>
                                            <td><s:property value="oplgid"/></td>
                                            <td><s:property value="onmbil"/></td>
                                            <td align="right"><s:property value="pegNilth"/></td>
                                            <td align="right"><s:property value="kawKadar"/></td>
                                            <td align="right"><s:property value="pegTksir"/></td>
                                            <td>
                                                <s:property value="hrtHnama"/><br/> -
                                                <s:property value="bgnBnama"/><br/>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                <tbody>
                            </table>
                        </div>  
                    </div>
                </div>
            </s:if>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="pull-right panel-options">
                        <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle3"></a>                                                        </span>
                    <h3 class="panel-title">Penyata Akaun Individu :<s:property value="PelMklumatPgangan.baki"/>:</h3>
                </div>
                <div class="panel-body" id="panel3">
                    <div class="form-group">                  
                        <%-- <label class="col-sm-5 control-label" style="color:red">PEMBAYARAN YANG BELUM DIKEMASKINI :</label>
                         <div class="col-sm-2 form-control-static">
                             <s:property value="PelMklumatPgangan.pegStatf == null?'-':PelMklumatPgangan.pegStatf"/>
                         </div>--%>
                    </div> 

                    <div class="form-group"> 

                        <div class="form-group">                  
                            <label class="col-sm-2 control-label">Status Bil :</label>
                            <div class="col-sm-2 form-control-static">
                                <b><s:property value="PelMklumatPgangan.pegStatf == null?'-':PelMklumatPgangan.pegStatf"/></b>
                            </div>         
                        </div> 

                        <div class="btn-group pull-right col-lg-offset-10">
                            <button class="cetakPilih" id="2" data-toggle="dropdown"></button>
                            <%--button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Cetak <i class="fa fa-angle-down"></i>
                            </button--%>
                            <ul class="dropdown-menu pull-right"> 
                                <s:url var="urlBilAsal" namespace="/report" action="cetak" escapeAmp="false">
                                    <s:param name="reportName">htpblm_a4</s:param>
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
                                <li><a class="modalButton" data-toggle="modal" data-src="<s:property value="#urlBilAsal" />" 
                                       data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false" data-label="Bil Asal">Bil Asal</a></li>
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
                                    <s:url var="urlBilAwal" namespace="/report" action="cetak" escapeAmp="false">
                                        <s:param name="reportName">htawal_a4</s:param>
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
                                <li><a class="modalButton" data-toggle="modal" data-src="<s:property value="#urlBilAwal" />" 
                                       data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false" data-label="Bil Awal">Bil Awal</a></li>
                                <s:if test="PelMklumatPgangan.PegStatf.equals(\"ANSURAN\")">
                                    <s:url var="urlBilAnsuran" namespace="/report" action="cetak" escapeAmp="false">
                                        <s:param name="reportName">hlkq01_a4</s:param>
                                        <s:param name="param1" value="PelMklumatPgangan.pegAkaun"/> 
                                        <s:param name="onama" value="%{userModel.userId}"/>
                                    </s:url> 
                                    <li><a class="modalButton" data-toggle="modal" data-src="<s:property value="#urlBilAnsuran" />" 
                                           data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false" data-label="Bil Ansuran">Bil Ansuran</a></li>
                                </s:if>
                                <s:url var="urlPenyata" namespace="/report" action="cetak" escapeAmp="false">
                                    <s:param name="reportName">httq02</s:param>
                                    <s:param name="param1" value="PelMklumatPgangan.pegAkaun"/> 
                                    <s:param name="param2" value="PelMklumatPgangan.pegAkaun"/>
                                    <s:param name="param5" value="pytStats" />
                                    <s:param name="onama" value="%{userModel.userId}"/>
                                </s:url> 
                                <li><a class="modalButton" data-toggle="modal" data-src="<s:property value="#urlPenyata" />" 
                                       data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false" data-label="Penyata Akaun">Penyata Akaun</a></li>
                            </ul>
                        </div> 
                    </div>

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
                                <%--s:if test="pytStats.equals(\"ALL\")">
                                <li role="presentation" class="active"><s:a href="%{#urlAkaun}?PelMklumatPgangan.pegAkaun=%{PelMklumatPgangan.pegAkaun}&thnPilihan=ALL&pytStats=ALL&module=%{module}#panel3">SEMUA</s:a></li>
                                </s:if>
                                <s:else>
                                <li role="presentation"><s:a href="%{#urlAkaun}?PelMklumatPgangan.pegAkaun=%{PelMklumatPgangan.pegAkaun}&thnPilihan=ALL&pytStats=ALL&module=%{module}#panel3">SEMUA</s:a></li>                                
                                </s:else--%>
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
                                            <%--tr style="background-color: #53A7D5; font-weight: bold;">                   
                                                <th colspan="4" style="text-align: right">Baki (RM)</th>                                 
                                                <td colspan="2" align="right"><s:property value="pnyataAkaun.Baki" /></td>
                                            </tr--%>
                                        </tfoot>
                                    </s:if>
                                </table>
                            </div>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
        <%--script>
            function goBack() {
                window.history.back()
            }
        </script--%>
        <script src="<%=request.getContextPath()%>/jscript/common.js"></script>    
        <script src="<%=request.getContextPath()%>/props2/js/bs-modal-fullscreen.js"></script>
        <s:include value="../inc2/footer_form.jsp"/> 
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
