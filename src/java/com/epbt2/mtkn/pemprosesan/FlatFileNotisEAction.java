/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan;

import com.epbt2.common.dao.StdLookupTable;
import com.epbt2.common.dao.StdLookupTableDao;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author shahr
 */
public class FlatFileNotisEAction extends ActionSupport implements Preparable {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private StdLookupTable drop = new StdLookupTable();
    private StdLookupTableDao dropDao = new StdLookupTableDao();

    private List<StdLookupTable> dropList;
    private List<StdLookupTable> jpkList;

    private String status;
    private String jpkod;
    private String pilihan;
    private String akaun1;
    private String akaun2;
    private String mnjln1;
    private String mnjln2;
    private String nolot1;
    private String nolot2;
    private String rjfil1;
    private String rjfil2;
   
    
    public String save() throws Exception {
        log.debug("Inside save()");

        conn = DBHelper.getConnectionDS();
        try {
            // show msg
            String[] msgArgs = {};

            addActionMessage(getText("Notis E telah berjaya di jana..", msgArgs));

            flatNotisE(conn, status, jpkod, pilihan, akaun1, akaun2, mnjln1, mnjln2, nolot1, nolot2, rjfil1, rjfil2);

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return SUCCESS;

    }
    
    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {


            drop.setLookupGroup("STATUS");
            dropList = dropDao.searchMatching(conn, drop, "MTKN");
            
            drop.setLookupGroup("JPKOD");
            jpkList = dropDao.searchMatching(conn, drop, "MTKN");

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

    }
    
     public void flatNotisE(Connection conn, String status, String jpkod, String pilihan, String akaun1, String akaun2, String mnjln1, String mnjln2, String nolot1,
            String nolot2, String rjfil1, String rjfil2) throws SQLException {

        String sql = "{ call mtkn.sp_mtkn.sedia_flatfile_excel_notis('" + status + "','" + jpkod + "','" + pilihan + "','" + akaun1 + "','"+ akaun2 +"','"+ mnjln1 +"','"+ mnjln2 +"','"+ nolot1 +"','"+ nolot2 +"','"+ rjfil1 +"','"+ rjfil2 +"') } "; 
         PreparedStatement stmt = null;
        ResultSet result = null;
        
        try {
            stmt = conn.prepareCall(sql);


            result = stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public StdLookupTable getDrop() {
        return drop;
    }

    public void setDrop(StdLookupTable drop) {
        this.drop = drop;
    }

    public List<StdLookupTable> getDropList() {
        return dropList;
    }

    public void setDropList(List<StdLookupTable> dropList) {
        this.dropList = dropList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
    }

    public String getAkaun1() {
        return akaun1;
    }

    public void setAkaun1(String akaun1) {
        this.akaun1 = akaun1;
    }

    public String getAkaun2() {
        return akaun2;
    }

    public void setAkaun2(String akaun2) {
        this.akaun2 = akaun2;
    }

    public String getMnjln1() {
        return mnjln1;
    }

    public void setMnjln1(String mnjln1) {
        this.mnjln1 = mnjln1;
    }

    public String getMnjln2() {
        return mnjln2;
    }

    public void setMnjln2(String mnjln2) {
        this.mnjln2 = mnjln2;
    }

    public String getNolot1() {
        return nolot1;
    }

    public void setNolot1(String nolot1) {
        this.nolot1 = nolot1;
    }

    public String getNolot2() {
        return nolot2;
    }

    public void setNolot2(String nolot2) {
        this.nolot2 = nolot2;
    }

    public String getRjfil1() {
        return rjfil1;
    }

    public void setRjfil1(String rjfil1) {
        this.rjfil1 = rjfil1;
    }

    public String getRjfil2() {
        return rjfil2;
    }

    public void setRjfil2(String rjfil2) {
        this.rjfil2 = rjfil2;
    }

    public String getJpkod() {
        return jpkod;
    }

    public void setJpkod(String jpkod) {
        this.jpkod = jpkod;
    }

    public List<StdLookupTable> getJpkList() {
        return jpkList;
    }

    public void setJpkList(List<StdLookupTable> jpkList) {
        this.jpkList = jpkList;
    }
    
    
  
}
