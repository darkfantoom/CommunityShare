
package Persistentie;

import Domein.Foto;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;


public class FotoDAO
{
    //private final static String LEES_Foto_SQL = "SELECT * FROM Foto Order by FotoNr asc";
    private Foto F;

    public Foto geefFoto(int fotoNr) 
	{
		
		Statement statement;
		Connectie connecti = new Connectie();
		
		try 
		{
			statement = connecti.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM foto WHERE FotoNr ='"+fotoNr+"'");
			
                        Blob Foto=rs.getBlob("Foto");				 
                        InputStream imageBlobStream=Foto.getBinaryStream();
                        BufferedImage foto=ImageIO.read(imageBlobStream);

			F = new Foto(rs.getInt("FotoNr"), foto);
			connecti.closeConnection();
			statement.close();
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return F;
	}
    public void nieuweFoto(Foto F) 
	{
		Connectie connecti = new Connectie();

		try
		{			
			
			Blob Foto=connecti.getConnection().createBlob();
			OutputStream afbeeldingStream=Foto.setBinaryStream(1);
			ImageIO.write(F.getFoto(),"png",afbeeldingStream);
			
			//Statement s = connecti.getConnection().createStatement();//connectie maken
			//ResultSet rs = s.executeQuery("SELECT FotoNr FROM Foto ORDER BY FotoNr desc");
			//rs.next();			
			PreparedStatement pstmt = connecti.getConnection().prepareStatement("INSERT INTO foto(FotoNr,Foto) VALUES(?,?)");
			pstmt.setInt(1, F.getFotoNr());
			pstmt.setBlob(2, Foto);
			
						
			pstmt.executeUpdate();
			connecti.closeConnection();
		}

		catch (SQLException sqlException) 
		{
                        System.out.print("Database Error");
                        sqlException.getMessage();
                        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 


}
