/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author ShahRizal
 */
public class HLjabtDaoExt extends HLjabtDao {
    
public List loadJabatan(Connection conn) throws SQLException {

        String sql = " select jab_jbkod, jab_jnama, jab_alam1, "
                     + " jab_alam2, jab_alam3, jab_alam4, jpk_jnama " 
                     + " from MTKN.HLJABT, mtkn.hjenpk "
                     + " where jpk_jpkod=jab_jbkod order by jab_jbkod asc ";
        List searchResults = listJabtanQuery(conn, conn.prepareStatement(sql));
        System.out.println(sql);
        return searchResults;
    }

    protected List listJabtanQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLjabt temp = createValueObject();

                temp.setJabJbkod(result.getString("JAB_JBKOD"));
                temp.setJabJnama(result.getString("JAB_JNAMA"));
                temp.setJabAlam1(result.getString("JAB_ALAM1"));
                temp.setJabAlam2(result.getString("JAB_ALAM2"));
                temp.setJabAlam3(result.getString("JAB_ALAM3"));
                temp.setJabAlam4(result.getString("JAB_ALAM4"));
                temp.setJpkJnama(result.getString("JPK_JNAMA"));
               

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
    
    /* TAKSIRAN */
    
    public List loadHLjabt(Connection conn) throws SQLException {

        String sql = "select JAB_JBKOD,JAB_JNAMA,JAB_ALAM1,JAB_ALAM2,JAB_ALAM3,JAB_ALAM4 from mtkn.hljabt ORDER BY 1";

        System.out.println(sql);
        List searchResults = listHLjabtQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    protected List listHLjabtQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLjabt temp = createValueObject();

                temp.setJabJbkod(result.getString("JAB_JBKOD"));
                temp.setJabJnama(result.getString("JAB_JNAMA"));
                temp.setJabAlam1(result.getString("JAB_ALAM1"));
                temp.setJabAlam2(result.getString("JAB_ALAM2"));
                temp.setJabAlam3(result.getString("JAB_ALAM3"));
                temp.setJabAlam4(result.getString("JAB_ALAM4"));

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
    
     public HLjabt maklJabt(Connection conn, String JAbjbkod) throws NotFoundException, SQLException {

        HLjabt valueObject = createValueObject();

        String sql = "SELECT JAB_JBKOD, NVL2(JAB_JNAMA, JAB_JNAMA || '<br/>', '') || NVL2(JAB_ALAM1, JAB_ALAM1 || '<br/>', '') "
                + "|| NVL2(JAB_ALAM2, JAB_ALAM2 || '<br/>', '') || NVL2(JAB_ALAM3, JAB_ALAM3 || '<br/>', '') || NVL2(JAB_ALAM4, JAB_ALAM4, '') JAB_JNAMA "
                + ", '' JAB_ALAM1, '' JAB_ALAM2, '' JAB_ALAM3, '' JAB_ALAM4 "
                + "FROM MTKN.HLJABT WHERE (JAB_JBKOD = '"+JAbjbkod+"' ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            maklJabtQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return valueObject;
    }
    
    protected void maklJabtQuery(Connection conn, PreparedStatement stmt, HLjabt valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setJabJbkod(result.getString("JAB_JBKOD")); 
                   valueObject.setJabJnama(result.getString("JAB_JNAMA"));                    

              } else {
                    //System.out.println("HLjabt Object Not Found!");
                    throw new NotFoundException("HLjabt Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }
    /* TAKSIRAN */
    
    //SQL Popup Jabatan - chai -
    public List loadKodJbtn(Connection conn, HLjabt valueObject) throws Exception {

        String sql = "select jab_jbkod, jab_jnama "
                + "from mtkn.hljabt  "
                + "order by jab_jbkod";

        System.out.println(sql);
        List searchResults = listKodJbtnQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }
    
    protected List listKodJbtnQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLjabt temp = createValueObject();

                temp.setJabJbkod(result.getString("JAB_JBKOD"));
                temp.setJabJnama(result.getString("JAB_JNAMA"));

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
    
    public List carianKodJbtn(Connection conn, HLjabt valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("select jab_jlkod, jab_jnama"
                + " from mtkn.hljabt where 1=1");

        if (valueObject.getJabJbkod()!= null) {

            if (first) {

                first = false;

            }
            sql.append(" AND jab_jlkod LIKE '").append(valueObject.getJabJbkod()).append("' ");
        }

        if (valueObject.getJabJnama()!= null) {

            if (first) {

                first = false;
            }
            sql.append("OR jab_jnama LIKE '").append(valueObject.getJabJnama()).append("' ");
        }

        sql.append("ORDER BY jab_jnama ASC ");
        System.out.println(sql);
        if (first) {
            searchResults = new ArrayList();
        } else {
            searchResults = listCariKodJbtnQuery(conn, conn.prepareStatement(sql.toString()));
        }

        return searchResults;
    }
    
    protected List listCariKodJbtnQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                HLjabt temp = createValueObject();

                temp.setJabJbkod(result.getString("JAB_JBKOD"));
                temp.setJabJnama(result.getString("JAB_JNAMA"));

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
}
