/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.common;

import com.epbt2.mtkn.ref.dao.HLjabt;
import com.epbt2.mtkn.ref.dao.HLjabtDao;
import com.epbt2.mtkn.ref.dao.HLjabtDaoExt;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.List;

/**
 *
 * @author NurMuhammadAfzal
 */
public class HLjabtAction extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;   
    private HLjabtDaoExt HLjabtDaoExt = new HLjabtDaoExt();
    private HLjabtDao HLjabtDao = new HLjabtDao();
    private HLjabt HLjabt = new HLjabt(); 
    private List<HLjabt> HLjabtList;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public HLjabtDaoExt getHLjabtDaoExt() {
        return HLjabtDaoExt;
    }

    public void setHLjabtDaoExt(HLjabtDaoExt HLjabtDaoExt) {
        this.HLjabtDaoExt = HLjabtDaoExt;
    }

    public HLjabt getHLjabt() {
        return HLjabt;
    }

    public void setHLjabt(HLjabt HLjabt) {
        this.HLjabt = HLjabt;
    }

    public List<HLjabt> getHLjabtList() {
        return HLjabtList;
    }

    public void setHLjabtList(List<HLjabt> HLjabtList) {
        this.HLjabtList = HLjabtList;
    }

    
    

    public String execute() throws Exception {
        conn = DBHelper.getConnectionDS();
        try{
            HLjabtList = HLjabtDaoExt.loadHLjabt(conn);
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());            
        } finally {
            DBHelper.closeConnection(conn);            
        }       

        return SUCCESS;
    
    }  
    
     public String input() throws Exception{
        conn = DBHelper.getConnectionDS();
        try {
           HLjabt = HLjabtDao.getObject(conn, HLjabt.getJabJbkod());
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return INPUT;

    }
}