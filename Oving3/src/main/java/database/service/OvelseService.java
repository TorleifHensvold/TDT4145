package database.service;

import java.sql.Connection;
import java.sql.SQLException;
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
}
