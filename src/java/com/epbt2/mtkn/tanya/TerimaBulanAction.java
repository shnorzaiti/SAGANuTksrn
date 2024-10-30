/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.common.dao.StdLookupTable;
import com.epbt2.common.dao.StdLookupTableDao;
import com.epbt2.mtkn.tanya.dao.HVptrx;
import com.epbt2.mtkn.tanya.dao.HVptrxDaoExt;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.Preparable;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author NurMuhammadAfzal
 */
public class TerimaBulanAction extends ActionSupport implements Preparable{

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;
    
    //isytihar DAO GEN
    //private HVmjc1Dao terimaanDao = new HVmjc1Dao();
    private HVptrxDaoExt terimabulanDaoExt = new HVptrxDaoExt();
    private HVptrx terimabulan = new HVptrx();
    private List<HVptrx> listTahun;
    private String Tahun;

    /* BYE 25/09/2014 */
    private final StdLookupTableDao refDao = new StdLookupTableDao();
    private final StdLookupTable ref = new StdLookupTable();
    
    private String jmlhTerimaan;
    private List<StdLookupTable> listBulan;
    private String layout;
    /* BYE 25/09/2014 */
    
    public String getTahun() {
        return Tahun;
    }

    public void setTahun(String Tahun) {
        this.Tahun = Tahun;
    }

    public List<HVptrx> getListTahun() {
        return listTahun;
    }

    public void setListTahun(List<HVptrx> listTahun) {
        this.listTahun = listTahun;
    }
   
    
    private List<HVptrx> terimabulanList;

    

    public String execute() throws Exception {

        conn = DBHelper.getConnectionDS();
        try{
            if(Tahun==null){
                Calendar now = Calendar.getInstance();
                Tahun = String.valueOf(now.get(Calendar.YEAR));
            }
            terimabulanList = terimabulanDaoExt.loadTerimaBulan(conn, Tahun);
            //log.debug("TERIMABULAN:"+terimabulanList.toString());
            
            jmlhTerimaan = terimabulanDaoExt.jmlhTerimaan(conn, Tahun);
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());            
        } finally {
            DBHelper.closeConnection(conn);            
        }       

        return SUCCESS;
    
    }

    public List<HVptrx> getTerimabulanList() {
        return terimabulanList;
    }

    public void setTerimabulanList(List<HVptrx> terimabulanList) {
        this.terimabulanList = terimabulanList;
    }
   

   @Override
   public void prepare() throws Exception {
   conn = DBHelper.getConnectionDS();
        try{
           listTahun = terimabulanDaoExt.listTahun(conn);
           ref.setLookupGroup("RBULAN");
           ref.setLookupStatus("A");
           listBulan = refDao.searchMatching(conn, ref, "SPBT");
           
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());            
        } finally {
            DBHelper.closeConnection(conn);            
        }             
   }   
   
    /* BYE 25/09/2014 */

    public String getJmlhTerimaan() {
        return jmlhTerimaan;
    }

    public void setJmlhTerimaan(String jmlhTerimaan) {
        this.jmlhTerimaan = jmlhTerimaan;
    }

    public List<StdLookupTable> getListBulan() {
        return listBulan;
    }

    public void setListBulan(List<StdLookupTable> listBulan) {
        this.listBulan = listBulan;
    }
    
    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }
    /* BYE 25/09/2014 */ 
}

