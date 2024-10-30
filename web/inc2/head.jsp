<%-- 
    Document   : head
    Created on : Feb 27, 2016, 12:30:55 PM
    Author     : BYE
--%>

<%--%@taglib prefix = "s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1"--%>





<link href="<%=request.getContextPath()%>/props2/css/bootstrap.min.css" rel="stylesheet">

<link href="<%=request.getContextPath()%>/props2/fonts/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/props2/css/animate.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/props2/css/nprogress.css" rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="<%=request.getContextPath()%>/props2/css/custom.css" rel="stylesheet">


<script src="<%=request.getContextPath()%>/props2/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/props2/js/cookie/jquery.cookie.js"></script>


<script src="<%=request.getContextPath()%>/props2/js/nprogress.js"></script>

<script type="text/javascript">
    var uri = window.location.toString();
    if (uri.indexOf("?") > 0) {
        var clean_uri = uri.substring(0, uri.indexOf("?"));
        window.history.replaceState({}, document.title, clean_uri);
    }
</script>
