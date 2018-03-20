package table;

public class Undergruppe {
	private int GruppeID;
	private int UnderGruppeID;
	
	public int getGruppeID() {
		return GruppeID;
	}
	public void setGruppeID(int gruppeID) {
		if (gruppeID <= 1000000000) { //TODO: Create else if (gruppeID does not exist) then Exception
			GruppeID = gruppeID;
		}else {
			throw new IllegalArgumentException("The number is too high to be an integer in java.");
		}
	}
	public int getUnderGruppeID() {
		return UnderGruppeID;
	}
	public void setUnderGruppeID(int underGruppeID) {
		if (underGruppeID <= 1000000000) {
			UnderGruppeID = underGruppeID;
		} else { //TODO: Create else if (underGruppeID does not exist) then Exception, also should not be the same as gruppeID
			throw new IllegalArgumentException("The number is too high to be an integer in java.");
		}
	}
	
	
}
