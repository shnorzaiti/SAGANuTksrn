<%-- 
    Document   : DendaNotisWaran
    Created on : Jun 6, 2014, 10:45:26 AM
    Author     : NurMuhammadAfzal & MohammadHafiz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row">
    <div class="col-lg-12">  
        <div id="infoMessage" style="display: none;"></div>   
        <s:if test="hasActionMessages() || hasActionErrors()">
            <div id="panelUmum pnl" class="panel-body">   
                <!-- messages & error -->
                <s:if test="hasActionMessages()">
                    <div class="alert alert-success">
                        <a href="#" class="close" data-dismiss="alert">�</a>
                        <s:actionmessage/>
                    </div>
                </s:if>
                <s:if test="hasActionErrors()">
                    <div class="alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert">�</a>
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
                    <i class="fa fa-arrows-alt"></i>
                </span>
                <h3 class="panel-title">Selenggara Kadar Denda / Notis E / Waran F</h3>
            </div>
            <div class="panel-body" id="panel">
                <div class="mb">
                        <button class="daftar" id="btnAdd" onclick="javascript:location.href = 'HKadarFormLink2'"></button>
                    <!--End Add button-->
                    <!--Print button-->
                    <div class="btn-group pull-right">
                        <button class="cetakPilih" data-toggle="dropdown"></button>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="#">Selenggara Kadar Denda / Notis E / Waran F</a></li>
                            <%--li><a href="#">Simpan sebagai format PDF</a></li>
                            <li><a href="#">Eksport kepada format MS Excel</a></li--%>
                        </ul>
                    </div>
                    <!--End Print button-->
                </div>
                <table class="table" id="models">
                    <thead>
                        <tr>                    
                            <th rowspan="2">Jenis Kadar</th>
                            <th colspan="3" style="text-align: center">Amaun</th>
                            <th colspan="2" style="text-align: center">Bagi Gandaan(RM)</th>
                            <th rowspan="2">Peratus (%)</th>
                            <th rowspan="2" colspan="2" style="text-align: center">Tindakan</th>
                        </tr>
                        <tr>                    
                            <th>Dari</th>
                            <th>Hingga</th>
                            <th>RM</th>
                            <th>Tambahan</th>
                            <th>Amaun</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="HKadarList" var="obj">
                            <tr align="center">
                                <td><s:property value="%{KDrstatf}"/></td>
                                <td align="right"><s:property value="%{KDrlower}"/></td>
                                <td align="right"><s:property value="%{KDrupper}"/></td>
                                <td align="right"><s:property value="%{KDramaun}"/></td>
                                <td align="right"><s:property value="%{KDraminc}"/></td>
                                <td align="right"><s:property value="%{KDrincre}"/></td>
                                <td align="right"><s:property value="%{KDrpcent}"/></td>
                                <td>
                                    <!-- -->
                                    <!--Add button-->
                                    <%--s:url var="UpdatelinkAkaun" action="HKadarForm">
                                        <s:param name="HKadar.rowID" value="%{rowID}"></s:param></s:url><s:a href="%{UpdatelinkAkaun}"><!--<i class="fa fa-mail-forward" title="Edit Maklumat Kadar"></i>--></s:a--%>
                                    <%--a class="modalButton" data-toggle="modal" data-src="<s:property value="#UpdatelinkAkaun" />" data-height="100%" data-width="99.6%" data-target="#modaHKadar1"--%> 
                                    <a href="HKadarFormLink2?HKadar.rowNum=<s:property value = "%{rowID}"/>">
                                        <i class="fa fa-edit"></i><!-- data-backdrop="static" data-keyboard="false"-->
                                    </a>
                                    <!--End Add button-->                            
                                </td>
                                <td style="text-align: center">
                                    <a href="deleteHKadarLink2?HKadar.rowNum=<s:property value = "%{rowID}"/>" class="delete-link">
                                        <i class="fa fa-trash-o"></i>
                                    </a>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table> 
            </div>
        </div>
    </div>
</div>
<!-- HKADAR (MODAL) -->
<div class="modal fade bs-example-modal-lg" id="modaHKadar1" tabindex="-1" role="dialog"  aria-labelledby="modaHKadar1Label" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modaHKadar1Label">Selenggara Kadar Denda / Notis E / Waran F</h4>
            </div>
            <div class="modal-body">
                <iframe id="jabatanFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- HKADAR (MODAL) -->
<div class="modal fade bs-example-modal-lg" id="modaHKadar2" tabindex="-1" role="dialog"  aria-labelledby="modaHKadar2Label" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modaHKadar2Label">Selenggara Kadar Denda / Notis E / Waran F</h4>
            </div>
            <div class="modal-body">
                <iframe id="jabatanFrame" frameborder="0" scrolling="no" style="overflow-x:hidden; overflow-y:auto;"></iframe>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- HKADAR (MODAL) -->


<!-- popup -->
<%--  <s:include value="/sidebar-right.jsp"/>       
  <s:include value="/footer-form.jsp"/> 
  <script>
      $(window).load(function() { // makes sure the whole site is loaded
          $('#status').fadeOut(); // will first fade out the loading animation
          $('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
          $('body').delay(350).css({'overflow': 'visible'});
      });
  </script>
  </body>--%>


<!-- Mohammad Hafiz August,8,2014 -->
<script src="<%=request.getContextPath()%>/jscript/common.js"></script>
