/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.tanya.dao;

import com.epbt2.util.NotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hafiz
 */
public class HVhtgkDaoExt extends HVhtgkDao {

    public List listPemantauanTgkn(Connection conn, String jpkod) throws SQLException {

        String sql = "SELECT PEG_AKAUN, PEG_STATF, PMK_NMBIL, ADPG1, ADPG2, ADPG3, ADPG4, "
                + "       TO_CHAR(PEG_NILTH, 'fm9,999,990.90') PEG_NILTH,  "
                + "       TO_CHAR(KAW_KADAR, 'fm9,999,990.90') KAW_KADAR,  "
                + "       TO_CHAR(PEG_TKSIR, 'fm9,999,990.90') PEG_TKSIR,  "
                + "       TO_CHAR(JUM_TGKN, 'fm9,999,990.90') JUM_TGKN, "
                + "       HTX_TMPOH "
                + "       FROM MTKN.hvhtgk "
                + "       WHERE jpk_itkod = '11010' "
                + "       and   jpk_jpkod = '"+ jpkod +"' "
                + "       ORDER BY PEG_AKAUN";

        List searchResults = listQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }

    /*public List loadSenarai(Connection conn, String PEgakaun) throws SQLException {

     String sql = "SELECT PEG_AKAUN, PEG_STATF, PMK_NMBIL, ADPG1, ADPG2, ADPG3, ADPG4, "
     + "       TO_CHAR(PEG_NILTH, 'fm9,999,990.90') PEG_NILTH,  "
     + "       TO_CHAR(KAW_KADAR, 'fm9,999,990.90') KAW_KADAR,  "
     + "       TO_CHAR(PEG_TKSIR, 'fm9,999,990.90') PEG_TKSIR,  "
     + "       TO_CHAR(JUM_TGKN, 'fm9,999,990.90') JUM_TGKN, "
     + "       HTX_TMPOH "
     + "       FROM MTKN.hvhtgk "
     + "       WHERE PEG_AKAUN='" + PEgakaun + "' "
     + "       ORDER BY PEG_AKAUN";
        
     List searchResults = listTerimaanQuery(conn, conn.prepareStatement(sql));
     return searchResults;
     }

     protected List listTerimaanQuery(Connection conn, PreparedStatement stmt) throws SQLException {

     ArrayList searchResults = new ArrayList();
     ResultSet result = null;

     try {
     result = stmt.executeQuery();

     while (result.next()) {
     HVhtgk temp = createValueObject();

     temp.setADpg1(result.getString("ADPG1"));
     temp.setADpg2(result.getString("ADPG2"));
     temp.setADpg3(result.getString("ADPG3"));
     temp.setADpg4(result.getString("ADPG4"));
     temp.setHTxtmpoh(result.getString("HTX_TMPOH"));
     temp.setJUmtgkn(result.getString("JUM_TGKN"));
     temp.setKAwkadar(result.getString("KAW_KADAR"));
     temp.setPEgakaun(result.getString("PEG_AKAUN"));
     temp.setPEgnilth(result.getString("PEG_NILTH"));
     temp.setPEgstatf(result.getString("PEG_STATF"));
     temp.setPEgtksir(result.getString("PEG_TKSIR"));

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

     protected void singleHVhtgkQuery(Connection conn, PreparedStatement stmt, HVhtgk valueObject)
     throws NotFoundException, SQLException {

     ResultSet result = null;

     try {
     result = stmt.executeQuery();

     if (result.next()) {

     valueObject.setPEgakaun(result.getString("PEG_AKAUN"));
     valueObject.setPEgstatf(result.getString("PEG_STATF"));
     valueObject.setPMknmbil(result.getString("PMK_NMBIL"));
     valueObject.setADpg1(result.getString("ADPG1"));
     valueObject.setADpg2(result.getString("ADPG2"));
     valueObject.setADpg3(result.getString("ADPG3"));
     valueObject.setADpg4(result.getString("ADPG4"));
     valueObject.setPEgnilth(result.getString("PEG_NILTH"));
     valueObject.setKAwkadar(result.getString("KAW_KADAR"));
     valueObject.setPEgtksir(result.getString("PEG_TKSIR"));
     valueObject.setJUmtgkn(result.getString("JUM_TGKN"));
     valueObject.setHTxtmpoh(result.getString("HTX_TMPOH"));

     } else {

     throw new NotFoundException("HVhtgk Object Not Found!");
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
     public String loadSenaraiTunggakan(Connection conn, String PEgakaun) throws SQLException {

     String sql = "SELECT PEG_AKAUN, PEG_STATF, PMK_NMBIL, ADPG1, ADPG2, ADPG3, ADPG4,"
     + "       TO_CHAR(PEG_NILTH, 'fm9,999,990.90') PEG_NILTH, "
     + "       TO_CHAR(KAW_KADAR, 'fm9,999,990.90') KAW_KADAR, "
     + "       TO_CHAR(PEG_TKSIR, 'fm9,999,990.90') PEG_TKSIR, "
     + "       TO_CHAR(JUM_TGKN, 'fm9,999,990.90') JUM_TGKN,"
     + "       HTX_TMPOH "
     + "       FROM MTKN.hvhtgk "
     + "       WHERE PEG_AKAUN='" + PEgakaun + "' "
     + "       ORDER BY PEG_AKAUN";
          
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
     }*/
}
