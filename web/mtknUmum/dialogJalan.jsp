<%-- 
    Document   : dialogKodAkaun
    Created on : Mar 23, 2015, 12:30:55 PM
    Author     : farisazri
--%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="../inc2/head.jsp"/>
        <s:include value="../inc2/head_datatable.jsp"/>
    </head>
    <script>
        function passData(data1, idField)
        {
            window.parent.$('#'+idField).val(data1);
            window.parent.$('#'+idField).blur();
            //window.parent.$('#'+idField).val(data1).trigger("change");
            
            
            window.parent.$("#modalJlkod").modal('hide');
            //window.parent.$(".modal-backdrop").hide();
            window.parent.$("iframe").contents().empty();
        }
        </script>

    <body style="background-color: white;">
        <div class="loader"></div> 
        <div class="row">
            <div class="col-xs-12">
                <section class="panel">
                    <div class="panel-body">
                        <div class="adv-table editable-table col-sm-12">
                            <%--s:form id="KodHartaForm" cssClass="form-horizontal" action="popHtkod" method="post">
                                <div class="form-group">
                                    <div class="col-sm-3">
                                        <div id="editable-sample_length" class="dataTables_length">
                                            <label>
                                                <s:if test="pageSizeSelected == 0">
                                                    <s:select name="pageSizeSelected" list="pageSizeList" listKey="pageSizeCode" listValue="pageSizeDesc" value="%{'10'}"                                 
                                                              onchange="document.forms[0].submit()"/>
                                                </s:if>
                                                <s:else>
                                                    <s:select name="pageSizeSelected" list="pageSizeList" listKey="pageSizeCode" listValue="pageSizeDesc"                                
                                                              onchange="document.forms[0].submit()"/>                            
                                                </s:else>
                                            </label>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="col-sm-8">
                                        <s:textfield name="carian" placeholder="Kod Harta atau Nama Tempat" cssClass="form-control input-sm"
                                                     onchange="this.value=this.value.toUpperCase()"/>
                                    </div>
                                    <div class="col-sm-1">
                                        <button class="btn btn-primary" id="btnAdd"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </div>
                        </s:form--%> 
                        <display:table name="JalanPopList" id="models" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending" >
                            <display:setProperty name="paging.banner.placement" value="bottom" />     
                            <display:setProperty name="basic.empty.showtable" value="true" />
                            <display:column property="jlnJlkod" title="Kod Jalan" />
                            <display:column property="jlnJnama" title="Nama Jalan" />
                            <display:column property="jlnPoskd" title="Poskod" />
                             
                            
                            <display:column  title="Pilihan">                        
                                <s:a href="#" onclick="passData('%{#attr.models.jlnJlkod}','%{idField}')"><i class="fa fa-check"></i></s:a>               
                            </display:column>
                        </display:table>
                    </div>
                </div>
            </div>
        </div>
        <script src="<%=request.getContextPath()%>/jscript/common.js"></script> 
        <s:include value="../inc2/footer_datatable.jsp"/> 
        <s:include value="../inc2/footer.jsp"/>
    </body>
</html>