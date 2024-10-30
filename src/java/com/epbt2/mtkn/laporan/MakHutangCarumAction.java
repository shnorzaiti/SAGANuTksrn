/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.laporan;

/**
 *
 * @author ainyrusly
 */
import com.epbt2.common.model.User;
import com.epbt2.interceptors.UserAware;
import com.epbt2.mtkn.ref.dao.HLjabt;
import com.epbt2.mtkn.ref.dao.HLjabtDaoExt;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.Preparable;
import com.epbt2.util.Breadcrumb;
import com.epbt2.util.DBHelper;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.SQLException;

public class MakHutangCarumAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;
    private User userModel = new User();

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private String param1;
    private String reportName;
    private String stsCetak;
    private String cetakLink;

    private HLjabtDaoExt jabtDaoExt = new HLjabtDaoExt();
    private HLjabt jabt = new HLjabt();

    public String execute() {
        retrieveData();
        return SUCCESS;
    }

    public void retrieveData() {

        try {
            conn = DBHelper.getConnectionDS();

            if (param1 != null) {

                jabt = jabtDaoExt.maklJabt(conn, param1);
            }
        } catch (Exception e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());

        } finally {
            DBHelper.closeConnection(conn);
        }

    }

    public String cetak() {
        setStsCetak("Y");
        
        retrieveData();

        ActionContext sc = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) sc.get(ServletActionContext.HTTP_REQUEST);
        setCetakLink(req.getContextPath() + "/report/cetak?reportName=htts28&param1=" + param1 + "&onama=" + userModel.getUserId());
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {

            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }

    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getStsCetak() {
        return stsCetak;
    }

    public void setStsCetak(String stsCetak) {
        this.stsCetak = stsCetak;
    }

    public String getCetakLink() {
        return cetakLink;
    }

    public void setCetakLink(String cetakLink) {
        this.cetakLink = cetakLink;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName;
    }

    public HLjabt getJabt() {
        return jabt;
    }

    public void setJabt(HLjabt jabt) {
        this.jabt = jabt;
    }

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
}
