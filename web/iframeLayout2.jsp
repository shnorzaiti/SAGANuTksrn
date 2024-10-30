<%@ taglib prefix = "s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title><s:text name="system.name"/></title>
        <link rel="icon" sizes="192x192" href="<%=request.getContextPath()%>/props/img/logo_03.png"> 
        <s:include value="/inc2/head.jsp"/>
    </head>  <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="right_col" role="main">
                    <tiles:insertAttribute name="body" />
                </div>
            </div>
        </div>

        <s:include value="/inc2/footer.jsp"/>  
    </body>
</html>
