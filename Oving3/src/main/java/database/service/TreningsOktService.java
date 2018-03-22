package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import table.Treningsokt;

public class TreningsOktService {
	
	public static boolean nyTreningsOkt(Treningsokt treningsokt) {
		try {
			Connection conn = DatabaseService.getDatasource().getConnection();
			PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO treningsokt (OktID, Dato, Tidspunkt, Varighet, Form, Prestasjon, Notat) VALUES (?,?,?,?,?,?,?)");
			prepStatement.setInt(1, treningsokt.getOktID());
			prepStatement.setString(2, treningsokt.getDato());
			prepStatement.setString(3, treningsokt.getTidspunkt());
			prepStatement.setInt(4, treningsokt.getVarighet());
			prepStatement.setInt(5, treningsokt.getForm());
			prepStatement.setInt(6, treningsokt.getPrestasjon());
			prepStatement.setString(7, treningsokt.getNotat());
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
