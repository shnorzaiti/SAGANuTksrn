/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.selenggara;

import com.epbt2.mtkn.selenggara.dao.HKadar;
import com.epbt2.mtkn.selenggara.dao.HKadarDao;
import com.epbt2.mtkn.selenggara.dao.HKadarDaoExt;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.DBHelper;
import com.epbt2.util.NotFoundException;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.List;

/**
 *
 * @author MohammadHafiz
 */
public class HKadarAction_del extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private HKadarDaoExt HKadarDaoExt = new HKadarDaoExt();
    private HKadar HKadar = new HKadar();
    private List<HKadar> HKadarList;

    /*
     MohammadHafiz Wednesday July 23,2014
     */
    private HKadarDao objDao = new HKadarDao();
    /*
     end MohammadHafiz Wednesday July 23,2014
     */

    public String execute() throws Exception {
        conn = DBHelper.getConnectionDS();
        try {
log.debug(HKadar.toString());
            if (HKadar.getKDrstatf() != null) {
                HKadarList = HKadarDaoExt.loadHKadar(conn, HKadar.getKDrstatf());
            }

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;

    }

    public String delete() throws Exception {
        conn = DBHelper.getConnectionDS();
        try {
            HKadar = HKadarDaoExt.Kadar(conn, HKadar.getRowID());
            log.debug(HKadar.toString());
            // show msg
            String[] msgArgs = {HKadar.getKDrstatf() + " Bagi Kadar " + HKadar.getKDrlower() + " - " + HKadar.getKDrupper()};

            objDao.delete(conn, HKadar);
            //find();
            addActionMessage(getText("obj.del", msgArgs));
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return SUCCESS;
    }
    /*
     MohammadHafiz Wednesday july 23,2014
     */
    // @Override
  /*  public String input() throws Exception {
     if (HKadar.getKDrstatf()!= null) {
     conn = DBHelper.getConnectionDS();
     try {
     HKadar = objDao.getObject(conn, HKadar.getKDrstatf());
     } catch (Exception e) {
     addActionError("Error : " + e);
     log.error(e, e.fillInStackTrace());
     } finally {
     DBHelper.closeConnection(conn);
     }
     }
     return INPUT;
     }
    
     public String save() throws Exception {
     conn = DBHelper.getConnectionDS();
     try {
     // show msg
     String[] msgArgs = {HKadar.getKDrstatf()};
            
     try {
     objDao.save(conn, HKadar);
     addActionMessage(getText("obj.upd", msgArgs));
     } catch (NotFoundException e) {
     objDao.create(conn, HKadar);
     addActionMessage(getText("obj.add", msgArgs));
     } 
            
     } catch (Exception e) {
     addActionError("Error : " + e);
     log.error(e, e.fillInStackTrace());
     } finally {
     DBHelper.closeConnection(conn);
     }
     return SUCCESS;

     }
     

     public String find() throws Exception {
     conn = DBHelper.getConnectionDS();
     try {
     HKadarList = objDao.loadAll(conn);
     } catch (Exception e) {
     addActionError("Error : " + e);
     log.error(e, e.fillInStackTrace());
     } finally {
     DBHelper.closeConnection(conn);
     }
     return SUCCESS;
     }*/

    /*
     end Mohammad Hafiz Wednesday July 23,2014
     */
    /*public Connection getConn() {
     return conn;
     }

     public void setConn(Connection conn) {
     this.conn = conn;
     }
     public HKadarDaoExt getHKadarDaoExt() {
     return HKadarDaoExt;
     }

     public void setHKadarDaoExt(HKadarDaoExt HKadarDaoExt) {
     this.HKadarDaoExt = HKadarDaoExt;
     }
     */
    public HKadar getHKadar() {
        return HKadar;
    }

    public void setHKadar(HKadar HKadar) {
        this.HKadar = HKadar;
    }

    public List<HKadar> getHKadarList() {
        return HKadarList;
    }

    public void setHKadarList(List<HKadar> HKadarList) {
        this.HKadarList = HKadarList;
    }

    /*public HKadarDao getObjDao() {
     return objDao;
     }

     public void setObjDao(HKadarDao objDao) {
     this.objDao = objDao;
     }*/
}
