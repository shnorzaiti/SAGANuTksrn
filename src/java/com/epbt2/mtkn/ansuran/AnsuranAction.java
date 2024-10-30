/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.ansuran;

import com.epbt2.common.dao.StdLookupTable;
import com.epbt2.common.dao.StdLookupTableDaoExt;
import com.epbt2.common.dao.StdSysParam;
import com.epbt2.common.dao.StdSysParamDaoExt;
import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.epbt2.mtkn.ansuran.dao.HLins1;
import com.epbt2.mtkn.ansuran.dao.HLins1Dao;
import com.epbt2.mtkn.ansuran.dao.HLins1DaoExt;
import com.epbt2.mtkn.induk.dao.HVnduk4;
import com.epbt2.mtkn.induk.dao.HVnduk4DaoExt;
import com.epbt2.mtkn.pemprosesan.dao.HLkbc1;
import com.epbt2.mtkn.pemprosesan.dao.HLkbc1DaoExt;
import com.epbt2.mtkn.ansuran.dao.HLins2;
import com.epbt2.mtkn.ansuran.dao.HLins2Dao;
import com.epbt2.mtkn.ansuran.dao.HLins2DaoExt;
import com.epbt2.mtkn.induk.dao.HVpnyt;
import com.epbt2.mtkn.induk.dao.HVpnytDaoExt3;
import com.epbt2.spbt.ref.dao.VPnyta;
import com.epbt2.spbt.ref.dao.VPnytaDaoExt2;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.DBHelper;
import com.epbt2.util.DateHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NurMuhammadAfzal
 */
public class AnsuranAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private User userModel = new User();

    //isytihar DAO GEN
    //private HVmjc1Dao terimaanDao = new HVmjc1Dao();
    private HVnduk4DaoExt HVnduk4DaoExt = new HVnduk4DaoExt();
    private HVnduk4 HVnduk4 = new HVnduk4();
    private HLins2DaoExt HLins2DaoExt = new HLins2DaoExt();
    private HLins2 HLins2 = new HLins2();
    private VPnytaDaoExt2 VPnytaDaoExt2 = new VPnytaDaoExt2();
    private VPnyta VPnyta = new VPnyta();
    private HLkbc1DaoExt HLkbc1DaoExt = new HLkbc1DaoExt();
    private HLkbc1 HLkbc1 = new HLkbc1();

    private HLins2 Ansuran = new HLins2();

    private HLins2Dao objDao = new HLins2Dao();

    private List<HVnduk4> HVnduk4List;
    private List<HLins2> HLins2List;
    // private List<HLins2> HLins2List2;
    private List<VPnyta> VPnytaList;
    private List<HLkbc1> HLkbc1List;

    /* BYE 17/11/2014 */
    private HVpnyt pnyataAkaun = new HVpnyt();
    private HVpnytDaoExt3 pnytaAkaunDao = new HVpnytDaoExt3();
    private List<HVpnyt> pnyataAkaunList;
    private int TAHUN;
    private String thnPilihan;

    private StdSysParamDaoExt sysParamDaoExt = new StdSysParamDaoExt();
    private final StdSysParam sysParam = new StdSysParam();
    private String modulID;
    private String bilKali;
    private String baki;
    /* BYE 17/11/2014 */

    /*BYE 29/11/2014 */
    private HLins1Dao bilAnsDao = new HLins1Dao();
    private HLins1DaoExt bilAnsDaoExt = new HLins1DaoExt();
    private HLins1 bilAns = new HLins1();
    private String stsUpd;
    private DateHelper dtHelper = new DateHelper();
    /*BYE 29/11/2014 */

    private String stsCetak;
    private String cetakLink;

    private StdLookupTableDaoExt refDaoExt = new StdLookupTableDaoExt();
    private StdLookupTable ref = new StdLookupTable();

    public String execute() throws Exception {
        conn = DBHelper.getConnectionDS();
        try {
            //HVnduk4List = HVnduk4DaoExt.loadHVnduk4(conn);
            if (HVnduk4.getPegAkaun() != null) {
                retrieveData(conn, HVnduk4.getPegAkaun());
            }

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;

    }

    public void retrieveData(Connection conn, String akaun) throws Exception {
        HVnduk4 = HVnduk4DaoExt.loadHVnduk4(conn, akaun);

        if (thnPilihan == null) {
            thnPilihan = String.valueOf(getTAHUN());
        }
        pnyataAkaunList = pnytaAkaunDao.loadPnytaAkaun(conn, akaun, thnPilihan);
        pnyataAkaun = pnytaAkaunDao.jmlhPnytaAkaun(conn, akaun, thnPilihan);

        if (HVnduk4.getPegStatf().equals("HAPUS")) {
            addActionMessage("No. Akaun " + akaun + " berstatus " + HVnduk4.getPegStatf());
        } else {

            if (HLkbc1DaoExt.rekodWujud(conn, akaun) != 0) {
                HLkbc1 = HLkbc1DaoExt.loadHLkbc1(conn, akaun);
            }

            //HLins2List2 = HLins2DaoExt.loadAll(conn);
                /* BYE 17/11/2014 */
            //VPnytaList = VPnytaDaoExt2.loadKemaskiniMklumatAnsuran (conn, HVnduk4.getPegAkaun());
            if (Double.parseDouble(pnyataAkaun.getBaki().replaceAll(",", "")) < 0) {
                addActionMessage("No. Akaun " + akaun + " menmpunyai baki sebanyak " + pnyataAkaun.getBaki());
            }

            /* BYE 17/11/2014 */
            bilKali = String.valueOf(HLins2DaoExt.countRecord(conn, akaun));

            if (bilKali.equals("0")) {
                setBilKali("");
            }

            HLins2List = HLins2DaoExt.loadHLins2(conn, akaun);

            /* BYE 07/10/2014 */
            Ansuran = HLins2DaoExt.jmlhBesarAnsuran(conn, akaun);
            /* BYE 07/10/2014 */

            if (bilAnsDaoExt.rekodWujud(conn, akaun) != 0) {
                bilAns = bilAnsDao.getObject(conn, akaun);
                bilAns.setIn1Tdate(dtHelper.convertDateFormat(conn, bilAns.getIn1Tdate()));
                ref.setLookupCode(bilAns.getIn1Stang());
                ref.setLookupGroup("STAT BARU");
                bilAns.setIn1Stang(refDaoExt.descReference(conn, ref, "MTKN"));

                setStsUpd("Y");
            } else {
                setStsUpd("N");
            }
        }
    }

    /*public String find() throws Exception {
     conn = DBHelper.getConnectionDS();
     try {
     HLins2List = objDao.loadAll(conn);

     } catch (Exception e) {
     addActionError("Error : " + e);
     log.error(e, e.fillInStackTrace());
     } finally {
     DBHelper.closeConnection(conn);
     }
     return SUCCESS;
     }*/
    public String jana() throws Exception {

        conn = DBHelper.getConnectionDS();
        try {
            log.debug("bilAns.getIn1Stang():"+bilAns.getIn1Stang());
            if (bilAns.getIn1Stang().equals("true")) {
                bilAns.setIn1Stang("Y");
            } else {
                bilAns.setIn1Stang("T");
            }

            log.debug(HVnduk4.getPegAkaun() + ":" + bilAns.getIn1Jmseq() + ":" + bilAns.getIn1Tdate() + ":" + bilAns.getIn1Stang() + ":" + bilAns.getIn1Nopek());
            pakejProsesAnsuran(conn, HVnduk4.getPegAkaun(), bilAns.getIn1Jmseq(), bilAns.getIn1Tdate(), bilAns.getIn1Stang(), bilAns.getIn1Nopek());

            //retrieveData(conn, HVnduk4.getPegAkaun());
            cetak();
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return "info";

    }

    public String save() throws Exception {

        conn = DBHelper.getConnectionDS();
        try {
            if (bilAns.getIn1Stang().equals("true")) {
                bilAns.setIn1Stang("Y");
            } else {
                bilAns.setIn1Stang("T");
            }

            for (int i = 0; i < HLins2List.size(); i++) {
                pakejProsesAnsuranManualDetail(conn, HVnduk4.getPegAkaun(), HLins2List.get(i).getIn2Trikh(), HLins2List.get(i).getIn2Ctsms(), HLins2List.get(i).getIn2Cttgk(), HLins2List.get(i).getIn2Dnsms(), HLins2List.get(i).getIn2Dntgk(), HLins2List.get(i).getIn2Ntsms(), HLins2List.get(i).getIn2Nttgk(), HLins2List.get(i).getIn2Wrsms(), HLins2List.get(i).getIn2Wrtgk());
            }
            pakejProsesAnsuranManualUtama(conn, HVnduk4.getPegAkaun(), HLins2List.size(), pnyataAkaun.getBaki(), bilAns.getIn1Tdate(), bilAns.getIn1Stang(), bilAns.getIn1Nopek());

            //retrieveData(conn, HVnduk4.getPegAkaun());
            cetak();
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return "info";

    }

    public String cetak() {
        setStsCetak("Y");

        ActionContext sc = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) sc.get(ServletActionContext.HTTP_REQUEST);
        setCetakLink(req.getContextPath() + "/report/cetak?reportName=hlkq01_a4&param1=" + HVnduk4.getPegAkaun() + "&onama=" + userModel.getUserId());

        return SUCCESS;
    }

    public void pakejProsesAnsuran(Connection conn, String noakn, String bilgn, String tkans, String stang, String nopek) throws SQLException {
        String sql = "{ call mtkn.sp_mtkn.proses_ansuran('" + noakn + "', '" + bilgn + "', '" + userModel.getUserMacAddress() + "','" + userModel.getUserPcName() + "','" + tkans + "','" + stang + "','" + nopek + "', '" + userModel.getUserId() + "') } ";
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

    public void pakejProsesAnsuranManualUtama(Connection conn, String noakn, int bilgn, String amaun, String tkans, String stang, String nopek) throws SQLException {

        String sql = "{ call mtkn.sp_mtkn.proses_ansuran_manual_utama('" + noakn + "', '" + bilgn + "', '" + amaun + "', '" + userModel.getUserMacAddress() + "','" + userModel.getUserPcName() + "','" + tkans + "','" + stang + "','" + nopek + "', '" + userModel.getUserId() + "') } ";

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

    public void pakejProsesAnsuranManualDetail(Connection conn, String noakn, String trikh, String ctsms, String cttgk, String dnsms, String dntgk, String ntsms, String nttgk, String wrsms, String wrtgk) throws SQLException {
        String sql = "{ call mtkn.sp_mtkn.proses_ansuran_manual_detail('" + noakn + "', '" + trikh + "', '" + ctsms + "','" + cttgk + "','" + dnsms + "','" + dntgk + "','" + ntsms + "', '" + nttgk + "', '" + wrsms + "', '" + wrtgk + "' ) } ";
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

    /*public String save() throws Exception {
     //  log.debug("Inside save()");

     conn = DBHelper.getConnectionDS();
     try {
     // show msg
     String[] msgArgs = {Ansuran.getIn2Akaun()};

     try {
     log.debug("SAVE");
     objDao.save(conn, Ansuran);
     addActionMessage(getText("obj.upd", msgArgs));
     } catch (NotFoundException e) {
     log.debug("INSERT");
     objDao.create(conn, Ansuran);
     addActionMessage(getText("obj.add", msgArgs));
     }
     // if save or create success, get doc created date
     //obj = objDao.getObject(conn, obj.getNegNegri());
     } catch (Exception e) {
     addActionError("Error : " + e);
     log.error(e, e.fillInStackTrace());
     } finally {
     DBHelper.closeConnection(conn);
     }
     return SUCCESS;

     }*/

    /* public HVnduk4DaoExt getHVnduk4DaoExt() {
     return HVnduk4DaoExt;
     }

     public void setHVnduk4DaoExt(HVnduk4DaoExt HVnduk4DaoExt) {
     this.HVnduk4DaoExt = HVnduk4DaoExt;
     }*/
    public HVnduk4 getHVnduk4() {
        return HVnduk4;
    }

    public void setHVnduk4(HVnduk4 HVnduk4) {
        this.HVnduk4 = HVnduk4;
    }

    /* public HLins2DaoExt getHLins2DaoExt() {
     return HLins2DaoExt;
     }

     public void setHLins2DaoExt(HLins2DaoExt HLins2DaoExt) {
     this.HLins2DaoExt = HLins2DaoExt;
     }

     public HLins2 getHLins2() {
     return HLins2;
     }

     public void setHLins2(HLins2 HLins2) {
     this.HLins2 = HLins2;
     }

     public VPnytaDaoExt2 getVPnytaDaoExt2() {
     return VPnytaDaoExt2;
     }

     public void setVPnytaDaoExt2(VPnytaDaoExt2 VPnytaDaoExt2) {
     this.VPnytaDaoExt2 = VPnytaDaoExt2;
     }

     public VPnyta getVPnyta() {
     return VPnyta;
     }

     public void setVPnyta(VPnyta VPnyta) {
     this.VPnyta = VPnyta;
     }

     public List<HVnduk4> getHVnduk4List() {
     return HVnduk4List;
     }

     public void setHVnduk4List(List<HVnduk4> HVnduk4List) {
     this.HVnduk4List = HVnduk4List;
     }*/
    public List<HLins2> getHLins2List() {
        return HLins2List;
    }

    public void setHLins2List(List<HLins2> HLins2List) {
        this.HLins2List = HLins2List;
    }

    /* public List<VPnyta> getVPnytaList() {
     return VPnytaList;
     }

     public void setVPnytaList(List<VPnyta> VPnytaList) {
     this.VPnytaList = VPnytaList;
     }*/

    /*public HLkbc1DaoExt getHLkbc1DaoExt() {
     return HLkbc1DaoExt;
     }

     public void setHLkbc1DaoExt(HLkbc1DaoExt HLkbc1DaoExt) {
     this.HLkbc1DaoExt = HLkbc1DaoExt;
     }*/

    /*public HLkbc1 getHLkbc1() {
     return HLkbc1;
     }

     public void setHLkbc1(HLkbc1 HLkbc1) {
     this.HLkbc1 = HLkbc1;
     }*/

    /*public List<HLkbc1> getHLkbc1List() {
     return HLkbc1List;
     }

     public void setHLkbc1List(List<HLkbc1> HLkbc1List) {
     this.HLkbc1List = HLkbc1List;
     }*/
    public HLins2 getAnsuran() {
        return Ansuran;
    }

    public void setAnsuran(HLins2 Ansuran) {
        this.Ansuran = Ansuran;
    }

    /*public HLins2Dao getObjDao() {
     return objDao;
     }

     public void setObjDao(HLins2Dao objDao) {
     this.objDao = objDao;
     }*/
    /*  public List<HLins2> getHLins2List2() {
     return HLins2List2;
     }
     public void setHLins2List2(List<HLins2> HLins2List2) {
     this.HLins2List2 = HLins2List2;
     }*/
    /* BYE 17/11/2014 */
    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {
            DateHelper dtHelper = new DateHelper();

            setTAHUN(Integer.parseInt(dtHelper.thnSemasa(conn)));

            sysParam.setParaId("3");
            modulID = sysParamDaoExt.sysParamValue(conn, sysParam, "MTKN");
        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
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

    public List<HVpnyt> getPnyataAkaunList() {
        return pnyataAkaunList;
    }

    public void setPnyataAkaunList(List<HVpnyt> pnyataAkaunList) {
        this.pnyataAkaunList = pnyataAkaunList;
    }

    public HVpnyt getPnyataAkaun() {
        return pnyataAkaun;
    }

    public void setPnyataAkaun(HVpnyt pnyataAkaun) {
        this.pnyataAkaun = pnyataAkaun;
    }

    public String getModulID() {
        return modulID;
    }

    public void setModulID(String modulID) {
        this.modulID = modulID;
    }

    public String getBilKali() {
        return bilKali;
    }

    public void setBilKali(String bilKali) {
        this.bilKali = bilKali;
    }

    public String getBaki() {
        return baki;
    }

    public void setBaki(String baki) {
        this.baki = baki;
    }
    /* BYE 17/11/2014 */

    /* BYE 29/11/2014 */
    public HLins1 getBilAns() {
        return bilAns;
    }

    public void setBilAns(HLins1 bilAns) {
        this.bilAns = bilAns;
    }

    public String getStsUpd() {
        return stsUpd;
    }

    public void setStsUpd(String stsUpd) {
        this.stsUpd = stsUpd;
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

    /* BYE 29/11/2014 */
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
}
