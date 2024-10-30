/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya;

import com.epbt2.mtkn.induk.dao.HLpgng;
import com.epbt2.mtkn.induk.dao.HLpgngDao;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Uzzair Baharudin
 */
public class AkaunLama extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;

    private HLpgngDao akaunLamaDao = new HLpgngDao();
    private HLpgng akaunLama = new HLpgng();

    public HLpgng getAkaunLama() {
        return akaunLama;
    }

    public void setAkaunLama(HLpgng akaunLama) {
        this.akaunLama = akaunLama;
    }

    
    public String execute() throws Exception{
        
        conn = DBHelper.getConnectionDS();
        try {
          akaunLama = akaunLamaDao.getObject(conn, akaunLama.getPEgakaun());        
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;

    }
}
