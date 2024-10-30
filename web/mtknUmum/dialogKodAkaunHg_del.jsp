<%-- 
    Document   : dialogKodAkaun
    Created on : Mar 23, 2015, 12:30:55 PM
    Author     : farisazri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="../inc2/head.jsp"/>
        <s:include value="../inc2/head_form.jsp"/>
        <%--s:include value="../inc2/head_datatable.jsp"/--%>
    </head>

    <script>
        function passData(data1)
        {
            window.parent.$('#AkaunHg').val(data1);
            window.parent.$('#AkaunHg').blur();

            window.parent.$("#modalAkaunHg").modal('hide');
            window.parent.$("iframe").contents().empty();
        }

    </script>
    <body style="background-color: white;">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="pull-right panel-options">
                            <i class="fa" id="toggle"></i>
                        </span>
                        <h3 class="panel-title">Menu Carian </h3>
                    </div>
                    <div class="panel-body" id="panel">         
                        <s:form cssClass="form-horizontal" namespace="/laporan" action="popAkaunHg" method="post">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">No.Akaun :</label>
                                <div class="col-sm-4">
                                    <s:textfield cssClass="form-control input-sm" name="PMkakaun" maxLength="14" title="Masukkan ID Pelanggan"/>
                                </div>
                                <label class="col-sm-2 control-label">Nama :</label>
                                <div class="col-sm-4">
                                    <s:textfield cssClass="form-control input-sm" name="PMknmbil" maxLength="60" title="Masukkan Nama Pelanggan"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <button type="submit" class="cari"></button>
                                    <button type="reset" class="isisemula" onclick="location.href = 'clearpopAkaun'"></button>                  
                                </div>
                            </div>
                        </s:form>
                    </div>
                    <s:if test="AkaunPopList.size() != 0">
                        <div class="panel">
                            <div class="panel-body"> 
                                <div class="adv-table editable-table" id="panel">
                                    <display:table uid="models" name="AkaunPopList" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending">
                                        <display:setProperty name="paging.banner.placement" value="bottom" />     
                                        <display:setProperty name="basic.empty.showtable" value="true" />  
                                        <display:column property="PMkakaun" title="No Akaun" />
                                        <display:column property="PMknmbil" title="Nama" />
                                        <display:column  title="Pilihan">                        
                                             <s:a href="#" onclick="passData('%{#attr.models.PMkakaun}')"><i class="fa fa-check"></i></s:a>               
                                        </display:column>
                                    </display:table>  
                                </div>
                            </div>
                        </div>
                    </s:if>
                </div>
            </div>
        </div>
        <script src="<%=request.getContextPath()%>/jscript/common.js"></script> 
        <%--s:include value="../inc2/footer_datatable.jsp"/--%> 
        <s:include value="../inc2/footer_form.jsp"/>
        <s:include value="../inc2/footer.jsp"/>
    </body>
</html>
