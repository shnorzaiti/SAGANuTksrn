<%@ taglib prefix = "s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="/inc/head.jsp"/>
    </head>

    <body>
        <tiles:insertAttribute name="top" />
        <aside>
            <tiles:insertAttribute name="menu" />
        </aside>

<!--        <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>-->
        <section id="main-content">
            <section class="wrapper">         
<!--                <div class="loader"></div>      -->
                <tiles:insertAttribute name="body" />
            </section> <!-- end wrapper -->
        </section> <!-- end main-content -->
<%--        <s:include value="sidebar-right.jsp"/> --%>
        <s:include value="/inc/footer.jsp"/>  
    </body>
</html>
