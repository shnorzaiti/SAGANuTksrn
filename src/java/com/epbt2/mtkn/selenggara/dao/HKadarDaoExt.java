/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.selenggara.dao;

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
public class HKadarDaoExt extends HKadarDao {

    public List loadHKadar(Connection conn, String kdrStatf) throws SQLException {
        
        String sql = "select KDR_STATF, TO_CHAR (a.KDR_LOWER,'fm9,999,990.90') KDR_LOWER, "
                + "TO_CHAR (a.KDR_UPPER,'fm9,999,990.90') KDR_UPPER,TO_CHAR (a.KDR_AMAUN,'fm9,999,990.90') KDR_AMAUN,  "
                + "a.ROWID, TO_CHAR(a.KDR_AMINC,'fm9,999,990.90') KDR_AMINC, TO_CHAR(a.KDR_INCRE,'fm9,999,990.90') KDR_INCRE, "
                + "a.KDR_PCENT KDR_PCENT   "
                + "from mtkn.hkadar a "
                + "where KDR_STATF = '"+ kdrStatf +"' "
                + "ORDER BY KDR_STATF, a.KDR_LOWER, a.KDR_UPPER ";
        
        System.out.println(sql);
        List searchResults = listHKadarQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    public int countRecord(Connection conn, String rowID) throws SQLException {

        String sql = "select count(*) from mtkn.hkadar WHERE ROWID='" + rowID + "'";

        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;

        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getInt(1);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return allRows;
    }

    public HKadar Kadar(Connection conn, String rowID) throws NotFoundException, SQLException {

        HKadar valueObject = createValueObject();
        String sql = "select b.LOOKUP_DESC KDR_STATF,"
                + "TO_CHAR (a.KDR_LOWER,'fm9,999,990.90')KDR_LOWER,"
                + "TO_CHAR (a.KDR_UPPER,'fm9,999,990.90')KDR_UPPER,"
                + "TO_CHAR (a.KDR_AMAUN,'fm9,999,990.90')KDR_AMAUN,"
                + "a.ROWID,"
                + "a.KDR_AMINC,"
                + "a.KDR_INCRE,"
                + "a.KDR_PCENT "
                + "from mtkn.hkadar a, MTKN.STD_LOOKUP_TABLE b  "
                + "WHERE a.ROWID='" + rowID + "' AND b.LOOKUP_GROUP = 'STATF DNW' AND b.LOOKUP_CODE = a.KDR_STATF AND b.LOOKUP_STATUS = 'A' ";
        /*
         Single Friday
         */
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            singleQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return valueObject;
    }
    /*
     Single Friday
     */

    protected List listHKadarQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HKadar temp = createValueObject();

                temp.setKDrstatf(result.getString("KDR_STATF"));
                temp.setKDrlower(result.getString("KDR_LOWER"));
                temp.setKDrupper(result.getString("KDR_UPPER"));
                temp.setKDramaun(result.getString("KDR_AMAUN"));
                temp.setKDraminc(result.getString("KDR_AMINC"));
                temp.setKDrincre(result.getString("KDR_INCRE"));
                temp.setKDrpcent(result.getString("KDR_PCENT"));
                temp.setRowID(result.getString("ROWID"));
                //temp.setRowNum(result.getString("ROWNUM"));

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

    public int kadarWujud(Connection conn, String kdrStatf, float akira) throws SQLException {

        String sql = "SELECT count(*) "
                + "FROM MTKN.HKADAR "
                + "WHERE (KDR_STATF = '" + kdrStatf + "' AND "
                + "   ((" + akira + " BETWEEN KDR_LOWER AND KDR_UPPER AND NVL(KDR_AMINC,0) = 0) "
                + "   OR (" + akira + " BETWEEN KDR_LOWER AND KDR_UPPER AND NVL(KDR_AMINC,0) > 0)) "
                + ") ";

        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;

        try {
            stmt = conn.prepareStatement(sql);

            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getInt(1);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return allRows;
    }

    public HKadar kadar(Connection conn, String kdrStatf, float akira) throws NotFoundException, SQLException {

        HKadar valueObject = createValueObject();

        String sql = "SELECT NVL(KDR_LOWER,0) KDR_LOWER, KDR_UPPER, NVL(KDR_AMAUN,0) KDR_AMAUN "
                + ", NVL(KDR_AMINC,0) KDR_AMINC, NVL(KDR_INCRE,0) KDR_INCRE, NVL(KDR_PCENT,0) KDR_PCENT "
                + ", KDR_STATF "
                + "FROM MTKN.HKADAR "
                + "WHERE (KDR_STATF = '" + kdrStatf + "' AND "
                + "   ((" + akira + " BETWEEN KDR_LOWER AND KDR_UPPER AND NVL(KDR_AMINC,0) = 0) "
                + "   OR (" + akira + " BETWEEN KDR_LOWER AND KDR_UPPER AND NVL(KDR_AMINC,0) > 0)) "
                + ") ";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            singleQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return valueObject;
    }

    public HKadar kadarInfo(Connection conn, String rowID) throws NotFoundException, SQLException {

        HKadar valueObject = createValueObject();

        //String sql = "select * from MTKN.HKADAR where ROWID='"+rowID+"'";           
        String sql = "select KDR_STATF,KDR_UPPER,KDR_LOWER,KDR_AMINC,KDR_AMAUN,KDR_INCRE,KDR_PCENT, b.LOOKUP_DESC KDR_DESC, a.ROWID "
                + "from MTKN.HKADAR a INNER JOIN MTKN.STD_LOOKUP_TABLE b ON (KDR_STATF = b.LOOKUP_CODE AND b.LOOKUP_GROUP = 'STATF DNW') "
                + //"where ROWNUM='"+rowID+"'";
                "where a.ROWID='" + rowID + "'";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            singleHKadarQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return valueObject;
    }

    protected void singleHKadarQuery(Connection conn, PreparedStatement stmt, HKadar valueObject)
            throws NotFoundException, SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                valueObject.setKDrstatf(result.getString("KDR_STATF"));
                valueObject.setKDrupper(result.getString("KDR_UPPER"));
                valueObject.setKDrlower(result.getString("KDR_LOWER"));
                valueObject.setKDraminc(result.getString("KDR_AMINC"));
                valueObject.setKDramaun(result.getString("KDR_AMAUN"));
                valueObject.setKDrincre(result.getString("KDR_INCRE"));
                valueObject.setKDrpcent(result.getString("KDR_PCENT"));
                valueObject.setKDrdesc(result.getString("KDR_DESC"));
                valueObject.setRowID(result.getString("ROWID"));

            } else {
                //System.out.println("HVnduk4 Object Not Found!");
                throw new NotFoundException("HKadar Object Not Found!");
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

    public int kiraKadar(Connection conn) throws SQLException {

        String sql = "SELECT nvl(count(*),0) "
                + "FROM MTKN.HKADAR ";

        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;

        try {
            stmt = conn.prepareStatement(sql);

            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getInt(1);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return allRows;
    }
}
