
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="../inc2/head.jsp"/>
        <s:include value="../inc2/head_form.jsp"/>
        <s:include value="../inc2/head_datatable.jsp"/>
    </head>
    <script>
        function passData(data1)
        {
            window.parent.$('#pneKppek').val(data1);
            window.parent.$('#pneKppek').blur();

            window.parent.$("#modalAkaun").modal('hide');
            window.parent.$("iframe").contents().empty();
        }
    </script>
    <body style="background-color: white;">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-body" id="panel2"> 
                        <div class="adv-table editable-table" id="panel"> 
                            <display:table uid="models" name="PneliaList" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending">
                                <display:setProperty name="paging.banner.placement" value="bottom" />     
                                <display:setProperty name="basic.empty.showtable" value="true" />  

                                <display:column property="pneKppek" title="Kad Pengenalan Pekerja"/> 
                                <display:column property="pneNapek" title="Nama Pekerja"/> 
                                <display:column  title="Pilihan">
                                    <s:a href="#" onclick="passData('%{#attr.models.pneKppek}')"><i class="fa fa-check"></i></s:a>  
                                </display:column>                             
                            </display:table>   
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="<%=request.getContextPath()%>/jscript/common.js"></script> 
        <s:include value="../inc2/footer_datatable.jsp"/> 
        <s:include value="../inc2/footer_form.jsp"/> 
        <s:include value="../inc2/footer.jsp"/>
    </body>

</html>        


