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

import com.epbt2.mtkn.common.dao.HLjabt;
import com.epbt2.mtkn.common.dao.HLjabtDaoExt;
import com.epbt2.common.model.PageSize;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JbtnPopAction extends ActionSupport implements Preparable {
    
    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;
    
    private HLjabt JbtnPop = new HLjabt();
    private HLjabtDaoExt JbtnPopDaoExt = new HLjabtDaoExt();
    
    private List <HLjabt> JbtnPopList;
    
    private String carian;
    private String fieldCarian;
    
    private final PageSize pageSize = new PageSize();
    private List<PageSize.PageSizeItem> pageSizeList;
    private int pageSizeSelected;
    
    public String execute() {

        try {

            conn = DBHelper.getConnectionDS();

            //untuk rekod
            if (pageSizeSelected == 0) {
                pageSizeSelected = 10;
            }

            if (getCarian() == null) {
                JbtnPopList = JbtnPopDaoExt.loadKodJbtn(conn, JbtnPop);
            } else {
                //untuk carian
                //PgwiPop.setPegKdpeg(getCarian());
                //PgwiPop.setPegPnama(getCarian());
                JbtnPop.setFieldCarian(fieldCarian);
                JbtnPop.setCarian(carian);
                JbtnPopList = JbtnPopDaoExt.carianKodJbtn(conn, JbtnPop);

            }

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

    public HLjabt getJbtnPop() {
        return JbtnPop;
    }

    public void setJbtnPop(HLjabt JbtnPop) {
        this.JbtnPop = JbtnPop;
    }

    public HLjabtDaoExt getJbtnPopDaoExt() {
        return JbtnPopDaoExt;
    }

    public void setJbtnPopDaoExt(HLjabtDaoExt JbtnPopDaoExt) {
        this.JbtnPopDaoExt = JbtnPopDaoExt;
    }

    public List<HLjabt> getJbtnPopList() {
        return JbtnPopList;
    }

    public void setJbtnPopList(List<HLjabt> JbtnPopList) {
        this.JbtnPopList = JbtnPopList;
    }

    public String getCarian() {
        return carian;
    }

    public void setCarian(String carian) {
        this.carian = carian;
    }

    public String getFieldCarian() {
        return fieldCarian;
    }

    public void setFieldCarian(String fieldCarian) {
        this.fieldCarian = fieldCarian;
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
    
}
