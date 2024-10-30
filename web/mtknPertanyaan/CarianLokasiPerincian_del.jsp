<%-- 
    Document   : CarianLokasiPerincian
    Created on : Jul 21, 2014, 11:49:32 AM
    Author     : NurMuhammadAfzal
--%>

<%@taglib prefix = "s" uri="/struts-tags"%>
<%@taglib prefix = "s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
    <div class="col-lg-12"> 
        <s:if test="layout.equals(\"frame\")">
            <s:set name="urlAkaun">FramePelMklumatPgangan</s:set>     
            <s:set name="urlList">FramecarianPertanyaanLokasi</s:set>         
            <s:set name="urlDetail">FramePelMklumatPgangan</s:set>      
        </s:if>
        <s:else>
            <s:set name="urlAkaun">PelMklumatPganganLink</s:set> 
            <s:set name="urlList">carianPertanyaanLokasiLink</s:set>     
            <s:set name="urlDetail">PelMklumatPganganLink</s:set>      
        </s:else>


<s:form cssClass="form-horizontal " action="%{#urlAkaun}" namespace="tanya">
<section class="panel">
    <header class="panel-heading">
        Senarai Akaun Aktif / Batal
        <span class="fa tools pull-right">
            <s:if test="module == null || !module.equals(\"MKTN\")">
                <s:a href="%{urlList}" cssClass="btn btn-primary"><i class="fa fa-backward"></i> Kembali </s:a>
                <%--a onclick="goBack()" class="btn btn-primary"><i class="fa fa-backward"></i> Kembali </a--%>
            </s:if>
            <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle"></a>         
        </span>

    </header>
    <div class="panel-body" id="panel">
        <table class="table table-bordered table-responsive table-striped" id="dynamic-table">
            <thead>
                <tr>
                    <th>no. K/P</th>
                    <th>no. akaun</th>                            
                    <th>nama pemilik</th>
                    <th>nilai tahunan (RM)</th>
                    <th>cukai taksiran (RM)</th>
                    <th>status akaun</th>
                    <th>tindakan</th>
                </tr>
            </thead>  
            <s:if test="layout.equals(\"frame\")">
                <s:set name="urlDetail">FramePelMklumatPgangan</s:set>                 
            </s:if>
            <s:else>
                <s:set name="urlDetail">PelMklumatPganganLink</s:set>   
            </s:else> 
            <tbody>
                <s:iterator value="LokasiPerincianList" var="obj">
                    <tr>
                        <td><s:property value="pvdPlgid"/></td>
                        <td><s:property value="pegAkaun"/></td>
                        <td><s:property value="pvdPnama"/></td>
                        <td align="right"><s:property value="pegNilth"/></td>
                        <td align="right"><s:property value="pegTksir"/></td>
                        <td><s:property value="pegStatf"/></td>
                        <td>
                            <%--<s:url var="linkAkaun" action="PelMklumatPganganLink">
                            <s:param name="PelMklumatPgangan.PEgakaun" value="%{PEgakaun}"></s:param>
</s:url>--%>
                            <s:a href="%{#urlDetail}?PelMklumatPgangan.pegAkaun=%{pegAkaun}&LokasiPerincian.pegJlkod=%{LokasiPerincian.pegJlkod}"><i class="fa fa-eye tooltips" data-toggle="tooltip" data-placement="top" title="Lihat Rekod"></i></s:a>
                            </td>
                    </s:iterator>
            </tbody>
        </table>
    </div>                             
</s:form>
</section>
<%--  <s:include value="/sidebar-right.jsp"/>        
  <s:include value="/footer-table.jsp"/> 
  <script>
      $(window).load(function() { // makes sure the whole site is loaded
                  $('#status').fadeOut(); // will first fade out the loading animation
                  $('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
                  $('body').delay(350).css({'overflow':'visible'});
          });
  </script>
</body>
</html>--%>

