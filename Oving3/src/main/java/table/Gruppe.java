package table;

public class Gruppe 
{
	private int GruppeID;
	private String TypeOvelse;
	
	public Gruppe(int GruppeID, String TypeOvelse) throws Exception
	{
		setGruppeID(GruppeID);
		setTypeOvelse(TypeOvelse);
	}

	private void setTypeOvelse(String typeOvelse) throws Exception
	{
		if (typeOvelse.length() > 50)
		{
			throw new IllegalArgumentException("The sentence must be 50 characters or less.");
		}
		else
		{
			this.TypeOvelse = typeOvelse;
		}
	}

	private void setGruppeID(int gruppeID) 
	{
		// TODO: add to check whether GruppeID already exists in SQL database.
		
		this.GruppeID = gruppeID;
	}
	
	public int getGruppeID()
	{
		return this.GruppeID;
	}
	
	public String getTypeOvelse()
	{
		return this.TypeOvelse;
	}
	
	// TODO: Add empty constructor
	// TODO: Add way to instantiate class from existing SQL database.
	
}
