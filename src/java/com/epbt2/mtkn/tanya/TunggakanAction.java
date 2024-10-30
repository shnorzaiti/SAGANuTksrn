/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.common.dao.StdLookupTable;
import com.epbt2.common.dao.StdLookupTableDao;
import com.epbt2.common.dao.StdLookupTableDaoExt;
import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.epbt2.mtkn.pemprosesan.dao.HJenpk;
import com.epbt2.mtkn.pemprosesan.dao.HJenpkDao;
import com.epbt2.mtkn.ref.dao.HLjabt;
import com.epbt2.mtkn.ref.dao.HLjabtDaoExt;
import com.epbt2.mtkn.tanya.dao.HVhtgk;
import com.epbt2.mtkn.tanya.dao.HVhtgkDao;
import com.epbt2.mtkn.tanya.dao.HVhtgkDaoExt;
import com.epbt2.util.Breadcrumb;
import com.epbt2.util.DBHelper;
import com.epbt2.util.ValueHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Hafiz
 */
public class TunggakanAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {

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
    private String jenisReport;

    String amtTmphParam1, amtTmphParam2, amtTmphParam3, amtTmphParam4, amtTmphParam5, amtTmphParam6, amtTmphParam7, amtTmphParam8, amtTmphParam10, amtTmphParam11;

    String pmlkParam1, pmlkParam2, pmlkParam3, pmlkParam4, reportNamePmlk, pmlkParam10, pmlkParam11;

    String syktParam1, syktParam2, reportNameSykt;

    String jlnParam1, jlnParam2, reportNameJln;
    String cbkParam1;

    private HLjabtDaoExt jabtDaoExt = new HLjabtDaoExt();
    private HLjabt jabt = new HLjabt();

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String cetak() {
        setStsCetak("Y");

        ActionContext sc = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) sc.get(ServletActionContext.HTTP_REQUEST);

        if (jenisReport.equals("1")) {
            if (reportSize.equals("2")) {
                if (!reportName.contains("_a4") == true) {
                    setReportName(reportName + "_a4");
                }
            } else if (reportName.contains("_") == true) {
                setReportName(reportName.substring(0, reportName.lastIndexOf("_")));
            }

            setParam1(amtTmphParam1);
            setParam2(amtTmphParam2);
            setParam3(amtTmphParam3);
            setParam4(amtTmphParam4);
            setParam5(amtTmphParam5);
            setParam6(amtTmphParam6);
            setParam7(amtTmphParam7);
            setParam8(amtTmphParam8);
            setParam10(amtTmphParam10);
            setParam11(amtTmphParam11);

            setCetakLink(req.getContextPath() + "/report/cetak?reportName=" + reportName + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5 + "&param6=" + param6 + "&param7=" + param7 + "&param8=" + param8 + "&param10=" + param10 + "&param11=" + param11 + "&param12=" + param12 + "&onama=" + userModel.getUserId());

        } else if (jenisReport.equals("2")) {

            setParam1(pmlkParam1);
            setParam2(pmlkParam2);
            setParam3(pmlkParam3);
            setParam4(pmlkParam4);
            setParam5(pmlkParam10);
            setParam6(pmlkParam11);
            setReportName(reportNamePmlk);

            if (reportSize.equals("2")) {
                if (!reportName.contains("_a4") == true) {
                    setReportName(reportName + "_a4");
                }
            } else if (reportName.contains("_") == true) {
                setReportName(reportName.substring(0, reportName.lastIndexOf("_")));
            }

            setCetakLink(req.getContextPath() + "/report/cetak?reportName=" + reportName + "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5 + "&param6=" + param6 + "&onama=" + userModel.getUserId());

        } else if (jenisReport.equals("3")) {

            setParam1(jlnParam1);
            setParam2(jlnParam2);
            setReportName(reportNameJln);

            if (reportSize.equals("2")) {
                if (!reportName.contains("_a4") == true) {
                    setReportName(reportName + "_a4");
                }
            } else if (reportName.contains("_") == true) {
                setReportName(reportName.substring(0, reportName.lastIndexOf("_")));
            }

            setCetakLink(req.getContextPath() + "/report/cetak?reportName=" + reportName + "&param1=" + param1 + "&param2=" + param2 + "&onama=" + userModel.getUserId());

        } else if (jenisReport.equals("4")) {
            setParam1(cbkParam1);
            retrieveDataCbk();

            setCetakLink(req.getContextPath() + "/report/cetak?reportName=htts28&param1=" + param1 + "&onama=" + userModel.getUserId());

        } else if (jenisReport.equals("5")) {

            setParam1(syktParam1);
            setParam2(syktParam2);
            setReportName(reportNameSykt);

            if (reportSize.equals("2")) {
                if (!reportName.contains("_a4") == true) {
                    setReportName(reportName + "_a4");
                }
            } else if (reportName.contains("_") == true) {
                setReportName(reportName.substring(0, reportName.lastIndexOf("_")));
            }

            setCetakLink(req.getContextPath() + "/report/cetak?reportName=" + reportName + "&param1=" + param1 + "&param2=" + param2 + "&onama=" + userModel.getUserId());
        }

        return SUCCESS;
    }

    public void retrieveDataCbk() {

        try {
            conn = DBHelper.getConnectionDS();

            if (cbkParam1 != null) {

                jabt = jabtDaoExt.maklJabt(conn, cbkParam1);
            }
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());

        } finally {
            DBHelper.closeConnection(conn);
        }

    }

    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {
            jenisReport = "1";

            setAmtTmphParam1("1");
            setReportName("htts25a");
            setReportSize("2");

            drop.setLookupGroup("STATUS");
            statusList = dropDao.searchMatching(conn, drop, "MTKN");
            amtTmphParam2 = "A";

            /* drop.setLookupGroup("STATUS");
             dropList = dropDao.searchMatching(conn, drop); */
            valAkaun = valHelper.minMaxValue(conn, "AKAUN", "MTKN");

            amtTmphParam3 = valAkaun[0];
            amtTmphParam4 = valAkaun[1];

            pmlkParam1 = param3;
            pmlkParam2 = param4;
            syktParam1 = param3;
            syktParam2 = param4;

            valJalan = valHelper.minMaxValue(conn, "JALAN", "MTKN");

            param5 = valJalan[0];
            param6 = valJalan[1];

            amtTmphParam5 = param5;
            amtTmphParam6 = param6;
            pmlkParam3 = param5;
            pmlkParam4 = param6;

            valHarta = valHelper.minMaxValue(conn, "HARTA", "MTKN");

            param7 = valHarta[0];
            param8 = valHarta[1];

            amtTmphParam7 = param7;
            amtTmphParam8 = param8;

            /*valTrikh = valHelper.minMaxValue(conn, "", "MTKN");

            param9 = valTrikh[0];*/
            valAmaun = valHelper.minMaxValue(conn, "AMAUN", "MTKN");
            param10 = valAmaun[0];
            param11 = valAmaun[1];

            amtTmphParam10 = param10;
            amtTmphParam11 = param11;
            pmlkParam10 = param10;
            pmlkParam11 = param11;

            drop.setLookupGroup("KCL_BIL");
            kecualiList = dropDao.searchMatching(conn, drop, "MTKN");
            param12 = "T";

            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());
        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
    }

    public Breadcrumb getbCrumb() {
        return bCrumb;
    }

    public void setbCrumb(Breadcrumb bCrumb) {
        this.bCrumb = bCrumb;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName;
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

    public String getCetakLink() {
        return cetakLink;
    }

    public void setCetakLink(String cetakLink) {
        this.cetakLink = cetakLink;
    }

    public String getReportSize() {
        return reportSize;
    }

    public void setReportSize(String reportSize) {
        this.reportSize = reportSize;
    }

    public String getJenisReport() {
        return jenisReport;
    }

    public void setJenisReport(String jenisReport) {
        this.jenisReport = jenisReport;
    }

    public String getAmtTmphParam1() {
        return amtTmphParam1;
    }

    public void setAmtTmphParam1(String amtTmphParam1) {
        this.amtTmphParam1 = amtTmphParam1;
    }

    public String getAmtTmphParam2() {
        return amtTmphParam2;
    }

    public void setAmtTmphParam2(String amtTmphParam2) {
        this.amtTmphParam2 = amtTmphParam2;
    }

    public String getAmtTmphParam3() {
        return amtTmphParam3;
    }

    public void setAmtTmphParam3(String amtTmphParam3) {
        this.amtTmphParam3 = amtTmphParam3;
    }

    public String getAmtTmphParam4() {
        return amtTmphParam4;
    }

    public void setAmtTmphParam4(String amtTmphParam4) {
        this.amtTmphParam4 = amtTmphParam4;
    }

    public String getAmtTmphParam5() {
        return amtTmphParam5;
    }

    public void setAmtTmphParam5(String amtTmphParam5) {
        this.amtTmphParam5 = amtTmphParam5;
    }

    public String getAmtTmphParam6() {
        return amtTmphParam6;
    }

    public void setAmtTmphParam6(String amtTmphParam6) {
        this.amtTmphParam6 = amtTmphParam6;
    }

    public String getAmtTmphParam7() {
        return amtTmphParam7;
    }

    public void setAmtTmphParam7(String amtTmphParam7) {
        this.amtTmphParam7 = amtTmphParam7;
    }

    public String getAmtTmphParam8() {
        return amtTmphParam8;
    }

    public void setAmtTmphParam8(String amtTmphParam8) {
        this.amtTmphParam8 = amtTmphParam8;
    }

    public String getAmtTmphParam10() {
        return amtTmphParam10;
    }

    public void setAmtTmphParam10(String amtTmphParam10) {
        this.amtTmphParam10 = amtTmphParam10;
    }

    public String getAmtTmphParam11() {
        return amtTmphParam11;
    }

    public void setAmtTmphParam11(String amtTmphParam11) {
        this.amtTmphParam11 = amtTmphParam11;
    }

    public String getPmlkParam1() {
        return pmlkParam1;
    }

    public void setPmlkParam1(String pmlkParam1) {
        this.pmlkParam1 = pmlkParam1;
    }

    public String getPmlkParam2() {
        return pmlkParam2;
    }

    public void setPmlkParam2(String pmlkParam2) {
        this.pmlkParam2 = pmlkParam2;
    }

    public String getPmlkParam3() {
        return pmlkParam3;
    }

    public void setPmlkParam3(String pmlkParam3) {
        this.pmlkParam3 = pmlkParam3;
    }

    public String getPmlkParam4() {
        return pmlkParam4;
    }

    public void setPmlkParam4(String pmlkParam4) {
        this.pmlkParam4 = pmlkParam4;
    }

    public String getPmlkParam10() {
        return pmlkParam10;
    }

    public void setPmlkParam10(String pmlkParam10) {
        this.pmlkParam10 = pmlkParam10;
    }

    public String getPmlkParam11() {
        return pmlkParam11;
    }

    public void setPmlkParam11(String pmlkParam11) {
        this.pmlkParam11 = pmlkParam11;
    }

    public String getReportNamePmlk() {
        return reportNamePmlk;
    }

    public void setReportNamePmlk(String reportNamePmlk) {
        this.reportNamePmlk = reportNamePmlk;
    }

    public String getSyktParam1() {
        return syktParam1;
    }

    public void setSyktParam1(String syktParam1) {
        this.syktParam1 = syktParam1;
    }

    public String getSyktParam2() {
        return syktParam2;
    }

    public void setSyktParam2(String syktParam2) {
        this.syktParam2 = syktParam2;
    }

    public String getReportNameSykt() {
        return reportNameSykt;
    }

    public void setReportNameSykt(String reportNameSykt) {
        this.reportNameSykt = reportNameSykt;
    }

    public String getJlnParam1() {
        return jlnParam1;
    }

    public void setJlnParam1(String jlnParam1) {
        this.jlnParam1 = jlnParam1;
    }

    public String getJlnParam2() {
        return jlnParam2;
    }

    public void setJlnParam2(String jlnParam2) {
        this.jlnParam2 = jlnParam2;
    }

    public String getReportNameJln() {
        return reportNameJln;
    }

    public void setReportNameJln(String reportNameJln) {
        this.reportNameJln = reportNameJln;
    }

    public String getCbkParam1() {
        return cbkParam1;
    }

    public void setCbkParam1(String cbkParam1) {
        this.cbkParam1 = cbkParam1;
    }

    public HLjabt getJabt() {
        return jabt;
    }

    public void setJabt(HLjabt jabt) {
        this.jabt = jabt;
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
