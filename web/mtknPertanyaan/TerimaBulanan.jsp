<%-- 
    Document   : TerimaBulanan
    Created on : Apr 16, 2014, 2:43:31 PM
    Author     : Uzzair Baharudin
--%>


<%@taglib prefix = "s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="panel panel-default">
            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <i class="fa" id="toggle"></i>
                    <i class="fa fa-arrows-alt"></i>
                </span>
                <h3 class="panel-title">terimaan bulanan</h3>
            </div>
            <div class="panel-body" id="panel">
                <s:if test="layout.equals(\"frame\")">
                    <s:set name="urlCarian">2FrameterimaBulan</s:set>                 
                </s:if>
                <s:else>
                    <s:set name="urlCarian">terimaBulanLink2</s:set>   
                </s:else> 
                <s:form cssClass="form-horizontal" namespace="/tanya" action="%{#urlCarian}">
            <div class="form-group">
                <label class="col-sm-4 control-label">TAHUN :</label>
                <div class="col-sm-2">
                    <s:select name="Tahun" list="listTahun" listKey="TAhun" listValue="TAhun" onchange="this.form.submit()" cssClass="form-control" /> 
                </div>
            </div>
        </s:form>
                    <table class="table display table-striped table-condensed table-responsive table-bordered" id="dynamic-table">

                    <thead> 

                        <tr>

                            <th>Jenis Transaksi</th>
                            <th>Kod</th>   
                            <s:iterator value="listBulan" var="listBulanVar">
                         <%--   <th>JAN</th>
                            <th>FEB</th>
                            <th>MAC</th>
                            <th>APR</th>
                            <th>MEI</th>
                            <th>JUN</th>                            
                            <th>JUL</th>
                            <th>OGOS</th>
                            <th>SEPT</th>
                            <th>OKT</th>
                            <th>NOV</th>
                            <th>DIS</th>--%>
                            <th><s:property value="lookupDesc"/></th>
                            </s:iterator>
                            <th>Jumlah Kutipan</th>        
                        </tr>

                    </thead>
                    <tbody>
                        <s:iterator value="terimabulanList" var="terimabulanVar">
                            <tr>
                                <td><s:property value="STbil"/></td>
                                <td><s:property value="KDrjk"/></td>                                
                                <td align="right"><s:property value="AMjan"/></td>
                                <td align="right"><s:property value="AMfeb"/></td>
                                <td align="right"><s:property value="AMmar"/></td>
                                <td align="right"><s:property value="AMapr"/></td>
                                <td align="right"><s:property value="AMmay"/></td>
                                <td align="right"><s:property value="AMjun"/></td>
                                <td align="right"><s:property value="AMjul"/></td>
                                <td align="right"><s:property value="AMaug"/></td>
                                <td align="right"><s:property value="AMsep"/></td>
                                <td align="right"><s:property value="AMoct"/></td>
                                <td align="right"><s:property value="AMnov"/></td>
                                <td align="right"><s:property value="AMdec"/></td> 
                                <td align="right"><s:property value="AMjum"/></td> 
                            </tr>
                        </s:iterator>
                    </tbody>
                    <tfoot>
                        <tr align="right">
                            <th colspan="14" style="text-align: right">jumlah besar</th>
                            <td><s:property value="jmlhTerimaan"/></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>                    
                
            