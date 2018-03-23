package table;

public class Tilhorergruppe
{
	private int gruppeID; // primary key to gruppe
	private int ovelsesID; // foreign key to gruppe
	
	public Tilhorergruppe(Gruppe gruppe, Ovelse ovelse)
	{
		setGruppeID(gruppe);
		setOvelsesID(ovelse);
	}
	
	public Tilhorergruppe()
	{
		
	}
	
	private void setGruppeID(Gruppe gruppe)
	{
		this.gruppeID = gruppe.getGruppeID();
	}
	
	private void setOvelsesID(Ovelse ovelse)
	{
		this.ovelsesID = ovelse.getOvelsesID();
	}
	
	public int getGruppeID() {
		return this.gruppeID;
	}
	
	public int getOvelsesID() {
		return this.ovelsesID;
	}
}
