/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epbt2.mtkn.tanya;

import com.epbt2.mtkn.pemprosesan.dao.HLpnyt;
import com.epbt2.mtkn.pemprosesan.dao.HLpnytDaoExt;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author NurMuhammadAfzal
 */
public class carianKutipanAction extends ActionSupport{
    
    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;//DECLARE CONNECTION
       
    private HLpnytDaoExt carianKutipanDaoExt = new HLpnytDaoExt();
    private HLpnyt carianKutipan = new HLpnyt();//SETTER GETTER

    public HLpnyt getCarianKutipan() {
        return carianKutipan;
    }

    public void setCarianKutipan(HLpnyt carianKutipan) {
        this.carianKutipan = carianKutipan;
    }

    public List<HLpnyt> getCarianKutipanList() {
        return carianKutipanList;
    }

    public void setCarianKutipanList(List<HLpnyt> carianKutipanList) {
        this.carianKutipanList = carianKutipanList;
    }
    private List<HLpnyt> carianKutipanList;//SETTER GETTER

    
    public String execute() throws Exception{
        conn = DBHelper.getConnectionDS();
        try {
          //carianKutipan = carianKutipanDao.getObject(conn, carianKutipan.getPEgakaun());
           
            carianKutipanList= carianKutipanDaoExt.searchMatching(conn, carianKutipan);
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;

    }
    
}
