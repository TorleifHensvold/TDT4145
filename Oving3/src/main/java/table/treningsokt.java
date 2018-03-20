package table;

public class treningsokt 
{
	private int oktID;
	private String dato;
	private String tidspunkt;
	private int varighet;
	private int form;
	private int prestasjon;
	private String notat;
	
	public treningsokt(int oktID, String dato, String tidspunkt, int varighet, int form, int prestasjon, String notat)
	{
		setOktID(oktID);
		setDato(dato);
		setTidspunkt(tidspunkt);
		setVarighet(varighet);
		setForm(form);
		setPrestasjon(prestasjon);
		setNotat(notat);
	}
	
	// ---------------------- Getters ------------------------------- //
	
	public int getOktID() 
	{
		return this.oktID;
	}
	
	public String getDato() 
	{
		return this.dato;
	}
	
	public String getTidspunkt() 
	{
		return this.tidspunkt;
	}
	
	public int getVarighet() 
	{
		return this.varighet;
	}
	
	public int getForm() 
	{
		return this.form;
	}
	
	public int getPrestasjon() 
	{
		return this.prestasjon;
	}
	
	public String getNotat() 
	{
		return this.notat;
	}
	
	// --------------------------- Setters ------------------ //
	
	private void setOktID(int oktID) 
	{
		this.oktID = oktID;
	}
	
	public void setDato(String dato) 
	{
		this.dato = dato;
	}
	
	public void setTidspunkt(String tidspunkt) 
	{
		this.tidspunkt = tidspunkt;
	}
	
	public void setVarighet(int varighet) 
	{
		this.varighet = varighet;
	}
	
	public void setForm(int form) 
	{
		this.form = form;
	}
	
	public void setPrestasjon(int prestasjon) 
	{
		this.prestasjon = prestasjon;
	}
	
	public void setNotat(String notat) 
	{
		this.notat = notat;
	}
	
	
}
