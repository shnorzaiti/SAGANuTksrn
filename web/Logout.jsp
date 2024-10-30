<%-- 
    Document   : logoutsuccess
    Created on : Feb 4, 2014, 11:43:37 PM
    Author     : ghani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html" import="java.util.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>            
        <% response.sendRedirect(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/ePBT"); %>
    </body>
</html>