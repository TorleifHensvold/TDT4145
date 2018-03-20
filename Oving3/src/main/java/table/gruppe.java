package table;

public class gruppe 
{
	private int GruppeID;
	private String TypeOvelse;
	
	public void gruppe(int GruppeID, String TypeOvelse) throws Exception
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
	
	
}
