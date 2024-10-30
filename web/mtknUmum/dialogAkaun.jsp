<%-- 
    Document   : dialogAkaun
    Created on : Aug 19, 2014, 10:39:02 AM
    Author     : ShahRizal
--%>

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

        function passData(data1, idAkaun)
        {
            window.parent.$('#' + idAkaun).val(data1);
            window.parent.$('#' + idAkaun).blur();
            
            window.parent.$("#modalAkaun").modal('hide');
            window.parent.$("iframe").contents().empty();
        }
    </script>
    <body style="background-color: white;"> 
        <!--div class="loader"></div--> 
        <div class="row">
            <div class="col-xs-12">
                <s:if test="stsScreen == null">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="pull-right panel-options">
                            <i class="fa" id="toggle"></i>
                        </span>
                        <h3 class="panel-title">Menu Carian </h3>
                    </div>
                    <div class="panel-body" id="panel"> 
                        <s:form id="AkaunForm" cssClass="form-horizontal" namespace="/ansuran" action="Akaun" method="post">                                 
                            <div class="form-group">
                                <label class="col-sm-2 control-label">No. Akaun :</label>
                                <div class="col-sm-4">
                                    <s:textfield cssClass="form-control input-sm" name="akaun.pegAkaun" maxLength="14" title="Masukkan No Akaun"/>
                                </div>
                                <label class="col-sm-2 control-label">Nama :</label>
                                <div class="col-sm-4">
                                    <s:textfield cssClass="form-control input-sm" name="akaun.pvdPnama" maxLength="14" title="Masukkan Nama"/>
                                    <s:hidden name="idAkaun"/>
                                    <s:hidden name="stsScreen"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <%--
                                    <s:submit value="Cari Rekod" cssClass="btn btn-primary"/>
                                    <s:reset value="Padam Carian" cssClass="btn btn-warning" onclick="location.href='clearakaun'"/>   --%>
                                    <button type="submit" class="cari"></button>
                                    <button type="reset" class="isisemula" onclick="location.href='clearakaun'"></button>
                                </div>
                            </div>
                        </s:form>
                    </div>
                </div>
                </s:if>
                <s:if test="akaunList.size() != 0">
                <div class="panel panel-default">
                    <div class="panel-body" id="panel2"> 
                        <div class="adv-table editable-table" id="panel">
                            <%--display:table uid="models" name="akaunList" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending">
                                <display:setProperty name="paging.banner.placement" value="bottom" />     
                                <display:setProperty name="basic.empty.showtable" value="true" />  
                                <display:column property="pegAkaun" title="No Akaun" style="width:10%; padding-right:10px !important; text-align: right;"/> 
                                <display:column title="Nama" property="pvdPnama"/>
                            <display:column  title="Pilihan"> 
                                <s:a href="#" onclick="passData('%{#attr.models.PegAkaun}','%{#attr.models.PvdPnama}','')"><i class="fa fa-check"></i></s:a>
                            </display:column>


                            </display:table--%>

                            <display:table uid="models" name="akaunList" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending">
                                <%--display:table id="maklAkaunTable" name="maklAkaunList" pagesize="${pageSizeSelected}" cellpadding="5px;"  
                                               cellspacing="5px;" style="width:100%;" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending"--%>
                                <display:setProperty name="paging.banner.placement" value="bottom" />     
                                <display:setProperty name="basic.empty.showtable" value="true" />  
                                <display:column property="pegAkaun" title="No. Akaun" />
                                <display:column property="pvdPnama" title="Nama"/>
                                <display:column  title="Pilihan"> 
                                    <s:a href="#" onclick="passData('%{#attr.models.PegAkaun}','%{idAkaun}')"><i class="fa fa-check"></i></s:a>
                                </display:column>
                            </display:table>
                        </div>
                    </div>
                </div>
                </s:if>
            </div>
        </div>
        <script src="<%=request.getContextPath()%>/jscript/common.js"></script> 
        <s:include value="../inc2/footer_datatable.jsp"/> 
        <s:include value="../inc2/footer_form.jsp"/> 
        <s:include value="../inc2/footer.jsp"/>
    </body>
</html>
