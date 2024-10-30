/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.laporan;

import com.epbt2.mtkn.ref.dao.HLjabt;
import com.epbt2.mtkn.ref.dao.HLjabtDaoExt;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author otasoft01
 */
public class MaklCBKJsonAction extends ActionSupport {

    private Log log = LogFactory.getLog(this.getClass());

    private Connection conn;
    private HLjabtDaoExt jabtDaoExt = new HLjabtDaoExt();
    private HLjabt jabt = new HLjabt();

    private String passData;
    private int rekodWujud;

    public String data() {

        try {
            conn = DBHelper.getConnectionDS();

            jabt.setJabJbkod(passData);
            rekodWujud = jabtDaoExt.countExist(conn, jabt);
            if (rekodWujud != 0) {
                jabt = jabtDaoExt.maklJabt(conn, jabt.getJabJbkod());
            }
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());

        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;
    }

    public String getJSON() throws Exception {
        return data();
    }

    public String getPassData() {
        return passData;
    }

    public void setPassData(String passData) {
        this.passData = passData;
    }

    public HLjabt getJabt() {
        return jabt;
    }

    public void setJabt(HLjabt jabt) {
        this.jabt = jabt;
    }

    public int getRekodWujud() {
        return rekodWujud;
    }

    public void setRekodWujud(int rekodWujud) {
        this.rekodWujud = rekodWujud;
    }

}
