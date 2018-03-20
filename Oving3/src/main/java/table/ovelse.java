package table;

public class ovelse {
	private int OvelsesID;
	private String Navn;
	
	
	
	public ovelse(int ovelsesID, String navn) throws Exception{
		setOvelsesID(ovelsesID);
		setNavn(navn);
	}



	public int getOvelsesID() {
		return OvelsesID;
	}



	public void setOvelsesID(int ovelsesID) throws Exception{
		if (ovelsesID <= 1000000000) {
			this.OvelsesID=ovelsesID;
		}
		else {
			throw new IllegalArgumentException("the int is too long");
		}
	}



	public String getNavn() {
		return Navn;
	}



	public void setNavn(String navn) throws Exception{
		if (navn ==null) {
			throw new IllegalArgumentException("Can't be null");
		}
		else if(navn.length()<=50) {
			this.Navn = navn;
		}
		else {
			throw new IllegalArgumentException("The name is too long");
		}
	}
	
}
