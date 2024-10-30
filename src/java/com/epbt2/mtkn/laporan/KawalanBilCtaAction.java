/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.laporan;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.Preparable;
import com.epbt2.util.Breadcrumb;
import com.epbt2.util.DBHelper;
import com.epbt2.util.ValueHelper;
import java.sql.SQLException;

/**
 *
 * @author farisazri
 */
public class KawalanBilCtaAction extends ActionSupport implements Preparable {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;
    private String param7;
    private String param8;
    private String param9;
    private String param10;
    private String param11;
    private String param16;
    private String param9a;

    private String reportName;
    private String stsCetak;
    private String cetakLink;

    //private ValueHelper valHelper = new ValueHelper();
    //private String[] valAkaun = new String[2];
    
    private ValueHelper valHelper = new ValueHelper();
    private String[] valAkaun = new String[2];
    private String[] valJalan = new String[2];
    private String[] valHarta = new String[2];
    private String[] valAbjad = new String[2];
    
    public String execute() {
        return SUCCESS;
    }

    public String cetak() {
        setStsCetak("Y");
        
        if (param9a != null) {
            param9 = param9a; 
        }

        ActionContext sc = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) sc.get(ServletActionContext.HTTP_REQUEST);
        setCetakLink(req.getContextPath() + "/report/cetak?reportName=" + reportName + "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5 + "&param6=" + param6 + "&param7=" + param7 + "&param8=" + param8 + "&param9=" + param9 + "&param10=" + param10 + "&param11=" + param11);
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {


            valAkaun = valHelper.minMaxValue(conn, "AKAUN", "MTKN");

            param1 = valAkaun[0];
            param2 = valAkaun[1];

            valJalan = valHelper.minMaxValue(conn, "JALAN", "MTKN");

            param3 = valJalan[0];
            param4 = valJalan[1];

            valHarta = valHelper.minMaxValue(conn, "HARTA", "MTKN");

            param5 = valHarta[0];
            param6 = valHarta[1];
            
            valAbjad = valHelper.minMaxValue(conn, "ABJAD", "MTKN");

            param7 = valAbjad[0];
            param8 = valAbjad[1];

            
            param16 = "1";
            param9 = "1";
            param10 = "1";

            
            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }

    public String getParam5() {
        return param5;
    }

    public void setParam5(String param5) {
        this.param5 = param5;
    }

    public String getParam6() {
        return param6;
    }

    public void setParam6(String param6) {
        this.param6 = param6;
    }

    public String getParam7() {
        return param7;
    }

    public void setParam7(String param7) {
        this.param7 = param7;
    }

    public String getParam8() {
        return param8;
    }

    public void setParam8(String param8) {
        this.param8 = param8;
    }

    public String getParam9() {
        return param9;
    }

    public void setParam9(String param9) {
        this.param9 = param9;
    }

    public String getParam10() {
        return param10;
    }

    public void setParam10(String param10) {
        this.param10 = param10;
    }

    public String getParam11() {
        return param11;
    }

    public void setParam11(String param11) {
        this.param11 = param11;
    }

    public String getParam16() {
        return param16;
    }

    public void setParam16(String param16) {
        this.param16 = param16;
    }

    public String getParam9a() {
        return param9a;
    }

    public void setParam9a(String param9a) {
        this.param9a = param9a;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }  
    
    public String getStsCetak() {
        return stsCetak;
    }

    public void setStsCetak(String stsCetak) {
        this.stsCetak = stsCetak;
    }

    public String getCetakLink() {
        return cetakLink;
    }

    public void setCetakLink(String cetakLink) {
        this.cetakLink = cetakLink;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName;
    }

}
