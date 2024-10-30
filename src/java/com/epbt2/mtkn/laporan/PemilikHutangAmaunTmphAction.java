/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.laporan;

import com.epbt2.common.dao.StdLookupTable;
import com.epbt2.common.dao.StdLookupTableDao;
import com.epbt2.common.dao.StdLookupTableDaoExt;
import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import com.epbt2.util.DBHelper;
import com.epbt2.util.ValueHelper;
import com.opensymphony.xwork2.Preparable;
import java.sql.SQLException;
import java.util.List;
import com.epbt2.util.Breadcrumb;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * @author farisazri
 */
public class PemilikHutangAmaunTmphAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;
    private User userModel = new User();

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private StdLookupTable drop = new StdLookupTable();
    private StdLookupTableDao dropDao = new StdLookupTableDao();
    private StdLookupTableDaoExt dropDaoExt = new StdLookupTableDaoExt();

    private List<StdLookupTable> statusList;
    private List<StdLookupTable> kecualiList;

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
    private String param12;
    private String reportName;
    private String stsCetak;
    private String cetakLink;

    private ValueHelper valHelper = new ValueHelper();
    private String[] valAkaun = new String[2];
    private String[] valJalan = new String[2];
    private String[] valHarta = new String[2];
    private String[] valTrikh = new String[1];
    private String[] valAmaun = new String[2];

    private String reportSize;

    public String execute() {
        return SUCCESS;
    }

    public String cetak() {
        setStsCetak("Y");

        if (reportSize.equals("2")) {
            if (!reportName.contains("_a4") == true) {
                setReportName(reportName + "_a4");
            }
        } else {
            if (reportName.contains("_") == true) {
                setReportName(reportName.substring(0, reportName.lastIndexOf("_")));
            }
        }

        ActionContext sc = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) sc.get(ServletActionContext.HTTP_REQUEST);
        setCetakLink(req.getContextPath() + "/report/cetak?reportName=" + reportName + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5 + "&param6=" + param6 + "&param7=" + param7 + "&param8=" + param8 + "&param10=" + param10 + "&param11=" + param11 + "&param12=" + param12 + "&onama=" + userModel.getUserId());
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {
            setParam1("1");
            setReportName("htts25a");
            setReportSize("2");

            drop.setLookupGroup("STATUS");
            statusList = dropDao.searchMatching(conn, drop, "MTKN");
            param2 = "A";
            
            drop.setLookupGroup("KCL_BIL");
            kecualiList = dropDao.searchMatching(conn, drop, "MTKN");
            param12 = "T";

            /* drop.setLookupGroup("STATUS");
             dropList = dropDao.searchMatching(conn, drop); */
            valAkaun = valHelper.minMaxValue(conn, "AKAUN", "MTKN");

            param3 = valAkaun[0];
            param4 = valAkaun[1];

            valJalan = valHelper.minMaxValue(conn, "JALAN", "MTKN");

            param5 = valJalan[0];
            param6 = valJalan[1];

            valHarta = valHelper.minMaxValue(conn, "HARTA", "MTKN");

            param7 = valHarta[0];
            param8 = valHarta[1];

            valTrikh = valHelper.minMaxValue(conn, "", "MTKN");

            param9 = valTrikh[0];

            valAmaun = valHelper.minMaxValue(conn, "AMAUN", "MTKN");
            param10 = valAmaun[0];
            param11 = valAmaun[1];

            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
    }

    public List<StdLookupTable> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<StdLookupTable> statusList) {
        this.statusList = statusList;
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

    public ValueHelper getValHelper() {
        return valHelper;
    }

    public void setValHelper(ValueHelper valHelper) {
        this.valHelper = valHelper;
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

    public String getReportSize() {
        return reportSize;
    }

    public void setReportSize(String reportSize) {
        this.reportSize = reportSize;
    }

    public User getUserModel() {
        return userModel;
    }

    @Override
    public void setUser(User userModel) {
        this.userModel = userModel;
    }

    public User getUser(User userModel) {
        return this.userModel;
    }

    @Override
    public User getModel() {
        return this.userModel;
    }

    public String getParam12() {
        return param12;
    }

    public void setParam12(String param12) {
        this.param12 = param12;
    }

    public List<StdLookupTable> getKecualiList() {
        return kecualiList;
    }

    public void setKecualiList(List<StdLookupTable> kecualiList) {
        this.kecualiList = kecualiList;
    }
    
    

}