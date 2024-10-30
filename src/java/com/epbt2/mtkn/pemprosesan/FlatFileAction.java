/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan;

import com.epbt2.common.dao.StdLookupTable;
import com.epbt2.common.dao.StdLookupTableDao;
import com.epbt2.common.dao.StdLookupTableDaoExt;
import com.epbt2.common.dao.StdSysParam;
import com.epbt2.common.dao.StdSysParamDaoExt;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Baizura
 */
public class FlatFileAction extends ActionSupport implements Preparable {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private StdLookupTable drop = new StdLookupTable();
    private StdLookupTableDao dropDao = new StdLookupTableDao();
    private StdLookupTableDaoExt dropDaoExt = new StdLookupTableDaoExt();

    private List<StdLookupTable> dropList;

    StdSysParamDaoExt paramDaoExt = new StdSysParamDaoExt();
    StdSysParam param = new StdSysParam();

    private String majlis;
    private String pilih;
    private String jpkod;
    private String amlbh;
    private String rekod;
    private String tkhbl;
    private String bilRekod;


     public String save() throws Exception {
        log.debug("Inside save()");

        conn = DBHelper.getConnectionDS();
        try {
            // show msg
            String[] msgArgs = {};

            addActionMessage(getText("FlatFile Bil Awal CTA telah berjaya di jana..", msgArgs));

            sediaFlatfileCta1 (conn, jpkod, amlbh, rekod, bilRekod);

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

            drop.setLookupGroup("JPKOD");
            dropList = dropDao.searchMatching(conn, drop, "MTKN");

            param.setParaId("100");
            setBilRekod(paramDaoExt.sysParamValue(conn, param, "MTKN"));

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

    }


    public void sediaFlatfileCta1(Connection conn, String tmp_jpkod, String tmp_amaun, String tmp_rekod, String tmp_bilgn) throws SQLException {

        String sql = "{ call mtkn.sp_mtkn.sedia_flatfile_cta('" + jpkod + "','" + amlbh + "','" + rekod + "','" + bilRekod + "' ) } ";
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

    public StdLookupTable getDrop() {
        return drop;
    }

    public void setDrop(StdLookupTable drop) {
        this.drop = drop;
    }

    public List<StdLookupTable> getDropList() {
        return dropList;
    }

    public void setDropList(List<StdLookupTable> dropList) {
        this.dropList = dropList;
    }

    public StdSysParam getParam() {
        return param;
    }

    public void setParam(StdSysParam param) {
        this.param = param;
    }

    public String getMajlis() {
        return majlis;
    }

    public void setMajlis(String majlis) {
        this.majlis = majlis;
    }

    public String getPilih() {
        return pilih;
    }

    public void setPilih(String pilih) {
        this.pilih = pilih;
    }

    public String getJpkod() {
        return jpkod;
    }

    public void setJpkod(String jpkod) {
        this.jpkod = jpkod;
    }

    public String getAmlbh() {
        return amlbh;
    }

    public void setAmlbh(String amlbh) {
        this.amlbh = amlbh;
    }

    public String getRekod() {
        return rekod;
    }

    public void setRekod(String rekod) {
        this.rekod = rekod;
    }

    public String getTkhbl() {
        return tkhbl;
    }

    public void setTkhbl(String tkhbl) {
        this.tkhbl = tkhbl;
    }

    public String getBilRekod() {
        return bilRekod;
    }

    public void setBilRekod(String bilRekod) {
        this.bilRekod = bilRekod;
    }
        

   



  

}
