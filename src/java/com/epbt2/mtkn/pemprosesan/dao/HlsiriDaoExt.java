/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epbt2.mtkn.pemprosesan.dao;

import com.epbt2.util.NotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author otasoft01
 */
public class HlsiriDaoExt extends HlsiriDao {
    
    public void saveInitialStghThn(Connection conn, Hlsiri valueObject) 
          throws NotFoundException, SQLException {

        
          String sql = "UPDATE MTKN.HLSIRI SET SIR_TMAXN = ? WHERE (SUBSTR(SIR_TNAMA,1,4) = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getSirTmaxn()); 

              stmt.setString(2, valueObject.getSirTnama()); 

              int rowcount = databaseUpdate(conn, stmt);
              /*if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
              }*/
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }
}
