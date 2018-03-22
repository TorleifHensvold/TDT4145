package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import table.Gruppe;

public class UnderGruppeService {
	
	
	
	public static boolean createRelation(Gruppe gruppe, Gruppe undergruppe) {
		try {
			Connection conn = DatabaseService.getDatasource().getConnection();
			if(GruppeService.getGruppeByID(gruppe.getGruppeID())!=gruppe) {
				return false;
			}
			if(GruppeService.getGruppeByID(undergruppe.getGruppeID())!=undergruppe) {
				return false;
			}
			PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO undergruppe (GruppeID, UnderGruppeID) VALUES (?,?);");
			prepStatement.setInt(1, gruppe.getGruppeID());
			prepStatement.setInt(2, undergruppe.getGruppeID());
			
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
