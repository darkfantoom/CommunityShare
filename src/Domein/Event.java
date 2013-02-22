
package Domein;

import java.util.List;


public class Event extends Melding
{
    private String Type;
    private String Categorie;
    

	



	public Event(String Type, String Categorie) 
        {
		super();
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
