/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Baizura
 */
public class HnotisDaoExt extends HnotisDao {

    public List flatFileCta2(Connection conn) throws SQLException {

        String sql = "SELECT KETER "
                + "     from MTKN.VHTTU07_CTA2 ";

        List searchResults = flatFileQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    public List flatFileCta2Mpaj(Connection conn) throws SQLException {

        String sql = "SELECT KETER "
                + "     from MTKN.VHTTU07_CTA2_MPAJ ";

        List searchResults = flatFileQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    public List flatFileNotis(Connection conn) throws SQLException {

        String sql = "SELECT KETER "
                + "     from MTKN.VHTTU07_NOTIS ";

        List searchResults = flatFileQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    public List flatFileNotisMpaj(Connection conn) throws SQLException {

        String sql = "SELECT KETER "
                + "     from MTKN.VHTTU07_NOTIS_MPAJ ";

        List searchResults = flatFileQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    public List flatFileNotisMdkpr(Connection conn) throws SQLException {

        String sql = "SELECT KETER "
                + "     from MTKN.VHTTU07_NOTIS_MDKPR ";

        List searchResults = flatFileQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }


    protected List flatFileQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                Hnotis temp = createValueObject();

                temp.setKeter(result.getString("KETER"));

                searchResults.add(temp);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        return (List) searchResults;
    }
}
