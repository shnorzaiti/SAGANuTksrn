<%@ taglib prefix="s" uri="/struts-tags"%>


    <s:if test="layout.equals(\"frame\")">
        <s:set name="urlCarian">searchFrameBilPulang</s:set>                 
    </s:if>
    <s:else>
        <s:set name="urlCarian">searchBilPulangLink</s:set>   
    </s:else>
    <s:form cssClass="form-horizontal" namespace="/pemprosesan" action="%{#urlCarian}">
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <i class="fa" id="toggle"></i>
                    <i class="fa fa-arrows-alt"></i>
                </span>
                <h3 class="panel-title">maklumat akaun</h3>
            </div>
            <div class="panel-body" id="panel">
                <div class="form-group">
                    <label class="col-sm-2 control-label">no. akaun :</label>
                    <div class="col-sm-3"> 
                        <s:textfield cssClass="form-control" name="bilPulang.pegAkaun" title="Masukkan No. Akaun Baru" onblur="this.form.submit()"/>
                        <%--     <s:hidden name="bilPulang.PegAkaun" /> --%>
                    </div>
                    <label class="col-sm-2 control-label">kegunaan tanah :</label>
                    <div class="col-sm-3 form-control-static">
                        <s:property value="bilPulang.tnhTnama == null?'-':bilPulang.tnhTnama"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">nama pemilik :</label>
                    <div class="col-sm-3 form-control-static">
                        <s:property value="bilPulang.pmkNmbil == null?'-':bilPulang.pmkNmbil"/>
                    </div>
                    <label class="col-sm-2 control-label">kegunaan hartanah :</label>                            
                    <div class="col-sm-3 form-control-static">
                        <s:property value="bilPulang.hrtHnama"/>
                    </div> 
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">alamat pemilik :</label>
                    <div class="col-sm-3 form-control-static">
                        <s:property value="bilPulang.pvdAlmt1" escape="false"/><br/>
                        <s:property value="bilPulang.PvdAlmt2" escape="false"/><br/>
                        <s:property value="bilPulang.PvdAlmt3" escape="false"/><br/>
                        <s:property value="bilPulang.PvdAlmt4"/>
                    </div>
                    <label class="col-sm-2 control-label">alamat harta :</label>
                    <div class="col-sm-3 form-control-static">
                        <s:property value="bilPulang.adpg1" escape="false"/><br/>
                        <s:property value="bilPulang.adpg2" escape="false"/><br/>
                        <s:property value="bilPulang.adpg3" escape="false"/><br/>
                        <s:property value="bilPulang.adpg4"/>
                    </div> 
                </div>
                <div class="form-group">    
                    <label class="col-sm-2 control-label">status :</label>
                    <div class="col-sm-3 form-control-static">
                        <s:property value="bilPulang.PegStatf == null?'-':bilPulang.PegStatf"/>
                    </div>
                    <label class="col-sm-2 control-label">jenis bangunan :</label>                            
                    <div class="col-sm-3 form-control-static">
                        <s:property value="bilPulang.BgnBnama" escape="false"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">nilai tahunan :</label>
                    <div class="col-sm-3 form-control-static">
                        <s:property value="bilPulang.PegBilpk == null?'-':bilPulang.PegBilpk"/>
                    </div>                        

                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">kadar :</label>
                    <div class="col-sm-3 form-control-static">
                        <s:property value="bilPulang.PmkKdans == null?'-':bilPulang.PmkKdans"/>
                    </div>
                </div>   
                <div class="form-group">                   
                    <label class="col-sm-2 control-label">tahunan :</label>
                    <div class="col-sm-3 form-control-static">
                        <s:property value="bilPulang.PegRjfil == null?'-':bilPulang.PegRjfil"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="operation-button">
                    <s:submit value="Cari Rekod " cssClass="cari"/>
                    <%-- <s:reset value="Padam Carian" cssClass="btn btn-warning"/> --%>
                </div>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="pull-right panel-options">
                    <i class="fa" id="toggle"></i>
                    <i class="fa fa-arrows-alt"></i>
                </span>
                <h3 class="panel-title">maklumat bil pulang</h3>
            </div>
            <div class="panel-body" id="panel">
                <div class="form-group">                           
                    <label class="col-sm-2 control-label">tarikh bil :</label>
                    <div class="col-sm-3">
                        <s:textfield name=""/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">nama penerima :</label>
                    <div class="col-sm-3">
                        <s:textfield name=""/>
                    </div>
                </div>
                <div class="form-group">  
                    <label class="col-sm-2 control-label">catatan :</label>                            
                    <div class="col-sm-3 form-control-static">
                        <s:property value=""/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">pegawai input :</label>
                    <div class="col-sm-3">
                        <s:textfield name=""/>
                    </div>                                                  
                </div>
                <div class="form-group">
                    <div class="operation-button">
                        <s:submit onclick="passData()" value="Simpan Rekod" cssClass="simpan"/> 
                    </div>
                </div>

            </div>                            
            </section>


        </s:form>   
    </div>




