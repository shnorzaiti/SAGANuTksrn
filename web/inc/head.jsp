<%-- 
    Document   : head
    Created on : Aug 19, 2014, 10:20:46 AM
    Author     : Uzzair Baharudin
--%>
<%@taglib prefix = "s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title><s:text name="system.name"/></title>
<!--Font Awesome-->
<link href="<%=request.getContextPath()%>/props/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
<!--Core Styling-->
<link href="<%=request.getContextPath()%>/props/css/bootstrap/bootstrap.css" rel="stylesheet"/>
<link href="<%=request.getContextPath()%>/props/css/admin/style-responsive.css" rel="stylesheet"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/<s:url value="props/css/gstrap/gstrap.css"/>" type="text/css"/>
      <link rel="stylesheet" href="<%=request.getContextPath()%>/<s:url value="props/css/admin/style.css"/>" type="text/css"/>
      <link rel="stylesheet" href="<%=request.getContextPath()%>/<s:url value="props/css/admin/style-responsive.css"/>" type="text/css"/>
      <!--Datetime Picker-->
      <link href="<%=request.getContextPath()%>/props/assets/datetimepicker/jquery.datetimepicker.css" rel="stylesheet"/>
<!--Data Tables-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/props/assets/data-tables/DT_bootstrap.css"/>
<!--Dialogs and Alerts-->
<link href="<%=request.getContextPath()%>/props/assets/vex/vex-theme-flat-attack.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/props/assets/vex/vex.css" rel="stylesheet" type="text/css"/>
<sj:head/><!--this is a must-->

