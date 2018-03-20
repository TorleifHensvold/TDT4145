package table;

public class Apparat {
	private String Navn;
	private String Beskrivelse;
	
	public Apparat(String navn, String beskrivelse) throws Exception{
		setNavn(navn);
		setBeskrivelse(beskrivelse);
	}
	
	public Apparat() {
		
	}
	
	public void databaseSetsName(String Navn) {
		this.Navn = Navn;
	}
	
	public void databaseSetsBeskrivelse(String Beskrivelse) {
		this.Beskrivelse = Beskrivelse;
	}

	//TODO create a method or a way of validating that the apparat doesn't already exist
	public void setNavn(String navn) throws Exception{
		if (navn.length() <= 30) {
			this.Navn = navn;
		}
		else {
			throw new IllegalArgumentException("the name is too long");
		}
	}

	public void setBeskrivelse(String beskrivelse) {
		if (beskrivelse.length() <= 300) {
			this.Beskrivelse = beskrivelse;
		}
		else {
			throw new IllegalArgumentException("the description is too long");
		}
	}
	public String getNavn() {
		return this.Navn;
	}
	public String getBeskrivelse() {
		return this.Beskrivelse;
	}
}
