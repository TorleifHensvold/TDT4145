package tdt4145.gr125.Oving3;

import java.sql.Connection;
import java.sql.*;

import database.service.DatabaseService;

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
			System.out.println();
			while (rs.next()) 
			{
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
	}
}
