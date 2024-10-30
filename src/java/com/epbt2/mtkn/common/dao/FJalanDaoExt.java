package com.epbt2.mtkn.common.dao;

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
public class FJalanDaoExt extends FJalanDao {

    //SQL Popup Jalan - chai -
    public List loadKodJalan(Connection conn, FJalan valueObject) throws Exception {

        String sql = "select lpad(jln_jlkod,5,'0') kod, jln_jnama nama, jln_poskd poskod "
                + "from spbt.fjalan "
                + "order by jln_jlkod";

        System.out.println(sql);
        List searchResults = listKodJalanQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }
    
    protected List listKodJalanQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                FJalan temp = createValueObject();

                temp.setKod(result.getString("KOD"));
                temp.setNama(result.getString("NAMA"));
                temp.setPoskod(result.getString("POSKOD"));

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
    
    public List carianKodJalan(Connection conn, FJalan valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("select jln_jnama, jln_poskd"
                + " from spbt.fjalan where 1=1");

        if (valueObject.getJlnJnama()!= null) {

            if (first) {

                first = false;

            }
            sql.append(" AND jln_jnama LIKE '").append(valueObject.getJlnJnama()).append("' ");
        }

        if (valueObject.getJlnPoskd()!= null) {

            if (first) {

                first = false;
            }
            sql.append("OR jln_poskd LIKE '").append(valueObject.getJlnPoskd()).append("' ");
        }

        sql.append("ORDER BY jln_jnama ASC ");
        System.out.println(sql);
        if (first) {
            searchResults = new ArrayList();
        } else {
            searchResults = listCariKodJalanQuery(conn, conn.prepareStatement(sql.toString()));
        }

        return searchResults;
    }
    
    protected List listCariKodJalanQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                FJalan temp = createValueObject();

                temp.setJlnJnama(result.getString("JLN_JNAMA"));
                temp.setJlnPoskd(result.getString("JLN_POSKD"));

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
