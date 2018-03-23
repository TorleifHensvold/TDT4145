package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import table.Tilhorergruppe;

public class TilhorergruppeService {
	
	public static boolean createTilhorergruppeRelation(Tilhorergruppe tilhorer) {
		try {
			Connection conn = DatabaseService.getDatasource().getConnection();
			PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO tilhorergruppe (GruppeID, ovelsesID) VALUES (?,?);");
			prepStatement.setInt(1, tilhorer.gruppeID);
			prepStatement.setInt(2, tilhorer.ovelsesID);
			boolean success = prepStatement.execute();
			
			prepStatement.close();
			conn.close();
			return success;
		}
		catch (Exception e) {
				e.printStackTrace();
				return false;
		}
	}
}
