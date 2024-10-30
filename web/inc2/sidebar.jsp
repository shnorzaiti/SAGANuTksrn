<%-- 
    Document   : sidebar
    Created on : Feb 25, 2016, 10:03:32 PM
    Author     : BYE
--%>

<%@taglib prefix = "s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="navbar nav_title" style="border: 0;">
    <a href="../../ePBT/mainPage" class="site_title" onclick="clearCookies();"><img src="<s:url namespace="/Image" action='logoImage?imageId=1'/>" height="60px" width="60px"/><%--i class="fa fa-paw"></i--%> <span><s:property value="%{moduleName}"/></span></a>
</div>
<div class="clearfix"></div>

<!-- menu prile quick info -->
<%--<div class="profile">
    <div class="profile_pic">
        <img src="images/img.jpg" alt="..." class="img-circle profile_img">
    </div>
    <div class="profile_info">
        <span>Welcome,</span>
        <h2>Anthony Fernando</h2>
    </div>
</div>
--%>
<!-- /menu prile quick info -->

<br />

<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

    <div class="menu_section">
        <h3>&nbsp;</h3>
        <ul class="nav side-menu">

            <!--------------- MAIN PART ------------>
            <li><a onclick="clearCookies();javascript:location.href = '<%=request.getContextPath()%>/common/welcome2'" ><i class="fa fa-laptop"></i> Laman Utama Sistem</a>
            </li>
            <s:iterator var="stdMenu" value="menuLevel1List">
                <s:set name="level1Node"><s:property value="%{menuCall}"/></s:set>
                <s:set name="level1StatusF"><s:property value="%{menuApplType}"/></s:set>                            
                <s:set name="level1MenuId"><s:property value="%{menuId}"/></s:set>            
                <s:if test="#level1StatusF.equals(\"M\")">
                    <li id="<s:property value="%{#level1MenuId}"/>">
                        <a>
                            <i class="<s:text name="%{menuIcon}"/>"></i> <span><s:text name="%{menuDesc}"/></span>
                            <span class="fa fa-chevron-down"></span>
                        </a>
                        <ul class="nav child_menu" style="display: none">
                            <s:iterator var="stdMenu" value="menuLevel2List">
                                <s:set name="level2Node"><s:property value="%{menuGroupId}"/></s:set>
                                <s:set name="level2ChildNode"><s:property value="%{menuCall}"/></s:set>
                                <s:set name="level2StatusF"><s:property value="%{menuApplType}"/></s:set>
                                <s:set name="level2MenuId"><s:property value="%{menuId}"/></s:set>         
                                <s:if test="#level1Node.equals(#level2Node)">
                                    <s:if test="#level2StatusF.equals(\"F\")">
                                        <li id="<s:property value="%{#level2MenuId}"/>">
                                            <s:a namespace="/%{nameSpace}" action="%{actionLink}"><s:property value="%{menuDesc}" escape="false"/></s:a>                            </li>
                                        </s:if>
                                        <s:elseif test="#level2StatusF.equals(\"P\")">
                                        <li id="<s:property value="%{#level2MenuId}"/>">
                                            <s:a href="../common/Redirect?url=%{projectName}.%{nameSpace}.%{actionLink}"><s:property value="%{menuDesc}" escape="false"/></s:a>           
                                            </li>
                                    </s:elseif>
                                    <s:else>
                                        <li>
                                            <a href="javascript:;">
                                                <i></i> <s:text name="%{menuDesc}"/>
                                                <span class="fa fa-chevron-down"></span>
                                            </a>
                                            <s:if test="menuLevel3List != null">

                                                <ul class="nav child_menu" style="display: none">
                                                    <s:iterator var="stdMenu" value="menuLevel3List">
                                                        <s:set name="level3Node"><s:property value="%{menuGroupId}"/></s:set>
                                                        <s:set name="level3ChildNode"><s:property value="%{menuCall}"/></s:set>
                                                        <s:set name="level3StatusF"><s:property value="%{menuApplType}"/></s:set>
                                                        <s:set name="level3MenuId"><s:property value="%{menuId}"/></s:set>  
                                                        <s:if test="#level2ChildNode.equals(#level3Node)"> 
                                                            <s:if test="#level3StatusF.equals(\"F\")">
                                                                <li id="<s:property value="%{#level3MenuId}"/>">
                                                                    <s:a namespace="/%{nameSpace}" action="%{actionLink}"><s:property value="%{menuDesc}" escape="false"/></s:a>                           
                                                                    </li>
                                                            </s:if>
                                                            <s:elseif test="#level3StatusF.equals(\"P\")">

                                                                <li id="<s:property value="%{#level3MenuId}"/>">
                                                                    <s:a href="../common/Redirect?url=%{projectName}.%{nameSpace}.%{actionLink}"><s:property value="%{menuDesc}" escape="false"/></s:a>           
                                                                    </li>                         
                                                            </s:elseif>
                                                        </s:if>
                                                    </s:iterator>
                                                </ul>
                                            </s:if>
                                        </li>
                                    </s:else>
                                </s:if>

                                <%--s:else>
                                    <li>
                                        <a>
                                            <i class=""/>
                                            <s:text name="%{menuDesc}" />
                                            <span class="fa fa-chevron-down"></span>
                                        </a>
                                    </li>
                                </s:else--%>
                            </s:iterator>
                        </ul>
                    </li>
                </s:if>
            <s:else>                            
                <li> <s:a namespace="/%{nameSpace}" action="%{actionLink}">
                         <i class="<s:text name="%{menuIcon}"/>"></i>
                        <span><s:property value="%{menuDesc}" escape="false"/></span>
                    </s:a>
                </li>
            </s:else>
            </s:iterator>
            <!--------------- MAIN PART ------------>
            <%--
                            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <h3>General</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="index.html">Dashboard</a>
                                        </li>
                                        <li><a href="index2.html">Dashboard2</a>
                                        </li>
                                        <li><a href="index3.html">Dashboard3</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="form.html">General Form</a>
                                        </li>
                                        <li><a href="form_advanced.html">Advanced Components</a>
                                        </li>
                                        <li><a href="form_validation.html">Form Validation</a>
                                        </li>
                                        <li><a href="form_wizards.html">Form Wizard</a>
                                        </li>
                                        <li><a href="form_upload.html">Form Upload</a>
                                        </li>
                                        <li><a href="form_buttons.html">Form Buttons</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="general_elements.html">General Elements</a>
                                        </li>
                                        <li><a href="media_gallery.html">Media Gallery</a>
                                        </li>
                                        <li><a href="typography.html">Typography</a>
                                        </li>
                                        <li><a href="icons.html">Icons</a>
                                        </li>
                                        <li><a href="glyphicons.html">Glyphicons</a>
                                        </li>
                                        <li><a href="widgets.html">Widgets</a>
                                        </li>
                                        <li><a href="invoice.html">Invoice</a>
                                        </li>
                                        <li><a href="inbox.html">Inbox</a>
                                        </li>
                                        <li><a href="calender.html">Calender</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="tables.html">Tables</a>
                                        </li>
                                        <li><a href="tables_dynamic.html">Table Dynamic</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="chartjs.html">Chart JS</a>
                                        </li>
                                        <li><a href="chartjs2.html">Chart JS2</a>
                                        </li>
                                        <li><a href="morisjs.html">Moris JS</a>
                                        </li>
                                        <li><a href="echarts.html">ECharts </a>
                                        </li>
                                        <li><a href="other_charts.html">Other Charts </a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="menu_section">
                            <h3>Live On</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="e_commerce.html">E-commerce</a>
                                        </li>
                                        <li><a href="projects.html">Projects</a>
                                        </li>
                                        <li><a href="project_detail.html">Project Detail</a>
                                        </li>
                                        <li><a href="contacts.html">Contacts</a>
                                        </li>
                                        <li><a href="profile.html">Profile</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="page_404.html">404 Error</a>
                                        </li>
                                        <li><a href="page_500.html">500 Error</a>
                                        </li>
                                        <li><a href="plain_page.html">Plain Page</a>
                                        </li>
                                        <li><a href="login.html">Login Page</a>
                                        </li>
                                        <li><a href="pricing_tables.html">Pricing Tables</a>
                                        </li>

                                    </ul>
                                </li>
                                <li><a><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a>
                                </li>
                            </ul>
                        </div>

                    </div>
            --%>
            <!-- /sidebar menu -->

        </ul>
    </div>
</div>
