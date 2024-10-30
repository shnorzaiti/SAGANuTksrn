/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epbt2.mtkn.pemprosesan.dao;

import com.epbt2.util.NotFoundException;
import java.sql.*;
import java.util.*;
/**
 *
 * @author NurMuhammadAfzal
 */
public class HLkbc1Dao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public HLkbc1 createValueObject() {
          return new HLkbc1();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public HLkbc1 getObject(Connection conn, String BC1akaun) throws NotFoundException, SQLException {

          HLkbc1 valueObject = createValueObject();
          valueObject.setBC1akaun(BC1akaun);
          load(conn, valueObject);
          return valueObject;
    }


    /**
     * load-method. This will load valueObject contents from database using
     * Primary-Key as identifier. Upper layer should use this so that valueObject
     * instance is created and only primary-key should be specified. Then call
     * this method to complete other persistent information. This method will
     * overwrite all other fields except primary-key and possible runtime variables.
     * If load can not find matching row, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be loaded.
     *                     Primary-key field must be set for this to work properly.
     */
    public void load(Connection conn, HLkbc1 valueObject) throws NotFoundException, SQLException {

          if (valueObject.getBC1akaun() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new NotFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM MTKN.HLKBC1 WHERE (BC1_AKAUN = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getBC1akaun()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * LoadAll-method. This will read all contents from database table and
     * build a List containing valueObjects. Please note, that this method
     * will consume huge amounts of resources if table has lot's of rows. 
     * This should only be used when target tables have only small amounts
     * of data.
     *
     * @param conn         This method requires working database connection.
     */
    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM MTKN.HLKBC1 ORDER BY BC1_AKAUN ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }



    /**
     * create-method. This will create new row in database according to supplied
     * valueObject contents. Make sure that values for all NOT NULL columns are
     * correctly specified. Also, if this table does not use automatic surrogate-keys
     * the primary-key must be specified. After INSERT command this method will 
     * read the generated primary-key back to valueObject if automatic surrogate-keys
     * were used. 
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be created.
     *                     If automatic surrogate-keys are not used the Primary-key 
     *                     field must be set for this to work properly.
     */
    public synchronized void create(Connection conn, HLkbc1 valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO MTKN.HLKBC1 ( BC1_AKAUN, BC1_NOBIL, BC1_TKHBL, "
               + "BC1_TMPOH, BC1_STATF) VALUES (?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getBC1akaun()); 
               stmt.setString(2, valueObject.getBC1nobil()); 
               stmt.setString(3, valueObject.getBC1tkhbl()); 
               stmt.setString(4, valueObject.getBC1tmpoh()); 
               stmt.setString(5, valueObject.getBC1statf()); 

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


    /**
     * save-method. This method will save the current state of valueObject to database.
     * Save can not be used to create new instances in database, so upper layer must
     * make sure that the primary-key is correctly specified. Primary-key will indicate
     * which instance is going to be updated in database. If save can not find matching 
     * row, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be saved.
     *                     Primary-key field must be set for this to work properly.
     */
    public void save(Connection conn, HLkbc1 valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE MTKN.HLKBC1 SET BC1_NOBIL = ?, BC1_TKHBL = ?, BC1_TMPOH = ?, "
               + "BC1_STATF = ? WHERE (BC1_AKAUN = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getBC1nobil()); 
              stmt.setString(2, valueObject.getBC1tkhbl()); 
              stmt.setString(3, valueObject.getBC1tmpoh()); 
              stmt.setString(4, valueObject.getBC1statf()); 

              stmt.setString(5, valueObject.getBC1akaun()); 

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


    /**
     * delete-method. This method will remove the information from database as identified by
     * by primary-key in supplied valueObject. Once valueObject has been deleted it can not 
     * be restored by calling save. Restoring can only be done using create method but if 
     * database is using automatic surrogate-keys, the resulting object will have different 
     * primary-key than what it was in the deleted object. If delete can not find matching row,
     * NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be deleted.
     *                     Primary-key field must be set for this to work properly.
     */
    public void delete(Connection conn, HLkbc1 valueObject) 
          throws NotFoundException, SQLException {

          if (valueObject.getBC1akaun() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new NotFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM MTKN.HLKBC1 WHERE (BC1_AKAUN = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getBC1akaun()); 

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


    /**
     * deleteAll-method. This method will remove all information from the table that matches
     * this Dao and ValueObject couple. This should be the most efficient way to clear table.
     * Once deleteAll has been called, no valueObject that has been created before can be 
     * restored by calling save. Restoring can only be done using create method but if database 
     * is using automatic surrogate-keys, the resulting object will have different primary-key 
     * than what it was in the deleted object. (Note, the implementation of this method should
     * be different with different DB backends.)
     *
     * @param conn         This method requires working database connection.
     */
    public void deleteAll(Connection conn) throws SQLException {

          String sql = "DELETE FROM MTKN.HLKBC1";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * coutAll-method. This method will return the number of all rows from table that matches
     * this Dao. The implementation will simply execute "select count(primarykey) from table".
     * If table is empty, the return value is 0. This method should be used before calling
     * loadAll, to make sure table has not too many rows.
     *
     * @param conn         This method requires working database connection.
     */
    public int countAll(Connection conn) throws SQLException {

          String sql = "SELECT count(*) FROM MTKN.HLKBC1";
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


    /** 
     * searchMatching-Method. This method provides searching capability to 
     * get matching valueObjects from database. It works by searching all 
     * objects that match permanent instance variables of given object.
     * Upper layer should use this by setting some parameters in valueObject
     * and then  call searchMatching. The result will be 0-N objects in a List, 
     * all matching those criteria you specified. Those instance-variables that
     * have NULL values are excluded in search-criteria.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance where search will be based.
     *                     Primary-key field should not be set.
     */
    public List searchMatching(Connection conn, HLkbc1 valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM MTKN.HLKBC1 WHERE 1=1 ");

          if (valueObject.getBC1akaun() != null) {
              if (first) { first = false; }
              sql.append("AND BC1_AKAUN LIKE '").append(valueObject.getBC1akaun()).append("%' ");
          }

          if (valueObject.getBC1nobil() != null) {
              if (first) { first = false; }
              sql.append("AND BC1_NOBIL LIKE '").append(valueObject.getBC1nobil()).append("%' ");
          }

          if (valueObject.getBC1tkhbl() != null) {
              if (first) { first = false; }
              sql.append("AND BC1_TKHBL LIKE '").append(valueObject.getBC1tkhbl()).append("%' ");
          }

          if (valueObject.getBC1tmpoh() != null) {
              if (first) { first = false; }
              sql.append("AND BC1_TMPOH LIKE '").append(valueObject.getBC1tmpoh()).append("%' ");
          }

          if (valueObject.getBC1statf() != null) {
              if (first) { first = false; }
              sql.append("AND BC1_STATF LIKE '").append(valueObject.getBC1statf()).append("%' ");
          }


          sql.append("ORDER BY BC1_AKAUN ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }


    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }


    /**
     * databaseUpdate-method. This method is a helper method for internal use. It will execute
     * all database handling that will change the information in tables. SELECT queries will
     * not be executed here however. The return value indicates how many rows were affected.
     * This method will also make sure that if cache is used, it will reset when data changes.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     */
    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }



    /**
     * databaseQuery-method. This method is a helper method for internal use. It will execute
     * all database queries that will return only one row. The resultset will be converted
     * to valueObject. If no rows were found, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     * @param valueObject  Class-instance where resulting data will be stored.
     */
    protected void singleQuery(Connection conn, PreparedStatement stmt, HLkbc1 valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setBC1akaun(result.getString("BC1_AKAUN")); 
                   valueObject.setBC1nobil(result.getString("BC1_NOBIL")); 
                   valueObject.setBC1tkhbl(result.getString("BC1_TKHBL")); 
                   valueObject.setBC1tmpoh(result.getString("BC1_TMPOH")); 
                   valueObject.setBC1statf(result.getString("BC1_STATF")); 

              } else {
                    //System.out.println("HLkbc1 Object Not Found!");
                    throw new NotFoundException("HLkbc1 Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * databaseQuery-method. This method is a helper method for internal use. It will execute
     * all database queries that will return multiple rows. The resultset will be converted
     * to the List of valueObjects. If no rows were found, an empty List will be returned.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     */
    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   HLkbc1 temp = createValueObject();

                   temp.setBC1akaun(result.getString("BC1_AKAUN")); 
                   temp.setBC1nobil(result.getString("BC1_NOBIL")); 
                   temp.setBC1tkhbl(result.getString("BC1_TKHBL")); 
                   temp.setBC1tmpoh(result.getString("BC1_TMPOH")); 
                   temp.setBC1statf(result.getString("BC1_STATF")); 

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

