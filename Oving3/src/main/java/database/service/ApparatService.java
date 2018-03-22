package database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import table.Apparat;

public class ApparatService
{
	// hent ut alle apparater
	// legge inn nye apparater
	// fjerne apparater
	// hente ut beskrivelsen til ett apparat

	public static boolean NewApparat(Apparat apparat)
	{
		try
		{
			Connection conn = DatabaseService.getDatasource().getConnection();
			PreparedStatement prepStatement = conn
					.prepareStatement("INSERT INTO apparat (Navn, Beskrivelse) VALUES (?,?);");
			prepStatement.setString(1, apparat.getNavn());
			prepStatement.setString(2, apparat.getBeskrivelse());

			boolean success = prepStatement.execute();

			prepStatement.close();
			conn.close();
			return success;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public static Apparat getApparatByNavn(String navn) throws Exception
	{
		Connection con = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepstatement = con.prepareStatement("SELECT * from apparat WHERE Navn=?;");
		prepstatement.setString(1, navn);
		ResultSet rs = prepstatement.executeQuery();

		ResultSetMetaData meta = rs.getMetaData();
		int col = meta.getColumnCount();

		if (col != 2)
		{
			throw new Exception();
		}

		Apparat ap = new Apparat();

		rs.next();

		ap.setNavn(navn);
		ap.setBeskrivelse(rs.getString(2));

		rs.close();
		con.close();

		return ap;
	}

	public static boolean deleteApparatByNavn(String Navn) throws SQLException
	{
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepstatement = conn.prepareStatement("DELETE FROM apparat WHERE Navn=?;");
		prepstatement.setString(1, Navn);
		boolean result = prepstatement.execute();
		conn.close();
		return result;
	}

	public static List<Apparat> getAllApparat() throws Exception
	{
		Connection conn = DatabaseService.getDatasource().getConnection();
		PreparedStatement prepstatement = conn.prepareStatement("SELECT * FROM apparat");
		ResultSet rs = prepstatement.executeQuery();

		ResultSetMetaData meta = rs.getMetaData();
		int col = meta.getColumnCount();

		if (col != 2)
		{
			throw new Exception();
		}

		List<Apparat> listOfApparat = convertResultSetToList(rs);

		rs.close();
		conn.close();

		return listOfApparat;
	}

	private static List<Apparat> convertResultSetToList(ResultSet rs) throws Exception
	{
		List<Apparat> listOfOvelse = new ArrayList<Apparat>();

		while (rs.next())
		{
			Apparat ap = new Apparat();
			ap.databaseSetsNavn(rs.getString(1));
			ap.databaseSetsBeskrivelse(rs.getString(2));
			listOfOvelse.add(ap);
		}
		return listOfOvelse;
	}
}
