package table;

public class Apparatovelse {
	private int OvelsesID; // primary key and foreign key to ovelse
	private int AntallKilo;
	private int AntallSett;
	private String Apparat;
	
	//TODO: create a constructor that can create an instance with only getting the variables that has to be not null
	public Apparatovelse(int ovelsesID, int antallKilo, int antallSett, String apparat) throws Exception{
		setOvelsesID(ovelsesID);
		setAntallKilo(antallKilo);
		setAntallSett(antallSett);
		setApparat(apparat);
	}
	
	public int getOvelsesID() {
		return OvelsesID;
	}
	
	public void setOvelsesID(int ovelsesID) throws Exception{
		//TODO: check that ovelsesID doesn't exist in apparatovelse, and check that there exists a ovelse with this ovelsesID as it is foreign key
		if (ovelsesID <= 1000000000) {
			this.OvelsesID=ovelsesID;
		}
		else {
			throw new IllegalArgumentException("the int is too long");
		}
	}
	
	public int getAntallKilo() {
		return AntallKilo;
	}
	
	public void setAntallKilo(int antallKilo) throws Exception{
		if (antallKilo <= 1000000000) {
			this.AntallKilo=antallKilo;
		}
		else {
			throw new IllegalArgumentException("the int is too long");
		}
		
	}
	
	public int getAntallSett() {
		return AntallSett;
	}
	
	public void setAntallSett(int antallSett) throws Exception{
		if (antallSett <= 1000000000) {
			this.AntallSett=antallSett;
		}
		else {
			throw new IllegalArgumentException("the int is too long");
		}
	}
	
	public String getApparat() {
		return Apparat;
	}
	
	public void setApparat(String apparat) throws Exception{
		if (apparat.length()<= 30) {
			this.Apparat = apparat;
		}
		else {
			throw new IllegalArgumentException("the string is too long");
		}
	}

	
}
