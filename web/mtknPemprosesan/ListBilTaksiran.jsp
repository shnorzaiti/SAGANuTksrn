<%-- 
    Document   : ListBilTaksiran
    Created on : May 15, 2014, 11:30:34 AM
    Author     : Mohammad Hafiz Tarmizi
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
                Senarai Akaun
                <span class="fa tools pull-right">
                <a class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle" ></a>                                       
            </span>
            </header>
            <div class="panel-body" id="panel">
                <table class="table table-striped table-condensed table-responsive table-bordered" id="editable-sample">
                    <thead>
                        <tr>                    
                            <th>No Akaun</th>
                            <th>Digit</th>
                            <th>Nama</th>                                                
                    </thead>

                    <tbody>
                        <s:iterator value="FAkaunList" var="FAkaunVar">
                            <tr>
                                <td><s:property value="PEgakaun"/></td>
                                <td><s:property value="PEgdigit"/></td>
                                <td><s:property value="PMknmbil"/></td>
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

