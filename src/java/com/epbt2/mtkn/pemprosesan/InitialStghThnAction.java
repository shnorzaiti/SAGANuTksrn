/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan;

import com.epbt2.mtkn.pemprosesan.dao.HLpnyt;
import com.epbt2.mtkn.pemprosesan.dao.HLpnytDaoExt;
import com.epbt2.util.DBHelper;
import com.epbt2.util.NotFoundException;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.Breadcrumb;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

/**
 *
 * @author otasoft01
 */
public class InitialStghThnAction extends ActionSupport implements Preparable {

    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;

    private HLpnyt penggal = new HLpnyt();
    private HLpnytDaoExt penggalDaoExt = new HLpnytDaoExt();

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private String noAkaun;

    public String execute() throws Exception {

        log.debug("Start");
        conn = DBHelper.getConnectionDS();

        try {

            penggal = penggalDaoExt.Penggal(conn);

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;
    }


    public String save() throws Exception {

        conn = DBHelper.getConnectionDS();
        try {

            String[] msgArgs = {};

            if (penggal.getPenggal().equals("1")) {

                PackageHujungPenggal(conn);

                addActionMessage(getText("Proses Initialisasi Setengah Tahun Telah Berjaya", msgArgs));

            } else {

                addActionError(getText("Proses Initialisasi Setengah Tahun Tidak Boleh Dilaksanakan Bagi Penggal Kedua. Proses ini Berlaku Semasa Proses YEND Bagi Taksiran", msgArgs));

            }

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return SUCCESS;

    }

    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {

            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

    }

    public void PackageHujungPenggal(Connection conn) throws SQLException {
        String sql = "{ call MTKN.SP_MTKN.hujung_penggal } "; //2432 no akaun
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

    public String getNoAkaun() {
        return noAkaun;
    }

    public void setNoAkaun(String noAkaun) {
        this.noAkaun = noAkaun;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName;
    }

    public HLpnyt getPenggal() {
        return penggal;
    }

    public void setPenggal(HLpnyt penggal) {
        this.penggal = penggal;
    }

}
