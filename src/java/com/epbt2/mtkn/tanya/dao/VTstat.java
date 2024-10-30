package com.epbt2.mtkn.tanya.dao;


import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * VTstat Value Object.
  * This class is value object representing database table MTKN.VTSTAT
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



public class VTstat implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String PYtstatf;
    private String TGkct;
    private String TGkdenda;
    private String TGknotise;
    private String TGkwrn;
    private String TGknod;
    private String CTaksir;
    private String Denda;
    private String NOtise;
    private String WAran;
    private String NOd;
    private String BYrtgkct;
    private String BYrtgkdenda;
    private String BYrtgknotise;
    private String BYrtgkwrn;
    private String BYrtgknod;
    private String BYrctaksir;
    private String BYrdenda;
    private String BYrnotise;
    private String BYrwaran;
    private String Byrnod;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public VTstat () {

    }

    public VTstat (String PYtstatfIn) {

          this.PYtstatf = PYtstatfIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public String getPYtstatf() {
          return this.PYtstatf;
    }
    public void setPYtstatf(String PYtstatfIn) {
          this.PYtstatf = PYtstatfIn;
    }

    public String getTGkct() {
          return this.TGkct;
    }
    public void setTGkct(String TGkctIn) {
          this.TGkct = TGkctIn;
    }

    public String getTGkdenda() {
          return this.TGkdenda;
    }
    public void setTGkdenda(String TGkdendaIn) {
          this.TGkdenda = TGkdendaIn;
    }

    public String getTGknotise() {
          return this.TGknotise;
    }
    public void setTGknotise(String TGknotiseIn) {
          this.TGknotise = TGknotiseIn;
    }

    public String getTGkwrn() {
          return this.TGkwrn;
    }
    public void setTGkwrn(String TGkwrnIn) {
          this.TGkwrn = TGkwrnIn;
    }

    public String getTGknod() {
          return this.TGknod;
    }
    public void setTGknod(String TGknodIn) {
          this.TGknod = TGknodIn;
    }

    public String getCTaksir() {
          return this.CTaksir;
    }
    public void setCTaksir(String CTaksirIn) {
          this.CTaksir = CTaksirIn;
    }

    public String getDenda() {
          return this.Denda;
    }
    public void setDenda(String DendaIn) {
          this.Denda = DendaIn;
    }

    public String getNOtise() {
          return this.NOtise;
    }
    public void setNOtise(String NOtiseIn) {
          this.NOtise = NOtiseIn;
    }

    public String getWAran() {
          return this.WAran;
    }
    public void setWAran(String WAranIn) {
          this.WAran = WAranIn;
    }

    public String getNOd() {
          return this.NOd;
    }
    public void setNOd(String NOdIn) {
          this.NOd = NOdIn;
    }

    public String getBYrtgkct() {
          return this.BYrtgkct;
    }
    public void setBYrtgkct(String BYrtgkctIn) {
          this.BYrtgkct = BYrtgkctIn;
    }

    public String getBYrtgkdenda() {
          return this.BYrtgkdenda;
    }
    public void setBYrtgkdenda(String BYrtgkdendaIn) {
          this.BYrtgkdenda = BYrtgkdendaIn;
    }

    public String getBYrtgknotise() {
          return this.BYrtgknotise;
    }
    public void setBYrtgknotise(String BYrtgknotiseIn) {
          this.BYrtgknotise = BYrtgknotiseIn;
    }

    public String getBYrtgkwrn() {
          return this.BYrtgkwrn;
    }
    public void setBYrtgkwrn(String BYrtgkwrnIn) {
          this.BYrtgkwrn = BYrtgkwrnIn;
    }

    public String getBYrtgknod() {
          return this.BYrtgknod;
    }
    public void setBYrtgknod(String BYrtgknodIn) {
          this.BYrtgknod = BYrtgknodIn;
    }

    public String getBYrctaksir() {
          return this.BYrctaksir;
    }
    public void setBYrctaksir(String BYrctaksirIn) {
          this.BYrctaksir = BYrctaksirIn;
    }

    public String getBYrdenda() {
          return this.BYrdenda;
    }
    public void setBYrdenda(String BYrdendaIn) {
          this.BYrdenda = BYrdendaIn;
    }

    public String getBYrnotise() {
          return this.BYrnotise;
    }
    public void setBYrnotise(String BYrnotiseIn) {
          this.BYrnotise = BYrnotiseIn;
    }

    public String getBYrwaran() {
          return this.BYrwaran;
    }
    public void setBYrwaran(String BYrwaranIn) {
          this.BYrwaran = BYrwaranIn;
    }

    public String getByrnod() {
          return this.Byrnod;
    }
    public void setByrnod(String ByrnodIn) {
          this.Byrnod = ByrnodIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(String PYtstatfIn,
          String TGkctIn,
          String TGkdendaIn,
          String TGknotiseIn,
          String TGkwrnIn,
          String TGknodIn,
          String CTaksirIn,
          String DendaIn,
          String NOtiseIn,
          String WAranIn,
          String NOdIn,
          String BYrtgkctIn,
          String BYrtgkdendaIn,
          String BYrtgknotiseIn,
          String BYrtgkwrnIn,
          String BYrtgknodIn,
          String BYrctaksirIn,
          String BYrdendaIn,
          String BYrnotiseIn,
          String BYrwaranIn,
          String ByrnodIn) {
          this.PYtstatf = PYtstatfIn;
          this.TGkct = TGkctIn;
          this.TGkdenda = TGkdendaIn;
          this.TGknotise = TGknotiseIn;
          this.TGkwrn = TGkwrnIn;
          this.TGknod = TGknodIn;
          this.CTaksir = CTaksirIn;
          this.Denda = DendaIn;
          this.NOtise = NOtiseIn;
          this.WAran = WAranIn;
          this.NOd = NOdIn;
          this.BYrtgkct = BYrtgkctIn;
          this.BYrtgkdenda = BYrtgkdendaIn;
          this.BYrtgknotise = BYrtgknotiseIn;
          this.BYrtgkwrn = BYrtgkwrnIn;
          this.BYrtgknod = BYrtgknodIn;
          this.BYrctaksir = BYrctaksirIn;
          this.BYrdenda = BYrdendaIn;
          this.BYrnotise = BYrnotiseIn;
          this.BYrwaran = BYrwaranIn;
          this.Byrnod = ByrnodIn;
    }


    /** 
     * hasEqualMapping-method will compare two VTstat instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(VTstat valueObject) {

          if (this.PYtstatf == null) {
                    if (valueObject.getPYtstatf() != null)
                           return(false);
          } else if (!this.PYtstatf.equals(valueObject.getPYtstatf())) {
                    return(false);
          }
          if (this.TGkct == null) {
                    if (valueObject.getTGkct() != null)
                           return(false);
          } else if (!this.TGkct.equals(valueObject.getTGkct())) {
                    return(false);
          }
          if (this.TGkdenda == null) {
                    if (valueObject.getTGkdenda() != null)
                           return(false);
          } else if (!this.TGkdenda.equals(valueObject.getTGkdenda())) {
                    return(false);
          }
          if (this.TGknotise == null) {
                    if (valueObject.getTGknotise() != null)
                           return(false);
          } else if (!this.TGknotise.equals(valueObject.getTGknotise())) {
                    return(false);
          }
          if (this.TGkwrn == null) {
                    if (valueObject.getTGkwrn() != null)
                           return(false);
          } else if (!this.TGkwrn.equals(valueObject.getTGkwrn())) {
                    return(false);
          }
          if (this.TGknod == null) {
                    if (valueObject.getTGknod() != null)
                           return(false);
          } else if (!this.TGknod.equals(valueObject.getTGknod())) {
                    return(false);
          }
          if (this.CTaksir == null) {
                    if (valueObject.getCTaksir() != null)
                           return(false);
          } else if (!this.CTaksir.equals(valueObject.getCTaksir())) {
                    return(false);
          }
          if (this.Denda == null) {
                    if (valueObject.getDenda() != null)
                           return(false);
          } else if (!this.Denda.equals(valueObject.getDenda())) {
                    return(false);
          }
          if (this.NOtise == null) {
                    if (valueObject.getNOtise() != null)
                           return(false);
          } else if (!this.NOtise.equals(valueObject.getNOtise())) {
                    return(false);
          }
          if (this.WAran == null) {
                    if (valueObject.getWAran() != null)
                           return(false);
          } else if (!this.WAran.equals(valueObject.getWAran())) {
                    return(false);
          }
          if (this.NOd == null) {
                    if (valueObject.getNOd() != null)
                           return(false);
          } else if (!this.NOd.equals(valueObject.getNOd())) {
                    return(false);
          }
          if (this.BYrtgkct == null) {
                    if (valueObject.getBYrtgkct() != null)
                           return(false);
          } else if (!this.BYrtgkct.equals(valueObject.getBYrtgkct())) {
                    return(false);
          }
          if (this.BYrtgkdenda == null) {
                    if (valueObject.getBYrtgkdenda() != null)
                           return(false);
          } else if (!this.BYrtgkdenda.equals(valueObject.getBYrtgkdenda())) {
                    return(false);
          }
          if (this.BYrtgknotise == null) {
                    if (valueObject.getBYrtgknotise() != null)
                           return(false);
          } else if (!this.BYrtgknotise.equals(valueObject.getBYrtgknotise())) {
                    return(false);
          }
          if (this.BYrtgkwrn == null) {
                    if (valueObject.getBYrtgkwrn() != null)
                           return(false);
          } else if (!this.BYrtgkwrn.equals(valueObject.getBYrtgkwrn())) {
                    return(false);
          }
          if (this.BYrtgknod == null) {
                    if (valueObject.getBYrtgknod() != null)
                           return(false);
          } else if (!this.BYrtgknod.equals(valueObject.getBYrtgknod())) {
                    return(false);
          }
          if (this.BYrctaksir == null) {
                    if (valueObject.getBYrctaksir() != null)
                           return(false);
          } else if (!this.BYrctaksir.equals(valueObject.getBYrctaksir())) {
                    return(false);
          }
          if (this.BYrdenda == null) {
                    if (valueObject.getBYrdenda() != null)
                           return(false);
          } else if (!this.BYrdenda.equals(valueObject.getBYrdenda())) {
                    return(false);
          }
          if (this.BYrnotise == null) {
                    if (valueObject.getBYrnotise() != null)
                           return(false);
          } else if (!this.BYrnotise.equals(valueObject.getBYrnotise())) {
                    return(false);
          }
          if (this.BYrwaran == null) {
                    if (valueObject.getBYrwaran() != null)
                           return(false);
          } else if (!this.BYrwaran.equals(valueObject.getBYrwaran())) {
                    return(false);
          }
          if (this.Byrnod == null) {
                    if (valueObject.getByrnod() != null)
                           return(false);
          } else if (!this.Byrnod.equals(valueObject.getByrnod())) {
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
        out.append("\nclass VTstat, mapping to table MTKN.VTSTAT\n");
        out.append("Persistent attributes: \n"); 
        out.append("PYtstatf = " + this.PYtstatf + "\n"); 
        out.append("TGkct = " + this.TGkct + "\n"); 
        out.append("TGkdenda = " + this.TGkdenda + "\n"); 
        out.append("TGknotise = " + this.TGknotise + "\n"); 
        out.append("TGkwrn = " + this.TGkwrn + "\n"); 
        out.append("TGknod = " + this.TGknod + "\n"); 
        out.append("CTaksir = " + this.CTaksir + "\n"); 
        out.append("Denda = " + this.Denda + "\n"); 
        out.append("NOtise = " + this.NOtise + "\n"); 
        out.append("WAran = " + this.WAran + "\n"); 
        out.append("NOd = " + this.NOd + "\n"); 
        out.append("BYrtgkct = " + this.BYrtgkct + "\n"); 
        out.append("BYrtgkdenda = " + this.BYrtgkdenda + "\n"); 
        out.append("BYrtgknotise = " + this.BYrtgknotise + "\n"); 
        out.append("BYrtgkwrn = " + this.BYrtgkwrn + "\n"); 
        out.append("BYrtgknod = " + this.BYrtgknod + "\n"); 
        out.append("BYrctaksir = " + this.BYrctaksir + "\n"); 
        out.append("BYrdenda = " + this.BYrdenda + "\n"); 
        out.append("BYrnotise = " + this.BYrnotise + "\n"); 
        out.append("BYrwaran = " + this.BYrwaran + "\n"); 
        out.append("Byrnod = " + this.Byrnod + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        VTstat cloned = new VTstat();

        if (this.PYtstatf != null)
             cloned.setPYtstatf(new String(this.PYtstatf)); 
        if (this.TGkct != null)
             cloned.setTGkct(new String(this.TGkct)); 
        if (this.TGkdenda != null)
             cloned.setTGkdenda(new String(this.TGkdenda)); 
        if (this.TGknotise != null)
             cloned.setTGknotise(new String(this.TGknotise)); 
        if (this.TGkwrn != null)
             cloned.setTGkwrn(new String(this.TGkwrn)); 
        if (this.TGknod != null)
             cloned.setTGknod(new String(this.TGknod)); 
        if (this.CTaksir != null)
             cloned.setCTaksir(new String(this.CTaksir)); 
        if (this.Denda != null)
             cloned.setDenda(new String(this.Denda)); 
        if (this.NOtise != null)
             cloned.setNOtise(new String(this.NOtise)); 
        if (this.WAran != null)
             cloned.setWAran(new String(this.WAran)); 
        if (this.NOd != null)
             cloned.setNOd(new String(this.NOd)); 
        if (this.BYrtgkct != null)
             cloned.setBYrtgkct(new String(this.BYrtgkct)); 
        if (this.BYrtgkdenda != null)
             cloned.setBYrtgkdenda(new String(this.BYrtgkdenda)); 
        if (this.BYrtgknotise != null)
             cloned.setBYrtgknotise(new String(this.BYrtgknotise)); 
        if (this.BYrtgkwrn != null)
             cloned.setBYrtgkwrn(new String(this.BYrtgkwrn)); 
        if (this.BYrtgknod != null)
             cloned.setBYrtgknod(new String(this.BYrtgknod)); 
        if (this.BYrctaksir != null)
             cloned.setBYrctaksir(new String(this.BYrctaksir)); 
        if (this.BYrdenda != null)
             cloned.setBYrdenda(new String(this.BYrdenda)); 
        if (this.BYrnotise != null)
             cloned.setBYrnotise(new String(this.BYrnotise)); 
        if (this.BYrwaran != null)
             cloned.setBYrwaran(new String(this.BYrwaran)); 
        if (this.Byrnod != null)
             cloned.setByrnod(new String(this.Byrnod)); 
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