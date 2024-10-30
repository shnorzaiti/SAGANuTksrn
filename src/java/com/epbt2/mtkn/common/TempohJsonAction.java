/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.common;

import com.epbt2.util.DateHelper;
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
public class TempohJsonAction extends ActionSupport {

    private Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private DateHelper dtHelper = new DateHelper();
    //private LmulusNiaga niaga = new LmulusNiaga();
    private String passTkhLulus;
    private String passTempoh;
    private String tkhTamat;

    public String data() {

        try {
            conn = DBHelper.getConnectionDS();
            
            if (passTkhLulus != null && !passTkhLulus.equals("") && passTempoh != null && !passTempoh.equals("")) {
                setTkhTamat(dtHelper.tarikhAkhirLesen(conn, passTkhLulus, passTempoh));
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

    public String getPassTkhLulus() {
        return passTkhLulus;
    }

    public void setPassTkhLulus(String passTkhLulus) {
        this.passTkhLulus = passTkhLulus;
    }

    public String getPassTempoh() {
        return passTempoh;
    }

    public void setPassTempoh(String passTempoh) {
        this.passTempoh = passTempoh;
    }

    public String getTkhTamat() {
        return tkhTamat;
    }

    public void setTkhTamat(String tkhTamat) {
        this.tkhTamat = tkhTamat;
    }
}
