/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan.dao;

import com.epbt2.util.NotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NurMuhammadAfzal
 */
public class HLkbc1DaoExt extends HLkbc1Dao {
    
     public int rekodWujud (Connection conn, String BC1akaun) throws SQLException {

        String sql = "select count(*) "
                + "from mtkn.HLKBC1 "
                + "where BC1_AKAUN='" + BC1akaun + "'";
        
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

     public HLkbc1 loadHLkbc1(Connection conn, String BC1akaun) throws NotFoundException, SQLException {
        HLkbc1 valueObject = createValueObject();

        String sql = "select BC1_AKAUN,BC1_NOBIL,BC1_TKHBL,BC1_TMPOH,BC1_STATF "
                + "from mtkn.HLKBC1 "
                + "where BC1_AKAUN='" + BC1akaun + "'";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            singleHLkbc1Query(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return valueObject;
    }

    protected void singleHLkbc1Query(Connection conn, PreparedStatement stmt, HLkbc1 valueObject)
            throws NotFoundException, SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                valueObject.setBC1akaun(result.getString("BC1_AKAUN"));
                valueObject.setBC1nobil(result.getString("BC1_NOBIL"));
                valueObject.setBC1tkhbl(result.getString("BC1_TKHBL"));
                valueObject.setBC1tmpoh(result.getString("BC1_TMPOH"));
                valueObject.setBC1statf(result.getString("BC1_STATF"));
                
            } else {
                //System.out.println("HVnduk4 Object Not Found!");
                throw new NotFoundException("HVnduk4 Object Not Found!");
            }
        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

}

}