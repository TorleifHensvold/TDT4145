package table;

public class Utenapparat extends Ovelse
{
	// private int OvelsesID; //primary key and foreign key to ovelse
	private String beskrivelse;

	public Utenapparat(int ovelsesID, String beskrivelse) throws Exception
	{
		super.setOvelsesID(ovelsesID);// setID(OvelsesID);
		setBeskrivelse(beskrivelse);
	}
	
	public Utenapparat() {
		
	}

	/*
	 * public void setID(int OvelsesID) throws Exception{ if (OvelsesID <=
	 * 100000000) { this.OvelsesID = OvelsesID; } else {//TODO: Create else if
	 * (OvelsesID does not exist) then Exception throw new
	 * IllegalArgumentException("the int is too long"); } }
	 */

	public void setBeskrivelse(String Beskrivelse)
	{
		if (Beskrivelse.length() <= 300)
		{
			this.beskrivelse = Beskrivelse;
		}
		else
		{
			throw new IllegalArgumentException("this string is too long");
		}
	}
	
	public void databaseSetsBeskrivelse(String Beskrivelse) {
		this.beskrivelse = Beskrivelse;
	}

	/*
	 * public int getOvelsesID() { return OvelsesID; }
	 */

	public String getBeskrivelse()
	{
		return beskrivelse;
	}

}
