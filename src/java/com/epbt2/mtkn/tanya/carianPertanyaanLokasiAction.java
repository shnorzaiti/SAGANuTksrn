/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.mtkn.induk.dao.HVnduk4;
import com.epbt2.mtkn.induk.dao.HVnduk4DaoExt;
import com.epbt2.mtkn.tanya.dao.HVpjln;
import com.epbt2.mtkn.tanya.dao.HVpjlnDaoExt;
import com.epbt2.spbt.ref.dao.FJalan;
import com.epbt2.spbt.ref.dao.FJalanDaoExt;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Uzzair Baharudin
 */
public class carianPertanyaanLokasiAction extends ActionSupport implements Preparable {
    
    private final Log log = LogFactory.getLog(this.getClass());
    
    private Connection conn;
    
    private HVpjlnDaoExt carianLokasiDaoExt = new HVpjlnDaoExt();
    private HVpjln carianLokasi = new HVpjln();
    private List<HVpjln> carianPertanyaanLokasiList;

    /* BYE 25/09/2014 */
    private String layout;
    /* BYE 25/09/2014 */

    /* BYE 23/06/2016 */
    private FJalanDaoExt jalanDaoExt = new FJalanDaoExt();
    private List<FJalan> jalanList;
    
    private HVnduk4DaoExt lokasiPerincianDaoExt = new HVnduk4DaoExt();
    private HVnduk4 lokasiPerincian = new HVnduk4();
    private List<HVnduk4> lokasiPerincianList;
    
    private String status;
    private String codeStatus;
    /* BYE 23/06/2016 */
    
    public String search() throws Exception {
        conn = DBHelper.getConnectionDS();
        try {
            ///if (carianLokasi.getJLkod() != null) {
            carianPertanyaanLokasiList = carianLokasiDaoExt.statusAkaun(conn, lokasiPerincian.getPegJlkod());
            /* } else {
             carianPertanyaanLokasiList = carianLokasiDao.loadAll(conn);
             }*/


            /* BYE 23/06/2016 */
            lokasiPerincianList = lokasiPerincianDaoExt.stsAkaunByJalan(conn, lokasiPerincian, status, codeStatus);
            /* BYE 23/06/2016 */
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        
        return SUCCESS;
        
    }

    /*public Connection getConn() {
     return conn;
     }

     public void setConn(Connection conn) {
     this.conn = conn;
     }

     public HVpjln getCarianLokasi() {
     return carianLokasi;
     }

     public void setCarianLokasi(HVpjln carianLokasi) {
     this.carianLokasi = carianLokasi;
     }
*/
     public List<HVpjln> getCarianPertanyaanLokasiList() {
     return carianPertanyaanLokasiList;
     }

     public void setCarianPertanyaanLokasiList(List<HVpjln> carianPertanyaanLokasiList) {
     this.carianPertanyaanLokasiList = carianPertanyaanLokasiList;
     }

    /* BYE 25/09/2014 */
    public String getLayout() {
        return layout;
    }
    
    public void setLayout(String layout) {
        this.layout = layout;
    }
    /* BYE 25/09/2014 */

    /* BYE 23/06/2016 */
    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();
        
        try {
            jalanList = jalanDaoExt.loadKodJalan(conn);
        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        
    }
    
    public List<FJalan> getJalanList() {
        return jalanList;
    }
    
    public void setJalanList(List<FJalan> jalanList) {
        this.jalanList = jalanList;
    }
    
    public List<HVnduk4> getLokasiPerincianList() {
        return lokasiPerincianList;
    }
    
    public void setLokasiPerincianList(List<HVnduk4> lokasiPerincianList) {
        this.lokasiPerincianList = lokasiPerincianList;
    }
    
    public HVnduk4 getLokasiPerincian() {
        return lokasiPerincian;
    }
    
    public void setLokasiPerincian(HVnduk4 lokasiPerincian) {
        this.lokasiPerincian = lokasiPerincian;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }
        
    /* BYE 23/06/2016 */
}
