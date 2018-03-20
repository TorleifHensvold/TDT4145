package table;

public class Utenapparat {
	private int OvelsesID; //primary key and foreign key to ovelse
	private String Beskrivelse;
	
	public Utenapparat(int OvelsesID, String Beskrivelse) throws Exception{
		setID(OvelsesID);
		setBeskrivelse(Beskrivelse);
	}
	
	public void setID(int OvelsesID) throws Exception{
		if (OvelsesID <= 100000000) {
			this.OvelsesID = OvelsesID;
		} else {//TODO: Create else if (OvelsesID does not exist) then Exception 
			throw new IllegalArgumentException("the int is too long");
		}
	}
	
	public void setBeskrivelse(String Beskrivelse) {
		if (Beskrivelse.length() <= 300) {
			this.Beskrivelse = Beskrivelse;
		} else {
			throw new IllegalArgumentException("this string is too long");
		}
	}
	
	public int getOvelsesID() {
		return OvelsesID;
	}
	
	public String getBeskrivelse() {
		return Beskrivelse;
	}
}
