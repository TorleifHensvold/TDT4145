package table;

public class treningsokt 
{
	private int OktID;
	private String Dato;
	private String Tidspunkt;
	private int Varighet;
	private int Form;
	private int Prestasjon;
	private String Notat;
	
	// ---------------------- Getters ------------------------------- //
	
	public int getOktID() 
	{
		return this.OktID;
	}
	
	public String getDato() 
	{
		return this.Dato;
	}
	
	public String getTidspunkt() 
	{
		return this.Tidspunkt;
	}
	
	public int getVarighet() 
	{
		return this.Varighet;
	}
	
	public int getForm() 
	{
		return this.Form;
	}
	
	public int getPrestasjon() 
	{
		return this.Prestasjon;
	}
	
	public String getNotat() 
	{
		return this.Notat;
	}
	
	// --------------------------- Setters ------------------ //
	
	public void setOktID(int oktID) 
	{
		OktID = oktID;
	}
	public void setDato(String dato) 
	{
		Dato = dato;
	}
	public void setTidspunkt(String tidspunkt) 
	{
		Tidspunkt = tidspunkt;
	}
	public void setVarighet(int varighet) 
	{
		Varighet = varighet;
	}
	public void setForm(int form) 
	{
		Form = form;
	}
	public void setPrestasjon(int prestasjon) 
	{
		Prestasjon = prestasjon;
	}
	public void setNotat(String notat) 
	{
		Notat = notat;
	}
	
	
}
