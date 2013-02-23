/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistentie;

import Domein.Persoon;
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
public class PersoonMapper {
   
    private Persoon pers;
    private Persoon pers2;
	
	public Persoon logIn(String facebookAccount, String twitterAccount)
	{
		
	
		
		Connectie c = new Connectie();
		
	try
             {
		
		Statement s = c.getConnection().createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM Persoon WHERE FacebookAccount ='"+facebookAccount+"' OR TwitterAccount='"+twitterAccount+"'");
		//gaat in database zoeken waar wachtwoord en userid overeenkomen en haalt dat object eruit eruit 
		rs.next();
		//FacebookAccount=rs.getString("FacebookAccount");
                
			
		if(rs.getString("FacebookAccount").equals(facebookAccount))
		{
                    twitterAccount = null;
                    pers = new Persoon(rs.getInt("PersoonNr"), rs.getInt("Score"), rs.getString("FacebookAccount"),twitterAccount);
	
		}
                if(rs.getString("TwitterAccount").equals(twitterAccount))
                {
                     facebookAccount = null;
                    pers = new Persoon(rs.getInt("PersoonNr"), rs.getInt("Score"), facebookAccount,rs.getString("TwitterAccount"));
                }
	   }
	    
		catch(SQLException e)
		{
			
		}
		return pers;

	}
	
	
	

	
	
	public List<Persoon> geefScores() 
	{
		List<Persoon> PersoonLijst = new ArrayList<Persoon>();

		// create Statement for querying database
		Statement statement;
		Connectie connecti = new Connectie();
		try {
			statement = connecti.getConnection().createStatement();
			

			// query database
			ResultSet rs = statement.executeQuery("SELECT FacebookAccount,TwitterAccount,Score FROM Persoon ORDER BY Score desc");
			
			while (rs.next()) {
                                 int persoonNr = 0;
                                 
                                 if(rs.getString("TwitterAccount").equals(null))
                                 {
                                     String twitterAccount = "geen";
                                     pers2 = new Persoon(persoonNr, rs.getInt("Score"), rs.getString("FacebookAccount"), twitterAccount);
                                 }
                                 else
                                 {
                                     String facebookAccount = "geen";
                                     pers2 = new Persoon(persoonNr, rs.getInt("Score"), facebookAccount,rs.getString("TwitterAccount"));
                                 }
				PersoonLijst.add(pers2);
				
				
					
			}
			statement.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return PersoonLijst;
	}
	
	

	
		public void voegEenPersoonToe(Persoon Pers) {
			
			Connectie connecti = new Connectie();

			try{
					
					
					Statement s = connecti.getConnection().createStatement();//connectie maken
					ResultSet rs = s.executeQuery("SELECT PersoonNr FROM Persoon ORDER BY PersoonNr desc");
					rs.next();
					
					
				
					String sql ="INSERT INTO Persoon(PersoonNr,Score,Email,FacebookAccount,TwitterAccount) VALUES(?,?,?,?)";
					
				PreparedStatement pstmt = connecti.getConnection().prepareStatement(sql);
				pstmt.setInt(1, Pers.getPersoonNr());	
                                pstmt.setInt(2, Pers.getScore());
				pstmt.setString(3, Pers.getFacebookAccount());
                                pstmt.setString(4, Pers.getTwitterAccount());
				
				pstmt.executeUpdate();
				
				
				connecti.closeConnection();
			}

			catch (SQLException sqlException) {
                        System.out.print("Database Error");
                        sqlException.getMessage();

			System.exit(1);
			}
		} 
			
	
	
	

    
}
