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
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Preparable;
import com.epbt2.util.Breadcrumb;
import com.epbt2.util.DBHelper;
import com.epbt2.util.ValueHelper;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class senaraiTahunanAction extends ActionSupport implements Preparable {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private String param1;
    private String param2;
    private String param3;
    private String reportName;

    private ValueHelper valHelper = new ValueHelper();
    private String[] valTransaksi = new String[2];

    private String stsCetak;
    private String cetakLink;

    public String execute() {
        return SUCCESS;
    }

    /*public String cetak() {
        setStsCetak("Y");

        ActionContext sc = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) sc.get(ServletActionContext.HTTP_REQUEST);
        setCetakLink(req.getContextPath() + "/report/cetak?reportName=" + reportName + "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3);
        return SUCCESS;
    }8*/

    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {

            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

            valTransaksi = valHelper.minMaxValue(conn, "TRANSAKSI", "MTKN");

            param1 = valTransaksi[0];
            param2 = valTransaksi[1];

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
            proIrep(conn, getParam3());
            cetak();

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return SUCCESS;

    }

    public void proIrep(Connection conn, String tahun) throws SQLException {

        String sql = "{ call irep.irep_htl24e('" + tahun + "' ) } ";
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

    public void cetak() {
        setStsCetak("Y");
        ActionContext sc = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) sc.get(ServletActionContext.HTTP_REQUEST);

        setCetakLink(req.getContextPath() + "/report/cetak?reportName=" + reportName + "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3);
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

    public ValueHelper getValHelper() {
        return valHelper;
    }

    public void setValHelper(ValueHelper valHelper) {
        this.valHelper = valHelper;
    }

    public String[] getValTransaksi() {
        return valTransaksi;
    }

    public void setValTransaksi(String[] valTransaksi) {
        this.valTransaksi = valTransaksi;
    }

}
