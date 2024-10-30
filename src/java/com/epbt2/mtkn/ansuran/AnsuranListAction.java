/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epbt2.mtkn.ansuran;

import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.epbt2.mtkn.ansuran.dao.HLins2;
import com.epbt2.mtkn.ansuran.dao.HLins2DaoExt;
import com.epbt2.util.DBHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author tiena
 */
public class AnsuranListAction extends ActionSupport implements UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());
    
    private Connection conn;

    private User userModel = new User();
    
    private HLins2DaoExt ansuranDaoExt = new HLins2DaoExt();
    private HLins2 ansuran = new HLins2();
    
    private List<HLins2> ansuranList;
    
    private String carianAkaun;
    private String carianNama;
    
    public String execute() throws Exception {
        conn = DBHelper.getConnectionDS();
        try {            
            if (carianAkaun != null || carianNama != null) {
                 ansuranList = ansuranDaoExt.listSearchAnsuran(conn, carianAkaun, carianNama);
            } else {
                ansuranList = ansuranDaoExt.listAnsuran(conn);
            }
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return SUCCESS;
    }
    
    public List<HLins2> getAnsuranList() {
        return ansuranList;
    }
    
    public void setAnsuranList(List<HLins2> ansuranList) {
        this.ansuranList = ansuranList;
    }
    
    public String getCarianAkaun() {
        return carianAkaun;
    }
    
    public void setCarianAkaun(String carianAkaun) {
        this.carianAkaun = carianAkaun;
    }
    
    public String getCarianNama() {
        return carianNama;
    }
    
    public void setCarianNama(String carianNama) {
        this.carianNama = carianNama;
    }  
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
