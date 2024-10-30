<%-- 
    Document   : sidebar
    Created on : Sep 9, 2014, 4:23:49 PM
    Author     : Uzzair Baharudin
--%>

<%@taglib prefix = "s" uri="/struts-tags"%>
<s:set name="userID">${userId}</s:set>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="sidebar"  class="nav-collapse">
    <!-- sidebar menu start-->
    <ul class="sidebar-menu" id="nav-accordion">        
        <li class="">
            <a href="<%=request.getContextPath()%>/common/welcome">
                <i class="fa fa-home"></i>
                <span>laman utama</span>
            </a>
        </li>
        <s:iterator var="stdMenu" value="menuLevel1List">
            <s:set name="level1Node"><s:property value="%{menuCall}"/></s:set>
            <s:set name="level1StatusF"><s:property value="%{menuApplType}"/></s:set>                
            <s:if test="#level1StatusF.equals(\"M\")">
                <li class="sub-menu">                            
                    <a href="javascript:;">
                        <i class="<s:text name="%{menuIcon}"/>"></i>
                        <span><s:text name="%{menuDesc}"/></span>
                    </a>
                    <ul class="sub"><!---->                               
                        <s:iterator var="stdMenu" value="menuLevel2List">
                            <s:set name="level2Node"><s:property value="%{menuGroupId}"/></s:set>
                            <s:set name="level2ChildNode"><s:property value="%{menuCall}"/></s:set>
                            <s:set name="level2StatusF"><s:property value="%{menuApplType}"/></s:set>
                            <s:if test="#level1Node.equals(#level2Node)">
                                <s:if test="#level2StatusF.equals(\"F\")">
                                    <li>                                            
                                        <s:a namespace="/%{nameSpace}" action="%{actionLink}">
                                            <i class="fa fa-angle-double-right"></i>
                                            <span><s:property value="%{menuDesc}" escape="false"/></span>
                                        </s:a>
                                    </li>
                                </s:if>
                                <s:elseif test="#level2StatusF.equals(\"P\")">
                                    <li>                                            
                                        <s:a href="Redirect?url=%{projectName}.%{nameSpace}.%{actionLink}">
                                            <i class="fa fa-angle-double-right"></i>
                                            <span><s:property value="%{menuDesc}" escape="false"/></span>
                                        </s:a>
                                    </li>
                                </s:elseif>
                                <s:else>
                                    <li>
                                        <a href="javascript:;">
                                            <i class="fa fa-list"></i>
                                            <span><s:text name="%{menuDesc}" /></span>
                                        </a>
                                        <s:if test="menuLevel3List != null">
                                            <ul id="level3" class="subSub">
                                                <s:iterator var="stdMenu" value="menuLevel3List">
                                                    <s:set name="level3Node"><s:property value="%{menuGroupId}"/></s:set>
                                                    <s:set name="level3ChildNode"><s:property value="%{menuCall}"/></s:set>
                                                    <s:set name="level3StatusF"><s:property value="%{menuApplType}"/></s:set>
                                                    <s:if test="#level2ChildNode.equals(#level3Node)"> 
                                                        <s:if test="#level3StatusF.equals(\"F\")">
                                                            <li>
                                                                <s:a namespace="/%{nameSpace}" action="%{actionLink}">
                                                                    <i class="fa fa-angle-double-right"></i>
                                                                    <span><s:text name="%{menuDesc}"/></span>
                                                                </s:a>
                                                            </li>
                                                        </s:if>
                                                        <%--<s:else>

                                                            <li>
                                                                <a href="javascript:;">
                                                                    <i class="fa fa-list"></i>
                                                                    <span><s:text name="%{menuDesc}" /></span>
                                                                </a>

                                                                <s:if test="menuLevel4List != null">
                                                                    <ul id="level4" class="subSub">
                                                                        <s:iterator var="stdMenu" value="menuLevel4List">
                                                                            <s:set name="level4Node"><s:property value="%{menuGroupId}"/></s:set>
                                                                            <s:if test="#level3ChildNode.equals(#level4Node)"> 
                                                                                <li>
                                                                                    <s:a namespace="/%{nameSpace}" action="%{actionLink}">
                                                                                        <i class="fa fa-angle-double-right"></i>
                                                                                        <span><s:text name="%{menuDesc}"/></span>
                                                                                    </s:a>
                                                                                </li>
                                                                            </s:if>
                                                                        </s:iterator>
                                                                    </ul>
                                                                </s:if>
                                                            </li>
                                                        </s:else>--%>
                                                    </s:if>
                                                </s:iterator>
                                            </ul>
                                        </s:if>
                                    </li>
                                </s:else>
                            </s:if>
                        </s:iterator>
                    </ul>
                </li>
            </s:if>
            <s:else>                            
                <li>                                            
                    <s:a namespace="/%{nameSpace}" action="%{actionLink}">
                        <i class="<s:text name="%{menuIcon}"/>"></i>
                        <span><s:property value="%{menuDesc}" escape="false"/></span>
                    </s:a>
                </li>
            </s:else>
        </s:iterator>
    </ul>
    <!-- sidebar menu end-->
</div>