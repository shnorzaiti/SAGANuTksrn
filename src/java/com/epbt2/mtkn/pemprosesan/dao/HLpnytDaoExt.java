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
public class HLpnytDaoExt extends HLpnytDao {

    public List loadHLpnyt(Connection conn, String noAkaun) throws SQLException {

        String sql = "select to_char(pyt_tkhbl, fm'dd/mm/yyyy')pyt_tkhbl, pyt_akaun, pyt_kdrjk,  pyt_amaun, pyt_statf "
                + "from mtkn.hlpnyt "
                + "WHERE pyt_tkhbl = '" + noAkaun + "' ";
        List searchResults = listHLpnytQuery(conn, conn.prepareStatement(sql));
        System.out.println(sql);
        return searchResults;
    }

    protected List listHLpnytQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLpnyt temp = createValueObject();

                temp.setPYtkhbl(result.getString("PYT_TKHBL"));
                temp.setPYtakaun(result.getString("PYT_AKAUN"));
                temp.setPYtkdrjk(result.getString("PYT_KDRJK"));
                temp.setPYtamaun(result.getString("PYT_AMAUN"));
                temp.setPYtstatf(result.getString("PYT_STATF"));

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

    public float cukaiTaksiran(Connection conn, String pytAkaun, String symbol) throws SQLException {

        String sql = "SELECT nvl(sum(decode(substr(pyt_kdrjk,1,1),'1',pyt_amaun,pyt_amaun*-1)),0) "
                + "FROM MTKN.HLPNYT "
                + "WHERE (PYT_AKAUN = '" + pytAkaun + "' AND SUBSTR(PYT_KDRJK,2,4) = '1010' AND "
                + "TRUNC(PYT_TKHBL) " + symbol + " (select TO_DATE('0107'||extract(year from sysdate), 'DDMMYYYY') from dual)) ";

        PreparedStatement stmt = null;
        ResultSet result = null;
        float allRows = 0;

        try {
            stmt = conn.prepareStatement(sql);

            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getFloat(1);
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

    public int kiraDendaSemasa(Connection conn, String pytAkaun) throws SQLException {

        String sql = "select nvl(count(1),0) "
                + "FROM mtkn.hlpnyt "
                + "WHERE pyt_kdrjk = '11020' AND pyt_akaun = '" + pytAkaun + "' "
                + "AND trunc(pyt_tkhbl) < (select TO_DATE('0107'||extract(year from sysdate), 'DDMMYYYY') from dual)) ";

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

    public String stsSelenggara(Connection conn, String para_id) throws SQLException {

        String sql = "SELECT PARA_VALUE "
                + "FROM MTKN.STD_SYS_PARAM "
                + "WHERE PARA_ID = '" + para_id + "' ";

        PreparedStatement stmt = null;
        ResultSet result = null;
        String allRows = "";

        try {
            stmt = conn.prepareStatement(sql);

            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getString(1);
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

    public float genap(Connection conn, double jmlah) throws SQLException {

        String sql = "SELECT spbt.epbt.get_bundar('" + jmlah + "') "
                + "FROM dual ";

        PreparedStatement stmt = null;
        ResultSet result = null;
        float allRows = 0;

        try {
            stmt = conn.prepareStatement(sql);

            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getFloat(1);
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

    public float amaunBilCBK(Connection conn, String pytAkaun) throws SQLException {

        String sql = "SELECT nvl(sum(decode(substr(pyt_kdrjk,1,2),'12',nvl(pyt_amaun,0),'22',nvl(pyt_amaun*-1,0))),0) + "
                + "nvl(sum(decode(substr(pyt_kdrjk,1,2),'11',nvl(pyt_amaun,0),'21',nvl(pyt_amaun*-1,0))),0) "
                + "FROM  mtkn.hlpnyt "
                + "WHERE pyt_akaun = '" + pytAkaun + "' ";

        PreparedStatement stmt = null;
        ResultSet result = null;
        float allRows = 0;

        try {
            stmt = conn.prepareStatement(sql);

            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getFloat(1);
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

    public int wujudAmaunBilCBK(Connection conn, String pytAkaun) throws SQLException {

        String sql = "SELECT SIGN(nvl(sum(decode(substr(pyt_kdrjk,1,2),'12',nvl(pyt_amaun,0),'22',nvl(pyt_amaun*-1,0))),0) + "
                + "nvl(sum(decode(substr(pyt_kdrjk,1,2),'11',nvl(pyt_amaun,0),'21',nvl(pyt_amaun*-1,0))),0)) "
                + "FROM  mtkn.hlpnyt "
                + "WHERE pyt_akaun = '" + pytAkaun + "' ";

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

    public List maklAmaunAkaunBilCBK(Connection conn, String pytAkaun) throws NotFoundException, SQLException {

        String sql = "select substr(pyt_kdrjk,3,3) pyt_kdrjk, "
                + "nvl(sum(decode(substr(pyt_kdrjk,1,2),'12',nvl(pyt_amaun,0),'22',nvl(pyt_amaun*-1,0))),0) amtgk, "
                + "nvl(sum(decode(substr(pyt_kdrjk,1,2),'11',nvl(pyt_amaun,0),'21',nvl(pyt_amaun*-1,0))),0) amsms "
                + "from MTKN.HLPNYT "
                + "where pyt_kdrjk <> '11090' and "
                + "pyt_akaun = '" + pytAkaun + "' "
                + "group by substr(pyt_kdrjk,3,3) "
                + "order by substr(pyt_kdrjk,3,3) desc";

        List searchResults = maklAmaunAkaunBilCBKQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    protected List maklAmaunAkaunBilCBKQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLpnyt temp = createValueObject();

                temp.setPYtkdrjk(result.getString("pyt_kdrjk"));
                temp.setAmtgk(result.getFloat("amtgk"));
                temp.setAmsms(result.getFloat("amsms"));

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

    public float jumlahAmaunBilCBK(Connection conn, String pytAkaun) throws SQLException {

        String sql = "SELECT sum(pyt_amaun) "
                + "FROM MTKN.HLPNYT "
                + "WHERE pyt_kdrjk = '11090' "
                + "and   pyt_akaun = '" + pytAkaun + "' "
                + "group by pyt_kdrjk ";

        PreparedStatement stmt = null;
        ResultSet result = null;
        float allRows = 0;

        try {
            stmt = conn.prepareStatement(sql);

            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getFloat(1);
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

    public HLpnyt jmlhTaksiranSemasaTunggakan(Connection conn, String pegJpkod) throws NotFoundException, SQLException {

        HLpnyt valueObject = createValueObject();
        String sql = "SELECT nvl(sum(decode(substr(pyt_kdrjk,1,2),'12',nvl(pyt_amaun,0),'22',nvl(pyt_amaun*-1,0))),0) tngak, "
                + "nvl(sum(decode(substr(pyt_kdrjk,1,2),'11',nvl(pyt_amaun,0),'21',nvl(pyt_amaun*-1,0))),0) smasa "
                + "FROM  mtkn.hlpnyt "
                + "WHERE substr(pyt_kdrjk,1,2) <> '11090' and "
                + "pyt_akaun in "
                + "   ( SELECT peg_akaun "
                + "       FROM mtkn.hlpgng, mtkn.hlpmlk, mtkn.hkawkd, spbt.fjalan "
                + "       WHERE peg_akaun = pmk_akaun and "
                + "           peg_jpkod = '" + pegJpkod + "' and "
                + "           pmk_kdexp = 'T' and "
                + "           peg_statf = 'Y' and "
                + "           peg_jlkod = jln_jlkod and "
                + "           jln_kwkod = kaw_kwkod and "
                + "           peg_htkod = kaw_htkod and "
                + "           round((nvl(peg_nilth,0)*nvl(kaw_kadar,0)/100*pmk_prtus/100),2) >= 2.5 ) ";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            jmlhTaksiranSemasaTunggakanQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return valueObject;
    }

    protected void jmlhTaksiranSemasaTunggakanQuery(Connection conn, PreparedStatement stmt, HLpnyt valueObject)
            throws NotFoundException, SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                valueObject.setTngak(result.getFloat("tngak"));
                valueObject.setSmasa(result.getFloat("smasa"));

            } else {
                //System.out.println("HLpnyt Object Not Found!");
                throw new NotFoundException("HLpnyt Object Not Found!");
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

    public float jumlahLebihan(Connection conn, String pegJpkod) throws SQLException {

        String sql = "SELECT sum(pyt_kdrjk) "
                + "FROM  mtkn.hlpnyt "
                + "WHERE substr(pyt_kdrjk,1,2) = '11090' and "
                + "pyt_akaun in  "
                + "   ( SELECT peg_akaun "
                + "       FROM mtkn.hlpgng, mtkn.hlpmlk, mtkn.hkawkd, spbt.fjalan "
                + "       WHERE peg_akaun = pmk_akaun and "
                + "           peg_jpkod = '" + pegJpkod + "' and "
                + "           pmk_kdexp = 'T' and "
                + "           peg_statf = 'Y' and "
                + "           peg_jlkod = jln_jlkod and "
                + "           jln_kwkod = kaw_kwkod and "
                + "           peg_htkod = kaw_htkod and "
                + "           round((nvl(peg_nilth,0)*nvl(kaw_kadar,0)/100*pmk_prtus/100),2) >= 2.5 ) ";

        PreparedStatement stmt = null;
        ResultSet result = null;
        float allRows = 0;

        try {
            stmt = conn.prepareStatement(sql);

            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getFloat(1);
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
    
    public HLpnyt Penggal(Connection conn) throws NotFoundException, SQLException {

        HLpnyt valueObject = createValueObject();

        String sql = "select spbt.epbt.get_penggal(sysdate) penggal from dual ";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            PenggalQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return valueObject;
    }

    protected void PenggalQuery(Connection conn, PreparedStatement stmt, HLpnyt valueObject)
            throws NotFoundException, SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {
                valueObject.setPenggal(result.getString("PENGGAL"));
            } else {

                //throw new NotFoundException("SInhrt Object Not Found!");
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
