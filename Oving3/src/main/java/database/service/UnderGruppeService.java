package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import table.Undergruppe;

public class UnderGruppeService {
	
	
	
	public static boolean createRelation(Undergruppe gruppe) {
		try {
			Connection conn = DatabaseService.getDatasource().getConnection();
			if(GruppeService.getGruppeByID(gruppe.getGruppeID()).getGruppeID()!=gruppe.getGruppeID()) {
				return false;
			}
			if(GruppeService.getGruppeByID(gruppe.getUnderGruppeID()).getGruppeID()!=gruppe.getUnderGruppeID()) {
				return false;
			}
			PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO undergruppe (GruppeID, UnderGruppeID) VALUES (?,?);");
			prepStatement.setInt(1, gruppe.getGruppeID());
			prepStatement.setInt(2, gruppe.getUnderGruppeID());
			
			boolean success = prepStatement.execute();
			
			prepStatement.close();
			conn.close();
			return success;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	public static ArrayList<Gruppe> getUnderGruppe(Gruppe gruppe) throws Exception{
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepState = conn.prepareStatement("SELECT * FROM gruppe WHERE GruppeID=?");
		prepState.setInt(1, gruppe.getGruppeID());
		
	}*/
}
