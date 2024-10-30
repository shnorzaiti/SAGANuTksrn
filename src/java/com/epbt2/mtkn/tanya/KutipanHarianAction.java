/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.mtkn.induk.dao.HVpnyt;
import com.epbt2.mtkn.induk.dao.HVpnytDaoExt2;
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
public class KutipanHarianAction extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private HVpnytDaoExt2 HVpnytDaoExt2 = new HVpnytDaoExt2();
    private HVpnyt HVpnyt = new HVpnyt();

    private List<HVpnyt> HVpnytList;

    /* BYE 25/09/2014 */
    private String layout;
    private String jmlhKutipan;
    /* BYE 25/09/2014 */

    /*public Connection getConn() {
     return conn;
     }

     public void setConn(Connection conn) {
     this.conn = conn;
     }

     public HVpnytDaoExt2 getHVpnytDaoExt2() {
     return HVpnytDaoExt2;
     }

     public void setHVpnytDaoExt2(HVpnytDaoExt2 HVpnytDaoExt2) {
     this.HVpnytDaoExt2 = HVpnytDaoExt2;
     }
*/
     public HVpnyt getHVpnyt() {
     return HVpnyt;
     }

     public void setHVpnyt(HVpnyt HVpnyt) {
     this.HVpnyt = HVpnyt;
     }
    public List<HVpnyt> getHVpnytList() {
        return HVpnytList;
    }

    public void setHVpnytList(List<HVpnyt> HVpnytList) {
        this.HVpnytList = HVpnytList;
    }

    public String execute() throws Exception {

        conn = DBHelper.getConnectionDS();
        try {
            if (HVpnyt.getPYttkhbl() != null) {
            HVpnytList = HVpnytDaoExt2.loadHVpnyt(conn, HVpnyt.getPYttkhbl());

            jmlhKutipan = HVpnytDaoExt2.jmlhKutipan(conn, HVpnyt.getPYttkhbl());
            }
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;

    }

    /* BYE 25/09/2014 */
    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getJmlhKutipan() {
        return jmlhKutipan;
    }

    public void setJmlhKutipan(String jmlhKutipan) {
        this.jmlhKutipan = jmlhKutipan;
    }
    /* BYE 25/09/2014 */

}
