/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epbt2.mtkn.common;

/**
 *
 * @author farisazri
 */


import com.epbt2.spbt.ref.dao.FJalan;
import com.epbt2.spbt.ref.dao.FJalanDaoExt;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JalanAction extends ActionSupport {
    
    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;
    
    private FJalan JalanPop = new FJalan();
    private FJalanDaoExt JalanPopDaoExt = new FJalanDaoExt();
        
    private List<FJalan> JalanPopList;
    
    private String idField;    
    
    public String execute() {

        try {

            conn = DBHelper.getConnectionDS();

            //untuk rekod
                JalanPopList = JalanPopDaoExt.loadKodJalan(conn);

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;
    }
    

    public List<FJalan> getJalanPopList() {
        return JalanPopList;
    }

    public void setJalanPopList(List<FJalan> JalanPopList) {
        this.JalanPopList = JalanPopList;
    }

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }
    
    
    
}
