package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import table.Apparat;


public class ApparatService {
	//hent ut alle apparater
	//legge inn nye apparater
	//fjerne apparater
	//hente ut beskrivelsen til ett apparat
	
	public boolean NewApparat(Apparat apparat) {
		try {
			Connection conn = DatabaseService.getDatasource().getConnection();
			PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO Apparat (Navn, Beskrivelse) VALUES (?,?);");
			prepStatement.setString(1, apparat.getNavn());
			prepStatement.setString(2, apparat.getBeskrivelse());
			
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
