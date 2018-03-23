package table;

public class Tilhorergruppe
{
	public int gruppeID; // primary key to gruppe
	public int ovelsesID; // foreign key to gruppe
	
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
}
