package com.epbt2.mtkn.tanya.dao;


import com.epbt2.util.NotFoundException;
import java.sql.*;
import java.util.*;

public class VTstatDao {
 
    public VTstat createValueObject() {
          return new VTstat();
    }
   
    public VTstat getObject(Connection conn, String PYtstatf) throws NotFoundException, SQLException {

          VTstat valueObject = createValueObject();
          valueObject.setPYtstatf(PYtstatf);
          load(conn, valueObject);
          return valueObject;
    }
   
    public void load(Connection conn, VTstat valueObject) throws NotFoundException, SQLException {

          if (valueObject.getPYtstatf() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new NotFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT PYT_STATF, TO_CHAR (TGK_CT,'fm99,999,990.90') TGK_CT, TO_CHAR (TGK_DENDA,'fm99,999,990.90') TGK_DENDA, TO_CHAR (TGK_NOTISE,'fm99,999,990.90') TGK_NOTISE, TO_CHAR (TGK_WRN,'fm99,999,990.90') TGK_WRN, TO_CHAR (TGK_NOD,'fm99,999,990.90') TGK_NOD, TO_CHAR (CTAKSIR,'fm99,999,990.90') CTAKSIR, TO_CHAR (DENDA,'fm99,999,990.90') DENDA, TO_CHAR (NOTISE,'fm99,999,990.90') NOTISE, TO_CHAR (WARAN,'fm99,999,990.90') WARAN, TO_CHAR (NOD,'fm99,999,990.90') NOD, TO_CHAR (BYR_TGK_CT,'fm99,999,990.90') BYR_TGK_CT, TO_CHAR (BYR_TGK_DENDA,'fm99,999,990.90') BYR_TGK_DENDA, TO_CHAR (BYR_TGK_NOTISE,'fm99,999,990.90') BYR_TGK_NOTISE, TO_CHAR (BYR_TGK_WRN,'fm99,999,990.90') BYR_TGK_WRN, TO_CHAR (BYR_TGK_NOD,'fm99,999,990.90') BYR_TGK_NOD, TO_CHAR (BYR_CTAKSIR,'fm99,999,990.90') BYR_CTAKSIR, TO_CHAR (BYR_DENDA,'fm99,999,990.90') BYR_DENDA, TO_CHAR (BYR_NOTISE,'fm99,999,990.90') BYR_NOTISE, TO_CHAR (BYR_WARAN,'fm99,999,990.90') BYR_WARAN, TO_CHAR (BYR_NOD,'fm99,999,990.90') BYR_NOD FROM MTKN.VTSTAT WHERE (PYT_STATF = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getPYtstatf()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }
 
    public List loadVTstat(Connection conn) throws SQLException {

          String sql = "SELECT LOOKUP_DESC PYT_STATF, TO_CHAR (TGK_CT,'fm99,999,990.90') TGK_CT, TO_CHAR (TGK_DENDA,'fm99,999,990.90') TGK_DENDA, TO_CHAR (TGK_NOTISE,'fm99,999,990.90') TGK_NOTISE, TO_CHAR (TGK_WRN,'fm99,999,990.90') TGK_WRN, TO_CHAR (TGK_NOD,'fm99,999,990.90') TGK_NOD, TO_CHAR (CTAKSIR,'fm99,999,990.90') CTAKSIR, TO_CHAR (DENDA,'fm99,999,990.90') DENDA, TO_CHAR (NOTISE,'fm99,999,990.90') NOTISE, TO_CHAR (WARAN,'fm99,999,990.90') WARAN, TO_CHAR (NOD,'fm99,999,990.90') NOD, TO_CHAR (BYR_TGK_CT,'fm99,999,990.90') BYR_TGK_CT, TO_CHAR (BYR_TGK_DENDA,'fm99,999,990.90') BYR_TGK_DENDA, TO_CHAR (BYR_TGK_NOTISE,'fm99,999,990.90') BYR_TGK_NOTISE, TO_CHAR (BYR_TGK_WRN,'fm99,999,990.90') BYR_TGK_WRN, TO_CHAR (BYR_TGK_NOD,'fm99,999,990.90') BYR_TGK_NOD, TO_CHAR (BYR_CTAKSIR,'fm99,999,990.90') BYR_CTAKSIR, TO_CHAR (BYR_DENDA,'fm99,999,990.90') BYR_DENDA, TO_CHAR (BYR_NOTISE,'fm99,999,990.90') BYR_NOTISE, TO_CHAR (BYR_WARAN,'fm99,999,990.90') BYR_WARAN, TO_CHAR (BYR_NOD,'fm99,999,990.90') BYR_NOD FROM MTKN.VTSTAT, MTKN.STD_LOOKUP_TABLE WHERE ( LOOKUP_CODE = PYT_STATF AND LOOKUP_GROUP= 'PYT_STATF' AND LOOKUP_STATUS = 'A')  ORDER BY PYT_STATF ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          System.out.println(sql);
          return searchResults;
    }

    public synchronized void create(Connection conn, VTstat valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO MTKN.VTSTAT ( PYT_STATF, TGK_CT, TGK_DENDA, "
               + "TGK_NOTISE, TGK_WRN, TGK_NOD, "
               + "CTAKSIR, DENDA, NOTISE, "
               + "WARAN, NOD, BYR_TGK_CT, "
               + "BYR_TGK_DENDA, BYR_TGK_NOTISE, BYR_TGK_WRN, "
               + "BYR_TGK_NOD, BYR_CTAKSIR, BYR_DENDA, "
               + "BYR_NOTISE, BYR_WARAN, BYR_NOD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getPYtstatf()); 
               stmt.setString(2, valueObject.getTGkct()); 
               stmt.setString(3, valueObject.getTGkdenda()); 
               stmt.setString(4, valueObject.getTGknotise()); 
               stmt.setString(5, valueObject.getTGkwrn()); 
               stmt.setString(6, valueObject.getTGknod()); 
               stmt.setString(7, valueObject.getCTaksir()); 
               stmt.setString(8, valueObject.getDenda()); 
               stmt.setString(9, valueObject.getNOtise()); 
               stmt.setString(10, valueObject.getWAran()); 
               stmt.setString(11, valueObject.getNOd()); 
               stmt.setString(12, valueObject.getBYrtgkct()); 
               stmt.setString(13, valueObject.getBYrtgkdenda()); 
               stmt.setString(14, valueObject.getBYrtgknotise()); 
               stmt.setString(15, valueObject.getBYrtgkwrn()); 
               stmt.setString(16, valueObject.getBYrtgknod()); 
               stmt.setString(17, valueObject.getBYrctaksir()); 
               stmt.setString(18, valueObject.getBYrdenda()); 
               stmt.setString(19, valueObject.getBYrnotise()); 
               stmt.setString(20, valueObject.getBYrwaran()); 
               stmt.setString(21, valueObject.getByrnod()); 

               int rowcount = databaseUpdate(conn, stmt);
               if (rowcount != 1) {
                    //System.out.println("PrimaryKey Error when updating DB!");
                    throw new SQLException("PrimaryKey Error when updating DB!");
               }

          } finally {
              if (stmt != null)
                  stmt.close();
          }


    }

    public void save(Connection conn, VTstat valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE MTKN.VTSTAT SET TGK_CT = ?, TGK_DENDA = ?, TGK_NOTISE = ?, "
               + "TGK_WRN = ?, TGK_NOD = ?, CTAKSIR = ?, "
               + "DENDA = ?, NOTISE = ?, WARAN = ?, "
               + "NOD = ?, BYR_TGK_CT = ?, BYR_TGK_DENDA = ?, "
               + "BYR_TGK_NOTISE = ?, BYR_TGK_WRN = ?, BYR_TGK_NOD = ?, "
               + "BYR_CTAKSIR = ?, BYR_DENDA = ?, BYR_NOTISE = ?, "
               + "BYR_WARAN = ?, BYR_NOD = ? WHERE (PYT_STATF = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getTGkct()); 
              stmt.setString(2, valueObject.getTGkdenda()); 
              stmt.setString(3, valueObject.getTGknotise()); 
              stmt.setString(4, valueObject.getTGkwrn()); 
              stmt.setString(5, valueObject.getTGknod()); 
              stmt.setString(6, valueObject.getCTaksir()); 
              stmt.setString(7, valueObject.getDenda()); 
              stmt.setString(8, valueObject.getNOtise()); 
              stmt.setString(9, valueObject.getWAran()); 
              stmt.setString(10, valueObject.getNOd()); 
              stmt.setString(11, valueObject.getBYrtgkct()); 
              stmt.setString(12, valueObject.getBYrtgkdenda()); 
              stmt.setString(13, valueObject.getBYrtgknotise()); 
              stmt.setString(14, valueObject.getBYrtgkwrn()); 
              stmt.setString(15, valueObject.getBYrtgknod()); 
              stmt.setString(16, valueObject.getBYrctaksir()); 
              stmt.setString(17, valueObject.getBYrdenda()); 
              stmt.setString(18, valueObject.getBYrnotise()); 
              stmt.setString(19, valueObject.getBYrwaran()); 
              stmt.setString(20, valueObject.getByrnod()); 

              stmt.setString(21, valueObject.getPYtstatf()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public void delete(Connection conn, VTstat valueObject) 
          throws NotFoundException, SQLException {

          if (valueObject.getPYtstatf() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new NotFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM MTKN.VTSTAT WHERE (PYT_STATF = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getPYtstatf()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be deleted (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public void deleteAll(Connection conn) throws SQLException {

          String sql = "DELETE FROM MTKN.VTSTAT";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public int countAll(Connection conn) throws SQLException {

          String sql = "SELECT count(*) FROM MTKN.VTSTAT";
          PreparedStatement stmt = null;
          ResultSet result = null;
          int allRows = 0;

          try {
              stmt = conn.prepareStatement(sql);
              result = stmt.executeQuery();

              if (result.next())
                  allRows = result.getInt(1);
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
          return allRows;
    }

    public List searchMatching(Connection conn, VTstat valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM MTKN.VTSTAT WHERE 1=1 ");

          if (valueObject.getPYtstatf() != null) {
              if (first) { first = false; }
              sql.append("AND PYT_STATF LIKE '").append(valueObject.getPYtstatf()).append("%' ");
          }

          if (valueObject.getTGkct() != null) {
              if (first) { first = false; }
              sql.append("AND TGK_CT LIKE '").append(valueObject.getTGkct()).append("%' ");
          }

          if (valueObject.getTGkdenda() != null) {
              if (first) { first = false; }
              sql.append("AND TGK_DENDA LIKE '").append(valueObject.getTGkdenda()).append("%' ");
          }

          if (valueObject.getTGknotise() != null) {
              if (first) { first = false; }
              sql.append("AND TGK_NOTISE LIKE '").append(valueObject.getTGknotise()).append("%' ");
          }

          if (valueObject.getTGkwrn() != null) {
              if (first) { first = false; }
              sql.append("AND TGK_WRN LIKE '").append(valueObject.getTGkwrn()).append("%' ");
          }

          if (valueObject.getTGknod() != null) {
              if (first) { first = false; }
              sql.append("AND TGK_NOD LIKE '").append(valueObject.getTGknod()).append("%' ");
          }

          if (valueObject.getCTaksir() != null) {
              if (first) { first = false; }
              sql.append("AND CTAKSIR LIKE '").append(valueObject.getCTaksir()).append("%' ");
          }

          if (valueObject.getDenda() != null) {
              if (first) { first = false; }
              sql.append("AND DENDA LIKE '").append(valueObject.getDenda()).append("%' ");
          }

          if (valueObject.getNOtise() != null) {
              if (first) { first = false; }
              sql.append("AND NOTISE LIKE '").append(valueObject.getNOtise()).append("%' ");
          }

          if (valueObject.getWAran() != null) {
              if (first) { first = false; }
              sql.append("AND WARAN LIKE '").append(valueObject.getWAran()).append("%' ");
          }

          if (valueObject.getNOd() != null) {
              if (first) { first = false; }
              sql.append("AND NOD LIKE '").append(valueObject.getNOd()).append("%' ");
          }

          if (valueObject.getBYrtgkct() != null) {
              if (first) { first = false; }
              sql.append("AND BYR_TGK_CT LIKE '").append(valueObject.getBYrtgkct()).append("%' ");
          }

          if (valueObject.getBYrtgkdenda() != null) {
              if (first) { first = false; }
              sql.append("AND BYR_TGK_DENDA LIKE '").append(valueObject.getBYrtgkdenda()).append("%' ");
          }

          if (valueObject.getBYrtgknotise() != null) {
              if (first) { first = false; }
              sql.append("AND BYR_TGK_NOTISE LIKE '").append(valueObject.getBYrtgknotise()).append("%' ");
          }

          if (valueObject.getBYrtgkwrn() != null) {
              if (first) { first = false; }
              sql.append("AND BYR_TGK_WRN LIKE '").append(valueObject.getBYrtgkwrn()).append("%' ");
          }

          if (valueObject.getBYrtgknod() != null) {
              if (first) { first = false; }
              sql.append("AND BYR_TGK_NOD LIKE '").append(valueObject.getBYrtgknod()).append("%' ");
          }

          if (valueObject.getBYrctaksir() != null) {
              if (first) { first = false; }
              sql.append("AND BYR_CTAKSIR LIKE '").append(valueObject.getBYrctaksir()).append("%' ");
          }

          if (valueObject.getBYrdenda() != null) {
              if (first) { first = false; }
              sql.append("AND BYR_DENDA LIKE '").append(valueObject.getBYrdenda()).append("%' ");
          }

          if (valueObject.getBYrnotise() != null) {
              if (first) { first = false; }
              sql.append("AND BYR_NOTISE LIKE '").append(valueObject.getBYrnotise()).append("%' ");
          }

          if (valueObject.getBYrwaran() != null) {
              if (first) { first = false; }
              sql.append("AND BYR_WARAN LIKE '").append(valueObject.getBYrwaran()).append("%' ");
          }

          if (valueObject.getByrnod() != null) {
              if (first) { first = false; }
              sql.append("AND BYR_NOD LIKE '").append(valueObject.getByrnod()).append("%' ");
          }


          sql.append("ORDER BY PYT_STATF ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }

    protected void singleQuery(Connection conn, PreparedStatement stmt, VTstat valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setPYtstatf(result.getString("PYT_STATF")); 
                   valueObject.setTGkct(result.getString("TGK_CT")); 
                   valueObject.setTGkdenda(result.getString("TGK_DENDA")); 
                   valueObject.setTGknotise(result.getString("TGK_NOTISE")); 
                   valueObject.setTGkwrn(result.getString("TGK_WRN")); 
                   valueObject.setTGknod(result.getString("TGK_NOD")); 
                   valueObject.setCTaksir(result.getString("CTAKSIR")); 
                   valueObject.setDenda(result.getString("DENDA")); 
                   valueObject.setNOtise(result.getString("NOTISE")); 
                   valueObject.setWAran(result.getString("WARAN")); 
                   valueObject.setNOd(result.getString("NOD")); 
                   valueObject.setBYrtgkct(result.getString("BYR_TGK_CT")); 
                   valueObject.setBYrtgkdenda(result.getString("BYR_TGK_DENDA")); 
                   valueObject.setBYrtgknotise(result.getString("BYR_TGK_NOTISE")); 
                   valueObject.setBYrtgkwrn(result.getString("BYR_TGK_WRN")); 
                   valueObject.setBYrtgknod(result.getString("BYR_TGK_NOD")); 
                   valueObject.setBYrctaksir(result.getString("BYR_CTAKSIR")); 
                   valueObject.setBYrdenda(result.getString("BYR_DENDA")); 
                   valueObject.setBYrnotise(result.getString("BYR_NOTISE")); 
                   valueObject.setBYrwaran(result.getString("BYR_WARAN")); 
                   valueObject.setByrnod(result.getString("BYR_NOD")); 

              } else {
                    //System.out.println("VTstat Object Not Found!");
                    throw new NotFoundException("VTstat Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }

    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   VTstat temp = createValueObject();

                   temp.setPYtstatf(result.getString("PYT_STATF")); 
                   temp.setTGkct(result.getString("TGK_CT")); 
                   temp.setTGkdenda(result.getString("TGK_DENDA")); 
                   temp.setTGknotise(result.getString("TGK_NOTISE")); 
                   temp.setTGkwrn(result.getString("TGK_WRN")); 
                   temp.setTGknod(result.getString("TGK_NOD")); 
                   temp.setCTaksir(result.getString("CTAKSIR")); 
                   temp.setDenda(result.getString("DENDA")); 
                   temp.setNOtise(result.getString("NOTISE")); 
                   temp.setWAran(result.getString("WARAN")); 
                   temp.setNOd(result.getString("NOD")); 
                   temp.setBYrtgkct(result.getString("BYR_TGK_CT")); 
                   temp.setBYrtgkdenda(result.getString("BYR_TGK_DENDA")); 
                   temp.setBYrtgknotise(result.getString("BYR_TGK_NOTISE")); 
                   temp.setBYrtgkwrn(result.getString("BYR_TGK_WRN")); 
                   temp.setBYrtgknod(result.getString("BYR_TGK_NOD")); 
                   temp.setBYrctaksir(result.getString("BYR_CTAKSIR")); 
                   temp.setBYrdenda(result.getString("BYR_DENDA")); 
                   temp.setBYrnotise(result.getString("BYR_NOTISE")); 
                   temp.setBYrwaran(result.getString("BYR_WARAN")); 
                   temp.setByrnod(result.getString("BYR_NOD")); 

                   searchResults.add(temp);
              }

          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }

          return (List)searchResults;
    }


}
