/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan;

import com.epbt2.common.dao.StdLookupTable;
import com.epbt2.common.dao.StdLookupTableDao;
import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.opensymphony.xwork2.ModelDriven;
import com.epbt2.mtkn.induk.dao.HLhtrxDaoExt;
import com.epbt2.mtkn.pemprosesan.dao.Hlsiri;
import com.epbt2.mtkn.pemprosesan.dao.HlsiriDao;
import com.epbt2.mtkn.pemprosesan.dao.Hnotis;
import com.epbt2.mtkn.pemprosesan.dao.HnotisDao;
import com.epbt2.mtkn.selenggara.dao.HKadar;
import com.epbt2.mtkn.selenggara.dao.HKadarDaoExt;
import com.epbt2.mtkn.induk.dao.HLhtrx;
import com.epbt2.mtkn.induk.dao.HLpgng;
import com.epbt2.mtkn.induk.dao.HLpgngDaoExt;
import com.epbt2.mtkn.pemprosesan.dao.HLpnyt;
import com.epbt2.mtkn.pemprosesan.dao.HLpnytDao;
import com.epbt2.mtkn.pemprosesan.dao.HLpnytDaoExt;
import com.epbt2.mtkn.induk.dao.HVnduk;
import com.epbt2.mtkn.induk.dao.HVndukDaoExt;
import com.epbt2.spbt.ref.dao.TRxkod;
import com.epbt2.spbt.ref.dao.TRxkodDaoExt;
import com.epbt2.ssla.ref.dao.Aftran;
import com.epbt2.ssla.ref.dao.AftranDao;
import com.epbt2.ssla.ref.dao.Alsiri;
import com.epbt2.ssla.ref.dao.AlsiriDao;
import com.epbt2.util.DBHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.Breadcrumb;
import com.epbt2.util.ValueHelper;
import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @author otasoft01
 */
public class DendaNotisWaranAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {//Belum ada session, UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;
    //private User userModel = new User();

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private String proses;
    private String pilihan;
    private String akaunDr;
    private String akaunHgga;
    private String jlnKod;
    private String amaunDr;
    private String amaunHgga;
    private String tarikh;
    private String tempoh;

    /* user */
    private User userModel = new User();
    /* user */

    private String trkod, sir_tnama;
    private int tmaxn = 0, blctr = 0, bilgn = 0;
    private float tksr1 = 0, tksr2 = 0, cttgk = 0, ctsms = 0, akira = 0, genap = 0;
    private double denda = 0, dnsms = 0, dntgk = 0, ntsms = 0, nttgk = 0, wrsms = 0, wrtgk = 0, alsms = 0, altgk = 0, jmlah = 0, jmdnd = 0;

    private final StdLookupTableDao refDao = new StdLookupTableDao();
    //private final StdLookupTableDaoExt refDaoExt = new StdLookupTableDaoExt();
    private StdLookupTable ref = new StdLookupTable();
    private final HVndukDaoExt indukDaoExt = new HVndukDaoExt();
    private HVnduk induk = new HVnduk();
    private final HlsiriDao siriDao = new HlsiriDao();
    private Hlsiri siri = new Hlsiri();
    private final AlsiriDao siriADao = new AlsiriDao();
    private Alsiri siriA = new Alsiri();
    private final HLpnytDaoExt penyataDaoExt = new HLpnytDaoExt();
    private final HLpnytDao penyataDao = new HLpnytDao();
    private HLpnyt penyata = new HLpnyt();
    private final HLhtrxDaoExt transaksiDaoExt = new HLhtrxDaoExt();
    private HLhtrx transaksi = new HLhtrx();
    private HKadarDaoExt kadarDaoExt = new HKadarDaoExt();
    private HKadar kadar = new HKadar();

    private HnotisDao notisDao = new HnotisDao();
    private Hnotis notis = new Hnotis();
    private final HLpgngDaoExt hlpgngDaoExt = new HLpgngDaoExt();
    private HLpgng hlpgng = new HLpgng();
    private final TRxkodDaoExt trxKodDaoExt = new TRxkodDaoExt();
    private TRxkod trxKod = new TRxkod();
    private final AftranDao aftranDao = new AftranDao();
    private Aftran aftran = new Aftran();

    private List<StdLookupTable> prosesList;
    private List<HVnduk> maklAkaunList;
    
    private ValueHelper valHelper = new ValueHelper();
    private String[] valAkaun = new String[2];
    private String[] valJalan = new String[2];
    private String[] valAmaun = new String[2];
    

    public String input() {
        return SUCCESS;
    }

    /* package sewa */
    private packageProsesBil dendaNotis = new packageProsesBil();

    /* package sewa */
    public String save() throws Exception {
        log.debug("Inside save()");

        conn = DBHelper.getConnectionDS();
        try {
            // show msg
            String[] msgArgs = {};

            dendaNotis.denNotisW(conn, proses, akaunDr, akaunHgga, amaunDr, amaunHgga, pilihan,
                    jlnKod, tarikh, tempoh, userModel.getUserId());

            addActionMessage(getText("Berjaya Di Kemaskini", msgArgs));
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

            if (pilihan == null) {
                setPilihan("1");
            }
            
            valAkaun = valHelper.minMaxValue(conn, "AKAUN", "MTKN");

            akaunDr = valAkaun[0];
            akaunHgga = valAkaun[1];
            
            valJalan = valHelper.minMaxValue(conn, "TPHNOTIS", "MTKN");

            tarikh = valJalan[0];
            tempoh = valJalan[1];
            
            valAmaun = valHelper.minMaxValue(conn, "AMAUN", "MTKN");

            amaunDr = valAmaun[0];
            amaunHgga = valAmaun[1];

            ref.setLookupGroup("STATF DNW");
            prosesList = refDao.searchMatching(conn, ref, "MTKN");

            transaksi = transaksiDaoExt.amaunHutang(conn);

            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
    }

    public String getAkaunDr() {
        return akaunDr;
    }

    public void setAkaunDr(String akaunDr) {
        this.akaunDr = akaunDr;
    }

    public String getAkaunHgga() {
        return akaunHgga;
    }

    public void setAkaunHgga(String akaunHgga) {
        this.akaunHgga = akaunHgga;
    }

    public String getJlnKod() {
        return jlnKod;
    }

    public void setJlnKod(String jlnKod) {
        this.jlnKod = jlnKod;
    }

    public String getAmaunDr() {
        return amaunDr;
    }

    public void setAmaunDr(String amaunDr) {
        this.amaunDr = amaunDr;
    }

    public String getAmaunHgga() {
        return amaunHgga;
    }

    public void setAmaunHgga(String amaunHgga) {
        this.amaunHgga = amaunHgga;
    }

    public String getTarikh() {
        return tarikh;
    }

    public void setTarikh(String tarikh) {
        this.tarikh = tarikh;
    }

    public String getTempoh() {
        return tempoh;
    }

    public void setTempoh(String tempoh) {
        this.tempoh = tempoh;
    }

    public String getProses() {
        return proses;
    }

    public void setProses(String proses) {
        this.proses = proses;
    }

    public List<StdLookupTable> getProsesList() {
        return prosesList;
    }

    public void setProsesList(List<StdLookupTable> prosesList) {
        this.prosesList = prosesList;
    }

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
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

    public String[] getValAmaun() {
        return valAmaun;
    }

    public void setValAmaun(String[] valAmaun) {
        this.valAmaun = valAmaun;
    }
    
    

}
