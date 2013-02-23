/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistentie;


import Domein.Reactie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arne
 */
public class ReactieMapper {
    
    //aanmaken van een reactie
    public void aanmakenVanEenReactie(Reactie r){
        Connectie connect = new Connectie();
        Statement statement;
        try{
            statement = connect.getConnection().createStatement();
            String sql=("INSERT INTO Reactie( "
                    + "MeldingNr,"
                    + "PersoonNr,"
                    + "Reactie )"
                    + "VALUES(?,?,?)");
            
            PreparedStatement pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setInt(1,r.getMeldingNr());
            pstmt.setInt(2,r.getPersoonNr());
            pstmt.setString(3,r.getReactie());
            
            pstmt.executeUpdate();
            connect.closeConnection();
        }  
             catch (SQLException sqlException) {
                        System.out.print("Database Error");
                        sqlException.getMessage();

			System.exit(1);
			}
        //reactie verwijderen
    }
    
    public void verwijderenVanEenReactie(Reactie r){
       Connectie connect = new Connectie();
         Statement statement;
        try{
            statement= connect.getConnection().createStatement();
            String sql= ("DELETE FROM Like WHERE("
                    + "MeldingNr"
                    + "PersoonNr,"
                    + "Reactie )"
                    + "VALUES(?,?,?)");
            
            PreparedStatement pstmt = connect.getConnection().prepareStatement(sql);
             pstmt.setInt(1, r.getMeldingNr());
             pstmt.setInt(2, r.getPersoonNr());
             pstmt.setString(3, r.getReactie());
             pstmt.executeUpdate();
             pstmt.close();
             connect.closeConnection();
            
        }   
       catch (SQLException sqlException) {
                        System.out.print("Database Error");
                        sqlException.getMessage();

			System.exit(1);
			}
     
     }
    
    //lijst/zoeken = meldingnr meegeven, moet lijst geven van die reactie op die melding
    public List<Reactie> geefLijstReacties(int meldingNr) 
	{
           List<Reactie> reactieLijst = new ArrayList<Reactie>();
           
           Connectie connect = new Connectie();
           Statement statement;
           try {
                  statement = connect.getConnection().createStatement();
                  ResultSet rs = statement.executeQuery("SELECT PersoonNr, Reactie FROM Reactie WHERE "
                           + "MeldingNr = '"+meldingNr+"' "
                           + "ORDER BY Datum");
                  
                  while(rs.next()){
                          Reactie re = new Reactie(meldingNr,rs.getInt("PersoonNr"), rs.getString("Reactie"));
                          reactieLijst.add(re);
                  }
           }
           catch (SQLException e) 
		{
			e.printStackTrace();
		}
           return reactieLijst;

        }
   }

    
 
    
    
    
