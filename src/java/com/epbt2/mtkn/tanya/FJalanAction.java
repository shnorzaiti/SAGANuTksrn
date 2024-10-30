/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.spbt.ref.dao.FJalan;
import com.epbt2.spbt.ref.dao.FJalanDaoExt;
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
public class FJalanAction extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;
    
    
    private FJalanDaoExt FJalanDaoExt = new FJalanDaoExt();
    private FJalan FJalan = new FJalan();    
   
    
    private List<FJalan> FJalanList;
    
    
    
    
    

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public FJalanDaoExt getFJalanDaoExt() {
        return FJalanDaoExt;
    }

    public void setFJalanDaoExt(FJalanDaoExt FJalanDaoExt) {
        this.FJalanDaoExt = FJalanDaoExt;
    }

    public FJalan getFJalan() {
        return FJalan;
    }

    public void setFJalan(FJalan FJalan) {
        this.FJalan = FJalan;
    }

    public List<FJalan> getFJalanList() {
        return FJalanList;
    }

    public void setFJalanList(List<FJalan> FJalanList) {
        this.FJalanList = FJalanList;
    }
   
    public String execute() throws Exception {

        conn = DBHelper.getConnectionDS();
        try{
            FJalanList = FJalanDaoExt.loadFJalan(conn);            
            
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());            
        } finally {
            DBHelper.closeConnection(conn);            
        }       

        return SUCCESS;
    
    }

  
}

