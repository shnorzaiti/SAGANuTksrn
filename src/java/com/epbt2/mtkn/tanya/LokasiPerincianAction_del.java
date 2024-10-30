/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epbt2.mtkn.tanya;


import com.epbt2.mtkn.induk.dao.HVnduk4;
import com.epbt2.mtkn.induk.dao.HVnduk4DaoExt;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Uzzair Baharudin
 */
public class LokasiPerincianAction_del extends ActionSupport{
    
    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;
    
    private HVnduk4DaoExt LokasiPerincianDaoExt = new HVnduk4DaoExt();
    private HVnduk4 LokasiPerincian = new HVnduk4();
    private List<HVnduk4> LokasiPerincianList; 
    
    /* BYE 07/10/2014 */
    private String layout;
    /* BYE 07/10/2014 */
    
    public String execute() throws Exception{
        conn = DBHelper.getConnectionDS();
        try {
          //carianPertanyaan = carianPertanyaanDao.getObject(conn, carianPertanyaan.getPEgakaun());
          
            //LokasiPerincianList= LokasiPerincianDaoExt.stsAkaunByJalan(conn, LokasiPerincian);
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;

    }

  /*  public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public HVnduk2Dao getLokasiPerincianDao() {
        return LokasiPerincianDao;
    }

    public void setLokasiPerincianDao(HVnduk2Dao LokasiPerincianDao) {
        this.LokasiPerincianDao = LokasiPerincianDao;
    }*/

    public HVnduk4 getLokasiPerincian() {
        return LokasiPerincian;
    }

    public void setLokasiPerincian(HVnduk4 LokasiPerincian) {
        this.LokasiPerincian = LokasiPerincian;
    }

    public List<HVnduk4> getLokasiPerincianList() {
        return LokasiPerincianList;
    }

    public void setLokasiPerincianList(List<HVnduk4> LokasiPerincianList) {
        this.LokasiPerincianList = LokasiPerincianList;
    } 
    
    /* BYE 25/09/2014 */
    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }
    /* BYE 25/09/2014 */
}
