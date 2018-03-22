package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import table.Gruppe;
import table.Ovelse;

public class GruppeService {
	
	public static List<Ovelse> includedInGruppe(int GruppeID) throws Exception{
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepStatement = conn.prepareStatement("SELECT * FROM (((gruppe NATURAL JOIN tilhorergruppe) NATURAL JOIN ovelse) NATURAL JOIN (apparatovelse UNION utenapparat)) WHERE gruppe.GruppeID=?;");
		prepStatement.setInt(1, GruppeID);
		
		List<Ovelse> listOfOvelse = OvelseService.getOvelserByStatement(prepStatement);
		
		conn.close();
        
        return listOfOvelse;
	}
	
	public static boolean nyGruppe(Gruppe gruppe) {
		try {
			Connection conn = DatabaseService.getDatasource().getConnection();
			PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO gruppe (GruppeID, TypeOvelse) VALUES (?,?);");
			prepStatement.setInt(1, gruppe.getGruppeID());
			prepStatement.setString(2, gruppe.getTypeOvelse());
			boolean success = prepStatement.execute();
			
			prepStatement.close();
			conn.close();
			return success;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<Gruppe> getAllGruppe()throws Exception
	{
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepState = conn.prepareStatement("SELECT * FROM gruppe");
		ResultSet rs = prepState.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
		int col = meta.getColumnCount();
		if (col != 2)
		{
			throw new Exception("The number of columns in the table from MySQL was not 2");
		}
		List<Gruppe> listOfGruppe = convertResultSetToList(rs);
		
		rs.close();
		conn.close();
		return listOfGruppe;
	}
	
	
	private static List<Gruppe> convertResultSetToList(ResultSet rs) throws Exception
	{
		List<Gruppe> listOfGruppe = new ArrayList<Gruppe>();
		
		while (rs.next())
		{
			Gruppe group = new Gruppe();
			group.databaseSetsGruppeID(rs.getInt(1));
			group.databaseSetsTypeOvelse(rs.getString(2));
			listOfGruppe.add(group);
		}
		return listOfGruppe;
	}
	
	public static Gruppe getGruppeByID(int ID)throws Exception {
		
			Connection conn = DatabaseService.getDatasource().getConnection();
		
		PreparedStatement prepState = conn.prepareStatement("SELECT * FROM gruppe WHERE GruppeID=?");
		prepState.setInt(1, ID);
		ResultSet rs = prepState.executeQuery();
		Gruppe group = null;
		if(rs.next()) {
			group = new Gruppe();
			group.databaseSetsGruppeID(rs.getInt(1));
			group.databaseSetsTypeOvelse(rs.getString(2));	
		}
		return group;
			
	}
	
	
}
