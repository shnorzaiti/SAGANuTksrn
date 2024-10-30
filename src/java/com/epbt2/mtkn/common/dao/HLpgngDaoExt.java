/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.common.dao;

import com.epbt2.util.NotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohammad Hafiz Tarmizi
 */
public class HLpgngDaoExt extends HLpgngDao {

    public List loadAkaun(Connection conn) throws SQLException {

        String sql = "select lpad(peg_akaun,9,'0') akaun, lpad(peg_digit,2,'0') digit, pmk_nmbil pnama from mtkn.hlpgng, mtkn.hlpmlk "
                + "where peg_akaun = pmk_akaun order by peg_akaun";
        List searchResults = listAkaunQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    protected List listAkaunQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLpgng temp = createValueObject();

                temp.setPEgakaun(result.getString("AKAUN"));
                temp.setPEgdigit(result.getString("DIGIT"));

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

    public void akaunStatus(Connection conn, HLpgng valueObject)
            throws NotFoundException, SQLException {

        String sql = "UPDATE MTKN.HLPGNG SET PEG_STATF = ? WHERE (PEG_AKAUN = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, valueObject.getPEgstatf());

            stmt.setString(2, valueObject.getPEgakaun());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                //System.out.println("Object could not be saved! (PrimaryKey not found)");
                throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public List maklBilCBK(Connection conn, String PEgjpkod) throws NotFoundException, SQLException {

        HLpgng valueObject = createValueObject();

        String sql = "SELECT PEG_AKAUN, "
                + "round((nvl(peg_nilth,0)*nvl(kaw_kadar,0)/100*pmk_prtus/100),2) tksir "
                + "FROM mtkn.hlpgng, mtkn.hlpmlk, mtkn.hkawkd, spbt.fjalan "
                + "WHERE peg_akaun = pmk_akaun and "
                + "peg_jpkod = '" + PEgjpkod + "' and "
                + "pmk_kdexp = 'T' and "
                + "peg_statf = 'Y' and "
                + "peg_jlkod = jln_jlkod and "
                + "jln_kwkod = kaw_kwkod and "
                + "peg_htkod = kaw_htkod and "
                + "round((nvl(peg_nilth,0)*nvl(kaw_kadar,0)/100*pmk_prtus/100),2) >= 2.5 "
                + "order by peg_akaun ";

        List searchResults = maklBilCBKQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    protected List maklBilCBKQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLpgng temp = createValueObject();

                temp.setPEgakaun(result.getString("PEG_AKAUN"));
                temp.setTksir(result.getString("tksir"));

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

    public void intialStghThnStatus(Connection conn, HLpgng valueObject)
            throws NotFoundException, SQLException {

        String sql = "UPDATE MTKN.HLPGNG SET PEG_STATF = ? "
                + "WHERE (peg_statf not in ('Y','H') AND peg_jpkod = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, valueObject.getPEgstatf());

            stmt.setString(2, valueObject.getPEgjpkod());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                //System.out.println("Object could not be saved! (PrimaryKey not found)");
                throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    //SQL Popup Akaun - chai -
    public List loadKodAkaun(Connection conn, HLpgng valueObject) throws Exception {

        String sql = "select lpad(peg_akaun,9,'0') akaun, lpad(peg_digit,2,'0') digit, pmk_nmbil nmbil "
                + "from mtkn.hlpgng, mtkn.hlpmlk "
                + "where peg_akaun = pmk_akaun "
                + "and rownum <= '200' "
                + "order by peg_akaun";

        System.out.println(sql);
        List searchResults = listKodAkaunQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }
    
    protected List listKodAkaunQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLpgng temp = createValueObject();

                temp.setAkaun(result.getString("AKAUN"));
                temp.setDigit(result.getString("DIGIT"));
                temp.setNmbil(result.getString("NMBIL"));

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
    
    public List carianKodAkaun(Connection conn, HLpgng valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("select peg_akaun, peg_digit"
                + " from mtkn.hlpgng where 1=1 "
                + "and rownum <= '200'");

        if (valueObject.getPEgakaun()!= null) {

            if (first) {

                first = false;

            }
            sql.append(" AND peg_akaun LIKE '").append(valueObject.getPEgakaun()).append("' ");
        }

        if (valueObject.getPEgdigit()!= null) {

            if (first) {

                first = false;
            }
            sql.append("OR peg_digit LIKE '").append(valueObject.getPEgdigit()).append("' ");
        }

        sql.append("ORDER BY peg_akaun ASC ");
        System.out.println(sql);
        if (first) {
            searchResults = new ArrayList();
        } else {
            searchResults = listCariKodAkaunQuery(conn, conn.prepareStatement(sql.toString()));
        }

        return searchResults;
    }
    
    protected List listCariKodAkaunQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLpgng temp = createValueObject();

                temp.setPEgakaun(result.getString("PEG_AKAUN"));
                temp.setPEgdigit(result.getString("PEG_DIGIT"));
                temp.setPmkNmbil(result.getString("PMK_NMBIL"));

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
    
    public List carianAkaun(Connection conn, HLpgng valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT lpad(pmk_akaun,9,'0') pmk_akaun, pmk_nmbil "
                + "FROM mtkn.hlpmlk "
                + "WHERE 1=1 ");

        if (valueObject.getPMkakaun()!= null) {
            if (first) {
                first = false;
            }
            sql.append("AND PMK_AKAUN LIKE '%").append(valueObject.getPMkakaun()).append("%' ");
        }

        if (valueObject.getPMknmbil()!= null) {
            if (first) {
                first = false;
            }
            sql.append("AND PMK_NMBIL LIKE '%").append(valueObject.getPMknmbil()).append("%' ");
        }

        sql.append("ORDER BY PMK_AKAUN ASC ");
        System.out.println(sql);
        // Prevent accidential full table results.
        // Use loadAll if all rows must be returned.
        if (first) {
            searchResults = new ArrayList();
        } else {
            searchResults = listCarianAkaunQuery(conn, conn.prepareStatement(sql.toString()));
        }

        return searchResults;
    }
    
    protected List listCarianAkaunQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLpgng temp = createValueObject();

                temp.setPMkakaun(result.getString("PMK_AKAUN"));
                temp.setPMknmbil(result.getString("PMK_NMBIL"));

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
