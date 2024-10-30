/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan;

import com.epbt2.mtkn.pemprosesan.dao.Hlcmk1;
import com.epbt2.mtkn.pemprosesan.dao.Hlcmk1Dao;
import com.epbt2.mtkn.pemprosesan.dao.Hlcmk2;
import com.epbt2.mtkn.pemprosesan.dao.Hlcmk2Dao;
import com.epbt2.mtkn.pemprosesan.dao.Hlsiri;
import com.epbt2.mtkn.pemprosesan.dao.HlsiriDao;
import com.epbt2.mtkn.pemprosesan.dao.HJenpk;
import com.epbt2.mtkn.pemprosesan.dao.HJenpkDao;
import com.epbt2.mtkn.induk.dao.HLhtrx;
import com.epbt2.mtkn.induk.dao.HLhtrxDao;
import com.epbt2.mtkn.induk.dao.HLhtrxDaoExt;
import com.epbt2.mtkn.ref.dao.HLjabt;
import com.epbt2.mtkn.ref.dao.HLjabtDaoExt;
import com.epbt2.mtkn.induk.dao.HLpgng;
import com.epbt2.mtkn.induk.dao.HLpgngDaoExt;
import com.epbt2.mtkn.pemprosesan.dao.HLpnyt;
import com.epbt2.mtkn.pemprosesan.dao.HLpnytDao;
import com.epbt2.mtkn.pemprosesan.dao.HLpnytDaoExt;
import com.epbt2.spbt.ref.dao.TRxkod;
import com.epbt2.spbt.ref.dao.TRxkodDaoExt;
import com.epbt2.ssla.ref.dao.Aftran;
import com.epbt2.ssla.ref.dao.AftranDao;
import com.epbt2.ssla.ref.dao.Alsiri;
import com.epbt2.ssla.ref.dao.AlsiriDao;
import com.epbt2.util.DBHelper;
import com.epbt2.util.NotFoundException;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.opensymphony.xwork2.ModelDriven;
import com.epbt2.util.Breadcrumb;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

/**
 *
 * @author Uzzair Baharudin
 */
public class BIlcbkAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private final HLpgngDaoExt HLpgngDaoExt = new HLpgngDaoExt();
    private final HLjabtDaoExt jabtDaoExt = new HLjabtDaoExt();
    private HLjabt jabt = new HLjabt();
    private final HlsiriDao siriDao = new HlsiriDao();
    private Hlsiri siri = new Hlsiri();
    private final AlsiriDao siriADao = new AlsiriDao();
    private Alsiri siriA = new Alsiri();
    private final HJenpkDao HJenpkDao = new HJenpkDao();
    private HJenpk HJenpk = new HJenpk();
    private final HLpnytDao penyataDao = new HLpnytDao();
    private final HLpnytDaoExt penyataDaoExt = new HLpnytDaoExt();
    private HLpnyt penyata = new HLpnyt();
    private final HLhtrxDao HLhtrxDao = new HLhtrxDao();
    private final HLhtrxDaoExt HLhtrxDaoExt = new HLhtrxDaoExt();
    private HLhtrx HLhtrx = new HLhtrx();
    private final HLpgngDaoExt hlpgngDaoExt = new HLpgngDaoExt();
    private HLpgng hlpgng = new HLpgng();
    private final Hlcmk1Dao hlcmk1Dao = new Hlcmk1Dao();
    private Hlcmk1 hlcmk1 = new Hlcmk1();
    private final Hlcmk2Dao hlcmk2Dao = new Hlcmk2Dao();
    private Hlcmk2 hlcmk2 = new Hlcmk2();
    private final TRxkodDaoExt trxKodDaoExt = new TRxkodDaoExt();
    private TRxkod glrTrxKod = new TRxkod();
    private final AftranDao aftranDao = new AftranDao();
    private Aftran aftran = new Aftran();

    private List<HLpgng> maklAkaunList;
    private List<HLpnyt> maklPenyataList;

    private int nsiri = 0, blctr = 0, signhtg = 0;
    private float amaun = 0, ambki = 0, amtgk = 0, amsms = 0, jksir = 0, tngak = 0, smasa = 0, balan = 0, lbhan = 0;
    public String tarikhCBK, tempohCBK;
    /*private HLjabtDao carianCBKDao = new HLjabtDao();
     private List<HLjabt> carianCBKList;
     */

 /* user */
    private User userModel = new User();
    /* user */

 /* package sewa */
    private packageProsesBil proses = new packageProsesBil();

    /* package sewa */
    public String input() {
        return SUCCESS;
    }

    public String save() throws Exception {
        log.debug("Inside save()");

        conn = DBHelper.getConnectionDS();
        try {
            // show msg
            String[] msgArgs = {};

            proses.bilCBK(conn, jabt.getJabJbkod(), tarikhCBK, tempohCBK, userModel.getUserId());

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

            
            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

    }

    public HLjabt getJabt() {
        return jabt;
    }

    public void setJabt(HLjabt jabt) {
        this.jabt = jabt;
    }

    public void insHlhtrx(String akaun, int blctr, String tarikhCBK) throws NotFoundException, SQLException {

        maklPenyataList = penyataDaoExt.maklAmaunAkaunBilCBK(conn, akaun);

        signhtg = penyataDaoExt.wujudAmaunBilCBK(conn, akaun);

        if (HLhtrxDaoExt.rekodWujud(conn, akaun) != 0) {
            HLhtrx.setHTxakaun(akaun);
            HLhtrxDao.delete(conn, HLhtrx);
        }

        ambki = penyataDaoExt.jumlahAmaunBilCBK(conn, akaun);

        if (maklPenyataList.size() > 0) {
            for (int j = 0; j < maklPenyataList.size(); j++) {
                amtgk = maklPenyataList.get(j).getAmtgk();
                amsms = maklPenyataList.get(j).getAmsms();

                if (amtgk < 0) {
                    ambki = ambki + amtgk;
                }

                if (amsms < 0) {
                    ambki = ambki + amsms;
                }

                if (amtgk > 0) {
                    ambki = amtgk + ambki;
                }

                if (ambki > 0 && signhtg == 1) {
                    insHLhtrx(akaun, "12" + maklPenyataList.get(j).getPYtkdrjk(), blctr, tarikhCBK, ambki);
                    ambki = 0;
                }

                if (amsms > 0) {
                    ambki = amsms + ambki;
                }

                if (ambki > 0 && signhtg == 1) {
                    insHLhtrx(akaun, "11" + maklPenyataList.get(j).getPYtkdrjk(), blctr, tarikhCBK, ambki);
                    ambki = 0;
                }
            }
        }

        if (ambki != 0) {
            insHLhtrx(akaun, "11090", blctr, tarikhCBK, ambki);
            ambki = 0;
        }
    }

    public void insHLhtrx(String akaun, String kdrjk, int noBil, String tkhbl, float amaun) throws SQLException {
        HLhtrx.setHTxakaun(akaun);
        HLhtrx.setHTxkdrjk(kdrjk);
        HLhtrx.setHTxnobil(String.valueOf(noBil));
        HLhtrx.setHTxtkhbil(tkhbl);
        HLhtrx.setHTxtmpoh(null);
        HLhtrx.setHTxamaun(String.valueOf(amaun));
        HLhtrx.setHTxstatf("S");
        HLhtrxDao.create(conn, HLhtrx);
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
    
    

}
