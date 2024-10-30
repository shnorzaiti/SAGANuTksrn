package com.epbt2.mtkn.pemprosesan.dao;


import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Hlcmk2 Value Object.
  * This class is value object representing database table MTKN.HLCMK2
  * This class is intented to be used together with associated Dao object.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class Hlcmk2 implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String cm2Jbkod;
    private String cm2Kdrjk;
    private String cm2Nobil;
    private String cm2Nores;
    private String cm2Amaun;
    private String cm2Bayar;
    private String cm2Statf;
    private String cm2Laras;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Hlcmk2 () {

    }

    public Hlcmk2 (String cm2JbkodIn, String cm2KdrjkIn, String cm2NobilIn) {

          this.cm2Jbkod = cm2JbkodIn;
          this.cm2Kdrjk = cm2KdrjkIn;
          this.cm2Nobil = cm2NobilIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public String getCm2Jbkod() {
          return this.cm2Jbkod;
    }
    public void setCm2Jbkod(String cm2JbkodIn) {
          this.cm2Jbkod = cm2JbkodIn;
    }

    public String getCm2Kdrjk() {
          return this.cm2Kdrjk;
    }
    public void setCm2Kdrjk(String cm2KdrjkIn) {
          this.cm2Kdrjk = cm2KdrjkIn;
    }

    public String getCm2Nobil() {
          return this.cm2Nobil;
    }
    public void setCm2Nobil(String cm2NobilIn) {
          this.cm2Nobil = cm2NobilIn;
    }

    public String getCm2Nores() {
          return this.cm2Nores;
    }
    public void setCm2Nores(String cm2NoresIn) {
          this.cm2Nores = cm2NoresIn;
    }

    public String getCm2Amaun() {
          return this.cm2Amaun;
    }
    public void setCm2Amaun(String cm2AmaunIn) {
          this.cm2Amaun = cm2AmaunIn;
    }

    public String getCm2Bayar() {
          return this.cm2Bayar;
    }
    public void setCm2Bayar(String cm2BayarIn) {
          this.cm2Bayar = cm2BayarIn;
    }

    public String getCm2Statf() {
          return this.cm2Statf;
    }
    public void setCm2Statf(String cm2StatfIn) {
          this.cm2Statf = cm2StatfIn;
    }

    public String getCm2Laras() {
          return this.cm2Laras;
    }
    public void setCm2Laras(String cm2LarasIn) {
          this.cm2Laras = cm2LarasIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(String cm2JbkodIn,
          String cm2KdrjkIn,
          String cm2NobilIn,
          String cm2NoresIn,
          String cm2AmaunIn,
          String cm2BayarIn,
          String cm2StatfIn,
          String cm2LarasIn) {
          this.cm2Jbkod = cm2JbkodIn;
          this.cm2Kdrjk = cm2KdrjkIn;
          this.cm2Nobil = cm2NobilIn;
          this.cm2Nores = cm2NoresIn;
          this.cm2Amaun = cm2AmaunIn;
          this.cm2Bayar = cm2BayarIn;
          this.cm2Statf = cm2StatfIn;
          this.cm2Laras = cm2LarasIn;
    }


    /** 
     * hasEqualMapping-method will compare two Hlcmk2 instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Hlcmk2 valueObject) {

          if (this.cm2Jbkod == null) {
                    if (valueObject.getCm2Jbkod() != null)
                           return(false);
          } else if (!this.cm2Jbkod.equals(valueObject.getCm2Jbkod())) {
                    return(false);
          }
          if (this.cm2Kdrjk == null) {
                    if (valueObject.getCm2Kdrjk() != null)
                           return(false);
          } else if (!this.cm2Kdrjk.equals(valueObject.getCm2Kdrjk())) {
                    return(false);
          }
          if (this.cm2Nobil == null) {
                    if (valueObject.getCm2Nobil() != null)
                           return(false);
          } else if (!this.cm2Nobil.equals(valueObject.getCm2Nobil())) {
                    return(false);
          }
          if (this.cm2Nores == null) {
                    if (valueObject.getCm2Nores() != null)
                           return(false);
          } else if (!this.cm2Nores.equals(valueObject.getCm2Nores())) {
                    return(false);
          }
          if (this.cm2Amaun == null) {
                    if (valueObject.getCm2Amaun() != null)
                           return(false);
          } else if (!this.cm2Amaun.equals(valueObject.getCm2Amaun())) {
                    return(false);
          }
          if (this.cm2Bayar == null) {
                    if (valueObject.getCm2Bayar() != null)
                           return(false);
          } else if (!this.cm2Bayar.equals(valueObject.getCm2Bayar())) {
                    return(false);
          }
          if (this.cm2Statf == null) {
                    if (valueObject.getCm2Statf() != null)
                           return(false);
          } else if (!this.cm2Statf.equals(valueObject.getCm2Statf())) {
                    return(false);
          }
          if (this.cm2Laras == null) {
                    if (valueObject.getCm2Laras() != null)
                           return(false);
          } else if (!this.cm2Laras.equals(valueObject.getCm2Laras())) {
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
        out.append("\nclass Hlcmk2, mapping to table MTKN.HLCMK2\n");
        out.append("Persistent attributes: \n"); 
        out.append("cm2Jbkod = " + this.cm2Jbkod + "\n"); 
        out.append("cm2Kdrjk = " + this.cm2Kdrjk + "\n"); 
        out.append("cm2Nobil = " + this.cm2Nobil + "\n"); 
        out.append("cm2Nores = " + this.cm2Nores + "\n"); 
        out.append("cm2Amaun = " + this.cm2Amaun + "\n"); 
        out.append("cm2Bayar = " + this.cm2Bayar + "\n"); 
        out.append("cm2Statf = " + this.cm2Statf + "\n"); 
        out.append("cm2Laras = " + this.cm2Laras + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Hlcmk2 cloned = new Hlcmk2();

        if (this.cm2Jbkod != null)
             cloned.setCm2Jbkod(new String(this.cm2Jbkod)); 
        if (this.cm2Kdrjk != null)
             cloned.setCm2Kdrjk(new String(this.cm2Kdrjk)); 
        if (this.cm2Nobil != null)
             cloned.setCm2Nobil(new String(this.cm2Nobil)); 
        if (this.cm2Nores != null)
             cloned.setCm2Nores(new String(this.cm2Nores)); 
        if (this.cm2Amaun != null)
             cloned.setCm2Amaun(new String(this.cm2Amaun)); 
        if (this.cm2Bayar != null)
             cloned.setCm2Bayar(new String(this.cm2Bayar)); 
        if (this.cm2Statf != null)
             cloned.setCm2Statf(new String(this.cm2Statf)); 
        if (this.cm2Laras != null)
             cloned.setCm2Laras(new String(this.cm2Laras)); 
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