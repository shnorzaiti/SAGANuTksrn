/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.laporan;

/**
 *
 * @author farisazri
 */
import com.epbt2.common.dao.StdLookupTable;
import com.epbt2.common.dao.StdLookupTableDao;
import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.epbt2.util.DBHelper;
import com.epbt2.util.ValueHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Preparable;
import java.sql.SQLException;
import com.epbt2.util.Breadcrumb;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class pengumuranThunanAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;
    private User userModel = new User();

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
    private String reportName;
    private String stsCetak;
    private String cetakLink;
    private String reportFormat;
    private String kumpPengguna;

    private ValueHelper valHelper = new ValueHelper();
    private String[] valAkaun = new String[2];
    private String[] valJalan = new String[2];
    private String[] valHarta = new String[2];
    private String[] valAmaun = new String[2];

    private StdLookupTable ref = new StdLookupTable();
    private StdLookupTableDao refDao = new StdLookupTableDao();

    private List<StdLookupTable> statusList;
    private List<StdLookupTable> formatList;

    public String execute() {
        return SUCCESS;
    }

    public String save() throws Exception {
        log.debug("Inside save()");
        conn = DBHelper.getConnectionDS();

        try {
            String[] msgArgs = {""};
            cetak();
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return SUCCESS;
    }

    public String cetak() throws SQLException {
        setStsCetak("Y");
        ActionContext sc = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) sc.get(ServletActionContext.HTTP_REQUEST);
        

        log.debug("Inside Cetak");
        log.debug("Pilih :" + param1);
        log.debug("bulan :" + param2);
        log.debug("tahun :" + param3);
        log.debug("trikhDr :" + param4);
        log.debug("trikhHg :" + param5);
        log.debug("jenis laporan :" + reportName);
        if (reportFormat == null) {
            if (reportName.equals("httl35")) {
                log.debug("jenis laporan1 :" + reportName);
                setCetakLink(req.getContextPath() + "/report/cetak?reportName=" + reportName + "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5 + "&param6=" + param6 + "&param7=" + param7 + "&param8=" + param8 + "&onama=" + userModel.getUserId());
                return SUCCESS;
            } else {
                log.debug("jenis laporan2 :" + reportName);
                msk_httl36(conn);
                setCetakLink(req.getContextPath() + "/report/cetak?reportName=" + reportName + "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5 + "&param6=" + param6 + "&param7=" + param7 + "&param8=" + param8 + "&onama=" + userModel.getUserId());
                return SUCCESS;
            }
        } else {
            if (reportName.equals("httl35")) {
                log.debug("jenis laporan1 :" + reportName);
                setCetakLink(req.getContextPath() + "/report/cetak?reportFormat=" + reportFormat + "&reportName=" + reportName + "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5 + "&param6=" + param6 + "&param7=" + param7 + "&param8=" + param8 + "&onama=" + userModel.getUserId());
                return SUCCESS;
            } else {
                log.debug("jenis laporan2 :" + reportName);
                msk_httl36(conn);
                setCetakLink(req.getContextPath() + "/report/cetak?reportFormat=" + reportFormat + "&reportName=" + reportName + "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5 + "&param6=" + param6 + "&param7=" + param7 + "&param8=" + param8 + "&onama=" + userModel.getUserId());
                return SUCCESS;
            }
        }

    }

    public void msk_httl36(Connection conn) throws SQLException {

        String sql = "{ call irep.irep_httl36 } ";
        System.out.println(sql);
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            stmt = conn.prepareCall(sql);

            result = stmt.executeQuery();

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {

            ref.setLookupGroup("STATUS");
            statusList = refDao.searchMatching(conn, ref, "MTKN");

            valAkaun = valHelper.minMaxValue(conn, "AKAUN", "MTKN");

            param1 = valAkaun[0];
            param2 = valAkaun[1];

            valJalan = valHelper.minMaxValue(conn, "JALAN", "MTKN");

            param3 = valJalan[0];
            param4 = valJalan[1];

            valHarta = valHelper.minMaxValue(conn, "HARTA", "MTKN");

            param5 = valHarta[0];
            param6 = valHarta[1];

            valAmaun = valHelper.minMaxValue(conn, "AMAUN", "MTKN");
            param7 = valAmaun[0];
            param8 = valAmaun[1];

            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

            kumpPengguna = userModel.getUserGroupId();

            ref.setLookupGroup("FORMAT");
            formatList = refDao.searchMatching(conn, ref, "SPBT");

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

    public ValueHelper getValHelper() {
        return valHelper;
    }

    public void setValHelper(ValueHelper valHelper) {
        this.valHelper = valHelper;
    }

    public String[] getValAkaun() {
        return valAkaun;
    }

    public void setValAkaun(String[] valAkaun) {
        this.valAkaun = valAkaun;
    }

    public String[] getValJalan() {
        return valJalan;
    }

    public void setValJalan(String[] valJalan) {
        this.valJalan = valJalan;
    }

    public String[] getValHarta() {
        return valHarta;
    }

    public void setValHarta(String[] valHarta) {
        this.valHarta = valHarta;
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

    public String getReportFormat() {
        return reportFormat;
    }

    public void setReportFormat(String reportFormat) {
        this.reportFormat = reportFormat;
    }

    public String getKumpPengguna() {
        return kumpPengguna;
    }

    public void setKumpPengguna(String kumpPengguna) {
        this.kumpPengguna = kumpPengguna;
    }

    public List<StdLookupTable> getFormatList() {
        return formatList;
    }

    public void setFormatList(List<StdLookupTable> formatList) {
        this.formatList = formatList;
    }
}
