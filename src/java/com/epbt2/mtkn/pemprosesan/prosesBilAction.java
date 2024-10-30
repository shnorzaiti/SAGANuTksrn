/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan;

import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.opensymphony.xwork2.ModelDriven;
import com.epbt2.util.DBHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.epbt2.util.ValueHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.Preparable;
import java.sql.SQLException;
import com.epbt2.util.Breadcrumb;

/**
 *
 * @author MohammadHafiz
 */
public class prosesBilAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());
    private Connection conn;

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;

    private String[] valAkaun = new String[2];
    private String[] valJalan = new String[2];
    private String[] valTempoh = new String[2];

    private ValueHelper valHelper = new ValueHelper();

    /* user */
    private User userModel = new User();
    /* user */

    private packageProsesBil membuatProsesBil = new packageProsesBil();

    public String save() throws Exception {
        log.debug("Inside save()");

        conn = DBHelper.getConnectionDS();
        try {

            String[] msgArgs = {};

            addActionMessage(getText("Bil Telah Berjaya Di Proses", msgArgs));

            membuatProsesBil.laksanaProsesBilAkaun(conn, getParam1(), getParam2(), getParam3(), getParam4(), getParam5(), getParam6(), userModel.getUserId());

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

            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

            valAkaun = valHelper.minMaxValue(conn, "AKAUN", "MTKN");

            param1 = valAkaun[0];
            param2 = valAkaun[1];

            valJalan = valHelper.minMaxValue(conn, "JALAN", "MTKN");

            param3 = valJalan[0];
            param4 = valJalan[1];

            valTempoh = valHelper.minMaxValue(conn, "TMPOH", "MTKN");

            param5 = valTempoh[0];
            param6 = valTempoh[1];

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public packageProsesBil getMembuatProsesBil() {
        return membuatProsesBil;
    }

    public void setMembuatProsesBil(packageProsesBil membuatProsesBil) {
        this.membuatProsesBil = membuatProsesBil;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName;
    }

    /* USER */
    public User getUserModel() {
        return userModel;
    }

    @Override
    public void setUser(User userModel) {
        this.userModel = userModel;
    }

    public User getUser(User userModel) {
        return this.userModel;
    }

    @Override
    public User getModel() {
        return this.userModel;
    }

    /* USER */
    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }

    public String getParam5() {
        return param5;
    }

    public void setParam5(String param5) {
        this.param5 = param5;
    }

    public String getParam6() {
        return param6;
    }

    public void setParam6(String param6) {
        this.param6 = param6;
    }

    public String[] getValAkaun() {
        return valAkaun;
    }

    public void setValAkaun(String[] valAkaun) {
        this.valAkaun = valAkaun;
    }

    public String[] getValJalan() {
        return valJalan;
    }

    public void setValJalan(String[] valJalan) {
        this.valJalan = valJalan;
    }

    public ValueHelper getValHelper() {
        return valHelper;
    }

    public void setValHelper(ValueHelper valHelper) {
        this.valHelper = valHelper;
    }

    public Breadcrumb getbCrumb() {
        return bCrumb;
    }

    public void setbCrumb(Breadcrumb bCrumb) {
        this.bCrumb = bCrumb;
    }

    public String[] getValTempoh() {
        return valTempoh;
    }

    public void setValTempoh(String[] valTempoh) {
        this.valTempoh = valTempoh;
    }

    
}
