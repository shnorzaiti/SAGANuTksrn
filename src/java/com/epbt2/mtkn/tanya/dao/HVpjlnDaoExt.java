/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya.dao;

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
public class HVpjlnDaoExt extends HVpjlnDao {

    public List statusAkaun(Connection conn, String jlkod) throws SQLException {

        String sql = "select * "
                + "from ( "
                + "select decode(t.row_count,1,'AKTIF', "
                + "                  2,'BATAL', null) status, "
                + "decode(t.row_count,1,ac.aktif, "
                + "                  2,ac.batal, null) bil "
                + "from MTKN.HVPJLN ac, "
                + "( select 1 row_count from dual "
                + "union all "
                + "select 2 row_count from dual) t "
                + "where JLKOD = '" + jlkod + "')  ";
        List searchResults = statusAkaunQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }
    
    protected List statusAkaunQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HVpjln temp = createValueObject();

                temp.setStatus(result.getString("status"));
                temp.setBil(result.getString("bil"));

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
