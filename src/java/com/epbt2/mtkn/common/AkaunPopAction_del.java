/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epbt2.mtkn.common;

/**
 *
 * @author farisazri
 */

import com.epbt2.mtkn.common.dao.HLpgng;
import com.epbt2.mtkn.common.dao.HLpgngDaoExt;
import com.epbt2.common.model.PageSize;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AkaunPopAction_del extends ActionSupport implements Preparable {
    
    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;
    
    private HLpgng AkaunPop = new HLpgng();
    private HLpgngDaoExt AkaunPopDaoExt = new HLpgngDaoExt();
    
    private List <HLpgng> AkaunPopList;
    
    private String carian;
    private String PMkakaun;
    private String PMknmbil;
    
    private final PageSize pageSize = new PageSize();
    private List<PageSize.PageSizeItem> pageSizeList;
    private int pageSizeSelected;
    
    public String execute() {

        try {

            conn = DBHelper.getConnectionDS();

            //untuk rekod
            /**if (pageSizeSelected == 0) {
                pageSizeSelected = 10;
            }

            if (getCarian() == null) {
                AkaunPopList = AkaunPopDaoExt.loadKodAkaun(conn, AkaunPop);
            } else {**/
                
                if (!PMkakaun.equals("")) {
                    AkaunPop.setPMkakaun(PMkakaun);
                }
                if (!PMknmbil.equals("")) {
                    AkaunPop.setPMknmbil(PMknmbil);
                }
                AkaunPopList = AkaunPopDaoExt.carianAkaun(conn, AkaunPop);
            //}

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;
    }
    
    public String clear() {
        try {
            conn = DBHelper.getConnectionDS();

            setPMkakaun("");
            setPMknmbil("");
            
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
        return SUCCESS;
    }
    
    @Override
    public void prepare() {
        try {
            pageSizeList = pageSize.getPageSizeList();
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        }
    }

    public HLpgng getAkaunPop() {
        return AkaunPop;
    }

    public void setAkaunPop(HLpgng AkaunPop) {
        this.AkaunPop = AkaunPop;
    }

    public HLpgngDaoExt getAkaunPopDaoExt() {
        return AkaunPopDaoExt;
    }

    public void setAkaunPopDaoExt(HLpgngDaoExt AkaunPopDaoExt) {
        this.AkaunPopDaoExt = AkaunPopDaoExt;
    }

    public List<HLpgng> getAkaunPopList() {
        return AkaunPopList;
    }

    public void setAkaunPopList(List<HLpgng> AkaunPopList) {
        this.AkaunPopList = AkaunPopList;
    }

    public String getCarian() {
        return carian;
    }

    public void setCarian(String carian) {
        this.carian = carian;
    }

    public List<PageSize.PageSizeItem> getPageSizeList() {
        return pageSizeList;
    }

    public void setPageSizeList(List<PageSize.PageSizeItem> pageSizeList) {
        this.pageSizeList = pageSizeList;
    }

    public int getPageSizeSelected() {
        return pageSizeSelected;
    }

    public void setPageSizeSelected(int pageSizeSelected) {
        this.pageSizeSelected = pageSizeSelected;
    }


    public String getPMkakaun() {
        return PMkakaun;
    }

    public void setPMkakaun(String PMkakaun) {
        this.PMkakaun = PMkakaun;
    }

    public String getPMknmbil() {
        return PMknmbil;
    }

    public void setPMknmbil(String PMknmbil) {
        this.PMknmbil = PMknmbil;
    }

    
}
