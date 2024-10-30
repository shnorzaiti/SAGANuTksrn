<%-- 
    Document   : InitialStghThn
    Created on : Apr 10, 2014, 2:52:08 PM
    Author     : Hafiz
--%>

<%@ taglib prefix = "s" uri="/struts-tags"%>
<s:include value="../inc2/head_form.jsp"/>
<!--main content starts here-->
<div class="row">
    <div class="col-lg-12">
        <div class="alert alert-success" id="infoMessage" style="display: none;"></div>
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
                </span>
                <h3 class="panel-title"><s:property value="bcName"/></h3>
            </div>

            <div class="panel-body" id="panel">
                <s:form cssClass="form-horizontal" namespace="/pemprosesan" action="saveInitialLink2">    
                    <div class="form-group">
                        <div align="center"><h1 style="color: red"><b>PERHATIAN</b></h1></div>
                        <div align="center"><h4>Sudahkah Anda Melaksanakan Proses Initialisasi Setengah Tahun ?<br>
                            </h4>
                            <p></p><p></p><br><br>

                            <p></p>
                        </div>

                        <div class="form-group">                    
                            <div class="col-sm-12" align="center">
                                <h3>Penggal Sekarang <em class="req">*</em> :  <s:property value="penggal.penggal" /></h3>
                            </div>
                            <s:hidden  cssClass="form-control input-sm" name="penggal.penggal" />
                        </div> 
                            <br>
                        <div class="form-group">
                            <div class="span4 offset4 text-center">                        
                                <button type="submit" class="proses"></button>
                            </div>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
