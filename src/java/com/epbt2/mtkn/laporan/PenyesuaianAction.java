/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.laporan;

import com.epbt2.common.dao.StdLookupTable;
import com.epbt2.common.dao.StdLookupTableDao;
import com.epbt2.common.dao.StdLookupTableDaoExt;
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
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author shahr
 */
public class PenyesuaianAction extends ActionSupport implements Preparable {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private StdLookupTable drop = new StdLookupTable();
    private StdLookupTableDao dropDao = new StdLookupTableDao();
    private StdLookupTableDaoExt dropDaoExt = new StdLookupTableDaoExt();

    private List<StdLookupTable> statusList;

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

    private String reportName;
    private String stsCetak;
    private String cetakLink;

    private ValueHelper valHelper = new ValueHelper();
    private String[] valAkaun = new String[2];
    private String[] valJalan = new String[2];
    private String[] valAmaun = new String[2];

    private String reportFormat;
    private String tahun;

    public String cetak() {
        setStsCetak("Y");

        ActionContext sc = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) sc.get(ServletActionContext.HTTP_REQUEST);

        if (reportName.equals("httl30")) {
             log.debug("Inside reportName() : "+ tahun);
            setCetakLink(req.getContextPath() + "/report/cetak?reportName=httl30" + "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5 + "&param6=" + param6 + "&param7=" + param7 + "&param8=" + param8 + "&param9=" + param9);
        } else {
             log.debug("Inside reportName() : "+ tahun);
            setCetakLink(req.getContextPath() + "/report/cetak?reportName=htl30jl" + "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 +  "&param5=" + param5 + "&param6=" + param6 + "&param7=" + param7 + "&param8=" + param8 + "&param9=" + param9 + "&param10=" + tahun );
        }
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {

            drop.setLookupGroup("STATUS");
            statusList = dropDao.searchMatching(conn, drop, "MTKN");
            param5 = "A";

            /* drop.setLookupGroup("STATUS");
             dropList = dropDao.searchMatching(conn, drop); */
            valAkaun = valHelper.minMaxValue(conn, "AKAUN_ALL", "MTKN");

            param1 = valAkaun[0];
            param2 = valAkaun[1];

            valJalan = valHelper.minMaxValue(conn, "JALAN", "MTKN");

            param3 = valJalan[0];
            param4 = valJalan[1];

            valAmaun = valHelper.minMaxValue(conn, "AMAUN", "MTKN");
            param6 = valAmaun[0];
            param7 = valAmaun[1];

            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
    }

    public String save() throws Exception {

        conn = DBHelper.getConnectionDS();
        try {
            proIrep(conn, getParam1(), getParam2(), getParam3(), getParam4(), getParam6(), getParam7(), getParam8(), getParam9(), getTahun() );
            cetak();
             log.debug("Inside reportName() : "+ tahun);

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return SUCCESS;

    }

    public void proIrep(Connection conn, String noakn1, String noakn2, String jlkod1, String jlkod2, String amaun1, String amaun2, String tkhbl1, String tkhbl2, String tahun ) throws SQLException {

        String sql = "{ call mtkn.sp_mtkn.laporan_penyesuaian_httl30('" + noakn1 + "','" + noakn2 + "','" + jlkod1 + "','" + jlkod2 + "','" + amaun1 + "','" + amaun2 + "','" + tkhbl1 + "','" + tkhbl2 + "','" + tahun + "' ) } ";
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

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
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

    public StdLookupTable getDrop() {
        return drop;
    }

    public void setDrop(StdLookupTable drop) {
        this.drop = drop;
    }

    public StdLookupTableDao getDropDao() {
        return dropDao;
    }

    public void setDropDao(StdLookupTableDao dropDao) {
        this.dropDao = dropDao;
    }

    public StdLookupTableDaoExt getDropDaoExt() {
        return dropDaoExt;
    }

    public void setDropDaoExt(StdLookupTableDaoExt dropDaoExt) {
        this.dropDaoExt = dropDaoExt;
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

    public String[] getValAmaun() {
        return valAmaun;
    }

    public void setValAmaun(String[] valAmaun) {
        this.valAmaun = valAmaun;
    }

    public String getReportFormat() {
        return reportFormat;
    }

    public void setReportFormat(String reportFormat) {
        this.reportFormat = reportFormat;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getParam10() {
        return param10;
    }

    public void setParam10(String param10) {
        this.param10 = param10;
    }

}
