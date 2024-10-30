/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epbt2.mtkn.common;

import com.epbt2.mtkn.common.dao.Msggpr;
import com.epbt2.mtkn.common.dao.MsggprDao;
import com.epbt2.util.DBHelper;
import com.epbt2.util.NotFoundException;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class MesejBilAction extends ActionSupport{
    
    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;
    
    private Msggpr msj = new Msggpr();
    private MsggprDao msjDao = new MsggprDao();
    
    
    private List<Msggpr> msjList;
    
    
    public String execute() throws Exception{
        
            conn = DBHelper.getConnectionDS();
            try {
                
                msj = msjDao.getObject(conn, getMsj().getMnmsej());
            } catch (Exception e) {
                addActionError("Error : " + e);
                log.error(e, e.fillInStackTrace());
            } finally {
                DBHelper.closeConnection(conn);
            }

        return SUCCESS;
    }
    
    public String save() throws Exception {
        log.debug("Inside save()");

        conn = DBHelper.getConnectionDS();
        try {
            // show msg
            String[] msgArgs = {msj.getMnmsej()};

           // try {
                log.debug("SAVE");
                msjDao.save(conn, msj);
                addActionMessage(getText("Mesej Berjaya Dikemaskini", msgArgs));
           /*} catch (NotFoundException e) {
                log.debug("INSERT");
                msjDao.create(conn, msj);
                addActionMessage(getText("Mesej Berjaya Ditambah", msgArgs));
            }*/
            // if save or create success, get doc created date
            //obj = objDao.getObject(conn, obj.getNegNegri());
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return SUCCESS;

    }

    public Msggpr getMsj() {
        return msj;
    }

    public void setMsj(Msggpr msj) {
        this.msj = msj;
    }

    public MsggprDao getMsjDao() {
        return msjDao;
    }

    public void setMsjDao(MsggprDao msjDao) {
        this.msjDao = msjDao;
    }
    
        
    
    
}