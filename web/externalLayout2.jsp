<%@ taglib prefix = "s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head lang="en">
        <title><s:text name="system.name"/></title>
        <link rel="icon" sizes="192x192" href="<%=request.getContextPath()%>/props/img/logo_03.png"> 
        <s:include value="inc2/head.jsp"/>
    </head>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        <!-- sidebar menu -->
                        <tiles:insertAttribute name="menu"/>
                        <!-- /sidebar menu -->
                    </div>
                </div>
                <!-- top navigation -->
                <tiles:insertAttribute name="top" />
                <!-- top navigation -->
                <!-- page content -->
                <div role="main">

                    <!-- top tiles -->
                    <!-- /top tiles -->      
                    <iframe id="blockrandom" class="wrapper" frameborder="0" height="700" width="100%" style="overflow-x:hidden; overflow-y:auto;" align="top" scrolling="yes" src="<%= request.getScheme()%>://<%= request.getServerName()%>:<%= request.getServerPort()%>/<s:property value="url"/>" name="iframe"><%-- onload="iFrameHeight()"--%>

                    </iframe>
                </div>
                <!-- /page content -->

            </div>

        </div>
        <s:include value="inc2/footer.jsp"/>  
        <script>
            $('iframe').load(function () {
                if ($("iframe").length > 0) {
                    var window = this.contentWindow;
                    var prevheight = $("iframe").attr('height');
                    var newheight = Math.max(window.document.body.scrollHeight, window.document.body.offsetHeight
                            , window.document.documentElement.clientHeight, window.document.documentElement.scrollHeight, window.document.documentElement.offsetHeight);
                    if (newheight !== prevheight && newheight > 0) {
                        $("iframe").attr('height', newheight);
                    }
                    //$("iframe").attr('height', $("iframe").attr('height') * 0.96);
                }
            });
                </script>
    </body>
</html>
