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

/**
 *
 * @author NurMuhammadAfzal Edit By : 25/09/2014 (BYE)
 */
public class HVmjc1DaoExt extends HVmjc1Dao {

    public HVmjc1 loadTerimaan(Connection conn) throws NotFoundException, SQLException {
//public List loadTerimaan(Connection conn) throws SQLException {
        HVmjc1 valueObject = createValueObject();

        String sql = "SELECT TO_CHAR(VMJ_AMTGK, 'fm999,999,990.99') VMJ_AMTGK, TO_CHAR(VMJ_BMTGK, 'fm9,999,990.90') VMJ_BMTGK, "
                + "TO_CHAR(VMJ_CMTGK, 'fm999,999,999.99') VMJ_CMTGK, TO_CHAR(VMJ_DMTGK, 'fm999,999,999.99') VMJ_DMTGK, "
                + "TO_CHAR(VMJ_LEBH1, 'fm999,999,999.99') VMJ_LEBH1, TO_CHAR(VMJ_AYTGK, 'fm999,999,999.99') VMJ_AYTGK, "
                + "TO_CHAR(VMJ_BYTGK, 'fm999,999,999.99') VMJ_BYTGK, TO_CHAR(VMJ_CYTGK, 'fm999,999,999.99') VMJ_CYTGK, "
                + "TO_CHAR(VMJ_DYTGK, 'fm999,999,999.99') VMJ_DYTGK, TO_CHAR(VMJ_FMSMS, 'fm999,999,999.99') VMJ_FMSMS, "
                + "TO_CHAR(VMJ_FMTGK, 'fm999,999,999.99') VMJ_FMTGK, TO_CHAR(VMJ_FYSMS, 'fm999,999,999.99') VMJ_FYSMS, "
                + "TO_CHAR(VMJ_FYTGK, 'fm999,999,999.99') VMJ_FYTGK "
                + "FROM MTKN.HVmjc1, MTKN.HVmjc2";
       // List searchResults = listTerimaanQuery(conn, conn.prepareStatement(sql));

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            listTerimaanQuery(conn, stmt, valueObject);
            //return searchResults;        

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return valueObject;
    }

    protected void listTerimaanQuery(Connection conn, PreparedStatement stmt, HVmjc1 temp)
            throws NotFoundException, SQLException {
        //protected List listTerimaanQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                /*ArrayList searchResults = new ArrayList();
                 ResultSet result = null;

                 try {
                 result = stmt.executeQuery();

                 while (result.next()) {*/
                  // HVmjc1 temp = createValueObject();
                temp.setVMjlebh1(result.getString("VMJ_LEBH1"));
                temp.setVMjcmtgk(result.getString("VMJ_CMTGK"));
                temp.setVMjcytgk(result.getString("VMJ_CYTGK"));
                temp.setVMjdmtgk(result.getString("VMJ_DMTGK"));
                temp.setVMjamtgk(result.getString("VMJ_AMTGK"));
                temp.setVMjaytgk(result.getString("VMJ_AYTGK"));
                temp.setVMjbmtgk(result.getString("VMJ_BMTGK"));
                temp.setVMjbytgk(result.getString("VMJ_BYTGK"));
                temp.setVMjdytgk(result.getString("VMJ_DYTGK"));
                temp.setVMjfmsms(result.getString("VMJ_FMSMS"));
                temp.setVMjfmtgk(result.getString("VMJ_FMTGK"));
                temp.setVMjfysms(result.getString("VMJ_FYSMS"));
                temp.setVMjfytgk(result.getString("VMJ_FYTGK"));

                // searchResults.add(temp);
            } else {
                //System.out.println("HVmjc1 Object Not Found!");
                throw new NotFoundException("HVmjc1 Object Not Found!");
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        // return (List)searchResults;
    }
}
