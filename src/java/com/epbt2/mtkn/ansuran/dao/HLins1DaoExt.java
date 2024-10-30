/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epbt2.mtkn.ansuran.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author otasoft01
 */
public class HLins1DaoExt extends HLins1Dao {
    public int rekodWujud (Connection conn, String akaun) throws SQLException {

        String sql = "select count(*) "
                + "from mtkn.hlins1 "
                + "where IN1_AKAUN='" + akaun + "'";
        
        PreparedStatement stmt = null;
        ResultSet result = null;
        int data = 0;
        
        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next()) {
                data = result.getInt(1);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return data;
    }
}
