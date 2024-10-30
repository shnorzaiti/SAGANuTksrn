package com.epbt2.mtkn.pemprosesan;

import com.epbt2.common.model.PageSize;
import com.epbt2.mtkn.induk.dao.HVnduk4;
import com.epbt2.mtkn.induk.dao.HVnduk4Dao;
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
 * @author NurMuhammadAfzal
 */
public class BilPulangAction extends ActionSupport{
    
    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;
       
    private HVnduk4DaoExt carianBilDaoExt = new HVnduk4DaoExt();
    private HVnduk4Dao carianBilDao = new HVnduk4Dao();
    private HVnduk4 bilPulang = new HVnduk4();
    private List<HVnduk4> bilPulangList;
    
    private final PageSize pageSize = new PageSize();
    private List<PageSize.PageSizeItem> pageSizeList;
    private int pageSizeSelected;
            
    public String execute(String PegAkaun) throws Exception{

        return SUCCESS;

    }
    
     public String search() throws Exception {
        conn = DBHelper.getConnectionDS();

   log.debug("MASUK SEARCH");
        try {
            
            if (bilPulang.getPegAkaun()!= null) {
                bilPulang = carianBilDaoExt.loadBil(conn, bilPulang.getPegAkaun());
             System.out.println("IF "+bilPulang.getPegAkaun());
            } else {
                 bilPulang = carianBilDaoExt.loadBil(conn, bilPulang.getPegAkaun());
                 System.out.println("ELSE "+bilPulang.getPegAkaun());
            }

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;

    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }



    public HVnduk4 getBilPulang() {
        return bilPulang;
    }

    public void setBilPulang(HVnduk4 bilPulang) {
        this.bilPulang = bilPulang;
    }

    public List<HVnduk4> getBilPulangList() {
        return bilPulangList;
    }

    public void setBilPulangList(List<HVnduk4> bilPulangList) {
        this.bilPulangList = bilPulangList;
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
