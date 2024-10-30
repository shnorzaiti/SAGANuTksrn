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
 * @author NurMuhammadAfzal Edit By : 25/09/2014 (BYE)
 */
public class HVmjc2DaoExt extends HVmjc2Dao {

    public HVmjc2 loadHutang(Connection conn) throws NotFoundException, SQLException {
    //public List loadHutang(Connection conn) throws SQLException {

          HVmjc2 valueObject = createValueObject();
          
        String sql = "SELECT "
                + "TO_CHAR(VMJ_LEBH2, 'fm999,999,999,999.99') VMJ_LEBH2,TO_CHAR(VMJ_EMSMS, 'fm999,999,999,999.99') VMJ_EMSMS,"
                + "TO_CHAR(VMJ_AMSMS, 'fm999,999,999,999.99') VMJ_AMSMS,TO_CHAR(VMJ_BMSMS, 'fm999,999,999,999.99') VMJ_BMSMS,"
                + "TO_CHAR(VMJ_CMSMS, 'fm999,999,999,999.99') VMJ_CMSMS,TO_CHAR(VMJ_DMSMS, 'fm999,999,999,999.99') VMJ_DMSMS,"
                + "TO_CHAR(VMJ_EMTGK, 'fm999,999,999,999.99') VMJ_EMTGK,TO_CHAR(VMJ_EYSMS, 'fm999,999,999,999.99') VMJ_EYSMS,"
                + "TO_CHAR(VMJ_EYTGK, 'fm999,999,999,999.99') VMJ_EYTGK,TO_CHAR(VMJ_FMSMS, 'fm999,999,999,999.99') VMJ_FMSMS,"
                + "TO_CHAR(VMJ_FMTGK, 'fm999,999,999,999.99') VMJ_FMTGK,TO_CHAR(VMJ_FYSMS, 'fm999,999,999,999.99') VMJ_FYSMS,"
                // hafiz 
                + "TO_CHAR(VMJ_FYTGK, 'fm999,999,999,990.99') VMJ_FYTGK,"
                + "TO_CHAR(VMJ_AYSMS, 'fm999,999,999,990.99') VMJ_AYSMS,"
                + "TO_CHAR(VMJ_BYSMS, 'fm999,999,999,990.99') VMJ_BYSMS,"
                + "TO_CHAR(VMJ_CYSMS, 'fm999,999,999,990.99') VMJ_CYSMS,"
                + "TO_CHAR(VMJ_DYSMS, 'fm999,999,999,990.99') VMJ_DYSMS,"
                
                //uzzair
                + "TO_CHAR(VMJ_FMSMS+VMJ_EMSMS, 'fm999,999,999,999.99') SCR_TGKNA,"
                + "TO_CHAR(VMJ_FMTGK+VMJ_EMTGK, 'fm999,999,999,999.99') SCR_TGKNB,"
                + "TO_CHAR(VMJ_FYSMS+VMJ_EYSMS, 'fm999,999,999,999.99') SCR_TGKNC,"
                + "TO_CHAR(VMJ_FYTGK+VMJ_EYTGK, 'fm999,999,999,999.99') SCR_TGKND "
                + "FROM MTKN.HVmjc2, MTKN.HVmjc1";
        // hafiz 
        //List searchResults = listTerimaanQuery(conn, conn.prepareStatement(sql));
        
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               
            listTerimaanQuery(conn, stmt, valueObject);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
          return valueObject;
       // return searchResults;
    }
    
    
    protected void listTerimaanQuery(Connection conn, PreparedStatement stmt, HVmjc2 temp)
            throws NotFoundException, SQLException {

   // protected List listTerimaanQuery(Connection conn, PreparedStatement stmt) throws SQLException {

       /* ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HVmjc2 temp = createValueObject();*/
        
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                temp.setVMjlebh2(result.getString("VMJ_LEBH2"));
                temp.setVMjemsms(result.getString("VMJ_EMSMS"));
                temp.setVMjamsms(result.getString("VMJ_AMSMS"));
                temp.setVMjbmsms(result.getString("VMJ_BMSMS"));
                temp.setVMjcmsms(result.getString("VMJ_CMSMS"));
                temp.setVMjdmsms(result.getString("VMJ_DMSMS"));
                temp.setVMjemtgk(result.getString("VMJ_EMTGK"));
                temp.setVMjeysms(result.getString("VMJ_EYSMS"));
                temp.setVMjeytgk(result.getString("VMJ_EYTGK"));
                temp.setVMjfmsms(result.getString("VMJ_FMSMS"));
                temp.setVMjfmtgk(result.getString("VMJ_FMTGK"));
                temp.setVMjfysms(result.getString("VMJ_FYSMS"));
                temp.setVMjfytgk(result.getString("VMJ_FYTGK"));
                //uzzair
                temp.setSCrtgkna(result.getString("SCR_TGKNA"));
                temp.setSCrtgknb(result.getString("SCR_TGKNB"));
                temp.setSCrtgknc(result.getString("SCR_TGKNC"));
                temp.setSCrtgknd(result.getString("SCR_TGKND"));
                //end-uzzair
                //hafiz
                temp.setVMjaysms(result.getString("VMJ_AYSMS"));
                temp.setVMjbysms(result.getString("VMJ_BYSMS"));
                temp.setVMjcysms(result.getString("VMJ_CYSMS"));
                temp.setVMjdysms(result.getString("VMJ_DYSMS"));

                //searchResults.add(temp);
                //end hafiz
            } else {
                //System.out.println("HVmjc1 Object Not Found!");
                throw new NotFoundException("HVmjc2 Object Not Found!");
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
