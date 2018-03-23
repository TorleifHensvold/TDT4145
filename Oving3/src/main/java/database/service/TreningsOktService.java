package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
	
	public static String getOvelseInInterval(int lower, int upper, String navn) throws SQLException {
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepStat = conn.prepareStatement("select `dato`, `tidspunkt`, `beskrivelse`, `navn` "
				+ "from(((`treningsokt` JOIN `inneholder` ON `treningsokt`.`OktID`=`inneholder`.`OktID`) "
				+ "join `ovelse` on `inneholder`.`OvelsesID` = `ovelse`.`OvelsesID`)"
				+ "join `utenapparat` on `utenapparat`.`OvelsesID` = `ovelse`.`OvelsesID`) "
				+ "where `ovelse`.`Navn` = ? and `treningsokt`.`Dato` <= ? and `treningsokt`.`Dato` >= ?;");
		prepStat.setString(1, navn);
		prepStat.setInt(2, upper);
		prepStat.setInt(3, lower);
		
		String str = "";
		
		ResultSet rs = prepStat.executeQuery();
		while(rs.next()) {
			str += rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4);
		}
		
		PreparedStatement prepStat1 = conn.prepareStatement("select `dato`, `tidspunkt`, `navn`, `antallkilo`, `antallsett` "
				+ "from(((`treningsokt` JOIN `inneholder` ON `treningsokt`.`OktID`=`inneholder`.`OktID`) "
				+ "join `ovelse` on `inneholder`.`OvelsesID` = `ovelse`.`OvelsesID`)"
				+ "join `apparatovelse` on `apparatovelse`.`OvelsesID` = `ovelse`.`OvelsesID`) "
				+ "where `ovelse`.`Navn` = ? and `treningsokt`.`Dato` <= ? and `treningsokt`.`Dato` >= ?;");
		prepStat1.setString(1, navn);
		prepStat1.setInt(2, upper);
		prepStat1.setInt(3, lower);
		
		String str1 = "";
		
		ResultSet rs1 = prepStat1.executeQuery();
		while(rs1.next()) {
			str1 += rs1.getString(1) + rs1.getString(2) + rs1.getString(3) + Integer.toString(rs1.getInt(4)) + Integer.toString(rs1.getInt(5));
		}
		
		return (str + str1);
		
	}
}
