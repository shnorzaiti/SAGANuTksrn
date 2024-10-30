/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hafiz
 */
public class packageProsesBil {

    public void laksanaProsesBilAkaun(Connection conn, String noakn, String noakn2, String jlkod1, String jlkod2, String tkhbl, String tmpoh, String usrid) throws SQLException {

        String sql = "{ call mtkn.sp_mtkn.proses_bil('" + noakn + "','" + noakn2 + "','" + jlkod1 + "','" + jlkod2 + "','" + tkhbl + "', '" + tmpoh + "', '" + usrid + "') } ";
        PreparedStatement stmt = null;
        ResultSet result = null;
        System.out.println("CARIAN SQL CARIAN PROSES BIL AKAUN :" + sql);
        try {
            stmt = conn.prepareCall(sql);
            result = stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void bilCBK(Connection conn, String jbkod, String tkhbl, String tmpoh, String usrid) throws SQLException {

        String sql = "{ call mtkn.sp_mtkn.proses_bil_CBK('" + jbkod + "','" + tkhbl + "','" + tmpoh + "','" + usrid + "') } ";
        System.out.println(sql);
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            stmt = conn.prepareCall(sql);

            result = stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void denNotisW(Connection conn, String proses, String noakn1, String noakn2, String amaun1, String amaun2, String pilih, String jlkod, String tkhbl, String tmpoh, String usrid) throws SQLException {

        String sql = "{ call mtkn.sp_mtkn.proses_DENDA_NOTIS_WARAN('" + proses + "','" + noakn1 + "','" + noakn2 + "','" + amaun1 + "','" + amaun2 + "','" + pilih + "','" + jlkod + "','" + tkhbl + "','" + tmpoh + "','" + usrid + "') } ";
        PreparedStatement stmt = null;
        ResultSet result = null;
        System.out.println("denda notis waran :" + sql);

        try {
            stmt = conn.prepareCall(sql);

            result = stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
