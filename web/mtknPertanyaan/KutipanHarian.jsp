<%-- 
    Document   : KutipanHarian
    Created on : Apr 11, 2014, 11:59:03 AM
    Author     : NurMuhammadAfzal
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
        <h3 class="panel-title">Kutipan Harian</h3>
    </div>
    <div class="panel-body" id="panel">
        <s:if test="layout.equals(\"frame\")">
            <s:set name="urlCarian">FrameKutipanHarian</s:set>                 
        </s:if>
        <s:else>
            <s:set name="urlCarian">KutipanHarianLink</s:set>   
        </s:else> 
        <s:form cssClass="form-horizontal bucket-form" namespace="/tanya" action="%{#urlCarian}">
            <div class="form-group">
                <!--poskod jalan/kawasan-->
                <label class="col-sm-2 control-label">Tarikh Bil :</label>
                <div class="col-sm-2">
                    <s:textfield cssClass="form-control input-sm datepicker" name="HVpnyt.PYttkhbl" onblur="this.form.submit()" placeholder="DD/MM/YYYY"/><!---->
                </div>
            </div>
            <div class="form-group">
                <div class="operation-button">
                    <s:submit value="Cari Rekod" cssClass="cari"/>
                </div>
            </div>
        </s:form>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="pull-right panel-options">
            <i class="fa" id="toggle2"></i>
            <i class="fa fa-arrows-alt"></i>
        </span>
        <h3 class="panel-title">hasil carian</h3>
    </div>
    <div class="panel-body" id="panel2">  
        <table class="table" id="models">
            <thead>
                <tr>
                    <th>Tarikh Bil</th>
                    <th>No. Akaun</th>
                    <th>Resit</th>
                    <th>Kod Transaksi</th>
                    <th>Keterangan</th>
                    <th>Jenis</th>
                    <th>Amaun</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="HVpnytList" var="HVpnytVar">
                    <tr style="text-align: center">
                        <td><s:property value="PYttkhbl"/></td>
                        <td><s:property value="PYtakaun"/></td>
                        <td><s:property value="PYtnobil"/></td>
                        <td><s:property value="PYtkdrjk"/></td>
                        <td><s:property value="PYtketer"/></td>
                        <td><s:property value="PYtstatf"/></td>
                        <td align="right"><s:property value="PYtamaun"/></td>

                    </tr>                                
                </s:iterator>
            </tbody>
            <tfoot>
                <tr style="text-align: center">
                    <th colspan="6" style="text-align: right">jumlah besar</th>
                    <td align="right"><s:property value="jmlhKutipan"/></td>

                </tr>
            </tfoot>
        </table>
    </div>
</div>



<%-- <s:include value="/sidebar-right.jsp"/>        
 <s:include value="/footer-table.jsp"/> 
 <script>
     $(window).load(function() { // makes sure the whole site is loaded
                 $('#status').fadeOut(); // will first fade out the loading animation
                 $('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
                 $('body').delay(350).css({'overflow':'visible'});
         });
 </script>
</body>
</html>--%>