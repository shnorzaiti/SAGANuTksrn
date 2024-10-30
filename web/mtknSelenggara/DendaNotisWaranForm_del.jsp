<%-- 
    Document   : DendaNotisWaranForm
    Created on : Jul 23, 2014, 4:26:19 PM
    Author     : Hafiz
--%>

<%@ taglib prefix ="s" uri="/struts-tags"%>
<s:include value="../inc2/head_form.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="row">
    <div class="col-lg-12">
            <div id="infoMessage" style="display: none;"></div>
            <s:if test="hasActionMessages() || hasActionErrors()">
                <div id="panelUmum" class="panel-body">   
                    <!-- messages & error -->
                    <s:if test="hasActionMessages()">
                        <div class="alert alert-success">
                            <a href="#" class="close" data-dismiss="alert">×</a>
                            <s:actionmessage/>
                        </div>
                    </s:if>
                    <s:if test="hasActionErrors()">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert">×</a>
                            <s:actionerror/>                                
                        </div>
                    </s:if>                                      
                    <!-- end messages & error -->    
                </div>
            </s:if>
        <div class="panel panel-default">

            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <%--s:a cssClass="btn btn-primary" action="maklPeganganLink2?maklPgng.mjaTkhpl=%{maklUmum.mjcTkhpl}">
                        <i class="fa fa-backward"></i>
                        Kembali
                    </s:a--%>
                    <i class="fa" id="toggle"></i>

                </span>
                <h3 class="panel-title"> Selenggara Kadar Denda / Notis E / Waran F </h3>
            </div>


            <!-- end messages & error -->
            <div class="panel-body" id="panel">      
                <!--try -->

                <!--try end -->
                <s:form id="HKadar" cssClass="form-horizontal" namespace="selenggara" action="saveHKadarFormLink2" method="post">  

                    <div class="form-group">
                        <label class="col-sm-3 control-label"><s:text name="obj.KDrstatf"/>  <span class="req">*</span> :</label>

                        <!-- LOV -->
                        <div class="col-sm-3">

                            <%--:<s:property value="Count"/>:<s:property value="HKadar.rowID"/>: 
                              :<s:property value="KDrdesc"/>:--%>

                            <s:if test="HKadar.rowID == null">
                                <s:select name="HKadar.KDrstatf" headerKey="" headerValue="Pilihan" list="SenaraiHKadar" listKey="lookupCode" listValue="lookupDesc" cssClass="form-control input-sm"/>              
                                <span class="text-warning"><s:fielderror><s:param>HKadar.KDrstatf</s:param> </s:fielderror></span>
                            </s:if>   
                            <s:else>
                                <s:hidden name="HKadar.rowID"/> 
                                <s:hidden name="HKadar.rowNum"/> 
                                <s:hidden name="HKadar.KDrstatf"/>
                                <b><s:property value="HKadar.KDrdesc"/></b>
                                <s:fielderror><s:param>HKadar.KDrstatf</s:param> </s:fielderror>
                            </s:else>

                        </div>
                        <!-- LOV -->   

                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label"><s:text name="obj.KDrlower"/>  <span class="req">*</span> :</label>
                        <div class="input-group col-sm-3">
                            <span class="input-group-addon">RM</span>
                            <s:textfield size="" name="HKadar.KDrlower" cssClass="form-control input-sm decimal amount" maxLength="10"/>
                            <s:fielderror> <s:param>HKadar.KDrlower</s:param> </s:fielderror>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><s:text name="obj.KDrupper"/>  <span class="req">*</span> :</label>
                        <div class="input-group col-sm-3">
                            <span class="input-group-addon">RM</span>
                            <s:textfield size="" name="HKadar.KDrupper" cssClass="form-control input-sm decimal amount" maxLength="10"/>
                            <s:fielderror> <s:param>HKadar.KDrupper</s:param> </s:fielderror>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><s:text name="obj.KDramaun"/>  <span class="req">*</span> :</label>
                        <div class="input-group col-sm-3">
                            <span class="input-group-addon">RM</span>
                            <s:textfield size="" name="HKadar.KDramaun" cssClass="form-control input-sm decimal amount" maxLength="7"/>
                            <s:fielderror> <s:param>HKadar.KDramaun</s:param> </s:fielderror>
                                </div> 
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><s:text name="obj.KDraminc"/> <span class="req">*</span> :</label>
                        <div class="input-group col-sm-3">
                            <span class="input-group-addon">RM</span>
                            <s:textfield size="" name="HKadar.KDraminc" cssClass="form-control input-sm decimal amount" maxLength="7"/>
                            <s:fielderror> <s:param>HKadar.KDraminc</s:param> </s:fielderror>
                                </div> 
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><s:text name="obj.KDrincre"/> <span class="req">*</span> :</label>
                        <div class="input-group col-sm-3">
                            <span class="input-group-addon">RM</span>
                            <s:textfield size="" name="HKadar.KDrincre" cssClass="form-control input-sm decimal amount" maxLength="7"/>
                            <s:fielderror> <s:param>HKadar.KDrincre</s:param> </s:fielderror>
                                </div> 
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><s:text name="obj.KDrpcent"/> <span class="req">*</span> :</label>
                        <div class="input-group col-sm-2">
                            <s:textfield size="" name="HKadar.KDrpcent" cssClass="form-control input-sm int number" maxLength="2"/>
                            <span class="input-group-addon">%</span>
                            <s:fielderror> <s:param>HKadar.KDrpcent</s:param> </s:fielderror>
                                </div> 
                            </div>
                            <div id="butang" class="operation-button">                        
                            <button type="submit" class="simpan confirm" data-msg="<s:text name="mesej.simpan"/>"></button>
                                <button type="reset" value="reset" class="batal"></button>
                    </div>

                </s:form> 
            </div>
        </div>
    </div>
</div>
<script>
    function passData()
    {
        window.parent.location.reload(true);
        window.parent.$("#modaHKadar").modal('hide');
        window.parent.$(".modal-backdrop").hide();
    }
</script>
<%-- <s:include value="/sidebar-right.jsp"/> --%>
<s:include value="../inc2/footer_form.jsp"/>
<script>
    $(window).load(function() { // makes sure the whole site is loaded
        $('#status').fadeOut(); // will first fade out the loading animation
        $('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
        $('body').delay(350).css({'overflow': 'visible'});
    });
</script> 