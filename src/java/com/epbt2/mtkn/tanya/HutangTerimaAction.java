/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.mtkn.tanya.dao.HVmjc1;
import com.epbt2.mtkn.tanya.dao.HVmjc1DaoExt;
import com.epbt2.mtkn.tanya.dao.HVmjc2;
import com.epbt2.mtkn.tanya.dao.HVmjc2DaoExt;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 *
 * @author NurMuhammadAfzal
 * Edit By : 
 * 25/09/2014 (BYE)
 */
public class HutangTerimaAction extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;
    
    //isytihar DAO GEN
    //private HVmjc1Dao terimaanDao = new HVmjc1Dao();
    private HVmjc1DaoExt terimaanDaoExt = new HVmjc1DaoExt();
    private HVmjc1 terimaan = new HVmjc1();
    private HVmjc2DaoExt hutangDao = new HVmjc2DaoExt();
    private HVmjc2 hutang = new HVmjc2();
    
    //private List<HVmjc1> terimaList;
    //private List<HVmjc2> hutangList;
    

    public String execute() throws Exception {

        conn = DBHelper.getConnectionDS();
        try{
            //terimaList = terimaanDaoExt.loadTerimaan(conn);
            terimaan = terimaanDaoExt.loadTerimaan(conn);
            
            //hutangList = hutangDao.loadHutang(conn);
            hutang = hutangDao.loadHutang(conn);
            
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());            
        } finally {
            DBHelper.closeConnection(conn);            
        }       

        return SUCCESS;
    
    }

/* public List<HVmjc2> getHutangList() {
        return hutangList;
    }

    public void setHutangList(List<HVmjc2> hutangList) {
        this.hutangList = hutangList;
    }

    

  

    public List<HVmjc1> getTerimaList() {
        return terimaList;
    }

    public void setTerimaList(List<HVmjc1> terimaList) {
        this.terimaList = terimaList;
    }*/

    public HVmjc1 getTerimaan() {
        return terimaan;
    }

    public void setTerimaan(HVmjc1 terimaan) {
        this.terimaan = terimaan;
    }

    public HVmjc2 getHutang() {
        return hutang;
    }

    public void setHutang(HVmjc2 hutang) {
        this.hutang = hutang;
    }
    
    
}

