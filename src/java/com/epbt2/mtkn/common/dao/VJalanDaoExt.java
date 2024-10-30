/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.common.dao;

/**
 *
 * @author GWINTECH
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VJalanDaoExt extends VJalanDao {
    
     //SQL Poskod - chai -
    public List loadPoskod(Connection conn, VJalan valueObject) throws Exception {

        String sql = "select jln_pskod, (jln_jnama||jln_knama) keter "
                + "from spbt.vjalan "
                + "order by jln_pskod";

        System.out.println(sql);
        List searchResults = loadPoskodQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }
    
    protected List loadPoskodQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                VJalan temp = createValueObject();
                
                temp.setJlnPskod(result.getString("JLN_PSKOD"));
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
