/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.mtkn.induk.dao.HVnduk4;
import com.epbt2.mtkn.induk.dao.HVnduk4DaoExt;
import com.epbt2.mtkn.ref.dao.HBangn;
import com.epbt2.mtkn.ref.dao.HBangnDaoExt;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Uzzair Baharudin
 */
public class carianPertanyaanAction extends ActionSupport implements Preparable {

    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;//DECLARE CONNECTION

    private HVnduk4DaoExt carianPertanyaanDaoExt = new HVnduk4DaoExt();
    private HVnduk4 carianPertanyaan = new HVnduk4();//SETTER GETTER
    private List<HVnduk4> carianPertanyaanList;//SETTER GETTER

    private HBangn carianBanguna = new HBangn ();
    private HBangnDaoExt carianBangunaDaoExt = new HBangnDaoExt();
    private List<HBangn> bgnList;

    /*BYE 24/09/2014*/
    private String layout;

    /*BYE 24/09/2014*/

    public String search() throws Exception {
        conn = DBHelper.getConnectionDS();
        try {
            //carianPertanyaan = carianPertanyaanDao.getObject(conn, carianPertanyaan.getPEgakaun());
            //log.debug(carianPertanyaan.toString());
            carianPertanyaanList = carianPertanyaanDaoExt.searchPertanyaan(conn, carianPertanyaan);

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
            bgnList = carianBangunaDaoExt.loadSenaraiKend(conn, carianBanguna);
        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

    }

    /*BYE 24/09/2014*/
    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    /*BYE 24/09/2014*/

    public HVnduk4 getCarianPertanyaan() {
        return carianPertanyaan;
    }

    public void setCarianPertanyaan(HVnduk4 carianPertanyaan) {
        this.carianPertanyaan = carianPertanyaan;
    }

    public List<HVnduk4> getCarianPertanyaanList() {
        return carianPertanyaanList;
    }

    public void setCarianPertanyaanList(List<HVnduk4> carianPertanyaanList) {
        this.carianPertanyaanList = carianPertanyaanList;
    }

    public HBangnDaoExt getCarianBangunaDaoExt() {
        return carianBangunaDaoExt;
    }

    public void setCarianBangunaDaoExt(HBangnDaoExt carianBangunaDaoExt) {
        this.carianBangunaDaoExt = carianBangunaDaoExt;
    }

    public List<HBangn> getBgnList() {
        return bgnList;
    }

    public void setBgnList(List<HBangn> bgnList) {
        this.bgnList = bgnList;
    }

    public HBangn getCarianBanguna() {
        return carianBanguna;
    }

    public void setCarianBanguna(HBangn carianBanguna) {
        this.carianBanguna = carianBanguna;
    }

}
