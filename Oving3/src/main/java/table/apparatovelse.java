package table;

public class apparatovelse {
	private int OvelsesID; // primary key and foreign key to ovelse
	private int AntallKilo;
	private int AntallSett;
	private String Apparat;
	
	//TODO: create a constructor that can create an instance with only getting the variables that has to be not null
	public apparatovelse(int ovelsesID, int antallKilo, int antallSett, String apparat) throws Exception{
		setOvelsesID(ovelsesID);
		setAntallKilo(antallKilo);
		setAntallSett(antallSett);
		setApparat(apparat);
	}
	
	public int getOvelsesID() {
		return OvelsesID;
	}
	
	public void setOvelsesID(int ovelsesID) {
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
	
	public void setAntallKilo(int antallKilo) {
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
	
	public void setAntallSett(int antallSett) {
		AntallSett = antallSett;
	}
	
	public String getApparat() {
		return Apparat;
	}
	
	public void setApparat(String apparat) {
		Apparat = apparat;
	}

	
}
