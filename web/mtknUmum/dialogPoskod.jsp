<%-- 
    Document   : dialogPoskod
    Created on : Dec 5, 2017, 4:25:56 PM
    Author     : ACAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<s:include value="../inc2/head_datatable.jsp"/>

<!DOCTYPE html>
<html>
    <head>
        <s:include value="../inc2/head.jsp"/> 
    </head>
    <script>
        function passData(data1, idField)
        {
            console.log("idField:" + idField);
            window.parent.$('#' + idField).val(data1);
            window.parent.$('#' + idField).blur();
            //window.parent.$('#'+idField).val(data1).trigger("change");


            window.parent.$("#modalPoskd").modal('hide');
            window.parent.$("iframe").contents().empty();
        }
    </script>
    <body style="background-color: white;">
        <div class="row">
            <div class="col-xs-12">
                <section class="panel">
                    <div class="panel-body">
                        <div class="adv-table editable-table" id="panel">   
                            <display:table name="PoskodPopList" id="models" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending" >
                                <display:setProperty name="paging.banner.placement" value="bottom" />     
                                <display:setProperty name="basic.empty.showtable" value="true" />
                                <display:column property="jlnPskod" title="Poskod" />
                                <display:column property="keter" title="Keterangan" />
                                <display:column  title="Pilihan">                        
                                    <s:a href="#" onclick="passData('%{#attr.models.jlnPskod}','%{idField}')"><i class="fa fa-check"></i></s:a>               
                                </display:column>
                            </display:table>
                        </div>
                    </div>
                </section>
            </div>
            <s:include value="../inc2/footer.jsp"/>     
            <script src="<%=request.getContextPath()%>/jscript/common.js"></script>  
        </div>
    </body>
</html>
<s:include value="../inc2/footer_datatable.jsp"/>