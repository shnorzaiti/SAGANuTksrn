<%-- 
    Document   : ListHutangJlnTmnKg
    Created on : May 14, 2014, 9:38:47 AM
    Author     : NurMuhammadAfzal
--%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="/head-table.jsp"/>    


    </head>
    <body>
        <s:include value="/top.jsp"/>    
        <s:include value="/sidebar-left.jsp"/>
        <!-- Preloader -->
        <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>

        <section class="panel">

            <header class="panel-heading">
                Senarai Kod Jalan/Taman/Kampung
                <span class="tools pull-right">
                    <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle"></a>                   
                </span>
            </header>
            <div class="panel-body" id="panel">
                <table class="table table-striped table-condensed table-responsive table-bordered" id="editable-sample">
                    <thead>
                        <tr>                    
                            <th>Kod</th>
                            <th>Keterangan</th>
                            <th>Poskod</th>
                            <th>Tindakan</th>
                    </thead>

                    <tbody>
                        <s:iterator value="FJalanList" var="FJalanVar">
                            <tr>
                                <td><s:property value="jlnJlkod"/></td>
                                <td><s:property value="jlnJnama"/></td>
                                <td><s:property value="jlnPoskd"/></td>
                                <td><s:url var="linkLokasi" action="carianPertanyaanLokasi">
                                        <s:param name="FJalan.JLnjlkod" value="%{JLnjlkod}"></s:param></s:url><s:a href="%{linkLokasi}"><i class="fa fa-eye tooltips" title="Lihat rekod"></i></s:a></td>
                                    </tr>
                        </s:iterator>
                    </tbody>
                </table>           
            </div>                            
        </section>

        <s:include value="/sidebar-right.jsp"/>       
        <s:include value="/footer-table.jsp"/> 
<script>
            $(window).load(function() { // makes sure the whole site is loaded
			$('#status').fadeOut(); // will first fade out the loading animation
			$('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
			$('body').delay(350).css({'overflow':'visible'});
		});
        </script>
    </body>

</html>            

