package tdt4145.gr125.Oving3;

import java.sql.*;

import database.service.ApparatService;
import database.service.DatabaseService;
import table.Apparat;

/**
 * Hello world!
 *
 */
@SuppressWarnings("unused")
public class App 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		System.out.println("java version: " + System.getProperty("java.version"));
		System.out.println("javafx.version: " + System.getProperty("javafx.version"));

		try 
		{
			System.out.println("SELECT * from apparat WHERE Navn=?;");
			String navn = "Pull-up Bar";
			Connection con= DatabaseService.getDatasource().getConnection();
			PreparedStatement prepstatement = con.prepareStatement("SELECT * from apparat WHERE Navn=?;");
			prepstatement.setString(1, navn);
			ResultSet rs = prepstatement.executeQuery();
        
			ResultSetMetaData meta = rs.getMetaData();
			int col = meta.getColumnCount();
        
			if(col != 2) 
			{
				throw new Exception();
			}
        
			Apparat ap = new Apparat();
			rs.next();
			ap.setNavn(navn);
			ap.setBeskrivelse(rs.getString(2));
               
        
			rs.close();
			con.close();

			System.out.println(ap);
			System.out.println("data i table: " + ap);
			System.out.println(ap.getNavn() + ": " + ap.getBeskrivelse());
			System.out.println();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		try 
		{
			System.out.println("SELECT * from apparat;");
			String navn = "Pull-up Bar";
			Connection con= DatabaseService.getDatasource().getConnection();
			PreparedStatement prepstatement = con.prepareStatement("SELECT * from apparat;");
			ResultSet rs = prepstatement.executeQuery();
        
			ResultSetMetaData meta = rs.getMetaData();
			int col = meta.getColumnCount();
        
			if(col != 2) 
			{
				throw new Exception();
			}
               
			while (rs.next())
			{
				String output = "";
				output += rs.getString(1) + ": " + rs.getString(2);
				System.out.println(output);
			}
			rs.close();
			con.close();

			
			System.out.println();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		try {
			Apparat ap = new Apparat("Stol", "Til å sitte på.");
			ApparatService.NewApparat(ap);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try 
		{
			System.out.println("SELECT * from apparat;");
			String navn = "Pull-up Bar";
			Connection con= DatabaseService.getDatasource().getConnection();
			PreparedStatement prepstatement = con.prepareStatement("SELECT * from apparat;");
			ResultSet rs = prepstatement.executeQuery();
        
			ResultSetMetaData meta = rs.getMetaData();
			int col = meta.getColumnCount();
        
			if(col != 2) 
			{
				throw new Exception();
			}
               
			while (rs.next())
			{
				String output = "";
				output += rs.getString(1) + ": " + rs.getString(2);
				System.out.println(output);
			}
			rs.close();
			con.close();

			
			System.out.println();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		try 
		{
			System.out.println("DELETE FROM apparat WHERE Navn=?;");
			String Navn = "Stol";
			Connection con= DatabaseService.getDatasource().getConnection();
	        PreparedStatement prepstatement = con.prepareStatement("DELETE FROM apparat WHERE Navn=?;");
	        prepstatement.setString(1, Navn);
	        boolean result =  prepstatement.execute();
            //conn.close();
            //return result;
	        
	        //prepstatement.executeQuery();
	        //prepstatement.execute();
	        con.close();
	        System.out.println("boolean: " + result);
	        System.out.println();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
		
		try 
		{
			System.out.println("SELECT * from apparat;");
			String navn = "Pull-up Bar";
			Connection con= DatabaseService.getDatasource().getConnection();
			PreparedStatement prepstatement = con.prepareStatement("SELECT * from apparat;");
			ResultSet rs = prepstatement.executeQuery();
        
			ResultSetMetaData meta = rs.getMetaData();
			int col = meta.getColumnCount();
        
			if(col != 2) 
			{
				throw new Exception();
			}
               
			while (rs.next())
			{
				String output = "";
				output += rs.getString(1) + ": " + rs.getString(2);
				System.out.println(output);
			}
			rs.close();
			con.close();

			
			System.out.println();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("Done");
	}
}
