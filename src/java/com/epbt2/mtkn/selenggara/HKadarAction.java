/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.selenggara;

import com.epbt2.common.dao.StdLookupTable;
import com.epbt2.common.dao.StdLookupTableDao;
import com.epbt2.common.dao.StdLookupTableDaoExt;
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
import com.opensymphony.xwork2.Preparable;
import java.sql.SQLException;
import java.util.List;
import com.epbt2.util.Breadcrumb;
import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @author NurMuhammadAfzal
 */
public class HKadarAction extends ActionSupport implements Preparable {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private final StdLookupTableDao refDao = new StdLookupTableDao();
    private final StdLookupTableDaoExt refDaoExt = new StdLookupTableDaoExt();
    private StdLookupTable ref = new StdLookupTable();

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private HKadarDaoExt HKadarDaoExt = new HKadarDaoExt();
    private HKadar HKadar = new HKadar();

    private List<HKadar> HKadarList;

    private List<StdLookupTable> SenaraiHKadar;


    /*
     MohammadHafiz Wednesday July 23,2014
     */
    private HKadarDao objDao = new HKadarDao();

    /*
     end MohammadHafiz Wednesday July 23,2014
     */

 /*
     Keluarkan Single Value (August, 6, 2014)
     */
    public String execute() throws Exception {
        conn = DBHelper.getConnectionDS();
        try {
            log.debug("JENIS KADAR:" + HKadar.getKDrstatf());
            if (HKadar.getKDrstatf() != null) {
                retrieveData(conn, HKadar.getKDrstatf());
            }
            //if (HKadar.getRowID() != null) {
            /*if (HKadar.getRowNum() != null) {

             HKadar = HKadarDaoExt.kadarInfo(conn, HKadar.getRowNum());
             }*/

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;

    }

    public void retrieveData(Connection conn, String kdrStatf) throws SQLException {
        HKadarList = HKadarDaoExt.loadHKadar(conn, kdrStatf);

    }

    /*
     end Keluarkan Single Value (August, 6, 2014)
     */
 /*
     MohammadHafiz Wednesday july 23,2014
     */
    //@Override
    /* public String input() throws Exception {
     // log.debug("Inside input()");
     if (HKadar.getKDrstatf() != null) {
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
     }*/
    public String save() throws Exception {
        //  log.debug("Inside save()");

        conn = DBHelper.getConnectionDS();
        try {
            // show msg
            String[] msgArgs = {""};
            log.debug(HKadar.toString());
            for (int i = 0; i < HKadarList.size(); i++) {
                HKadar.setKDrstatf(HKadarList.get(i).getKDrstatf());
                HKadar.setKDrlower(HKadarList.get(i).getKDrlower());
                HKadar.setKDrupper(HKadarList.get(i).getKDrupper());
                HKadar.setKDramaun(HKadarList.get(i).getKDramaun());
                HKadar.setKDraminc(HKadarList.get(i).getKDraminc());
                HKadar.setKDrincre(HKadarList.get(i).getKDrincre());
                HKadar.setKDrpcent(HKadarList.get(i).getKDrpcent());
                HKadar.setRowID(HKadarList.get(i).getRowID());
                try {
                    // if (HKadar.getRowNum() != null) {
                    // log.debug("SAVE");
                    objDao.save(conn, HKadar);
                } catch (NotFoundException e) {
                    // } else {
                    //  log.debug("INSERT");
                    objDao.create(conn, HKadar);
                }
            }

            retrieveData(conn, HKadar.getKDrstatf());
            addActionMessage(getText("obj.upd", msgArgs));
            // if save or create success, get doc created date
            //obj = objDao.getObject(conn, obj.getNegNegri());
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

            for (int i = 0; i < HKadarList.size(); i++) {
                HKadar.setRowID(HKadarList.get(i).getRowID());

                if (HKadarList.get(i).getStsBuang() != null) {
                    if (HKadarList.get(i).getStsBuang().equals("true")) {
                        objDao.delete(conn, HKadar);
                    }
                }
            }

            execute();
            String[] msgArgs = {""};
            addActionMessage(getText("obj.del", msgArgs));
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
            /* LIST HKADAR PANEL */
            //HKadarList = HKadarDaoExt.loadAll(conn);

            /* LIST HKADAR PANEL */
 /* HKADAR PANEL */
            ref.setLookupGroup("STATF DNW"); //LOOKUP GROUP
            SenaraiHKadar = refDaoExt.searchMatching(conn, ref, "MTKN");

            /* HKADAR PANEL */
            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());
            
        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

    }

    /*public String find() throws Exception {
     log.debug("Inside find()");
     conn = DBHelper.getConnectionDS();
     try {
     HKadarList = objDao.loadAll(conn);
     log.debug("objList :" + HKadarList.size());
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

     public StdLookupTable getRef() {
     return ref;
     }

     public void setRef(StdLookupTable ref) {
     this.ref = ref;
     }

     public HKadarDaoExt getHKadarDaoExt() {
     return HKadarDaoExt;
     }

     public void setHKadarDaoExt(HKadarDaoExt HKadarDaoExt) {
     this.HKadarDaoExt = HKadarDaoExt;
     }*/
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

    public List<StdLookupTable> getSenaraiHKadar() {
        return SenaraiHKadar;
    }

    public void setSenaraiHKadar(List<StdLookupTable> SenaraiHKadar) {
        this.SenaraiHKadar = SenaraiHKadar;
    }

    /* public HKadarDao getObjDao() {
     return objDao;
     }

     public void setObjDao(HKadarDao objDao) {
     this.objDao = objDao;
     }*/

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName;
    }
    
    
}
