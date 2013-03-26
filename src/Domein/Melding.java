/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import java.sql.Date;




public class Melding 
{
    private int persoonNr,fotoNr,teller;//teller zodat de melding kan bijhouden hoeveel er het gelike of gedisliked hebben
    private String straatNaam,gemeente,omschrijving;
    private Date datum;

    public Melding( int persoonNr, int fotoNr, int teller, String straatNaam, String gemeente, String omschrijving, Date datum) {
        
        this.persoonNr = persoonNr;
        this.fotoNr = fotoNr;
        this.teller = teller;
        this.straatNaam = straatNaam;
        this.gemeente = gemeente;
        this.omschrijving = omschrijving;
        this.datum = datum;
    }


    public int getPersoonNr() {
        return persoonNr;
    }

    public void setPersoonNr(int persoonNr) {
        this.persoonNr = persoonNr;
    }

    public int getFotoNr() {
        return fotoNr;
    }

    public void setFotoNr(int fotoNr) {
        this.fotoNr = fotoNr;
    }

    public int getTeller() {
        return teller;
    }

    public void setTeller(int teller) {
        this.teller = teller;
    }

    public String getStraatNaam() {
        return straatNaam;
    }

    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }



    

    
}
