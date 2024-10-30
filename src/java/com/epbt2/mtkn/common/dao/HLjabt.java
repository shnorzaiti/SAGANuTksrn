package com.epbt2.mtkn.common.dao;

import java.io.Serializable;




 /**
  * HLjabt Value Object.
  * This class is value object representing database table hljabt
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



public class HLjabt implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String jabJbkod;
    private String jabJnama;
    private String JabAlam1;
    private String JabAlam2;
    private String JabAlam3;
    private String JabAlam4;
    
    private String JpkJnama;
    
    //tambahan popup
    private String carian;
    private String fieldCarian;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public HLjabt () {

    }

    public HLjabt (String jabJbkodIn) {

          this.jabJbkod = jabJbkodIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public String getJabJbkod() {
          return this.jabJbkod;
    }
    public void setJabJbkod(String jabJbkodIn) {
          this.jabJbkod = jabJbkodIn;
    }

    public String getJabJnama() {
          return this.jabJnama;
    }
    public void setJabJnama(String jabJnamaIn) {
          this.jabJnama = jabJnamaIn;
    }

    public String getJabAlam1() {
          return this.JabAlam1;
    }
    public void setJabAlam1(String JabAlam1In) {
          this.JabAlam1 = JabAlam1In;
    }

    public String getJabAlam2() {
          return this.JabAlam2;
    }
    public void setJabAlam2(String JabAlam2In) {
          this.JabAlam2 = JabAlam2In;
    }

    public String getJabAlam3() {
          return this.JabAlam3;
    }
    public void setJabAlam3(String JabAlam3In) {
          this.JabAlam3 = JabAlam3In;
    }

    public String getJabAlam4() {
          return this.JabAlam4;
    }
    public void setJabAlam4(String JabAlam4In) {
          this.JabAlam4 = JabAlam4In;
    }
    
    public String getJpkJnama() {
          return this.JpkJnama;
    }
    public void setJpkJnama(String JpkJnamaIn) {
          this.JpkJnama = JpkJnamaIn;
    }

    public String getCarian() {
        return carian;
    }

    public void setCarian(String carian) {
        this.carian = carian;
    }

    public String getFieldCarian() {
        return fieldCarian;
    }

    public void setFieldCarian(String fieldCarian) {
        this.fieldCarian = fieldCarian;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(String jabJbkodIn,
          String jabJnamaIn,
          String JabAlam1In,
          String JabAlam2In,
          String JabAlam3In,
          String JabAlam4In) {
          this.jabJbkod = jabJbkodIn;
          this.jabJnama = jabJnamaIn;
          this.JabAlam1 = JabAlam1In;
          this.JabAlam2 = JabAlam2In;
          this.JabAlam3 = JabAlam3In;
          this.JabAlam4 = JabAlam4In;
    }


    /** 
     * hasEqualMapping-method will compare two HLjabt instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(HLjabt valueObject) {

          if (this.jabJbkod == null) {
                    if (valueObject.getJabJbkod() != null)
                           return(false);
          } else if (!this.jabJbkod.equals(valueObject.getJabJbkod())) {
                    return(false);
          }
          if (this.jabJnama == null) {
                    if (valueObject.getJabJnama() != null)
                           return(false);
          } else if (!this.jabJnama.equals(valueObject.getJabJnama())) {
                    return(false);
          }
          if (this.JabAlam1 == null) {
                    if (valueObject.getJabAlam1() != null)
                           return(false);
          } else if (!this.JabAlam1.equals(valueObject.getJabAlam1())) {
                    return(false);
          }
          if (this.JabAlam2 == null) {
                    if (valueObject.getJabAlam2() != null)
                           return(false);
          } else if (!this.JabAlam2.equals(valueObject.getJabAlam2())) {
                    return(false);
          }
          if (this.JabAlam3 == null) {
                    if (valueObject.getJabAlam3() != null)
                           return(false);
          } else if (!this.JabAlam3.equals(valueObject.getJabAlam3())) {
                    return(false);
          }
          if (this.JabAlam4 == null) {
                    if (valueObject.getJabAlam4() != null)
                           return(false);
          } else if (!this.JabAlam4.equals(valueObject.getJabAlam4())) {
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
        out.append("\nclass HLjabt, mapping to table hljabt\n");
        out.append("Persistent attributes: \n"); 
        out.append("jabJbkod = " + this.jabJbkod + "\n"); 
        out.append("jabJnama = " + this.jabJnama + "\n"); 
        out.append("JabAlam1 = " + this.JabAlam1 + "\n"); 
        out.append("JabAlam2 = " + this.JabAlam2 + "\n"); 
        out.append("JabAlam3 = " + this.JabAlam3 + "\n"); 
        out.append("JabAlam4 = " + this.JabAlam4 + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        HLjabt cloned = new HLjabt();

        if (this.jabJbkod != null)
             cloned.setJabJbkod(new String(this.jabJbkod)); 
        if (this.jabJnama != null)
             cloned.setJabJnama(new String(this.jabJnama)); 
        if (this.JabAlam1 != null)
             cloned.setJabAlam1(new String(this.JabAlam1)); 
        if (this.JabAlam2 != null)
             cloned.setJabAlam2(new String(this.JabAlam2)); 
        if (this.JabAlam3 != null)
             cloned.setJabAlam3(new String(this.JabAlam3)); 
        if (this.JabAlam4 != null)
             cloned.setJabAlam4(new String(this.JabAlam4)); 
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
