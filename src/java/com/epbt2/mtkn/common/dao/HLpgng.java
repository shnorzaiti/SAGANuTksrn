package com.epbt2.mtkn.common.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

/**
 *
 * @author NurMuhammadAfzal
 */
public class HLpgng implements Cloneable, Serializable {

    /**
     * Persistent Instance variables. This data is directly mapped to the
     * columns of database table.
     */
    private String PEgakaun;
    private String PEgdigit;
    private String PEgjlkod;
    private String PEgthkod;
    private String PEghtkod;
    private String PEgjpkod;
    private String PEgbgkod;
    private String PEgstkod;
    private String PEgnolot;
    private String PEgbllot;
    private String PEgnompt;
    private String PEgpelan;
    private String PEgadpg1;
    private String PEgtkhoc;
    private String PEgtkhtk;
    private String PEgtkhpl;
    private String PEgnilth;
    private String PEgbilpk;
    private String PEglsbgn;
    private String PEglstnh;
    private String PEgrjfil;
    private String PEgrjmmk;
    private String PEgstatf;
    private String PEgoldac;
    private String PEgstatk;
    private String PEgstcbk;
    private String PEgonama;
    private String PEglsans;
    private String PEgadpg2;
    private String PEgaklsn;
    private String PEgakswn;
    private String PEgakpbg;
    
    private String PMkakaun;
    private String PMknmbil;
    
    //tmbahan popup
    private String carian;
    private String fieldCarian;
    private String pmkNmbil;
    private String akaun;
    private String digit;
    private String nmbil;

    /* BYE 05/08/2014 */
    private String tksir;

    public String getTksir() {
        return tksir;
    }

    public void setTksir(String tksir) {
        this.tksir = tksir;
    }

    /* BYE 05/08/2014 */
    //Tmbahan Popup -chai-
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

    public String getPmkNmbil() {
        return pmkNmbil;
    }

    public void setPmkNmbil(String pmkNmbil) {
        this.pmkNmbil = pmkNmbil;
    }

    public String getAkaun() {
        return akaun;
    }

    public void setAkaun(String akaun) {
        this.akaun = akaun;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public String getNmbil() {
        return nmbil;
    }

    public void setNmbil(String nmbil) {
        this.nmbil = nmbil;
    }

    public String getPMkakaun() {
        return PMkakaun;
    }

    public void setPMkakaun(String PMkakaun) {
        this.PMkakaun = PMkakaun;
    }

    public String getPMknmbil() {
        return PMknmbil;
    }

    public void setPMknmbil(String PMknmbil) {
        this.PMknmbil = PMknmbil;
    }
    
    
    
    
 

    /**
     * Constructors. DaoGen generates two constructors by default. The first one
     * takes no arguments and provides the most simple way to create object
     * instance. The another one takes one argument, which is the primary key of
     * the corresponding table.
     */
    public HLpgng() {

    }

    public HLpgng(String PEgakaunIn) {

        this.PEgakaun = PEgakaunIn;

    }

    /**
     * Get- and Set-methods for persistent variables. The default behaviour does
     * not make any checks against malformed data, so these might require some
     * manual additions.
     */
    public String getPEgakaun() {
        return this.PEgakaun;
    }

    public void setPEgakaun(String PEgakaunIn) {
        this.PEgakaun = PEgakaunIn;
    }

    public String getPEgdigit() {
        return this.PEgdigit;
    }

    public void setPEgdigit(String PEgdigitIn) {
        this.PEgdigit = PEgdigitIn;
    }

    public String getPEgjlkod() {
        return this.PEgjlkod;
    }

    public void setPEgjlkod(String PEgjlkodIn) {
        this.PEgjlkod = PEgjlkodIn;
    }

    public String getPEgthkod() {
        return this.PEgthkod;
    }

    public void setPEgthkod(String PEgthkodIn) {
        this.PEgthkod = PEgthkodIn;
    }

    public String getPEghtkod() {
        return this.PEghtkod;
    }

    public void setPEghtkod(String PEghtkodIn) {
        this.PEghtkod = PEghtkodIn;
    }

    public String getPEgjpkod() {
        return this.PEgjpkod;
    }

    public void setPEgjpkod(String PEgjpkodIn) {
        this.PEgjpkod = PEgjpkodIn;
    }

    public String getPEgbgkod() {
        return this.PEgbgkod;
    }

    public void setPEgbgkod(String PEgbgkodIn) {
        this.PEgbgkod = PEgbgkodIn;
    }

    public String getPEgstkod() {
        return this.PEgstkod;
    }

    public void setPEgstkod(String PEgstkodIn) {
        this.PEgstkod = PEgstkodIn;
    }

    public String getPEgnolot() {
        return this.PEgnolot;
    }

    public void setPEgnolot(String PEgnolotIn) {
        this.PEgnolot = PEgnolotIn;
    }

    public String getPEgbllot() {
        return this.PEgbllot;
    }

    public void setPEgbllot(String PEgbllotIn) {
        this.PEgbllot = PEgbllotIn;
    }

    public String getPEgnompt() {
        return this.PEgnompt;
    }

    public void setPEgnompt(String PEgnomptIn) {
        this.PEgnompt = PEgnomptIn;
    }

    public String getPEgpelan() {
        return this.PEgpelan;
    }

    public void setPEgpelan(String PEgpelanIn) {
        this.PEgpelan = PEgpelanIn;
    }

    public String getPEgadpg1() {
        return this.PEgadpg1;
    }

    public void setPEgadpg1(String PEgadpg1In) {
        this.PEgadpg1 = PEgadpg1In;
    }

    public String getPEgtkhoc() {
        return this.PEgtkhoc;
    }

    public void setPEgtkhoc(String PEgtkhocIn) {
        this.PEgtkhoc = PEgtkhocIn;
    }

    public String getPEgtkhtk() {
        return this.PEgtkhtk;
    }

    public void setPEgtkhtk(String PEgtkhtkIn) {
        this.PEgtkhtk = PEgtkhtkIn;
    }

    public String getPEgtkhpl() {
        return this.PEgtkhpl;
    }

    public void setPEgtkhpl(String PEgtkhplIn) {
        this.PEgtkhpl = PEgtkhplIn;
    }

    public String getPEgnilth() {
        return this.PEgnilth;
    }

    public void setPEgnilth(String PEgnilthIn) {
        this.PEgnilth = PEgnilthIn;
    }

    public String getPEgbilpk() {
        return this.PEgbilpk;
    }

    public void setPEgbilpk(String PEgbilpkIn) {
        this.PEgbilpk = PEgbilpkIn;
    }

    public String getPEglsbgn() {
        return this.PEglsbgn;
    }

    public void setPEglsbgn(String PEglsbgnIn) {
        this.PEglsbgn = PEglsbgnIn;
    }

    public String getPEglstnh() {
        return this.PEglstnh;
    }

    public void setPEglstnh(String PEglstnhIn) {
        this.PEglstnh = PEglstnhIn;
    }

    public String getPEgrjfil() {
        return this.PEgrjfil;
    }

    public void setPEgrjfil(String PEgrjfilIn) {
        this.PEgrjfil = PEgrjfilIn;
    }

    public String getPEgrjmmk() {
        return this.PEgrjmmk;
    }

    public void setPEgrjmmk(String PEgrjmmkIn) {
        this.PEgrjmmk = PEgrjmmkIn;
    }

    public String getPEgstatf() {
        return this.PEgstatf;
    }

    public void setPEgstatf(String PEgstatfIn) {
        this.PEgstatf = PEgstatfIn;
    }

    public String getPEgoldac() {
        return this.PEgoldac;
    }

    public void setPEgoldac(String PEgoldacIn) {
        this.PEgoldac = PEgoldacIn;
    }

    public String getPEgstatk() {
        return this.PEgstatk;
    }

    public void setPEgstatk(String PEgstatkIn) {
        this.PEgstatk = PEgstatkIn;
    }

    public String getPEgstcbk() {
        return this.PEgstcbk;
    }

    public void setPEgstcbk(String PEgstcbkIn) {
        this.PEgstcbk = PEgstcbkIn;
    }

    public String getPEgonama() {
        return this.PEgonama;
    }

    public void setPEgonama(String PEgonamaIn) {
        this.PEgonama = PEgonamaIn;
    }

    public String getPEglsans() {
        return this.PEglsans;
    }

    public void setPEglsans(String PEglsansIn) {
        this.PEglsans = PEglsansIn;
    }

    public String getPEgadpg2() {
        return this.PEgadpg2;
    }

    public void setPEgadpg2(String PEgadpg2In) {
        this.PEgadpg2 = PEgadpg2In;
    }

    public String getPEgaklsn() {
        return this.PEgaklsn;
    }

    public void setPEgaklsn(String PEgaklsnIn) {
        this.PEgaklsn = PEgaklsnIn;
    }

    public String getPEgakswn() {
        return this.PEgakswn;
    }

    public void setPEgakswn(String PEgakswnIn) {
        this.PEgakswn = PEgakswnIn;
    }

    public String getPEgakpbg() {
        return this.PEgakpbg;
    }

    public void setPEgakpbg(String PEgakpbgIn) {
        this.PEgakpbg = PEgakpbgIn;
    }

    /**
     * setAll allows to set all persistent variables in one method call. This is
     * useful, when all data is available and it is needed to set the initial
     * state of this object. Note that this method will directly modify instance
     * variales, without going trough the individual set-methods.
     */
    public void setAll(String PEgakaunIn,
            String PEgdigitIn,
            String PEgjlkodIn,
            String PEgthkodIn,
            String PEghtkodIn,
            String PEgjpkodIn,
            String PEgbgkodIn,
            String PEgstkodIn,
            String PEgnolotIn,
            String PEgbllotIn,
            String PEgnomptIn,
            String PEgpelanIn,
            String PEgadpg1In,
            String PEgtkhocIn,
            String PEgtkhtkIn,
            String PEgtkhplIn,
            String PEgnilthIn,
            String PEgbilpkIn,
            String PEglsbgnIn,
            String PEglstnhIn,
            String PEgrjfilIn,
            String PEgrjmmkIn,
            String PEgstatfIn,
            String PEgoldacIn,
            String PEgstatkIn,
            String PEgstcbkIn,
            String PEgonamaIn,
            String PEglsansIn,
            String PEgadpg2In,
            String PEgaklsnIn,
            String PEgakswnIn,
            String PEgakpbgIn) {
        this.PEgakaun = PEgakaunIn;
        this.PEgdigit = PEgdigitIn;
        this.PEgjlkod = PEgjlkodIn;
        this.PEgthkod = PEgthkodIn;
        this.PEghtkod = PEghtkodIn;
        this.PEgjpkod = PEgjpkodIn;
        this.PEgbgkod = PEgbgkodIn;
        this.PEgstkod = PEgstkodIn;
        this.PEgnolot = PEgnolotIn;
        this.PEgbllot = PEgbllotIn;
        this.PEgnompt = PEgnomptIn;
        this.PEgpelan = PEgpelanIn;
        this.PEgadpg1 = PEgadpg1In;
        this.PEgtkhoc = PEgtkhocIn;
        this.PEgtkhtk = PEgtkhtkIn;
        this.PEgtkhpl = PEgtkhplIn;
        this.PEgnilth = PEgnilthIn;
        this.PEgbilpk = PEgbilpkIn;
        this.PEglsbgn = PEglsbgnIn;
        this.PEglstnh = PEglstnhIn;
        this.PEgrjfil = PEgrjfilIn;
        this.PEgrjmmk = PEgrjmmkIn;
        this.PEgstatf = PEgstatfIn;
        this.PEgoldac = PEgoldacIn;
        this.PEgstatk = PEgstatkIn;
        this.PEgstcbk = PEgstcbkIn;
        this.PEgonama = PEgonamaIn;
        this.PEglsans = PEglsansIn;
        this.PEgadpg2 = PEgadpg2In;
        this.PEgaklsn = PEgaklsnIn;
        this.PEgakswn = PEgakswnIn;
        this.PEgakpbg = PEgakpbgIn;
    }

    /**
     * hasEqualMapping-method will compare two HLpgng instances and return true
     * if they contain same values in all persistent instance variables. If
     * hasEqualMapping returns true, it does not mean the objects are the same
     * instance. However it does mean that in that moment, they are mapped to
     * the same row in database.
     */
    public boolean hasEqualMapping(HLpgng valueObject) {

        if (this.PEgakaun == null) {
            if (valueObject.getPEgakaun() != null) {
                return (false);
            }
        } else if (!this.PEgakaun.equals(valueObject.getPEgakaun())) {
            return (false);
        }
        if (this.PEgdigit == null) {
            if (valueObject.getPEgdigit() != null) {
                return (false);
            }
        } else if (!this.PEgdigit.equals(valueObject.getPEgdigit())) {
            return (false);
        }
        if (this.PEgjlkod == null) {
            if (valueObject.getPEgjlkod() != null) {
                return (false);
            }
        } else if (!this.PEgjlkod.equals(valueObject.getPEgjlkod())) {
            return (false);
        }
        if (this.PEgthkod == null) {
            if (valueObject.getPEgthkod() != null) {
                return (false);
            }
        } else if (!this.PEgthkod.equals(valueObject.getPEgthkod())) {
            return (false);
        }
        if (this.PEghtkod == null) {
            if (valueObject.getPEghtkod() != null) {
                return (false);
            }
        } else if (!this.PEghtkod.equals(valueObject.getPEghtkod())) {
            return (false);
        }
        if (this.PEgjpkod == null) {
            if (valueObject.getPEgjpkod() != null) {
                return (false);
            }
        } else if (!this.PEgjpkod.equals(valueObject.getPEgjpkod())) {
            return (false);
        }
        if (this.PEgbgkod == null) {
            if (valueObject.getPEgbgkod() != null) {
                return (false);
            }
        } else if (!this.PEgbgkod.equals(valueObject.getPEgbgkod())) {
            return (false);
        }
        if (this.PEgstkod == null) {
            if (valueObject.getPEgstkod() != null) {
                return (false);
            }
        } else if (!this.PEgstkod.equals(valueObject.getPEgstkod())) {
            return (false);
        }
        if (this.PEgnolot == null) {
            if (valueObject.getPEgnolot() != null) {
                return (false);
            }
        } else if (!this.PEgnolot.equals(valueObject.getPEgnolot())) {
            return (false);
        }
        if (this.PEgbllot == null) {
            if (valueObject.getPEgbllot() != null) {
                return (false);
            }
        } else if (!this.PEgbllot.equals(valueObject.getPEgbllot())) {
            return (false);
        }
        if (this.PEgnompt == null) {
            if (valueObject.getPEgnompt() != null) {
                return (false);
            }
        } else if (!this.PEgnompt.equals(valueObject.getPEgnompt())) {
            return (false);
        }
        if (this.PEgpelan == null) {
            if (valueObject.getPEgpelan() != null) {
                return (false);
            }
        } else if (!this.PEgpelan.equals(valueObject.getPEgpelan())) {
            return (false);
        }
        if (this.PEgadpg1 == null) {
            if (valueObject.getPEgadpg1() != null) {
                return (false);
            }
        } else if (!this.PEgadpg1.equals(valueObject.getPEgadpg1())) {
            return (false);
        }
        if (this.PEgtkhoc == null) {
            if (valueObject.getPEgtkhoc() != null) {
                return (false);
            }
        } else if (!this.PEgtkhoc.equals(valueObject.getPEgtkhoc())) {
            return (false);
        }
        if (this.PEgtkhtk == null) {
            if (valueObject.getPEgtkhtk() != null) {
                return (false);
            }
        } else if (!this.PEgtkhtk.equals(valueObject.getPEgtkhtk())) {
            return (false);
        }
        if (this.PEgtkhpl == null) {
            if (valueObject.getPEgtkhpl() != null) {
                return (false);
            }
        } else if (!this.PEgtkhpl.equals(valueObject.getPEgtkhpl())) {
            return (false);
        }
        if (this.PEgnilth == null) {
            if (valueObject.getPEgnilth() != null) {
                return (false);
            }
        } else if (!this.PEgnilth.equals(valueObject.getPEgnilth())) {
            return (false);
        }
        if (this.PEgbilpk == null) {
            if (valueObject.getPEgbilpk() != null) {
                return (false);
            }
        } else if (!this.PEgbilpk.equals(valueObject.getPEgbilpk())) {
            return (false);
        }
        if (this.PEglsbgn == null) {
            if (valueObject.getPEglsbgn() != null) {
                return (false);
            }
        } else if (!this.PEglsbgn.equals(valueObject.getPEglsbgn())) {
            return (false);
        }
        if (this.PEglstnh == null) {
            if (valueObject.getPEglstnh() != null) {
                return (false);
            }
        } else if (!this.PEglstnh.equals(valueObject.getPEglstnh())) {
            return (false);
        }
        if (this.PEgrjfil == null) {
            if (valueObject.getPEgrjfil() != null) {
                return (false);
            }
        } else if (!this.PEgrjfil.equals(valueObject.getPEgrjfil())) {
            return (false);
        }
        if (this.PEgrjmmk == null) {
            if (valueObject.getPEgrjmmk() != null) {
                return (false);
            }
        } else if (!this.PEgrjmmk.equals(valueObject.getPEgrjmmk())) {
            return (false);
        }
        if (this.PEgstatf == null) {
            if (valueObject.getPEgstatf() != null) {
                return (false);
            }
        } else if (!this.PEgstatf.equals(valueObject.getPEgstatf())) {
            return (false);
        }
        if (this.PEgoldac == null) {
            if (valueObject.getPEgoldac() != null) {
                return (false);
            }
        } else if (!this.PEgoldac.equals(valueObject.getPEgoldac())) {
            return (false);
        }
        if (this.PEgstatk == null) {
            if (valueObject.getPEgstatk() != null) {
                return (false);
            }
        } else if (!this.PEgstatk.equals(valueObject.getPEgstatk())) {
            return (false);
        }
        if (this.PEgstcbk == null) {
            if (valueObject.getPEgstcbk() != null) {
                return (false);
            }
        } else if (!this.PEgstcbk.equals(valueObject.getPEgstcbk())) {
            return (false);
        }
        if (this.PEgonama == null) {
            if (valueObject.getPEgonama() != null) {
                return (false);
            }
        } else if (!this.PEgonama.equals(valueObject.getPEgonama())) {
            return (false);
        }
        if (this.PEglsans == null) {
            if (valueObject.getPEglsans() != null) {
                return (false);
            }
        } else if (!this.PEglsans.equals(valueObject.getPEglsans())) {
            return (false);
        }
        if (this.PEgadpg2 == null) {
            if (valueObject.getPEgadpg2() != null) {
                return (false);
            }
        } else if (!this.PEgadpg2.equals(valueObject.getPEgadpg2())) {
            return (false);
        }
        if (this.PEgaklsn == null) {
            if (valueObject.getPEgaklsn() != null) {
                return (false);
            }
        } else if (!this.PEgaklsn.equals(valueObject.getPEgaklsn())) {
            return (false);
        }
        if (this.PEgakswn == null) {
            if (valueObject.getPEgakswn() != null) {
                return (false);
            }
        } else if (!this.PEgakswn.equals(valueObject.getPEgakswn())) {
            return (false);
        }
        if (this.PEgakpbg == null) {
            if (valueObject.getPEgakpbg() != null) {
                return (false);
            }
        } else if (!this.PEgakpbg.equals(valueObject.getPEgakpbg())) {
            return (false);
        }

        return true;
    }

    /**
     * toString will return String object representing the state of this
     * valueObject. This is useful during application development, and possibly
     * when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass HLpgng, mapping to table HLPGNG\n");
        out.append("Persistent attributes: \n");
        out.append("PEgakaun = " + this.PEgakaun + "\n");
        out.append("PEgdigit = " + this.PEgdigit + "\n");
        out.append("PEgjlkod = " + this.PEgjlkod + "\n");
        out.append("PEgthkod = " + this.PEgthkod + "\n");
        out.append("PEghtkod = " + this.PEghtkod + "\n");
        out.append("PEgjpkod = " + this.PEgjpkod + "\n");
        out.append("PEgbgkod = " + this.PEgbgkod + "\n");
        out.append("PEgstkod = " + this.PEgstkod + "\n");
        out.append("PEgnolot = " + this.PEgnolot + "\n");
        out.append("PEgbllot = " + this.PEgbllot + "\n");
        out.append("PEgnompt = " + this.PEgnompt + "\n");
        out.append("PEgpelan = " + this.PEgpelan + "\n");
        out.append("PEgadpg1 = " + this.PEgadpg1 + "\n");
        out.append("PEgtkhoc = " + this.PEgtkhoc + "\n");
        out.append("PEgtkhtk = " + this.PEgtkhtk + "\n");
        out.append("PEgtkhpl = " + this.PEgtkhpl + "\n");
        out.append("PEgnilth = " + this.PEgnilth + "\n");
        out.append("PEgbilpk = " + this.PEgbilpk + "\n");
        out.append("PEglsbgn = " + this.PEglsbgn + "\n");
        out.append("PEglstnh = " + this.PEglstnh + "\n");
        out.append("PEgrjfil = " + this.PEgrjfil + "\n");
        out.append("PEgrjmmk = " + this.PEgrjmmk + "\n");
        out.append("PEgstatf = " + this.PEgstatf + "\n");
        out.append("PEgoldac = " + this.PEgoldac + "\n");
        out.append("PEgstatk = " + this.PEgstatk + "\n");
        out.append("PEgstcbk = " + this.PEgstcbk + "\n");
        out.append("PEgonama = " + this.PEgonama + "\n");
        out.append("PEglsans = " + this.PEglsans + "\n");
        out.append("PEgadpg2 = " + this.PEgadpg2 + "\n");
        out.append("PEgaklsn = " + this.PEgaklsn + "\n");
        out.append("PEgakswn = " + this.PEgakswn + "\n");
        out.append("PEgakpbg = " + this.PEgakpbg + "\n");
        return out.toString();
    }

    /**
     * Clone will return identical deep copy of this valueObject. Note, that
     * this method is different than the clone() which is defined in
     * java.lang.Object. Here, the retuned cloned object will also have all its
     * attributes cloned.
     */
    public Object clone() {
        HLpgng cloned = new HLpgng();

        if (this.PEgakaun != null) {
            cloned.setPEgakaun(new String(this.PEgakaun));
        }
        if (this.PEgdigit != null) {
            cloned.setPEgdigit(new String(this.PEgdigit));
        }
        if (this.PEgjlkod != null) {
            cloned.setPEgjlkod(new String(this.PEgjlkod));
        }
        if (this.PEgthkod != null) {
            cloned.setPEgthkod(new String(this.PEgthkod));
        }
        if (this.PEghtkod != null) {
            cloned.setPEghtkod(new String(this.PEghtkod));
        }
        if (this.PEgjpkod != null) {
            cloned.setPEgjpkod(new String(this.PEgjpkod));
        }
        if (this.PEgbgkod != null) {
            cloned.setPEgbgkod(new String(this.PEgbgkod));
        }
        if (this.PEgstkod != null) {
            cloned.setPEgstkod(new String(this.PEgstkod));
        }
        if (this.PEgnolot != null) {
            cloned.setPEgnolot(new String(this.PEgnolot));
        }
        if (this.PEgbllot != null) {
            cloned.setPEgbllot(new String(this.PEgbllot));
        }
        if (this.PEgnompt != null) {
            cloned.setPEgnompt(new String(this.PEgnompt));
        }
        if (this.PEgpelan != null) {
            cloned.setPEgpelan(new String(this.PEgpelan));
        }
        if (this.PEgadpg1 != null) {
            cloned.setPEgadpg1(new String(this.PEgadpg1));
        }
        if (this.PEgtkhoc != null) {
            cloned.setPEgtkhoc(new String(this.PEgtkhoc));
        }
        if (this.PEgtkhtk != null) {
            cloned.setPEgtkhtk(new String(this.PEgtkhtk));
        }
        if (this.PEgtkhpl != null) {
            cloned.setPEgtkhpl(new String(this.PEgtkhpl));
        }
        if (this.PEgnilth != null) {
            cloned.setPEgnilth(new String(this.PEgnilth));
        }
        if (this.PEgbilpk != null) {
            cloned.setPEgbilpk(new String(this.PEgbilpk));
        }
        if (this.PEglsbgn != null) {
            cloned.setPEglsbgn(new String(this.PEglsbgn));
        }
        if (this.PEglstnh != null) {
            cloned.setPEglstnh(new String(this.PEglstnh));
        }
        if (this.PEgrjfil != null) {
            cloned.setPEgrjfil(new String(this.PEgrjfil));
        }
        if (this.PEgrjmmk != null) {
            cloned.setPEgrjmmk(new String(this.PEgrjmmk));
        }
        if (this.PEgstatf != null) {
            cloned.setPEgstatf(new String(this.PEgstatf));
        }
        if (this.PEgoldac != null) {
            cloned.setPEgoldac(new String(this.PEgoldac));
        }
        if (this.PEgstatk != null) {
            cloned.setPEgstatk(new String(this.PEgstatk));
        }
        if (this.PEgstcbk != null) {
            cloned.setPEgstcbk(new String(this.PEgstcbk));
        }
        if (this.PEgonama != null) {
            cloned.setPEgonama(new String(this.PEgonama));
        }
        if (this.PEglsans != null) {
            cloned.setPEglsans(new String(this.PEglsans));
        }
        if (this.PEgadpg2 != null) {
            cloned.setPEgadpg2(new String(this.PEgadpg2));
        }
        if (this.PEgaklsn != null) {
            cloned.setPEgaklsn(new String(this.PEgaklsn));
        }
        if (this.PEgakswn != null) {
            cloned.setPEgakswn(new String(this.PEgakswn));
        }
        if (this.PEgakpbg != null) {
            cloned.setPEgakpbg(new String(this.PEgakpbg));
        }
        return cloned;
    }

    /**
     * getDaogenVersion will return information about generator which created
     * these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}
