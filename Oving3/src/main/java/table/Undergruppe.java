package table;

public class Undergruppe {
	private int gruppeID;
	private int underGruppeID;
	
	public Undergruppe(int GruppeID, int undergruppeID) {
		setGruppeID(GruppeID);
		setUnderGruppeID(undergruppeID);
	}
	
	public Undergruppe() {
		
	}
	
	public int getGruppeID() {
		return gruppeID;
	}
	public void setGruppeID(int gruppeID) {
		if (gruppeID <= 1000000000) { //TODO: Create else if (gruppeID does not exist) then Exception
			this.gruppeID = gruppeID;
		}else {
			throw new IllegalArgumentException("The number is too high to be an integer in java.");
		}
	}
	public int getUnderGruppeID() {
		return underGruppeID;
	}
	public void setUnderGruppeID(int underGruppeID) {
		if (underGruppeID <= 1000000000) {
			this.underGruppeID = underGruppeID;
		} else { //TODO: Create else if (underGruppeID does not exist) then Exception, also should not be the same as gruppeID
			throw new IllegalArgumentException("The number is too high to be an integer in java.");
		}
	}
	
	
}
