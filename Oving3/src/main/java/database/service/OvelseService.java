package database.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import table.Ovelse;



public class OvelseService 
{
	public static List<Ovelse> getAllOvelser() throws Exception
	{
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepState = conn.prepareStatement("SELECT * FROM ovelse");
		ResultSet rs = prepState.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
		int col = meta.getColumnCount();
		if (col != 2)
		{
			throw new Exception("The number of columns in the table from MySQL was not 2");
		}
		List<Ovelse> listOfOvelse = convertResultSetToList(rs);
		
		rs.close();
		conn.close();
		return listOfOvelse;
		
		
	}
	
	private static List<Ovelse> convertResultSetToList(ResultSet rs) throws Exception
	{
		List<Ovelse> listOfOvelse = new ArrayList<Ovelse>();
		
		while (rs.next())
		{
			Ovelse ov = new Ovelse();
			ov.databaseSetOvelsesID(rs.getInt(1));
			ov.databaseSetNavn(rs.getString(2));
			listOfOvelse.add(ov);
		}
		return listOfOvelse;
	}
	
	public static Ovelse getOvelseByID(int ID) throws SQLException
	{
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepState = conn.prepareStatement("SELECT * FROM ovelse WHERE OvelseID = ?;");
		prepState.setInt(1, ID);
		ResultSet rs = prepState.executeQuery();
		Ovelse ovelse = null;
		if (rs.next())
		{
			ovelse = new Ovelse();
			ovelse.databaseSetOvelsesID(rs.getInt(1));
			ovelse.databaseSetNavn(rs.getString(2));
		}
		return ovelse;
	}
	
	public static void addOvelse(Ovelse ovelse) throws SQLException
	{
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepState = conn.prepareStatement("INSERT INTO ovelse VALUE (?,?);");
		prepState.setInt(1, ovelse.getOvelsesID());
		prepState.setString(2, ovelse.getNavn());
		int rows = prepState.executeUpdate();
		System.out.println(rows + " rows updated.");
	}
	
	public static List<Ovelse> getOvelserByStatement(PreparedStatement prepState) throws Exception
	{
		ResultSet rs = prepState.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
		
		int col = meta.getColumnCount();
		if (col != 2)
		{
			throw new Exception("The number of columns in the table from MySQL was not 2");
		}
		List<Ovelse> listOfOvelse = convertResultSetToList(rs);
		
		rs.close();
		return listOfOvelse;
		
	}
}
