/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.common;

import com.epbt2.spbt.ref.dao.TRxkod;
import com.epbt2.spbt.ref.dao.TRxkodDaoExt;
import com.epbt2.common.model.PageSize;
import com.epbt2.util.DBHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author shahr
 */
public class TransTaksiranAction extends ActionSupport {

    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;

    private TRxkod transaksi = new TRxkod();
    private TRxkodDaoExt transaksiDaoExt = new TRxkodDaoExt();

    private List<TRxkod> transaksiList;
    private String idField;
    
     public String execute() {

        try {

            conn = DBHelper.getConnectionDS();

            //untuk rekod
            /*if (pageSizeSelected == 0) {
                pageSizeSelected = 10;
            }

            if (getCarian() == null) {*/
                transaksiList = transaksiDaoExt.listTransTaksiran(conn);
            /*} else {
                //untuk carian
                //PgwiPop.setPegKdpeg(getCarian());
                //PgwiPop.setPegPnama(getCarian());
                transaksi.setFieldCarian(fieldCarian);
                transaksi.setCarian(carian);
                transaksiList = transaksiDaoExt.carianTransaksiCagaran(conn, transaksi);

            }*/

        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

        return SUCCESS;
    }

    public TRxkod getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(TRxkod transaksi) {
        this.transaksi = transaksi;
    }

    public TRxkodDaoExt getTransaksiDaoExt() {
        return transaksiDaoExt;
    }

    public void setTransaksiDaoExt(TRxkodDaoExt transaksiDaoExt) {
        this.transaksiDaoExt = transaksiDaoExt;
    }

    public List<TRxkod> getTransaksiList() {
        return transaksiList;
    }

    public void setTransaksiList(List<TRxkod> transaksiList) {
        this.transaksiList = transaksiList;
    }

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }
     
     

}
