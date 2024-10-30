/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.common;

/**
 *
 * @author GWINTECH
 */
import com.epbt2.common.model.PageSize;
import com.epbt2.mtkn.common.dao.VJalan;
import com.epbt2.mtkn.common.dao.VJalanDaoExt;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LovPoskodAction extends ActionSupport{
    
    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;
    
    private VJalan PoskodPop = new VJalan();
    private VJalanDaoExt PoskodPopDaoExt = new VJalanDaoExt();
    
    private List<VJalan> PoskodPopList;
    
    private final PageSize pageSize = new PageSize();
    private List<PageSize.PageSizeItem> pageSizeList;
    private int pageSizeSelected;
    
    private String idField;
    
    public String execute() {

        try {
            
            if (pageSizeSelected == 0) {
                pageSizeSelected = 10;
            }

            
            conn = DBHelper.getConnectionDS();
            
            PoskodPopList = PoskodPopDaoExt.loadPoskod(conn, PoskodPop);

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;
    }

    public VJalan getPoskodPop() {
        return PoskodPop;
    }

    public void setPoskodPop(VJalan PoskodPop) {
        this.PoskodPop = PoskodPop;
    }

    public List<VJalan> getPoskodPopList() {
        return PoskodPopList;
    }

    public void setPoskodPopList(List<VJalan> PoskodPopList) {
        this.PoskodPopList = PoskodPopList;
    }

    

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
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
