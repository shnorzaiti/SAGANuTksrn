/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
* MOHAMMAD HAFIZ MAY, 27,2014
*
*/

package com.epbt2.mtkn.tanya;



import com.epbt2.mtkn.tanya.dao.VTstat;
import com.epbt2.mtkn.tanya.dao.VTstatDao;
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
public class MklumatTransaksiAction  extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    //isytihar DAO GEN
    //private HVmjc1Dao terimaanDao = new HVmjc1Dao();
    private VTstatDao mklumatTransaksiDao = new VTstatDao();
    private VTstat mklumatTransaksi = new VTstat();

    private List<VTstat> mklumatTransaksiList;
   

    public String execute() throws Exception {
        conn = DBHelper.getConnectionDS();
        try{
            
            mklumatTransaksiList = mklumatTransaksiDao.loadVTstat(conn);            
            
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());            
        } finally {
            DBHelper.closeConnection(conn);            
        }       

        return SUCCESS;
    
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public VTstatDao getMklumatTransaksiDao() {
        return mklumatTransaksiDao;
    }

    public void setMklumatTransaksiDao(VTstatDao mklumatTransaksiDao) {
        this.mklumatTransaksiDao = mklumatTransaksiDao;
    }

    public VTstat getMklumatTransaksi() {
        return mklumatTransaksi;
    }

    public void setMklumatTransaksi(VTstat mklumatTransaksi) {
        this.mklumatTransaksi = mklumatTransaksi;
    }

    public List<VTstat> getMklumatTransaksiList() {
        return mklumatTransaksiList;
    }

    public void setMklumatTransaksiList(List<VTstat> mklumatTransaksiList) {
        this.mklumatTransaksiList = mklumatTransaksiList;
    }

}
