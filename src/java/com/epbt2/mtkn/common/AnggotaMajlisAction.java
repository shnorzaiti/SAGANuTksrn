/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.common;

import com.epbt2.sspg.ref.dao.Pnelia;
import com.epbt2.sspg.ref.dao.PneliaDao;
import com.epbt2.sspg.ref.dao.PneliaDaoExt;
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
public class AnggotaMajlisAction extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;   
    private PneliaDaoExt PneliaDaoExt = new PneliaDaoExt();
    private PneliaDao PneliaDao = new PneliaDao();
    private Pnelia Pnelia = new Pnelia(); 
    private List<Pnelia> PneliaList;


    public String execute() throws Exception {
        conn = DBHelper.getConnectionDS();
        try{
            PneliaList = PneliaDaoExt.loadPNelia(conn);
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
           Pnelia = PneliaDao.getObject(conn, Pnelia.getPneNapek());
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return INPUT;

    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public PneliaDao getPneliaDao() {
        return PneliaDao;
    }

    public void setPneliaDao(PneliaDao PneliaDao) {
        this.PneliaDao = PneliaDao;
    }

    public Pnelia getPnelia() {
        return Pnelia;
    }

    public void setPnelia(Pnelia Pnelia) {
        this.Pnelia = Pnelia;
    }

    public List<Pnelia> getPneliaList() {
        return PneliaList;
    }

    public void setPneliaList(List<Pnelia> PneliaList) {
        this.PneliaList = PneliaList;
    }
     
}