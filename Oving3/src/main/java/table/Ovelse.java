package table;

public class Ovelse {
	private int ovelsesID;
	private String navn;
	
	
	
	public Ovelse(int ovelsesID, String navn) throws Exception{
		setOvelsesID(ovelsesID);
		setNavn(navn);
	}

	public Ovelse()
	{
		
	}
	
	public void databaseSetOvelsesID(int ovelsesID)
	{
		this.ovelsesID = ovelsesID;
	}
	
	public void databaseSetNavn(String navn)
	{
		this.navn = navn;
	}


	public int getOvelsesID() {
		return this.ovelsesID;
	}



	public void setOvelsesID(int ovelsesID) throws Exception{
		if (ovelsesID <= 1000000000) {
			this.ovelsesID=ovelsesID;
		}
		else {
			throw new IllegalArgumentException("the int is too long");
		}
	}



	public String getNavn() {
		return this.navn;
	}



	public void setNavn(String navn) throws Exception{
		if (navn ==null) {
			throw new IllegalArgumentException("Can't be null");
		}
		else if(navn.length()<=50) {
			this.navn = navn;
		}
		else {
			throw new IllegalArgumentException("The name is too long");
		}
	}
	
}
