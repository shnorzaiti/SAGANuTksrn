/*
    Document   : HutangTerimaanCbk
    Created on : May 6, 2014, 9:34:29 AM
    Author     : Mohammad Hafiz Tarmizi
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;


import com.epbt2.mtkn.tanya.dao.HVcmk1;
import com.epbt2.mtkn.tanya.dao.HVcmk1DaoExt;
import com.epbt2.mtkn.tanya.dao.HVcmk2;
import com.epbt2.mtkn.tanya.dao.HVcmk2DaoExt;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 *
 * @author Mohammad Hafiz 2 May 2014 
 * edit by : 25/09/2014 (BYE)
 */
public class HutangTerimaanCbkAction extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    //isytihar DAO GEN
    //private HVmjc1Dao terimaanDao = new HVmjc1Dao();
    private HVcmk1DaoExt terimaanCbkDao = new HVcmk1DaoExt();
    private HVcmk1 terimaanCbk = new HVcmk1();
    private HVcmk2DaoExt hutangCbkDaoExt = new HVcmk2DaoExt();
    private HVcmk2 hutangCbk = new HVcmk2();

    /*private List<HVcmk1> terimaanCbkList;
    private List<HVcmk2> hutangCbkList;*/

    public String execute() throws Exception {

        conn = DBHelper.getConnectionDS();
        try {
            //terimaanCbkList = terimaanCbkDao.loadTerimaanCbk(conn);
            terimaanCbk = terimaanCbkDao.loadTerimaanCbk(conn);

            //hutangCbkList = hutangCbkDaoExt.loadHutangCbk(conn);
            hutangCbk = hutangCbkDaoExt.loadHutangCbk(conn);

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;
    }

    /* public Connection getConn() {
    return conn;
    }
    public void setConn(Connection conn) {
    this.conn = conn;
    }
    public HVcmk2DaoExt getHutangCbkDaoExt() {
    return hutangCbkDaoExt;
    }
    public void setHutangCbkDaoExt(HVcmk2DaoExt hutangCbkDaoExt) {
    this.hutangCbkDaoExt = hutangCbkDaoExt;
    }
    public HVcmk2 getHutangCbk() {
    return hutangCbk;
    }
    public void setHutangCbk(HVcmk2 hutangCbk) {
    this.hutangCbk = hutangCbk;
    }
    public HVcmk1DaoExt getTerimaanCbkDao() {
    return terimaanCbkDao;
    }
    public void setTerimaanCbkDao(HVcmk1DaoExt terimaanCbkDao) {
    this.terimaanCbkDao = terimaanCbkDao;
    }
    public HVcmk1 getTerimaanCbk() {
    return terimaanCbk;
    }
    public void setTerimaanCbk(HVcmk1 terimaanCbk) {
    this.terimaanCbk = terimaanCbk;
    }
    public List<HVcmk1> getTerimaanCbkList() {
    return terimaanCbkList;
    }
    public void setTerimaanCbkList(List<HVcmk1> terimaanCbkList) {
    this.terimaanCbkList = terimaanCbkList;
    }
    public List<HVcmk2> getHutangCbkList() {
    return hutangCbkList;
    }
    public void setHutangCbkList(List<HVcmk2> hutangCbkList) {
    this.hutangCbkList = hutangCbkList;
    }*/
    public HVcmk1 getTerimaanCbk() {
        return terimaanCbk;
    }

    public void setTerimaanCbk(HVcmk1 terimaanCbk) {
        this.terimaanCbk = terimaanCbk;
    }

    public HVcmk2 getHutangCbk() {
        return hutangCbk;
    }

    public void setHutangCbk(HVcmk2 hutangCbk) {
        this.hutangCbk = hutangCbk;
    }
    

}
