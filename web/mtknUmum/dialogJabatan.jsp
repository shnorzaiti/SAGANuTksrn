<%-- 
    Document   : ListCBK
    Created on : May 15, 2014, 11:26:47 AM
    Author     : NurMuhammadAfzal
--%>

<%@taglib prefix = "s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>

<html>
    <head>
        <s:include value="../inc/head.jsp"/>
    </head>
    <script>
        function passData(data1)
        {
            window.parent.$('#JAbjbkod').val(data1);
            window.parent.$('#JAbjbkod').blur();
            
            window.parent.$("#modalJabatan").modal('hide');
            window.parent.$(".modal-backdrop").hide();
        }
    </script>

    <body style="background-color: white;">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div id="infoMessage" style="display: none;"></div>
                    <s:if test="hasActionMessages() || hasActionErrors()">
                        <div id="panelUmum" class="panel-body">   
                            <!-- messages & error -->
                            <s:if test="hasActionMessages()">
                                <div class="alert alert-success">
                                    <a href="#" class="close" data-dismiss="alert">×</a>
                                    <s:actionmessage/>
                                </div>
                            </s:if>
                            <s:if test="hasActionErrors()">
                                <div class="alert alert-danger">
                                    <a href="#" class="close" data-dismiss="alert">×</a>
                                    <s:actionerror/>                                
                                </div>
                            </s:if>                                      
                            <!-- end messages & error -->
                        </div>
                    </s:if>
                    <div class="panel-heading">
                        <span class="pull-right panel-options">
                            <i class="fa" id="toggle"></i>
                            <i class="fa fa-arrows-alt"></i>
                        </span>
                        <h3 class="panel-title">Senarai Jabatan</h3>
                    </div>

                    <div class="panel-body" id="panel"> 
                        <display:table name="HLjabtList" uid="models" pagesize="" cellpadding="5px;" class="table table-bordered table-condensed table-responsive table-striped" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending" >
                            <display:setProperty name="paging.banner.placement" value="bottom" />     
                            <display:setProperty name="basic.empty.showtable" value="true" />
                            <display:column property="jabJbkod" title="Kod" />
                            <display:column property="jabJnama" title="Keterangan" />
                             <display:column title="Alamat">
                              <s:property value = "%{#attr.models.jabAlam1}"/>     
                                <br/>  
                                 <s:property value = "%{#attr.models.jabAlam2}"/>
                                <br/>
                                <s:property value = "%{#attr.models.jabAlam3}"/>     
                                <br/>
                                <s:property value = "%{#attr.models.jabAlam4}"/>
                            </display:column>
                            
                            <display:column  title="Pilihan">                        
                                <s:a href="#" onclick="passData('%{#attr.models.jabJbkod}')"><i class="fa fa-check"></i></s:a>               
                            </display:column>
                        </display:table>
                    </div>
                </div>
            </div>
        </div>
        <s:include value="../inc/footer.jsp"/>  
    </body>
</html>