/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epbt2.mtkn.pemprosesan.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;
/**
 *
 * @author NurMuhammadAfzal
 */
public class HLkbc1 implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String BC1akaun;
    private String BC1nobil;
    private String BC1tkhbl;
    private String BC1tmpoh;
    private String BC1statf;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public HLkbc1 () {

    }

    public HLkbc1 (String BC1akaunIn) {

          this.BC1akaun = BC1akaunIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public String getBC1akaun() {
          return this.BC1akaun;
    }
    public void setBC1akaun(String BC1akaunIn) {
          this.BC1akaun = BC1akaunIn;
    }

    public String getBC1nobil() {
          return this.BC1nobil;
    }
    public void setBC1nobil(String BC1nobilIn) {
          this.BC1nobil = BC1nobilIn;
    }

    public String getBC1tkhbl() {
          return this.BC1tkhbl;
    }
    public void setBC1tkhbl(String BC1tkhblIn) {
          this.BC1tkhbl = BC1tkhblIn;
    }

    public String getBC1tmpoh() {
          return this.BC1tmpoh;
    }
    public void setBC1tmpoh(String BC1tmpohIn) {
          this.BC1tmpoh = BC1tmpohIn;
    }

    public String getBC1statf() {
          return this.BC1statf;
    }
    public void setBC1statf(String BC1statfIn) {
          this.BC1statf = BC1statfIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(String BC1akaunIn,
          String BC1nobilIn,
          String BC1tkhblIn,
          String BC1tmpohIn,
          String BC1statfIn) {
          this.BC1akaun = BC1akaunIn;
          this.BC1nobil = BC1nobilIn;
          this.BC1tkhbl = BC1tkhblIn;
          this.BC1tmpoh = BC1tmpohIn;
          this.BC1statf = BC1statfIn;
    }


    /** 
     * hasEqualMapping-method will compare two HLkbc1 instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(HLkbc1 valueObject) {

          if (this.BC1akaun == null) {
                    if (valueObject.getBC1akaun() != null)
                           return(false);
          } else if (!this.BC1akaun.equals(valueObject.getBC1akaun())) {
                    return(false);
          }
          if (this.BC1nobil == null) {
                    if (valueObject.getBC1nobil() != null)
                           return(false);
          } else if (!this.BC1nobil.equals(valueObject.getBC1nobil())) {
                    return(false);
          }
          if (this.BC1tkhbl == null) {
                    if (valueObject.getBC1tkhbl() != null)
                           return(false);
          } else if (!this.BC1tkhbl.equals(valueObject.getBC1tkhbl())) {
                    return(false);
          }
          if (this.BC1tmpoh == null) {
                    if (valueObject.getBC1tmpoh() != null)
                           return(false);
          } else if (!this.BC1tmpoh.equals(valueObject.getBC1tmpoh())) {
                    return(false);
          }
          if (this.BC1statf == null) {
                    if (valueObject.getBC1statf() != null)
                           return(false);
          } else if (!this.BC1statf.equals(valueObject.getBC1statf())) {
                    return(false);
          }

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass HLkbc1, mapping to table MTKN.HLKBC1\n");
        out.append("Persistent attributes: \n"); 
        out.append("BC1akaun = " + this.BC1akaun + "\n"); 
        out.append("BC1nobil = " + this.BC1nobil + "\n"); 
        out.append("BC1tkhbl = " + this.BC1tkhbl + "\n"); 
        out.append("BC1tmpoh = " + this.BC1tmpoh + "\n"); 
        out.append("BC1statf = " + this.BC1statf + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        HLkbc1 cloned = new HLkbc1();

        if (this.BC1akaun != null)
             cloned.setBC1akaun(new String(this.BC1akaun)); 
        if (this.BC1nobil != null)
             cloned.setBC1nobil(new String(this.BC1nobil)); 
        if (this.BC1tkhbl != null)
             cloned.setBC1tkhbl(new String(this.BC1tkhbl)); 
        if (this.BC1tmpoh != null)
             cloned.setBC1tmpoh(new String(this.BC1tmpoh)); 
        if (this.BC1statf != null)
             cloned.setBC1statf(new String(this.BC1statf)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}
