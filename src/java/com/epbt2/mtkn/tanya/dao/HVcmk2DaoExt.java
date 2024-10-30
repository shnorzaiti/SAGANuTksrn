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
 * @author Hafiz Edit by :25/09/2014(BYE)
 */
public class HVcmk2DaoExt extends HVcmk2Dao {

public HVcmk2 loadHutangCbk(Connection conn) throws NotFoundException, SQLException {
    //public List loadHutangCbk(Connection conn) throws SQLException {

          HVcmk2 valueObject = createValueObject();
          
        String sql = "SELECT "
                + "TO_CHAR(CMP_BKTGK, 'fm9,999,990.90') CMP_BKTGK, "
                + "TO_CHAR(CMP_BKSMS, 'fm9,999,990.90') CMP_BKSMS, "
                + "TO_CHAR(CMN_BKTGK, 'fm9,999,990.90') CMN_BKTGK, "
                + "TO_CHAR(CMN_BKSMS, 'fm9,999,990.90') CMN_BKSMS, "
                + "TO_CHAR(CMB_BKTGK, 'fm9,999,990.90') CMB_BKTGK, "
                + "TO_CHAR(CMB_BKSMS, 'fm9,999,990.90') CMB_BKSMS, "
                //ADD ON JULY 22,2014 (HAFIZ)                  
                + "TO_CHAR(CMP_LEBH2, 'fm9,999,990.90') CMP_LEBH2, "
                + "TO_CHAR(CMN_LEBH2, 'fm9,999,990.90') CMN_LEBH2, "
                + "TO_CHAR(CMB_LEBH2, 'fm9,999,990.90') CMB_LEBH2 "
                
                + "FROM MTKN.HVCMK1, MTKN.HVCMK2, MTKN.HVCMK6, MTKN.HVCMK7, MTKN.HVCMK8";

       // List searchResults = listHutangCbkQuery(conn, conn.prepareStatement(sql));
        //return searchResults;
        
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);

               listHutangCbkQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
          
          return valueObject;
    }

protected void listHutangCbkQuery(Connection conn, PreparedStatement stmt, HVcmk2 temp) 
            throws NotFoundException, SQLException {
    //protected List listHutangCbkQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        /*ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HVcmk2 temp = createValueObject();*/
         ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {
             
                temp.setCMpbktgk(result.getString("CMP_BKTGK"));
                temp.setCMpbksms(result.getString("CMP_BKSMS"));
                temp.setCMnbktgk(result.getString("CMN_BKTGK"));
                temp.setCMnbksms(result.getString("CMN_BKSMS"));
                temp.setCMbbktgk(result.getString("CMB_BKTGK"));
                temp.setCMbbksms(result.getString("CMB_BKSMS"));
                 //ADD ON JULY 22,2014 (HAFIZ)
                temp.setCMplebh2(result.getString("CMP_LEBH2"));
                temp.setCMnlebh2(result.getString("CMN_LEBH2"));
                temp.setCMblebh2(result.getString("CMB_LEBH2"));


                //searchResults.add(temp);
                
            } else {
                //System.out.println("HVcmk1 Object Not Found!");
                throw new NotFoundException("HVcmk2 Object Not Found!");
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        //return (List) searchResults;
    }

}
