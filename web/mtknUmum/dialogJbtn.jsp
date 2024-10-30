<%-- 
    Document   : dialogJbtn
    Created on : Mar 23, 2015, 11:38:26 AM
    Author     : farisazri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<!DOCTYPE html>
<html>
    <head>

        <s:include value="../inc/head.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="system.name"/></title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/props/css/displayTag/displayTag.css"/>
    </head>

    <script>

        function passData(data1, data2)
        {
        <%--alert(data1+":"+data2+":"+data3);--%>
            window.parent.$('#JbtnDr').val(data1);//kod
            window.parent.$('#keter').val(data2);
            window.parent.$("#modalJbtn").modal('hide');
            window.parent.$(".modal-backdrop").hide();
        }
    </script>
    <body>
        <div class="row">
            <div class="col-xs-12">
                <section class="panel">
                    <div class="panel-body">
                        <div class="adv-table editable-table col-sm-12">
                            <s:form id="KodJabatanForm" cssClass="form-horizontal" action="popJbtn" method="post">
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
                                        <s:textfield name="carian" placeholder="Jabatan" cssClass="form-control input-sm"
                                                     onchange="this.value=this.value.toUpperCase()"/>
                                    </div>
                                    <div class="col-sm-1">
                                        <button class="btn btn-primary" id="btnAdd"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </div>
                        </s:form>
                        <display:table id="senaraiKodTable" name="JbtnPopList" pagesize="${pageSizeSelected}" cellpadding="5px;"  
                                       cellspacing="5px;" style="width:100%;" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending">
                            <display:setProperty name="paging.banner.placement" value="both" />     
                            <display:setProperty name="basic.empty.showtable" value="true" />  
                            <display:column  title="Kod Jabatan" style="width:10%; padding-right:10px !important; text-align: right;"> 
                                <s:a href="#" onclick="passData('%{#attr.senaraiKodTable.JabJbkod}','%{#attr.senaraiKodTable.JabJnama}')"><s:property value="%{#attr.senaraiKodTable.JabJbkod}"/></s:a>
                            </display:column>
                            <display:column title="Nama Jabatan" sortable="true"><s:property value="%{#attr.senaraiKodTable.JabJnama}"/></display:column>
                        </display:table>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>