<%-- 
    Document   : top
    Created on : Sep 9, 2014, 4:23:38 PM
    Author     : Uzzair Baharudin
--%>
<%@taglib prefix = "s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
<!--header start-->
<nav class="navbar header topbar-bg clearfix">

    <!--brand start-->
    <div class="brand">
        <a href="<%= request.getScheme()%>://<%= request.getServerName()%>:<%= request.getServerPort()%>/ePBT/mainPage" class="logo">
            <img src="<%=request.getContextPath()%>/props/img/logo_03.png"/> <p><s:property value="%{moduleName}"/></p>
        </a>
        <!--        <div class="sidebar-toggle-box">                                    </div>-->
    </div>
    <!--brand end-->
    <div class="notify-group">
        <div class="nav notify-row" id="top_menu">
            <!--  notification start -->
            <ul class="nav top-menu">
                <!-- settings start -->
                <li class="dropdown">
                    <a class="dropdown-toggle tooltips sidebar-toggle" data-placement="right" data-original-title="Kawalan">
                        <i class="fa fa-toggle-on fa-2x"></i>                    
                    </a>                
                </li>
                <!-- settings end -->            
            </ul>
            <!--  end -->
        </div>
    </div> 
    <div class="container-fluid">
        <div id="navbar" class="navbar-collapse collapse notify-alert">
            <ul class="nav navbar-nav navbar-left">
                <li class="active"><a href="<%= request.getScheme()%>://<%= request.getServerName()%>:<%= request.getServerPort()%>/ePBT/mainPage"><i class="fa fa-home"></i></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-tasks"></i> <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="dropdown-header"><s:property value="%{systemName}"/></li>       
                            <s:iterator var="system" value="listSystem">
                            <li>
                                <a href="<s:property value="%{projectName}" escape="false"/>/<s:property value="%{actionLink}" escape="false"/>"><s:property value="%{menuDesc}" escape="false"/>    
                                </a>
                            </li>
                        </s:iterator>     


                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-globe"></i><s:if test="bilNotify > 0"><span class="badge bg-theme"><s:property value="bilNotify"/></span></s:if> <span class="caret"></span>                        
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li class="dropdown-header">Notifikasi <s:property value="%{moduleName}"/></li>
                            <s:if test="listNotify.size() == 0">
                            <li>
                                <a href="#">Tiada</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:iterator var="notify" value="listNotify">
                                <li>
                                    <a href="<s:property value="%{urlNmurl}" escape="false"/>"><s:property value="%{ntfKeter}" escape="false"/></a>
                                </li>
                            </s:iterator>
                        </s:else>
                    </ul>
                </li>
                <li><a href="#"><i class="fa fa-gears"></i></a></li>
                <li><a href="#"><i class="fa fa-bar-chart"></i></a></li>
            </ul>
            <ul class="pull-right profile">                
                <li><a href="#"><img src="../props/img/UZE.png" alt=""/><span><s:property value="%{userModel.userName}"/></span></a></li>                                                      
            </ul>

        </div>
    </div>
</nav>

<!--header end-->

