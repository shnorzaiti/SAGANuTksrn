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
public class ClearDataInitial {
    
    public void hlKbc1 (Connection conn) 
          throws NotFoundException, SQLException {


          String sql = "TRUNCATE TABLE hlkbc1 ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);


              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }
    
    public void hlKbc2 (Connection conn) 
          throws NotFoundException, SQLException {


          String sql = "TRUNCATE TABLE hlkbc2 ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);


              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }
    
    public void hNotis (Connection conn) 
          throws NotFoundException, SQLException {


          String sql = "TRUNCATE TABLE hnotis ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);


              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }    
  
    public void hlNote (Connection conn) 
          throws NotFoundException, SQLException {


          String sql = "TRUNCATE TABLE hlnote ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);


              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }    
  
    public void hWarnf (Connection conn) 
          throws NotFoundException, SQLException {


          String sql = "TRUNCATE TABLE hwarnf ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);


              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }
    
    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }
}
