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
 * @author NurMuhammadAfzal
 */
public class HVptrxDaoExt extends HVptrxDao {

    public List loadTerimaBulan(Connection conn, String tahun) throws SQLException {

        String sql = "SELECT TAHUN, DECODE (STBIL,'B','BIL','J','JURNAL', 'R','RESIT','T','TUNGGAKAN') STBIL, "
                + "TO_CHAR(AMJAN, 'fm99,999,990.90') AMJAN, KDRJK, "
                + "TO_CHAR(AMFEB, 'fm99,999,990.90') AMFEB, TO_CHAR(AMMAR, 'fm99,999,990.90') AMMAR, "
                + "TO_CHAR(AMMAY, 'fm99,999,990.90') AMMAY, TO_CHAR(AMAPR, 'fm99,999,990.90') AMAPR, "
                + "TO_CHAR(AMJUN, 'fm99,999,990.90') AMJUN, TO_CHAR(AMJUL, 'fm99,999,990.90') AMJUL, "
                + "TO_CHAR(AMSEP, 'fm99,999,990.90') AMSEP, TO_CHAR(AMAUG, 'fm99,999,990.90') AMAUG, "
                + "TO_CHAR(AMOCT, 'fm99,999,990.90') AMOCT, TO_CHAR(AMNOV, 'fm99,999,990.90') AMNOV, "
                + "TO_CHAR(AMDEC, 'fm99,999,990.90') AMDEC, TO_CHAR(AMJUM, 'fm99,999,990.90') AMJUM "
                + "FROM MTKN.HVptrx "
                + "WHERE TAHUN = '"+tahun+"' "
                + "ORDER BY STBIL, KDRJK ASC";
       
       List searchResults = listTerimaanQuery(conn, conn.prepareStatement(sql));
        
        return searchResults;
    }

    protected List listTerimaanQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HVptrx temp = createValueObject();

                temp.setTAhun(result.getString("TAHUN"));
                temp.setSTbil(result.getString("STBIL"));
                temp.setKDrjk(result.getString("KDRJK"));
                temp.setAMjan(result.getString("AMJAN"));
                temp.setAMfeb(result.getString("AMFEB"));
                temp.setAMmar(result.getString("AMMAR"));
                temp.setAMapr(result.getString("AMAPR"));
                temp.setAMmay(result.getString("AMMAY"));
                temp.setAMjun(result.getString("AMJUN"));
                temp.setAMjul(result.getString("AMJUL"));
                temp.setAMaug(result.getString("AMAUG"));
                temp.setAMsep(result.getString("AMSEP"));
                temp.setAMoct(result.getString("AMOCT"));
                temp.setAMnov(result.getString("AMNOV"));
                temp.setAMdec(result.getString("AMDEC"));
                temp.setAMjum(result.getString("AMJUM"));

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
     public List listTahun(Connection conn) throws SQLException {

        String sql = "Select distinct (TAHUN) AS TAHUN "                 
                    + "FROM MTKN.HVptrx "
                    + "order by TAHUN desc";
       
       List searchResults = listTahunQuery(conn, conn.prepareStatement(sql));
        
        return searchResults;
    }
     protected List listTahunQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HVptrx temp = createValueObject();

                temp.setTAhun(result.getString("TAHUN"));                

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
     
     public String jmlhTerimaan(Connection conn, String tahun) throws SQLException {

          String sql = "SELECT TO_CHAR(sum(AMJUM), 'fm99,999,990.90') AMJUM "
                + "FROM MTKN.HVptrx "
                + "WHERE TAHUN = '"+tahun+"' ";
          
          PreparedStatement stmt = null;
          ResultSet result = null;
          String data = "";

          try {
              stmt = conn.prepareStatement(sql);
              result = stmt.executeQuery();

              if (result.next())
                  data = result.getString(1);
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
          return data;
    }
}
