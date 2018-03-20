package table;

public class inneholder 
{
	private int OktID; 	//primary key and foreign key to treningsokt
	private int OvelsesID;	//primary key and foreign key to ovelse
	
	
	public inneholder(int OktID, int OvelsesID) throws Exception
	{
		setOktID(OktID);
		setOvelsesID(OvelsesID);
	}
	
	public int getOktID() 
	{
		return OktID;
	}
	
	public int getOvelsesID() 
	{
		return OvelsesID;
	}
	
	private void setOktID(int oktID) throws Exception
	{
		if (oktID > 1000000000)
		{
			throw new IllegalArgumentException("The number is too high to be an integer in java.");
		}
		// TODO: Create else if (oktID does not exist) then Exeption
		else
		{
		this.OktID = oktID;
		}
	}
	
	private void setOvelsesID(int ovelsesID) throws Exception
	{
		if (ovelsesID > 1000000000)
		{
			throw new IllegalArgumentException("The number is too high to be an integer in java.");
		}
		// TODO: Create else if (oktID does not exist) then Exeption
		else
		{
		this.OvelsesID = ovelsesID;
		}
	}
	
	// TODO Create empty constructor and a way to initialise a inneholder class from SQL server.
	
}
