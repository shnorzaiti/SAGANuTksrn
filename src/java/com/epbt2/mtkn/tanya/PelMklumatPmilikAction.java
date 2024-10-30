/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.mtkn.induk.dao.HLpmlk;
import com.epbt2.mtkn.induk.dao.HLpmlkDao;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Hafiz
 */
public class PelMklumatPmilikAction extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    //isytihar DAO GEN
    //private HVmjc1Dao terimaanDao = new HVmjc1Dao();
    private HLpmlkDao pelMklumatPmilikDao = new HLpmlkDao();
    private HLpmlk pelMklumatPmilik = new HLpmlk();

    private List<HLpmlk> pelMklumatPmilikList;

    public String execute() throws Exception {
        conn = DBHelper.getConnectionDS();
        try {
            pelMklumatPmilikList = pelMklumatPmilikDao.loadAll(conn);

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;
    }

    public HLpmlkDao getPelMklumatPmilikDao() {
        return pelMklumatPmilikDao;
    }

    public void setPelMklumatPmilikDao(HLpmlkDao pelMklumatPmilikDao) {
        this.pelMklumatPmilikDao = pelMklumatPmilikDao;
    }

    public HLpmlk getPelMklumatPmilik() {
        return pelMklumatPmilik;
    }

    public void setPelMklumatPmilik(HLpmlk pelMklumatPmilik) {
        this.pelMklumatPmilik = pelMklumatPmilik;
    }

    public List<HLpmlk> getPelMklumatPmilikList() {
        return pelMklumatPmilikList;
    }

    public void setPelMklumatPmilikList(List<HLpmlk> pelMklumatPmilikList) {
        this.pelMklumatPmilikList = pelMklumatPmilikList;
    }
    
}
