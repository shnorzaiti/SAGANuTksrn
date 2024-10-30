<%-- 
    Document   : top
    Created on : Feb 25, 2016, 10:01:34 PM
    Author     : BYE
--%>

<%@taglib prefix = "s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="top_nav">

    <div class="nav_menu">
        <nav class="" role="navigation">
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <img src="<%=request.getContextPath()%>/props2/images/profile.png" alt=""><s:property value="%{userModel.userName}"/>
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                        <%--li><a href="javascript:;">  Profile</a>
                        </li>
                        <li>
                            <a href="javascript:;">
                                <span class="badge bg-red pull-right">50%</span>
                                <span>Settings</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;">Help</a>
                        </li--%>
                        <li><a href="/ePBT/logOutUser"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                        </li>
                    </ul>
                </li>                

                <li role="presentation" class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                        <i class="fa fa-bell-o"></i>  
                        <s:if test="bilNotify > 0">
                            <span class="label label-success"><s:property value="bilNotify"/></span>
                        </s:if>     
                        <span class="caret"></span>  
                    </a>
                    <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu"><%----%>
                        <li class="header"><h5><b>Notifikasi <s:property value="%{moduleName}"/></b></h5> </li>

                            <s:if test="listNotify.size() == 0">
                            <li class="msg_list">
                                <a href="#">Tiada</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:iterator var="notify" value="listNotify">
                                <li>
                                    <a href="<s:property value="%{urlNmurl}" escape="false"/>">
                                        <span class="message"><s:property value="%{ntfKeter}" escape="false"/></span>
                                    </a>
                                </li>
                            </s:iterator>
                        </s:else>
                    </ul>
                </li>
                <li role="presentation" class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                        <i class="fa fa-tasks"></i>
                        <span class="caret"></span>       
                    </a>
                    <ul id="menu1" class="dropdown-menu list-unstyled animated fadeInDown" role="menu">
                        <li class="dropdown-header"><h5><b><s:property value="%{systemName}"/></b></h5></li>

                        <s:iterator var="system" value="listSystem">
                            <li class=" msg_list">
                                <a href="<s:property value="%{projectName}" escape="false"/>/<s:property value="%{actionLink}" escape="false"/>?menuGroup=<s:property value="%{menuGroupId}" escape="false"/>&userId=<s:property value="%{userModel.userId}"/>"><s:property value="%{menuDesc}" escape="false"/></a>
                            </li>
                        </s:iterator>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>

</div>