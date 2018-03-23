package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import table.Utenapparat;

public class UtenapparatService {
	
	
	public static void addNewUtenapparat(Utenapparat app) throws SQLException {
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepStat = conn.prepareStatement("INSERT INTO utenapparat (OvelsesID, Beskrivelse) VALUES (?, ?);");
		prepStat.setInt(1, app.getOvelsesID());
		prepStat.setString(2, app.getBeskrivelse());
		prepStat.executeUpdate();
		conn.close();
	}
	
	public static void deleteUtenapparatOvelse(Utenapparat app) throws Exception
	{
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepState = conn.prepareStatement("DELETE * FROM utenapparatovelse WHERE OvelsesID = ?");
		prepState.setInt(1, app.getOvelsesID());
		OvelseService.deleteOvelseByID(app.getOvelsesID());
		conn.close();
	}
		
	public static List<Utenapparat> getApparatovelseByStatement(PreparedStatement prepState) throws Exception{
		
		ResultSet rs = prepState.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
		
		int col = meta.getColumnCount();
		if (col != 2)
		{
			throw new Exception("The number of columns in the table from MySQL was not 2");
		}
		List<Utenapparat> listOfUApparatovelse = convertResultSetToList(rs);
		
		rs.close();
		return listOfUApparatovelse;
	}
	
	private static List<Utenapparat> convertResultSetToList(ResultSet rs) throws Exception
	{
		List<Utenapparat> listOfUApparatovelse = new ArrayList<Utenapparat>();
		
		while (rs.next())
		{
			Utenapparat aov = new Utenapparat();
			aov.databaseSetOvelsesID(rs.getInt("OvelsesID"));
			aov.databaseSetNavn(rs.getString("Navn"));
			aov.databaseSetsBeskrivelse(rs.getString("Beskrivelse"));

					
			listOfUApparatovelse.add(aov);
		}
		return listOfUApparatovelse;
	}
}
