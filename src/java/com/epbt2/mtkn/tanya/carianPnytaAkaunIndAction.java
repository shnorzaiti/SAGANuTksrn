
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.mtkn.induk.dao.HVnduk;
import com.epbt2.mtkn.induk.dao.HVndukDao;
import com.epbt2.mtkn.induk.dao.HVpnyt;
import com.epbt2.mtkn.induk.dao.HVpnytDao;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Uzzair Baharudin
 */
public class carianPnytaAkaunIndAction extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;//DECLARE CONNECTION

    private HVndukDao carianHvndukDao = new HVndukDao();
    private HVnduk carianHvnduk = new HVnduk();//SETTER GETTER
    private List<HVnduk> carianHvndukList;//SETTER GETTER

    private HVpnytDao carianPenyataDao = new HVpnytDao();
    private HVpnyt carianPenyata = new HVpnyt();//SETTER GETTER
    private List<HVpnyt> carianPenyataList;//SETTER GETTER

    public String execute() throws Exception {
        
        conn = DBHelper.getConnectionDS();
        try {
            //carianPertanyaan = carianPertanyaanDao.getObject(conn, carianPertanyaan.getPEgakaun());
        
            carianPenyataList = carianPenyataDao.searchMatching(conn, carianPenyata);
        
            //
        
            carianHvndukList = carianHvndukDao.searchMatching(conn, carianHvnduk);
        
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;

    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public HVndukDao getCarianHvndukDao() {
        return carianHvndukDao;
    }

    public void setCarianHvndukDao(HVndukDao carianHvndukDao) {
        this.carianHvndukDao = carianHvndukDao;
    }

    public HVnduk getCarianHvnduk() {
        return carianHvnduk;
    }

    public void setCarianHvnduk(HVnduk carianHvnduk) {
        this.carianHvnduk = carianHvnduk;
    }

    public List<HVnduk> getCarianHvndukList() {
        return carianHvndukList;
    }

    public void setCarianHvndukList(List<HVnduk> carianHvndukList) {
        this.carianHvndukList = carianHvndukList;
    }

    public HVpnytDao getCarianPenyataDao() {
        return carianPenyataDao;
    }

    public void setCarianPenyataDao(HVpnytDao carianPenyataDao) {
        this.carianPenyataDao = carianPenyataDao;
    }

    public HVpnyt getCarianPenyata() {
        return carianPenyata;
    }

    public void setCarianPenyata(HVpnyt carianPenyata) {
        this.carianPenyata = carianPenyata;
    }

    public List<HVpnyt> getCarianPenyataList() {
        return carianPenyataList;
    }

    public void setCarianPenyataList(List<HVpnyt> carianPenyataList) {
        this.carianPenyataList = carianPenyataList;
    }

}
