<%-- 
    Document   : terimaTrans
    Created on : May 3, 2014, 9:43:23 AM
    Author     : otasoft01
--%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row">
    <div class="col-lg-12">
        <!-- PANEL TERIMAAN TRANSAKSI -->
        <section class="panel" style="margin-bottom: 0px">
            <ul class="breadcrumb">
                <li> <a href="<%=request.getContextPath()%><s:text name="bcrumb.main.href"/>"><s:text name="bcrumb.main"/></a> <span class="divider"></span> </li>
                <li> <s:text name="bcrumb.tanya"/><span class="divider"></span> </li>
                <li> <s:text name="bcrumb.tanya.terimaTrans"/> </li>
            </ul>
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
            <header class="panel-heading">
                <s:text name="bcrumb.tanya.terimaTrans"/>
                <span class="tools pull-right">
                    <a href="javascript:;" class="fa fa-chevron-down tooltips" data-toggle="tooltip" data-placement="bottom" title="Min/Max"></a>                   
                    <a href="javascript:;" class="fa fa-times tooltips" data-toggle="tooltip" data-placement="bottom" title="Tutup"></a>
                </span>
            </header>
            <div id="panelTerimaTrans" class="panel-body">          
                <div class="table-responsive">
                    <div class="col-sm-12">
                        <table id="transaksiTable" class="table table-bordered table-condensed">
                            <thead>
                                <tr>
                                    <th class="col-sm-1" rowspan="2"><label><s:text name="trans.kodNiaga"/></label></th>
                                    <th class="col-sm-4" rowspan="2"><label><s:text name="trans.keterangan"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.jan"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.feb"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.mac"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.apr"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.mei"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.jun"/></label></th>
                                    <th class="col-sm-1" rowspan="2"><label><s:text name="trans.jumlah"/></label></th>
                                </tr>
                                <tr>
                                    <th class="col-sm-1"><label><s:text name="terima.jul"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.ogos"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.sept"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.okt"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.nov"/></label></th>
                                    <th class="col-sm-1"><label><s:text name="terima.dis"/></label></th>                                    
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="transList" var="trans" status="transSts">
                                    <tr>
                                        <td rowspan="2">
                                            <s:property value="kodp1 == null ? '-':kodp1" escape="false"  />-
                                            <s:property value="kodp2 == null ? '-':kodp2" escape="false"  />-
                                            <s:property value="kodp3 == null ? '-':kodp3" escape="false"  />
                                        </td>
                                        <td rowspan="2"><s:property value="itkod == null ? '-':itkod" escape="false"  /></td>
                                        <td align="right"><s:property value="amjan == null ? '-':amjan" escape="false"  /></td>
                                        <td align="right"><s:property value="amfeb == null ? '-':amfeb" escape="false"  /></td>
                                        <td align="right"><s:property value="ammar == null ? '-':ammar" escape="false"  /></td>
                                        <td align="right"><s:property value="amapr == null ? '-':amapr" escape="false"  /></td>
                                        <td align="right"><s:property value="ammay == null ? '-':ammay" escape="false"  /></td>
                                        <td align="right"><s:property value="amjun == null ? '-':amjun" escape="false"  /></td>
                                        <td align="right" rowspan="2"><strong><s:property value="amjum == null ? '-':amjum" escape="false"  /></strong></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><s:property value="amjul == null ? '-':amjul" escape="false"  /></td>
                                        <td align="right"><s:property value="amaug == null ? '-':amaug" escape="false"  /></td>
                                        <td align="right"><s:property value="amsep == null ? '-':amsep" escape="false"  /></td>
                                        <td align="right"><s:property value="amoct == null ? '-':amoct" escape="false"  /></td>
                                        <td align="right"><s:property value="amnov == null ? '-':amnov" escape="false"  /></td>
                                        <td align="right"><s:property value="amdec == null ? '-':amdec" escape="false"  /></td>                                        
                                    </tr>
                                </s:iterator>     
                            <tfoot>
                                <tr>
                                    <td colspan="8" align="right"><label><s:text name="trans.jumlahB"/></label></td>
                                    <td align="right"><strong><s:property value="jmlhBesar == null ? '-':jmlhBesar" escape="false"  /></strong></td>
                                </tr>
                            </tfoot>
                            </tbody>
                        </table>
                    </div>
                </div>  
            </div>
        </section>
    </div>
</div>
