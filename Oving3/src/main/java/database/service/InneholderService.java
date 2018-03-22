package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import table.Inneholder;

public class InneholderService {

	public static boolean createInneholderRelation(Inneholder inneholder) {
		try {
			Connection conn = DatabaseService.getDatasource().getConnection();
			PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO inneholder (OktID, OvelsesID) VALUES (?,?);");
			prepStatement.setInt(1, inneholder.getOktID());
			prepStatement.setInt(2, inneholder.getOvelsesID());
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
