<%@ taglib prefix = "s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <s:include value="/inc/head.jsp"/>
    </head>
    <tiles:insertAttribute name="body" />
    <s:include value="/inc/footer.jsp"/>  
</body>
</html>
