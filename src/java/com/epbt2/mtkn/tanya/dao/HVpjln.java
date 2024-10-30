
package com.epbt2.mtkn.tanya.dao;


import java.io.*;

 /**
  * HVpjln Value Object.
  * This class is value object representing database table MTKN.HVPJLN
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



public class HVpjln implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String JLkod;
    private String JNama;
    private String AKtif;
    private String BAtal;
    
    /* BYE 23/06/2016 */
    private String status;
    private String bil;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBil() {
        return bil;
    }

    public void setBil(String bil) {
        this.bil = bil;
    }
        
    /* BYE 23/06/2016 */



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public HVpjln () {

    }

    public HVpjln (String JLkodIn) {

          this.JLkod = JLkodIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public String getJLkod() {
          return this.JLkod;
    }
    public void setJLkod(String JLkodIn) {
          this.JLkod = JLkodIn;
    }

    public String getJNama() {
          return this.JNama;
    }
    public void setJNama(String JNamaIn) {
          this.JNama = JNamaIn;
    }

    public String getAKtif() {
          return this.AKtif;
    }
    public void setAKtif(String AKtifIn) {
          this.AKtif = AKtifIn;
    }

    public String getBAtal() {
          return this.BAtal;
    }
    public void setBAtal(String BAtalIn) {
          this.BAtal = BAtalIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(String JLkodIn,
          String JNamaIn,
          String AKtifIn,
          String BAtalIn) {
          this.JLkod = JLkodIn;
          this.JNama = JNamaIn;
          this.AKtif = AKtifIn;
          this.BAtal = BAtalIn;
    }


    /** 
     * hasEqualMapping-method will compare two HVpjln instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(HVpjln valueObject) {

          if (this.JLkod == null) {
                    if (valueObject.getJLkod() != null)
                           return(false);
          } else if (!this.JLkod.equals(valueObject.getJLkod())) {
                    return(false);
          }
          if (this.JNama == null) {
                    if (valueObject.getJNama() != null)
                           return(false);
          } else if (!this.JNama.equals(valueObject.getJNama())) {
                    return(false);
          }
          if (this.AKtif == null) {
                    if (valueObject.getAKtif() != null)
                           return(false);
          } else if (!this.AKtif.equals(valueObject.getAKtif())) {
                    return(false);
          }
          if (this.BAtal == null) {
                    if (valueObject.getBAtal() != null)
                           return(false);
          } else if (!this.BAtal.equals(valueObject.getBAtal())) {
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
        out.append("\nclass HVpjln, mapping to table MTKN.HVPJLN\n");
        out.append("Persistent attributes: \n"); 
        out.append("JLkod = " + this.JLkod + "\n"); 
        out.append("JNama = " + this.JNama + "\n"); 
        out.append("AKtif = " + this.AKtif + "\n"); 
        out.append("BAtal = " + this.BAtal + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        HVpjln cloned = new HVpjln();

        if (this.JLkod != null)
             cloned.setJLkod(new String(this.JLkod)); 
        if (this.JNama != null)
             cloned.setJNama(new String(this.JNama)); 
        if (this.AKtif != null)
             cloned.setAKtif(new String(this.AKtif)); 
        if (this.BAtal != null)
             cloned.setBAtal(new String(this.BAtal)); 
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
