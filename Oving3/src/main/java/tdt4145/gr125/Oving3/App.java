package tdt4145.gr125.Oving3;

import java.sql.*;

import database.service.DatabaseService;
import table.Apparat;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		System.out.println("java version: " + System.getProperty("java.version"));
		System.out.println("javafx.version: " + System.getProperty("javafx.version"));

		try 
		{
			Connection conn = DatabaseService.getDatasource().getConnection();
			PreparedStatement prepState = conn.prepareStatement("SELECT * FROM apparat");
			ResultSet rs = prepState.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			for (int i = 1; i <= columnCount; i++) 
			{
				System.out.printf(meta.getColumnName(i) + ", ");
			}
			while (rs.next()) 
			{
				System.out.println();
				String row = "";
				for (int i = 1; i <= columnCount; i++) 
				{
				row += rs.getString(i) + ", ";	
				}
				System.out.println(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
		String navn = "Pull-up Bar";
		Connection con= DatabaseService.getDatasource().getConnection();
        PreparedStatement prepstatement = con.prepareStatement("SELECT * from apparat WHERE Navn=?;");
        prepstatement.setString(1, navn);
        ResultSet rs = prepstatement.executeQuery();
        
        ResultSetMetaData meta = rs.getMetaData();
        int col = meta.getColumnCount();
        
        if(col != 2) {
        	throw new Exception();
        }
        
        Apparat ap = new Apparat();
        rs.next();
        ap.setNavn(navn);
        ap.setBeskrivelse(rs.getString(2));
               
        
        rs.close();
        con.close();

        System.out.println(ap);
        System.out.println(ap.getNavn() + " " + ap.getBeskrivelse());
		}
		catch (Exception e)
		{System.out.println(e);
		}
		
	}
}
