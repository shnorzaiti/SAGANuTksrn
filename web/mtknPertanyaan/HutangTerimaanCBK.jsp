<%-- 

    Document   : HutangTerimaanCBK
    Created on : Apr 21, 2014, 3:34:29 PM
    Author     : NurMuhammadAfzal

    Document   : HutangTerimaanCbk
    Created on : May 2, 2014, 3:34:29 PM
    Author     : Mohammad Hafiz Tarmizi

--%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="pull-right panel-options">
            <i class="fa" id="toggle"></i>
            <i class="fa fa-arrows-alt"></i>
        </span>
        <h3 class="panel-title">baki pembukaan</h3>
    </div>
    <div class="panel-body" id="panel">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th></th>
                    <th>
                        Persekutuan
                    </th>
                    <th>
                        Negeri
                    </th>
                    <th>
                        Badan Berkanun
                    </th>                                
                </tr>
            </thead>
            <tbody>
                <%--<s:iterator value="terimaanCbkList" var="terimaanCbkVar">--%>
                <tr align="right">
                    <th>Tunggakan</th>
                    <td><s:property value = "%{terimaanCbk.CMpamtgk}"/></td>
                    <td><s:property value = "%{terimaanCbk.CMnamtgk}"/></td>
                    <td><s:property value = "%{terimaanCbk.CMbamtgk}"/></td>
                </tr>

                <tr align="right">
                    <th>Bayaran Lebihan</th>
                    <td><s:property value = "%{terimaanCbk.CMplebh1}"/></td>
                    <td><s:property value = "%{terimaanCbk.CMnlebh1}"/></td>
                    <td><s:property value = "%{terimaanCbk.CMblebh1}"/></td>                           
                </tr>
                <tr align="right">
                    <th>Amaun Dikenakan</th>
                    <td><s:property value = "%{terimaanCbk.CMpamsms}"/></td>
                    <td><s:property value = "%{terimaanCbk.CMnamsms}"/></td>
                    <td><s:property value = "%{terimaanCbk.CMbamsms}"/></td>

                </tr>
                <%--</s:iterator>--%>

            </tbody>
        </table>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="pull-right panel-options">
            <i class="fa" id="toggle2"></i>
            <i class="fa fa-arrows-alt"></i>
        </span>
        <h3 class="panel-title">amaun diterima</h3>
    </div>
    <div class="panel-body" id="panel2">
        <table class="table">
            <thead>
                <tr>
                    <th></th>
                    <th>
                        Persekutuan
                    </th>
                    <th>
                        Negeri
                    </th>
                    <th>
                        Badan Berkanun
                    </th>       
                </tr>
            </thead>
            <tbody>
                <%--<s:iterator value="terimaanCbkList" var="terimaanCbkVar">--%>
                <tr align="right">
                    <th>Tunggakan</th>
                    <td><s:property value = "%{terimaanCbk.CMpbytgk}"/></td>
                    <td><s:property value = "%{terimaanCbk.CMnbytgk}"/></td>
                    <td><s:property value = "%{terimaanCbk.CMbbytgk}"/></td>
                </tr>
                <tr align="right">
                    <th>Kadar Caruman</th>
                    <td><s:property value = "%{terimaanCbk.CMpbysms}"/></td>
                    <td><s:property value = "%{terimaanCbk.CMnbysms}"/></td>
                    <td><s:property value = "%{terimaanCbk.CMbbysms}"/></td>
                </tr>
                <%-- </s:iterator>--%>
            </tbody>
        </table>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="pull-right panel-options">
            <i class="fa" id="toggle3"></i>
            <i class="fa fa-arrows-alt"></i>
        </span>
        <h3 class="panel-title">baki penutup</h3>
    </div>
    <div class="panel-body" id="panel3">                                                                        
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th></th>
                    <th>
                        Persekutuan
                    </th>
                    <th>
                        Negeri
                    </th>
                    <th>
                        Badan Berkanun
                    </th>       
                </tr>
            </thead>
            <tbody>
                <%--<s:iterator value="hutangCbkList" var="hutangCbkVar">--%>
                <tr align="right">
                    <th>Tunggakan</th>
                    <td><s:property value = "%{hutangCbk.CMpbktgk}"/></td>
                    <td><s:property value = "%{hutangCbk.CMnbktgk}"/></td>
                    <td><s:property value = "%{hutangCbk.CMbbktgk}"/></td>
                </tr>
                <tr align="right">
                    <th>Kadar Caruman</th>
                    <td><s:property value = "%{hutangCbk.CMpbksms}"/></td>
                    <td><s:property value = "%{hutangCbk.CMnbksms}"/></td>
                    <td><s:property value = "%{hutangCbk.CMbbksms}"/></td>
                </tr>
                <tr align="right">
                    <th>Bayaran Lebihan</th>
                    <td><s:property value = "%{hutangCbk.CMplebh2}"/></td>
                    <td><s:property value = "%{hutangCbk.CMnlebh2}"/></td>
                    <td><s:property value = "%{hutangCbk.CMblebh2}"/></td>
                </tr>
                <%--</s:iterator>--%>
            </tbody>
        </table>
    </div>
</div>