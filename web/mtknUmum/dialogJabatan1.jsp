<%-- 
    Document   : ListCBK
    Created on : May 15, 2014, 11:26:47 AM
    Author     : NurMuhammadAfzal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<%--<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="system.name"/></title>
        <link href="<%=request.getContextPath()%>/props/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="<%=request.getContextPath()%>/props/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/props/css/displayTag/displayTag.css"/>
        <link href="<%=request.getContextPath()%>/props/css/style.css" rel="stylesheet"/>
    </head>
    <script>
        function passData(data1)
        {
            window.parent.$('#JAbjbkod').val(data1);
            window.parent.$('#JAbjbkod').blur();

            window.parent.$("#modalJabatan").modal('hide');
          modalJabatan  window.parent.$(".modal-backdrop").hide();
        }
    </script>
    <body style="background-color: white;">
        <!-- Preloader -->
       <%-- <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>--%>
        <div class="row">
            <div class="col-xs-12">
                <section class="panel">
                    <div class="panel-body"> 
                        <div class="adv-table editable-table col-sm-12">                                    
                            <display:table id="HLjabtTable" name="HLjabtList" pagesize="5" cellpadding="5px;"  
                                           cellspacing="5px;" style="width:100%;" requestURI="" requestURIcontext="false" sort="list" defaultorder="ascending">
                                <display:setProperty name="paging.banner.placement" value="both" />     
                                <display:setProperty name="basic.empty.showtable" value="true" />  
                                
                                <display:column title="KOD" sortable="true"> 
                                    <s:a href="#" onclick="passData('%{#attr.HLjabtTable.jabJbkod}')">
                                        <s:property value="%{#attr.HLjabtTable.jabJbkod}"/>
                                    </s:a>
                                </display:column>
                                <display:column property="jabJnama" title="KETERANGAN" sortable="true"/>
                                <display:column title="ALAMAT" sortable="true">
                                        <s:property value="%{#attr.HLjabtTable.jabAlam1}"/><br/>
                                        <s:property value="%{#attr.HLjabtTable.jabAlam2}"/><br/>
                                        <s:property value="%{#attr.HLjabtTable.jabAlam3}"/><br/>
                                        <s:property value="%{#attr.HLjabtTable.jabAlam4}"/>
                                </display:column>
                            </display:table>                                   
                        </div>
                    </div>
                </section>
            </div>
        </div>
<%--<script>
            $(window).load(function() { // makes sure the whole site is loaded
			$('#status').fadeOut(); // will first fade out the loading animation
			$('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
			$('body').delay(350).css({'overflow':'visible'});
		});
        </script>--%>
    </body>

</html>            

<%-- 
    Document   : dialogJabatan1
    Created on : Mar 4, 2016, 3:21:19 PM
    Author     : Jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
