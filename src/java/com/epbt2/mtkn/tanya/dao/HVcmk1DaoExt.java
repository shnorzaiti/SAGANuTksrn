/*
 Document   : HutangTerimaanCbk
 Created on : May 6, 2014, 9:34:29 AM
 Author     : Mohammad Hafiz Tarmizi
 */

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
public class HVcmk1DaoExt extends HVcmk1Dao {

    /*hafiz
     2 MAY 2014, FRIDAY
     */
    public HVcmk1 loadTerimaanCbk(Connection conn) throws NotFoundException, SQLException {
        //public List loadTerimaanCbk(Connection conn) throws SQLException {

        HVcmk1 valueObject = createValueObject();

        String sql = "SELECT "
                + "TO_CHAR(CMP_AMTGK, 'fm9,999,990.90') CMP_AMTGK,"
                + "TO_CHAR(CMP_AMSMS, 'fm9,999,990.90') CMP_AMSMS,"
                + "TO_CHAR(CMP_BYTGK, 'fm9,999,990.90') CMP_BYTGK,"
                + "TO_CHAR(CMP_BYSMS, 'fm9,999,990.90') CMP_BYSMS,"
                + "TO_CHAR(CMN_AMTGK, 'fm9,999,990.90') CMN_AMTGK,"
                + "TO_CHAR(CMN_AMSMS, 'fm9,999,990.90') CMN_AMSMS,"
                + "TO_CHAR(CMN_BYTGK, 'fm9,999,990.90') CMN_BYTGK,"
                + "TO_CHAR(CMN_BYSMS, 'fm9,999,990.90') CMN_BYSMS,"
                + "TO_CHAR(CMB_AMTGK, 'fm9,999,990.90') CMB_AMTGK,"
                + "TO_CHAR(CMB_AMSMS, 'fm9,999,990.90') CMB_AMSMS,"
                + "TO_CHAR(CMB_BYTGK, 'fm9,999,990.90') CMB_BYTGK,"
                + "TO_CHAR(CMB_BYSMS, 'fm9,999,990.90') CMB_BYSMS, "
                + "TO_CHAR(CMP_LEBH1, 'fm9,999,990.90') CMP_LEBH1, "
                + "TO_CHAR(CMN_LEBH1, 'fm9,999,990.90') CMN_LEBH1, "
                + "TO_CHAR(CMB_LEBH1, 'fm9,999,990.90') CMB_LEBH1 "
                + "FROM MTKN.HVCMK1, MTKN.HVCMK2, MTKN.HVCMK3, MTKN.HVCMK4, MTKN.HVCMK5";
                //List searchResults = listTerimaanCbkQuery(conn, conn.prepareStatement(sql));
        //return searchResults;

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            listTerimaanCbkQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return valueObject;
    }

    protected void listTerimaanCbkQuery(Connection conn, PreparedStatement stmt, HVcmk1 temp)
            throws NotFoundException, SQLException {
    //protected List listTerimaanCbkQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        /* ArrayList searchResults = new ArrayList();
         ResultSet result = null;

         try {
         result = stmt.executeQuery();

         while (result.next()) {
         HVcmk1 temp = createValueObject();*/
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {
                temp.setCMpamtgk(result.getString("CMP_AMTGK"));
                temp.setCMpamsms(result.getString("CMP_AMSMS"));
                temp.setCMpbytgk(result.getString("CMP_BYTGK"));
                temp.setCMpbysms(result.getString("CMP_BYSMS"));

                temp.setCMnamtgk(result.getString("CMN_AMTGK"));
                temp.setCMnamsms(result.getString("CMN_AMSMS"));
                temp.setCMnbytgk(result.getString("CMN_BYTGK"));
                temp.setCMnbysms(result.getString("CMN_BYSMS"));

                temp.setCMbamtgk(result.getString("CMB_AMTGK"));
                temp.setCMbamsms(result.getString("CMB_AMSMS"));
                temp.setCMbbytgk(result.getString("CMB_BYTGK"));
                temp.setCMbbysms(result.getString("CMB_BYSMS"));

                temp.setCMplebh1(result.getString("CMP_LEBH1"));
                temp.setCMnlebh1(result.getString("CMN_LEBH1"));
                temp.setCMblebh1(result.getString("CMB_LEBH1"));

                //searchResults.add(temp);
            } else {
                //System.out.println("HVcmk1 Object Not Found!");
                throw new NotFoundException("HVcmk1 Object Not Found!");
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        //return (List)searchResults;
    }
    /*END hafiz
     2 MAY 2014, FRIDAY
     */

}
