<%-- 
    Document   : dialogTransTaksiran
    Created on : Oct 1, 2018, 10:17:48 AM
    Author     : shahr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="../inc2/head.jsp"/>
        <s:include value="../inc2/head_datatable.jsp"/>
    </head>



    <script>
        function passData(idField, data1)
        {
            window.parent.$('#' + idField).val(data1);
            window.parent.$('#' + idField).blur();

            window.parent.$("#modal").modal('hide');
            window.parent.$(".modal-backdrop").hide();
        }

    </script>

    <body style="background-color: white;">
        <div class="loader"></div> 
        <div class="row">
            <div class="col-xs-12">
                <section class="panel">
                    <div class="panel-body">
                        <div class="adv-table editable-table col-sm-12">
                            <display:table uid="models" name="transaksiList" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending">
                                <%--display:table id="senaraiKendTable" name="senaraiKendList" pagesize="${pageSizeSelected}" cellpadding="5px;"  
                                               cellspacing="5px;" style="width:100%;" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending"--%>
                                <display:setProperty name="paging.banner.placement" value="both" />     
                                <display:setProperty name="basic.empty.showtable" value="true" />  
                                <display:column  title="Kod " property="trxItkod" style="width:10%; padding-right:10px !important; text-align: right;"/> 
                                <display:column title="Keterangan" property="trxInama"/>
                                <display:column  title="Pilihan"> 
                                    <s:a href="#" onclick="passData('%{idField}','%{#attr.models.trxItkod}')"><i class="fa fa-check"></i></s:a>
                                </display:column>
                            </display:table>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <script src="<%=request.getContextPath()%>/jscript/common.js"></script> 
        <s:include value="../inc2/footer_datatable.jsp"/> 
        <s:include value="../inc2/footer.jsp"/>
    </body>
</html>



