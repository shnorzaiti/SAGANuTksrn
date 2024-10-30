<%-- 
    Document   : mesejBil
    Created on : Disember 6, 2018, 8:27:19 PM
    Author     : Siti Nor Baizura
--%>


<%@ taglib prefix = "s" uri="/struts-tags"%>
<s:include value="../inc2/head_form.jsp"/>

<%--<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>--%>
<!--main content starts here-->
<s:if test="hasActionMessages() || hasActionErrors()">
    <div id="panelUmum pnl" class="panel-body">   
        <!-- messages & error -->
        <s:if test="hasActionMessages()">
            <div class="alert alert-success">
                <a href="#" class="close" data-dismiss="alert"><i class="fa fa-times-circle"></i></a>
                    <s:actionmessage/>
            </div>
        </s:if>
        <s:if test="hasActionErrors()">
            <div class="alert alert-danger">
                <a href="#" class="close" data-dismiss="alert"><i class="fa fa-times-circle"></i></a>
                    <s:actionerror/>                                
            </div>

        </s:if>                                      
        <!-- end messages & error -->    
    </div>
</s:if>  
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="pull-right panel-options">
            <i class="fa" id="toggle"></i>
            <i class="fa fa-arrows-alt"></i>
        </span>
        <h3 class="panel-title">bil taksiran</h3>
    </div>
    <div class="panel-body" id="panel">
        <s:form cssClass="form-horizontal" namespace="/laporan" action="saveMesejBilLink2">

            <div class="form-group">
                <label class="col-sm-2 control-label">Mesej Baris 1 :</label>
                <div class="col-sm-7"> 
                    <s:textfield cssClass="form-control input-sm" name="msj.mnmsej" maxLength="750"/>

                </div>          
            </div>                      
            <div class="form-group">
                <label class="col-sm-2 control-label">Mesej Baris 2 :</label>
                <div class="col-sm-7"> 
                    <s:textfield cssClass="form-control input-sm" name="msj.mnmsj1" maxLength="50"/>

                </div>          
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Mesej Baris 3 :</label>
                <div class="col-sm-7"> 
                    <s:textfield cssClass="form-control input-sm" name="msj.mnmsj2" maxLength="50"/>

                </div>          
            </div>
            <!-- -->


            <div class="form-group">
                <div class="operation-button">                        
                    <button type="submit" class="simpan confirm" data-msg="<s:text name="mesej.simpan"/>"></button>    
                    <s:if test="sts != null">
                        <button type="reset" class="batal"></button>
                    </s:if>
                    <s:else>
                        <button type="reset" class="batal" onclick="javascript:location.href = 'MesejBilLink2'"></button>
                    </s:else>

                </div>
            </div>
        </s:form>
    </div>
</div>


</div> <!-- end panel-body -->
</section> <!-- end panel  -->

<script src="<%=request.getContextPath()%>/jscript/common.js"></script>
<s:include value="../inc2/footer_form.jsp"/>

<%--<s:include value="/sidebar-right.jsp"/>         
<s:include value="/footer-table.jsp"/>   --%>
<%--<s:include value="/footer-form.jsp"/>--%>
<%--<script>
    $(window).load(function() { // makes sure the whole site is loaded
                $('#status').fadeOut(); // will first fade out the loading animation
                $('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
                $('body').delay(350).css({'overflow':'visible'});
        });
</script>--%>
<%--  </body>
</html> --%>
