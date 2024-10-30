/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan;

import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.epbt2.mtkn.induk.dao.HVnduk4;
import com.epbt2.mtkn.induk.dao.HVnduk4DaoExt;
import com.epbt2.mtkn.induk.dao.HVpnyt;
import com.epbt2.mtkn.induk.dao.HVpnytDaoExt3;
import com.epbt2.util.DBHelper;
import com.epbt2.util.DateHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author shahr
 */
public class ProsKaveatAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());
    private User userModel = new User();

    private Connection conn;
    private HVpnyt pnyataAkaun = new HVpnyt();
    private HVpnytDaoExt3 pnytaAkaunDao = new HVpnytDaoExt3();
    private HVnduk4 PelMklumatPgangan = new HVnduk4();
    private HVnduk4DaoExt PelMklumatPganganDaoExt = new HVnduk4DaoExt();

    private List<HVpnyt> pnyataAkaunList;
    private int TAHUN;
    private String thnPilihan;

    private String layout;
    private String module;

    private String pytStats;

    public String execute() throws Exception {
        conn = DBHelper.getConnectionDS();
        try {
            if (PelMklumatPgangan.getPegAkaun() != null && !PelMklumatPgangan.getPegAkaun().equals("")) {
                if (PelMklumatPganganDaoExt.countNotisWaran(conn, PelMklumatPgangan.getPegAkaun()) != 0) {
                    retrieveData(conn, PelMklumatPgangan.getPegAkaun());
                    //PelMklumatPgangan = PelMklumatPganganDaoExt.loadInduk(conn, PelMklumatPgangan.getPegAkaun());

                    /* PENYATA AKAUN */
                    if (thnPilihan == null) {
                        thnPilihan = String.valueOf(getTAHUN());
                        log.debug("EXECUTE:" + thnPilihan);
                        pytStats = "0";
                    }
                    pnyataAkaunList = pnytaAkaunDao.loadPnytaAkaun(conn, PelMklumatPgangan.getPegAkaun(), thnPilihan);
                    pnyataAkaun = pnytaAkaunDao.jmlhPnytaAkaun(conn, PelMklumatPgangan.getPegAkaun(), thnPilihan);

                    log.debug(PelMklumatPgangan.toString());

                } else {
                    addActionMessage(getText("Rekod Tidak Wujud"));
                }
            }
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);

        }
        return SUCCESS;
    }

    public void retrieveData(Connection conn, String pegAkaun) throws Exception {
        PelMklumatPgangan = PelMklumatPganganDaoExt.loadInduk(conn, pegAkaun);
        if (thnPilihan == null) {
            thnPilihan = String.valueOf(getTAHUN());
            log.debug("EXECUTE:" + thnPilihan);
            pytStats = "0";

            pnyataAkaunList = pnytaAkaunDao.loadPnytaAkaun(conn, PelMklumatPgangan.getPegAkaun(), thnPilihan);
            pnyataAkaun = pnytaAkaunDao.jmlhPnytaAkaun(conn, PelMklumatPgangan.getPegAkaun(), thnPilihan);

            log.debug(PelMklumatPgangan.toString());
        } else {
            //  alamatDaoExt.loadAlamatPelanggan(conn, alamat);
            addActionMessage(getText("Rekod Tidak Wujud"));
        }
    }

    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {
            DateHelper dtHelper = new DateHelper();

            setTAHUN(Integer.parseInt(dtHelper.thnSemasa(conn)));
        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
    }

    public String save() throws Exception {
        log.debug("Inside save()");

        conn = DBHelper.getConnectionDS();
        try {
            // show msg
            String[] msgArgs = {};

            addActionMessage(getText("Proses Kaveat telah berjaya..", msgArgs));

            prosKaveat(conn, PelMklumatPgangan.getPegAkaun(), userModel.getUserId());

            retrieveData(conn, PelMklumatPgangan.getPegAkaun());

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return SUCCESS;

    }

    public void prosKaveat(Connection conn, String pegAkaun, String user) throws SQLException {

        String sql = "{ call ipro.sp_mdbg.mohon_kaviat('" + pegAkaun + "','" + user + "') } ";
        System.out.println("CARIAN SQL CARIAN PROSES KAVEAT :" + sql);
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            stmt = conn.prepareCall(sql);

            result = stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

    public HVpnyt getPnyataAkaun() {
        return pnyataAkaun;
    }

    public void setPnyataAkaun(HVpnyt pnyataAkaun) {
        this.pnyataAkaun = pnyataAkaun;
    }

    public HVpnytDaoExt3 getPnytaAkaunDao() {
        return pnytaAkaunDao;
    }

    public void setPnytaAkaunDao(HVpnytDaoExt3 pnytaAkaunDao) {
        this.pnytaAkaunDao = pnytaAkaunDao;
    }

    public HVnduk4 getPelMklumatPgangan() {
        return PelMklumatPgangan;
    }

    public void setPelMklumatPgangan(HVnduk4 PelMklumatPgangan) {
        this.PelMklumatPgangan = PelMklumatPgangan;
    }

    public List<HVpnyt> getPnyataAkaunList() {
        return pnyataAkaunList;
    }

    public void setPnyataAkaunList(List<HVpnyt> pnyataAkaunList) {
        this.pnyataAkaunList = pnyataAkaunList;
    }

    public int getTAHUN() {
        return TAHUN;
    }

    public void setTAHUN(int TAHUN) {
        this.TAHUN = TAHUN;
    }

    public String getThnPilihan() {
        return thnPilihan;
    }

    public void setThnPilihan(String thnPilihan) {
        this.thnPilihan = thnPilihan;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getPytStats() {
        return pytStats;
    }

    public void setPytStats(String pytStats) {
        this.pytStats = pytStats;
    }

    /* USER */
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
    /* USER */

}
