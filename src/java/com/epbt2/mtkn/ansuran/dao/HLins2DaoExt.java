/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.ansuran.dao;

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
public class HLins2DaoExt extends HLins2Dao {

    public List loadHLins2(Connection conn, String noAkaun) throws SQLException {

        String sql = "SELECT IN2_AKAUN, TO_CHAR(IN2_TRIKH,'DD/MM/YYYY')IN2_TRIKH, "
                + "TO_CHAR(IN2_CTSMS,'fm9,999,990.90') IN2_CTSMS, TO_CHAR(IN2_CTTGK,'fm9,999,990.90') IN2_CTTGK, "
                + "TO_CHAR(IN2_DNSMS,'fm9,999,990.90') IN2_DNSMS, TO_CHAR(IN2_DNTGK,'fm9,999,990.90') IN2_DNTGK, "
                + "TO_CHAR(IN2_NTSMS,'fm9,999,990.90') IN2_NTSMS, TO_CHAR(IN2_NTTGK,'fm9,999,990.90') IN2_NTTGK, "
                + "TO_CHAR(IN2_WRSMS,'fm9,999,990.90') IN2_WRSMS, TO_CHAR(IN2_WRTGK,'fm9,999,990.90') IN2_WRTGK, "
                + "TO_CHAR(IN2_LNSMS,'fm9,999,990.90') IN2_LNSMS, TO_CHAR(IN2_LNTGK,'fm9,999,990.90') IN2_LNTGK, "
                + "ROWID, "
                + "TO_CHAR((nvl(IN2_CTSMS,0)+nvl(IN2_CTTGK,0)+nvl(IN2_DNSMS,0)+nvl(IN2_DNTGK,0)+nvl(IN2_NTSMS,0)+nvl(IN2_NTTGK,0)+nvl(IN2_WRSMS,0)+nvl(IN2_WRTGK,0)+nvl(IN2_LNSMS,0)+nvl(IN2_LNTGK,0)),'fm9,999,990.90') JUMLAH "
                + "FROM MTKN.HLins2 "
                + "WHERE IN2_AKAUN = '" + noAkaun + "' ";
                //+ "ORDER BY IN2_TRIKH  ";
        List searchResults = listHLins2Query(conn, conn.prepareStatement(sql));
        return searchResults;
    }

    protected List listHLins2Query(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLins2 temp = createValueObject();

                temp.setIn2Akaun(result.getString("IN2_AKAUN"));
                temp.setIn2Trikh(result.getString("IN2_TRIKH"));
                temp.setIn2Ctsms(result.getString("IN2_CTSMS"));
                temp.setIn2Cttgk(result.getString("IN2_CTTGK"));
                temp.setIn2Dnsms(result.getString("IN2_DNSMS"));
                temp.setIn2Dntgk(result.getString("IN2_DNTGK"));
                temp.setIn2Ntsms(result.getString("IN2_NTSMS"));
                temp.setIn2Nttgk(result.getString("IN2_NTTGK"));
                temp.setIn2Wrsms(result.getString("IN2_WRSMS"));
                temp.setIn2Wrtgk(result.getString("IN2_WRTGK"));
                temp.setIn2Lnsms(result.getString("IN2_LNSMS"));
                temp.setIn2Lntgk(result.getString("IN2_LNTGK"));
                temp.setRowID(result.getString("ROWID"));
                temp.setJumlah(result.getString("JUMLAH"));

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

    public HLins2 jmlhBesarAnsuran(Connection conn, String noAkaun) throws NotFoundException, SQLException {

        HLins2 valueObject = createValueObject();        

        String sql = "SELECT TO_CHAR(SUM(IN2_CTSMS),'fm9,999,990.90') IN2_CTSMS, TO_CHAR(SUM(IN2_CTTGK),'fm9,999,990.90') IN2_CTTGK, "
                + "TO_CHAR(SUM(IN2_DNSMS),'fm9,999,990.90') IN2_DNSMS, TO_CHAR(SUM(IN2_DNTGK),'fm9,999,990.90') IN2_DNTGK, "
                + "TO_CHAR(SUM(IN2_NTSMS),'fm9,999,990.90') IN2_NTSMS, TO_CHAR(SUM(IN2_NTTGK),'fm9,999,990.90') IN2_NTTGK, "
                + "TO_CHAR(SUM(IN2_WRSMS),'fm9,999,990.90') IN2_WRSMS, TO_CHAR(SUM(IN2_WRTGK),'fm9,999,990.90') IN2_WRTGK, "
                + "TO_CHAR(SUM(IN2_LNSMS),'fm9,999,990.90') IN2_LNSMS, TO_CHAR(SUM(IN2_LNTGK),'fm9,999,990.90') IN2_LNTGK, "
                + "TO_CHAR((nvl(SUM(IN2_CTSMS),0)+nvl(SUM(IN2_CTTGK),0)+nvl(SUM(IN2_DNSMS),0)+nvl(SUM(IN2_DNTGK),0)+nvl(SUM(IN2_NTSMS),0)+nvl(SUM(IN2_NTTGK),0)+nvl(SUM(IN2_WRSMS),0)+nvl(SUM(IN2_WRTGK),0)+nvl(SUM(IN2_LNSMS),0)+nvl(SUM(IN2_LNTGK),0)),'fm9,999,990.90') JUMLAH "
                + "FROM MTKN.HLins2 "
                + "WHERE IN2_AKAUN = '" + noAkaun + "' ";
        
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            jmlhBesarQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return valueObject;
    }

    protected void jmlhBesarQuery(Connection conn, PreparedStatement stmt, HLins2 valueObject)
            throws NotFoundException, SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {
                
                valueObject.setIn2Ctsms(result.getString("IN2_CTSMS"));
                valueObject.setIn2Cttgk(result.getString("IN2_CTTGK"));
                valueObject.setIn2Dnsms(result.getString("IN2_DNSMS"));
                valueObject.setIn2Dntgk(result.getString("IN2_DNTGK"));
                valueObject.setIn2Ntsms(result.getString("IN2_NTSMS"));
                valueObject.setIn2Nttgk(result.getString("IN2_NTTGK"));
                valueObject.setIn2Wrsms(result.getString("IN2_WRSMS"));
                valueObject.setIn2Wrtgk(result.getString("IN2_WRTGK"));
                valueObject.setIn2Lnsms(result.getString("IN2_LNSMS"));
                valueObject.setIn2Lntgk(result.getString("IN2_LNTGK"));
                valueObject.setJumlah(result.getString("JUMLAH"));

            } else {
                //System.out.println("HVnduk4 Object Not Found!");
                throw new NotFoundException("HLins2 Object Not Found!");
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

    public List listAnsuran(Connection conn) throws SQLException {

        String sql = "SELECT IN2_AKAUN, PVD_PNAMA, TO_CHAR(minTmpoh,'dd/mm/yyyy') || ' - ' || TO_CHAR(maxTmpoh,'dd/mm/yyyy') IN2_TMPOH, "
                + "count(*) bil, TO_CHAR(SUM(nvl(IN2_CTSMS,0)+nvl(IN2_CTTGK,0)+nvl(IN2_DNSMS,0)+nvl(IN2_DNTGK,0)+nvl(IN2_NTSMS,0)+nvl(IN2_NTTGK,0)+nvl(IN2_WRSMS,0)+nvl(IN2_WRTGK,0)+nvl(IN2_LNSMS,0)+nvl(IN2_LNTGK,0)),'fm9,999,990.90')  JUMLAH                FROM MTKN.HLins2, (SELECT min(IN2_TRIKH) minTmpoh,IN2_AKAUN minAkaun FROM MTKN.HLins2 GROUP BY IN2_AKAUN) min, (SELECT max(IN2_TRIKH) maxTmpoh,IN2_AKAUN maxAkaun FROM MTKN.HLins2 GROUP BY IN2_AKAUN) max, MTKN.HVNDUK4 "
                + "WHERE IN2_AKAUN = minAkaun AND IN2_AKAUN = maxAkaun AND IN2_AKAUN = PEG_AKAUN "
                + "GROUP BY IN2_AKAUN, minTmpoh, maxTmpoh, PVD_PNAMA ORDER BY CASE WHEN (minTmpoh is null AND maxTmpoh is null) THEN '2' ELSE '1' END,  maxTmpoh desc ";
        List searchResults = listAnsuranQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }
    
    public List listSearchAnsuran(Connection conn, String akaun, String nama) throws SQLException {

        String sql = "SELECT IN2_AKAUN, PVD_PNAMA, TO_CHAR(minTmpoh,'dd/mm/yyyy') || ' - ' || TO_CHAR(maxTmpoh,'dd/mm/yyyy') IN2_TMPOH, "
                + "count(*) bil, TO_CHAR(SUM(nvl(IN2_CTSMS,0)+nvl(IN2_CTTGK,0)+nvl(IN2_DNSMS,0)+nvl(IN2_DNTGK,0)+nvl(IN2_NTSMS,0)+nvl(IN2_NTTGK,0)+nvl(IN2_WRSMS,0)+nvl(IN2_WRTGK,0)+nvl(IN2_LNSMS,0)+nvl(IN2_LNTGK,0)),'fm9,999,990.90')  JUMLAH                FROM MTKN.HLins2, (SELECT min(IN2_TRIKH) minTmpoh,IN2_AKAUN minAkaun FROM MTKN.HLins2 GROUP BY IN2_AKAUN) min, (SELECT max(IN2_TRIKH) maxTmpoh,IN2_AKAUN maxAkaun FROM MTKN.HLins2 GROUP BY IN2_AKAUN) max, MTKN.HVNDUK4 "
                + "WHERE IN2_AKAUN = minAkaun AND IN2_AKAUN = maxAkaun AND IN2_AKAUN = PEG_AKAUN ";
        
        if (!akaun.equals("") || !nama.equals("")) {
            sql = sql + "AND (";
            
             if (!akaun.equals("")) {
                 sql = sql + "IN2_AKAUN like '"+akaun+"' ";
             }
             
             if (!nama.equals("")) {
                 if (!akaun.equals("")) {
                     sql = sql + "OR ";
                 }
                 sql = sql + "PVD_PNAMA like '"+nama+"' ";
             }            
            sql = sql + ")";
        }
        
                sql = sql + "GROUP BY IN2_AKAUN, minTmpoh, maxTmpoh, PVD_PNAMA ORDER BY CASE WHEN (minTmpoh is null AND maxTmpoh is null) THEN '2' ELSE '1' END,  maxTmpoh desc ";
        
        List searchResults = listAnsuranQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }

    protected List listAnsuranQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLins2 temp = createValueObject();

                temp.setIn2Akaun(result.getString("IN2_AKAUN"));
                temp.setNama(result.getString("PVD_PNAMA"));
                temp.setIn2Trikh(result.getString("IN2_TMPOH"));
                temp.setBilangan(result.getInt("bil"));
                temp.setJumlah(result.getString("JUMLAH"));

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
     public int countRecord(Connection conn, String akaun) throws SQLException {
          
        String sql = "select count(*) from mtkn.HLins2 WHERE IN2_AKAUN='"+akaun+"'";
        System.out.println(sql);
        
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
