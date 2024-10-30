/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.epbt2.mtkn.induk.dao.HVnduk4;
import com.epbt2.mtkn.induk.dao.HVnduk4Dao;
import com.epbt2.mtkn.induk.dao.HVnduk4DaoExt;
import com.epbt2.mtkn.induk.dao.HVpnyt;
import com.epbt2.mtkn.induk.dao.HVpnytDaoExt3;
import com.epbt2.mtkn.induk.dao.Hlsyer;
import com.epbt2.mtkn.induk.dao.HlsyerDao;
import com.epbt2.mtkn.induk.dao.HlsyerDaoExt;
import com.epbt2.mtkn.induk.dao.HLpmlk;
import com.epbt2.mtkn.induk.dao.HLpmlkDaoExt;
import com.epbt2.util.DBHelper;
import com.epbt2.util.DateHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author 
 */
public class PelMklumatPganganAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());
    private User userModel = new User();

    private Connection conn;
    private HVpnyt pnyataAkaun = new HVpnyt();
    private HVpnytDaoExt3 pnytaAkaunDao = new HVpnytDaoExt3();
    private HVnduk4Dao PelMklumatPganganAction = new HVnduk4Dao();
    private HVnduk4 PelMklumatPgangan = new HVnduk4();

    private HLpmlk pemAsal = new HLpmlk();
    private HLpmlkDaoExt pemAsalDaoExt = new HLpmlkDaoExt();

    private HVnduk4DaoExt PelMklumatPganganDaoExt = new HVnduk4DaoExt();

    private List<HVpnyt> pnyataAkaunList;
    private int TAHUN;
    private String thnPilihan;
    private List<HLpmlk> pemAsalList;
    private int wujudPemAsal;


    /* BYE 25/09/2014 */
    private String layout;
    private String module;
    /* BYE 25/09/2014 */
 /* BYE 19/11/2014 */
    private String pytStats;
    /* BYE 19/11/2014 */

 /* BYE 02/09/2015 */
    private HVnduk4 LokasiPerincian = new HVnduk4();
    /* BYE 02/09/2015 */

 /* BYE 13/06/2016 */
    private HlsyerDao syerDao = new HlsyerDao();
    private HlsyerDaoExt syerDaoExt = new HlsyerDaoExt();
    private Hlsyer syer = new Hlsyer();
    private List<Hlsyer> kongsiList;
    private int wujudSyer;
    private String stsBack;

    
    /* BYE 16/08/2016 */
    private String[] maklJbtn = new String[2];
    /* BYE 16/08/2016 */


    //declare model mana yg nak dipakai
    public HVpnyt getPnyataAkaun() {
        return pnyataAkaun;
    }

    public void setPnyataAkaun(HVpnyt pnyataAkaun) {
        this.pnyataAkaun = pnyataAkaun;
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

    public HVnduk4 getPelMklumatPgangan() {
        return PelMklumatPgangan;
    }

    public void setPelMklumatPgangan(HVnduk4 PelMklumatPgangan) {
        this.PelMklumatPgangan = PelMklumatPgangan;
    }

    //public HttpServletRequest request;
    public String execute() throws Exception {
        conn = DBHelper.getConnectionDS();
        /*if (getTAHUN() == null) {
         Calendar now = Calendar.getInstance();
         setTAHUN(String.valueOf(now.get(Calendar.YEAR)));
         }*/
        try {
            log.debug("MODULE:" + module + ":" + layout);

            if (thnPilihan == null) {
                thnPilihan = String.valueOf(getTAHUN());
                pytStats = "0";
            }

            if (PelMklumatPgangan.getPegAkaun() != null) {
                PelMklumatPgangan = PelMklumatPganganAction.getObject(conn, PelMklumatPgangan.getPegAkaun());
                maklJbtn = PelMklumatPganganDaoExt.maklJabatanCBK(conn, PelMklumatPgangan.getPegJpkod());
                
                PelMklumatPgangan.setJabJnama(maklJbtn[0]);
                PelMklumatPgangan.setTrxInama(maklJbtn[1]);
                
                log.debug(PelMklumatPgangan.toString());
                
                pnyataAkaunList = pnytaAkaunDao.loadPnytaAkaun(conn, PelMklumatPgangan.getPegAkaun(), thnPilihan);
                pnyataAkaun = pnytaAkaunDao.jmlhPnytaAkaun(conn, PelMklumatPgangan.getPegAkaun(), thnPilihan);
                //BYE 13/06/2016
                kongsiList = syerDaoExt.kongsiPMSyerTanya(conn, PelMklumatPgangan.getPegAkaun());                
                wujudSyer = syerDaoExt.kongsiPMSyerTanyaWujud(conn, PelMklumatPgangan.getPegAkaun());
                pemAsalList = pemAsalDaoExt.pemAsal(conn, PelMklumatPgangan.getPegAkaun());
                wujudPemAsal = pemAsalDaoExt.pemAsalWujud(conn, PelMklumatPgangan.getPegAkaun());

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
            DateHelper dtHelper = new DateHelper();

            setTAHUN(Integer.parseInt(dtHelper.thnSemasa(conn)));
        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
    }

    public String getThnPilihan() {
        return thnPilihan;
    }

    public void setThnPilihan(String thnPilihan) {
        this.thnPilihan = thnPilihan;
    }

    /* BYE 25/09/2014 */
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

    /* BYE 25/09/2014 */
 /* BYE 19/11/2014 */
    public String getPytStats() {
        return pytStats;
    }

    public void setPytStats(String pytStats) {
        this.pytStats = pytStats;
    }

    /* BYE 19/11/2014 */

 /* BYE 02/09/2015 */
    public HVnduk4 getLokasiPerincian() {
        return LokasiPerincian;
    }

    public void setLokasiPerincian(HVnduk4 LokasiPerincian) {
        this.LokasiPerincian = LokasiPerincian;
    }

    /* BYE 02/09/2015 */

 /* BYE 13/06/2015 */
    public List<Hlsyer> getKongsiList() {
        return kongsiList;
    }

    public void setKongsiList(List<Hlsyer> kongsiList) {
        this.kongsiList = kongsiList;
    }

    public int getWujudSyer() {
        return wujudSyer;
    }

    public void setWujudSyer(int wujudSyer) {
        this.wujudSyer = wujudSyer;
    }

    public String getStsBack() {
        return stsBack;
    }

    public void setStsBack(String stsBack) {
        this.stsBack = stsBack;
    }

    /* BYE 13/06/2015 */
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



    public List<HLpmlk> getPemAsalList() {
        return pemAsalList;
    }

    public void setPemAsalList(List<HLpmlk> pemAsalList) {
        this.pemAsalList = pemAsalList;
    }

    public int getWujudPemAsal() {
        return wujudPemAsal;
    }

    public void setWujudPemAsal(int wujudPemAsal) {
        this.wujudPemAsal = wujudPemAsal;
    }
    
    
    
}
