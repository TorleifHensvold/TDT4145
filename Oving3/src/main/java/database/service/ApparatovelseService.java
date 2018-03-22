package database.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import table.Apparatovelse;
import table.Ovelse;

public class ApparatovelseService {
	
	public static List<Apparatovelse> getApparatovelseByStatement(PreparedStatement prepState) throws Exception{
		
		ResultSet rs = prepState.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
		
		int col = meta.getColumnCount();
		if (col != 2)
		{
			throw new Exception("The number of columns in the table from MySQL was not 2");
		}
		List<Apparatovelse> listOfApparatovelse = convertResultSetToList(rs);
		
		rs.close();
		return listOfApparatovelse;
	}
	
	private static List<Apparatovelse> convertResultSetToList(ResultSet rs) throws Exception
	{
		List<Apparatovelse> listOfApparatovelse = new ArrayList<Apparatovelse>();
		
		while (rs.next())
		{
			Apparatovelse aov = new Apparatovelse();
			aov.databaseSetOvelsesID(rs.getInt(1));
			aov.databaseSetAntallKilo(rs.getInt(2));
			aov.databaseSetAntallSett(rs.getInt(3));
			aov.databaseSetApparat(rs.getString(4));
			
			listOfApparatovelse.add(aov);
		}
		return listOfApparatovelse;
	}
}
