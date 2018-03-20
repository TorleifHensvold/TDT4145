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
		if (checkInt(oktID))
		{
			this.oktID = oktID;
		}
	}
	
	public void setDato(String dato) 
	{
		if (checkString(dato, 30, false))
		{
			this.dato = dato;
		}
	}
	
	public void setTidspunkt(String tidspunkt) 
	{
		this.tidspunkt = tidspunkt;
	}
	
	public void setVarighet(int varighet) 
	{
		if (checkInt(oktID))
		{
			this.varighet = varighet;
		}
	}
	
	public void setForm(int form) 
	{
		if (checkInt(oktID))
		{
			this.form = form;
		}
	}
	
	public void setPrestasjon(int prestasjon) 
	{
		if (checkInt(oktID))
		{
			this.prestasjon = prestasjon;
		}
	}
	
	public void setNotat(String notat) 
	{
		this.notat = notat;
	}
	
	private boolean checkInt(int tall)
	{
		if (tall > 1000000000)
		{
			throw new IllegalArgumentException("The number was too long to be an integer in Java.");
		}
		else 
		{
			return true;
		}
	}
	
	private boolean checkString(String tekst, int lengde, boolean nullAllowed)
	{
		if (!nullAllowed)	// If we don't allow NULL, we check the length.
		{
			if (tekst.length() > lengde)	// If the length is longer than allowed, throw illegalargument.
			{
				throw new IllegalArgumentException("The length of the text was too long, it must be less than " + lengde + ".");
			}
			else
			{
				return true;
			}
		}
		else		// null is implicitly allowed.
		{
			if (tekst == null)
			{
				return true;
			}
			else if (tekst.length() > lengde)
			{
				throw new IllegalArgumentException("The length of the text was too long, it must be less than " + lengde + ".");
			}
			else
			{
				return true;
			}
		}
	}
	
}
