/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import java.sql.Date;

/**
 *
 * @author arne
 */
public class Reactie 
{
    private int meldingNr,persoonNr;
    private String reactie;
    private Date datum;

    public Reactie(int meldingNr, int persoonNr, String reactie, Date datum) {
        this.meldingNr = meldingNr;
        this.persoonNr = persoonNr;
        this.reactie = reactie;
        this.datum = datum;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getMeldingNr() {
        return meldingNr;
    }

    public void setMeldingNr(int meldingNr) {
        this.meldingNr = meldingNr;
    }

    public int getPersoonNr() {
        return persoonNr;
    }

    public void setPersoonNr(int persoonNr) {
        this.persoonNr = persoonNr;
    }

    public String getReactie() {
        return reactie;
    }

    public void setReactie(String reactie) {
        this.reactie = reactie;
    }
    
    
    
}
