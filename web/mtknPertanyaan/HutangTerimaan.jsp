<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="pull-right panel-options">
            <i class="fa" id="toggle"></i>
            <i class="fa fa-arrows-alt"></i>
        </span>
        <h3 class="panel-title">terimaan</h3>
    </div>
    <div class="panel-body" id="panel">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th></th>
                    <th>
                        baki pembukaan
                    </th>
                    <th>
                        terimaan tunggakan
                    </th>
                    <th>
                        baki tunggakan
                    </th>                                
                </tr>
            </thead>
            <tbody>
                <%-- <s:iterator value="terimaList" var="terimaVar">--%>
                <tr>
                    <th>taksiran</th>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjamtgk"/></td>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjaytgk"/></td>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjfmsms"/></td>
                </tr>
                <tr>
                    <th>notis e</th>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjbmtgk"/></td>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjbytgk"/></td>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjfmtgk"/></td>  
                </tr>
                <tr>
                    <th>denda lewat</th>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjcmtgk"/></td>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjcytgk"/></td>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjfysms"/></td>
                </tr>
                <tr>
                    <th>waran f</th>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjdmtgk"/></td>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjdytgk"/></td>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjfytgk"/></td>
                </tr>
                <tr>
                    <th>bayaran lebihan</th>
                    <td style="text-align: right"> <s:property value = "terimaan.VMjlebh1"/></td>
                    <td colspan="2">&nbsp;</td>
                </tr>                               

                <%--</s:iterator>   --%>
            </tbody>
        </table>
    </div>
</div>   
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="pull-right panel-options">
            <i class="fa" id="toggle"></i>
            <i class="fa fa-arrows-alt"></i>
        </span>
        <h3 class="panel-title">hutang</h3>
    </div>
    <div class="panel-body" id="panel">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th></th>
                    <th>
                        amaun dikenakan
                    </th>
                    <th>
                        terimaan semasa
                    </th>
                    <th>
                        baki hutang semasa
                    </th>       
                    <th>
                        baki penutupan
                    </th>      
                </tr>
            </thead>
            <tbody>
                <%--<s:iterator value="hutangList" var="hutangVar">--%>
                <tr>
                    <th>taksiran</th>

                    <td style="text-align: right"> <s:property value = "%{hutang.VMjamsms}"/></td>
                    <td style="text-align: right"> <s:property value = "%{hutang.VMjaysms}"/></td>
                    <td style="text-align: right"> <s:property value = "%{hutang.VMjemsms}"/></td>
                    <td style="text-align: right"> <s:property value = "%{hutang.SCrtgkna}"/></td>
                </tr>
                <tr>
                    <th>notis e</th>

                    <td style="text-align: right"> <s:property value = "%{hutang.VMjbmsms}"/></td>
                    <td style="text-align: right"> <s:property value = "%{hutang.VMjbysms}"/></td>
                    <td style="text-align: right"> <s:property value = "%{hutang.VMjemtgk}"/></td>
                    <td style="text-align: right"> <s:property value = "%{hutang.SCrtgknb}"/></td>


                </tr>
                <tr>
                    <th>denda lewat</th>

                    <td style="text-align: right"> <s:property value = "%{hutang.VMjcmsms}"/></td>
                    <td style="text-align: right"> <s:property value = "%{hutang.VMjcysms}"/></td>
                    <td style="text-align: right"> <s:property value = "%{hutang.VMjeysms}"/></td>
                    <td style="text-align: right"> <s:property value = "%{hutang.SCrtgknc}"/></td>


                </tr>
                <tr>
                    <th>waran f</th>

                    <td style="text-align: right"> <s:property value = "hutang.VMjdmsms"/></td>
                    <td style="text-align: right"> <s:property value = "hutang.VMjdysms"/></td>
                    <td style="text-align: right"> <s:property value = "hutang.VMjeytgk"/></td>
                    <td style="text-align: right"> <s:property value = "hutang.SCrtgknd"/></td>

                </tr>       
                <tr>
                    <th colspan="4" align="right">Bayaran Lebihan</th>
                    <td style="text-align: right"> <s:property value = "hutang.VMjlebh2"/></td>      

                </tr> 
                <%--</s:iterator>--%>
            </tbody>
        </table>
    </div>
</div>  

