/*
    Document   : KodAkaunAction
    Created on : May 24, 2014, 9:34:29 AM
    Author     : Mohammad Hafiz Tarmizi
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.mtkn.induk.dao.HLpmlk;
import com.epbt2.mtkn.induk.dao.HLpmlkDaoExt;
import com.epbt2.mtkn.induk.dao.HVnduk;
import com.epbt2.mtkn.induk.dao.HVndukDao;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.List;

/**
 *
 * @author Mohammad Hafiz 2 May 2014
 */
public class KodAkaunAction extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    //isytihar DAO GEN
    //private HVmjc1Dao terimaanDao = new HVmjc1Dao();
    private HLpmlkDaoExt pelMklumatPemilikDao = new HLpmlkDaoExt();
    private HLpmlk MklumatPemilik = new HLpmlk();
    private HVndukDao pelMklumatPeganganDao = new HVndukDao();
    private HVnduk MklumatPegangan = new HVnduk();

    private List<HLpmlk> MklumatPemilikList;
    private List<HVnduk> MklumatPeganganList;

    public String execute() throws Exception {

        conn = DBHelper.getConnectionDS();
        try {
            MklumatPemilikList = pelMklumatPemilikDao.loadPemilik(conn);

            MklumatPeganganList = pelMklumatPeganganDao.loadAll(conn);

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;
    }

    public HLpmlkDaoExt getPelMklumatPemilikDao() {
        return pelMklumatPemilikDao;
    }

    public void setPelMklumatPemilikDao(HLpmlkDaoExt pelMklumatPemilikDao) {
        this.pelMklumatPemilikDao = pelMklumatPemilikDao;
    }

    public HLpmlk getMklumatPemilik() {
        return MklumatPemilik;
    }

    public void setMklumatPemilik(HLpmlk MklumatPemilik) {
        this.MklumatPemilik = MklumatPemilik;
    }

    public HVndukDao getPelMklumatPeganganDao() {
        return pelMklumatPeganganDao;
    }

    public void setPelMklumatPeganganDao(HVndukDao pelMklumatPeganganDao) {
        this.pelMklumatPeganganDao = pelMklumatPeganganDao;
    }

    public HVnduk getMklumatPegangan() {
        return MklumatPegangan;
    }

    public void setMklumatPegangan(HVnduk MklumatPegangan) {
        this.MklumatPegangan = MklumatPegangan;
    }

    public List<HLpmlk> getMklumatPemilikList() {
        return MklumatPemilikList;
    }

    public void setMklumatPemilikList(List<HLpmlk> MklumatPemilikList) {
        this.MklumatPemilikList = MklumatPemilikList;
    }

    public List<HVnduk> getMklumatPeganganList() {
        return MklumatPeganganList;
    }

    public void setMklumatPeganganList(List<HVnduk> MklumatPeganganList) {
        this.MklumatPeganganList = MklumatPeganganList;
    }


}
