package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import table.Gruppe;

public class GruppeService {
	
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
}
