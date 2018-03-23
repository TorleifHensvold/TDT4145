package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import table.Ovelse;
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
	
	public static List<Treningsokt> getNLastTreningsokt(int n) throws Exception{
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepStatement = conn.prepareStatement("SELECT * FROM treningsokt ORDER BY dato + 0 DESC LIMIT ?");
		prepStatement.setInt(1, n);
		
		ResultSet rs =  prepStatement.executeQuery();
		
		List<Treningsokt> listOfOkt = new ArrayList<Treningsokt>();
		
		while (rs.next())
		{
			Treningsokt o = new Treningsokt();
			o.databaseSetsOktID(rs.getInt("OktID"));
			o.databaseSetsDato(rs.getString("Dato"));
			o.databaseSetsTidspunkt(rs.getString("Tidspunkt"));
			o.databaseSetsForm((Integer)rs.getObject("Form"));
			o.databaseSetsNotat((String)rs.getObject("Notat"));
			o.databaseSetsVarighet(rs.getInt("Varighet"));
			o.databaseSetsPrestasjon((Integer)rs.getObject("Prestasjon"));
			
			listOfOkt.add(o);
		}
		return listOfOkt;
		
	}
}
