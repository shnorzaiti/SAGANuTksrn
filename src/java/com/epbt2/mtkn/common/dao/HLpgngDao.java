package com.epbt2.mtkn.common.dao;

import com.epbt2.util.NotFoundException;
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
public class HLpgngDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public HLpgng createValueObject() {
          return new HLpgng();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public HLpgng getObject(Connection conn, String PEgakaun) throws NotFoundException, SQLException {

          HLpgng valueObject = createValueObject();
          valueObject.setPEgakaun(PEgakaun);
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
    public void load(Connection conn, HLpgng valueObject) throws NotFoundException, SQLException {

          if (valueObject.getPEgakaun() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new NotFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM MTKN.HLPGNG WHERE (PEG_AKAUN = ? OR PEG_OLDAC = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getPEgakaun());
               stmt.setString(2, valueObject.getPEgakaun()); 

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

          String sql = "SELECT * FROM MTKN.HLPGNG ORDER BY PEG_AKAUN ASC ";
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
    public synchronized void create(Connection conn, HLpgng valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO MTKN.HLPGNG ( PEG_AKAUN, PEG_DIGIT, PEG_JLKOD, "
               + "PEG_THKOD, PEG_HTKOD, PEG_JPKOD, "
               + "PEG_BGKOD, PEG_STKOD, PEG_NOLOT, "
               + "PEG_BLLOT, PEG_NOMPT, PEG_PELAN, "
               + "PEG_ADPG1, PEG_TKHOC, PEG_TKHTK, "
               + "PEG_TKHPL, PEG_NILTH, PEG_BILPK, "
               + "PEG_LSBGN, PEG_LSTNH, PEG_RJFIL, "
               + "PEG_RJMMK, PEG_STATF, PEG_OLDAC, "
               + "PEG_STATK, PEG_STCBK, PEG_ONAMA, "
               + "PEG_LSANS, PEG_ADPG2, PEG_AKLSN, "
               + "PEG_AKSWN, PEG_AKPBG) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getPEgakaun()); 
               stmt.setString(2, valueObject.getPEgdigit()); 
               stmt.setString(3, valueObject.getPEgjlkod()); 
               stmt.setString(4, valueObject.getPEgthkod()); 
               stmt.setString(5, valueObject.getPEghtkod()); 
               stmt.setString(6, valueObject.getPEgjpkod()); 
               stmt.setString(7, valueObject.getPEgbgkod()); 
               stmt.setString(8, valueObject.getPEgstkod()); 
               stmt.setString(9, valueObject.getPEgnolot()); 
               stmt.setString(10, valueObject.getPEgbllot()); 
               stmt.setString(11, valueObject.getPEgnompt()); 
               stmt.setString(12, valueObject.getPEgpelan()); 
               stmt.setString(13, valueObject.getPEgadpg1()); 
               stmt.setString(14, valueObject.getPEgtkhoc()); 
               stmt.setString(15, valueObject.getPEgtkhtk()); 
               stmt.setString(16, valueObject.getPEgtkhpl()); 
               stmt.setString(17, valueObject.getPEgnilth()); 
               stmt.setString(18, valueObject.getPEgbilpk()); 
               stmt.setString(19, valueObject.getPEglsbgn()); 
               stmt.setString(20, valueObject.getPEglstnh()); 
               stmt.setString(21, valueObject.getPEgrjfil()); 
               stmt.setString(22, valueObject.getPEgrjmmk()); 
               stmt.setString(23, valueObject.getPEgstatf()); 
               stmt.setString(24, valueObject.getPEgoldac()); 
               stmt.setString(25, valueObject.getPEgstatk()); 
               stmt.setString(26, valueObject.getPEgstcbk()); 
               stmt.setString(27, valueObject.getPEgonama()); 
               stmt.setString(28, valueObject.getPEglsans()); 
               stmt.setString(29, valueObject.getPEgadpg2()); 
               stmt.setString(30, valueObject.getPEgaklsn()); 
               stmt.setString(31, valueObject.getPEgakswn()); 
               stmt.setString(32, valueObject.getPEgakpbg()); 

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
    public void save(Connection conn, HLpgng valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE MTKN.HLPGNG SET PEG_DIGIT = ?, PEG_JLKOD = ?, PEG_THKOD = ?, "
               + "PEG_HTKOD = ?, PEG_JPKOD = ?, PEG_BGKOD = ?, "
               + "PEG_STKOD = ?, PEG_NOLOT = ?, PEG_BLLOT = ?, "
               + "PEG_NOMPT = ?, PEG_PELAN = ?, PEG_ADPG1 = ?, "
               + "PEG_TKHOC = ?, PEG_TKHTK = ?, PEG_TKHPL = ?, "
               + "PEG_NILTH = ?, PEG_BILPK = ?, PEG_LSBGN = ?, "
               + "PEG_LSTNH = ?, PEG_RJFIL = ?, PEG_RJMMK = ?, "
               + "PEG_STATF = ?, PEG_OLDAC = ?, PEG_STATK = ?, "
               + "PEG_STCBK = ?, PEG_ONAMA = ?, PEG_LSANS = ?, "
               + "PEG_ADPG2 = ?, PEG_AKLSN = ?, PEG_AKSWN = ?, "
               + "PEG_AKPBG = ? WHERE (PEG_AKAUN = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getPEgdigit()); 
              stmt.setString(2, valueObject.getPEgjlkod()); 
              stmt.setString(3, valueObject.getPEgthkod()); 
              stmt.setString(4, valueObject.getPEghtkod()); 
              stmt.setString(5, valueObject.getPEgjpkod()); 
              stmt.setString(6, valueObject.getPEgbgkod()); 
              stmt.setString(7, valueObject.getPEgstkod()); 
              stmt.setString(8, valueObject.getPEgnolot()); 
              stmt.setString(9, valueObject.getPEgbllot()); 
              stmt.setString(10, valueObject.getPEgnompt()); 
              stmt.setString(11, valueObject.getPEgpelan()); 
              stmt.setString(12, valueObject.getPEgadpg1()); 
              stmt.setString(13, valueObject.getPEgtkhoc()); 
              stmt.setString(14, valueObject.getPEgtkhtk()); 
              stmt.setString(15, valueObject.getPEgtkhpl()); 
              stmt.setString(16, valueObject.getPEgnilth()); 
              stmt.setString(17, valueObject.getPEgbilpk()); 
              stmt.setString(18, valueObject.getPEglsbgn()); 
              stmt.setString(19, valueObject.getPEglstnh()); 
              stmt.setString(20, valueObject.getPEgrjfil()); 
              stmt.setString(21, valueObject.getPEgrjmmk()); 
              stmt.setString(22, valueObject.getPEgstatf()); 
              stmt.setString(23, valueObject.getPEgoldac()); 
              stmt.setString(24, valueObject.getPEgstatk()); 
              stmt.setString(25, valueObject.getPEgstcbk()); 
              stmt.setString(26, valueObject.getPEgonama()); 
              stmt.setString(27, valueObject.getPEglsans()); 
              stmt.setString(28, valueObject.getPEgadpg2()); 
              stmt.setString(29, valueObject.getPEgaklsn()); 
              stmt.setString(30, valueObject.getPEgakswn()); 
              stmt.setString(31, valueObject.getPEgakpbg()); 

              stmt.setString(32, valueObject.getPEgakaun()); 

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
    public void delete(Connection conn, HLpgng valueObject) 
          throws NotFoundException, SQLException {

          if (valueObject.getPEgakaun() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new NotFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM MTKN.HLPGNG WHERE (PEG_AKAUN = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getPEgakaun()); 

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

          String sql = "DELETE FROM MTKN.HLPGNG";
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

          String sql = "SELECT count(*) FROM MTKN.HLPGNG";
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
    public List searchMatching(Connection conn, HLpgng valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM MTKN.HLPGNG WHERE 1=1 ");

          if (valueObject.getPEgakaun() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_AKAUN LIKE '").append(valueObject.getPEgakaun()).append("%' ");
          }

          if (valueObject.getPEgdigit() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_DIGIT LIKE '").append(valueObject.getPEgdigit()).append("%' ");
          }

          if (valueObject.getPEgjlkod() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_JLKOD LIKE '").append(valueObject.getPEgjlkod()).append("%' ");
          }

          if (valueObject.getPEgthkod() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_THKOD LIKE '").append(valueObject.getPEgthkod()).append("%' ");
          }

          if (valueObject.getPEghtkod() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_HTKOD LIKE '").append(valueObject.getPEghtkod()).append("%' ");
          }

          if (valueObject.getPEgjpkod() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_JPKOD LIKE '").append(valueObject.getPEgjpkod()).append("%' ");
          }

          if (valueObject.getPEgbgkod() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_BGKOD LIKE '").append(valueObject.getPEgbgkod()).append("%' ");
          }

          if (valueObject.getPEgstkod() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_STKOD LIKE '").append(valueObject.getPEgstkod()).append("%' ");
          }

          if (valueObject.getPEgnolot() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_NOLOT LIKE '").append(valueObject.getPEgnolot()).append("%' ");
          }

          if (valueObject.getPEgbllot() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_BLLOT LIKE '").append(valueObject.getPEgbllot()).append("%' ");
          }

          if (valueObject.getPEgnompt() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_NOMPT LIKE '").append(valueObject.getPEgnompt()).append("%' ");
          }

          if (valueObject.getPEgpelan() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_PELAN LIKE '").append(valueObject.getPEgpelan()).append("%' ");
          }

          if (valueObject.getPEgadpg1() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_ADPG1 LIKE '").append(valueObject.getPEgadpg1()).append("%' ");
          }

          if (valueObject.getPEgtkhoc() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_TKHOC LIKE '").append(valueObject.getPEgtkhoc()).append("%' ");
          }

          if (valueObject.getPEgtkhtk() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_TKHTK LIKE '").append(valueObject.getPEgtkhtk()).append("%' ");
          }

          if (valueObject.getPEgtkhpl() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_TKHPL LIKE '").append(valueObject.getPEgtkhpl()).append("%' ");
          }

          if (valueObject.getPEgnilth() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_NILTH LIKE '").append(valueObject.getPEgnilth()).append("%' ");
          }

          if (valueObject.getPEgbilpk() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_BILPK LIKE '").append(valueObject.getPEgbilpk()).append("%' ");
          }

          if (valueObject.getPEglsbgn() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_LSBGN LIKE '").append(valueObject.getPEglsbgn()).append("%' ");
          }

          if (valueObject.getPEglstnh() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_LSTNH LIKE '").append(valueObject.getPEglstnh()).append("%' ");
          }

          if (valueObject.getPEgrjfil() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_RJFIL LIKE '").append(valueObject.getPEgrjfil()).append("%' ");
          }

          if (valueObject.getPEgrjmmk() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_RJMMK LIKE '").append(valueObject.getPEgrjmmk()).append("%' ");
          }

          if (valueObject.getPEgstatf() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_STATF LIKE '").append(valueObject.getPEgstatf()).append("%' ");
          }

          if (valueObject.getPEgoldac() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_OLDAC LIKE '").append(valueObject.getPEgoldac()).append("%' ");
          }

          if (valueObject.getPEgstatk() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_STATK LIKE '").append(valueObject.getPEgstatk()).append("%' ");
          }

          if (valueObject.getPEgstcbk() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_STCBK LIKE '").append(valueObject.getPEgstcbk()).append("%' ");
          }

          if (valueObject.getPEgonama() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_ONAMA LIKE '").append(valueObject.getPEgonama()).append("%' ");
          }

          if (valueObject.getPEglsans() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_LSANS LIKE '").append(valueObject.getPEglsans()).append("%' ");
          }

          if (valueObject.getPEgadpg2() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_ADPG2 LIKE '").append(valueObject.getPEgadpg2()).append("%' ");
          }

          if (valueObject.getPEgaklsn() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_AKLSN LIKE '").append(valueObject.getPEgaklsn()).append("%' ");
          }

          if (valueObject.getPEgakswn() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_AKSWN LIKE '").append(valueObject.getPEgakswn()).append("%' ");
          }

          if (valueObject.getPEgakpbg() != null) {
              if (first) { first = false; }
              sql.append("AND PEG_AKPBG LIKE '").append(valueObject.getPEgakpbg()).append("%' ");
          }


          sql.append("ORDER BY PEG_AKAUN ASC ");

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
    protected void singleQuery(Connection conn, PreparedStatement stmt, HLpgng valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setPEgakaun(result.getString("PEG_AKAUN")); 
                   valueObject.setPEgdigit(result.getString("PEG_DIGIT")); 
                   valueObject.setPEgjlkod(result.getString("PEG_JLKOD")); 
                   valueObject.setPEgthkod(result.getString("PEG_THKOD")); 
                   valueObject.setPEghtkod(result.getString("PEG_HTKOD")); 
                   valueObject.setPEgjpkod(result.getString("PEG_JPKOD")); 
                   valueObject.setPEgbgkod(result.getString("PEG_BGKOD")); 
                   valueObject.setPEgstkod(result.getString("PEG_STKOD")); 
                   valueObject.setPEgnolot(result.getString("PEG_NOLOT")); 
                   valueObject.setPEgbllot(result.getString("PEG_BLLOT")); 
                   valueObject.setPEgnompt(result.getString("PEG_NOMPT")); 
                   valueObject.setPEgpelan(result.getString("PEG_PELAN")); 
                   valueObject.setPEgadpg1(result.getString("PEG_ADPG1")); 
                   valueObject.setPEgtkhoc(result.getString("PEG_TKHOC")); 
                   valueObject.setPEgtkhtk(result.getString("PEG_TKHTK")); 
                   valueObject.setPEgtkhpl(result.getString("PEG_TKHPL")); 
                   valueObject.setPEgnilth(result.getString("PEG_NILTH")); 
                   valueObject.setPEgbilpk(result.getString("PEG_BILPK")); 
                   valueObject.setPEglsbgn(result.getString("PEG_LSBGN")); 
                   valueObject.setPEglstnh(result.getString("PEG_LSTNH")); 
                   valueObject.setPEgrjfil(result.getString("PEG_RJFIL")); 
                   valueObject.setPEgrjmmk(result.getString("PEG_RJMMK")); 
                   valueObject.setPEgstatf(result.getString("PEG_STATF")); 
                   valueObject.setPEgoldac(result.getString("PEG_OLDAC")); 
                   valueObject.setPEgstatk(result.getString("PEG_STATK")); 
                   valueObject.setPEgstcbk(result.getString("PEG_STCBK")); 
                   valueObject.setPEgonama(result.getString("PEG_ONAMA")); 
                   valueObject.setPEglsans(result.getString("PEG_LSANS")); 
                   valueObject.setPEgadpg2(result.getString("PEG_ADPG2")); 
                   valueObject.setPEgaklsn(result.getString("PEG_AKLSN")); 
                   valueObject.setPEgakswn(result.getString("PEG_AKSWN")); 
                   valueObject.setPEgakpbg(result.getString("PEG_AKPBG")); 

              } else {
                    //System.out.println("HLpgng Object Not Found!");
                    throw new NotFoundException("HLpgng Object Not Found!");
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
                   HLpgng temp = createValueObject();

                   temp.setPEgakaun(result.getString("PEG_AKAUN")); 
                   temp.setPEgdigit(result.getString("PEG_DIGIT")); 
                   temp.setPEgjlkod(result.getString("PEG_JLKOD")); 
                   temp.setPEgthkod(result.getString("PEG_THKOD")); 
                   temp.setPEghtkod(result.getString("PEG_HTKOD")); 
                   temp.setPEgjpkod(result.getString("PEG_JPKOD")); 
                   temp.setPEgbgkod(result.getString("PEG_BGKOD")); 
                   temp.setPEgstkod(result.getString("PEG_STKOD")); 
                   temp.setPEgnolot(result.getString("PEG_NOLOT")); 
                   temp.setPEgbllot(result.getString("PEG_BLLOT")); 
                   temp.setPEgnompt(result.getString("PEG_NOMPT")); 
                   temp.setPEgpelan(result.getString("PEG_PELAN")); 
                   temp.setPEgadpg1(result.getString("PEG_ADPG1")); 
                   temp.setPEgtkhoc(result.getString("PEG_TKHOC")); 
                   temp.setPEgtkhtk(result.getString("PEG_TKHTK")); 
                   temp.setPEgtkhpl(result.getString("PEG_TKHPL")); 
                   temp.setPEgnilth(result.getString("PEG_NILTH")); 
                   temp.setPEgbilpk(result.getString("PEG_BILPK")); 
                   temp.setPEglsbgn(result.getString("PEG_LSBGN")); 
                   temp.setPEglstnh(result.getString("PEG_LSTNH")); 
                   temp.setPEgrjfil(result.getString("PEG_RJFIL")); 
                   temp.setPEgrjmmk(result.getString("PEG_RJMMK")); 
                   temp.setPEgstatf(result.getString("PEG_STATF")); 
                   temp.setPEgoldac(result.getString("PEG_OLDAC")); 
                   temp.setPEgstatk(result.getString("PEG_STATK")); 
                   temp.setPEgstcbk(result.getString("PEG_STCBK")); 
                   temp.setPEgonama(result.getString("PEG_ONAMA")); 
                   temp.setPEglsans(result.getString("PEG_LSANS")); 
                   temp.setPEgadpg2(result.getString("PEG_ADPG2")); 
                   temp.setPEgaklsn(result.getString("PEG_AKLSN")); 
                   temp.setPEgakswn(result.getString("PEG_AKSWN")); 
                   temp.setPEgakpbg(result.getString("PEG_AKPBG")); 

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
