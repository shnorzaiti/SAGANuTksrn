<%-- 
    Document   : DendaNotisWaran
    Created on : Jun 6, 2014, 10:45:26 AM
    Author     : NurMuhammadAfzal & MohammadHafiz
--%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="pull-right panel-options">
            <i class="fa" id="toggle"></i>
            <i class="fa fa-arrows-alt"></i>
        </span>
        <h3 class="panel-title">maklumat transaksi</h3>
    </div>
    <div class="panel-body" id="panel">
        <%--div class="btn-group pull-right">           
            <s:url var="urlMaklumat" namespace="/report" action="cetak" escapeAmp="false">
                <s:param name="reportName">maklTransaksi</s:param>
            </s:url>                                        
            <a  class="modalButton" data-toggle="modal" data-src="<s:property value="#urlMaklumat" />" 
                data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false"> 
                <button class="cetak" title="Cetak Rekod"></button>
            </a>                            <!--<button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Pilihan <i class="fa fa-angle-down"></i>
</button>         
<ul class="dropdown-menu pull-right">   
            
    <li><a  class="modalButton" data-toggle="modal" data-src="<s:property value="#urlMaklumat" />" 
           data-height="500px" data-width="99.6%" data-target="#modalCetak" data-backdrop="static" data-keyboard="false">Cetak</a></li>              </ul>-->
        </div--%>
        <table class="table table-striped table-condensed table-responsive table-bordered">
            <thead>
                <tr>  
                    <th width="25%">jenis transaksi</th>
                    <th width="15%">cukai taksir</th>
                    <th width="15%">denda</th>
                    <th width="15%">notis e</th>
                    <th width="15%">waran</th>
                    <th width="15%">NOD</th>                           
                </tr>
            </thead>
            <div class="panel-body" id="panel"></div>

            <tbody>
                <s:iterator value="mklumatTransaksiList" var="mklumatTransaksiVar">
                    <tr align="right">
                        <td align="center"><s:property value = "%{PYtstatf}"/></td>
                        <td><s:property value="%{CTaksir}"/></td>
                        <td><s:property value="%{Denda}"/></td>
                        <td><s:property value="%{NOtise}"/></td>
                        <td><s:property value="%{WAran}"/></td>
                        <td><s:property value="%{NOd}"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
           
        <table class="table">
            <thead>
                <tr>                    
                    <th rowspan="2" width="25%">jenis transaksi</th>
                    <th colspan="5">tunggakan</th>                           
                </tr>
                <tr>  
                    <th width="15%">cukai taksir</th>
                    <th width="15%">denda</th>
                    <th width="15%">notis e</th>
                    <th width="15%">waran</th>
                    <th width="15%">NOD</th>                           
                </tr>
            </thead>

            <tbody>
                <s:iterator value="mklumatTransaksiList" var="mklumatTransaksiVar">
                    <tr  align="right">
                        <td align="center"><s:property value="%{PYtstatf}"/></td>
                        <td><s:property value="%{TGkct}"/></td>
                        <td><s:property value="%{TGkdenda}"/></td>
                        <td><s:property value="%{TGknotise}"/></td>
                        <td><s:property value="%{TGkwrn}"/></td>
                        <td><s:property value="%{TGknod}"/></td>
                        <!-- refer flbanklist.jsp -->
                    </tr>
                </s:iterator>
            </tbody>
        </table>  

        <div class="form-group"></div>


        <table class="table">
            <thead>
                <tr>
                    <th rowspan="3" width="25%">jenis transaksi</th>
                    <th colspan="5">bayaran</th>
                </tr>
                <tr>
                    <th width="15%">cukai taksir</th>
                    <th width="15%">denda</th>
                    <th width="15%">notis e</th>
                    <th width="15%">waran</th>
                    <th width="15%">NOD</th>
                </tr>
            </thead>

            <tbody>
                <s:iterator value="mklumatTransaksiList" var="mklumatTransaksiVar">

                    <tr  align="right">
                        <td align="center"><s:property value="%{PYtstatf}"/></td>
                        <td><s:property value="%{BYrctaksir}"/></td>
                        <td><s:property value="%{BYrdenda}"/></td>
                        <td><s:property value="%{BYrnotise}"/></td>
                        <td><s:property value="%{BYrwaran}"/></td> 
                        <td><s:property value="%{Byrnod}"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>   

        <div class="form-group"></div>


        <table class="table">
            <thead>
                <tr>
                    <th rowspan="3" width="25%">jenis transaksi</th>
                    <th colspan="5">bayaran tunggakan</th>
                </tr>
                <tr>
                    <th width="15%">cukai taksir</th>
                    <th width="15%">denda</th>
                    <th width="15%">notis e</th>
                    <th width="15%">waran</th>
                    <th width="15%">NOD</th>
                </tr>
            </thead>

            <tbody>
                <s:iterator value="mklumatTransaksiList" var="mklumatTransaksiVar">
                    <tr  align="right">
                        <td align="center"><s:property value="%{PYtstatf}"/></td>
                        <td><s:property value="%{BYrtgkct}"/></td>
                        <td><s:property value="%{BYrtgkdenda}"/></td>
                        <td><s:property value="%{BYrtgknotise}"/></td>
                        <td><s:property value="%{BYrtgkwrn}"/></td>
                        <td><s:property value="%{BYrtgknod}"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</div>        
<script src="<%=request.getContextPath()%>/jscript/common.js"></script>    
<!-- CETAK (MODAL) -->  
<div class="modal fade" id="modalCetak" tabindex="-1" role="dialog"  aria-labelledby="modalCetakLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" style="width: 100%; height: 100%; padding: 0">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalCetakLabel">Maklumat Taksiran</h4>
            </div>
            <div class="modal-body" style="zoom:0.80;">
                <iframe id="cetakFrame" src="<s:property value="cetakLink" escape="false"/>" height="700px" width="100%" 
                        frameborder="0" scrolling="yes"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- CETAK (MODAL) -->