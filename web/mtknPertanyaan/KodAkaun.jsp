<%-- 
    Document   : 1
    Created on : May 24, 2014, 11:06:02 AM
    Author     : NurMuhammadAfzal

AkaunLama.jsp / PelMklumatPgangan.jsp / PelMklumatPmilik.jsp

--%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="/head-form.jsp"/>                 


    </head>
    <body>
        <s:include value="/top.jsp"/>    
        <s:include value="/sidebar-left.jsp"/> 
        <!-- Preloader -->
        <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>
        <form class="form-horizontal">
            <section class="panel">

                <header class="panel-heading">
                    MAKLUMAT PEGANGAN MILIK
                    <span class="tools pull-right">
                        <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle"></a>                   
                    </span>
                </header>
                <div class="panel-body" id="panel">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">No. Akaun :</label>
                        <div class="col-sm-2">
                            <s:textfield cssClass="form-control input-sm" name="PelMklumatPgangan.PEgakaun" onblur="this.form.submit()"/>
                        </div>


                        <label class="col-sm-2 control-label">Akaun Lama :</label>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.PEgoldac"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">No. K/P :</label>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.PMkplgid"/>
                        </div>                        
                        <label class="col-sm-2 control-label">No. Hakmilik :</label>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.PMkhkmlk"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Bil. Pemilik :</label>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.PEgbilpk"/>
                        </div>                        
                        <label class="col-sm-2 control-label">Rujukan Fail :</label>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.PEgrjfil"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Nama Pemilik :</label>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.PMknmbil"/>
                        </div>                        
                    </div>

                    <div class="form-group">    
                        <label class="col-sm-2 control-label">Alamat Pemilik :</label>
                        <div class="col-sm-8">
                            <s:property value="PelMklumatPgangan.PVdalmt1"/>
                            <s:property value="PelMklumatPgangan.PVdalmt2"/>
                            <s:property value="PelMklumatPgangan.PVdalmt3"/>
                            <s:property value="PelMklumatPgangan.PVdalmt4"/>
                        </div>
                    </div>
                </div>  
            </section>
            <section class="panel">

                <header class="panel-heading">
                    MAKLUMAT PEGANGAN HARTA
                    <span class="tools pull-right">
                       <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle2"></a>                                                   
                    </span>


                </header>
                <div class="panel-body" id="panel2">

                    <div class="form-group form-control-static">
                        <label class="col-sm-2 control-label">Kegunaan Tanah :</label>
                        <div class="col-sm-1"><s:property value="PelMklumatPgangan.PEgthkod"/></div>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.TNhtnama"/>
                        </div>                        
                        <label class="col-sm-2 control-label">Kegunaan Hartanah :</label>
                        <div class="col-sm-1">
                            <s:property value="PelMklumatPgangan.PEghtkod"/>
                        </div>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.HRthnama"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Jenis Pemilik :</label>
                        <div class="col-sm-1">
                            <s:property value="PelMklumatPgangan.PEgjpkod"/>
                        </div> 
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.JPkjnama"/>
                        </div> 
                        <label class="col-sm-2 control-label">Jenis Bangunan :</label>
                        <div class="col-sm-1">
                            <s:property value="PelMklumatPgangan.PEgbgkod"/>
                        </div>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.BGnbnama"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Struktur Bangunan:</label>
                        <div class="col-sm-1">
                            <s:property value="PelMklumatPgangan.PEgstkod"/>
                        </div>    
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.STbsnama"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Alamat Harta :</label>
                        <div class="col-sm-8">
                            <s:property value="PelMklumatPgangan.ADpg1"/>
                            <s:property value="PelMklumatPgangan.ADpg2"/>
                            <s:property value="PelMklumatPgangan.ADpg3"/>
                            <s:property value="PelMklumatPgangan.ADpg4"/>
                        </div>                                                           
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Status Pegangan :</label>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.PEgstatk"/>
                        </div>                        
                        <label class="col-sm-2 control-label">No. P.T :</label>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.PEgnompt"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">No. Pelan :</label>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.PEgpelan"/>
                        </div>                        
                        <label class="col-sm-2 control-label">Nilai Tahunan :</label>                                            <div class="col-sm-3">
                            <div class="input-group">
                                <span>RM</span>
                                <s:property value="PelMklumatPgangan.PEgnilth"/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-2 control-label">Kadar Peratus :</label>
                        <div class="col-sm-3">
                            <div class="input-group">
                                <s:property value="PelMklumatPgangan.KAwkadar"/>
                                <span>&#37;</span>
                            </div>
                        </div>

                        <label class="col-sm-2 control-label">Taksiran Tahunan :</label>                                         <div class="col-sm-3">
                            <div class="input-group">
                                <span>RM</span>
                                <s:property value="PelMklumatPgangan.PEgtksir"/>
                            </div>
                        </div>
                    </div>    

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Tarikh O.C. :</label>
                        <div class="col-sm-3">
                            <div class="input-group" >
                                <s:property value="PelMklumatPgangan.PEgtkhoc"/>
                                <span class="input-group-addon"><i class=""></i></span>
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">Tarikh ACM :</label>
                        <div class="col-sm-3">
                            <div class="input-group" >
                                <s:property value="PelMklumatPgangan.PEgtkhpl"/>
                                <span class="input-group-addon"><i class=""></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Tarikh Kuatkuasa:</label>
                        <div class="col-sm-3">
                            <div class="input-group">
                                <s:property value="PelMklumatPgangan.PEgtkhtk"/>
                                <span class="input-group-addon"><i class=""></i></span>
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">Luas Bangunan :</label>
                        <div class="col-sm-3">
                            <s:property value="PelMklumatPgangan.PEglsbgn"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Luas Tanah :</label>
                        <div class="col-sm-3">
                            <s:property  value="PelMklumatPgangan.PEglstnh"/>
                        </div>                        
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Rujukan MMK :</label>
                        <div class="col-sm-6">
                            <s:property value="PelMklumatPgangan.PEgrjmmk"/>
                        </div>
                    </div>                  
                </div>


            </section>            

      

        <section class="panel">

            <header class="panel-heading">
                PELBAGAI MAKLUMAT PEMILIK
                <span class="tools pull-right">
                    <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle3"></a>                   
                </span>
            </header>
            <div class="panel-body" id="panel3">
                <div class="form-group">
                    <label class="col-sm-2 control-label">No. Akaun :</label>
                    <div class="col-sm-2">
                        <select name="select" class="form-control input-sm">
                            <option>Display</option>
                            <option>67890</option>
                            <option>12345</option>
                            <option>67890</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">No. K/P / Pendaftaran :</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control input-sm">

                    </div>
                    <label class="col-sm-2 control-label">Status :</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-sm">
                    </div>    
                </div>


                <div class="form-group">
                    <label class="col-sm-2 control-label">Bangsa :</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control imput-sm">
                    </div>
                    <label class="col-sm-2 control-label">Kod Ansuran :</label>
                    <div class="col-sm-2">
                        <select name="select" class="form-control input-sm">
                            <option>Ya</option>
                            <option>Tidak</option>
                            <option>12345</option>
                            <option>67890</option>
                        </select>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-2 control-label">Dikecualikan Bil :</label>
                    <div class="col-sm-2">
                        <select name="select" class="form-control input-sm">
                            <option>Ya </option>
                            <option>Tidak</option>
                            <option>12345</option>
                            <option>67890</option>
                        </select>
                    </div>
                    <label class="col-sm-3 control-label">Peratus Taksiran :</label>
                    <div class="col-sm-2">
                        <div class="input-group">
                            <input type="text" class="form-control input-sm">
                            <span class="input-group-addon">&#37;</span>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nama Pemilik :</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control input-sm">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Alamat Pemilik :</label>
                    <div class="col-sm-3">
                        <textarea rows="6" cols="70" class="form-control input-sm"></textarea>
                    </div>
                </div>

                <header class="panel-heading">
                    MAKLUMAT HARTA
                    <span class="tools pull-right"></span>
                </header>
                <div class="panel-body">


                    <div class="form-group">
                        <label class="col-sm-2 control-label">No. Hakmilik :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                        <label class="col-sm-2 control-label">Kegunaan Hartanah :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Alamat Harta :</label>
                        <div class="col-sm-3">
                            <textarea rows="6" cols="70" class="form-control input-sm"></textarea>
                        </div>
                    </div>


                </div>   
                <header class="panel-heading">
                    MAKLUMAT MAJLIS
                    <span class="tools pull-right">
                        <a  class="tooltips" data-toggle="tooltip" data-placement="bottom" id="toggle4"></a>                   
                    </span>
                </header>
                <div class="panel-body" id="panel4">    

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Rujukan Majlis :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                        <label class="col-sm-2 control-label">No. Jilid :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Rujukan Fail :</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control input-sm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Nilai Tahunan :</label>
                        <div class="col-sm-3">
                            <div class="input-group">
                                <span class="input-group-addon">RM</span>
                                <input type="text" class="form-control input-sm">
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">Kadar Peratus :</label>
                        <div class="col-sm-3">
                            <div class="input-group">
                                <input type="text" class="form-control input-sm">
                                <span class="input-group-addon">&#37;</span>
                            </div>
                        </div>    
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Taksiran Tahunan :</label>
                        <div class="col-sm-3">
                            <div class="input-group">
                                <span class="input-group-addon">RM</span>
                                <input type="text" class="form-control input-sm">
                            </div>
                        </div>
                    </div>   


                    <div class="span4 offset4 text-center">                        
                        <button type="submit" class="btn btn-primary">Simpan</button>
                        <button type="reset" class="btn btn-primary">Batal</button>
                    </div>
                </div>   
            </div>                            
        </section>
    </form>   

    <!-- Pelbagai Maklumat Pemilik -->
    <s:include value="/sidebar-right.jsp"/> 
    <s:include value="/footer-form.jsp"/> 
    <script>
            $(window).load(function() { // makes sure the whole site is loaded
			$('#status').fadeOut(); // will first fade out the loading animation
			$('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
			$('body').delay(350).css({'overflow':'visible'});
		});
        </script>
</body>
</html>
