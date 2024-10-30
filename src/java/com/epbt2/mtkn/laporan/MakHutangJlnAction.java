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
import com.epbt2.util.DBHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import com.epbt2.util.ValueHelper;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.Preparable;
import java.sql.SQLException;
import com.epbt2.util.Breadcrumb;
import com.opensymphony.xwork2.ModelDriven;

public class MakHutangJlnAction extends ActionSupport implements Preparable, UserAware, ModelDriven<User> {

    private final Log log = LogFactory.getLog(this.getClass());

    private Connection conn;
    private User userModel = new User();

    private Breadcrumb bCrumb = new Breadcrumb();
    private String bcName;

    private String param1;
    private String param2;
    private String reportName;
    private String stsCetak;
    private String cetakLink;

    private ValueHelper valHelper = new ValueHelper();
    private String[] valJalan = new String[2];
    
    private String reportSize;

    public String execute() {
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        conn = DBHelper.getConnectionDS();

        try {
            reportSize = "2";
            setReportName("htts27");
            valJalan = valHelper.minMaxValue(conn, " JALAN ", "MTKN");

            param1 = valJalan[0];
            param2 = valJalan[1];

            bcName = bCrumb.name(conn, "MTKN", ActionContext.getContext().getName());

        } catch (SQLException e) {
            addActionError("Error : " + e);
            log.error(e, e.fillInStackTrace());
        } finally {
            DBHelper.closeConnection(conn);
        }
    }

    public String cetak() {
        setStsCetak("Y");

            if (reportSize.equals("2")) {
                if (!reportName.contains("_a4") == true) {
                    setReportName(reportName + "_a4");
                }
            } else {
                if (reportName.contains("_") == true) {
                    setReportName(reportName.substring(0, reportName.lastIndexOf("_")));
                }
            }
            
        ActionContext sc = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) sc.get(ServletActionContext.HTTP_REQUEST);
        setCetakLink(req.getContextPath() + "/report/cetak?reportName="+ reportName+ "&param1=" + param1 + "&param2=" + param2+ "&onama=" + userModel.getUserId());
        return SUCCESS;
    }

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

    public ValueHelper getValHelper() {
        return valHelper;
    }

    public void setValHelper(ValueHelper valHelper) {
        this.valHelper = valHelper;
    }

    public String[] getValJalan() {
        return valJalan;
    }

    public void setValJalan(String[] valJalan) {
        this.valJalan = valJalan;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName;
    }

    public String getReportSize() {
        return reportSize;
    }

    public void setReportSize(String reportSize) {
        this.reportSize = reportSize;
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
