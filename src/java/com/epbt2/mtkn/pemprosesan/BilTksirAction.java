/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan;

import com.epbt2.mtkn.pemprosesan.dao.Hlkbc2;
import com.epbt2.mtkn.pemprosesan.dao.Hlkbc2Dao;
import com.epbt2.mtkn.pemprosesan.dao.Hlsiri;
import com.epbt2.mtkn.pemprosesan.dao.HlsiriDao;
import com.epbt2.mtkn.induk.dao.HLhtrx;
import com.epbt2.mtkn.induk.dao.HLhtrxDaoExt;
import com.epbt2.mtkn.pemprosesan.dao.HLkbc1;
import com.epbt2.mtkn.pemprosesan.dao.HLkbc1Dao;
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
import com.epbt2.util.DateHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.Breadcrumb;
import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @author otasoft01
 */
public class BilTksirAction extends ActionSupport implements Preparable {

    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private String pilihan;
    private String akaunDr;
    private String akaunHgga;
    private String jlnKod;
    private String tarikhTksr;
    private String tempohTksr;
    private String year, month, today;

    private final HVndukDaoExt indukDaoExt = new HVndukDaoExt();
    private HVnduk induk = new HVnduk();
    private final HlsiriDao siriDao = new HlsiriDao();
    private Hlsiri siri = new Hlsiri();
    private final AlsiriDao siriADao = new AlsiriDao();
    private Alsiri siriA = new Alsiri();
    private final HLhtrxDaoExt transaksiDaoExt = new HLhtrxDaoExt();
    private HLhtrx transaksi = new HLhtrx();
    private final DateHelper dtHelper = new DateHelper();
    private final HLpnytDao penyataDao = new HLpnytDao();
    private final HLpnytDaoExt penyataDaoExt = new HLpnytDaoExt();
    private HLpnyt penyata = new HLpnyt();
    private final HLkbc1Dao hlkbc1Dao = new HLkbc1Dao();
    private HLkbc1 hlkbc1 = new HLkbc1();
    private final HLpgngDaoExt hlpgngDaoExt = new HLpgngDaoExt();
    private HLpgng hlpgng = new HLpgng();
    private final Hlkbc2Dao hlkbc2Dao = new Hlkbc2Dao();
    private Hlkbc2 hlkbc2 = new Hlkbc2();
    private final TRxkodDaoExt trxKodDaoExt = new TRxkodDaoExt();
    private TRxkod glrTrxKod = new TRxkod();
    private TRxkod smpTrxKod = new TRxkod();
    private final AftranDao aftranDao = new AftranDao();
    private Aftran aftran = new Aftran();

    private List<HVnduk> maklAkaunList;

    private int nsiri = 0, blctr = 0;
    private float tksir = 0, smpah = 0, jmsms = 0, jssmp = 0, jmcta = 0, jmkht = 0, jmnot = 0, jmdnd = 0, jmwrf = 0, jmsmp = 0, jmnod = 0, jmmkh = 0;

    public String input() {
        return SUCCESS;
    }

    public String save() {
        try {
            conn = DBHelper.getConnectionDS();

            addActionMessage(getText("obj.success"));

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);

        }

        return SUCCESS;
    }

    @Override
    public void prepare() {

        try {
            conn = DBHelper.getConnectionDS();

            if (pilihan == null) {
                setPilihan("1");
            }

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar now = Calendar.getInstance();
            setTarikhTksr(dateFormat.format(now.getTime()));
            setTempohTksr(dateFormat.format(now.getTime()));
            
            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
    }

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
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

    public String getTarikhTksr() {
        return tarikhTksr;
    }

    public void setTarikhTksr(String tarikhTksr) {
        this.tarikhTksr = tarikhTksr;
    }

    public String getTempohTksr() {
        return tempohTksr;
    }

    public void setTempohTksr(String tempohTksr) {
        this.tempohTksr = tempohTksr;
    }

    public List<HVnduk> getMaklAkaunList() {
        return maklAkaunList;
    }

    public void setMaklAkaunList(List<HVnduk> maklAkaunList) {
        this.maklAkaunList = maklAkaunList;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName;
    }
    
    

}
