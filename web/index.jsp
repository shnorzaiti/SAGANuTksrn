<%-- 
    Document   : index
    Created on : Oct 28, 2014, 2:42:39 PM
    Author     : Uzzair Baharudin
--%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="/inc/head.jsp"/>           
    </head>

    <body>
        <%// response.sendRedirect("indexTaksiran"); %>      
        <% response.sendRedirect(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/ePBT"); %>
    </body>

</html>       
<!--<!DOCTYPE html>
<head>
    <%--<s:include value="head.jsp"/>--%>
</head>

<body>
    <section id="container" >
        header start
        <header class="header fixed-top clearfix">
            <%--<s:include value="top.jsp"/>           --%>
        </header>
        header end
        sidebar start
        <aside>
           <%-- <s:include value="sidebar-left.jsp"/>--%>
        </aside>
        sidebar end
        main content start
        <section id="main-content">
            <section class="wrapper">
              page start
                <div class="row">
                    <div class="col-sm-12">
                        <section class="panel">
                            <header class="panel-heading">
                                Heading goes here..
                                <span class="tools pull-right">
                                    <a href="javascript:;" class="fa fa-chevron-down"></a>              
                                </span>
                            </header>
                            <div class="panel-body">
                                This is a sample page
                            </div>
                        </section>
                    </div> col-sm-12 div
                </div>row div
                 page end
            </section>
        </section>
        main content end
        right sidebar start
        <div class="right-sidebar">
            <%--<s:include value="right-sidebar.jsp"/>--%>
        </div>
        right sidebar end
    </section>
    <%--<s:include value="footer.jsp"/>--%>
</body>
</html>-->
