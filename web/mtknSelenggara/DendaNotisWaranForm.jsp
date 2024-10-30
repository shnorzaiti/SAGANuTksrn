<%-- 
    Document   : DendaNotisWaranForm
    Created on : Jul 21, 2016, 10:17:10 AM
    Author     : Baizura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="../inc2/head_form.jsp"/>
<div class="row">
    <div class="col-lg-12">  
        <div id="infoMessage" style="display: none;"></div>   
        <s:if test="hasActionMessages() || hasActionErrors()">
            <div id="panelUmum pnl" class="panel-body">   
                <!-- messages & error -->
                <s:if test="hasActionMessages()">
                    <div class="alert alert-success">
                        <a href="#" class="close" data-dismiss="alert">�</a>
                        <s:actionmessage/>
                    </div>
                </s:if>
                <s:if test="hasActionErrors()">
                    <div class="alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert">�</a>
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
                <h3 class="panel-title"><s:property value="bcName"/></h3>
            </div>
            <div class="panel-body" id="panel">
                <s:form id="dendaNotisWaranForm" action="saveHKadarLink2" method="post" cssClass="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><s:text name="obj.KDrstatf"/> :<em class="req">*</em></label>
                        <div class="col-sm-4 form-control-static">
                            <s:select id="KDrstatf" name="HKadar.KDrstatf" headerKey="" headerValue="--- Pilih Jenis Kadar ---" list="SenaraiHKadar" listKey="lookupCode" listValue="lookupDesc" cssClass="form-control input-sm" title="Jenis Kadar" onchange="reloadMaklumat(this.form, 'HKadarLink2')" cssErrorClass="decoratedErrorField"/>              
                            <span class="req"><s:fielderror><s:param>HKadar.KDrstatf</s:param> </s:fielderror></span>
                                </div>
                            </div>

                            <div class="table-responsive">
                                <div class="col-sm-3 col-sm-offset-9">
                                    <div class="btn-group">
                                        <a id="addDendaNotis" class="tambah" href="#"></a>
                                    </div>           
                                    <div class="btn-group">
                                        <a id="addBuang" class="buang confirm" href="#" data-msg="<s:text name="mesej.buang"/>" formId="dendaNotisWaranForm"></a>
                            </div>           
                        </div>
                        <br/><br/>
                        <div class="col-sm-12">
                            <table id="dendaNotisTable" class="table table-bordered table-condensed table-responsive table-striped">
                                <thead>
                                    <tr>                    
                                        <th>Dari (RM)</th>
                                        <th>Hingga (RM)</th>
                                        <th>Amaun (RM)</th>
                                        <th>Gandaan Tambahan (RM)</th>
                                        <th>Gandaan Amaun (RM)</th>
                                        <th>Peratus (%)</th>
                                        <th>Tindakan</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:if test="HKadarList == null"> 
                                        <tr>
                                            <td colspan="7">Tiada rekod dijumpai.</td>
                                        </tr>
                                    </s:if>
                                    <s:else>

                                        <s:if test="HKadarList.size() == 0">

                                            <tr>
                                                <td>
                                                    <s:hidden id="HKadarList[0].KDrstatf" name="HKadarList[0].KDrstatf" value="%{HKadar.KDrstatf}" cssClass="form-control input-sm" maxLength="2" cssErrorClass="decoratedErrorField"/>
                                                    <s:textfield size="" name="HKadarList[0].KDrlower" cssClass="form-control input-sm decimal amount" maxLength="10"/>
                                                    <span class="req"><s:fielderror> <s:param>HKadarList[0].KDrlower</s:param> </s:fielderror></span>
                                                        </td>
                                                        <td>
                                                    <s:textfield size="" name="HKadarList[0].KDrupper" cssClass="form-control input-sm decimal amount" maxLength="10"/>
                                                    <span class="req"><s:fielderror> <s:param>HKadarList[0].KDrupper</s:param> </s:fielderror></span>
                                                        </td>
                                                        <td>
                                                    <s:textfield size="" name="HKadarList[0].KDramaun" cssClass="form-control input-sm decimal amount" maxLength="7"/>
                                                    <span class="req"><s:fielderror> <s:param>HKadarList[0].KDramaun</s:param> </s:fielderror></span>
                                                        </td>
                                                        <td>
                                                    <s:textfield size="" name="HKadarList[0].KDraminc" cssClass="form-control input-sm decimal amount" maxLength="7"/>
                                                    <span class="req"><s:fielderror> <s:param>HKadarList[0].KDraminc</s:param> </s:fielderror></span>
                                                        </td>
                                                        <td>
                                                    <s:textfield size="" name="HKadarList[0].KDrincre" cssClass="form-control input-sm decimal amount" maxLength="7"/>
                                                    <span class="req"><s:fielderror> <s:param>HKadarList[0].KDrincre</s:param> </s:fielderror></span>
                                                        </td>
                                                        <td>
                                                    <s:textfield size="" name="HKadarList[0].KDrpcent" cssClass="form-control input-sm int number" maxLength="2"/>
                                                    <span class="req"><s:fielderror> <s:param>HKadarList[0].KDrpcent</s:param> </s:fielderror></span>
                                                        </td>
                                                        <td>&nbsp;</td>
                                                    </tr>
                                        </s:if>
                                        <s:else>                                                        <s:iterator value="HKadarList" var="kadar" status="kadarSts">

                                                <tr>
                                                    <td>
                                                        <s:hidden id="HKadarList[%{#kadarSts.index}].rowID" name="HKadarList[%{#kadarSts.index}].rowID" cssClass="form-control input-sm" cssErrorClass="decoratedErrorField"/>
                                                        <s:hidden id="HKadarList[%{#kadarSts.index}].KDrstatf" name="HKadarList[%{#kadarSts.index}].KDrstatf" value="%{HKadar.KDrstatf}" cssClass="form-control input-sm" maxLength="2" cssErrorClass="decoratedErrorField"/>
                                                        <s:textfield size="" name="HKadarList[%{#kadarSts.index}].KDrlower" cssClass="form-control input-sm decimal amount" maxLength="10"/>                                                   
                                                        <span class="req"><s:fielderror><s:param><s:property value="HKadarList[%{#kadarSts.index}].KDrlower"/></s:param> </s:fielderror></span>
                                                            </td>
                                                            <td>
                                                        <s:textfield size="" name="HKadarList[%{#kadarSts.index}].KDrupper" cssClass="form-control input-sm decimal amount" maxLength="10"/>                                                   
                                                        <span class="req"><s:fielderror><s:param><s:property value="HKadarList[%{#kadarSts.index}].KDrupper"/></s:param> </s:fielderror></span>
                                                            </td>
                                                            <td>
                                                        <s:textfield size="" name="HKadarList[%{#kadarSts.index}].KDramaun" cssClass="form-control input-sm decimal amount" maxLength="7"/>                                                         
                                                        <span class="req"><s:fielderror><s:param><s:property value="HKadarList[%{#kadarSts.index}].KDramaun"/></s:param> </s:fielderror></span>
                                                            </td>
                                                            <td>
                                                        <s:textfield size="" name="HKadarList[%{#kadarSts.index}].KDraminc" cssClass="form-control input-sm decimal amount" maxLength="7"/>
                                                        <span class="req"><s:fielderror><s:param><s:property value="HKadarList[%{#kadarSts.index}].KDraminc"/></s:param> </s:fielderror></span>
                                                            </td>
                                                            <td>
                                                        <s:textfield size="" name="HKadarList[%{#kadarSts.index}].KDrincre" cssClass="form-control input-sm decimal amount" maxLength="7"/>
                                                        <span class="req"><s:fielderror><s:param><s:property value="HKadarList[%{#kadarSts.index}].KDrincre"/></s:param> </s:fielderror></span>
                                                            </td>
                                                            <td>
                                                        <s:textfield size="" name="HKadarList[%{#kadarSts.index}].KDrpcent" cssClass="form-control input-sm int number" maxLength="2"/>   
                                                        <span class="req"><s:fielderror><s:param><s:property value="HKadarList[%{#kadarSts.index}].KDrpcent"/></s:param> </s:fielderror></span>
                                                            </td>
                                                            <td>                                               <s:checkbox id="HKadarList[%{#kadarSts.index}].stsBuang" name="HKadarList[%{#kadarSts.index}].stsBuang" cssClass="form-control input-sm checkbox"/>      </td>
                                                </tr>
                                            </s:iterator>
                                        </s:else>
                                    </s:else>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-sm-3 col-sm-offset-9">
                        <div class="btn-group">
                            <a id="addDendaNotis2" class="tambah" href="#"></a>
                        </div>           
                        <div class="btn-group">
                            <a id="addBuang2" class="buang confirm" href="#" data-msg="<s:text name="mesej.buang"/>" formId="dendaNotisWaranForm"></a>
                        </div>                    
                    </div>
                    <br/>
                    <div class="form-group">
                        <div class="operation-button">                        
                            <button type="submit" class="simpan confirm" data-msg="<s:text name="mesej.simpan"/>"></button>
                            <%--button type="reset" class="batal" onclick="javascript:location.href = 'HKadarLink2';"></button--%>
                        </div>
                    </div> 
                </div>
            </s:form>
        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/jscript/common.js"></script>
<script>
                                $("#addDendaNotis,#addDendaNotis2").click(function () {
                                    $("#dendaNotisTable tbody tr:last")
                                            .clone(true)
                                            .appendTo("#dendaNotisTable")
                                            .each(function () {

                                                var index = $("#dendaNotisTable tbody tr:last").index();

                                                $(this).find("input:text, input:hidden").each(function () {
                                                    this.name = this.name.replace(/\[(\d+)\]/g, '[' + (index) + ']');
                                                    this.id = this.id.replace(/\[(\d+)\]/g, '[' + (index) + ']');
                                                    this.value = "";
                                                });

                                                $(this).find("div").each(function () {
                                                    this.id = this.id.replace(/\[(\d+)\]/g, '[' + (index) + ']');
                                                });
                                                $(this).find("input[id$='KDrstatf']").val($('#KDrstatf').val());
                                                /*$(this).find("div[id$='kwkodText']").html("");
                                                 $(this).find("input[id$='kwsMkkod']").val($('#kwsMkkodMain').val());*/

                                                $(this).find("input[id$='stsBuang']").remove();
                                                $(this).find("a").remove();
                                                $(this).find("td:last").append('<a href="#" onclick="javascript:$(this).closest(\'tr\').remove();"><i class="fa fa-trash-o  tooltips" title="Padam Baris" alt="delete" ></i></a>');
                                            });
                                    goToByScroll("dendaNotisTable tbody tr:last td:last");

                                });

                                $("#addBuang,#addBuang2").click(function () {
                                    $('form[id=dendaNotisWaranForm]').attr('action', 'deleteHKadarLink2');
                                    //$('form[id=jAduan]').submit();
                                });
</script>
<s:include value="../inc2/footer_form.jsp"/>  