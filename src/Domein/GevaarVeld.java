/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import java.util.List;

/**
 *
 * @author arne
 */
public class GevaarVeld extends Melding {

    private String Type;
    private String Categorie;

    public GevaarVeld(String Type, String Categorie) 
    {
        this.Type = Type;
        this.Categorie = Categorie;
    }

    public String getType() 
    {
        return Type;
    }

    public void setType(String Type) 
    {
        this.Type = Type;
    }

    public String getCategorie() 
    {
        return Categorie;
    }

    public void setCategorie(String Categorie) 
    {
        this.Categorie = Categorie;
    }
}
